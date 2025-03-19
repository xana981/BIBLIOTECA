package biblioteca.demo.run;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import javax.swing.JPasswordField;


public class BibliotecaView {
	
	protected JFrame frmBiblioteca;
	private JPasswordField passwordFieldClave;
	private BibliotecaController controlador;
	
	public BibliotecaView(BibliotecaController c) {
		inicialize(c);
	}
	
	private void inicialize(BibliotecaController c) {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.setSize(new Dimension(484, 343));
		frmBiblioteca.setResizable(false);
		frmBiblioteca.setVisible(true);
		frmBiblioteca.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {
		controlador=c;
		}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("GESTIÓN BIBLIOTECA");
		lblNewLabel.setBounds(72, 23, 312, 40);
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblNewLabel);

		JButton btnBiblioteca = new JButton("REALIZAR PRÉSTAMO / DEVOLUCIÓN");
		btnBiblioteca.setBounds(33, 84, 377, 35);
		btnBiblioteca.setForeground(new Color(0, 0, 0));
		btnBiblioteca.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBiblioteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBiblioteca.setVisible(false);
				PrestamoController controlador = new PrestamoController();
				controlador.setVistaModel(new PrestamoView(controlador), new PrestamoModel());
			}
		});
		frmBiblioteca.getContentPane().add(btnBiblioteca);
		frmBiblioteca.getContentPane().setLayout(null);
		
		
		JButton btnLibro = new JButton("LIBRO (Añadir, modificar...)");
		btnLibro.setBounds(89, 143, 267, 35);
		btnLibro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBiblioteca.setVisible(false);
				LibroController controlador = new LibroController();
				controlador.setVistaModel(new LibroView(controlador), new LibroModel());
			}
		});
		frmBiblioteca.getContentPane().add(btnLibro);
		
		JButton btnSocio = new JButton("SOCIO (Añadir, modificar...)");
		btnSocio.setBounds(88, 203, 268, 35);
		btnSocio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBiblioteca.setVisible(false);
				SocioController controlador = new SocioController();
				controlador.setVistaModel(new SocioView(controlador), new SocioModel());
			}
		});
		frmBiblioteca.getContentPane().add(btnSocio);
		
		JButton btnSalir = new JButton("Salir"); //Boton "Salir" retrocede al menu Login
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBiblioteca.setVisible(false);
				LoginController controlador = new LoginController();
				controlador.setVistaModel(new LoginView(controlador), new LoginModel());
			}
		});
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.setBounds(386, 265, 70, 27);
		
		frmBiblioteca.getContentPane().add(btnSalir);
		
	}
}
