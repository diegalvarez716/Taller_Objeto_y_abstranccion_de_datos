package main;
import java.util.Stack;

public class Notacion {

    public static String conversionPostfijo(String expresion) {
        String epostfifija = "";
        Stack<Character> stack = new Stack<>();
        StringBuilder numBuilder = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char car = expresion.charAt(i);

            if (Character.isDigit(car) || car == '.') {
                numBuilder.append(car);
            } else {
                if (numBuilder.length() > 0) {
                    epostfifija += numBuilder.toString() + " ";
                    numBuilder.setLength(0);
                }

                if (jerarquia(car) > 0) {
                    while (!stack.isEmpty() && jerarquia(stack.peek()) >= jerarquia(car)) {
                        epostfifija += stack.pop() + " ";
                    }
                    stack.push(car);
                } else if (car == ')') {
                    char aux = stack.pop();
                    while (aux != '(') {
                        epostfifija += aux + " ";
                        aux = stack.pop();
                    }
                } else if (car == '(') {
                    stack.push(car);
                }
            }
        }

        if (numBuilder.length() > 0) {
            epostfifija += numBuilder.toString() + " ";
        }

        while (!stack.isEmpty()) {
            epostfifija += stack.pop() + " ";
        }

        return epostfifija.trim();
    }

    public static int jerarquia(char car){
        switch (car){
            case '+':
            case '-':
                return 1;
            case '*':
            case'/':
                return 2;
        }
        return -1;
    }
}