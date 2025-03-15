# maXsport

![logobueno (1)](https://github.com/user-attachments/assets/b602fddd-e731-40b3-a8cc-cb9ce3fdbf65)


## Índice
1. [Introducción](#introducción)
2. [Descripción](#descripción)
3. [Estado](#estado)
4. [Tecnologías utilizadas](#tecnologías-utilizadas)
5. [Dificultades encontradas](#dificultades-encontradas)
6. [Colaboradores](#colaboradores)
7. [UX.User experience](#Usabilidad)

## Introducción
maXsport es una aplicación diseñada para gestionar los entrenamientos de los usuarios de un gimnasio. Su objetivo es facilitar el seguimiento del progreso y la planificación de rutinas personalizadas en las que un entrenador puede elegir que rutinas y ejercicios asigna a cada usuario. 

## Descripción
La aplicación permite a los usuarios registrar sus entrenamientos, monitorear y consultar sus ejercicios y ajustar sus planes de ejercicio según sus objetivos conforme a las rutinas que su entrenador decida. Cada entrenador puede ir variando la rutina de ejercicios por ususarios segun su desempeño.

![PLAN_page-0001](https://github.com/user-attachments/assets/537a5dfe-e0b3-49f8-b0fd-627178125f11)

## Estado
El proyecto se encuentra en proceso de desarrollo. Actualmente se están mejorando la interfaz de usuario, añadiendo el login y en los proximos dias se generarán las clases para el acceso a los datos.

## Tecnologías utilizadas
Para el desarrollo de maXsport se han utilizado el lenguaje de programacion Java, las consultas a la BBDD se realizaran con el uso de Azure Data Studio sobre un servidos MS SQL server, todo ello siendo desarrollado sobre Ubuntu 20.04.
El control de versiones se realiza con el uso de GIT, mediante repos al remoto de GITHUB.

## Dificultades encontradas
Hasta ahora lo que mas tienpo ha precisado ha sido conseguir hacer que trabaje el servidor y el gestor de DB Azure Data Studio ya que no habia soporte para ubuntu 24.04, debiendo degradar el SO a ubuntu 20.04. con los problemas que ello me ha generado.

Estoy teniendo problemas con el archivo DataAccess, ya aque los metodos no hacian exactamente lo que deberian, he cambiado el codigo en algunos puntos, estas dudas ya fueron resueltas por el profesor.

Otro problema que tuve es usar nerbeans 23, al tener que usaR UBUNTU 20.04 , este no tiene soporte para netbeans 23 por lo que tuve que hacerlo en la version 21, me encontré en un callejon ya que si elegia ubuntu 24.04 no podia usar el Azure pero si netbeans 23 o elegir ubuntu 20.04 con el que si podia usar azure data studio pero no la vesion 23 de netbeans.

Intenté realizar la carba del combobox con objetos a mi manera y la hice pero luego vi que la que explicaba el profesar era mucho mejor.

## Colaboradores
gjm@paucasesnovescifp.cat
Mi hija ha realizado el logo y mi hijo testea errores.

## Usabilidad.UX
Se inicia la Tarea número 4. Esta tarea esta basada en la usabilidad de la aplicación. Se trata de mejorar la usabilidad, la facilidad y comodidad en el uso. Estos cambios han sido entre otros:

-Se ha añadido una skin que cambia en tiempo de ejecución.

-Se han reorganizado los elementos de la interface.

-Se ha añadido un botón calendario donde se pueden ver los entrenos programados por los entrenadores. Esto se hace por un componente beans hecho en la tarea 2.

-Se añaden ToolTipText en los botones.

-Se añade un buscador de usuarios.

-Se añade el cambio del puntero al pasar por encima de ciertos botones.

-Se han añadido funcionalidades que no habia antes como la eliminación de un entreno y ejercicios. Sobre este último las sentencias sql me han parecido complicadas afectando a 4 tablas.

-He cambiado varios textfield como el del login para que solo acepte ciertos caracteres, o el correo que sea válido y no este en la base de datos.

-He añadido gestion de entrenos para eliminar entrenos de usuarios, en este dialog se muestra la foto del usuario al que entrenamos.

-He ido eliminando errores que ha testeado mi hijo, como jtextfield que estaban enable y no deberian, y alguna Exception.

-En medio del proyecto he cambiado de equipo, trabajando ahora en windows y he comenzando a usar el management sql y el ms server 2022.

-He cambiado los JList para que se actualicen inmediatamente al borrar o añadir ejercicios y entrenos.

-He hecho lo mismo con los JCcombobox.

-He aprovechado código para los nuevos cambios como los métodos para poner la foto de los usuarios.

-En el dialogoLogin , muevo el focus para poder usarlo con tabulaciones o pulsar directamente intro para loguear lo que hace mas cómoda la navegación.

-He sacado código a clases para una mejor modularidad como la DefaultTableModel de entrenos.

-He creado nuevos metodos en DataAccess para las consultas que necesitaba.

-Aqui un ejemplo de las nuevas Interface que se muestran al usuario:

![image](https://github.com/user-attachments/assets/59d54b6b-128a-4bed-b4dd-fb760b37daed)

![image](https://github.com/user-attachments/assets/0407bb88-c6e2-4a0d-8a91-863dfabdfa1b)

