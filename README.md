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

### Desde consola

1. Abrir una terminal y ubicarse en la carpeta del proyecto
2. Ejecuta el siguiente comando para compilar el proyecto:
  - gradle build
2. Después de construir el proyecto, ejecuta la aplicación con:
  - gradle run
    
   ![image](https://github.com/user-attachments/assets/1c077933-3506-47ef-8eec-ac236b7a9207)
   
### Usando Eclipse

1. Importar el Proyecto en Eclipse:
   - Abre Eclipse y selecciona `File` > `Open Projects...`.
   - Navega hasta la carpeta donde clonaste el repositorio y selecciona esa carpeta usando `Directory`.
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

## Ejemplos de Uso en el Código

La clase `App` contiene ejemplos de cómo interactuar con el sistema de gestión de libros. A continuación, se describen algunas de las funcionalidades implementadas:

1. **Creación de Libros**: Se muestran ejemplos de cómo crear libros y manejar excepciones en caso de errores.
2. **Obtención de Libros**: Ejemplos para obtener un libro por su ID, incluyendo la validación de ID nulos.
3. **Actualización de Libros**: Se ilustra cómo actualizar la información de un libro y manejar situaciones donde el libro no exista.
4. **Filtrado y Búsqueda**: Ejemplos de cómo filtrar libros por precio, buscar por título y obtener libros de un autor específico.
5. **Ordenación**: Ejemplo de cómo obtener una lista de libros ordenada por fecha de publicación.
6. **Eliminación de Libros**: Se muestran ejemplos de eliminación de libros y la validación de IDs inválidos.

### Personalización de Ejemplos

Puedes modificar los ejemplos anteriores en la clase `App` para realizar diferentes validaciones y pruebas. Esto te permitirá experimentar con el sistema y adaptar las funcionalidades a tus necesidades específicas.

Por ejemplo, puedes:
- Agregar más libros con diferentes propiedades.
- Probar diferentes combinaciones de búsqueda y filtrado.
- Manejar otros escenarios de error.

## Decisiones de diseño

Las siguientes decisiones de diseño fueron tomadas siguiendo las especificaciones solicitadas para el proyecto de gestión de libros:

1. **Arquitectura en Capas**:
   - Se implementó una arquitectura en capas para separar las responsabilidades del sistema. Esto incluye la capa de **Modelo**, **DAO**, y **Servicio**, lo que facilita la mantenibilidad y escalabilidad del código.

2. **Uso de DAOs**:
   - La implementación de **Data Access Objects (DAOs)** permite un acceso limpio y desacoplado a los datos. Esto facilita futuros cambios en la forma en que se almacenan los datos (por ejemplo, cambiar de una base de datos en memoria a una base de datos persistente).

3. **Excepciones Personalizadas**:
   - Se crearon excepciones personalizadas (`BookNotFoundException`, `InvalidBookException`) para manejar errores específicos de forma clara y concisa. Esto mejora la legibilidad del código y facilita la gestión de errores.

4. **Características de Java 8**:
   - Se utilizó la **Stream API** de Java 8 para implementar búsquedas y filtros eficientes, lo que mejora el rendimiento y hace que el código sea más expresivo y fácil de entender.
   - Se emplearon **Optional** para manejar posibles valores nulos, evitando el uso de referencias nulas y haciendo el código más seguro.

5. **Validaciones en el Servicio**:
   - La lógica de negocio se maneja en la capa de **Servicio**, donde se implementan las validaciones necesarias antes de interactuar con los DAOs. Esto asegura que solo los datos válidos sean procesados y almacenados.

6. **Manejo de Errores**:
   - Se implementó un manejo de errores consistente, donde las excepciones son capturadas y se proporciona retroalimentación clara al usuario. Esto mejora la experiencia del usuario y facilita la depuración.

Estas decisiones fueron fundamentales para cumplir con los requerimientos técnicos y funcionales del proyecto.

## Consideraciones Finales

- **Configuración de la Base de Datos**: Este proyecto utiliza una base de datos en memoria, por lo que no se requieren configuraciones adicionales.

