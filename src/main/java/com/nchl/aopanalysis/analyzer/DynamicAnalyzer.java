package com.nchl.aopanalysis.analyzer;

public class DynamicAnalyzer {

    public static DynamicAnalysisResult runHelloWorld() {
        System.out.println("[Dynamic] Running main method...");
        HelloWorld.main(new String[]{});

        System.out.println("[Dynamic] Running greet(\"Dynamic Test\")...");
        String greetOutput = HelloWorld.greet("Dynamic Test");

        return new DynamicAnalysisResult("Hello, World!\n", greetOutput);
    }

    public record DynamicAnalysisResult(String mainOutput, String greetOutput) {}
}
