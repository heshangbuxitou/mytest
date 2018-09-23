package com.zy.designs.interpreter;

public class Main {
    public static void main(String[] args) {
        /**
         * 解释器用于对一段语法的解析和转义，它充当了翻译官的角色，如果一种特定类型的问题
         * 发生频率较高，可以考虑使用简单的语法来描述，然后用解释器来解释这个语法。解释器模式可以嗯
         * 方便的改变和扩展语法，因为其各节点语法都是相似的。下面用音乐的例子来演示。
         */
        PlayContext context = new PlayContext();
        context.setText("T 500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 " +
                "C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");
        while (!context.isFinished()){
            Expression expression = ExpressionFactory.createExpression(context);
            expression.interpret(context);

        }
    }
}
