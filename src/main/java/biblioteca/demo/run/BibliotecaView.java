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

import biblioteca.demo.run.PrestamoView;
import biblioteca.demo.run.DevolucionView;
import biblioteca.demo.run.SociosView;
import biblioteca.demo.run.LibrosView;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("REALIZAR PRÉSTAMO");
		btnNewButton_1.setBounds(80, 60, 280, 35);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrestamoView prestamo = new PrestamoView();	 //Cambio de pantalla
			}
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIÓN BIBLIOTECA");
		lblNewLabel.setBounds(58, 10, 325, 40);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblNewLabel);
		frmBiblioteca.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REALIZAR DEVOLUCIÓN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DevolucionView devolucion = new DevolucionView();	 //Cambio de pantalla
			}
		});
		btnNewButton_2.setBounds(80, 110, 280, 35);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmBiblioteca.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LIBRO (Añadir, modificar...)");
		btnNewButton_3.setBounds(79, 155, 280, 35);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrosView libros = new LibrosView();	 //Cambio de pantalla
			}
		});
		frmBiblioteca.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SOCIO (Añadir, modificar...)");
		btnNewButton_4.setBounds(80, 200, 280, 35);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SociosView socios = new SociosView();	 //Cambio de pantalla
			}
		});
		frmBiblioteca.getContentPane().add(btnNewButton_4);
	}
	
	
	
}
