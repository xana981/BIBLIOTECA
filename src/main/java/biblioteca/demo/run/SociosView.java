package biblioteca.demo.run;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class SociosView {
	
	protected JFrame frmSocio;
	private JTable tableSocio;
	
	public SociosView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmSocio = new JFrame();
		frmSocio.setSize(new Dimension(645, 451));
		frmSocio.setResizable(false);
		frmSocio.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmSocio.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnCambioSocio = new JButton("Confirmar cambios");
		btnCambioSocio.setBounds(376, 162, 207, 51);
		btnCambioSocio.setBackground(new Color(255, 192, 203));
		btnCambioSocio.setForeground(new Color(0, 0, 0));
		btnCambioSocio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCambioSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmSocio.getContentPane().setLayout(null);
		
		JLabel lblSocio = new JLabel("SOCIO");
		lblSocio.setBounds(271, 21, 99, 40);
		lblSocio.setForeground(new Color(0, 0, 255));
		lblSocio.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmSocio.getContentPane().add(lblSocio);
		frmSocio.getContentPane().add(btnCambioSocio);
		
		JScrollPane scrollPaneSocio = new JScrollPane();
		scrollPaneSocio.setBounds(20, 324, 592, 80);
		scrollPaneSocio.setToolTipText("");
		frmSocio.getContentPane().add(scrollPaneSocio);
		
		tableSocio = new JTable();
		tableSocio.setColumnSelectionAllowed(true);
		tableSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tableSocio.setModel(new DefaultTableModel(
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
		tableSocio.getColumnModel().getColumn(0).setResizable(false);
		tableSocio.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableSocio.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableSocio.getColumnModel().getColumn(2).setResizable(false);
		tableSocio.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableSocio.getColumnModel().getColumn(3).setResizable(false);
		tableSocio.getColumnModel().getColumn(3).setPreferredWidth(74);
		scrollPaneSocio.setViewportView(tableSocio);
		
		
		TextField textFieldNombre = new TextField();
		textFieldNombre.setText("Nombre y apellidos");
		textFieldNombre.setForeground(Color.GRAY);
		textFieldNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBackground(new Color(233, 233, 233));
		textFieldNombre.setBounds(20, 142, 323, 21);
		frmSocio.getContentPane().add(textFieldNombre);
		
		TextField textFieldNacimiento = new TextField();
		textFieldNacimiento.setText("Fecha de nacimiento");
		textFieldNacimiento.setForeground(Color.GRAY);
		textFieldNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldNacimiento.setEditable(false);
		textFieldNacimiento.setBackground(new Color(233, 233, 233));
		textFieldNacimiento.setBounds(20, 208, 147, 21);
		frmSocio.getContentPane().add(textFieldNacimiento);
		
		TextField textFieldInfo = new TextField();
		textFieldInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInfo.setEditable(true);
			}
		});
		textFieldInfo.setText("Información adicional");
		textFieldInfo.setForeground(Color.GRAY);
		textFieldInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldInfo.setEditable(false);
		textFieldInfo.setBackground(new Color(233, 233, 233));
		textFieldInfo.setBounds(20, 262, 323, 21);
		frmSocio.getContentPane().add(textFieldInfo);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setBounds(10, 78, 132, 27);
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		frmSocio.getContentPane().add(txtpnIntroducirSocio);
		
		TextField textFieldSocio = new TextField();
		textFieldSocio.setForeground(Color.GRAY);
		textFieldSocio.setBounds(148, 78, 174, 27);
		textFieldSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSocio.setText("< Introduce el nº >");
		frmSocio.getContentPane().add(textFieldSocio);
		
		JTextPane txtpnNombreApellidos = new JTextPane();
		txtpnNombreApellidos.setBounds(10, 115, 170, 21);
		txtpnNombreApellidos.setBackground(SystemColor.menu);
		txtpnNombreApellidos.setText("Nombre y apellidos del socio");
		txtpnNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmSocio.getContentPane().add(txtpnNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setBounds(10, 292, 264, 21);
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnListaDeLibros);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setBounds(10, 235, 132, 21);
		txtpnInfo.setText("Información adicional");
		txtpnInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnInfo.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnInfo);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setBounds(10, 175, 109, 21);
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnFechaNacimiento);
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo");
		btnAñadirNuevo.setBounds(376, 85, 207, 51);
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		frmSocio.getContentPane().add(btnAñadirNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(376, 238, 207, 51);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		frmSocio.getContentPane().add(btnEliminar);
		
		JButton btnModificarNombre = new JButton("Modificar");
		btnModificarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(true);
			}
		});
		btnModificarNombre.setBounds(186, 115, 89, 23);
		btnModificarNombre.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarNombre);
		
		JButton btnModificarFecha = new JButton("Modificar");
		btnModificarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacimiento.setEditable(true);
			}
		});
		btnModificarFecha.setBounds(129, 178, 89, 23);
		btnModificarFecha.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarFecha);
		
		JButton btnModificarInfo = new JButton("Modificar");
		btnModificarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInfo.setEditable(true);
			}
		});
		btnModificarInfo.setBounds(148, 235, 89, 23);
		btnModificarInfo.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarInfo);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BibliotecaView biblioteca = new BibliotecaView();	 //Cambio de pantalla
				frmSocio.setVisible(false);
			}
			
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 75, 27);
		frmSocio.getContentPane().add(btnAtras);

		
		frmSocio.setVisible(true);
	}
}
