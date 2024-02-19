# Participantes:   Diego ALvarez (C.I 30983861) Javier Mujica (C.I )

# Proyecto: 
 Este proyecto consiste en una evaluadora de expresiones aritmeticas basicas la cual recibe un archivo de entrada como parametro con todas las expresiones aritmeticas a evaluar y da como resultado dos archivos de salida, uno con los resultados correspondientes y el otro con las operaciones en forma de arbol llevadas a cabo para obtener cada resultado.

        *INFORMACION IMPORTANTE* : los caracteres aceptados son "0,1,2,3,4,5,6,7,8,9,*,+,-,/" o de lo contrario sera tomado como error 

# como funciona internamente 
* Main:

- Esta clase contiene el método principal main, que es el punto de entrada de la aplicación.
- Lee expresiones matemáticas desde un archivo de entrada.
- Verifica la validez de cada expresión y realiza operaciones aritméticas si la expresión es válida.
- Construye y muestra un árbol de expresiones para cada expresión válida.
- Escribe los resultados de las operaciones en un archivo de salida.

* Resultado:

- Contiene métodos para resolver expresiones matemáticas en notación postfija.
- Utiliza una pila para evaluar las expresiones y devolver el resultado.

* Nodo:

- Define la estructura de un nodo en un árbol binario.
- Cada nodo tiene un valor y referencias a sus nodos hijos izquierdo y derecho.

* Arbol:

- Implementa la lógica para construir y mostrar un árbol binario a partir de una expresión en notación postfija.
- Contiene métodos para verificar si un operador es válido y para construir el árbol binario correspondiente a una expresión.
- Proporciona métodos para imprimir el árbol en forma horizontal y vertical.

* Notacion:

- Ofrece métodos para convertir una expresión matemática de notación infija a postfija.
- Define la jerarquía de los operadores para la conversión de notación.
- Utiliza una pila para realizar la conversión y obtener la expresión en notación postfija.
- Estas descripciones deberían proporcionar una comprensión general de la funcionalidad y el propósito de cada clase en tu aplicación.

# Como Ejecturalo: 
    -En una terminal ejecutar el siguiente comando "git clone https://github.com/diegalvarez716/Taller_Objeto_y_abstranccion_de_datos/proyecto2.git"

    -Una vez descargar da carpeta del proyecto llamada "proyecto2", debe entrar a dicha carpeta e ingresar a la sub-carpeta llmada "entrada_y_salida"
    
    -Modificar el acrhivo llamado "test1.input", ahi se deben agregar todas las operaciones que se desean evaluar linea por linea

    -Luego desde la consolas de comando debe ingresar a la carpeta "proyecto2" y ejecutar el comando "javac Main.java"

    -Se creara un archivo .class udebe ejecutar el comando "java Main" para la ejecucion del programa, una vez ejecutado se crearan las respuestas en los archivos de salidad correspondientes en la sub-carpeta "entrada_y_salida"

# Casos de prueba
    Al momento de clonar la carpeta del proyecto, ya se cuenta con ciertos casos de prueba en el archivo de entrada que se llevaron a cabo en el proceso de elaboracion, con el fin de asegurar el correcto funcionamiento del progrmana.
    Dichos casos de prueba son los siguientes:

    1+1: Se pone a prueba la suma
    0-1: Se pone a prueba la resta
    0*5: se pone a prueba la multiplicacion
    3/2: se pone a pueba la division 
    0.5*2: se pone a prueba los caracteres aceptados por el programa
    4*-5: se pone a prueba la correcta sintaxis de las operaciones
    +1*8: se pone a prueba la correcta sintaxis de las operaciones
    1/0: se pone a prueba la division por cero 
    12+188: se realiza operacion con operandos de mas de un digito 
    5*10: se se realiza operacion con operandos de mas de un digito 
    1+2*3/4+2-1: se pone a prueba el comportamiento del programa con una operacion de vaarios operadores con diferentes jerarquias 
    
    los resultados fueron los siguientes: 

    2
    ----------
    -1
    ----------
    0
    ----------
    1
    ----------
    ERROR
    ----------
    ERROR
    ----------
    ERROR
    ----------
    ERROR
    ----------
    200
    ----------
    50
    ----------
    3
    ----------


