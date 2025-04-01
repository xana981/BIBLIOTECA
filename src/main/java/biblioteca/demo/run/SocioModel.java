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
	
	
	
	
	public void confirmarNuevoModel(String num,String nombre,String trabaja,String fecha,String info) {  //Insertar VALORES de un socio NUEVO
		
		String sqlNuevo = "INSERT INTO Socio(numSocio,nombreCompleto,esTrabajador,fechaNac,masInfo) VALUES (?,?,?,?,?)";  
		
		db.executeUpdate(sqlNuevo,num,nombre,trabaja,fecha,info); 
		
	}
	
		
	public void ConfirmarCambiosModel(int num,String nombre,String trabaja,int fecha,String info) {
		
		String sqlCambios = "UPDATE Socio SET (nombreCompleto = ?,esTrabajador = ?,fechaNac = ?,masInfo = ?) WHERE numSocio = ?";
		
		db.executeUpdate(sqlCambios,nombre,trabaja,fecha,info,num); 
		
	}
	
	public void EliminarSocioModel(String numSocio) {
		
		String sqlBorrar = "DELETE FROM Socio WHERE numSocio = ?";
		
		db.executeUpdate(sqlBorrar,numSocio);

	}

}
