# Sistema de Gestión de Libros

Este proyecto es un sistema básico de gestión de libros que permite realizar operaciones CRUD y búsquedas avanzadas utilizando características de Java 8. 

## Requerimientos

- Java 8
- Gradle

## Estructura del Proyecto

![image](https://github.com/user-attachments/assets/7c3dd46b-4e6e-433d-9617-eed45356fede)

## Funcionalidades

### CRUD

- Crear un nuevo libro
- Obtener un libro por ID
- Actualizar información de un libro
- Eliminar un libro

### Búsquedas Avanzadas

- Buscar libros por título (búsqueda parcial, case-insensitive)
- Filtrar libros por rango de precios
- Obtener todos los libros de un autor específico
- Obtener la lista de libros ordenada por fecha de publicación

## Instrucciones de Configuración

1. Descarga el código
2. Asegúrate de tener Java 8 y Gradle instalados.
3. Ejecuta el proyecto

## Desde consola

1. Abrir una terminal y ubicarse en la carpeta del proyecto
2. Ejecuta el siguiente comando para compilar el proyecto:
  - gradle build
2. Después de construir el proyecto, ejecuta la aplicación con:
  - gradle run
    
   ![image](https://github.com/user-attachments/assets/1c077933-3506-47ef-8eec-ac236b7a9207)
   
## Usando Eclipse

1. Importar el Proyecto en Eclipse:
   - Abre Eclipse y selecciona `File` > `Import...`.
   - Selecciona `Gradle` > `Existing Gradle Project` y haz clic en `Next`.
   - Navega hasta la carpeta donde clonaste el repositorio y selecciona esa carpeta.
   - Haz clic en `Finish`.

2. Construir el Proyecto:
   - Una vez importado, Eclipse debería reconocer automáticamente el archivo `build.gradle`.
   - Si no lo hace, haz clic derecho en el proyecto en el `Project Explorer`, selecciona `Gradle` > `Refresh Gradle Project`.

3. Configurar el JDK:
   - Haz clic derecho en el proyecto y selecciona `Properties`.
   - Ve a `Java Build Path` y asegúrate de que esté configurado para usar Java 8.
   - En `Java Compiler`, selecciona `1.8` como nivel de compilación.

4. Ejecutar la Aplicación:
   - Localiza la clase principal **App** (donde está el método `main`).
   - Haz clic derecho en la clase y selecciona `Run As` > `Java Application`.

5. Verificar la Consola:
   - Abre la consola de Eclipse para ver la salida de la aplicación. Aquí podrás verificar que todo funcione correctamente.


