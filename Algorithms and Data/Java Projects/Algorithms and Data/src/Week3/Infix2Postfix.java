package Week3;

import java.util.Scanner;

public class Infix2Postfix {

    private static int precedence(char operator) {
        switch (operator) {
            case '^' : return 3;
            case '*': case '/' : return 2;
            case '+' : case '-' : return 1;
        }
        return 0;
    }

    public static String infix2postfix(String infix)
    {
        String result = new String("");

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < infix.length(); i++)
        {
            char nextChar = infix.charAt(i);

            if (Character.isDigit(nextChar))
                result = result + nextChar;

            else if (nextChar == '(')
                stack.push(nextChar);

            else if (nextChar == ')')
            {
                while (stack.peek() != '(')
                    result = result + stack.pop();

                stack.pop();
            }
            else
            {

                while (!stack.isEmpty() && precedence(nextChar) <= precedence(stack.peek())){
                    result = result + stack.pop();
                }
                stack.push(nextChar);
            }
        }


        while (!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }

    static int evaluatePostfix(String postfix)
    {

        Stack<Integer> stack = new Stack<Integer>();


        for(int i = 0; i <postfix.length(); i++)
        {
            char nextChar = postfix.charAt(i);

            if(Character.isDigit(nextChar))
                stack.push(nextChar - '0');
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(nextChar)
                {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;

                    case '^':
                        stack.push((int)Math.pow(val2, val1));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an infix expression (no spaces) > ");
        String infix = input.nextLine();
        System.out.println("Postfix is :" + infix2postfix(infix));
        System.out.println("Result is " + evaluatePostfix(infix2postfix(infix)));
    }
}

