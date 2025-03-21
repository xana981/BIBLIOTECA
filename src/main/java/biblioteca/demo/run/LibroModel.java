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
		
		return lista;
		
	}

}
