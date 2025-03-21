package biblioteca.demo.run;

import java.util.List;
import biblioteca.demo.run.LibroModel;
import biblioteca.demo.run.LibroView;


public class LibroController {
	
	private LibroModel model;
	private LibroView view;
	
	public void setVistaModel(LibroView v , LibroModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		//this.view.getFrame().setVisible(true);
	}

	public void LibroElegidoController(int ISBN) {
		//metodo para rellenar la tabla de articulos y pedidos
		
		List<Object[]> lista = model.LibroElegidoModel(ISBN);// pedirle al modelo los registros de DB correspondientes a la tabla libro con ISBN = a lo que le paso desde la vista.
		List<Object[]> tabla = model.infoPrestamoModel(ISBN);
		
		//en este momento, ya tengo en lista el resultado de la consulta a la DB
		// en este caso, como el resultado es unico, tendre una lista con un elemento, correspondiente a la posicion 0 de la lista (lista.getFirst() o lista.get(0))
		// este elemento de la lista, contiene un tipo Object[]. es un array de objetos (genericos)
		//como el resultado del select del modelo solamente me devuelve el titulo, en el object[] voy a tener un array de longitud 1
		
		//a continuacion creo una variable local que me va a permitir sacar la informacion del objeto contenido en la primera posicion de la lista que me devuelve el modelo.
		
		Object[] contenido = lista.getFirst(); // creo e inicializo la variable contenido
		Object[] contenidotabla = tabla.getFirst();
		
		this.view.gettextFieldTitulo().setText(contenido[1].toString()); // sacar la informacion que hay en la posicion 0 del array contenido que contiene el titulo que yo quiero mostrar 
		this.view.gettextFieldAutor().setText(contenido[2].toString());		
		this.view.gettextFieldEdicion().setText(contenido[3].toString());		
		this.view.gettextFieldCategoria().setText(contenido[4].toString());	
		
		for (int i=0; i<tabla.size();i++) {
			view.rellenaPrestamo(tabla.get(i));
		}
		
		
	};
	
	
	public LibroView getView() {
		return view;
	}

	public void setView(LibroView view) {
		this.view = view;
	}

	public LibroModel getModel() {
		return model;
	}

	public void setModel(LibroModel model) {
		this.model = model;
	}
}






