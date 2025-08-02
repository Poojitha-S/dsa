package dsa.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        String str = "[(]{}";
        System.out.println("Is Parentheses Valid(Brute)? : " + validParentheses.isValidBrute(str));
        System.out.println("Is Parentheses Valid(Stack)? : " + validParentheses.isValidStack(str));
    }
    public boolean isValidBrute(String s) {
        int previousLength = -1;
        while (s.length() != previousLength){
            previousLength = s.length();
            s = s.replace("()","").replace("[]","").replace("{}","");
        }
        return s.isEmpty();
    }
    public boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character cha : s.toCharArray()){
            if(cha.equals('('))
                stack.push(')');
            else if(cha.equals('['))
                stack.push(']');
            else if (cha.equals('{'))
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != cha)
                return false;
        }
        return stack.isEmpty();
    }
}
