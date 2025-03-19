package biblioteca.demo.run;

import java.util.List;
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
