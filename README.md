# Proyecto Integrador: ArrayList y LinkedList

## 📋 Descripción

Implementación de dos estructuras de datos fundamentales en Java: **ArrayList** (basada en arreglos dinámicos) y **LinkedList** (basada en nodos enlazados). Ambas implementan la interfaz `IList<E>` y proporcionan funcionalidad genérica para almacenar y manipular colecciones de elementos.

Este proyecto incluye casos de prueba exhaustivos que validan el correcto funcionamiento de ambas estructuras en escenarios positivos y de error.

---

## 📁 Estructura del Proyecto

```
.
├── IList.java          → Interfaz que define el contrato de ambas listas
├── ArrayList.java      → Implementación basada en arreglo dinámico
├── LinkedList.java     → Implementación basada en nodos enlazados
├── Node.java           → Clase que representa un nodo para LinkedList
├── Main.java           → Clase con casos de prueba
└── README.md           → Este archivo
```

---

## 🎯 Clases Principales

### **IList.java** (Interfaz)
Define el contrato que deben cumplir todas las implementaciones de lista:
- `void add(E e)` - Agregar al final
- `void add(E e, int index)` - Agregar en posición específica
- `E remove(int index)` - Eliminar elemento
- `E get(int index)` - Obtener elemento
- `int size()` - Obtener tamaño
- `void clear()` - Vaciar lista
- `boolean isEmpty()` - Verificar si está vacía

### **ArrayList.java** (Implementación con Arreglo)
- **Capacidad inicial:** 10 elementos
- **Expansión automática:** Aumenta de 10 en 10 cuando se llena
- **Acceso:** O(1) - Acceso directo por índice
- **Inserción/Eliminación:** O(n) - Requiere desplazar elementos

### **LinkedList.java** (Implementación con Nodos)
- **Estructura:** Cadena de nodos enlazados
- **Acceso:** O(n) - Requiere recorrer desde el inicio
- **Inserción/Eliminación:** O(n) - Requiere navegar hasta la posición

### **Node.java** (Nodo para LinkedList)
Representa un nodo individual en la lista enlazada:
- `E info` - Información almacenada
- `Node<E> next` - Referencia al siguiente nodo

---

## 🧪 Casos de Prueba

El archivo `Main.java` contiene **39 casos de prueba** que validan:

### ✅ Casos Positivos (ArrayList: 10 | LinkedList: 14)
- Agregar elementos al final
- Obtener elementos
- Verificar tamaño
- Insertar en posiciones específicas
- Eliminar elementos
- Expansión automática (ArrayList)
- Limpiar lista
- Representación en String

### ❌ Casos de Error (ArrayList: 6 | LinkedList: 8)
- Acceder a índices negativos
- Acceder a índices fuera de rango
- Eliminar de índices inválidos
- Insertar en posiciones inválidas
- Operaciones en listas vacías

**Ejecución:** `java Main`

---

## 📚 JavaDoc: Documentación del Código

JavaDoc es un estándar de Java para documentar código. Utiliza **comentarios especiales** (con `/**` y `*/`) que contienen **etiquetas** (palabras que comienzan con `@`) para describir métodos, parámetros, excepciones y más.

### ¿Por qué usé JavaDoc?

✅ **Documentación automática:** Genera HTML con toda la documentación
✅ **Claridad:** Otros desarrolladores (y yo en el futuro) entienden el código rápido
✅ **IDE Support:** IntelliJ y Eclipse muestran la documentación al pasar el mouse
✅ **Profesionalismo:** Es estándar en la industria
✅ **Mantenibilidad:** Facilita el mantenimiento del código

---

## 🏷️ Etiquetas JavaDoc Usadas en el Proyecto

### 1. **`@param`** - Documenta parámetros

**Sintaxis:**
```java
@param nombreParametro Descripción del parámetro
```

**Ejemplo en el código:**
```java
/**
 * Añade un elemento en una posición específica.
 * @param e Elemento a añadir
 * @param index Posición donde insertar
 */
public void add(E e, int index) {
    // ...
}
```

**Explicación:**
- `@param e` describe el parámetro `e` (el elemento a añadir)
- `@param index` describe el parámetro `index` (la posición)
- **Debes usar `@param` por cada parámetro** que tenga el método

**Ubicación en JavaDoc generado:**
```
Parameters:
  e - Elemento a añadir
  index - Posición donde insertar
```

---

### 2. **`@return`** - Documenta el valor retornado

**Sintaxis:**
```java
@return Descripción de lo que devuelve el método
```

**Ejemplo en el código:**
```java
/**
 * Elimina el elemento en la posición especificada.
 * @param index Posición del elemento a eliminar
 * @return El elemento eliminado
 */
@Override
public E remove(int index) {
    // ...
    return aux;
}
```

**Explicación:**
- `@return` describe qué devuelve el método
- Se usa **solo en métodos que retornan algo** (no en `void`)
- Es importante explicar **qué es** lo que se retorna

**Ubicación en JavaDoc generado:**
```
Returns:
  El elemento eliminado
```

---

### 3. **`@throws`** - Documenta excepciones

**Sintaxis:**
```java
@throws NombreExcepcion Descripción de cuándo se lanza
```

**Ejemplo en el código:**
```java
/**
 * Obtiene el elemento en la posición especificada.
 * @param index Posición del elemento
 * @return El elemento en esa posición
 * @throws IndexOutOfBoundsException si el índice está fuera de rango
 */
@Override
public E get(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }
    // ...
}
```

**Explicación:**
- `@throws` describe qué excepciones puede lanzar el método
- **Importante:** Lista TODAS las excepciones que pueden ocurrir
- Explica **en qué situación** se lanza

**Ubicación en JavaDoc generado:**
```
Throws:
  IndexOutOfBoundsException - si el índice está fuera de rango
```

---

### 4. **Descripción General** - El primer comentario

**Sintaxis:**
```java
/**
 * Descripción breve del método (en una línea).
 * 
 * Descripción más detallada si es necesaria.
 * Puede ocupar varias líneas.
 */
```

**Ejemplo en el código:**
```java
/**
 * Verifica si el arreglo está lleno.
 * @return true si size == capacity
 */
protected boolean isFull() {
    return size == capacity;
}
```

**Explicación:**
- La **primera línea** es la descripción breve (se muestra en resúmenes)
- Describe **QUÉ hace** el método, no **CÓMO** lo hace
- Si necesitas más detalles, agrega párrafos adicionales

---

## 📋 Ejemplo Completo: Método `add(E e, int index)`

```java
/**
 * Añade un elemento en una posición específica.
 * 
 * Si la posición es 0, el elemento se inserta al principio.
 * Si la posición es igual al tamaño, se inserta al final.
 * 
 * @param e Elemento a añadir
 * @param index Posición donde insertar (0 <= index <= size)
 * @throws IndexOutOfBoundsException si index < 0 o index > size
 */
@Override
public void add(E e, int index) {
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }
    // ... resto del código
}
```

**Desglose:**
| Parte | Explicación |
|-------|-------------|
| Línea 1 | Descripción breve |
| Líneas 3-5 | Descripción detallada (opcional pero buena práctica) |
| Línea 7 | Documenta parámetro `e` |
| Línea 8 | Documenta parámetro `index` con rango válido |
| Línea 9 | Documenta qué excepción se lanza y cuándo |

---

## 🔍 Comparación: Con y Sin JavaDoc

### ❌ Sin JavaDoc (malo)
```java
public E get(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }
    @SuppressWarnings("unchecked")
    E result = (E) items[index];
    return result;
}
```

**Problemas:**
- ¿Qué hace exactamente?
- ¿Qué parámetro necesita?
- ¿Qué puede devolver?
- ¿Qué errores pueden ocurrir?

### ✅ Con JavaDoc (bien)
```java
/**
 * Obtiene el elemento en la posición especificada.
 * @param index Posición del elemento
 * @return El elemento en esa posición
 * @throws IndexOutOfBoundsException si el índice está fuera de rango
 */
@Override
public E get(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }
    @SuppressWarnings("unchecked")
    E result = (E) items[index];
    return result;
}
```

**Ventajas:**
- ✅ Claro qué hace
- ✅ Sé qué parámetro usar
- ✅ Sé qué esperar como resultado
- ✅ Sé qué errores pueden ocurrir
- ✅ IDE muestra esto al pasar el mouse

---


## 🚀 Cómo Usar Este Proyecto

### Compilar
```bash
javadoc -d docs *.java
javac *.java
```

### Ejecutar pruebas
```bash
java Main
```

### Resultado esperado
```
╔════════════════════════════════════════════════════════════╗
║  PRUEBAS DE ARRAYLIST Y LINKEDLIST                         ║
╚════════════════════════════════════════════════════════════╝

═══════════════════════════════════════════════════════════
PRUEBAS: ARRAYLIST<STRING>
═══════════════════════════════════════════════════════════

✅ ArrayList - Agregar al final
✅ ArrayList - Obtener elemento
...

═══════════════════════════════════════════════════════════
RESUMEN DE PRUEBAS
═══════════════════════════════════════════════════════════
Total de pruebas: 39
✅ Pasadas: 39
❌ Fallidas: 0
═══════════════════════════════════════════════════════════
```

---

## 📝 Autor

**Mélany** - Segundo año de Ingeniería Informática  
**Universidad:** Universidad de Pinar del Río (Universidad Hermanos Saíz Montes de Oca)

---

## 📚 Referencias

- [Oracle JavaDoc Official Documentation](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
- Java Generics and Collections
- Estructuras de Datos: ArrayList vs LinkedList


