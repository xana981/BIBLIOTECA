package biblioteca.demo.run;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import biblioteca.demo.run.SocioModel;
import biblioteca.demo.run.SocioView;


public class SocioController {
	
	private SocioModel model;
	private SocioView view;
	
	public void setVistaModel(SocioView v , SocioModel m) {
		this.model = m;
		this.view = v;
	}
	
	
	public void SocioElegidoController(int numSocio) {
		//metodo para rellenar la tabla de articulos y pedidos
		
		List<Object[]> lista = model.SocioElegidoModel(numSocio);// pedirle al modelo los registros de DB correspondientes a la tabla libro con ISBN = a lo que le paso desde la vista.
		List<Object[]> tabla = model.infoPrestamoModel(numSocio);
		
		if (lista.size()==0) {      //Rellena tabla SOLO si el tamaño de la tabla es distinto a 0 (No hay datos)
			JOptionPane.showMessageDialog(null, "El socio que has introducido no existe");
		}
		
				
		//en este momento, ya tengo en lista el resultado de la consulta a la DB
		// en este caso, como el resultado es unico, tendre una lista con un elemento, correspondiente a la posicion 0 de la lista (lista.getFirst() o lista.get(0))
		// este elemento de la lista, contiene un tipo Object[]. es un array de objetos (genericos)
		//como el resultado del select del modelo solamente me devuelve el titulo, en el object[] voy a tener un array de longitud 1
		
		//a continuacion creo una variable local que me va a permitir sacar la informacion del objeto contenido en la primera posicion de la lista que me devuelve el modelo.
		
		else {
			Object[] contenido = lista.getFirst();  //creo e inicializo la variable contenido
			
			if (tabla.size()!=0) {      //Rellena tabla si el tamaño de la tabla es distinto a 0
				Object[] contenidotabla = tabla.get(0);
			}
			
			this.view.gettextFieldNombre().setText(contenido[1].toString()); // sacar la informacion que hay en la posicion 0 del array contenido que contiene el titulo que yo quiero mostrar 
			this.view.gettextFieldTrabajador().setText(contenido[2].toString());	
			this.view.gettextFieldNacimiento().setText(contenido[3].toString());		
			this.view.gettextFieldInfo().setText(contenido[4].toString());

			for (int i=0; i<(tabla.size());i++) {
				view.rellenaPrestamo(tabla.get(i));   
			}
		}
	};
	
	public void confirmarNuevoController() {  ///int numSocio,String nombreCompleto,String esTrabajador,String fechaNac,String masInfo
	
		int n = JOptionPane.showConfirmDialog(null,"¿Estas seguro de DAR el ALTA?","Advertencia",JOptionPane.YES_NO_OPTION); //Pregunta si estamos seguros del cambio
		if (n==0) {//Si la respuesta es SI, tiene que subir los datos a la base de dato
			
			String numSocio; //Se crean la variable	
			String nombreCompleto;
			String esTrabajador;
			String fechaNac;
			String masInfo;
		
			numSocio = this.view.gettextPaneSocio().getText();   //Recogemos los datos de los cuadros para enviarlos a la base de datos
			nombreCompleto = this.view.gettextFieldNombre().getText(); 
			esTrabajador = this.view.gettextFieldTrabajador().getText().toString(); 
			fechaNac = this.view.gettextFieldNacimiento().getText().toString();
			masInfo = this.view.gettextFieldInfo().getText().toString();
	
			this.model.confirmarNuevoModel(numSocio,nombreCompleto,esTrabajador,fechaNac,masInfo); //Llamamos a la funcion creada en modelo para que nos pase la info guardada de los cuadros
			
			JOptionPane.showMessageDialog(null, "El alta de SOCIO nuevo se he generado correctamente");  //Cuadro de aviso informando del cambio
			
			this.view.frmSocio.setVisible(false);
			BibliotecaController controlador = new BibliotecaController();
			controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
		}
	};
		
	public void ConfirmarCambiosController() {
		int n = JOptionPane.showConfirmDialog(null,"¿Estas seguro de CONFIRMAR los cambios?","Advertencia",JOptionPane.YES_NO_OPTION);
		
		if(n==0) {    //Si la respuesta es SI, tiene que subir los datos a la base de datos
			String numSocio; //Se crean las variables
			String nombreCompleto; 
			String esTrabajador;
			String fechaNac;
			String masInfo;
			
			numSocio = this.view.gettextPaneSocio().getText();   //Recogemos los datos de los cuadros para enviarlos a la base de datos
			nombreCompleto = this.view.gettextFieldNombre().getText(); 
			esTrabajador = this.view.gettextFieldTrabajador().getText().toString(); 
			fechaNac = this.view.gettextFieldNacimiento().getText().toString();
			masInfo = this.view.gettextFieldInfo().getText().toString();
			
			this.model.confirmarCambiosModel(numSocio,nombreCompleto,esTrabajador,fechaNac,masInfo);  
			
			JOptionPane.showMessageDialog(null, "Los cambios se han realizado  correctamente");	 
			
			this.view.frmSocio.setVisible(false);
			BibliotecaController controlador = new BibliotecaController();
			controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());	
		}
	};
	
	public void EliminarSocioController(String numSocio) {
		int n = JOptionPane.showConfirmDialog(null,"¿Estas seguro de ELIMINAR registro seleccionado?","Advertencia",JOptionPane.YES_NO_OPTION);

		numSocio = this.view.gettextPaneSocio().getText();
		if(n==0) {
			this.model.EliminarSocioModel(numSocio);
		}
		
		JOptionPane.showMessageDialog(null, "Se ha eliminado el SOCIO correctamente");
		
		this.view.frmSocio.setVisible(false);
		BibliotecaController controlador = new BibliotecaController();
		controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
	}
	
	
	public SocioView getView() {
		return view;
	}

	public void setView(SocioView view) {
		this.view = view;
	}

	public SocioModel getModel() {
		return model;
	}

	public void setModel(SocioModel model) {
		this.model = model;
	}
}
