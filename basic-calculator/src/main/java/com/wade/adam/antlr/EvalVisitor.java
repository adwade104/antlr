package com.wade.adam.antlr;

import grammars.LabeledExprBaseVisitor;
import grammars.LabeledExprParser;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    Map<String, Integer> memory = new HashMap<>();
    
    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx){
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx){
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;
    }

    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx){
        return Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx){
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0);
    }

    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx){
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return ctx.op.getType() == LabeledExprParser.MUL ? left * right : left / right;
    }

    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx){
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return ctx.op.getType() == LabeledExprParser.ADD ? left + right : left - right;
    }

    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx){
        return visit(ctx.expr());
    }

}
