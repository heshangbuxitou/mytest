package com.zy.algorithm;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> statck1;
    Stack<Integer> statck2;

    public MyQueue() {
        // do intialization if necessary
        statck1 = new Stack<Integer>();
        statck2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        statck1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (statck2.empty()) {
            while (!statck1.empty()) {
                statck2.push(statck1.pop());
            }
        }
        return statck2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (statck2.empty()) {
            while (!statck1.empty()) {
                statck2.push(statck1.pop());
            }
        }
        return statck2.peek();
    }
}
