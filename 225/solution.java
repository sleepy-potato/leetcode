class MyStack {
    
    private Deque<Integer> mainQ;
    private Deque<Integer> otherQ;

    /** Initialize your data structure here. */
    public MyStack() {
        mainQ = new ArrayDeque<>();
        otherQ = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        mainQ.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (mainQ.size() > 1) {
            otherQ.addLast(mainQ.removeFirst());
        }
        int result = mainQ.removeFirst();

        // swap main and other
        Deque<Integer> tmpQ = mainQ;
        mainQ = otherQ;
        otherQ = tmpQ;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        int result = pop();
        mainQ.addLast(result);
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mainQ.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
