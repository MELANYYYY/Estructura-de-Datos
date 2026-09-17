# Documentación del Proyecto: Estructuras de Datos

Este trabajo es un proyecto de programación que cuenta con:
- Implementación de ArrayList
- Implementación de LinkedList
- README.md que describe detalladamente todo

## Descripción de Clases

### IList.java
Es la interfaz principal del proyecto que define el contrato a seguir para las estructuras de datos[cite: 8]. Establece las operaciones fundamentales de una lista genérica, tales como la inserción, eliminación, obtención de elementos, consulta de tamaño, vaciado completo y verificación de estado[cite: 8].

### ArrayList.java
Constituye la implementación de la interfaz IList utilizando un arreglo de objetos estático de forma subyacente[cite: 7]. Inicialmente, el arreglo cuenta con una capacidad predeterminada de 10 elementos[cite: 7]. Cuando el arreglo alcanza su límite, la clase invoca un método interno para expandir su capacidad en 10 espacios adicionales, copiando los elementos existentes al nuevo arreglo[cite: 7]. Al insertar o eliminar elementos en posiciones intermedias, la estructura desplaza los datos restantes para mantener la continuidad, y lanza excepciones estandarizadas si se intenta acceder a índices fuera de rango[cite: 7].

### Node.java
Es la clase estructural básica requerida para el funcionamiento de la lista enlazada[cite: 11]. Cada objeto de esta clase actúa como un contenedor que almacena la información de tipo genérico y mantiene una referencia hacia el siguiente nodo de la secuencia, lo que permite enlazar la estructura de datos en la memoria[cite: 11].

### LinkedList.java
Representa la implementación de la interfaz IList mediante una secuencia de nodos enlazados[cite: 9]. A diferencia de la implementación basada en arreglos, esta clase gestiona una referencia al primer nodo y un contador general de tamaño[cite: 9]. Al insertar o eliminar elementos, la lista actualiza los enlaces entre los nodos en lugar de desplazar bloques de datos[cite: 9]. Para acceder a posiciones o índices específicos, la clase efectúa un recorrido secuencial desde el nodo inicial hasta alcanzar el índice solicitado[cite: 9].

### Main.java
Es la clase central encargada de la ejecución y comprobación del sistema[cite: 10]. Ofrece un menú interactivo por consola que permite al usuario probar las listas de manera manual simulando una gestión de vehículos[cite: 10]. Asimismo, integra un motor para ejecutar un conjunto de pruebas automatizadas[cite: 10]. Estas pruebas validan de manera exhaustiva el comportamiento lógico de ambas listas, evaluando casos de uso exitosos y comprobando la correcta emisión de excepciones ante escenarios de error[cite: 10].

## Compilación y Ejecución

Para compilar y probar este proyecto, es necesario ejecutar los siguientes pasos desde la terminal de comandos:

1. Navegar hasta el directorio raíz donde se encuentran los archivos fuente.
2. Compilar el código mediante el compilador de Java ejecutando: `javac *.java`
3. Iniciar el programa ejecutando la clase principal con el comando: `java Main`

## Estructura del Proyecto

El sistema se compone de los siguientes archivos de código fuente:

- IList.java
- ArrayList.java
- Node.java
- LinkedList.java
- Main.java
