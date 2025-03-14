package biblioteca.demo.run;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//import biblioteca.demo.run.*;


import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import java.awt.Dimension;

public class IncorrectaView {
	
	protected JFrame frmIncorrecta;
	
	public IncorrectaView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmIncorrecta = new JFrame();
		frmIncorrecta.setSize(new Dimension(301, 165));
		frmIncorrecta.setResizable(false);
		frmIncorrecta.setVisible(true);
		frmIncorrecta.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmIncorrecta.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmIncorrecta.getContentPane().setLayout(null);
		
		JLabel lblSeguro = new JLabel("La contraseña NO es correcta");
		lblSeguro.setBounds(24, 24, 238, 40);
		lblSeguro.setForeground(Color.RED);
		lblSeguro.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frmIncorrecta.getContentPane().add(lblSeguro);
		
		JButton btnSi = new JButton("Aceptar");
		btnSi.addActionListener(new ActionListener() { //Cuando pulsamos sobre el ACEPTAR
			public void actionPerformed(ActionEvent e) {
				frmIncorrecta.setVisible(false);
			}
		});
		btnSi.setBounds(92, 75, 90, 26);
		frmIncorrecta.getContentPane().add(btnSi);
	}
}
