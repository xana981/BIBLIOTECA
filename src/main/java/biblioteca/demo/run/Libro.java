package biblioteca.demo.run;

public class Libro {

	private int isbn; //asociada a la clave primaria en la tabla de DB
	private String titulo;
	private String autor;
	private int edicion;	
	
		
	
	
	
//Metodo set, va modificar ese atributo. 
//Metodo get para consultar, te devuelve el valor del atributo
	
	public int getIsbn() { 
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() { //Me devuelve el valor del atributo, una cadena de caracteres
		return autor;
	}

	public void setAutor(String autor) { //entre parentesis el argumento al que voy a llamar
		this.autor = autor; //Le asigno al atributo el valor que le paso como argumento
	}

	public int getEdicion() { 	// Te devuelve el valor del atributo edicion de la clase libro, 
								// al ser público se puede invocar o llamar desde fuera de la clase
								// al definir el metodo me tiene que devolver un tipo int porque el atributo edicion está definido como entero.
		return edicion; //la sentencia return me devuelve el resultado al metodo
	}

	public void setEdicion(int edicion) { //al poner tipo void no me hace falta poner la sentencia return
		this.edicion = edicion; //asigna al atributo edicion, el valor que le paso como argumento en la llamada del metodo
	}
	
	
}
