package biblioteca.demo.run;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

import biblioteca.demo.run.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class LoginView {
	
	protected JFrame frmLogin;
	private JPasswordField passwordFieldContra;
	
	public LoginView() {
		inicialize();

	}
	
	private void inicialize() {
		
		frmLogin = new JFrame();
		frmLogin.setSize(new Dimension(286, 229));
		frmLogin.setResizable(false);
		frmLogin.setVisible(true);
		frmLogin.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmLogin.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmLogin.getContentPane().setLayout(null);
		
		JTextPane textPaneUsuario = new JTextPane();
		textPaneUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneUsuario.setBounds(86, 64, 144, 27);
		frmLogin.getContentPane().add(textPaneUsuario);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 128, 192));
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblLogin.setBounds(91, 13, 71, 40);
		frmLogin.getContentPane().add(lblLogin);
	
		
		passwordFieldContra = new JPasswordField();
		passwordFieldContra.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passwordFieldContra.setBounds(86, 104, 134, 25);
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
		btnVerContra.setBounds(230, 104, 25, 25);
		frmLogin.getContentPane().add(btnVerContra);
		
		JButton btnLogin = new JButton("Entrar"); //Cuando se pulsa sobre el botón "Login" se comprueba contraseña y si es correcta abre BibliotecaView, sino IncorrectaView
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Creamos las Variables y el Método para validar los campos usuario y contraseña//
				String usuariomin =" ";
				String usuario = " ";
				char pase[]=passwordFieldContra.getPassword();
				String pass  =new String(pase);
				usuariomin = textPaneUsuario.getText();
				usuario = usuariomin.toUpperCase();

				/*Asignamos el nombre de usuario y contraseña que queramos//
				En este caso Usuario = jose / juan y Pass=1234*/

				if(usuario.equals("JOSE") && pass.equals("1234"))
				{
					BibliotecaView biblioteca = new BibliotecaView();	 //Cambio a la pantalla Biblioteca
					frmLogin.setVisible(false);
				}
				else if(usuario.equals("JUAN") && pass.equals("1234"))
				{
					BibliotecaView biblioteca = new BibliotecaView();	 //Cambio a la pantalla Biblioteca
					frmLogin.setVisible(false);
				}
				else if(usuario.equals("1") && pass.equals("1"))
				{
					BibliotecaView biblioteca = new BibliotecaView();	 //Cambio a la pantalla Biblioteca
					frmLogin.setVisible(false);
				}
				else
				{
					passwordFieldContra.setText(null);
					IncorrectaView incorrecta = new IncorrectaView();	 //Cambio a la pantalla Incorrecta
				}
			}
		});
				
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogin.setBounds(78, 143, 87, 26);
		frmLogin.getContentPane().add(btnLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsuario.setBounds(26, 64, 50, 27);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Contraseña");
		lblClave.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClave.setBounds(10, 104, 66, 27);
		frmLogin.getContentPane().add(lblClave);
		
	}
}