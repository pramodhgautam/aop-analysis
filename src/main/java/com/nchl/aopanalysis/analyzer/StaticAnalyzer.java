package com.nchl.aopanalysis.analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.IOException;
import java.nio.file.Path;

public class StaticAnalyzer {

    public static void analyze(Path javaFilePath) throws IOException {
        CompilationUnit cu = StaticJavaParser.parse(javaFilePath);

        cu.getTypes().forEach(type -> {
            System.out.println("[Static] Class: " + type.getName());
            type.getMethods().forEach(method ->
                System.out.println("[Static] Method: " + method.getNameAsString())
            );
        });
    }
}
