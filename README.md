#Autores

Diego Alvarez / C.I: 30.983.861

Javier Mujica / C.I: 30.711.587


#Funcionamiento del Codigo

Este programa consiste en la creacion de pokedexes y teams de pokemones mediante la implementancion de estructuras de datos como pilas y cola para luego llevar a cabo un combate entre los respectivos teams  y generar un archivo de salida con las sentencias correspondientes 

Los comandos aceptados son: 

"CREATE STACK POKEDEX" -> Crea una pokedex en forma de pila 

"CREATE QUEUE POKEDEX" -> Crea una pokedex en forma de cola 

"SHOW STACK POKEDEX" -> Muestra en el archivo de salida todos los pokemones que forman la pokedex con el formato "Nombre/Tipo" 

"SHOW QUEUE POKEDEX" -> Muestra en el archivo de salida todos los pokemones que forman la pokedex con el formato "Nombre/Tipo" 

"CREATE STACK TEAM" -> Crea un team en forma de pila con de acuerdo a los tipos de pokemones que sean ingresados, estos seran seleccionados de la stack pokedex 

"CREATE QUEUE TEAM" -> Crea un team en forma de cola con de acuerdo a los tipos de pokemones que sean ingresados, estos seran seleccionados de la Queue pokedex

"SHOW STACK TEAM" -> Muestra en el archivo de salida todos los pokemones que forman el team con el formato "Nombre/Tipo" 

"SHOW QUEUE TEAM" -> Muestra en el archivo de salida todos los pokemones que forman el team con el formato "Nombre/Tipo"

#Como Ejecutar el Codigo

Para ejecutar el proyecto primero debe descargarse el proyecto usando "git clone https://github.com/diegalvarez716/Objeto_y_abstranccion_de_datos.git" despues se debe de acceder a la carpeta "proyecto", una vez en la carpete se debe de abrir la consola de comando en la misma direccion que este el ejecutable de "proyecto1.exe", para luego usar el comando "./proyecto1 nombre-del-test.md". El archivo de se creara en el escritorio


#Ejemplos de entrada y salida

Entrada   

CREATE STACK POKEDEX

Charmander/Fire, Charmeleon/Fire, Charizard/Fire, Chikorita/Grass, Psyduck/Water, Meganium/Grass, Chimchar/Fire, Cacnea/Grass, Wailmer/Water

CREATE QUEUE POKEDEX

Blastoise/Water, Feraligatr/Water, Sceptile/Grass, Gorebyss/Water, Piplup/Water, Tepig/Fire, Torchic/Fire, Typhlosion/Fire, Rapidash/Fire

SHOW STACK POKEDEX

SHOW QUEUE POKEDEX

CREATE STACK TEAM

Fire Grass water

CREATE QUEUE TEAM

Fire Fire Fire

SHOW STACK TEAM

SHOW QUEUE TEAM

ENCOUNTER


Salida 

STACK POKEDEX 

 Wailmer/Water Cacnea/Grass Chimchar/Fire Meganium/Grass Psyduck/Water Chikorita/Grass Charizard/Fire Charmeleon/Fire Charmander/Fire
 
 QUEUE POKEDEX 
 
 Blastoise/Water Feraligatr/Water Sceptile/Grass Gorebyss/Water Piplup/Water Tepig/Fire Torchic/Fire Typhlosion/Fire Rapidash/Fire
 
 STACK TEAM 
 
 Wailmer/Water Cacnea/Grass Chimchar/Fire
 
 QUEUE TEAM 
 
 Tepig/Fire Torchic/Fire Typhlosion/Fire
 
TURN 1

Wailmer/Water VS Tepig/Fire -> Wailmer/Water

TURN 2

Wailmer/Water VS Torchic/Fire -> Wailmer/Water

TURN 3

Wailmer/Water VS Typhlosion/Fire -> Wailmer/Water

STACK TEAM WINS


#Pruebas del Codigo

test.md: Esta es la prueba estandar del como se nos pidio el codigo.

test2.md: En esta se pone a prueba en caso en el que todos los pokemones son iguales.

test3.md: En esta se pone a prueba el caso de varios pokemones contra uno solo.


#Acotaciones 

-Solo se aceptan los pokemones de tipo "Fire", "Water" y "Grass" de lo contrario no seran tomados en cuenta 

-Al momento de crear una pokedex sea de tipo pila o  cola en inmediatamente en la linea siguiente deben estar presente los pokemones a ingresar con el siguiente formato "Nombre/Tipo, Nombre/Tipo,". 
Tambien debe asegurarse de no generar saltos de lineas manueles al ingresar todos los pokemones, de lo contrario solo seran tomados en cuenta los de la primera linea 

-Al momento de ingresar la sentencia para crear los teams ya sea Pila o Cola, en la linea siguiente deben ser ingresados los tipos de pokemones que se desean utilizar con un espacio entre cada tipo, por ejemplo, "Tipo1 Tipo2"
