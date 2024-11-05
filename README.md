# maXsport

![logobueno (1)](https://github.com/user-attachments/assets/b602fddd-e731-40b3-a8cc-cb9ce3fdbf65)


## Índice
1. [Introducción](#introducción)
2. [Descripción](#descripción)
3. [Estado](#estado)
4. [Tecnologías utilizadas](#tecnologías-utilizadas)
5. [Dificultades encontradas](#dificultades-encontradas)
6. [Colaboradores](#colaboradores)

## Introducción
maXsport es una aplicación diseñada para gestionar los entrenamientos de los usuarios de un gimnasio. Su objetivo es facilitar el seguimiento del progreso y la planificación de rutinas personalizadas en las que un entrenador puede elegir que rutinas y ejercicios asigna a cada usuario. 

## Descripción
La aplicación permite a los usuarios registrar sus entrenamientos, monitorear y consultar sus ejercicios y ajustar sus planes de ejercicio según sus objetivos conforme a las rutinas que su entrenador decida. Cada entrenador puede ir variando la rutina de ejercicios por ususarios segun su desempeño.
 
## Estado
El proyecto se encuentra en proceso de desarrollo. Actualmente se están mejorando la interfaz de usuario, añadiendo el login y en los proximos dias se generarán las clases para el acceso a los datos.

## Tecnologías utilizadas
Para el desarrollo de maXsport se han utilizado el lenguaje de programacion Java, las consultas a la BBDD se realizaran con el uso de Azure Data Studio sobre un servidos MS SQL server, todo ello siendo desarrollado sobre Ubuntu 20.04.
El control de versiones se realiza con el uso de GIT, mediante repos al remoto de GITHUB.

## Dificultades encontradas
Hasta ahora lo que mas tienpo ha precisado ha sido conseguir hacer que trabaje el servidor y el gestor de DB Azure Data Studio ya que no habia soporte para ubuntu 24.04, debiendo degradar el SO a ubuntu 20.04. con los problemas que ello me ha generado.

Estoy teniendo problemas con el archivo DataAccess, ya aque los metodos no hacian exactamente lo que deberian, he cambiado el codigo en algunos puntos, estas dudas ya fueron resueltas por el profesor.

Otro problema que tube es usar nerbeans 23, al tener que usaR UBUNTU 20.04 , este no tiene soporte para netbeans 23 por lo que tuve que hacerlo en la version 21, me encontré en un callejon ya que si elegia ubuntu 24.04 no podia usar el Azure pero si netbeans 23 o elegir ubuntu 20.04 con el que si podia usar azure data studio pero no la vesion 23 de netbeans.

Intenté realizar la carba del combobox con objetos a mi manera y la hice pero luego vi que la que explicaba el profesar era mucho mejor.

## Colaboradores
gjm@paucasesnovescifp.cat
Mi hija ha realizado el logo
