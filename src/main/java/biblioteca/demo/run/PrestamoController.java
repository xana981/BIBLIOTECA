package biblioteca.demo.run;

import java.awt.TextField;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import biblioteca.demo.run.PrestamoModel;
import biblioteca.demo.run.PrestamoView;


public class PrestamoController {
	
	private PrestamoModel model;
	private PrestamoView view;
	
	public void setVistaModel(PrestamoView v , PrestamoModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		//this.view.getFrame().setVisible(true);
	}
	
	public void SocioElegidoPController(int numSocio) {
		//metodo para rellenar la tabla de articulos y pedidos
		
		List<Object[]> lista = model.SocioElegidoPModel(numSocio);// pedirle al modelo los registros de DB correspondientes a la tabla libro con ISBN = a lo que le paso desde la vista.
		List<Object[]> tabla = model.infoPrestamoModel(numSocio);
		
		/*en este momento, ya tengo en lista el resultado de la consulta a la DB
		 en este caso, como el resultado es unico, tendre una lista con un elemento, correspondiente a la posicion 0 de la lista (lista.getFirst() o lista.get(0))
		 este elemento de la lista, contiene un tipo Object[]. es un array de objetos (genericos)
		 como el resultado del select del modelo solamente me devuelve el titulo, en el object[] voy a tener un array de longitud 1
		 a continuacion creo una variable local que me va a permitir sacar la informacion del objeto contenido en la primera posicion de la lista que me devuelve el modelo.*/
		
		if (lista.size()==0) {      //Rellena tabla SOLO si el tamaño de la tabla es distinto a 0 (No hay datos)
			JOptionPane.showMessageDialog(null, "El socio que has introducido no existe");
		}
		else {
			Object[] contenido = lista.getFirst();  //creo e inicializo la variable contenido
			
			if (tabla.size()!=0) {      //Rellena tabla si el tamaño de la tabla es distinto a 0
				Object[] contenidotabla = tabla.get(1);
			}
			
			this.view.gettextFieldNombre().setText(contenido[1].toString()); // sacar la informacion que hay en la posicion 0 del array contenido que contiene el titulo que yo quiero mostrar 
			this.view.gettextFieldNacimiento().setText(contenido[3].toString());		
			
			for (int i=0; i<(tabla.size());i++) {
				view.rellenaPrestamo(tabla.get(i));   
			}
		}
	};
	
	public void LibroElegidoController(int ISBN) {
		
		List<Object[]> tituloLibro = model.LibroElegidoModel(ISBN);// pedirle al modelo los registros de DB correspondientes a la tabla libro con ISBN = a lo que le paso desde la vista.
		List<Object[]> libroPrestado = model.LibroPrestadoModel(ISBN);
		
		if (tituloLibro.size()==0) {      //Rellena tabla SOLO si el tamaño de la tabla es distinto a 0 (No hay datos)
			JOptionPane.showMessageDialog(null, "El libro que has introducido no existe");
		}
		else {
			Object[] contenidoLibro = tituloLibro.getFirst();  //creo e inicializo la variable contenido
			
			this.view.gettextFieldTitulo().setText(contenidoLibro[1].toString()); //contenido que tiene titulo y que yo quiero mostrar 
		}
		if (libroPrestado.size()==0) {      //Rellena tabla SOLO si el tamaño de la tabla es distinto a 0 (No hay datos)
			this.view.gettextFieldPrestado().setText("No".toString());
			
			this.view.enabledrdbtn15().setEnabled(true);
			this.view.enabledrdbtn30().setEnabled(true);
		}
		else {
			this.view.gettextFieldPrestado().setText("Si".toString());

		}
		

	};
	
	public void ConfirmarPrestamoController(int ISBN,int numSocio) {
		List<Object[]> confirmarPrestado = model.LibroPrestadoModel(ISBN);
		
		Object[] contenidoPrestado = confirmarPrestado.getFirst();
		
	//	if (numSocio == contenidoPrestado[1]) {
	//		
	//	}
		
	}
	
	

	public PrestamoView getView() {
		return view;
	}

	public void setView(PrestamoView view) {
		this.view = view;
	}

	public PrestamoModel getModel() {
		return model;
	}

	public void setModel(PrestamoModel model) {
		this.model = model;
	}
}
