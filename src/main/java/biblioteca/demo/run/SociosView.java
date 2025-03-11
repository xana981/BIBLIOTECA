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
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.TextField;
import java.awt.Panel;
import javax.swing.table.DefaultTableModel;
import java.awt.Label;
import javax.swing.JComboBox;
import biblioteca.demo.run.BibliotecaView;

public class SociosView {
	
	protected JFrame frmBiblioteca;
	private JTable tableSocio;
	
	public SociosView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnCambioSocio = new JButton("Confirmar cambios");
		btnCambioSocio.setBounds(376, 162, 207, 51);
		btnCambioSocio.setBackground(new Color(255, 192, 203));
		btnCambioSocio.setForeground(new Color(0, 0, 0));
		btnCambioSocio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCambioSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblSocio = new JLabel("SOCIO");
		lblSocio.setBounds(271, 21, 99, 40);
		lblSocio.setForeground(new Color(0, 0, 255));
		lblSocio.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblSocio);
		frmBiblioteca.getContentPane().add(btnCambioSocio);
		
		JScrollPane scrollPanePrestados = new JScrollPane();
		scrollPanePrestados.setBounds(20, 324, 592, 80);
		scrollPanePrestados.setToolTipText("");
		frmBiblioteca.getContentPane().add(scrollPanePrestados);
		
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
		scrollPanePrestados.setViewportView(tableSocio);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setBounds(10, 78, 132, 27);
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		frmBiblioteca.getContentPane().add(txtpnIntroducirSocio);
		
		TextField textFieldSocio = new TextField();
		textFieldSocio.setForeground(Color.GRAY);
		textFieldSocio.setBounds(148, 78, 174, 27);
		textFieldSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSocio.setText("< Introduce el nº >");
		frmBiblioteca.getContentPane().add(textFieldSocio);
		
		JTextPane txtpnNombreApellidos = new JTextPane();
		txtpnNombreApellidos.setBounds(10, 115, 180, 21);
		txtpnNombreApellidos.setBackground(SystemColor.menu);
		txtpnNombreApellidos.setText("Nombre y apellidos del socio");
		txtpnNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmBiblioteca.getContentPane().add(txtpnNombreApellidos);
		
		Label labelNombreApellidos = new Label("Nombre y apellidos\r\n");
		labelNombreApellidos.setForeground(Color.GRAY);
		labelNombreApellidos.setBounds(20, 142, 341, 27);
		labelNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmBiblioteca.getContentPane().add(labelNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setBounds(10, 292, 264, 21);
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		frmBiblioteca.getContentPane().add(txtpnListaDeLibros);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setBounds(10, 235, 142, 21);
		txtpnInfo.setText("Información adicional");
		txtpnInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnInfo.setBackground(SystemColor.menu);
		frmBiblioteca.getContentPane().add(txtpnInfo);
		
		Label labelInfo = new Label("Informacion adicional");
		labelInfo.setForeground(Color.GRAY);
		labelInfo.setBounds(20, 262, 341, 27);
		labelInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmBiblioteca.getContentPane().add(labelInfo);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setBounds(10, 175, 109, 21);
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		frmBiblioteca.getContentPane().add(txtpnFechaNacimiento);
		
		Label labelFechaNacimiento = new Label("Fecha de nacimiento");
		labelFechaNacimiento.setForeground(Color.GRAY);
		labelFechaNacimiento.setBounds(20, 202, 208, 27);
		labelFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmBiblioteca.getContentPane().add(labelFechaNacimiento);
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo");
		btnAñadirNuevo.setBounds(376, 85, 207, 51);
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		frmBiblioteca.getContentPane().add(btnAñadirNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(376, 238, 207, 51);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		frmBiblioteca.getContentPane().add(btnEliminar);
		
		JButton btnModificarNombre = new JButton("Modificar");
		btnModificarNombre.setBounds(186, 115, 89, 23);
		btnModificarNombre.setForeground(Color.RED);
		frmBiblioteca.getContentPane().add(btnModificarNombre);
		
		JButton btnModificarFecha = new JButton("Modificar");
		btnModificarFecha.setBounds(129, 178, 89, 23);
		btnModificarFecha.setForeground(Color.RED);
		frmBiblioteca.getContentPane().add(btnModificarFecha);
		
		JButton btnModificarInfo = new JButton("Modificar");
		btnModificarInfo.setBounds(148, 235, 89, 23);
		btnModificarInfo.setForeground(Color.RED);
		frmBiblioteca.getContentPane().add(btnModificarInfo);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BibliotecaView biblioteca = new BibliotecaView();	 //Cambio de pantalla
			}
			
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.BLUE);
		btnAtras.setBounds(10, 11, 75, 27);
		frmBiblioteca.getContentPane().add(btnAtras);
	}
}
