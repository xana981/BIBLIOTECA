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

public class ConfirmarView {
	
	protected JFrame frmConfirmar;
	
	public ConfirmarView() {
		inicialize();
	}
	
	private void inicialize() {
		
		frmConfirmar = new JFrame();
		frmConfirmar.setSize(new Dimension(239, 161));
		frmConfirmar.setResizable(false);
		frmConfirmar.setVisible(true);
		frmConfirmar.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
			}
		});
		frmConfirmar.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmConfirmar.getContentPane().setLayout(null);
		
		JLabel lblSeguro = new JLabel("¿Estás seguro?");
		lblSeguro.setBounds(51, 24, 122, 40);
		lblSeguro.setForeground(new Color(0, 0, 0));
		lblSeguro.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frmConfirmar.getContentPane().add(lblSeguro);
		
		JButton btnSi = new JButton("Sí");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConfirmar.setVisible(false);
			}
		});
		btnSi.setBounds(38, 75, 65, 26);
		frmConfirmar.getContentPane().add(btnSi);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConfirmar.setVisible(false);
			}
		});
		btnNo.setBounds(113, 75, 65, 26);
		frmConfirmar.getContentPane().add(btnNo);
	}
}
