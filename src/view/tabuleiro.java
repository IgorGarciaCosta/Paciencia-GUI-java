package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Partida;

import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class tabuleiro {
	
	final static Partida partida = new Partida();
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		partida.iniciarPartida();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabuleiro window = new tabuleiro();
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
	public tabuleiro() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNovoJogo.setBounds(274, 0, 77, 23);
		frame.getContentPane().add(btnNovoJogo);
		
		JButton btnSairDoJogo = new JButton("Sair do Jogo");
		btnSairDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSairDoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(false);
				menu.main(null);
				
			}
		});
		btnSairDoJogo.setBounds(351, 0, 83, 23);
		frame.getContentPane().add(btnSairDoJogo);
		
		JButton btnQtsVirar = new JButton("Qts. virar do est.");
		btnQtsVirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] values = {"1", "3"};
				Object selected = JOptionPane.showInputDialog(null, "Virar 1 ou 3 cartas?", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
				if ( selected != null ){//null if the user cancels. 
				    //do something
					int qtd = Integer.parseInt((String) selected);
					partida.definirQtdVirarEstoque(qtd);
				}
			}
			
		});
		btnQtsVirar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnQtsVirar.setBounds(159, 0, 115, 23);
		frame.getContentPane().add(btnQtsVirar);
	}
}
