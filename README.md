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



#Acotaciones 

-A la hora de hacer una corrida del programa es necesario hacer lo siguiente escribir  "./proyecto1 nombre del archivo a pasar como parametro".

-Solo se aceptan los pokemones de tipo "Fire", "Water" y "Grass" de lo contrario no seran tomados en cuenta 

-Al momento de crear una pokedex sea de tipo pila o  cola en inmediatamente en la linea siguiente deben estar presente los pokemones a ingresar con el siguiente formato "Nombre/Tipo, Nombre/Tipo,". 
Tambien debe asegurarse de no generar saltos de lineas manueles al ingresar todos los pokemones, de lo contrario solo seran tomados en cuenta los de la primera linea 

-Al momento de ingresar la sentencia para crear los teams ya sea Pila o Cola, en la linea siguiente deben ser ingresados los tipos de pokemones que se desean utilizar con un espacio entre cada tipo, por ejemplo, "Tipo1 Tipo2"
