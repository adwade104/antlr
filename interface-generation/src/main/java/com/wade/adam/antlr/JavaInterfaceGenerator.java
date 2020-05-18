package com.wade.adam.antlr;

import grammars.JavaLexer;
import grammars.JavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class JavaInterfaceGenerator {

    public void generateInterface(String source) {
        CodePointCharStream input = CharStreams.fromString(source);
        compile(input);
    }

    private void compile(CharStream source) {
        JavaLexer lexer = new JavaLexer(source);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokenStream);
        ParseTree tree = parser.compilationUnit();
        JavaClassVisitor visitor = new JavaClassVisitor(parser);
        visitor.visit(tree);
    }

}
