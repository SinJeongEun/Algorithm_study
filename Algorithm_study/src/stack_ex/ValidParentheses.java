package stack_ex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {

    public static void main(String[] args) {
        boolean valid = new ValidParentheses().isValid("([])");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Set<Character> openSet = new HashSet<>(List.of('(', '{', '['));
        Set<Character> closeSet = new HashSet<>(List.of(')', '}', ']'));

        Stack<Character> openStack = new Stack<>();
        Stack<Character> closeStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(openSet.contains(c)) {
                openStack.push(c);
            } else {
                if(openStack.isEmpty()) return false;

                // 괄호 짝 맟주기
                char openParentheses = openStack.pop();

                switch (openParentheses) {
                    case '(':
                        if (c != ')') return false;
                        break;
                    case '[':
                        if (c != ']') return false;
                        break;
                    case '{':
                        if (c != '}') return false;
                        break;
                }
            }
        }

        return openStack.isEmpty() ? true : false;
    }
}
