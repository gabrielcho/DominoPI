## Dominó Programación interactiva
Este es el git que se crea para el proyecto de dominó de programación interactiva.

##### Bitácora:
18/07/19: Se construyó parcialmente la clase ficha y la clase Pila, donde a esta última se le agregaron ya todas las fichas y la posibilidad de aleatorizar las fichas contenidas en un array, adicionalmente se creó un método para obtener fácilmente la imagen de un objeto Ficha.

19/07/19: 

##### Requerimientos:
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


