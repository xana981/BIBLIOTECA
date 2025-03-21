package biblioteca.demo.run;

import java.util.List;

import biblioteca.demo.util.Database;

public class LibroModel {
	
	Database db = new Database();
	
	Database db1 = new Database();


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
		
		String sql1 = "SELECT * FROM Prestamo WHERE ISBN = ?"; //crear el string que voy a ejecutar en la base de datos
		
		tabla = db1.executeQueryArray(sql1,j); 
		//ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return tabla;
		
	}

}
