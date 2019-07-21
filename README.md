## Dominó Programación interactiva
###### Tip para el Javadoc
javadoc *.java -encoding UTF-8 -charset UTF-8 -docencoding UTF-8

Este es el git que se crea para el proyecto de dominó de programación interactiva.

##### Bitácora:
18/07/19: Se construyó parcialmente la clase ficha y la clase Pila, donde a esta última se le agregaron ya todas las fichas y la posibilidad de aleatorizar las fichas contenidas en un array, adicionalmente se creó un método para obtener fácilmente la imagen de un objeto Ficha.

19/07/19: Se logró setear un layout apropiado para la estructura del juego, se implementaron demasiados métodos que ayudan tanto a la lógica del juego como a la graficación en sí, la principal dificultad encontrada hasta ahora es la de graficar el tablero de juego (que es donde se ponen las fichas) y también organizar la lógica del tablero de juego de modo que las fichas queden pegadas con el número que les corresponde, hay especial dificultad más que todo en la parte donde no sé cómo hacer que, por ejemplo, al momento de comprobar si una ficha se puede jugar o no, sólo compruebe la parte que está en la cola o la cabeza de las jugadas, sobre todo en el hecho de que tendría que intercambiar los lados de las fichas para poder situar las fichas jugadas de manera organizada pero esta acción me generaría problemas al momento de graficarlas por la cuestión de las imágenes y su asignación por lados de la ficha.
Se me ocurre una idea y es generar las imágenes de las fichas al momento de crear una nueva ficha, de esa manera, si intercambiamos los lados no habría problema en graficar las fichas (que es el mayor impedimento) Por ahora me voy a dormir, estoy cansado... 

20/07/19:  Finalmente logré implementar un método de verificación de jugada, rotación de ficha y creación de botones de fichas rotadas. 
Falta crear un método de interfaz para estructurar bien lo del tablero de juego que sería la región center del layout principal.
Falta agregarle las acciones de click a las fichas de la mano para que se jueguen en el tablero.
Estoy más cansado que ayer... Maldición.
##### Requerimientos:
0. B U T I F A R R A
1. Debe tener interfaz gráfica
2. Las fichas deben ser arrastradas al tablero y después acomodadas, se debe comprobar si una ficha se puede poner o no
3. yeahhh nose tampoko jaajsjjj sisas
4. Jueputa mátenme eahhhahahhw sisi

#### Planteamiento del problema

- #### Fase 1
    Los jugadores deben elegir una de las 28 fichas, quien saque la mayor ficha juega primero.
- #### Fase 2 
    Se reparten siete fichas entre los dos jugadores, el que juega primero abre la jugada con cualquier ficha, el segundo continua poniendo una ficha que tenga un número disponible a cualquiera de los dos lados.
    Si no se tiene ninguna ficha disponible para jugar, toma fichas de la pila hasta que tenga una para jugar, esto se hace realizando comprobaciones
- #### Fase 3
    Cuando un jugador no tiene fichas para jugar, toma de las fichas que restaron de la repartición hasta que tenga algo bueno para jugar.
    Cuando un jugador haya puesto todas sus fichas en el tablero, se dice que este es ganador.
- #### Fase 4
    Se descuenta o agrega dinero al balance del jugador, dependiendo si perdió o ganó.

#### Planteamiento de Clases
- #### Ficha:
    Se crea una clase ficha con el fin de que al llamar al constructor se le asignen dos valores, el del lado A y el Lado B, también se le debería asignar una imagen para facilitar la graficación en la clase de interfaz.


