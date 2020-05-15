package com.wade.adam.antlr;

import grammars.HelloLexer;
import grammars.HelloParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Driver {

    public static void main(String[] args) {
        String hello = "hello world";
        String id = process(hello);
        System.out.println("Said hello to " + id);
    }

    private static String process(String source){
        CodePointCharStream input = CharStreams.fromString(source);
        return compile(input);
    }

    private static String compile(CharStream source){
        HelloLexer lexer = new HelloLexer(source);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokenStream);
        ParseTree tree = parser.r();
        HelloVisitorImpl visitor = new HelloVisitorImpl();
        return visitor.visit(tree);
    }

}
