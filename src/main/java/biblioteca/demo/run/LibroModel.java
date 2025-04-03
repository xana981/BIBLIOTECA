package biblioteca.demo.run;

import java.util.List;

import biblioteca.demo.util.Database;

public class LibroModel {
	
	Database db = new Database();
	
	public List<Object[]> LibroElegidoModel(int i) {
	
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
     								// a la base de datos
	
		String sql = "SELECT * FROM Libro WHERE ISBN = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql,i); 
		//ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return lista;
		
	}
	
	public List<Object[]> infoPrestamoModel(int j) {
		
		List<Object[]> tabla = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sqlPrestamo = "SELECT * FROM Prestamo WHERE ISBN = ?"; //crear el string que voy a ejecutar en la base de datos
		
		tabla = db.executeQueryArray(sqlPrestamo,j); 
		//ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return tabla;
	              	
	}
	
	public void confirmarNuevoModel(String ISBN,String titulo,String autor,String edicion,String categoria) {  //Insertar VALORES de un Libro NUEVO
		
		String sqlNuevo = "INSERT INTO Libro(ISBN,titulo,autor,añoEdicion,categoria) VALUES (?,?,?,?,?)";  
		
		db.executeUpdate(sqlNuevo,ISBN,titulo,autor,edicion,categoria); 
		
	}
	
	public void confirmarCambiosModel(String ISBN,String titulo,String autor,String edicion,String categoria) { //Modificar los VALORES del socio que hemos introducido
		
		String sqlCambios = "UPDATE Libro SET titulo = ?,autor = ?,añoEdicion = ?,categoria = ? WHERE ISBN = ?";
				
		db.executeUpdate(sqlCambios,ISBN,titulo,autor,edicion,categoria); 
		
	}
	
	public void EliminarLibroModel(String numLibro) {  //Eliminar el LIBRO que hemos seleccionado 
		
		String sqlBorrar = "DELETE FROM Libro WHERE numLibro = ?";
		
		db.executeUpdate(sqlBorrar,numLibro);

	}
	
}
