package biblioteca.demo.run;

import java.util.List;
import biblioteca.demo.run.BibliotecaModel;
import biblioteca.demo.run.BibliotecaView;
/*import biblioteca.demo.run.PrestamoView;
import biblioteca.demo.run.SocioView;
import biblioteca.demo.run.LibroView;*/

public class BibliotecaController {
	
	private BibliotecaModel model;
	private BibliotecaView view;
	
/*	private PrestamoView view;
	private LibroView view;
	private SocioView view;*/
	
	public void setVistaModel(BibliotecaView v , BibliotecaModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		
		//this.view.getFrame().setVisible(true);
	}

	//a partir de aqui, implementamos los metodos de las funcionalidades correspondientes
	

	
	public BibliotecaView getView() {
		return view;
	}

	public void setView(BibliotecaView view) {
		this.view = view;
	}

	public BibliotecaModel getModel() {
		return model;
	}

	public void setModel(BibliotecaModel model) {
		this.model = model;
	}
	
	
/*	public PrestamoView getView() {
		return view;
	}

	public void setView(PrestamoView view) {
		this.view = view;
	}

	public BibliotecaModel getModel() {
		return model;
	}

	public void setModel(BibliotecaModel model) {
		this.model = model;
	}*/
}


