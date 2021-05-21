package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Paciencia;
import controller.Partida;
import model.Carta;
import model.MonteDeCartas;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

class ControladorDeUpdateDePaginaBB {
	static boolean novoJogoClicado = true;

	private static final ControladorDeUpdateDePagina SINGLE_INSTANCE = new ControladorDeUpdateDePagina();

	public ControladorDeUpdateDePaginaBB() {

	}

	public static ControladorDeUpdateDePagina getInstance() {
		return SINGLE_INSTANCE;
	}

	public static void setVar(boolean novoValor) {
		novoJogoClicado = novoValor;
	}

	public static boolean getVar() {
		return novoJogoClicado;
	}
}

public class tabuleiroBigBertha {
	static Partida partida = null;
	Paciencia paciencia = null;
	MonteDeCartas pilhaRecebida = null;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabuleiroBigBertha window = new tabuleiroBigBertha();
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
	public tabuleiroBigBertha() {
		initialize();
	}

	public void atualizaPagina() {
		frame.dispose();
		frame.setVisible(false);
		tabuleiro.main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		if (ControladorDeUpdateDePagina.getVar()) {// se foi clicado o botão de novo jogo
			partida = inicializaERetornaPartida();
			paciencia = inicializaERetornaPaciencia();
			pilhaRecebida = inicializaERetornaMonteDeCartas();
			partida.iniciarPartida();
		}

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.getContentPane().setLayout(null);

		JButton btnSairDoJogo = new JButton("Sair do Jogo");
		btnSairDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSairDoJogo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ControladorDeUpdateDePagina.setVar(true);// setar aqui para true evita um erro ao iniciar novamente o
															// jogo
				frame.dispose();
				frame.setVisible(false);
				partida.encerrarPartida();
				menu.main(null);
			}
		});

		btnSairDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSairDoJogo.setBounds(339, 0, 95, 13);
		frame.getContentPane().add(btnSairDoJogo);

		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object resposta = JOptionPane.showConfirmDialog(btnNovoJogo, "Tem certeza que quer reiniciar?");
				System.out.print(resposta);
				if ((int) resposta == 0) {
					ControladorDeUpdateDePagina.setVar(true);
					partida.encerrarPartida();
					partida.iniciarPartida();
					atualizaPagina();
				}
			}
		});

		btnNovoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNovoJogo.setBounds(244, 0, 95, 13);
		frame.getContentPane().add(btnNovoJogo);

		JButton btnQtsVirar = new JButton("Qts. virar do est.");
		btnQtsVirar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] values = { "1", "3" };
				Object selected = JOptionPane.showInputDialog(null, "Virar 1 ou 3 cartas?", "Selection",
						JOptionPane.DEFAULT_OPTION, null, values, "0");
				if (selected != null) {// null if the user cancels.
					int qtd = Integer.parseInt((String) selected);
					partida.definirQtdVirarEstoque(qtd);
				}
			}

		});

		btnQtsVirar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnQtsVirar.setBounds(130, 0, 115, 13);
		frame.getContentPane().add(btnQtsVirar);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		colocaEstoqueNaTela();
		colocaEstoqueReisNaTela();
	}

	public void colocaEstoqueNaTela() {
		// pilhaRecebida = paciencia.getMonteEstoque();
		// Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		// if (carta != null) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel est = new JLabel("");
		est.setIcon(new ImageIcon(newImg));
		est.setBounds(10, 19, 40, 59);
		frame.getContentPane().add(est);
		// perguntaPraOndeMover(est, carta, "est");
		// }

	}

	public void colocaEstoqueReisNaTela() {
		// pilhaRecebida = paciencia.getMonteEstoque();
		// Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		// if (carta != null) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		
		JLabel estReis = new JLabel("New label");
		estReis.setIcon(new ImageIcon(newImg));
		estReis.setBounds(387, 19, 37, 59);
		frame.getContentPane().add(estReis);
		// perguntaPraOndeMover(est, carta, "est");
		// }

	}

	public void colocaFundacoesNaTela() {
		// pilhaRecebida = paciencia.getMonteEstoque();
		// Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		// if (carta != null) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fu1 = new JLabel("");
		fu1.setIcon(new ImageIcon(newImg));
		fu1.setBounds(85, 19, 30, 50);
		frame.getContentPane().add(fu1);
		// perguntaPraOndeMover(est, carta, "est");
		// }
	}

	public Partida inicializaERetornaPartida() {
		Partida partida = new Partida();
		return partida;
	}

	public Paciencia inicializaERetornaPaciencia() {
		Paciencia paciencia = partida.retornaPacienciaAtual();
		return paciencia;
	}

	public MonteDeCartas inicializaERetornaMonteDeCartas() {
		MonteDeCartas pilhaRecebida = new MonteDeCartas();
		return pilhaRecebida;
	}
}
