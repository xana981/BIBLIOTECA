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
import net.miginfocom.swing.MigLayout;

public class LibroPruebaView {
	
	protected JFrame frmLibro;
	private JTable tableLibro;
	private LibroController controlador;
	
	public LibroPruebaView(LibroController c) {
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
		frmLibro.getContentPane().setLayout(new MigLayout("", "[102.00px][249.00,grow][][59.00px]", "[40px][27px,grow][23px,grow][grow][21px,grow][35.00,grow][][68.00]"));
				
				JLabel lblLibro = new JLabel("LIBRO");
				lblLibro.setForeground(new Color(255, 128, 192));
				lblLibro.setFont(new Font("Times New Roman", Font.BOLD, 28));
				frmLibro.getContentPane().add(lblLibro, "cell 1 0,alignx center,growy");
				
				JEditorPane editorPaneISBN = new JEditorPane();
				frmLibro.getContentPane().add(editorPaneISBN, "cell 1 1,grow");
		
		JEditorPane editorPane_1 = new JEditorPane();
		frmLibro.getContentPane().add(editorPane_1, "cell 1 2,grow");
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo"); //Boton AÑADIR NUEVO
		
		JButton btnEdicion = new JButton("");
		btnEdicion.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));

		btnEdicion.setForeground(Color.RED);
		frmLibro.getContentPane().add(btnEdicion, "cell 2 2,alignx center,aligny center");
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		frmLibro.getContentPane().add(btnAñadirNuevo, "cell 3 2,grow");
		
		JTextPane txtpnAutor = new JTextPane();
		txtpnAutor.setText("Autor");
		txtpnAutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnAutor.setBackground(SystemColor.menu);
		frmLibro.getContentPane().add(txtpnAutor, "cell 0 3,growx");
		
		JEditorPane editorPane_2 = new JEditorPane();
		frmLibro.getContentPane().add(editorPane_2, "cell 1 3,grow");
		
		JButton btnCategoria = new JButton("");
		btnCategoria.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));

		btnCategoria.setForeground(Color.RED);
		frmLibro.getContentPane().add(btnCategoria, "cell 2 3,growx,aligny center");
		
		JButton btnCambioLibro = new JButton("Confirmar cambios"); //Boton confirmar cambios
		btnCambioLibro.setBackground(new Color(255, 192, 203));
		btnCambioLibro.setForeground(new Color(0, 0, 0));
		btnCambioLibro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frmLibro.getContentPane().add(btnCambioLibro, "cell 3 3,grow");
		
		JTextPane txtpnEdicion = new JTextPane();
		txtpnEdicion.setText("Año Edición");
		txtpnEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnEdicion.setBackground(SystemColor.menu);
		frmLibro.getContentPane().add(txtpnEdicion, "flowx,cell 0 4,alignx left,aligny center");
		
		JEditorPane editorPane_2_1 = new JEditorPane();
		frmLibro.getContentPane().add(editorPane_2_1, "cell 1 4,grow");
		
		JButton btnCategoria_1 = new JButton("");
		btnCategoria_1.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnCategoria_1.setForeground(Color.RED);
		frmLibro.getContentPane().add(btnCategoria_1, "cell 2 4");
		
		JButton btnEliminar = new JButton("Añadir nuevo");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		frmLibro.getContentPane().add(btnEliminar, "cell 3 4,grow");
		
		JTextPane txtpnCategoria = new JTextPane();
		txtpnCategoria.setText("Categoria");
		txtpnCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnCategoria.setBackground(SystemColor.menu);
		frmLibro.getContentPane().add(txtpnCategoria, "cell 0 5,alignx left,aligny center");
		
		JEditorPane editorPane_2_1_1 = new JEditorPane();
		frmLibro.getContentPane().add(editorPane_2_1_1, "cell 1 5,grow");
		
		JButton btnCategoria_1_1 = new JButton("");
		btnCategoria_1_1.setIcon(new ImageIcon("C:\\Users\\mañana\\Vero\\Iconos\\icons8-modificar-16.png"));
		btnCategoria_1_1.setForeground(Color.RED);
		frmLibro.getContentPane().add(btnCategoria_1_1, "cell 2 5");
		
		JTextPane txtpnPrestado = new JTextPane();
		txtpnPrestado.setText("Está prestado");
		txtpnPrestado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnPrestado.setBackground(SystemColor.menu);
		frmLibro.getContentPane().add(txtpnPrestado, "cell 0 6,grow");
		
		JTextPane txtpnIntroducirLibro = new JTextPane();
		txtpnIntroducirLibro.setBackground(SystemColor.menu);
		txtpnIntroducirLibro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirLibro.setText("Introducir isbn");
		frmLibro.getContentPane().add(txtpnIntroducirLibro, "cell 0 1,alignx left,aligny center");
				
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setBackground(SystemColor.menu);
		txtpnTitulo.setText("Título");
		txtpnTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmLibro.getContentPane().add(txtpnTitulo, "cell 0 2,growx,aligny center");
		
		
		 try { //Titulo
	            Connection connection = DriverManager.getConnection("jdbc:sqlite:Biblioteca.db");
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT Titulo FROM Libro WHERE ISBN == '100259'");     ///********************************************
	            
	            if (resultSet.next()) {
	                String data = resultSet.getString("Titulo");
	            }

	            // Cerrar la conexión
	            resultSet.close();
	            statement.close();
	            connection.close();
	     } 
		 catch (Exception e) {
			 e.printStackTrace();
	     }
	    
		 try { //Autor
	            Connection connection = DriverManager.getConnection("jdbc:sqlite:Biblioteca.db");
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT Autor FROM Libro WHERE ISBN == '100259'");
	       	            
	            if (resultSet.next()) {
	                String data = resultSet.getString("Autor");

	            }

	            // Cerrar la conexión
	            resultSet.close();         
	            statement.close();
	            connection.close();
	     } 
		 catch (Exception e) {
			 e.printStackTrace();
	     }
		
		 try { //Año edicion
	            Connection connection = DriverManager.getConnection("jdbc:sqlite:Biblioteca.db");
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT añoEdicion FROM Libro WHERE ISBN == '100259'");
	       	            
	            if (resultSet.next()) {
	                String data = resultSet.getString("añoEdicion");
	            }

	            // Cerrar la conexión
	            resultSet.close();         
	            statement.close();
	            connection.close();
	     } 
		 catch (Exception e) {
			 e.printStackTrace();
	     }
		
		 try { //Año categoria
	            Connection connection = DriverManager.getConnection("jdbc:sqlite:Biblioteca.db");
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT categoria FROM Libro WHERE ISBN == '100259'");
	       	            
	            if (resultSet.next()) {
	                String data = resultSet.getString("categoria");
	                if (data.equals("0")) {

	                }
	                else if (data.equals("1")) {

	                }
	            }

	            // Cerrar la conexión
	            resultSet.close();         
	            statement.close();
	            connection.close();
	     } 
		 catch (Exception e) {
			 e.printStackTrace();
	     }
		
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
		frmLibro.getContentPane().add(btnAtras, "cell 0 0,growx,aligny center");
		
				JScrollPane scrollPaneLibro = new JScrollPane();
				scrollPaneLibro.setToolTipText("");
				frmLibro.getContentPane().add(scrollPaneLibro, "cell 0 7 4 1,grow");
				
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
		
		
		frmLibro.setVisible(true);
	}
}
