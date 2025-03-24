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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import biblioteca.demo.run.*;

public class SocioView {
	
	protected JFrame frmSocio;
	private JTable tablaSocio;
	private SocioController controlador;
	private TextField textFieldNombre;
	private TextField textFieldNacimiento;
	private TextField textFieldInfo;
	private DefaultTableModel tablaPrestamo;
	
	
	public SocioView(SocioController c) {
		inicialize(c);
	}
	
	private void inicialize(SocioController c) {
		
		frmSocio = new JFrame();
		frmSocio.setSize(new Dimension(645, 451));
		frmSocio.setResizable(false);
		frmSocio.setLocationRelativeTo(null);
		controlador=c;
		frmSocio.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmSocio.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		tablaPrestamo = new DefaultTableModel(new Object[][] {
		},
		new String[] {
				"ISBN", "Titulo", "Fecha prestamo", "Duracion", "New column"
			}
		);
		
		JButton btnConfirmarCambios = new JButton("Confirmar cambios"); //Boton "confirmar cambios"
		btnConfirmarCambios.setEnabled(false);
		btnConfirmarCambios.setBounds(376, 162, 207, 51);
		btnConfirmarCambios.setBackground(new Color(255, 192, 203));
		btnConfirmarCambios.setForeground(new Color(0, 0, 0));
		btnConfirmarCambios.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmSocio.getContentPane().setLayout(null);
				
				
		JLabel lblSocio = new JLabel("SOCIO");   //El TITULO
		lblSocio.setBounds(271, 21, 99, 40);
		lblSocio.setForeground(new Color(255, 128, 192));
		lblSocio.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmSocio.getContentPane().add(lblSocio);
		frmSocio.getContentPane().add(btnConfirmarCambios);
		
		JScrollPane scrollPaneSocio = new JScrollPane();
		scrollPaneSocio.setBounds(20, 324, 592, 80);
		scrollPaneSocio.setToolTipText("");
		frmSocio.getContentPane().add(scrollPaneSocio);
		
		tablaSocio = new JTable();
		tablaSocio.setColumnSelectionAllowed(true);
		tablaSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tablaSocio.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ISBN", "Titulo", "Fecha prestamo", "Duracion", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaSocio.getColumnModel().getColumn(0).setResizable(false);
		tablaSocio.getColumnModel().getColumn(0).setPreferredWidth(40);
		tablaSocio.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaSocio.getColumnModel().getColumn(2).setResizable(false);
		tablaSocio.getColumnModel().getColumn(2).setPreferredWidth(90);
		tablaSocio.getColumnModel().getColumn(3).setResizable(false);
		tablaSocio.getColumnModel().getColumn(3).setPreferredWidth(74);
		scrollPaneSocio.setViewportView(tablaSocio);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setBounds(10, 78, 132, 27);
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		frmSocio.getContentPane().add(txtpnIntroducirSocio);
		
		JTextPane textPaneSocio = new JTextPane();
		textPaneSocio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPaneSocio.setForeground(Color.BLACK);//Cambiar el color de la letra			
				textPaneSocio.setText(null); //Quitar el texto de socio para poder escribir el numero del codigo

			}
		});
		textPaneSocio.setText("< Introduce nº socio >");
		textPaneSocio.setForeground(Color.GRAY);
		textPaneSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneSocio.setBounds(145, 77, 142, 27);
		frmSocio.getContentPane().add(textPaneSocio);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.SocioElegidoController(Integer.parseInt(textPaneSocio.getText()));
			}
		});
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\buscar.png"));
		btnBuscar.setBounds(297, 78, 25, 27);
		frmSocio.getContentPane().add(btnBuscar);
		
		// Celdas para introducir los valores de la base de datos	(TextField)	
		
		this.textFieldNombre = new TextField();
		textFieldNombre.setText("Nombre y apellidos");
		textFieldNombre.setForeground(Color.GRAY);
		textFieldNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBackground(new Color(233, 233, 233));
		textFieldNombre.setBounds(20, 142, 323, 21);
		frmSocio.getContentPane().add(textFieldNombre);
		
		this.textFieldNacimiento = new TextField();
		textFieldNacimiento.setText("Fecha de nacimiento");
		textFieldNacimiento.setForeground(Color.GRAY);
		textFieldNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldNacimiento.setEditable(false);
		textFieldNacimiento.setBackground(new Color(233, 233, 233));
		textFieldNacimiento.setBounds(20, 208, 147, 21);
		frmSocio.getContentPane().add(textFieldNacimiento);
		
		this.textFieldInfo = new TextField();
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
		
		//Los titulos de las opciones (txtpn)
		
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
		
		JButton btnEliminar = new JButton("Eliminar");                              //Boton ELIMINAR
		btnEliminar.addActionListener(new ActionListener() { //Activa pantalla confirmar
			public void actionPerformed(ActionEvent e) {
				ConfirmarView confirmar = new ConfirmarView();
			}
		});
		btnEliminar.setBounds(376, 238, 207, 51);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		frmSocio.getContentPane().add(btnEliminar);
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo"); //Se borran los valores y se hace editable para poder grabar
		btnAñadirNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmarCambios.setEnabled(true);
				
				textPaneSocio.setText(null); //Quitar el texto de socio para poder escribir el numero del codigo
				textPaneSocio.setForeground(Color.BLACK);
				
				textFieldNombre.setEditable(true); //Hace el campo editable
				textFieldNombre.setForeground(Color.BLACK);//Cambiar el color de la letra		
				textFieldNombre.setText(null); //Borra valor de la celda
				textFieldNombre.setBackground(Color.WHITE); //Cambia el fondo de la celda
				
				textFieldNacimiento.setEditable(true);
				textFieldNacimiento.setForeground(Color.BLACK);
				textFieldNacimiento.setText(null);
				textFieldNacimiento.setBackground(Color.WHITE);
				
				textFieldInfo.setEditable(true);
				textFieldInfo.setForeground(Color.BLACK);
				textFieldInfo.setText(null);
				textFieldInfo.setBackground(Color.WHITE);
				
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnAñadirNuevo.setBounds(376, 85, 207, 51); //Boton "añadir nuevo"
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		frmSocio.getContentPane().add(btnAñadirNuevo);
		
		
		JButton btnModificarNombre = new JButton(""); //Boton modificar Nombre
		btnModificarNombre.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(true);
				textFieldNombre.setForeground(Color.BLACK);//Cambiar el color de la letra
			}
		});
		btnModificarNombre.setBounds(186, 115, 22, 22);
		btnModificarNombre.setForeground(new Color(0, 0, 0));
		frmSocio.getContentPane().add(btnModificarNombre);
		
		JButton btnModificarFecha = new JButton(""); //Boton modificar Fecha
		btnModificarFecha.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacimiento.setEditable(true);
				textFieldNacimiento.setForeground(Color.BLACK);//Cambiar el color de la letra
			}
		});
		btnModificarFecha.setBounds(129, 178, 22, 22);
		btnModificarFecha.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarFecha);
		
		JButton btnModificarInfo = new JButton(""); //Boton modificar Info
		btnModificarInfo.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInfo.setEditable(true);
				textFieldInfo.setForeground(Color.BLACK);//Cambiar el color de la letra
			}
		});
		btnModificarInfo.setBounds(148, 235, 22, 22);
		btnModificarInfo.setForeground(Color.RED);
		frmSocio.getContentPane().add(btnModificarInfo);
		
		
		btnConfirmarCambios.addActionListener(new ActionListener() { //PULSAR BOTON CONFIRMAR CAMBIOS _ Cuando se confirman los cambios se le quita el editable y cambia el color
			public void actionPerformed(ActionEvent e) {
				textPaneSocio.setForeground(Color.GRAY);
				
				textFieldNombre.setEditable(false);
				textFieldNombre.setForeground(Color.GRAY);//Cambiar el color de la letra				
				
				textFieldNacimiento.setEditable(false);
				textFieldNacimiento.setForeground(Color.GRAY);//Cambiar el color de la letra
				
				textFieldInfo.setEditable(false);
				textFieldInfo.setForeground(Color.GRAY);
				
			}
		});
		
		JButton btnAtras = new JButton("Atrás");  //Boton atrás
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSocio.setVisible(false);
				BibliotecaController controlador = new BibliotecaController();
				controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 75, 27);
		frmSocio.getContentPane().add(btnAtras);
		
		frmSocio.setVisible(true);
	}
	
	public TextField gettextFieldNombre() {
		return this.textFieldNombre;
	};
	
	public TextField gettextFieldNacimiento() {
		return this.textFieldNacimiento;
	};
	
	public TextField gettextFieldInfo() {
		return this.textFieldInfo;
	};
	
	public void rellenaPrestamo(Object[] rowSocio) {
		
		this.tablaPrestamo.addRow(rowSocio);//para añadir una fila a la tabla lo primero que tengo que añadir es la 
												//fila al modelo correspondiente a esa tabla
		this.tablaSocio.setModel(tablaPrestamo); //una vez la tenga añadida al modelo, muestro el modelo en la tabla
	}
}
