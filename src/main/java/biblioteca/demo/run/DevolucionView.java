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

public class DevolucionView {
	
	protected JFrame frmBiblioteca;
	private JTable tablePrestados;
	
	public DevolucionView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnDevolucion = new JButton("Confirmar devolución");
		btnDevolucion.setBackground(new Color(255, 192, 203));
		btnDevolucion.setBounds(405, 102, 207, 51);
		btnDevolucion.setForeground(new Color(0, 0, 0));
		btnDevolucion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmBiblioteca.getContentPane().setLayout(null);
		
		JLabel lblDevolucion = new JLabel(" DEVOLUCIÓN");
		lblDevolucion.setBounds(210, 11, 201, 40);
		lblDevolucion.setForeground(new Color(0, 0, 255));
		lblDevolucion.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmBiblioteca.getContentPane().add(lblDevolucion);
		frmBiblioteca.getContentPane().add(btnDevolucion);
		
		JScrollPane scrollPanePrestados = new JScrollPane();
		scrollPanePrestados.setToolTipText("");
		scrollPanePrestados.setBounds(20, 191, 592, 80);
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
		labelNombreApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelNombreApellidos.setBounds(20, 126, 350, 27);
		frmBiblioteca.getContentPane().add(labelNombreApellidos);
		
		JTextPane txtpnListaDeLibros = new JTextPane();
		txtpnListaDeLibros.setText("Lista de libros prestados (No devueltos)");
		txtpnListaDeLibros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnListaDeLibros.setBackground(SystemColor.menu);
		txtpnListaDeLibros.setBounds(10, 159, 264, 21);
		frmBiblioteca.getContentPane().add(txtpnListaDeLibros);
	}
}
