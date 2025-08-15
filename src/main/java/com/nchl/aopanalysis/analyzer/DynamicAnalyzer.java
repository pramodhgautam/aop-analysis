package com.nchl.aopanalysis.analyzer;

public class DynamicAnalyzer {

    public static void runHelloWorld() {
        System.out.println("[Dynamic] Running main method...");
        HelloWorld.main(new String[]{});

        System.out.println("[Dynamic] Running greet(\"Dynamic Test\")...");
        String greetOutput = HelloWorld.greet("Dynamic Test");
        System.out.println(greetOutput);
    }
}
