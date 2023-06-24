package com.learn.pattern.interpreter;

public class App {
    InterpreterContext context;

    public App(InterpreterContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        App app = new App(new InterpreterContext());

        String s = "255 in hex";
        System.out.println(app.interpret(s));
    }

    String interpret(String s) {
        Expression expression = null;
        if (s.contains("binary")) {
            expression = new IntToBinaryExpression(Integer.parseInt(s.substring(0, s.indexOf(" "))));
        } else if (s.contains("hex")) {
            expression = new IntToHexExpression(Integer.parseInt(s.substring(0, s.indexOf(" "))));
        } else {
            return s;
        }

        return expression.interpreter(context);
    }
}
