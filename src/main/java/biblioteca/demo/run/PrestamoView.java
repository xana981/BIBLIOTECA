package biblioteca.demo.run;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Label;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Choice;

public class PrestamoView {
	
	protected JFrame frmPrestamo;
	private JTable tablaPrestados;
	private PrestamoController controlador;
	private TextField textFieldNombre;
	private TextField textFieldNacimiento;
	private TextField textFieldTitulo; 
	private TextField textFieldPrestado;
	private DefaultTableModel tablaPrestamo;

	
	public PrestamoView(PrestamoController c) {
		inicialize(c);
	}
	
	private void inicialize(PrestamoController cont) {
		
		frmPrestamo = new JFrame();
		frmPrestamo.setVisible(true);
		frmPrestamo.setSize(new Dimension(787, 540));
		frmPrestamo.setResizable(false);
		frmPrestamo.setLocationRelativeTo(null);
		controlador=cont;
		frmPrestamo.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmPrestamo.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		tablaPrestamo = new DefaultTableModel(new Object[][] {
		},
		new String[] {
				"ISBN", "Titulo", "Fecha prestamo", "Duracion"
			}
		);
		
		JLabel lblPrestamoDevolucion = new JLabel(" PRÉSTAMO / DEVOLUCIÓN");
		lblPrestamoDevolucion.setBounds(223, 11, 405, 40);
		lblPrestamoDevolucion.setForeground(new Color(255, 128, 192));
		lblPrestamoDevolucion.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmPrestamo.getContentPane().add(lblPrestamoDevolucion);
		
		JButton btnPrestamo = new JButton("Confirmar préstamo");
		btnPrestamo.setBackground(new Color(255, 192, 203));
		btnPrestamo.setBounds(55, 435, 207, 51);
		btnPrestamo.setForeground(new Color(0, 0, 0));
		btnPrestamo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarView confirmar = new ConfirmarView();	 //Activa la pantalla Confirmar	
			}
		});
		frmPrestamo.getContentPane().setLayout(null);
		frmPrestamo.getContentPane().add(btnPrestamo);
		
		JTextPane textPaneSocio = new JTextPane();
		textPaneSocio.setForeground(Color.GRAY);
		textPaneSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneSocio.setText("< Introducir nº de socio >");
		textPaneSocio.setBounds(152, 62, 156, 26);
		textPaneSocio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPaneSocio.setForeground(Color.BLACK);//Cambiar el color de la letra				
				textPaneSocio.setText(null); //Quitar el texto de socio para poder escribir el numero del codigo
			}
		});
		frmPrestamo.getContentPane().add(textPaneSocio);
		
		// *********************** Mostrar BOTON BUSCAR
		JButton btnBuscarSocio = new JButton("");
		btnBuscarSocio.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\buscar.png"));
		btnBuscarSocio.setBounds(318, 62, 25, 27);
		frmPrestamo.getContentPane().add(btnBuscarSocio);
		
		JButton btnBuscarISBN = new JButton("");
		btnBuscarISBN.setEnabled(false);
		btnBuscarISBN.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\buscar.png"));
		btnBuscarISBN.setBounds(250, 288, 25, 27);
		frmPrestamo.getContentPane().add(btnBuscarISBN);
		
		
		JScrollPane scrollPanePrestados = new JScrollPane();
		scrollPanePrestados.setToolTipText("");
		scrollPanePrestados.setBounds(20, 197, 729, 80);
		frmPrestamo.getContentPane().add(scrollPanePrestados);
		
		tablaPrestados = new JTable();
		tablaPrestados.setCellSelectionEnabled(true);
		tablaPrestados.setEnabled(true);
		tablaPrestados.setColumnSelectionAllowed(true);
		tablaPrestados.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tablaPrestados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"isbn", "Numero de socio", "Fecha pr\u00E9stamo", "Duraci\u00F3n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaPrestados.getColumnModel().getColumn(0).setResizable(false);
		tablaPrestados.getColumnModel().getColumn(0).setPreferredWidth(40);
		tablaPrestados.getColumnModel().getColumn(1).setResizable(false);
		tablaPrestados.getColumnModel().getColumn(1).setPreferredWidth(96);
		tablaPrestados.getColumnModel().getColumn(2).setResizable(false);
		tablaPrestados.getColumnModel().getColumn(2).setPreferredWidth(70);
		tablaPrestados.getColumnModel().getColumn(3).setResizable(false);
		tablaPrestados.getColumnModel().getColumn(3).setPreferredWidth(70);
		scrollPanePrestados.setViewportView(tablaPrestados);
		
		// Mostrar los TextField
		this.textFieldNombre = new TextField();
		textFieldNombre.setForeground(Color.GRAY);
		textFieldNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldNombre.setText("Nombre y apellidos");
		textFieldNombre.setEditable(false);
		textFieldNombre.setBackground(new Color(233, 233, 233));
		textFieldNombre.setBounds(20, 126, 405, 21);
		frmPrestamo.getContentPane().add(textFieldNombre);
		
		this.textFieldNacimiento = new TextField();
		textFieldNacimiento.setText("Fecha nacimiento");
		textFieldNacimiento.setForeground(Color.GRAY);
		textFieldNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldNacimiento.setEditable(false);
		textFieldNacimiento.setBounds(470, 126, 156, 21);
		textFieldNacimiento.setBackground(new Color(233, 233, 233));
		frmPrestamo.getContentPane().add(textFieldNacimiento);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setText("Titulo");
		txtpnTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setBackground(SystemColor.menu);
		txtpnTitulo.setBounds(10, 323, 47, 21);
		frmPrestamo.getContentPane().add(txtpnTitulo);
		
		this.textFieldTitulo = new TextField();
		textFieldTitulo.setText("Titulo");
		textFieldTitulo.setForeground(Color.GRAY);
		textFieldTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldTitulo.setEditable(false);
		textFieldTitulo.setBackground(new Color(233, 233, 233));
		textFieldTitulo.setBounds(20, 356, 328, 21);
		frmPrestamo.getContentPane().add(textFieldTitulo);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setEditable(false);
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		txtpnIntroducirSocio.setBounds(10, 62, 132, 27);
		frmPrestamo.getContentPane().add(txtpnIntroducirSocio);
		
		JTextPane txtpnISBN = new JTextPane();  //Cuadro para INTRODUCIR ISBN
		txtpnISBN.setEditable(false);
		txtpnISBN.setText("Introducir isbn");
		txtpnISBN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnISBN.setBackground(SystemColor.menu);
		txtpnISBN.setBounds(10, 288, 97, 27);
		frmPrestamo.getContentPane().add(txtpnISBN);
		
		JTextPane textPaneISBN = new JTextPane();
		textPaneISBN.setEditable(false);
		textPaneISBN.setEnabled(false);
		textPaneISBN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPaneISBN.setForeground(Color.BLACK);//Cambiar el color de la letra				
				textPaneISBN.setText(null); //Quitar el texto de socio para poder escribir el numero del codigo
			}
		});
		textPaneISBN.setText("< Introducir ISBN >");
		textPaneISBN.setForeground(Color.GRAY);
		textPaneISBN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textPaneISBN.setBounds(117, 288, 123, 26);
		frmPrestamo.getContentPane().add(textPaneISBN);
		
		JTextPane txtpnPrestado = new JTextPane();
		txtpnPrestado.setText("¿Esta prestado?");
		txtpnPrestado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnPrestado.setEditable(false);
		txtpnPrestado.setBackground(SystemColor.menu);
		txtpnPrestado.setBounds(410, 323, 97, 26);
		frmPrestamo.getContentPane().add(txtpnPrestado);
		
		this.textFieldPrestado = new TextField();
		textFieldPrestado.setText("Si / No");
		textFieldPrestado.setForeground(Color.GRAY);
		textFieldPrestado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldPrestado.setEditable(false);
		textFieldPrestado.setBackground(new Color(233, 233, 233));
		textFieldPrestado.setBounds(420, 356, 55, 21);
		frmPrestamo.getContentPane().add(textFieldPrestado);
		
		JTextPane txtpnNombreApellidos = new JTextPane();
		txtpnNombreApellidos.setEditable(false);
		txtpnNombreApellidos.setBackground(SystemColor.menu);
		txtpnNombreApellidos.setText("Nombre y apellidos del socio");
		txtpnNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNombreApellidos.setBounds(10, 99, 180, 21);
		frmPrestamo.getContentPane().add(txtpnNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setEditable(false);
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		txtpnListaDeLibros.setBounds(10, 165, 264, 21);
		frmPrestamo.getContentPane().add(txtpnListaDeLibros);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setEditable(false);
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		txtpnFechaNacimiento.setBounds(460, 99, 218, 21);
		frmPrestamo.getContentPane().add(txtpnFechaNacimiento);
		
		JTextPane txtpnDuracion = new JTextPane();
		txtpnDuracion.setEditable(false);
		txtpnDuracion.setText("Duración préstamo");
		txtpnDuracion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnDuracion.setBackground(SystemColor.menu);
		txtpnDuracion.setBounds(10, 383, 123, 31);
		frmPrestamo.getContentPane().add(txtpnDuracion);
		
		// Mostrar RADIO BUTTON 15 o 30 dias
		JRadioButton rdbtn15 = new JRadioButton("15 días");
		rdbtn15.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtn15.setBounds(139, 383, 70, 31);
		frmPrestamo.getContentPane().add(rdbtn15);
		
		JRadioButton rdbtn30 = new JRadioButton("30 días");
		rdbtn30.setToolTipText("");
		rdbtn30.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtn30.setBounds(211, 383, 70, 31);
		frmPrestamo.getContentPane().add(rdbtn30);
		
		// Mostrar BOTON Devolucion
		JButton btnDevolucion = new JButton("Confirmar devolución");
		btnDevolucion.setForeground(Color.BLACK);
		btnDevolucion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDevolucion.setBackground(new Color(255, 192, 203));
		btnDevolucion.setBounds(495, 435, 226, 51);
		frmPrestamo.getContentPane().add(btnDevolucion);
				
		// EJECUTAR BOTONES BUSCAR
		btnBuscarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textPaneSocio.getText()) == "") {   //Comprobar si se ha introducido algun valor
					JOptionPane.showMessageDialog(null, "No has introducido ningún valor");
				}
				else {
					controlador.SocioElegidoPController(Integer.parseInt(textPaneSocio.getText()));
					textPaneISBN.setEnabled(true);
					textPaneISBN.setEditable(true);
					btnBuscarISBN.setEnabled(true);
					
				}
			}
		});
		
		
		btnBuscarISBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textPaneISBN.getText()) == "") {   //Comprobar si se ha introducido algun valor
					JOptionPane.showMessageDialog(null, "No has introducido ningún valor");
				}
				else {
					controlador.LibroElegidoController(Integer.parseInt(textPaneISBN.getText()));
				}
			}
		});
				
				
		//EJECUTAR BOTONES 15 o 30 dias para que no pueda marcar los 2 a la vez
		rdbtn15.addActionListener(new ActionListener() { //Si se toca "15 dias", se desactiva "30 dias"
			public void actionPerformed(ActionEvent e) {
				rdbtn30.setSelected(false);
			}
		});
		
		rdbtn30.addActionListener(new ActionListener() {//Si se toca "30 dias", se desactiva "15 dias"
			public void actionPerformed(ActionEvent e) {
				rdbtn15.setSelected(false);
			}
		});
		
		//EJECUTAR BOTON DEVOLUCION
		btnDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarView confirmar = new ConfirmarView();	 //Activa la pantalla Confirmar	
			}
		});
		
		// BOTON ATRAS
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPrestamo.setVisible(false);
				BibliotecaController controlador = new BibliotecaController();
				controlador.setVistaModel(new BibliotecaView(controlador), new BibliotecaModel());
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 70, 27);
		frmPrestamo.getContentPane().add(btnAtras);
		

		
	}

	public TextField gettextFieldNombre() {
		return this.textFieldNombre;
	}

	public TextField gettextFieldNacimiento() {
		return this.textFieldNacimiento;
	}
	
	public TextField gettextFieldTitulo() {
		return this.textFieldTitulo;
	}
	
	public TextField gettextFieldPrestado() {
		return this.textFieldPrestado;
	}
	
	public void rellenaPrestamo(Object[] rowPrestados) {  //RELLENAR TABLA
		
		this.tablaPrestamo.addRow(rowPrestados); //para añadir una fila a la tabla lo primero que tengo que añadir es la 
												//fila al modelo correspondiente a esa tabla
		this.tablaPrestados.setModel(tablaPrestamo); //una vez la tenga añadida al modelo, muestro el modelo en la tabla
	}
	

}
