package com.nchl.aopanalysis.analyzer;

public class MainRunner {
    public static void main(String[] args) {
        // Static analysis simulation
        System.out.println("[Static] Class: HelloWorld");
        System.out.println("[Static] Method: main");
        System.out.println("[Static] Method: greet");

        // Dynamic analysis execution
        DynamicAnalyzer.runHelloWorld();
    }
}
