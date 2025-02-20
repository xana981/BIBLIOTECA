Deseamos gestionar una biblioteca.
La biblioteca contiene libros que los socios pueden tomar prestados un número de
días (dependiendo del préstamo, 15 días o un mes)
Tendremos que mantener un inventario de los libros que existen en la biblioteca
De cada libro nos interesa, al menos, su ISBN, su título, autor y año de edición. Los
identificaremos por su ISBN. El ISBN o International Standard Book Number es un
número de 13 cifras que identifica de una manera única a cada libro o producto de
editorial publicado en el mundo con características semejantes.
Tenemos dos categorías de libros, adultos y menores de 14 años.
Tendremos que mantener almacenada la información referente a todos los socios que
existen en la biblioteca.
Tenemos dos clases de socios, adultos y niños. Los adultos se identificarán con su DNI
(número sin la letra). Los menores de 14 años estarán identificados por un numero de
socio aleatorio que no exista ya en la base de datos entre 0 y 99999.
Los socios adultos podrán sacar libros de categorías adulto y menores de 14 años. Los
socios menores solo podrán sacar libros de su categoría.
Un socio puede tomar prestados como máximo tres libros. Un préstamo puede ser de
15 días o de 30 días a contar a partir del día siguiente a cuando se realiza el préstamo.
Si un socio tiene algún libro en préstamo, que haya pasado su fecha de vencimiento, no
podrá tampoco sacar más libros hasta que no devuelva el que tiene en préstamo (y que
esté vencido de fecha).
Para los socios, podremos dar de alta, baja, modificar datos
Para los libros, podremos añadir y sacar del inventario
Para la gestión de préstamos, tendremos que dar de alta un préstamo, de baja cuando
el socio lo devuelva. Debemos tener en cuenta de que en nuestra biblioteca pueden

existir varios ejemplares con el mismo título pero que la manera unívoca de
identificarlos será a través de su ISBN.
Por otro lado, tendremos también información acerca de los bibliotecarios
(trabajadores habilitados para gestionar préstamos) de la biblioteca. Mantendremos
información sobre toda la plantilla y tendremos en cuenta que esos trabajadores a su
vez pueden ser socios y sacar libros. En cada préstamo, incluimos información acerca
del trabajador que ha gestionado el préstamo, pero un trabajador socio no puede
prestarse un libro a sí mismo.
Debemos de tener en cuenta de que toda esta información tiene que ser almacenada
en una base de datos, en nuestro caso, utilizaremos la base de datos SQLite instalada
en nuestra máquina virtual Linux.

Con la información que disponemos se pide:
1. Análisis de requisitos funcionales
2. Construcción del modelo de datos (clases) y casos de uso posibles
3. Diseño de la estructura de base de datos utilizando una base de datos
relacional SQLite
4. Codificación del proyecto utilizando Eclipse.
5. Utilizaremos un repositorio en GitHub para ir almacenando los cambios
