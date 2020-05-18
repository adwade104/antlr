package com.wade.adam.antlr;

import grammars.JavaBaseVisitor;
import grammars.JavaParser;
import org.antlr.v4.runtime.TokenStream;

public class JavaClassVisitor extends JavaBaseVisitor<Object> {

    private JavaParser javaParser;

    public JavaClassVisitor(JavaParser javaParser) {
        this.javaParser = javaParser;
    }

    @Override
    public Object visitClassDeclaration(JavaParser.ClassDeclarationContext ctx){
        System.out.println("interface I" + ctx.Identifier() + "{ ");
        visit(ctx.classBody());
        System.out.println("}");
        return null;
    }

    @Override
    public Object visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx){
        TokenStream tokens = javaParser.getTokenStream();
        String type = "void";
        if(ctx.type() != null){
            type = tokens.getText(ctx.type());
        }

        String args = tokens.getText(ctx.formalParameters());
        System.out.println("\t" + type + " " + ctx.Identifier()+args+ ";");
        return null;
    }

}
