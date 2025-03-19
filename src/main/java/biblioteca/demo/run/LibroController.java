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
