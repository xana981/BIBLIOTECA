package biblioteca.demo.run;

import java.util.List;

import biblioteca.demo.util.Database;

public class BibliotecaModel {
	
	Database db = new Database();

	public List<Object[]> AniadirArticulosPedido(int i) {
		// TODO Auto-generated method stub
		List<Object[]> lista = null;
		
		String sql = "SELECT * FROM ARTICULOPEDIDO WHERE IDPEDIDO = ?";
		
		lista = db.executeQueryArray(sql, i);
		
		return lista;
	}
}
