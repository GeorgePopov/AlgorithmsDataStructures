package lesson3_stackQueue.trainingManual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IStack {
    private int maxSize;
    private char[] stackArr;
    private int top; // позиция последнего эл-та (-1 означает, что stack пуст)

    public IStack(int size) {
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;
    }

    public void push(char i) {
        this.stackArr[++this.top] = i;
    }

    public char pop() {
        return this.stackArr[this.top--];
    }

    public char peek() {
        return this.stackArr[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }
}

class Bracket {
    private String input;

    public Bracket(String in){
        input = in;
    }

    public void check() {
        int size = input.length();
        IStack st = new IStack(size);

        for (int i=0; i < input.length(); i++){
            char ch = input.charAt(i);
            switch(ch){
                case '[':
                case '{':
                case '(':
                    st.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!st.isEmpty()) {
                        char chr = st.pop();
                        if ((ch == '}' && chr != '{') || (ch == ']' && chr != '[') || (ch == ')' && chr != '(')){
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!st.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}

class JavaStack {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            input = getString();
            if (input.equals("")) break;

            Bracket br = new Bracket(input);
            br.check();
        }

    }


    public static String getString() throws IOException { // ! Пример метода который принимает строку, введенную с клавиатуры.

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        return br.readLine();
    }
}