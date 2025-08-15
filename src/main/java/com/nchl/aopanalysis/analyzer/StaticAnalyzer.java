package com.nchl.aopanalysis.analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.IOException;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.IOException;

public class StaticAnalyzer {

    public static void analyzeAndPrint(String javaFilePath) throws IOException {
        File file = new File(javaFilePath); // <-- convert string path to File
        CompilationUnit cu = StaticJavaParser.parse(file);

        cu.findAll(com.github.javaparser.ast.body.ClassOrInterfaceDeclaration.class)
                .forEach(clazz -> {
                    System.out.println("[Static] Class: " + clazz.getNameAsString());
                    clazz.getMethods().forEach(method ->
                            System.out.println("[Static] Method: " + method.getNameAsString()));
                });
    }
}
