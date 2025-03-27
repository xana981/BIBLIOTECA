--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:

delete from Libro;
delete from Socio;
delete from Prestamo;


INSERT INTO Libro(ISBN,titulo,autor,añoEdicion,categoria) VALUES    
(100259,"Don Quijote de La Mancha I","Miguel de Cervantes",1991,"Adulto"),
(100260,"Don Quijote de La Mancha II","Miguel de Cervantes",1991,"Adulto"),
(102412,"Historias de Nueva Orleans","William Faulkner",1985,"Adulto"),
(106591,"El principito","Maquiavelo",1995,"Adulto"),
(165842,"Diplomacia","Henry Kissinger",1998,"Adulto"),
(156234,"El Último Emperador","Pu-Yi",1989,"Adulto"),
(165356,"Los Windsor","Kitty Kelley",1998,"Adulto"),
(132862,"Fortunata y Jacinta","Pérez Galdós",1984,"Adulto"),
(195932,"Bajo el asfalto, la flor","Monica Rodriguez",2002,"Infantil"),
(195297,"Ha nacido una isla","Aladjidi Virginie",1999,"Infantil"),
(195715,"Monstruo azul","Horcek Petr",2003,"Infantil"),
(100548,"El hundimiento","Manuel Vilaw",2015,"Adulto"),
(110812,"Cien noches","Luis Martin",2005,"Adulto"),
(196452,"Yo, Tarzanne","Festuc Teatre",2005,"Infantil"),
(184957,"La regenta","Benito Perez Galdos",2015,"Adulto");

INSERT INTO Socio(numSocio,nombreCompleto,esTrabajador,fechaNac,masInfo) VALUES  
(53545473,"Veronica Gallo","No",'10-07-1991',"Tlfno: 985147896"),
(71658965,"Carmen Martinez","No",'19-08-1999',"Tlfno: 985584628"),
(10259341,"Jose Gomez","Si",'23-02-1959',"Tlfno: 985481526"),
(15493254,"Juan Diaz","Si",'04-05-1971',"Tlfno: 985975264"),
(59482364,"Pedro Mendez","No",'09-10-2012',"Tlfno: 985216574"),
(21856334,"Maria Garcia","No",'29-12-1983',"Tlfno: 985854123"),
(10592212,"Rocio Gonzalez","No",'13-05-1971',"Tlfno: 985217854"),
(71954823,"Mario Rodriguez","No",'15-10-1978',"Tlfno: 985954321"),
(52148221,"Antonio Cordoba","No",'16-07-2015',"Tlfno: 985846257"),
(10625076,"Javier Fernandez","No",'15-03-1954',"Tlfno: 984215944"),
(09452214,"Romina Perez","No",'21-09-1968',"Tlfno: 985845789");

INSERT INTO Prestamo(ISBN,numSocio,fechaPrestamo,Duracion) VALUES 
(100260,53545473,'17-03-2025',15),
(165842,21856334,'28-02-2025',30),
(195715,52148221,'06-03-2025',15),
(100259,53545473,'26-02-2025',30),
(184957,71658965,'28-02-2025',30),
(165356,09452214,'15-03-2025',15);

