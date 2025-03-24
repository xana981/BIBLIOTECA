package biblioteca.demo.run;

import java.util.List;

import biblioteca.demo.util.Database;

public class SocioModel {
	
	Database db = new Database();
	
	Database dbPrestamo = new Database();
	
	//Database dbLibro = new Database();

	
	public List<Object[]> SocioElegidoModel(int i) {
		
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql = "SELECT * FROM Socio WHERE numSocio = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql,i);  //ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return lista;
		
	}
	
	public List<Object[]> infoPrestamoModel(int j) {
		
		List<Object[]> tabla = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql1 = "SELECT * FROM Prestamo WHERE numSocio = ?"; //crear el string que voy a ejecutar en la base de datos
		
		tabla = dbPrestamo.executeQueryArray(sql1,j); 
		//ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return tabla;
	}
	
	/*public List<Object[]> infoLibro(int g) {
		
		List<Object[]> valor = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sqlValor = "SELECT Titulo FROM Libro WHERE ISBN = ?"; //crear el string que voy a ejecutar en la base de datos
		
		valor = dbLibro.executeQueryArray(sqlValor,g); 
		//ejecuta, pero devulelve una lista de objetos. 
		//sqlValor, el string que tiene la secuencia, g es el valor
		
		return valor;
	}*/
	

}
