package practisequestions.leetcode.stack;

/*
Design a stack class that supports the push, pop, top, and getMin operations.

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]

Output: [null,null,null,null,0,null,2,1]

Explanation:
MinStack minStack = new MinStack();
minStack.push(1);
minStack.push(2);
minStack.push(0);
minStack.getMin(); // return 0
minStack.pop();
minStack.top();    // return 2
minStack.getMin(); // return 1
* */

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;


    public MinStack() {
       this.stack = new Stack<>();
       this.minstack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
        int minValue = Math.min(this.minstack.isEmpty() ? Integer.MAX_VALUE : this.minstack.peek(), val);
        this.minstack.push(minValue);
    }

    public void pop() {
        this.stack.pop();
        this.minstack.pop();
    }

    public int top() {
       return this.stack.peek();
    }

    public int getMin() {
        return this.minstack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println("minStack" + minStack.toString());
        System.out.println(minStack.getMin());

    }
}
