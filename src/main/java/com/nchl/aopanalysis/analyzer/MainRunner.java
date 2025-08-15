package com.nchl.aopanalysis.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class MainRunner {
    public static void main(String[] args) throws Exception {
        // 1. Static Analysis
        var staticResult = StaticAnalyzer.analyze(Path.of("src/main/java/HelloWorld.java"));

        // 2. Dynamic Analysis (AOP will intercept greet)
        var dynamicResult = DynamicAnalyzer.runHelloWorld();

        // 3. Combine results into JSON
        Map<String, Object> output = new HashMap<>();
        output.put("staticAnalysis", Map.of(
                "classNames", staticResult.classNames(),
                "ast", staticResult.ast()
        ));
        output.put("dynamicAnalysis", Map.of(
                "mainOutput", dynamicResult.mainOutput(),
                "greetOutput", dynamicResult.greetOutput()
        ));
        output.put("timestamp", Instant.now().toString());

        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output);
        System.out.println(json);
    }
}
