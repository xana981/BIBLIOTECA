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
import javax.swing.JOptionPane;
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
	private TextField textFieldTrabajador;
	private TextField textFieldInfo;
	private DefaultTableModel tablaPrestamo;
	private JButton btnEliminar;
	private JButton btnConfirmarCambios;
	private JButton btnAñadirNuevo;
	private JTextPane textPaneSocio;
	private JButton btnConfirmarNuevo;
		
		
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
				"ISBN", "Titulo", "Fecha prestamo", "Duracion"
			}
		);
						
		JLabel lblSocio = new JLabel("SOCIO");   //El TITULO
		lblSocio.setBounds(271, 21, 99, 40);
		lblSocio.setForeground(new Color(255, 128, 192));
		lblSocio.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmSocio.getContentPane().add(lblSocio);

		
		JScrollPane scrollPaneSocio = new JScrollPane();
		scrollPaneSocio.setBounds(20, 324, 592, 80);
		scrollPaneSocio.setToolTipText("");
		frmSocio.getContentPane().add(scrollPaneSocio);
		
		tablaSocio = new JTable();
		tablaSocio.setColumnSelectionAllowed(true);
		tablaSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tablaSocio.setModel(tablaPrestamo);
		tablaSocio.getColumnModel().getColumn(0).setResizable(false);
		tablaSocio.getColumnModel().getColumn(0).setPreferredWidth(40);
		tablaSocio.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaSocio.getColumnModel().getColumn(2).setResizable(false);
		tablaSocio.getColumnModel().getColumn(2).setPreferredWidth(90);
		tablaSocio.getColumnModel().getColumn(3).setResizable(false);
		tablaSocio.getColumnModel().getColumn(3).setPreferredWidth(74);
		scrollPaneSocio.setViewportView(tablaSocio);
		
		//Presentacion botones ACCIONES
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo");      //Boton AÑADIR NUEVO
		btnAñadirNuevo.setBounds(376, 85, 207, 51); //Boton "añadir nuevo"
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		frmSocio.getContentPane().add(btnAñadirNuevo);
		
		JButton btnConfirmarCambios = new JButton("Confirmar cambios"); //Boton "CONFIRMAR CAMBIOS"
		btnConfirmarCambios.setEnabled(false);
		btnConfirmarCambios.setBounds(376, 162, 207, 51);
		btnConfirmarCambios.setBackground(new Color(255, 192, 203));
		btnConfirmarCambios.setForeground(new Color(0, 0, 0));
		btnConfirmarCambios.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmSocio.getContentPane().add(btnConfirmarCambios);
		
		this.btnConfirmarNuevo = new JButton("Confirmar nuevo");
		btnConfirmarNuevo.setForeground(Color.BLACK);
		btnConfirmarNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnConfirmarNuevo.setEnabled(false);
		btnConfirmarNuevo.setBackground(new Color(255, 192, 203));
		btnConfirmarNuevo.setBounds(376, 162, 207, 51);
		frmSocio.getContentPane().add(btnConfirmarNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");    //Boton eliminar
		btnEliminar.setBounds(376, 238, 207, 51);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		frmSocio.getContentPane().add(btnEliminar);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setEditable(false);
		txtpnIntroducirSocio.setBounds(10, 78, 132, 27);
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		frmSocio.getContentPane().add(txtpnIntroducirSocio);
		
		this.textPaneSocio = new JTextPane();
		textPaneSocio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if  (tablaPrestamo.getRowCount() > 0) { // Si la tabla tiene valores los ELIMINA para comenzar de nuevo
					tablaPrestamo.removeRow(0);
				}
				tablaSocio.setVisible(false);
				
				textPaneSocio.setForeground(Color.BLACK);//Cambiar el color de la letra			
				textPaneSocio.setText(null); //Quitar el texto de socio para poder escribir el numero del codigo
			}
		});
		textPaneSocio.setText("< Introduce nº socio >");
		textPaneSocio.setForeground(Color.GRAY);
		textPaneSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneSocio.setBounds(145, 77, 142, 27);
		frmSocio.getContentPane().add(textPaneSocio);
				
		//Los titulos de las opciones (txtpn)
		
		JTextPane txtpnNombreApellidos = new JTextPane();
		txtpnNombreApellidos.setEditable(false);
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
		txtpnInfo.setEditable(false);
		txtpnInfo.setBounds(10, 235, 132, 21);
		txtpnInfo.setText("Información adicional");
		txtpnInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnInfo.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnInfo);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setEditable(false);
		txtpnFechaNacimiento.setBounds(10, 175, 109, 21);
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		frmSocio.getContentPane().add(txtpnFechaNacimiento);
		
		JTextPane txtpnTrabajador = new JTextPane();
		txtpnTrabajador.setText("Es trabajador");
		txtpnTrabajador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnTrabajador.setEditable(false);
		txtpnTrabajador.setBackground(SystemColor.menu);
		txtpnTrabajador.setBounds(229, 115, 81, 21);
		frmSocio.getContentPane().add(txtpnTrabajador);
		
		JTextPane txtpnSi = new JTextPane();
		txtpnSi.setText("( Si / No )");
		txtpnSi.setVisible(false);		
		txtpnSi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnSi.setEditable(false);
		txtpnSi.setBackground(SystemColor.menu);
		txtpnSi.setBounds(296, 142, 70, 21);
		frmSocio.getContentPane().add(txtpnSi);
		
		JTextPane txtpnFecha = new JTextPane();
		txtpnFecha.setVisible(false);
		txtpnFecha.setText("( DD - MM - AAAA )");
		txtpnFecha.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtpnFecha.setEditable(false);
		txtpnFecha.setBackground(SystemColor.menu);
		txtpnFecha.setBounds(173, 208, 132, 21);
		frmSocio.getContentPane().add(txtpnFecha);
				
		//Botones "iconos" para MODIFICAR DATOS
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\buscar.png"));
		btnBuscar.setBounds(297, 78, 25, 27);
		frmSocio.getContentPane().add(btnBuscar);
		
		JButton btnModificarNombre = new JButton(""); //Boton modificar Nombre
		btnModificarNombre.setEnabled(false);
		btnModificarNombre.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarNombre.setBounds(186, 115, 22, 22);
		btnModificarNombre.setForeground(new Color(0, 0, 0));
		frmSocio.getContentPane().add(btnModificarNombre);
		
		JButton btnModificarFecha = new JButton(""); //Boton modificar Fecha
		btnModificarFecha.setEnabled(false);
		btnModificarFecha.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarFecha.setBounds(129, 178, 22, 22);
		btnModificarFecha.setForeground(new Color(0, 0, 0));
		frmSocio.getContentPane().add(btnModificarFecha);
		
		JButton btnModificarInfo = new JButton(""); //Boton modificar Info
		btnModificarInfo.setEnabled(false);
		btnModificarInfo.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarInfo.setBounds(148, 235, 22, 22);
		btnModificarInfo.setForeground(new Color(0, 0, 0));
		frmSocio.getContentPane().add(btnModificarInfo);
		
		JButton btnModificarTrabajador = new JButton("");    //Boton modificar Trabajador
		btnModificarTrabajador.setEnabled(false);
		btnModificarTrabajador.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarTrabajador.setForeground(Color.BLACK);
		btnModificarTrabajador.setBounds(321, 115, 22, 22);
		frmSocio.getContentPane().add(btnModificarTrabajador);
		
		JButton btnAtras = new JButton("Atrás");  
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 75, 27);
		frmSocio.getContentPane().add(btnAtras);
		
		// Celdas para introducir los valores de la base de datos	(TextField)	
		
		this.textFieldNombre = new TextField();
		textFieldNombre.setText("Nombre y apellidos");
		textFieldNombre.setForeground(Color.GRAY);
		textFieldNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBackground(new Color(233, 233, 233));
		textFieldNombre.setBounds(20, 142, 188, 21);
		frmSocio.getContentPane().add(textFieldNombre);
		
		this.textFieldNacimiento = new TextField();
		textFieldNacimiento.setText("Fecha de nacimiento");
		textFieldNacimiento.setForeground(Color.GRAY);
		textFieldNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldNacimiento.setEditable(false);
		textFieldNacimiento.setBackground(new Color(233, 233, 233));
		textFieldNacimiento.setBounds(20, 208, 150, 21);
		frmSocio.getContentPane().add(textFieldNacimiento);
		
		this.textFieldInfo = new TextField();
		textFieldInfo.setText("Información adicional");
		textFieldInfo.setForeground(Color.GRAY);
		textFieldInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldInfo.setEditable(false);
		textFieldInfo.setBackground(new Color(233, 233, 233));
		textFieldInfo.setBounds(20, 262, 323, 21);
		frmSocio.getContentPane().add(textFieldInfo);
		
		this.textFieldTrabajador = new TextField();
		textFieldTrabajador.setForeground(Color.GRAY);
		textFieldTrabajador.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldTrabajador.setEditable(false);
		textFieldTrabajador.setBackground(new Color(233, 233, 233));
		textFieldTrabajador.setBounds(239, 142, 48, 21);
		frmSocio.getContentPane().add(textFieldTrabajador);

				
		//EJECUTAR BOTON BUSCAR		
		
		btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tablaSocio.setVisible(true);
						
			if ((textPaneSocio.getText()) == "") {   //Comprobar si se ha introducido algun valor
				JOptionPane.showMessageDialog(null, "No has introducido ningún valor");
			}
			else {
				controlador.SocioElegidoController(Integer.parseInt(textPaneSocio.getText()));
											
				btnModificarNombre.setEnabled(true);
				btnModificarFecha.setEnabled(true);
				btnModificarInfo.setEnabled(true);
				btnModificarTrabajador.setEnabled(true);				
				btnAñadirNuevo.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		}
		});

		//Botones de EJECUCION "AÑADIR - CONFIRMAR - ELIMINAR"
		
		btnAñadirNuevo.addActionListener(new ActionListener() {  //Se borran los valores y se hace editable para poder grabar
			public void actionPerformed(ActionEvent e) {
				btnConfirmarNuevo.setEnabled(true);
				
				if  (tablaPrestamo.getRowCount() > 0) { // Si la tabla tiene valores los ELIMINA para comenzar de nuevo
					tablaPrestamo.removeRow(0);
				}		
				tablaSocio.setVisible(false);
				txtpnFecha.setVisible(true);
				txtpnSi.setVisible(true);
				btnModificarNombre.setEnabled(false);
				btnModificarFecha.setEnabled(false);
				btnModificarTrabajador.setEnabled(false);
				btnModificarInfo.setEnabled(false);
				
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
				
				textFieldTrabajador.setEditable(true);
				textFieldTrabajador.setForeground(Color.BLACK);
				textFieldTrabajador.setText(null);
				textFieldTrabajador.setBackground(Color.WHITE);
								
				textPaneSocio.setForeground(Color.BLACK);
				textPaneSocio.setText(null); //Quitar el texto de socio para poder escribir el numero del codigo
				
				btnConfirmarCambios.setVisible(false);
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		
		btnConfirmarNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.confirmarNuevoController();
			}
		});

		btnConfirmarCambios.addActionListener(new ActionListener() { //PULSAR BOTON CONFIRMAR CAMBIOS _ Cuando se confirman los cambios se le quita el editable y cambia el color
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(btnConfirmarCambios,"¿Estas seguro de CONFIRMAR los cambios?","Mensaje",JOptionPane.YES_NO_OPTION);
				
				if(n==0) {    //Si la respuesta es SI, tiene que subir los datos a la base de datos
					
					//controlador.ConfirmarCambiosController(null, null, null, null, null);
										
		


					
					
					controlador.ConfirmarCambiosController((textPaneSocio.getText()),(textFieldNombre.getText()),(textFieldTrabajador.getText()),(textFieldNacimiento.getText()),(textFieldInfo.getText()));				
					
					BibliotecaController controlador = new BibliotecaController();
					controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
					frmSocio.setVisible(false);   //Cuando se confirman los cambios se le quita el editable y cambia el color
				}
				
				/*textPaneSocio.setForeground(Color.GRAY);
				textFieldNombre.setEditable(false); //Hacer el cuadro NO editable
				textFieldNombre.setForeground(Color.GRAY);//Cambiar el color de la letra				
				textFieldNacimiento.setEditable(false);
				textFieldNacimiento.setForeground(Color.GRAY);
				textFieldInfo.setEditable(false);
				textFieldInfo.setForeground(Color.GRAY);
				textFieldTrabajador.setEditable(false);
				textFieldTrabajador.setForeground(Color.GRAY);*/
			}
		});

		btnEliminar.addActionListener(new ActionListener() { //EJECUTAR Boton ELIMINAR Activa panel de confimacion
			public void actionPerformed(ActionEvent e) {
				controlador.EliminarSocioController(textPaneSocio.getText());
			}
		});

		//EJECUCION BOTONES MODIFICACIONES
		
		btnModificarNombre.addActionListener(new ActionListener() { //EJECUTAR Boton Modificar NOMBRE
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(true);
				textFieldNombre.setForeground(Color.BLACK);//Cambiar el color de la letra
				textFieldNombre.setBackground(Color.WHITE); //Cambia el fondo de la celda
				
				btnAñadirNuevo.setEnabled(false);
				btnConfirmarCambios.setEnabled(true);
				btnEliminar.setEnabled(false);
			}
		});

		btnModificarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacimiento.setEditable(true);
				textFieldNacimiento.setForeground(Color.BLACK);//Cambiar el color de la letra
				textFieldNacimiento.setBackground(Color.WHITE); //Cambia el fondo de la celda

				txtpnFecha.setVisible(true);
				btnAñadirNuevo.setEnabled(false);
				btnConfirmarCambios.setEnabled(true);
				btnEliminar.setEnabled(false);
			}
		});

		btnModificarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInfo.setEditable(true);
				textFieldInfo.setForeground(Color.BLACK);//Cambiar el color de la letra
				textFieldInfo.setBackground(Color.WHITE); //Cambia el fondo de la celda
				
				btnAñadirNuevo.setEnabled(false);
				btnConfirmarCambios.setEnabled(true);
				btnEliminar.setEnabled(false);
			}
		});
		
		btnModificarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTrabajador.setEditable(true);
				textFieldTrabajador.setForeground(Color.BLACK);//Cambiar el color de la letra
				textFieldTrabajador.setBackground(Color.WHITE); //Cambia el fondo de la celda
				
				btnAñadirNuevo.setEnabled(false);
				btnConfirmarCambios.setEnabled(true);
				btnEliminar.setEnabled(false);
				txtpnSi.setVisible(true);
			}
		});

		// EJECUTAR Boton "ATRAS"

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSocio.setVisible(false);
				BibliotecaController controlador = new BibliotecaController();
				controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
			}
		});
		
		frmSocio.getContentPane().setLayout(null);
		frmSocio.setVisible(true);

	}
	
	//Rellenar valores del TextField
	
	public JTextPane gettextPaneSocio() {	
		return this.textPaneSocio;
	}	
	
	public TextField gettextFieldNombre() { //Recojo el valor de la informacion del cuadro
		return this.textFieldNombre;
	};
	
	public TextField gettextFieldTrabajador() {
		return this.textFieldTrabajador;
	};
		
	public TextField gettextFieldNacimiento() {
		return this.textFieldNacimiento;
	};

	public TextField gettextFieldInfo() {
		return this.textFieldInfo;
	};
	
	//Rellenar tabla con valores prestados
	public void rellenaPrestamo(Object[] rowSocio) {
		
		this.tablaPrestamo.addRow(rowSocio);//para añadir una fila a la tabla lo primero que tengo que añadir es la 
												//fila al modelo correspondiente a esa tabla
		this.tablaSocio.setModel(tablaPrestamo); //una vez la tenga añadida al modelo, muestro el modelo en la tabla
	}
	
		
	
	
	
	
	
	
}
