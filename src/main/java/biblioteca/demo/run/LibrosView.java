package biblioteca.demo.run;
import javax.swing.JFrame;
import biblioteca.demo.run.BibliotecaView;
import javax.swing.JButton;
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

public class LibrosView {
	
	protected JFrame frmLibro;
	private JTable tableLibro;
	
	public LibrosView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmLibro = new JFrame();
		frmLibro.setSize(new Dimension(650, 480));
		frmLibro.setResizable(false);
		frmLibro.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmLibro.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnCambioLibro = new JButton("Confirmar cambios"); //Boton confirmar cambios
		btnCambioLibro.setBackground(new Color(255, 192, 203));
		btnCambioLibro.setBounds(391, 174, 207, 51);
		btnCambioLibro.setForeground(new Color(0, 0, 0));
		btnCambioLibro.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		frmLibro.getContentPane().setLayout(null);
		
		JLabel lblLibro = new JLabel("LIBRO");
		lblLibro.setBounds(267, 11, 99, 40);
		lblLibro.setForeground(new Color(255, 128, 192));
		lblLibro.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmLibro.getContentPane().add(lblLibro);
		frmLibro.getContentPane().add(btnCambioLibro);
		
		JScrollPane scrollPaneLibro = new JScrollPane();
		scrollPaneLibro.setToolTipText("");
		scrollPaneLibro.setBounds(20, 373, 592, 51);
		frmLibro.getContentPane().add(scrollPaneLibro);
		
		tableLibro = new JTable();
		tableLibro.setColumnSelectionAllowed(true);
		tableLibro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tableLibro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"N\u00BA Socio", "Nombre", "Fecha pr\u00E9stamo", "Duraci\u00F3n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableLibro.getColumnModel().getColumn(0).setResizable(false);
		tableLibro.getColumnModel().getColumn(0).setPreferredWidth(56);
		tableLibro.getColumnModel().getColumn(1).setPreferredWidth(222);
		tableLibro.getColumnModel().getColumn(2).setPreferredWidth(92);
		tableLibro.getColumnModel().getColumn(3).setResizable(false);
		tableLibro.getColumnModel().getColumn(3).setPreferredWidth(70);
		scrollPaneLibro.setViewportView(tableLibro);

		// Cuadros de texto con las celdas		
		
		TextField textFieldTitulo = new TextField();
		textFieldTitulo.setEditable(false);
		textFieldTitulo.setText("Titulo del libro");
		textFieldTitulo.setForeground(Color.GRAY);
		textFieldTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldTitulo.setBackground(new Color(233, 233, 233));
		textFieldTitulo.setBounds(20, 126, 323, 21);
		frmLibro.getContentPane().add(textFieldTitulo);
		
		TextField textFieldAutor = new TextField();
		textFieldAutor.setText("Autor del libro");
		textFieldAutor.setForeground(Color.GRAY);
		textFieldAutor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldAutor.setEditable(false);
		textFieldAutor.setBackground(new Color(233, 233, 233));
		textFieldAutor.setBounds(20, 186, 323, 21);
		frmLibro.getContentPane().add(textFieldAutor);
		
		TextField textFieldEdicion = new TextField();
		textFieldEdicion.setText("Año de edición del libro");
		textFieldEdicion.setForeground(Color.GRAY);
		textFieldEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldEdicion.setEditable(false);
		textFieldEdicion.setBackground(new Color(233, 233, 233));
		textFieldEdicion.setBounds(20, 246, 147, 21);
		frmLibro.getContentPane().add(textFieldEdicion);
		
		TextField textFieldCategoria = new TextField();
		textFieldCategoria.setText("Categoría del libro");
		textFieldCategoria.setForeground(Color.GRAY);
		textFieldCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldCategoria.setEditable(false);
		textFieldCategoria.setBackground(new Color(233, 233, 233));
		textFieldCategoria.setBounds(20, 306, 147, 21);
		frmLibro.getContentPane().add(textFieldCategoria);
		JTextPane txtpnIntroducirLibro = new JTextPane();
		txtpnIntroducirLibro.setBackground(SystemColor.menu);
		txtpnIntroducirLibro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirLibro.setText("Introducir isbn");
		txtpnIntroducirLibro.setBounds(10, 62, 91, 27);
		frmLibro.getContentPane().add(txtpnIntroducirLibro);
		
		TextField textFieldLibro = new TextField();

		textFieldLibro.setForeground(Color.GRAY);
		textFieldLibro.setBackground(Color.WHITE);
		textFieldLibro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldLibro.setText("< Introduce el isbn >");
		textFieldLibro.setBounds(107, 62, 174, 21);
		frmLibro.getContentPane().add(textFieldLibro);
		
		textFieldLibro.addMouseListener(new MouseAdapter() { //Cuando se entra en el cuadro 
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldLibro.setText(null);   //Borra el contenido del cuadro
				textFieldLibro.setForeground(Color.BLACK); //Cambia de color la letra
			}
		});
		
		
		JTextPane txtpnTitulo = new JTextPane();
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
		
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo"); //Boton AÑADIR NUEVO
		btnAñadirNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLibro.setText(null);   //Borra el contenido del cuadro
				textFieldLibro.setForeground(Color.BLACK);//Cambia de color la letra
								
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
			}
		});
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		btnAñadirNuevo.setBounds(391, 112, 207, 51);
		frmLibro.getContentPane().add(btnAñadirNuevo);
		
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
		
		JButton btnAutor = new JButton("");
		btnAutor.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAutor.setEditable(true);
				textFieldAutor.setForeground(Color.BLACK);
			}
		});
		btnAutor.setForeground(Color.RED);
		btnAutor.setBounds(65, 159, 22, 22);
		frmLibro.getContentPane().add(btnAutor);
		
		JButton btnEdicion = new JButton("");
		btnEdicion.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEdicion.setEditable(true);
				textFieldEdicion.setForeground(Color.BLACK);
			}
		});
		btnEdicion.setForeground(Color.RED);
		btnEdicion.setBounds(93, 219, 22, 22);
		frmLibro.getContentPane().add(btnEdicion);
		
		JButton btnCategoria = new JButton("");
		btnCategoria.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCategoria.setEditable(true);
				textFieldCategoria.setForeground(Color.BLACK);
			}
		});
		btnCategoria.setForeground(Color.RED);
		btnCategoria.setBounds(78, 277, 22, 22);
		frmLibro.getContentPane().add(btnCategoria);
		
		btnCambioLibro.addActionListener(new ActionListener() { //PULSAR BOTON CONFIRMAR CAMBIOS _ Cuando se confirman los cambios se le quita el editable y cambia el color
			public void actionPerformed(ActionEvent e) {
				textFieldLibro.setForeground(Color.GRAY);
				
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
				BibliotecaView biblioteca = new BibliotecaView();	 //Cambio de pantalla
				frmLibro.setVisible(false);	
			}
		});
		

		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 76, 27);
		frmLibro.getContentPane().add(btnAtras);
		
		
		frmLibro.setVisible(true);
	}
}
