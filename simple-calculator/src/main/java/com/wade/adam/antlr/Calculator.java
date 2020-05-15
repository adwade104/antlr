package com.wade.adam.antlr;

import grammars.CalculatorLexer;
import grammars.CalculatorParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {

    public Double calculate(String source) {
        CodePointCharStream input = CharStreams.fromString(source);
        return compile(input);
    }

    private Double compile(CharStream source) {
        CalculatorLexer lexer = new CalculatorLexer(source);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokenStream);
        ParseTree tree = parser.operation();
        CalculatorVisitorImpl visitor = new CalculatorVisitorImpl();
        return visitor.visit(tree);
    }

}
