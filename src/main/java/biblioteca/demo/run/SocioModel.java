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
	
	public List<Object[]> infoPrestamoModel(int j) {
		
		List<Object[]> tabla = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql1 = "SELECT * FROM Prestamo WHERE numSocio = ?"; //crear el string que voy a ejecutar en la base de datos
		
		tabla = db.executeQueryArray(sql1,j); 
		//ejecuta, pero devulelve una lista de objetos. 
		//sql, el string que tiene la secuencia, i es el valor
		
		return tabla;
	}
	
	public List<Object[]> AniadirNuevoModel (int num,String nombre,String trabaja,int fecha,String info) {  //Insertar VALORES socio NUEVO
		
		List<Object[]> nuevo = null; 							
		
		String sqlNuevo = "INSERT INTO Socio(numSocio,nombreCompleto,esTrabajador,fechaNac,masInfo) VALUES (?,?,?,?,?)";

		nuevo = db.executeQueryArray(sqlNuevo,num,nombre,trabaja,fecha,info); 
		
		return nuevo;
	}
	
	
	public List<Object[]> ConfirmarCambios(int num,String nombre,String trabaja,int fecha,String info) {
		
		List<Object[]> cambios = null; 							
		
		String sqlCambios = "UPDATE Socio SET (numSocio = ?,nombreCompleto = ?,esTrabajador = ?,fechaNac = ?,masInfo = ?) WHERE numSocio = ?";
		
		cambios = db.executeQueryArray(sqlCambios,num,nombre,trabaja,fecha,info); 
		
		return cambios;
	}
	

}
