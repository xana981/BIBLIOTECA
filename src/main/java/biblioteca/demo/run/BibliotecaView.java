package biblioteca.demo.run;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JToggleButton;

import biblioteca.demo.run.*;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.TextField;

public class BibliotecaView {
	
	protected JFrame frmBiblioteca;
	
	public BibliotecaView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("REALIZAR PRÉSTAMO / DEVOLUCIÓN");
		btnNewButton_1.setBounds(27, 76, 383, 35);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrestamoView prestamo = new PrestamoView();	 //Cambio de pantalla
			}
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIÓN BIBLIOTECA");
		lblNewLabel.setBounds(58, 11, 325, 40);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblNewLabel);
		frmBiblioteca.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("LIBRO (Añadir, modificar...)");
		btnNewButton_3.setBounds(80, 122, 280, 35);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrosView libros = new LibrosView();	 //Cambio de pantalla
			}
		});
		frmBiblioteca.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SOCIO (Añadir, modificar...)");
		btnNewButton_4.setBounds(80, 168, 280, 35);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SociosView socios = new SociosView();	 //Cambio de pantalla
			}
		});
		frmBiblioteca.getContentPane().add(btnNewButton_4);
		
		JButton btnLogear = new JButton("Login");
		btnLogear.setBounds(158, 266, 98, 26);
		frmBiblioteca.getContentPane().add(btnLogear);
		
		JComboBox comboIsbnTrabajador = new JComboBox();
		comboIsbnTrabajador.setToolTipText("Trabajador");
		comboIsbnTrabajador.setMaximumRowCount(15);
		comboIsbnTrabajador.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboIsbnTrabajador.setEditable(true);
		comboIsbnTrabajador.setBounds(10, 227, 197, 26);
		frmBiblioteca.getContentPane().add(comboIsbnTrabajador);
		
		TextField textFieldContrasenia = new TextField();
		textFieldContrasenia.setText("< Introduce la contraseña >");
		textFieldContrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldContrasenia.setBounds(213, 226, 197, 27);
		frmBiblioteca.getContentPane().add(textFieldContrasenia);
	}
}
