package biblioteca.demo.run;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import biblioteca.demo.run.*;

import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;

import java.awt.TextField;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class BibliotecaView {
	
	protected JFrame frmBiblioteca;
	private JPasswordField passwordFieldClave;
	
	public BibliotecaView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.setSize(new Dimension(484, 343));
		frmBiblioteca.setResizable(false);
		frmBiblioteca.setVisible(true);
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		

		
		/*JButton btnVerClaves = new JButton("");
		btnVerClaves.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-ojo-24.png"));
		btnVerClaves.setBounds(282, 288, 25, 25);
		btnVerClaves.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { //Cuando se pulsa que aparezca la contraseña
				passwordFieldClave.setEchoChar((char)0); 
			}
			@Override
			public void mouseReleased(MouseEvent e) { //Cuando se suelta desaparezca nuevamente
				passwordFieldClave.setEchoChar('•');
			}
		});
		frmBiblioteca.getContentPane().add(btnVerClaves);*/
				
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
				PrestamoView prestamo = new PrestamoView();	 //Cambio de pantalla
				frmBiblioteca.setVisible(false);
			}
		});
		frmBiblioteca.getContentPane().add(btnBiblioteca);
		frmBiblioteca.getContentPane().setLayout(null);
		
		
		JButton btnLibro = new JButton("LIBRO (Añadir, modificar...)");
		btnLibro.setBounds(89, 143, 267, 35);
		btnLibro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrosView libros = new LibrosView();	 //Cambio de pantalla
				frmBiblioteca.setVisible(false);
			}
		});
		frmBiblioteca.getContentPane().add(btnLibro);
		
		JButton btnSocio = new JButton("SOCIO (Añadir, modificar...)");
		btnSocio.setBounds(88, 203, 268, 35);
		btnSocio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SociosView socios = new SociosView();	 //Cambio de pantalla
				frmBiblioteca.setVisible(false);
			}
		});
		frmBiblioteca.getContentPane().add(btnSocio);
		
	
		
		JButton btnSalir = new JButton("Salir"); //Boton "Salir" retrocede al menu Login
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView login = new LoginView();	 //Cambio a la pantalla al logeo
				frmBiblioteca.setVisible(false);
			}
		});
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.setBounds(386, 265, 70, 27);
		
		
		frmBiblioteca.getContentPane().add(btnSalir);


		
	}
}
