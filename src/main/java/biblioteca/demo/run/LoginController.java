package biblioteca.demo.run;

import java.util.List;
import biblioteca.demo.run.LoginModel;
import biblioteca.demo.run.LoginView;


public class LoginController {
	
	private LoginModel model;
	private LoginView view;
	
	public void setVistaModel(LoginView v , LoginModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		//this.view.getFrame().setVisible(true);
	}

	public LoginView getView() {
		return view;
	}

	public void setView(LoginView view) {
		this.view = view;
	}

	public LoginModel getModel() {
		return model;
	}

	public void setModel(LoginModel model) {
		this.model = model;
	}
}
