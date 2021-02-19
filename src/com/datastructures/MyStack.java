package com.datastructures;

public class MyStack {
    private int[] elements;
    private int lastLocationWritten = -1;

    public MyStack(int numberOfElements){
        elements = new int[numberOfElements];
    }


    public void push(int elementToPush) {
        if (isFull()) throw new StackOverflowException("stack is full");
        elements[++lastLocationWritten] = elementToPush;
    }

    public int peek() {
        if (isEmpty()) throw new StackUnderflowException("Stack is empty");
        return elements[lastLocationWritten];
    }

    public  int removeLastElement(){
        if (isEmpty()) throw new StackUnderflowException("Stack is empty");
        int lastElement = elements[lastLocationWritten];
        elements[lastLocationWritten--] = 0;
        return lastElement;
    }

    public boolean isEmpty() {
        return (lastLocationWritten == -1);
    }

    public boolean isFull() {
        return (lastLocationWritten == (elements.length-1));
    }

    public static class StackOverflowException extends RuntimeException{
        public StackOverflowException(String message){
            super(message);
        }

    }
    public static class StackUnderflowException extends RuntimeException{
        public StackUnderflowException(String message){
            super(message);
        }

    }
}


