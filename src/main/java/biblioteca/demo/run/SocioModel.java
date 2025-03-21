package biblioteca.demo.run;

import java.util.List;

import biblioteca.demo.util.Database;

public class SocioModel {
	
	Database db = new Database();

	
	public List<Object[]> SocioElegidoModel(int i) {
		
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql = "SELECT * FROM Socio WHERE numSocio = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql,i);  //ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return lista;
		
	}

}
