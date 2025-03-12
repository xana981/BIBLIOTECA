package biblioteca.demo.run;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
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
		txtpnNombreApellidos.setBounds(10, 115, 180, 21);
		txtpnNombreApellidos.setBackground(SystemColor.menu);
		txtpnNombreApellidos.setText("Nombre y apellidos del socio");
		txtpnNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmSocio.getContentPane().add(txtpnNombreApellidos);
		
		Label labelNombreApellidos = new Label("Nombre y apellidos\r\n");
		labelNombreApellidos.setForeground(Color.GRAY);
		labelNombreApellidos.setBounds(20, 142, 341, 27);
		labelNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmSocio.getContentPane().add(labelNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setBounds(10, 292, 264, 21);
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnListaDeLibros);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setBounds(10, 235, 142, 21);
		txtpnInfo.setText("Información adicional");
		txtpnInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnInfo.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnInfo);
		
		Label labelInfo = new Label("Informacion adicional");
		labelInfo.setForeground(Color.GRAY);
		labelInfo.setBounds(20, 262, 341, 27);
		labelInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmSocio.getContentPane().add(labelInfo);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setBounds(10, 175, 109, 21);
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnFechaNacimiento);
		
		Label labelFechaNacimiento = new Label("Fecha de nacimiento");
		labelFechaNacimiento.setForeground(Color.GRAY);
		labelFechaNacimiento.setBounds(20, 202, 208, 27);
		labelFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmSocio.getContentPane().add(labelFechaNacimiento);
		
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
		btnModificarNombre.setBounds(186, 115, 89, 23);
		btnModificarNombre.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarNombre);
		
		JButton btnModificarFecha = new JButton("Modificar");
		btnModificarFecha.setBounds(129, 178, 89, 23);
		btnModificarFecha.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarFecha);
		
		JButton btnModificarInfo = new JButton("Modificar");
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
