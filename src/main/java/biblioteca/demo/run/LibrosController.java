package biblioteca.demo.run;

import java.util.List;
import biblioteca.demo.run.LibrosModel;
import biblioteca.demo.run.LibrosView;


public class LibrosController {
	
	private LibrosModel model;
	private LibrosView view;
	
	public void setVistaModel(LibrosView v , LibrosModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		//this.view.getFrame().setVisible(true);
	}

	public LibrosView getView() {
		return view;
	}

	public void setView(LibrosView view) {
		this.view = view;
	}

	public LibrosModel getModel() {
		return model;
	}

	public void setModel(LibrosModel model) {
		this.model = model;
	}
}
