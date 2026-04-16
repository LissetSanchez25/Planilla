PRÁCTICA U1 Y U2 - PROGRAMAS GUI CON BASE DE DATOS

---

REQUISITOS

* Java JDK instalado
* MySQL Server instalado y en ejecución
* MySQL Workbench (opcional para importar la BD)
* Sistema operativo Windows

---

CONFIGURACIÓN

1. BASE DE DATOS

* Abrir MySQL Workbench

* Crear una base de datos (ejemplo: prac2)

* Importar el archivo ubicado en:

  bd/script_bd.sql

* Ejecutar todo el script para crear tablas y datos

---

2. CONFIGURACIÓN DE CONEXIÓN

* Abrir el proyecto en NetBeans

* Buscar la clase de conexión (normalmente en utilerias)

* Verificar los datos:

  URL: jdbc:mysql://localhost:3306/prac2
  Usuario: root
  Contraseña: 1234

* Ajustar si es necesario según tu configuración local

---

EJECUCIÓN DEL PROGRAMA

OPCIÓN 1:

* Ejecutar el archivo:

  prac2.jar

* Doble clic sobre el archivo

OPCIÓN 2:

* Ejecutar el archivo:

  ejecutar.bat

---

ESTRUCTURA DEL PROYECTO

* src/          → Código fuente
* bd/           → Script de base de datos
* doc/          → Manual de usuario
* prac2.jar     → Ejecutable funcional
* README.txt    → Instrucciones

---

NOTAS IMPORTANTES

* MySQL debe estar encendido antes de ejecutar el programa
* La base de datos debe estar importada
* Verificar que las credenciales sean correctas
* Si el .jar no abre, ejecutar desde consola:

  java -jar prac2.jar

---

AUTOR

Nombre: (Tu nombre)
Materia: (Nombre de la materia)
Profesor: (Nombre del profesor)

---
