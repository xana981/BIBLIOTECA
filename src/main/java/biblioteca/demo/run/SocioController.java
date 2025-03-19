package biblioteca.demo.run;

import java.util.List;
import biblioteca.demo.run.SocioModel;
import biblioteca.demo.run.SocioView;


public class SocioController {
	
	private SocioModel model;
	private SocioView view;
	
	public void setVistaModel(SocioView v , SocioModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		//this.view.getFrame().setVisible(true);
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
