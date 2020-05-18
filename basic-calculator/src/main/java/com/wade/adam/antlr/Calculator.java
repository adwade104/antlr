package com.wade.adam.antlr;

import grammars.LabeledExprLexer;
import grammars.LabeledExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {

    public void calculate(String source) {
        CodePointCharStream input = CharStreams.fromString(source);
        compile(input);
    }

    private void compile(CharStream source) {
        LabeledExprLexer lexer = new LabeledExprLexer(source);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokenStream);
        ParseTree tree = parser.prog();
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }

}
