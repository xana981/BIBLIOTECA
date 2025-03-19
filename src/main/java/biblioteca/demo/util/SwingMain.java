package biblioteca.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import biblioteca.demo.run.LoginView;
import biblioteca.demo.run.LoginController;
import biblioteca.demo.run.LoginModel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;



/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(new Dimension(600, 200));
		frame.setTitle("Main");
		frame.setBounds(0, 0, 287, 185);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("ACCEDER AL LOGIN");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { //evento de pulsar el boton y me abre la vista
				LoginController controlador = new LoginController();
				controlador.setVistaModel(new LoginView(controlador), new LoginModel());
			} 
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
		Database db=new Database(); //creo la base de datos de prueba
		
		db.createDatabase(false); //le paso el valor falso porque considero que no esta creada aun
		db.loadDatabase(); //cargo datos de prueba
		
	}
		
	public JFrame getFrame() { return this.frame; }
	

	
}
