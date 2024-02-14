package main;
import java.util.Stack;

public class Resultado {

    public static int resolucion(String expresion){
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<expresion.length(); i++){
            char car = expresion.charAt(i);
            if(Notacion.jerarquia(car)>0){
                int op1=stack.pop();
                int op2=stack.pop();
                int aux=operacion(op1, op2, car);
                stack.push(aux);
            }else {
                stack.push((int)(car-'0'));
            }
        }
        int resultado=stack.pop();
        return resultado;
    }
    public static int operacion(int op1, int op2, char operador){
        switch (operador){
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                return op2 / op1;
        }
        return 0;
    }

}
