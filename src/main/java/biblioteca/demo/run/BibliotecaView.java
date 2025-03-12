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

public class BibliotecaView {
	
	protected JFrame frmBiblioteca;
	
	public BibliotecaView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.setSize(new Dimension(464, 407));
		frmBiblioteca.setResizable(false);
		frmBiblioteca.setVisible(true);
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("REALIZAR PRÉSTAMO / DEVOLUCIÓN");
		btnNewButton_1.setBounds(33, 84, 377, 35);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrestamoView prestamo = new PrestamoView();	 //Cambio de pantalla
				frmBiblioteca.setVisible(false);
			}
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIÓN BIBLIOTECA");
		lblNewLabel.setBounds(72, 23, 312, 40);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblNewLabel);
		frmBiblioteca.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("LIBRO (Añadir, modificar...)");
		btnNewButton_3.setBounds(89, 131, 267, 35);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrosView libros = new LibrosView();	 //Cambio de pantalla
				frmBiblioteca.setVisible(false);
			}
		});
		frmBiblioteca.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SOCIO (Añadir, modificar...)");
		btnNewButton_4.setBounds(89, 184, 268, 35);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SociosView socios = new SociosView();	 //Cambio de pantalla
				frmBiblioteca.setVisible(false);
			}
		});
		frmBiblioteca.getContentPane().add(btnNewButton_4);
		
		TextField textFieldContrasenia = new TextField();
		textFieldContrasenia.setBounds(130, 282, 178, 26);
		textFieldContrasenia.setText("< Introduce la contraseña >");
		textFieldContrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmBiblioteca.getContentPane().add(textFieldContrasenia);
		
		JComboBox comboIsbnTrabajador = new JComboBox();
		comboIsbnTrabajador.setBounds(116, 249, 215, 27);
		comboIsbnTrabajador.setToolTipText("Trabajador");
		comboIsbnTrabajador.setMaximumRowCount(15);
		comboIsbnTrabajador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboIsbnTrabajador.setEditable(true);
		frmBiblioteca.getContentPane().add(comboIsbnTrabajador);
		
		JButton btnLogear = new JButton("Login");
		btnLogear.setBounds(193, 314, 65, 26);
		frmBiblioteca.getContentPane().add(btnLogear);
	}
}
