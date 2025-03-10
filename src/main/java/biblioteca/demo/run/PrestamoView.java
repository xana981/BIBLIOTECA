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

public class PrestamoView {
	
	protected JFrame frmBiblioteca;
	private JTable tablePrestados;
	
	public PrestamoView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnPrestamo = new JButton("Confirmar préstamo");
		btnPrestamo.setBackground(new Color(255, 192, 203));
		btnPrestamo.setBounds(198, 368, 207, 51);
		btnPrestamo.setForeground(new Color(0, 0, 0));
		btnPrestamo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblPrestamo = new JLabel(" PRÉSTAMO");
		lblPrestamo.setBounds(206, 11, 180, 40);
		lblPrestamo.setForeground(new Color(0, 0, 255));
		lblPrestamo.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblPrestamo);
		frmBiblioteca.getContentPane().add(btnPrestamo);
		
		JScrollPane scrollPanePrestados = new JScrollPane();
		scrollPanePrestados.setToolTipText("");
		scrollPanePrestados.setBounds(20, 197, 592, 80);
		frmBiblioteca.getContentPane().add(scrollPanePrestados);
		
		tablePrestados = new JTable();
		tablePrestados.setColumnSelectionAllowed(true);
		tablePrestados.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tablePrestados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"isbn", "Titulo", "Fecha pr\u00E9stamo", "Fecha dev."
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePrestados.getColumnModel().getColumn(0).setResizable(false);
		tablePrestados.getColumnModel().getColumn(0).setPreferredWidth(40);
		tablePrestados.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePrestados.getColumnModel().getColumn(2).setPreferredWidth(70);
		tablePrestados.getColumnModel().getColumn(3).setResizable(false);
		tablePrestados.getColumnModel().getColumn(3).setPreferredWidth(70);
		scrollPanePrestados.setViewportView(tablePrestados);
		
		JTextPane txtpnIntroducirSocio = new JTextPane();
		txtpnIntroducirSocio.setBackground(SystemColor.menu);
		txtpnIntroducirSocio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirSocio.setText("Introducir nº de socio");
		txtpnIntroducirSocio.setBounds(10, 62, 132, 27);
		frmBiblioteca.getContentPane().add(txtpnIntroducirSocio);
		
		TextField textFieldSocio = new TextField();
		textFieldSocio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSocio.setText("< Introduce el nº >");
		textFieldSocio.setBounds(148, 62, 174, 27);
		frmBiblioteca.getContentPane().add(textFieldSocio);
		
		JTextPane txtpnNombreApellidos = new JTextPane();
		txtpnNombreApellidos.setBackground(SystemColor.menu);
		txtpnNombreApellidos.setText("Nombre y apellidos del socio");
		txtpnNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNombreApellidos.setBounds(10, 99, 180, 21);
		frmBiblioteca.getContentPane().add(txtpnNombreApellidos);
		
		Label labelNombreApellidos = new Label("");
		labelNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelNombreApellidos.setBounds(20, 126, 350, 27);
		frmBiblioteca.getContentPane().add(labelNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		txtpnListaDeLibros.setBounds(10, 165, 264, 21);
		frmBiblioteca.getContentPane().add(txtpnListaDeLibros);
		
		JTextPane txtpnIntroducirIsbn = new JTextPane();
		txtpnIntroducirIsbn.setText("Introducir isbn libro");
		txtpnIntroducirIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIntroducirIsbn.setBackground(SystemColor.menu);
		txtpnIntroducirIsbn.setBounds(10, 288, 132, 27);
		frmBiblioteca.getContentPane().add(txtpnIntroducirIsbn);
		
		JComboBox comboIsbnLibros = new JComboBox();
		comboIsbnLibros.setEditable(true);
		comboIsbnLibros.setMaximumRowCount(15);
		comboIsbnLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboIsbnLibros.setToolTipText("< Introduce el isbn >");
		comboIsbnLibros.setBounds(148, 288, 377, 27);
		frmBiblioteca.getContentPane().add(comboIsbnLibros);
		
		JTextPane txtpnFechaNacimiento = new JTextPane();
		txtpnFechaNacimiento.setText("Fecha Nacimiento");
		txtpnFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnFechaNacimiento.setBackground(SystemColor.menu);
		txtpnFechaNacimiento.setBounds(394, 99, 218, 21);
		frmBiblioteca.getContentPane().add(txtpnFechaNacimiento);
		
		Label labelFechaNacimiento = new Label("");
		labelFechaNacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelFechaNacimiento.setBounds(404, 126, 208, 27);
		frmBiblioteca.getContentPane().add(labelFechaNacimiento);
	}
}
