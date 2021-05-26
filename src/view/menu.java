package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Paci\u00EAncia");
		lblNewLabel.setBounds(0, 11, 434, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel);

		JButton btnNormal = new JButton("Paci\u00EAncia normal com interface");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(false);
				TabuleiroGUI.main(null);
			}
		});

		btnNormal.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNormal.setBounds(109, 141, 239, 23);
		frame.getContentPane().add(btnNormal);

		JButton btnPacinciaBigBertha = new JButton("Paci\u00EAncia Big Bertha com interface");
		btnPacinciaBigBertha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(false);
				TabuleiroBigBerthaGUI.main(null);
			}
		});
		btnPacinciaBigBertha.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPacinciaBigBertha.setBounds(109, 175, 239, 23);
		frame.getContentPane().add(btnPacinciaBigBertha);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Obrigado por jogar!", "Até mais", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		btnFinalizar.setBounds(175, 209, 116, 23);
		frame.getContentPane().add(btnFinalizar);
		
		JButton btnNormalSI = new JButton("Fechar interface gr\u00E1fica");
		btnNormalSI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(false);
				//Main.menu();
			}
		});
		btnNormalSI.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNormalSI.setBounds(109, 107, 239, 23);
		frame.getContentPane().add(btnNormalSI);

	}
	
	
	
	
}
