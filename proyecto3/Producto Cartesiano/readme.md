# README para el código `Cartesiano.java`

## Descripción
El programa `Cartesiano.java` es una aplicación de consola escrita en Java que lee un archivo de entrada, procesa los datos y escribe los resultados en un archivo de salida.

## Funcionalidad
El programa realiza las siguientes operaciones:

1. Lee líneas de un archivo de entrada (`entrada_y_salida\\test.input`).
2. Para cada línea leída, verifica si la sintaxis es correcta utilizando la función `Errores()`.
3. Si la sintaxis es correcta, divide la línea en dos partes, genera el producto cartesiano de los dos conjuntos y escribe el resultado en el archivo de salida (`entrada_y_salida\\test.output`).
4. Si la sintaxis no es correcta, escribe el mensaje de error en el archivo de salida.
5. Repite los pasos 2-4 hasta que no queden más líneas en el archivo de entrada.

### Producto Cartesiano
Para que el programa funcione correctamente, las líneas de entrada deben seguir una estructura específica que represente dos conjuntos para el producto cartesiano. Por ejemplo, `[:a, :b, :c] [4, 5]` o `[:a:, :b:, :c:] [aaa, hola, chao]`.

### Parte Principal del Código
La parte principal del código que permite la funcionalidad descrita anteriormente es la siguiente:

```java
String[] parts = lectura.split("\\] \\[");

String[] array1 = parts[0].substring(1).split(", ");
String[] array2 = parts[1].substring(0, parts[1].length()-1).split(", ");
```

En este fragmento de código, la línea de entrada se divide en dos partes en el primer paso. Cada parte representa un conjunto. Luego, cada conjunto se divide en sus elementos individuales. Estos elementos se utilizan para generar el producto cartesiano.

## Como Ejecturalo: 
    -En una terminal ejecutar el siguiente comando "git clone https://github.com/diegalvarez716/Taller_Objeto_y_abstranccion_de_datos.git"

    -Una vez descargar da carpeta del proyecto llamada "proyecto3", debe entrar a dicha carpeta e ingresar a la sub-carpeta llmada "entrada_y_salida"
    
    -Modificar el acrhivo llamado "test.input", ahi se deben agregar todas las lineas de texto que se desean evaluar

    -Luego desde la consolas de comando debe ingresar al directorio "proyecto3/Producto Cartesiano" y ejecutar el comando "javac Carteriano.java"

    -Se creara un archivo .class, debe ejecutar el comando "java Cartesiano" para la ejecucion del programa, una vez ejecutado se crearan las respuestas en los archivos de salidad correspondientes en la sub-carpeta "entrada_y_salida"

## Notas
Este programa asume que los archivos de entrada y salida están en el directorio `entrada_y_salida`. Asegúrate de que este directorio exista y contenga el archivo de entrada antes de ejecutar el programa.

