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
		tabuleiroBigBertha.main(null);
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
		
		//NOMES DE PILHAS
		JLabel f1Label = new JLabel("Fil. 1");
		f1Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f1Label.setForeground(Color.WHITE);
		f1Label.setBounds(38, 186, 24, 14);
		frame.getContentPane().add(f1Label);

		JLabel f2Label = new JLabel("Fil. 2");
		f2Label.setForeground(Color.WHITE);
		f2Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f2Label.setBounds(78, 185, 24, 14);
		frame.getContentPane().add(f2Label);

		JLabel f3Label = new JLabel("Fil. 3");
		f3Label.setForeground(Color.WHITE);
		f3Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f3Label.setBounds(118, 185, 24, 14);
		frame.getContentPane().add(f3Label);

		JLabel f4Label = new JLabel("Fil. 4");
		f4Label.setForeground(Color.WHITE);
		f4Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f4Label.setBounds(158, 185, 24, 14);
		frame.getContentPane().add(f4Label);

		JLabel f5Label = new JLabel("Fil. 5");
		f5Label.setForeground(Color.WHITE);
		f5Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f5Label.setBounds(204, 185, 24, 14);
		frame.getContentPane().add(f5Label);

		JLabel f6Label = new JLabel("Fil. 6");
		f6Label.setForeground(Color.WHITE);
		f6Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f6Label.setBounds(244, 185, 24, 14);
		frame.getContentPane().add(f6Label);

		JLabel f7Label = new JLabel("Fil. 7");
		f7Label.setForeground(Color.WHITE);
		f7Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f7Label.setBounds(294, 185, 24, 14);
		frame.getContentPane().add(f7Label);

		JLabel f8Label = new JLabel("Fil. 8");
		f8Label.setForeground(Color.WHITE);
		f8Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f8Label.setBounds(339, 185, 24, 14);
		frame.getContentPane().add(f8Label);

		JLabel f9Label = new JLabel("Fil. 9");
		f9Label.setForeground(Color.WHITE);
		f9Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f9Label.setBounds(378, 185, 24, 14);
		frame.getContentPane().add(f9Label);

		JLabel f10Label = new JLabel("Fil. 10");
		f10Label.setForeground(Color.WHITE);
		f10Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f10Label.setBounds(108, 247, 24, 14);
		frame.getContentPane().add(f10Label);

		JLabel f11Label = new JLabel("Fil. 11");
		f11Label.setForeground(Color.WHITE);
		f11Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f11Label.setBounds(158, 246, 24, 14);
		frame.getContentPane().add(f11Label);

		JLabel f12Label = new JLabel("Fil. 12");
		f12Label.setForeground(Color.WHITE);
		f12Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f12Label.setBounds(204, 246, 24, 14);
		frame.getContentPane().add(f12Label);

		JLabel f13Label = new JLabel("Fil. 13");
		f13Label.setForeground(Color.WHITE);
		f13Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f13Label.setBounds(254, 246, 24, 14);
		frame.getContentPane().add(f13Label);

		JLabel f14Label = new JLabel("Fil. 14");
		f14Label.setForeground(Color.WHITE);
		f14Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f14Label.setBounds(294, 246, 24, 14);
		frame.getContentPane().add(f14Label);

		JLabel estLabel = new JLabel("Estoque");
		estLabel.setForeground(Color.WHITE);
		estLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		estLabel.setBounds(10, 101, 30, 14);
		frame.getContentPane().add(estLabel);

		JLabel reisLabel = new JLabel("Reis");
		reisLabel.setForeground(Color.WHITE);
		reisLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		reisLabel.setBounds(394, 100, 24, 14);
		frame.getContentPane().add(reisLabel);

		JLabel fund1Label = new JLabel("Fund. 1");
		fund1Label.setForeground(Color.WHITE);
		fund1Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund1Label.setBounds(50, 71, 30, 14);
		frame.getContentPane().add(fund1Label);

		JLabel fund2Label = new JLabel("Fund. 2");
		fund2Label.setForeground(Color.WHITE);
		fund2Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund2Label.setBounds(90, 71, 30, 14);
		frame.getContentPane().add(fund2Label);

		JLabel fund3Label = new JLabel("Fund 3.");
		fund3Label.setForeground(Color.WHITE);
		fund3Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund3Label.setBounds(130, 71, 30, 14);
		frame.getContentPane().add(fund3Label);

		JLabel fund4Label = new JLabel("Fund. 4");
		fund4Label.setForeground(Color.WHITE);
		fund4Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund4Label.setBounds(170, 71, 30, 14);
		frame.getContentPane().add(fund4Label);

		JLabel fund5Label = new JLabel("Fund. 5");
		fund5Label.setForeground(Color.WHITE);
		fund5Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund5Label.setBounds(210, 71, 30, 14);
		frame.getContentPane().add(fund5Label);

		JLabel fund6Label = new JLabel("Fund. 6");
		fund6Label.setForeground(Color.WHITE);
		fund6Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund6Label.setBounds(250, 71, 30, 14);
		frame.getContentPane().add(fund6Label);

		JLabel fund7Label = new JLabel("Fund. 7");
		fund7Label.setForeground(Color.WHITE);
		fund7Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund7Label.setBounds(294, 71, 30, 14);
		frame.getContentPane().add(fund7Label);

		JLabel fund8Label = new JLabel("Fund. 8");
		fund8Label.setForeground(Color.WHITE);
		fund8Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund8Label.setBounds(339, 71, 30, 14);
		frame.getContentPane().add(fund8Label);
		
		JLabel f15Label = new JLabel("Fil. 15");
		f15Label.setForeground(Color.WHITE);
		f15Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f15Label.setBounds(334, 246, 24, 14);
		frame.getContentPane().add(f15Label);
		//FIM DOS NOMES DE PILHAS

		colocaEstoqueNaTela();
		colocaEstoqueReisNaTela();
		colocaFundacoesNaTela();
		colocaFileirasNaTela();
		insereQuantDeCartas();

	}

	public void colocaEstoqueNaTela() {
		// pilhaRecebida = paciencia.getMonteEstoque();
		// Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		// if (carta != null) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel est = new JLabel("");
		est.setIcon(new ImageIcon(newImg));
		est.setBounds(10, 53, 30, 50);
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
		estReis.setBounds(394, 53, 30, 50);
		frame.getContentPane().add(estReis);
		// perguntaPraOndeMover(est, carta, "est");
		// }

	}

	public void colocaFileirasNaTela() {
		// if (carta != null) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil1 = new JLabel("");
		fil1.setIcon(new ImageIcon(newImg));
		fil1.setBounds(38, 135, 30, 50);
		frame.getContentPane().add(fil1);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil2 = new JLabel("");
		fil2.setIcon(new ImageIcon(newImg));
		fil2.setBounds(78, 135, 30, 50);
		frame.getContentPane().add(fil2);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil3 = new JLabel("");
		fil3.setIcon(new ImageIcon(newImg));
		fil3.setBounds(118, 135, 30, 50);
		frame.getContentPane().add(fil3);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil4 = new JLabel("");
		fil4.setIcon(new ImageIcon(newImg));
		fil4.setBounds(158, 135, 30, 50);
		frame.getContentPane().add(fil4);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil5 = new JLabel("");
		fil5.setIcon(new ImageIcon(newImg));
		fil5.setBounds(204, 135, 30, 50);
		frame.getContentPane().add(fil5);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil6 = new JLabel("");
		fil6.setIcon(new ImageIcon(newImg));
		fil6.setBounds(244, 135, 30, 50);
		frame.getContentPane().add(fil6);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil7 = new JLabel("");
		fil7.setIcon(new ImageIcon(newImg));
		fil7.setBounds(294, 135, 30, 50);
		frame.getContentPane().add(fil7);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil8 = new JLabel("");
		fil8.setIcon(new ImageIcon(newImg));
		fil8.setBounds(339, 135, 30, 50);
		frame.getContentPane().add(fil8);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil9 = new JLabel("");
		fil9.setIcon(new ImageIcon(newImg));
		fil9.setBounds(379, 135, 30, 50);
		frame.getContentPane().add(fil9);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil10 = new JLabel("");
		fil10.setIcon(new ImageIcon(newImg));
		fil10.setBounds(108, 200, 30, 50);
		frame.getContentPane().add(fil10);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil11 = new JLabel("");
		fil11.setIcon(new ImageIcon(newImg));
		fil11.setBounds(158, 196, 30, 50);
		frame.getContentPane().add(fil11);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil12 = new JLabel("");
		fil12.setIcon(new ImageIcon(newImg));
		fil12.setBounds(204, 196, 30, 50);
		frame.getContentPane().add(fil12);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil13 = new JLabel("");
		fil13.setIcon(new ImageIcon(newImg));
		fil13.setBounds(254, 196, 30, 50);
		frame.getContentPane().add(fil13);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil14 = new JLabel("");
		fil14.setIcon(new ImageIcon(newImg));
		fil14.setBounds(294, 196, 30, 50);
		frame.getContentPane().add(fil14);
		// perguntaPraOndeMover(est, carta, "est");
		// }
		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fil15 = new JLabel("");
		fil15.setIcon(new ImageIcon(newImg));
		fil15.setBounds(334, 196, 30, 50);
		frame.getContentPane().add(fil15);

		
		

	}

	public void colocaFundacoesNaTela() {
		// pilhaRecebida = paciencia.getMonteEstoque();
		// Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		// if (carta != null) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund1 = new JLabel("");
		fund1.setIcon(new ImageIcon(newImg));
		fund1.setBounds(50, 24, 30, 50);
		frame.getContentPane().add(fund1);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund2 = new JLabel("");
		fund2.setIcon(new ImageIcon(newImg));
		fund2.setBounds(90, 24, 30, 50);
		frame.getContentPane().add(fund2);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund3 = new JLabel("");
		fund3.setIcon(new ImageIcon(newImg));
		fund3.setBounds(130, 24, 30, 50);
		frame.getContentPane().add(fund3);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund4 = new JLabel("");
		fund4.setIcon(new ImageIcon(newImg));
		fund4.setBounds(170, 24, 30, 50);
		frame.getContentPane().add(fund4);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund5 = new JLabel("");
		fund5.setIcon(new ImageIcon(newImg));
		fund5.setBounds(210, 24, 30, 50);
		frame.getContentPane().add(fund5);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund6 = new JLabel("");
		fund6.setIcon(new ImageIcon(newImg));
		fund6.setBounds(254, 24, 30, 50);
		frame.getContentPane().add(fund6);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund7 = new JLabel("");
		fund7.setIcon(new ImageIcon(newImg));
		fund7.setBounds(294, 24, 30, 50);
		frame.getContentPane().add(fund7);
		// perguntaPraOndeMover(est, carta, "est");
		// }

		// if (carta != null) {
		img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		JLabel fund8 = new JLabel("");
		fund8.setIcon(new ImageIcon(newImg));
		fund8.setBounds(339, 24, 30, 50);
		frame.getContentPane().add(fund8);

	}

	public void insereQuantDeCartas() {
		
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
