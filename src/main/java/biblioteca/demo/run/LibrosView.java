package biblioteca.demo.run;
import javax.swing.JFrame;
import biblioteca.demo.run.BibliotecaView;
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

public class LibrosView {
	
	protected JFrame frmBiblioteca;
	private JTable tableLibro;
	
	public LibrosView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnCambioLibro = new JButton("Confirmar cambios");
		btnCambioLibro.setBackground(new Color(255, 192, 203));
		btnCambioLibro.setBounds(376, 174, 207, 51);
		btnCambioLibro.setForeground(new Color(0, 0, 0));
		btnCambioLibro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCambioLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblLibro = new JLabel("LIBRO");
		lblLibro.setBounds(267, 11, 99, 40);
		lblLibro.setForeground(new Color(0, 0, 255));
		lblLibro.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblLibro);
		frmBiblioteca.getContentPane().add(btnCambioLibro);
		
		JScrollPane scrollPaneLibro = new JScrollPane();
		scrollPaneLibro.setToolTipText("");
		scrollPaneLibro.setBounds(20, 373, 592, 51);
		frmBiblioteca.getContentPane().add(scrollPaneLibro);
		
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
		
		JTextPane txtpnIntroducirLibro = new JTextPane();
		txtpnIntroducirLibro.setBackground(SystemColor.menu);
		txtpnIntroducirLibro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirLibro.setText("Introducir isbn");
		txtpnIntroducirLibro.setBounds(10, 62, 91, 27);
		frmBiblioteca.getContentPane().add(txtpnIntroducirLibro);
		
		TextField textFieldLibro = new TextField();
		textFieldLibro.setForeground(Color.GRAY);
		textFieldLibro.setBackground(Color.WHITE);
		textFieldLibro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldLibro.setText("< Introduce el isbn >");
		textFieldLibro.setBounds(107, 62, 174, 27);
		frmBiblioteca.getContentPane().add(textFieldLibro);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setBackground(SystemColor.menu);
		txtpnTitulo.setText("Título");
		txtpnTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnTitulo.setBounds(10, 99, 45, 21);
		frmBiblioteca.getContentPane().add(txtpnTitulo);
		
		Label labelTitulo = new Label("Titulo del libro");
		labelTitulo.setForeground(Color.GRAY);
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelTitulo.setBounds(20, 126, 350, 27);
		frmBiblioteca.getContentPane().add(labelTitulo);
		
		JTextPane txtpnPrestado = new JTextPane();
		txtpnPrestado.setText("Está prestado");
		txtpnPrestado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnPrestado.setBackground(SystemColor.menu);
		txtpnPrestado.setBounds(17, 341, 264, 21);
		frmBiblioteca.getContentPane().add(txtpnPrestado);
		
		JTextPane txtpnEdicion = new JTextPane();
		txtpnEdicion.setText("Año Edición");
		txtpnEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnEdicion.setBackground(SystemColor.menu);
		txtpnEdicion.setBounds(10, 219, 76, 21);
		frmBiblioteca.getContentPane().add(txtpnEdicion);
		
		Label labelEdicion = new Label("Año de edición");
		labelEdicion.setForeground(Color.GRAY);
		labelEdicion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelEdicion.setBounds(20, 246, 261, 27);
		frmBiblioteca.getContentPane().add(labelEdicion);
		
		JTextPane txtpnAutor = new JTextPane();
		txtpnAutor.setText("Autor");
		txtpnAutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnAutor.setBackground(SystemColor.menu);
		txtpnAutor.setBounds(10, 159, 45, 21);
		frmBiblioteca.getContentPane().add(txtpnAutor);
		
		Label labelFechaNacimiento_1 = new Label("Autor");
		labelFechaNacimiento_1.setForeground(Color.GRAY);
		labelFechaNacimiento_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelFechaNacimiento_1.setBounds(20, 186, 208, 27);
		frmBiblioteca.getContentPane().add(labelFechaNacimiento_1);
		
		JTextPane txtpnCategoria = new JTextPane();
		txtpnCategoria.setText("Categoria");
		txtpnCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnCategoria.setBackground(SystemColor.menu);
		txtpnCategoria.setBounds(10, 279, 60, 21);
		frmBiblioteca.getContentPane().add(txtpnCategoria);
		
		Label labelCategoria = new Label("Categoría");
		labelCategoria.setForeground(Color.GRAY);
		labelCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelCategoria.setBounds(20, 308, 261, 27);
		frmBiblioteca.getContentPane().add(labelCategoria);
		
		JButton btnAñadirNuevo = new JButton("Añadir nuevo");
		btnAñadirNuevo.setForeground(Color.BLACK);
		btnAñadirNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAñadirNuevo.setBackground(new Color(255, 192, 203));
		btnAñadirNuevo.setBounds(376, 112, 207, 51);
		frmBiblioteca.getContentPane().add(btnAñadirNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setBounds(376, 236, 207, 51);
		frmBiblioteca.getContentPane().add(btnEliminar);
		
		JButton btnModificarTitulo = new JButton("Modificar");
		btnModificarTitulo.setForeground(Color.RED);
		btnModificarTitulo.setBounds(65, 100, 89, 23);
		frmBiblioteca.getContentPane().add(btnModificarTitulo);
		
		JButton btnAutor = new JButton("Modificar");
		btnAutor.setForeground(Color.RED);
		btnAutor.setBounds(65, 159, 89, 23);
		frmBiblioteca.getContentPane().add(btnAutor);
		
		JButton btnEdicion = new JButton("Modificar");
		btnEdicion.setForeground(Color.RED);
		btnEdicion.setBounds(93, 219, 89, 23);
		frmBiblioteca.getContentPane().add(btnEdicion);
		
		JButton btnCategoria = new JButton("Modificar");
		btnCategoria.setForeground(Color.RED);
		btnCategoria.setBounds(78, 277, 89, 23);
		frmBiblioteca.getContentPane().add(btnCategoria);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BibliotecaView biblioteca = new BibliotecaView();	 //Cambio de pantalla
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(10, 11, 76, 27);
		frmBiblioteca.getContentPane().add(btnAtras);
	}
}
