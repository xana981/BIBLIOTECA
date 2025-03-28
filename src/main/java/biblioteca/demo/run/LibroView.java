package biblioteca.demo.run;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
				"ISBN", "Numero de socio", "Fecha prestamo", "Duracion"
			}
		);
		
		JLabel lblLibro = new JLabel("LIBRO"); //El titulo encabezado
		lblLibro.setBounds(267, 11, 99, 40);
		lblLibro.setForeground(new Color(255, 128, 192));
		lblLibro.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmLibro.getContentPane().add(lblLibro);
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo");             // Boton "AÑADIR NUEVO"
		btnAñadirNuevo.setForeground(Color.BLACK);                         
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		btnAñadirNuevo.setBounds(391, 112, 207, 51);
		frmLibro.getContentPane().add(btnAñadirNuevo);
		
		JButton btnConfirmarCambios = new JButton("Confirmar cambios");    // Boton "CONFIRMAR CAMBIOS"
		btnConfirmarCambios.setEnabled(false);
		btnConfirmarCambios.setBackground(new Color(255, 192, 203));
		btnConfirmarCambios.setBounds(391, 174, 207, 51);
		btnConfirmarCambios.setForeground(new Color(0, 0, 0));
		btnConfirmarCambios.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmLibro.getContentPane().add(btnConfirmarCambios);
		
		JButton btnEliminar = new JButton("Eliminar");          // Boton "ELIMINAR"
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setBounds(391, 236, 207, 51);
		frmLibro.getContentPane().add(btnEliminar);
	
		// Vista Botones MODIFICAR
		
		JButton btnModificarTitulo = new JButton("");
		btnModificarTitulo.setEnabled(false);
		btnModificarTitulo.setToolTipText("Modificar Titulo");
		btnModificarTitulo.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarTitulo.setBounds(65, 100, 22, 22);
		frmLibro.getContentPane().add(btnModificarTitulo);		
		
		
		JButton btnModificarAutor = new JButton("");
		btnModificarAutor.setEnabled(false);
		btnModificarAutor.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarAutor.setBounds(65, 159, 22, 22);
		frmLibro.getContentPane().add(btnModificarAutor);
	
		JButton btnModificarEdicion = new JButton("");
		btnModificarEdicion.setEnabled(false);
		btnModificarEdicion.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarEdicion.setBounds(93, 219, 22, 22);
		frmLibro.getContentPane().add(btnModificarEdicion);
	
		JButton btnModificarCategoria = new JButton("");
		btnModificarCategoria.setEnabled(false);
		btnModificarCategoria.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnModificarCategoria.setBounds(78, 277, 22, 22);
		frmLibro.getContentPane().add(btnModificarCategoria);
		
		
		JTextPane textPaneLibro = new JTextPane();     //Cuadro para introducir el ISBN
		textPaneLibro.setText("< Introduce el isbn >");
		textPaneLibro.setForeground(Color.GRAY);
		textPaneLibro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneLibro.setBounds(103, 62, 142, 27);
		frmLibro.getContentPane().add(textPaneLibro);
		textPaneLibro.addMouseListener(new MouseAdapter() { //Al pulsar sobre el cuadro textPaneLibro
			@Override
			public void mouseClicked(MouseEvent e) {
		
				if  (tablaPrestamo.getRowCount() > 0) { // Si la tabla tiene valores los ELIMINA para comenzar de nuevo
					tablaPrestamo.removeRow(0);
				}
				
				textPaneLibro.setForeground(Color.BLACK); //Cambia de color la letra
				textPaneLibro.setText(null);   //Borra el contenido del cuadro

				textFieldTitulo.setText("Titulo del libro");
				textFieldAutor.setText("Autor del libro");
				textFieldEdicion.setText("Año de edición del libro");
				textFieldCategoria.setText("Categoría del libro");
				
				tablaLibro.setVisible(false);
			}
		});

		JScrollPane scrollPaneLibro = new JScrollPane();
		scrollPaneLibro.setToolTipText("");
		scrollPaneLibro.setBounds(20, 373, 592, 51);
		frmLibro.getContentPane().add(scrollPaneLibro);
		
		tablaLibro = new JTable();
		tablaLibro.setVisible(false);
		tablaLibro.setColumnSelectionAllowed(true);
		tablaLibro.setModel(tablaPrestamo);
		tablaLibro.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		tablaLibro.getColumnModel().getColumn(0).setResizable(false);
		tablaLibro.getColumnModel().getColumn(1).setResizable(false);
		tablaLibro.getColumnModel().getColumn(2).setResizable(false);
		tablaLibro.getColumnModel().getColumn(3).setResizable(false);
		scrollPaneLibro.setViewportView(tablaLibro);
		
		JTextPane txtpnIntroducirLibro = new JTextPane();
		txtpnIntroducirLibro.setEditable(false);
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
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setBackground(SystemColor.menu);
		txtpnTitulo.setText("Título");
		txtpnTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnTitulo.setBounds(10, 99, 45, 21);
		frmLibro.getContentPane().add(txtpnTitulo);
		
		JTextPane txtpnPrestado = new JTextPane();
		txtpnPrestado.setEditable(false);
		txtpnPrestado.setText("Está prestado");
		txtpnPrestado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnPrestado.setBackground(SystemColor.menu);
		txtpnPrestado.setBounds(17, 341, 264, 21);
		frmLibro.getContentPane().add(txtpnPrestado);
		
		JTextPane txtpnEdicion = new JTextPane();
		txtpnEdicion.setEditable(false);
		txtpnEdicion.setText("Año Edición");
		txtpnEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnEdicion.setBackground(SystemColor.menu);
		txtpnEdicion.setBounds(10, 219, 76, 21);
		frmLibro.getContentPane().add(txtpnEdicion);
		
		JTextPane txtpnAutor = new JTextPane();
		txtpnAutor.setEditable(false);
		txtpnAutor.setText("Autor");
		txtpnAutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnAutor.setBackground(SystemColor.menu);
		txtpnAutor.setBounds(10, 159, 45, 21);
		frmLibro.getContentPane().add(txtpnAutor);
		
		JTextPane txtpnCategoria = new JTextPane();
		txtpnCategoria.setEditable(false);
		txtpnCategoria.setText("Categoria");
		txtpnCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnCategoria.setBackground(SystemColor.menu);
		txtpnCategoria.setBounds(10, 279, 60, 21);
		frmLibro.getContentPane().add(txtpnCategoria);
	
		//***************************************Al Pulsar boton de BUCAR para ElegirLibro
		JButton btnBuscar = new JButton("");					
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((textPaneLibro.getText()) == "") {
					JOptionPane.showMessageDialog(null, "No has introducido ningún valor");
				}
				else {
					controlador.LibroElegidoController(Integer.parseInt(textPaneLibro.getText())); 
				
					btnModificarTitulo.setEnabled(true);
					btnModificarAutor.setEnabled(true);
					btnModificarEdicion.setEnabled(true);
					btnModificarCategoria.setEnabled(true);
	
					btnEliminar.setEnabled(true);
					
					tablaLibro.setVisible(true);
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\buscar.png"));
		btnBuscar.setBounds(256, 63, 25, 25);
		frmLibro.getContentPane().add(btnBuscar);
				
 		//EJECUTAR botones de MODIFICACION DE DATOS
		
		btnModificarTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTitulo.setEditable(true);
				textFieldTitulo.setForeground(Color.BLACK);
				textFieldTitulo.setBackground(Color.WHITE);
				
				btnConfirmarCambios.setEnabled(true);
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
				tablaLibro.setVisible(false);
			}
		});

		btnModificarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAutor.setEditable(true);
				textFieldAutor.setForeground(Color.BLACK);
				textFieldAutor.setBackground(Color.WHITE);
				
				btnConfirmarCambios.setEnabled(true);
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
				tablaLibro.setVisible(false);
			}
		});

		btnModificarEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEdicion.setEditable(true);
				textFieldEdicion.setForeground(Color.BLACK);
				textFieldEdicion.setBackground(Color.WHITE);
				
				btnConfirmarCambios.setEnabled(true);
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
				tablaLibro.setVisible(false);
			}
		});
		
		btnModificarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCategoria.setEditable(true);
				textFieldCategoria.setForeground(Color.BLACK);
				textFieldCategoria.setBackground(Color.WHITE);
				
				btnConfirmarCambios.setEnabled(true);
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
				tablaLibro.setVisible(false);
			}
		});
		
		btnConfirmarCambios.addActionListener(new ActionListener() { //EJECUTAR BOTON CONFIRMAR CAMBIOS 
			public void actionPerformed(ActionEvent e) {
				
				
				//******* pendiente GRABAR DATOS en base de datos
				
				int n = JOptionPane.showConfirmDialog(btnConfirmarCambios,"¿Estas seguro de CONFIRMAR los cambios?","Mensaje",JOptionPane.YES_NO_OPTION);	
				
				if(n==0) {    //Si la respuesta es SI
					
					//PDTE modificar los datos en la BD...
					
					BibliotecaController controlador = new BibliotecaController();
					controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
					frmLibro.setVisible(false);   //Cuando se confirman los cambios se le quita el editable y cambia el color
				}
			}
		});
		
    	btnAñadirNuevo.addActionListener(new ActionListener() {   // EJECUTAR Boton AÑADIR NUEVO
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
				
				
				btnConfirmarCambios.setEnabled(true);
				btnAñadirNuevo.setEnabled(false);
				btnEliminar.setEnabled(false);
				tablaLibro.setVisible(false);
			}
		});
    	
		btnEliminar.addActionListener(new ActionListener() {      // EJECUTAR Boton ELIMINAR
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(btnEliminar,"Estas seguro de ELIMINAR registro?","Mensaje",JOptionPane.YES_NO_OPTION);				
				///ConfirmarView confirmar = new ConfirmarView();	 *******************************************************Activa la pantalla Confirmar		
			}
		});

		JButton btnAtras = new JButton("Atrás");              //BOTON ATRAS
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
