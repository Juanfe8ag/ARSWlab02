# Lab02
## Autor: Juan Felipe Ochoa

## Primera parte: Creación, puesta en marcha y coordinación de hilos.

Para este punto se inicia el programa de PrimeFinder con 200.000.000 de datos y un solo hilo.
Mientras se ejecuta la aplicación se mira el comportamiento de cores (el equipo tiene 8).
![Screenshot 2025-08-23 074608.png](util%2FScreenshot%202025-08-23%20074608.png)


Se ve que todos los cores estaban trabajando en el proceso y el tiempo de ejecución fue de casi 2 minutos.

Luego se modifica el código para que la busqueda se divida en 3 hilos. El rendimiento de los cores fue
menor ya que hubo 3 que ni siquiera llegaron al 50% de uso. Además el tiempo de ejecuión fue de un minuto.
![Screenshot 2025-08-23 082713.png](util%2FScreenshot%202025-08-23%20082713.png)