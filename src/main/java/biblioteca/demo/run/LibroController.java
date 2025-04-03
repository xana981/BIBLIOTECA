package biblioteca.demo.run;

import java.util.List;
import biblioteca.demo.run.LibroModel;
import biblioteca.demo.run.LibroView;
import javax.swing.JOptionPane;

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
		
		if (lista.size()==0) {      //Rellena tabla si el tamaño de la tabla es distinto a 0
			JOptionPane.showMessageDialog(null, "El ISBN que has introducido no existe");
		}
		else {
			//en este momento, ya tengo en lista el resultado de la consulta a la DB
			// en este caso, como el resultado es unico, tendre una lista con un elemento, correspondiente a la posicion 0 de la lista (lista.getFirst() o lista.get(0))
			// este elemento de la lista, contiene un tipo Object[]. es un array de objetos (genericos)
			//como el resultado del select del modelo solamente me devuelve el titulo, en el object[] voy a tener un array de longitud 1
			
			//a continuacion creo una variable local que me va a permitir sacar la informacion del objeto contenido en la primera posicion de la lista que me devuelve el modelo.
			
			Object[] contenido = lista.getFirst();  //creo e inicializo la variable contenido
			if (tabla.size()!=0) {      //Rellena tabla si el tamaño de la tabla es distinto a 0
				Object[] contenidotabla = tabla.get(0);
			}
			this.view.gettextFieldTitulo().setText(contenido[1].toString()); // sacar la informacion que hay en la posicion 0 del array contenido que contiene el titulo que yo quiero mostrar 
			this.view.gettextFieldAutor().setText(contenido[2].toString());		
			this.view.gettextFieldEdicion().setText(contenido[3].toString());		
			this.view.gettextFieldCategoria().setText(contenido[4].toString());	
	
			for (int i=0; i<=(tabla.size());i++) {
				view.rellenaPrestamo(tabla.get(i));   
			}
		}
	};
	
	public void confirmarNuevoController() {  ///int numSocio,String nombreCompleto,String esTrabajador,String fechaNac,String masInfo
		
		int n = JOptionPane.showConfirmDialog(null,"¿Estas seguro de DAR el ALTA?","Advertencia",JOptionPane.YES_NO_OPTION); //Pregunta si estamos seguros del cambio
		
		if (n==0) {//Si la respuesta es SI, tiene que subir los datos a la base de dato
			
			String ISBN; //Se crean las variables			
			String Titulo; 
			String Autor; 
			String Edicion;
			String Categoria;
		
			ISBN = this.view.gettextPaneLibro().getText();   //Recogemos los datos de los cuadros para enviarlos a la base de datos
			Titulo = this.view.gettextFieldTitulo().getText(); 
			Autor = this.view.gettextFieldAutor().getText().toString(); 
			Edicion = this.view.gettextFieldEdicion().getText().toString();
			Categoria = this.view.gettextFieldCategoria().getText().toString();
	
			this.model.confirmarNuevoModel(ISBN,Titulo,Autor,Edicion,Categoria); //Llamamos a la funcion creada en modelo para que nos pase la info guardada de los cuadros
			
			JOptionPane.showMessageDialog(null, "El alta de LIBRO nuevo se he generado correctamente");  //Cuadro de aviso informando del cambio
			
			this.view.frmLibro.setVisible(false);
			BibliotecaController controlador = new BibliotecaController();
			controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
		}
	};
	
	public void ConfirmarCambiosController() {
		int n = JOptionPane.showConfirmDialog(null,"¿Estas seguro de CONFIRMAR los cambios?","Advertencia",JOptionPane.YES_NO_OPTION);
		
		if(n==0) {    //Si la respuesta es SI, tiene que subir los datos a la base de datos
			
			String ISBN; //Se crean las variables			
			String Titulo; 
			String Autor; 
			String Edicion;
			String Categoria;
			
			ISBN = this.view.gettextPaneLibro().getText();   //Recogemos los datos de los cuadros para enviarlos a la base de datos
			Titulo = this.view.gettextFieldTitulo().getText(); 
			Autor = this.view.gettextFieldAutor().getText().toString(); 
			Edicion = this.view.gettextFieldEdicion().getText().toString();
			Categoria = this.view.gettextFieldCategoria().getText().toString();
			
			this.model.confirmarCambiosModel(ISBN,Titulo,Autor,Edicion,Categoria);  
			
			JOptionPane.showMessageDialog(null, "Los cambios se han realizado correctamente");	 
			
			this.view.frmLibro.setVisible(false);
			BibliotecaController controlador = new BibliotecaController();
			controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());	
		}
	};
	
	public void EliminarSocioController(String numLibro) {
		
		int n = JOptionPane.showConfirmDialog(null,"¿Estas seguro de ELIMINAR registro seleccionado?","Advertencia",JOptionPane.YES_NO_OPTION);

		numLibro = this.view.gettextPaneLibro().getText();
		
		if(n==0) {
			this.model.EliminarLibroModel(numLibro);
		}
		
		JOptionPane.showMessageDialog(null, "Se ha eliminado el LIBRO correctamente");
		
		this.view.frmLibro.setVisible(false);
		BibliotecaController controlador = new BibliotecaController();
		controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
	}
		
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




