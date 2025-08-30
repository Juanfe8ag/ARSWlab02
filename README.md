# Lab02
## Autor: Juan Felipe Ochoa

## Primera parte: Creación, puesta en marcha y coordinación de hilos en números primos.

Para este punto se inicia el programa de PrimeFinder con 200.000.000 de datos y un solo hilo.
Mientras se ejecuta la aplicación se mira el comportamiento de cores (el equipo tiene 8).
![Screenshot 2025-08-23 074608.png](util%2FScreenshot%202025-08-23%20074608.png)


Se ve que todos los cores estaban trabajando en el proceso y el tiempo de ejecución fue de casi 2 minutos.

Luego se modifica el código para que la busqueda se divida en 3 hilos. El rendimiento de los cores fue
menor ya que hubo 3 que ni siquiera llegaron al 50% de uso. Además el tiempo de ejecuión fue de un minuto.
![Screenshot 2025-08-23 082713.png](util%2FScreenshot%202025-08-23%20082713.png)

Para el último requisito de la primera parte se implementaron unos métodos de sincronización dentro de los hilos para parar y reanudar. 
Por otro lado, en la clase principal se realiza un ciclo para que cada 5 segunndos, el sistema cuente los números primos encontrados y se pueda 
reanudar al presionar ENTER.

## Segunda parte: Carreras de Galgos, solución de inconsistencias.

La primera inconsistencia fue el aviso de ganador al iniciar la carrera, para ello se uso el método join() para que todos los hilos paren antes de mostrar el mensaje.
La segunda inconsistencia era que, al terminar la carrera, era probable encontrar que dos Galgos habían quedado aparentemente en el mismo puesto, cosa que es imposible y, analizando, 
se concluyó que era por error de sincronización, ya que era posible que se accediera al puesto antes de que el que había llegado realmente lo actualizara. Para resolverlo
se implemento un método sincronizado para que se acceda a él uno a uno y no se repita el puesto. 

Por último, también se tenía que implementar la funcionalidad de los botones stop y continue, para ello se creo una nueva clase llamada PauseRace para que
mediante los métodos wait() y notifyAll() se pararan o reanudaran los hilos dependiendo el caso. 