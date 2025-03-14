package biblioteca.demo.run;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import biblioteca.demo.run.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView {
	
	protected JFrame frmLogin;
	private JPasswordField passwordFieldContra;
	
	public LoginView() {
		inicialize();

	}
	
	private void inicialize() {
		
		frmLogin = new JFrame();
		frmLogin.setSize(new Dimension(271, 229));
		frmLogin.setResizable(false);
		frmLogin.setVisible(true);
		frmLogin.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmLogin.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmLogin.getContentPane().setLayout(null);
	
	
		JComboBox comboTrabajador = new JComboBox();
		comboTrabajador.setBounds(22, 64, 215, 27);
		comboTrabajador.setToolTipText("");
		comboTrabajador.setMaximumRowCount(15);
		comboTrabajador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboTrabajador.setEditable(true);
		
		frmLogin.getContentPane().add(comboTrabajador);
		
		// Creacion del JComboBox y añadir los items.
		comboTrabajador.addItem(" ");
		comboTrabajador.addItem("Trabajador 1");
		comboTrabajador.addItem("Trabajador 2");
		comboTrabajador.addItem("Trabajador 3");	
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 128, 192));
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblLogin.setBounds(91, 13, 71, 40);
		frmLogin.getContentPane().add(lblLogin);
	
		
		passwordFieldContra = new JPasswordField();
		passwordFieldContra.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordFieldContra.setBounds(51, 104, 134, 25);
		char[] entracontra = passwordFieldContra.getPassword();
		frmLogin.getContentPane().add(passwordFieldContra);
		
		JButton btnVerContra = new JButton("");
		btnVerContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordFieldContra.setEchoChar((char)0); 
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				passwordFieldContra.setEchoChar('●'); 				
			}
		});
		btnVerContra.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-ojo-24.png"));
		btnVerContra.setBounds(195, 104, 25, 25);
		frmLogin.getContentPane().add(btnVerContra);
		
		JButton btnLogin = new JButton("Entrar"); //Cuando se pulsa sobre el botón "Login" se comprueba contraseña y si es correcta abre BibliotecaView, sino IncorrectaView
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ComprobarContra(entracontra) == true)
				{
					BibliotecaView biblioteca = new BibliotecaView();	 //Cambio a la pantalla Biblioteca
					frmLogin.setVisible(false);
				}
				else
				{
					passwordFieldContra.setText(null);
					IncorrectaView incorrecto = new IncorrectaView();	 //Cambio a la pantalla Incorrecta
				}
			}
		});
		
		btnLogin.setBounds(78, 143, 87, 26);
		frmLogin.getContentPane().add(btnLogin);
		
	}
	public static boolean ComprobarContra(char[]entracontra)
	{
		char[]contracorrecta = new char[] {'1','2','3','4'};
		if (entracontra.length != contracorrecta.length)
			return false;
		else
			return true;			
			/*for (int i=0; i < entracontra.length; i++)
			{
				if (entracontra[i] != contracorrecta[i])
				{	
					return true;
				}	
			}*/

		
	}
}
