package biblioteca.demo.run;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import java.awt.TextField;

import javax.swing.table.DefaultTableModel;
import java.awt.Label;
import javax.swing.JComboBox;

import biblioteca.demo.run.*;
import java.awt.Dimension;

public class PrestamoView {
	
	protected JFrame frmPrestamo;
	private JTable tablePrestados;
	
	public PrestamoView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmPrestamo = new JFrame();
		frmPrestamo.setVisible(true);
		frmPrestamo.setSize(new Dimension(787, 472));
		frmPrestamo.setResizable(false);
		frmPrestamo.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmPrestamo.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnPrestamo = new JButton("Confirmar préstamo");
		btnPrestamo.setBackground(new Color(255, 192, 203));
		btnPrestamo.setBounds(54, 360, 207, 51);
		btnPrestamo.setForeground(new Color(0, 0, 0));
		btnPrestamo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarView confirmar = new ConfirmarView();	 //Activa la pantalla Confirmar	
			}
		});
		frmPrestamo.getContentPane().setLayout(null);
		
		JLabel lblPrestamoDevolucion = new JLabel(" PRÉSTAMO / DEVOLUCIÓN");
		lblPrestamoDevolucion.setBounds(223, 11, 405, 40);
		lblPrestamoDevolucion.setForeground(new Color(0, 0, 255));
		lblPrestamoDevolucion.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmPrestamo.getContentPane().add(lblPrestamoDevolucion);
		frmPrestamo.getContentPane().add(btnPrestamo);
		
		JScrollPane scrollPanePrestados = new JScrollPane();
		scrollPanePrestados.setToolTipText("");
		scrollPanePrestados.setBounds(20, 197, 729, 80);
		frmPrestamo.getContentPane().add(scrollPanePrestados);
		
		tablePrestados = new JTable();
		tablePrestados.setColumnSelectionAllowed(true);
		tablePrestados.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tablePrestados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"isbn", "Titulo", "Fecha pr\u00E9stamo", "Duraci\u00F3n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePrestados.getColumnModel().getColumn(0).setResizable(false);
		tablePrestados.getColumnModel().getColumn(0).setPreferredWidth(40);
		tablePrestados.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePrestados.getColumnModel().getColumn(2).setPreferredWidth(70);
		tablePrestados.getColumnModel().getColumn(3).setResizable(false);
		tablePrestados.getColumnModel().getColumn(3).setPreferredWidth(70);
		scrollPanePrestados.setViewportView(tablePrestados);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		txtpnIntroducirSocio.setBounds(10, 62, 132, 27);
		frmPrestamo.getContentPane().add(txtpnIntroducirSocio);
		
		TextField textFieldSocio = new TextField();
		textFieldSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSocio.setText("< Introduce el nº >");
		textFieldSocio.setBounds(148, 62, 174, 27);
		frmPrestamo.getContentPane().add(textFieldSocio);
		
		JTextPane txtpnNombreApellidos = new JTextPane();
		txtpnNombreApellidos.setBackground(SystemColor.menu);
		txtpnNombreApellidos.setText("Nombre y apellidos del socio");
		txtpnNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNombreApellidos.setBounds(10, 99, 180, 21);
		frmPrestamo.getContentPane().add(txtpnNombreApellidos);
		
		Label labelNombreApellidos = new Label("Nombre y apellidos");
		labelNombreApellidos.setForeground(Color.GRAY);
		labelNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelNombreApellidos.setBounds(20, 126, 417, 27);
		frmPrestamo.getContentPane().add(labelNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		txtpnListaDeLibros.setBounds(10, 165, 264, 21);
		frmPrestamo.getContentPane().add(txtpnListaDeLibros);
		
		JTextPane txtpnIntroducirIsbn = new JTextPane();
		txtpnIntroducirIsbn.setText("Introducir isbn");
		txtpnIntroducirIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirIsbn.setBackground(SystemColor.menu);
		txtpnIntroducirIsbn.setBounds(10, 288, 97, 27);
		frmPrestamo.getContentPane().add(txtpnIntroducirIsbn);
		
		JComboBox comboIsbnLibros = new JComboBox();
		comboIsbnLibros.setEditable(true);
		comboIsbnLibros.setMaximumRowCount(15);
		comboIsbnLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboIsbnLibros.setToolTipText("Introduce el isbn");
		comboIsbnLibros.setBounds(113, 288, 324, 27);
		frmPrestamo.getContentPane().add(comboIsbnLibros);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		txtpnFechaNacimiento.setBounds(461, 99, 218, 21);
		frmPrestamo.getContentPane().add(txtpnFechaNacimiento);
		
		Label labelFechaNacimiento = new Label("Fecha nacimiento");
		labelFechaNacimiento.setForeground(Color.GRAY);
		labelFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelFechaNacimiento.setBounds(471, 126, 208, 27);
		frmPrestamo.getContentPane().add(labelFechaNacimiento);
		
		JTextPane txtpnDuracion = new JTextPane();
		txtpnDuracion.setText("Duración préstamo");
		txtpnDuracion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnDuracion.setBackground(SystemColor.menu);
		txtpnDuracion.setBounds(10, 326, 123, 27);
		frmPrestamo.getContentPane().add(txtpnDuracion);
		
		JRadioButton rdbtn15 = new JRadioButton("15 días");

		rdbtn15.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtn15.setBounds(139, 322, 70, 31);
		frmPrestamo.getContentPane().add(rdbtn15);
		
		JRadioButton rdbtn30 = new JRadioButton("30 días");
		
		rdbtn30.setToolTipText("");
		rdbtn30.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtn30.setBounds(226, 322, 70, 31);
		frmPrestamo.getContentPane().add(rdbtn30);
		
		
		rdbtn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn30.setSelected(false);
			}
		});
		
		rdbtn30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn15.setSelected(false);
			}
		});
		
		
		
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BibliotecaView biblioteca = new BibliotecaView();	 //Cambio de pantalla
				frmPrestamo.setVisible(false);
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 70, 27);
		frmPrestamo.getContentPane().add(btnAtras);
		
		JButton btnDevolucion = new JButton("Confirmar devolución");
		btnDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarView confirmar = new ConfirmarView();	 //Activa la pantalla Confirmar	
			}
		});
		btnDevolucion.setForeground(Color.BLACK);
		btnDevolucion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDevolucion.setBackground(new Color(255, 192, 203));
		btnDevolucion.setBounds(498, 360, 226, 51);
		frmPrestamo.getContentPane().add(btnDevolucion);
	}
}
