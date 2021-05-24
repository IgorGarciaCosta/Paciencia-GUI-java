package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.PacienciaBigBertha;
import controller.PartidaBigBertha;
import model.Carta;
import model.MonteDeCartas;
import model.Naipe;
import model.Numeracao;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

class ControladorDeUpdateDePaginaBB {
	static boolean novoJogoClicado = true;

	private static final ControladorDeUpdateDePaginaBB SINGLE_INSTANCE = new ControladorDeUpdateDePaginaBB();

	public ControladorDeUpdateDePaginaBB() {

	}

	public static ControladorDeUpdateDePaginaBB getInstance() {
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
	static PartidaBigBertha partida = null;
	PacienciaBigBertha paciencia = null;
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

		if (ControladorDeUpdateDePaginaBB.getVar()) {// se foi clicado o botão de novo jogo
			partida = inicializaERetornaPartida();
			paciencia = inicializaERetornaPaciencia();
			pilhaRecebida = inicializaERetornaMonteDeCartas();
			partida.iniciarPartida();
		}
		
		paciencia = partida.retornaPacienciaAtual();

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.getContentPane().setLayout(null);

		JButton btnSairDoJogo = new JButton("Sair do Jogo");
		btnSairDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSairDoJogo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ControladorDeUpdateDePaginaBB.setVar(true);// setar aqui para true evita um erro ao iniciar novamente o
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
					ControladorDeUpdateDePaginaBB.setVar(true);
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

		// NOMES DE PILHAS
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

		JLabel f3Label = new JLabel(" Fil. 3");
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

		JLabel f9Label = new JLabel(" Fil. 9");
		f9Label.setForeground(Color.WHITE);
		f9Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f9Label.setBounds(378, 185, 24, 14);
		frame.getContentPane().add(f9Label);

		JLabel f10Label = new JLabel("Fil. 10 ");
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
		estLabel.setBounds(0, 60, 30, 14);
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

		JLabel fund4Label = new JLabel("Fund4");
		fund4Label.setForeground(Color.WHITE);
		fund4Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fund4Label.setBounds(170, 71, 30, 14);
		frame.getContentPane().add(fund4Label);

		JLabel fund5Label = new JLabel("Fund5");
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

		JLabel f15Label = new JLabel(" Fil. 15");
		f15Label.setForeground(Color.WHITE);
		f15Label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		f15Label.setBounds(334, 246, 24, 14);
		frame.getContentPane().add(f15Label);

		JLabel descLabel = new JLabel("Des.");
		descLabel.setForeground(Color.WHITE);
		descLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		descLabel.setBounds(0, 135, 17, 14);
		frame.getContentPane().add(descLabel);
		// FIM DOS NOMES DE PILHAS

		
		colocaEstoqueNaTela();
		colocaDescarteNatela();
		colocaEstoqueReisNaTela();
		colocaFundacoesNaTela();
		colocaFileirasNaTela();
		insereQuantDeCartas();

	}

	public void colocaDescarteNatela() {
		pilhaRecebida = paciencia.getMonteDescarteBigBertha();
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			JLabel desc = new JLabel("");
			desc.setIcon(new ImageIcon(newImg));
			desc.setBounds(10, 85, 30, 50);
			frame.getContentPane().add(desc);
			perguntaPraOndeMover(desc, carta, "desc");
		}

	}

	public void colocaEstoqueNaTela() {
		pilhaRecebida = paciencia.getMonteEstoqueBigBertha();
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			JLabel est = new JLabel("");
			est.setIcon(new ImageIcon(newImg));
			est.setBounds(10, 11, 30, 50);
			frame.getContentPane().add(est);
			perguntaPraOndeMover(est, carta, "est");
		}

	}

	public void colocaEstoqueReisNaTela() {
		pilhaRecebida = paciencia.getMonteEstoqueBigBertha();
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			JLabel estReis = new JLabel("");
			estReis.setIcon(new ImageIcon(newImg));
			estReis.setBounds(394, 53, 30, 50);
			frame.getContentPane().add(estReis);
			perguntaPraOndeMover(estReis, carta, "estR");
		}

	}

	public void colocaFileirasNaTela() {
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(0);
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		Image img = null;
		Image newImg = null;
		if (carta != null) {
			img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
			JLabel fil1 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil1.setIcon(new ImageIcon(newImg));
			fil1.setBounds(38, 135, 30, 50);
			frame.getContentPane().add(fil1);
			perguntaPraOndeMover(fil1, carta, "t1");
		}

		pilhaRecebida = paciencia.getMonteFileiraBigBertha(1);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil2 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil2.setIcon(new ImageIcon(newImg));
			fil2.setBounds(78, 135, 30, 50);
			frame.getContentPane().add(fil2);
			perguntaPraOndeMover(fil2, carta, "t2");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(2);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil3 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil3.setIcon(new ImageIcon(newImg));
			fil3.setBounds(118, 135, 30, 50);
			frame.getContentPane().add(fil3);
			perguntaPraOndeMover(fil3, carta, "t3");
		}

		pilhaRecebida = paciencia.getMonteFileiraBigBertha(3);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil4 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil4.setIcon(new ImageIcon(newImg));
			fil4.setBounds(158, 135, 30, 50);
			frame.getContentPane().add(fil4);
			perguntaPraOndeMover(fil4, carta, "t4");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(4);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil5 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil5.setIcon(new ImageIcon(newImg));
			fil5.setBounds(204, 135, 30, 50);
			frame.getContentPane().add(fil5);
			perguntaPraOndeMover(fil5, carta, "t5");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(5);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil6 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil6.setIcon(new ImageIcon(newImg));
			fil6.setBounds(244, 135, 30, 50);
			frame.getContentPane().add(fil6);
			perguntaPraOndeMover(fil6, carta, "t6");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(6);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil7 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil7.setIcon(new ImageIcon(newImg));
			fil7.setBounds(294, 135, 30, 50);
			frame.getContentPane().add(fil7);
			perguntaPraOndeMover(fil7, carta, "t7");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(7);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil8 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil8.setIcon(new ImageIcon(newImg));
			fil8.setBounds(339, 135, 30, 50);
			frame.getContentPane().add(fil8);
			perguntaPraOndeMover(fil8, carta, "t8");
		}

		pilhaRecebida = paciencia.getMonteFileiraBigBertha(8);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil9 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil9.setIcon(new ImageIcon(newImg));
			fil9.setBounds(379, 135, 30, 50);
			frame.getContentPane().add(fil9);
			perguntaPraOndeMover(fil9, carta, "t9");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(9);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil10 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil10.setIcon(new ImageIcon(newImg));
			fil10.setBounds(108, 200, 30, 50);
			frame.getContentPane().add(fil10);
			perguntaPraOndeMover(fil10, carta, "t10");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(10);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil11 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil11.setIcon(new ImageIcon(newImg));
			fil11.setBounds(158, 196, 30, 50);
			frame.getContentPane().add(fil11);
			perguntaPraOndeMover(fil11, carta, "t11");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(11);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil12 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil12.setIcon(new ImageIcon(newImg));
			fil12.setBounds(204, 196, 30, 50);
			frame.getContentPane().add(fil12);
			perguntaPraOndeMover(fil12, carta, "t12");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(12);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil13 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil13.setIcon(new ImageIcon(newImg));
			fil13.setBounds(254, 196, 30, 50);
			frame.getContentPane().add(fil13);
			perguntaPraOndeMover(fil13, carta, "t13");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(13);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil14 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil14.setIcon(new ImageIcon(newImg));
			fil14.setBounds(294, 196, 30, 50);
			frame.getContentPane().add(fil14);
			perguntaPraOndeMover(fil14, carta, "t14");
		}
		pilhaRecebida = paciencia.getMonteFileiraBigBertha(14);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fil15 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fil15.setIcon(new ImageIcon(newImg));
			fil15.setBounds(334, 196, 30, 50);
			frame.getContentPane().add(fil15);
			perguntaPraOndeMover(fil15, carta, "t15");
		}

	}

	public void colocaFundacoesNaTela() {
		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(0);
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		if (carta != null) {
			JLabel fund1 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund1.setIcon(new ImageIcon(newImg));
			fund1.setBounds(50, 24, 30, 50);
			frame.getContentPane().add(fund1);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(1);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund2 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund2.setIcon(new ImageIcon(newImg));
			fund2.setBounds(90, 24, 30, 50);
			frame.getContentPane().add(fund2);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(2);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund3 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund3.setIcon(new ImageIcon(newImg));
			fund3.setBounds(130, 24, 30, 50);
			frame.getContentPane().add(fund3);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(3);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund4 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund4.setIcon(new ImageIcon(newImg));
			fund4.setBounds(170, 24, 30, 50);
			frame.getContentPane().add(fund4);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(4);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund5 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund5.setIcon(new ImageIcon(newImg));
			fund5.setBounds(210, 24, 30, 50);
			frame.getContentPane().add(fund5);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(5);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund6 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund6.setIcon(new ImageIcon(newImg));
			fund6.setBounds(254, 24, 30, 50);
			frame.getContentPane().add(fund6);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(6);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund7 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund7.setIcon(new ImageIcon(newImg));
			fund7.setBounds(294, 24, 30, 50);
			frame.getContentPane().add(fund7);
		}

		pilhaRecebida = paciencia.getMonteFundacaoBigBertha(7);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund8 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(30, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund8.setIcon(new ImageIcon(newImg));
			fund8.setBounds(339, 24, 30, 50);
			frame.getContentPane().add(fund8);
		}

	}

	public void insereQuantDeCartas() {

		int est = paciencia.getMonteEstoqueBigBertha().size();
		JLabel estQnt = new JLabel("(" + est + ")");
		estQnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		estQnt.setForeground(Color.WHITE);
		estQnt.setBounds(34, 60, 17, 14);
		frame.getContentPane().add(estQnt);

		int fu1 = paciencia.getMonteFundacaoBigBertha(0).size();
		JLabel fu1Qnt = new JLabel("(" + fu1 + ")");
		fu1Qnt.setForeground(Color.WHITE);
		fu1Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu1Qnt.setBounds(78, 70, 24, 14);
		frame.getContentPane().add(fu1Qnt);

		int fu2 = paciencia.getMonteFundacaoBigBertha(1).size();
		JLabel fu2Qnt = new JLabel("(" + fu2 + ")");
		fu2Qnt.setForeground(Color.WHITE);
		fu2Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu2Qnt.setBounds(118, 70, 24, 14);
		frame.getContentPane().add(fu2Qnt);

		int fu3 = paciencia.getMonteFundacaoBigBertha(2).size();
		JLabel fu3Qnt = new JLabel("(" + fu3 + ")");
		fu3Qnt.setForeground(Color.WHITE);
		fu3Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu3Qnt.setBounds(158, 70, 24, 14);
		frame.getContentPane().add(fu3Qnt);

		int fu4 = paciencia.getMonteFundacaoBigBertha(3).size();
		JLabel fu4Qnt = new JLabel("(" + fu4 + ")");
		fu4Qnt.setForeground(Color.WHITE);
		fu4Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu4Qnt.setBounds(192, 70, 24, 14);
		frame.getContentPane().add(fu4Qnt);

		int fu5 = paciencia.getMonteFundacaoBigBertha(4).size();
		JLabel fu5Qnt = new JLabel("(" + fu5 + ")");
		fu5Qnt.setForeground(Color.WHITE);
		fu5Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu5Qnt.setBounds(233, 70, 24, 14);
		frame.getContentPane().add(fu5Qnt);

		int fu6 = paciencia.getMonteFundacaoBigBertha(5).size();
		JLabel fu6Qnt = new JLabel("(" + fu6 + ")");
		fu6Qnt.setForeground(Color.WHITE);
		fu6Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu6Qnt.setBounds(279, 70, 24, 14);
		frame.getContentPane().add(fu6Qnt);

		int fu7 = paciencia.getMonteFundacaoBigBertha(6).size();
		JLabel fu7Qnt = new JLabel("(" + fu7 + ")");
		fu7Qnt.setForeground(Color.WHITE);
		fu7Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu7Qnt.setBounds(323, 70, 24, 14);
		frame.getContentPane().add(fu7Qnt);

		int fu8 = paciencia.getMonteFundacaoBigBertha(7).size();
		JLabel fu8Qnt = new JLabel("(" + fu8 + ")");
		fu8Qnt.setForeground(Color.WHITE);
		fu8Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fu8Qnt.setBounds(367, 70, 17, 14);
		frame.getContentPane().add(fu8Qnt);

		JLabel reisQnt = new JLabel("(0)");
		reisQnt.setForeground(Color.WHITE);
		reisQnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		reisQnt.setBounds(417, 100, 17, 14);
		frame.getContentPane().add(reisQnt);

		int fil1 = paciencia.getMonteFileiraBigBertha(0).size();
		JLabel fil1Qnt = new JLabel("(" + fil1 + ")");
		fil1Qnt.setForeground(Color.WHITE);
		fil1Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil1Qnt.setBounds(63, 185, 17, 14);
		frame.getContentPane().add(fil1Qnt);

		int fil2 = paciencia.getMonteFileiraBigBertha(1).size();
		JLabel fil2Qnt = new JLabel("(" + fil2 + ")");
		fil2Qnt.setForeground(Color.WHITE);
		fil2Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil2Qnt.setBounds(108, 185, 17, 14);
		frame.getContentPane().add(fil2Qnt);

		int fil3 = paciencia.getMonteFileiraBigBertha(2).size();
		JLabel fil3Qnt = new JLabel("(" + fil3 + ")");
		fil3Qnt.setForeground(Color.WHITE);
		fil3Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil3Qnt.setBounds(143, 185, 17, 14);
		frame.getContentPane().add(fil3Qnt);

		int fil4 = paciencia.getMonteFileiraBigBertha(3).size();
		JLabel fil4Qnt = new JLabel("(" + fil4 + ")");
		fil4Qnt.setForeground(Color.WHITE);
		fil4Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil4Qnt.setBounds(183, 185, 17, 14);
		frame.getContentPane().add(fil4Qnt);

		int fil5 = paciencia.getMonteFileiraBigBertha(4).size();
		JLabel fil5Qnt = new JLabel("(" + fil5 + ")");
		fil5Qnt.setForeground(Color.WHITE);
		fil5Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil5Qnt.setBounds(233, 185, 17, 14);
		frame.getContentPane().add(fil5Qnt);

		int fil6 = paciencia.getMonteFileiraBigBertha(5).size();
		JLabel fil6Qnt = new JLabel("(" + fil6 + ")");
		fil6Qnt.setForeground(Color.WHITE);
		fil6Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil6Qnt.setBounds(267, 185, 17, 14);
		frame.getContentPane().add(fil6Qnt);

		int fil7 = paciencia.getMonteFileiraBigBertha(6).size();
		JLabel fil7Qnt = new JLabel("(" + fil7 + ")");
		fil7Qnt.setForeground(Color.WHITE);
		fil7Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil7Qnt.setBounds(322, 185, 17, 14);
		frame.getContentPane().add(fil7Qnt);

		int fil8 = paciencia.getMonteFileiraBigBertha(7).size();
		JLabel fil8Qnt = new JLabel("(" + fil8 + ")");
		fil8Qnt.setForeground(Color.WHITE);
		fil8Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil8Qnt.setBounds(367, 185, 17, 14);
		frame.getContentPane().add(fil8Qnt);

		int fil9 = paciencia.getMonteFileiraBigBertha(8).size();
		JLabel fil9Qnt = new JLabel("(" + fil9 + ")");
		fil9Qnt.setForeground(Color.WHITE);
		fil9Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil9Qnt.setBounds(401, 185, 17, 14);
		frame.getContentPane().add(fil9Qnt);

		int fil10 = paciencia.getMonteFileiraBigBertha(9).size();
		JLabel fil10Qnt = new JLabel("(" + fil10 + ")");
		fil10Qnt.setForeground(Color.WHITE);
		fil10Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil10Qnt.setBounds(130, 246, 17, 14);
		frame.getContentPane().add(fil10Qnt);

		int fil11 = paciencia.getMonteFileiraBigBertha(10).size();
		JLabel fil11Qnt = new JLabel("(" + fil11 + ")");
		fil11Qnt.setForeground(Color.WHITE);
		fil11Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil11Qnt.setBounds(183, 246, 17, 14);
		frame.getContentPane().add(fil11Qnt);

		int fil12 = paciencia.getMonteFileiraBigBertha(11).size();
		JLabel fil12Qnt = new JLabel("(" + fil12 + ")");
		fil12Qnt.setForeground(Color.WHITE);
		fil12Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil12Qnt.setBounds(228, 246, 17, 14);
		frame.getContentPane().add(fil12Qnt);

		int fil13 = paciencia.getMonteFileiraBigBertha(12).size();
		JLabel fil13Qnt = new JLabel("(" + fil13 + ")");
		fil13Qnt.setForeground(Color.WHITE);
		fil13Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil13Qnt.setBounds(279, 246, 17, 14);
		frame.getContentPane().add(fil13Qnt);

		int fil14 = paciencia.getMonteFileiraBigBertha(13).size();
		JLabel fil14Qnt = new JLabel("(" + fil14 + ")");
		fil14Qnt.setForeground(Color.WHITE);
		fil14Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil14Qnt.setBounds(323, 246, 17, 14);
		frame.getContentPane().add(fil14Qnt);

		int fil15 = paciencia.getMonteFileiraBigBertha(14).size();
		JLabel fil15Qnt = new JLabel("(" + fil15 + ")");
		fil15Qnt.setForeground(Color.WHITE);
		fil15Qnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		fil15Qnt.setBounds(367, 247, 17, 14);
		frame.getContentPane().add(fil15Qnt);

		int descQ = paciencia.getMonteFileiraBigBertha(14).size();
		JLabel descQnt = new JLabel("(" + descQ + ")");
		descQnt.setForeground(Color.WHITE);
		descQnt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		descQnt.setBounds(23, 134, 17, 14);
		frame.getContentPane().add(descQnt);

	}

	public PartidaBigBertha inicializaERetornaPartida() {
		PartidaBigBertha partida = new PartidaBigBertha();
		return partida;
	}

	public PacienciaBigBertha inicializaERetornaPaciencia() {
		PacienciaBigBertha paciencia = partida.retornaPacienciaAtual();
		return paciencia;
	}

	public MonteDeCartas inicializaERetornaMonteDeCartas() {
		MonteDeCartas pilhaRecebida = new MonteDeCartas();
		return pilhaRecebida;
	}

	public void moveCadaCarta(String[] opcoesDeDestino, String nomePilhaOrigem, int idOrigemRecebido) {
		String[] values1 = opcoesDeDestino;
		Object selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", nomePilhaOrigem,
				JOptionPane.DEFAULT_OPTION, null, values1, "0");
		int idOrigem = idOrigemRecebido;
		int idDestino = 0;
		if (selected != null) {
			switch ((String) selected) {
			case "Estoque":
				idDestino = 1;
				break;
			case "Descarte":
				idDestino = 2;
				break;
			case "Fundação 1":
				idDestino = 3;
				break;
			case "Fundação 2":
				idDestino = 4;
				break;
			case "Fundação 3":
				idDestino = 5;
				break;
			case "Fundação 4":
				idDestino = 6;
				break;
			case "Fundação 5":
				idDestino = 7;
				break;
			case "Fundação 6":
				idDestino = 8;
				break;
			case "Fundação 7":
				idDestino = 9;
				break;
			case "Fundação 8":
				idDestino = 10;
				break;
			case "Fileira 1":
				idDestino = 11;
				break;
			case "Fileira 2":
				idDestino = 12;
				break;
			case "Fileira 3":
				idDestino = 13;
				break;
			case "Fileira 4":
				idDestino = 14;
				break;
			case "Fileira 5":
				idDestino = 15;
				break;
			case "Fileira 6":
				idDestino = 16;
				break;
			case "Fileira 7":
				idDestino = 17;
				break;
			case "Fileira 8":
				idDestino = 18;
				break;
			case "Fileira 9":
				idDestino = 19;
				break;
			case "Fileira 10":
				idDestino = 20;
				break;
			case "Fileira 11":
				idDestino = 21;
				break;
			case "Fileira 12":
				idDestino = 22;
				break;
			case "Fileira 13":
				idDestino = 23;
				break;
			case "Fileira 14":
				idDestino = 24;
				break;
			case "Fileira 15":
				idDestino = 25;
				break;
			}

			partida.moverCarta(idOrigem, idDestino);
			ControladorDeUpdateDePaginaBB.setVar(false);
			atualizaPagina();
		}
	}

	public void perguntaPraOndeMover(JLabel labelDaCarta, Carta carta, String pilhaClicada) {
		labelDaCarta.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String[] values = {};
				Object selected = null;
				int idOrigem = 0;
				switch (pilhaClicada) {
				case "est":
					String[] values1 = { "Descarte" };
					moveCadaCarta(values1, "Estoque", 1);
					break;

				case "desc":
					String[] values2 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10",
							"Fileira 11", "Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values2, "Descarte", 2);
					break;

				case "t1":
					String[] values3 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 2", "Fileira 3", "Fileira 4",
							"Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values3, "Fileira 1", 7);
					break;
				case "t2":
					String[] values4 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 3", "Fileira 4",
							"Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values4, "Fileira 2", 8);
					break;
				case "t3":
					String[] values5 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 4",
							"Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values5, "Fileira 3", 9);
					break;
				case "t4":
					String[] values6 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values6, "Fileira 4", 10);
					break;
				case "t5":
					String[] values7 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values7, "Fileira 5", 11);
					break;
				case "t6":
					String[] values8 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values8, "Fileira 6", 12);
					break;
				case "t7":
					String[] values9 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 8", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values9, "Fileira 7", 13);
					break;
				case "t8":
					String[] values10 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 9", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values10, "Fileira 8", 14);
					break;

				case "t9":
					String[] values11 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 10", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values11, "Fileira 9", 15);
					break;
				case "t10":
					String[] values12 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 11",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values12, "Fileira 10", 16);
					break;
				case "t11":
					String[] values13 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10",
							"Fileira 12", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values13, "Fileira 11", 17);
					break;
				case "t12":
					String[] values14 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10",
							"Fileira 11", "Fileira 13", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values14, "Fileira 12", 18);
					break;
				case "t13":
					String[] values15 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10",
							"Fileira 11", "Fileira 12", "Fileira 14", "Fileira 15" };
					moveCadaCarta(values15, "Fileira 13", 19);
					break;
				case "t14":
					String[] values16 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10",
							"Fileira 11", "Fileira 12", "Fileira 13", "Fileira 15" };
					moveCadaCarta(values16, "Fileira 14", 20);
					break;
				case "t15":
					String[] values17 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fundação 5",
							"Fundação 6", "Fundação 7", "Fundação 8", "Fileira 1", "Fileira 2", "Fileira 3",
							"Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7", "Fileira 8", "Fileira 9", "Fileira 10",
							"Fileira 11", "Fileira 12", "Fileira 13", "Fileira 14" };
					moveCadaCarta(values17, "Fileira 15", 21);
					break;
				}

				if (selected != null) {// null if the user cancels.
					System.out.print(selected);
				}
			}
		});
	}

	public Image retornaFotoDaCarta(Carta carta) {
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		Numeracao num = carta.getNumeracao();
		int numero = num.getValor();
		Naipe nai = carta.getNaipe();
		String naipe = nai.toString();// retorna a respectiva letra do naipe

		switch (numero) {
		case 1:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/AceSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/AceHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/AceClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/AceDiamonds.png")).getImage();
				break;
			}
			break;
		case 2:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/TwoSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/TwoHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/TwoClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/TwoDiamonds.png")).getImage();
				break;
			}
			break;
		case 3:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/ThreeSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/ThreeHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/ThreeClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/ThreeDiamonds.png")).getImage();
				break;
			}
			break;
		case 4:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/FourSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/FourHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/FourClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/FourDiamonds.png")).getImage();
				break;
			}
			break;
		case 5:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/FiveSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/FiveSpades.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/FiveClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/FiveDiamonds.png")).getImage();
				break;
			}
			break;
		case 6:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/SixSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/SixSpades.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/SixClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/SixDiamonds.png")).getImage();
				break;
			}
			break;
		case 7:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/SevenSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/SevenHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/SevenClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/SevenDiamonds.png")).getImage();
				break;
			}
			break;
		case 8:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/EightSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/EightHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/EightClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/EightDiamonds.png")).getImage();
				break;
			}
			break;
		case 9:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/NineSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/NineHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/NineClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/NineDiamonds.png")).getImage();
				break;
			}
			break;
		case 10:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/TenSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/TenHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/TenClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/TenDiamonds.png")).getImage();
				break;
			}
			break;
		case 11:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/JackSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/JackHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/JackClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/JackDiamonds.png")).getImage();
				break;
			}
			break;
		case 12:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/QueenSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/QueenHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/QueenClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/QueenDiamonds.png")).getImage();
				break;
			}
			break;
		case 13:
			switch (naipe) {
			case "E":// espadas
				img = new ImageIcon(this.getClass().getResource("/cards/KingSpades.png")).getImage();
				break;
			case "C":// copas
				img = new ImageIcon(this.getClass().getResource("/cards/KingHearts.png")).getImage();
				break;
			case "P":// paus
				img = new ImageIcon(this.getClass().getResource("/cards/KingClubs.png")).getImage();
				break;
			case "O":// ouros
				img = new ImageIcon(this.getClass().getResource("/cards/KingDiamonds.png")).getImage();
				break;
			}
			break;
		}

		return img;
	}

}
