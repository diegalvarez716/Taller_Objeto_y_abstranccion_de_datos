package main;
import java.util.Stack;

public class Notacion {

    public static String conversionPostfijo(String expresion){
        String epostfifija="";
        Stack<Character> stack=new Stack<>();

        for (int i=0; i<expresion.length();i++){
            char car=expresion.charAt(i);

            if(jerarquia(car)>0){
                while (stack.isEmpty()==false && jerarquia(stack.peek()) >= jerarquia(car)){
                    epostfifija += stack.pop();
                }
                stack.push(car);
            } else if (car==')') {
                char aux=stack.pop();
                while (aux!='('){
                    epostfifija+=aux;
                    aux=stack.pop();
                }
            }else if(car=='('){
                stack.push(car);
            }else{
                epostfifija += car;
            }
        }
        for(int i=0; i<stack.size(); i++){
            epostfifija += stack.pop();
        }
        return epostfifija;
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
