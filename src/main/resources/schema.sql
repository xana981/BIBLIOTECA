--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Libro;
drop table Socio;
drop table Prestamo;

CREATE TABLE "Libro" (
	"ISBN"	INTEGER NOT NULL,
	"titulo"	TEXT NOT NULL,
	"autor"	TEXT NOT NULL,
	"añoEdicion"	INTEGER NOT NULL,
	"categoria"	TEXT NOT NULL,
	PRIMARY KEY("ISBN")
);

CREATE TABLE "Socio" (
	"numSocio"	INTEGER NOT NULL,
	"nombreCompleto" TEXT NOT NULL,
	"esTrabajador" INTEGER NOT NULL,
	"fechaNac" INTEGER NOT NULL,
	"masInfo" TEXT,
	PRIMARY KEY("numSocio")
);

CREATE TABLE "Prestamo" (
	"libro"	INTEGER NOT NULL,
	"socio"	INTEGER NOT NULL,
	"fechaPrestamo"	INTEGER NOT NULL,
	"fechaDevolucion" INTEGER,
	PRIMARY KEY("socio","libro"),
	FOREIGN KEY("libro") REFERENCES "Libro"("ISBN"),
	FOREIGN KEY("socio") REFERENCES "Socio"("numSocio")
);

