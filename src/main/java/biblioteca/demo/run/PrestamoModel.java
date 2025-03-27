package biblioteca.demo.run;

import java.util.List;

import biblioteca.demo.util.Database;

public class PrestamoModel {
	
	Database db = new Database();
	
	public List<Object[]> SocioElegidoPModel(int i) {
		
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql = "SELECT * FROM Socio WHERE numSocio = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql,i);  //ejecuta, pero devuelve una lista de objetos. 
												//sql, el string que tiene la secuencia, i es el valor
		return lista;
		
	}
	
	public List<Object[]> infoPrestamoModel(int j) {
		
		List<Object[]> tabla = null;    //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
										// a la base de datos
		String sqlPrestamo = "SELECT * FROM Prestamo WHERE numSocio = ?"; //crear el string que voy a ejecutar en la base de datos
		
		tabla = db.executeQueryArray(sqlPrestamo,j); 

		return tabla;
	}
	
	public List<Object[]> LibroPrestadoModel(int p) {
		
		List<Object[]> libroPrestado = null;		
	
		String sqlPrestado = "SELECT * FROM Prestamo WHERE ISBN = ?";
		
		libroPrestado = db.executeQueryArray(sqlPrestado,p);

		return libroPrestado;
	}
	
	
	public List<Object[]> LibroElegidoModel(int ISBN) {
		
		List<Object[]> tituloLibro = null;
		
		String sqlLibro = "SELECT * FROM Libro WHERE ISBN = ?";
		
		tituloLibro = db.executeQueryArray(sqlLibro,ISBN); 
		
		return tituloLibro;
	}
	
}
	

