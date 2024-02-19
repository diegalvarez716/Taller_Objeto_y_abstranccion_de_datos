package main;
import java.util.Stack;

public class Resultado {
    public static int resolucion(String expresion) {
        Stack<Double> stack = new Stack<>();
        StringBuilder numBuilder = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char car = expresion.charAt(i);

            if (Character.isDigit(car) || car == '.') {
                numBuilder.append(car);
            } else {
                if (numBuilder.length() > 0) {
                    stack.push(Double.parseDouble(numBuilder.toString()));
                    numBuilder.setLength(0);
                }

                if (Notacion.jerarquia(car) > 0) {
                    double op1 = stack.pop();
                    double op2 = stack.pop();
                    double aux = operacion(op1, op2, car);
                    stack.push(aux);
                }
            }
        }

        if (numBuilder.length() > 0) {
            stack.push(Double.parseDouble(numBuilder.toString()));
        }

        return (int) Math.round(stack.pop());
    }

    public static double operacion(double op1, double op2, char operador) {
        switch (operador) {
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                return Math.floor(op2 / op1);
        }
        return 0;
    }


}