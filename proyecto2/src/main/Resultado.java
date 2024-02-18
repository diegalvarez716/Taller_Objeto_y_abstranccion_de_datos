package main;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Resultado {
    public static List<Arbol> lista = new ArrayList<>();
    public static int resolucion(String expresion) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder numBuilder = new StringBuilder();
        int cont=0;
        int cantDenumeros= cantNumeros(expresion);

        for (int i = 0; i < expresion.length(); i++) {
            char car = expresion.charAt(i);
            if (Character.isDigit(car)) {
                numBuilder.append(car);
            } else {
                if (numBuilder.length() > 0) {
                    stack.push(Integer.parseInt(numBuilder.toString()));
                    numBuilder.setLength(0);
                }
                if (Notacion.jerarquia(car) > 0){
                    int op1 = stack.pop();
                    int  op2 = stack.pop();
                    int aux = operacion(op1, op2, car);
                    cont++;
                    if(cont == (cantDenumeros-1)){
                        Arbol aux2 = new Arbol();
                        aux2.add(Character.toString(car));
                        aux2.add(Integer.toString(op1));
                        aux2.add(Integer.toString(op2));
                        lista.add(aux2);
                    }
                    stack.push(aux);
                }
            }
        }
        if (numBuilder.length() > 0) {
            stack.push(Integer.parseInt(numBuilder.toString()));
        }
        return stack.pop();
    }

    public static int operacion(int op1, int op2, char operador) {
        switch (operador) {
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

    public static int cantNumeros(String expresion){
        int cantidad=0;
        //20,2,*
        //012345
        for (int i=0;i<expresion.length(); i++){
            if(Character.isDigit(expresion.charAt(i))){
                while (Character.isDigit(expresion.charAt(i))){
                    i++;
                }
                cantidad++;
            }
        }
        return  cantidad;
    }

}