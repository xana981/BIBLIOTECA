package biblioteca.demo.run;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.*;
import javax.swing.JLabel;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class LibroView {
	
	protected JFrame frmLibro;
	private JTable tablaLibro;
	private LibroController controlador;
	private TextField textFieldTitulo;
	private TextField textFieldAutor;
	private TextField textFieldEdicion;
	private TextField textFieldCategoria;
	private DefaultTableModel tablaPrestamo;
	
	public LibroView(LibroController c) {
		inicialize(c);
	}
	
	private void inicialize(LibroController c) {
		
		frmLibro = new JFrame();
		frmLibro.setSize(new Dimension(650, 480));
		frmLibro.setResizable(false);
		frmLibro.setLocationRelativeTo(null);
		controlador=c;
		frmLibro.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmLibro.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		frmLibro.getContentPane().setLayout(null);
		
		tablaPrestamo = new DefaultTableModel(new Object[][] {
		},
		new String[] {
				"ISBN","numSocio","fechaPrestamo","fechaDevolucion"
			}
		);
		
		
		JLabel lblLibro = new JLabel("LIBRO"); //El encabezado
		lblLibro.setBounds(267, 11, 99, 40);
		lblLibro.setForeground(new Color(255, 128, 192));
		lblLibro.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmLibro.getContentPane().add(lblLibro);

		
		JTextPane textPaneLibro = new JTextPane();
		textPaneLibro.setText("< Introduce el isbn >");
		textPaneLibro.setForeground(Color.GRAY);
		textPaneLibro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneLibro.setBounds(103, 62, 142, 27);
		frmLibro.getContentPane().add(textPaneLibro);
		textPaneLibro.addMouseListener(new MouseAdapter() { //Al pulsar sobre el cuadro textPaneLibro
			@Override
			public void mouseClicked(MouseEvent e) {
				textPaneLibro.setForeground(Color.BLACK); //Cambia de color la letra
				textPaneLibro.setText(null);   //Borra el contenido del cuadro
			}
		});

		JScrollPane scrollPaneLibro = new JScrollPane();
		scrollPaneLibro.setToolTipText("");
		scrollPaneLibro.setBounds(20, 373, 592, 51);
		frmLibro.getContentPane().add(scrollPaneLibro);
		
		tablaLibro = new JTable();
		tablaLibro.setColumnSelectionAllowed(true);
		tablaLibro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tablaLibro.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"ISBN", "numSocio", "Fecha prestamo", "Duracion"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		tablaLibro.getColumnModel().getColumn(0).setResizable(false);
		tablaLibro.getColumnModel().getColumn(0).setPreferredWidth(56);
		tablaLibro.getColumnModel().getColumn(1).setPreferredWidth(222);
		tablaLibro.getColumnModel().getColumn(2).setPreferredWidth(92);
		tablaLibro.getColumnModel().getColumn(3).setResizable(false);
		tablaLibro.getColumnModel().getColumn(3).setPreferredWidth(70);
		scrollPaneLibro.setViewportView(tablaLibro);
		
		JTextPane txtpnIntroducirLibro = new JTextPane();
		txtpnIntroducirLibro.setBackground(SystemColor.menu);
		txtpnIntroducirLibro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirLibro.setText("Introducir isbn");
		txtpnIntroducirLibro.setBounds(10, 62, 91, 27);
		frmLibro.getContentPane().add(txtpnIntroducirLibro);

		// Celdas para introducir los valores de la base de datos	(TextField)	
		
		this.textFieldTitulo = new TextField();                                 //******************** TextFieldTitulo "Valores de la BD"
		textFieldTitulo.setEditable(false);
		textFieldTitulo.setText("Titulo del libro");
		textFieldTitulo.setForeground(Color.GRAY);
		textFieldTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldTitulo.setBackground(new Color(233, 233, 233));
		textFieldTitulo.setBounds(20, 126, 323, 21);
		//textFieldTitulo.setModel(LibroTitulo);
		frmLibro.getContentPane().add(textFieldTitulo);
		
		this.textFieldAutor = new TextField();
		textFieldAutor.setText("Autor del libro");
		textFieldAutor.setForeground(Color.GRAY);
		textFieldAutor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldAutor.setEditable(false);
		textFieldAutor.setBackground(new Color(233, 233, 233));
		textFieldAutor.setBounds(20, 186, 323, 21);
		frmLibro.getContentPane().add(textFieldAutor);
		
		this.textFieldEdicion = new TextField();
		textFieldEdicion.setText("Año de edición del libro");
		textFieldEdicion.setForeground(Color.GRAY);
		textFieldEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldEdicion.setEditable(false);
		textFieldEdicion.setBackground(new Color(233, 233, 233));
		textFieldEdicion.setBounds(20, 246, 147, 21);
		frmLibro.getContentPane().add(textFieldEdicion);
		
		this.textFieldCategoria = new TextField();
		textFieldCategoria.setText("Categoría del libro");
		textFieldCategoria.setForeground(Color.GRAY);
		textFieldCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldCategoria.setEditable(false);
		textFieldCategoria.setBackground(new Color(233, 233, 233));
		textFieldCategoria.setBounds(20, 306, 147, 21);
		frmLibro.getContentPane().add(textFieldCategoria);
		

		//Los titulos de las opciones (txtpn)
				
		JTextPane txtpnTitulo = new JTextPane();                        //******************** txtpnTitulo (Titulos)
		txtpnTitulo.setBackground(SystemColor.menu);
		txtpnTitulo.setText("Título");
		txtpnTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnTitulo.setBounds(10, 99, 45, 21);
		frmLibro.getContentPane().add(txtpnTitulo);
		
		JTextPane txtpnPrestado = new JTextPane();
		txtpnPrestado.setText("Está prestado");
		txtpnPrestado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnPrestado.setBackground(SystemColor.menu);
		txtpnPrestado.setBounds(17, 341, 264, 21);
		frmLibro.getContentPane().add(txtpnPrestado);
		
		JTextPane txtpnEdicion = new JTextPane();
		txtpnEdicion.setText("Año Edición");
		txtpnEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnEdicion.setBackground(SystemColor.menu);
		txtpnEdicion.setBounds(10, 219, 76, 21);
		frmLibro.getContentPane().add(txtpnEdicion);
		
		JTextPane txtpnAutor = new JTextPane();
		txtpnAutor.setText("Autor");
		txtpnAutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnAutor.setBackground(SystemColor.menu);
		txtpnAutor.setBounds(10, 159, 45, 21);
		frmLibro.getContentPane().add(txtpnAutor);
		
		JTextPane txtpnCategoria = new JTextPane();
		txtpnCategoria.setText("Categoria");
		txtpnCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnCategoria.setBackground(SystemColor.menu);
		txtpnCategoria.setBounds(10, 279, 60, 21);
		frmLibro.getContentPane().add(txtpnCategoria);
	
		JButton btnBuscar = new JButton("");					//***************************************Al Pulsar boton de busqueda para ElegirLibro
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.LibroElegidoController(Integer.parseInt(textPaneLibro.getText())); 
			}
		});
	
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\buscar.png"));
		btnBuscar.setBounds(256, 63, 25, 25);
		frmLibro.getContentPane().add(btnBuscar);
				
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarView confirmar = new ConfirmarView();	 //Activa la pantalla Confirmar		
			}
		});
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setBounds(391, 236, 207, 51);
		frmLibro.getContentPane().add(btnEliminar);
		
		JButton btnModificarTitulo = new JButton("");
		btnModificarTitulo.setToolTipText("Modificar Titulo");
		btnModificarTitulo.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTitulo.setEditable(true);
				textFieldTitulo.setForeground(Color.BLACK);
			}
		});
		btnModificarTitulo.setForeground(Color.RED);
		btnModificarTitulo.setBounds(65, 100, 22, 22);
		frmLibro.getContentPane().add(btnModificarTitulo);
		
		JButton btnModificarAutor = new JButton("");
		btnModificarAutor.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAutor.setEditable(true);
				textFieldAutor.setForeground(Color.BLACK);
			}
		});
		btnModificarAutor.setForeground(Color.RED);
		btnModificarAutor.setBounds(65, 159, 22, 22);
		frmLibro.getContentPane().add(btnModificarAutor);
		
		JButton btnModificarEdicion = new JButton("");
		btnModificarEdicion.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEdicion.setEditable(true);
				textFieldEdicion.setForeground(Color.BLACK);
			}
		});
		btnModificarEdicion.setForeground(Color.RED);
		btnModificarEdicion.setBounds(93, 219, 22, 22);
		frmLibro.getContentPane().add(btnModificarEdicion);
		
		JButton btnModificarCategoria = new JButton("");
		btnModificarCategoria.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCategoria.setEditable(true);
				textFieldCategoria.setForeground(Color.BLACK);
			}
		});
		btnModificarCategoria.setForeground(Color.RED);
		btnModificarCategoria.setBounds(78, 277, 22, 22);
		frmLibro.getContentPane().add(btnModificarCategoria);
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo");             //Boton AÑADIR NUEVO
		btnAñadirNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneLibro.setText(null);   //Borra el contenido del cuadro
				textPaneLibro.setForeground(Color.BLACK);//Cambia de color la letra
								
				textFieldTitulo.setText(null);
				textFieldTitulo.setEditable(true);
				textFieldTitulo.setForeground(Color.BLACK);
				textFieldTitulo.setBackground(Color.WHITE);
				
				textFieldAutor.setText(null);
				textFieldAutor.setEditable(true);
				textFieldAutor.setForeground(Color.BLACK);
				textFieldAutor.setBackground(Color.WHITE);
				
				textFieldEdicion.setText(null);
				textFieldEdicion.setEditable(true);
				textFieldEdicion.setForeground(Color.BLACK);
				textFieldEdicion.setBackground(Color.WHITE);
				
				textFieldCategoria.setText(null);
				textFieldCategoria.setEditable(true);
				textFieldCategoria.setForeground(Color.BLACK);
				textFieldCategoria.setBackground(Color.WHITE);
				
				btnAñadirNuevo.setVisible(false);
			}
		});
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		btnAñadirNuevo.setBounds(391, 112, 207, 51);
		frmLibro.getContentPane().add(btnAñadirNuevo);
		
		JButton btnConfirmarCambios = new JButton("Confirmar cambios");      //Boton CONFIRMAR CAMBIOS
		btnConfirmarCambios.setBackground(new Color(255, 192, 203));
		btnConfirmarCambios.setBounds(391, 174, 207, 51);
		btnConfirmarCambios.setForeground(new Color(0, 0, 0));
		btnConfirmarCambios.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmLibro.getContentPane().add(btnConfirmarCambios);btnConfirmarCambios.addActionListener(new ActionListener() { //PULSAR BOTON CONFIRMAR CAMBIOS _ Cuando se confirman los cambios se le quita el editable y cambia el color
			public void actionPerformed(ActionEvent e) {
				
				textFieldTitulo.setEditable(false); //Editable NO
				textFieldTitulo.setForeground(Color.GRAY);//Cambiar el color de la letra			
				textFieldTitulo.setBackground(new Color(233, 233, 233));
				
				textFieldAutor.setEditable(false); 
				textFieldAutor.setForeground(Color.GRAY);
				textFieldAutor.setBackground(new Color(233, 233, 233));
				
				textFieldEdicion.setEditable(false);
				textFieldEdicion.setForeground(Color.GRAY);
				textFieldEdicion.setBackground(new Color(233, 233, 233));
				
				textFieldCategoria.setEditable(false);
				textFieldCategoria.setForeground(Color.GRAY);
				textFieldCategoria.setBackground(new Color(233, 233, 233));
			}
		});
		
		
		JButton btnAtras = new JButton("Atrás"); //BOTON ATRAS
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLibro.setVisible(false);	
				BibliotecaController controlador = new BibliotecaController();
				controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 76, 27);
		frmLibro.getContentPane().add(btnAtras);
		
		frmLibro.setVisible(true);
		
	}	
		
	
	public TextField gettextFieldTitulo() {
		return this.textFieldTitulo;
	};
	
	public TextField gettextFieldAutor() {
		return this.textFieldAutor;
	};
	
	public TextField gettextFieldCategoria() {
		return this.textFieldCategoria;
	};
	
	public TextField gettextFieldEdicion() {
		return this.textFieldEdicion;
	};
	
	public void rellenaPrestamo(Object[] rowLibro) {
		
		this.tablaPrestamo.addRow(rowLibro);//para añadir una fila a la tabla lo primero que tengo que añadir es la 
												//fila al modelo correspondiente a esa tabla
		this.tablaLibro.setModel(tablaPrestamo); //una vez la tenga añadida al modelo, muestro el modelo en la tabla
	}
	
		
}
