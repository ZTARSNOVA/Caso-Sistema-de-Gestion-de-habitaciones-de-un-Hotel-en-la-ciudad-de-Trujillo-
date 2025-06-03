# Caso: Sistema de Gestión de habitaciones de un Hotel en la ciudad de Trujillo

Enunciado:
Se requiere implementar un sistema para gestionar habitaciones (numero, tipo y precioxHora) de un hotel, para lo cual se presenta los siguientes requerimientos funcionales:

Se requiere implementar un sistema para gestionar habitaciones (numero, tipo y precioxHora) de un hotel, para lo cual se presenta los siguientes requerimientos funcionales:

- Registrar, Buscar, Actualizar, Eliminar y listar habitaciones.
- Calcular el precio final de una habitación, para eso se aplica diferentes estrategias de cálculo
como: tipo de habitación (Doble, Deluxe y Suite) y el nro. de horas que se ocupa.
Para asegurar una estructura clara y mantenible, la solución debe aplicar:
    - Patrón de Arquitectura MVC: para separar responsabilidades (Modelo, Vista y
    Controlador).
    - Considerar 02 reglas de Negocio e implementarlas en la capa de Servicio.
    - Además, debe usar los patrones de diseño de Repository y Estrategy (calcular el precio final según la habitación y nro de horas que se ocupa).

-----------------------------------------------------

 _💡Este proyecto grupal se desarrolla como parte de la evaluación continua del curso de Programación Orientada a Objetos II en la Universidad San Ignacio de Loyola._

-----------------------------------------------------

* Base de datos

```sql
CREATE DATABASE IF NOT EXISTS habitaciones_db;
USE habitaciones_db;

CREATE TABLE habitaciones (
  HabitacionID INT AUTO_INCREMENT PRIMARY KEY,
  Numero VARCHAR(50) NOT NULL,
  Tipo VARCHAR(50) NOT NULL,
  Precio DOUBLE(10,2) NOT NULL
);
```


