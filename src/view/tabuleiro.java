package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Partida;
import model.Carta;
import model.MonteDeCartas;
import model.Naipe;
import model.Numeracao;
import controller.Paciencia;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

public class tabuleiro {

	final static Partida partida = new Partida();
	Paciencia paciencia = partida.retornaPacienciaAtual();
	MonteDeCartas pilhaRecebida = new MonteDeCartas();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		partida.iniciarPartida();
		paciencia = partida.retornaPacienciaAtual();

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object resposta = JOptionPane.showConfirmDialog(btnNovoJogo, "Tem certeza que quer reiniciar?");
				System.out.print(resposta);
				if ((int) resposta == 0) {
					frame.dispose();
					frame.setVisible(false);
					partida.encerrarPartida();
					partida.iniciarPartida();
					tabuleiro.main(null);
				}
			}
		});
		btnNovoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNovoJogo.setBounds(246, 0, 95, 23);
		frame.getContentPane().add(btnNovoJogo);

		JButton btnSairDoJogo = new JButton("Sair do Jogo");
		btnSairDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSairDoJogo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(false);
				partida.encerrarPartida();
				menu.main(null);
			}
		});

		btnSairDoJogo.setBounds(339, 0, 95, 23);
		frame.getContentPane().add(btnSairDoJogo);

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
		btnQtsVirar.setBounds(131, 0, 115, 23);
		frame.getContentPane().add(btnQtsVirar);

		JLabel lblF1 = new JLabel("Funda\u00E7\u00E3o 1");
		lblF1.setForeground(Color.WHITE);
		lblF1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblF1.setBounds(200, 34, 46, 14);
		frame.getContentPane().add(lblF1);

		JLabel lblF2 = new JLabel("Funda\u00E7\u00E3o 2");
		lblF2.setForeground(Color.WHITE);
		lblF2.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblF2.setBounds(266, 34, 46, 14);
		frame.getContentPane().add(lblF2);

		JLabel lblF3 = new JLabel("Funda\u00E7\u00E3o 3");
		lblF3.setForeground(Color.WHITE);
		lblF3.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblF3.setBounds(322, 34, 46, 14);
		frame.getContentPane().add(lblF3);

		JLabel lblF4 = new JLabel("Funda\u00E7\u00E3o 4");
		lblF4.setForeground(Color.WHITE);
		lblF4.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblF4.setBounds(378, 34, 46, 14);
		frame.getContentPane().add(lblF4);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setForeground(Color.WHITE);
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblEstoque.setBounds(10, 33, 30, 14);
		frame.getContentPane().add(lblEstoque);

		JLabel lblDescarte = new JLabel("Descarte");
		lblDescarte.setForeground(Color.WHITE);
		lblDescarte.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblDescarte.setBounds(72, 33, 30, 14);
		frame.getContentPane().add(lblDescarte);

		JLabel lblTableau_1 = new JLabel("Tableau 1");
		lblTableau_1.setForeground(Color.WHITE);
		lblTableau_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_1.setBounds(10, 236, 38, 14);
		frame.getContentPane().add(lblTableau_1);

		JLabel lblTableau_2 = new JLabel("Tableau 2");
		lblTableau_2.setForeground(Color.WHITE);
		lblTableau_2.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_2.setBounds(72, 235, 38, 14);
		frame.getContentPane().add(lblTableau_2);

		JLabel lblTableau_3 = new JLabel("Tableau 3");
		lblTableau_3.setForeground(Color.WHITE);
		lblTableau_3.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_3.setBounds(131, 235, 38, 14);
		frame.getContentPane().add(lblTableau_3);

		JLabel lblTableau_4 = new JLabel("Tableau 4");
		lblTableau_4.setForeground(Color.WHITE);
		lblTableau_4.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_4.setBounds(187, 236, 38, 14);
		frame.getContentPane().add(lblTableau_4);

		JLabel lblTableau_5 = new JLabel("Tableau 5");
		lblTableau_5.setForeground(Color.WHITE);
		lblTableau_5.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_5.setBounds(246, 235, 38, 14);
		frame.getContentPane().add(lblTableau_5);

		JLabel lblTableau_6 = new JLabel("Tableau 6");
		lblTableau_6.setForeground(Color.WHITE);
		lblTableau_6.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_6.setBounds(308, 235, 38, 14);
		frame.getContentPane().add(lblTableau_6);

		JLabel lblTableau_7 = new JLabel("Tableau 7");
		lblTableau_7.setForeground(Color.WHITE);
		lblTableau_7.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblTableau_7.setBounds(364, 235, 38, 14);
		frame.getContentPane().add(lblTableau_7);

		colocaDescarteNaTela();
		colocaEstoqueNaTela();
		colocaFundacoesNaTela();
		colocaFileirasNaTela();
		insereQuantDeCartas();

	}

	public void insereQuantDeCartas() {
		int tab1 = paciencia.getMonteFileira(0).size();
		JLabel t1Number = new JLabel("(" + tab1 + ")");
		t1Number.setForeground(Color.WHITE);
		t1Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t1Number.setBounds(45, 235, 17, 14);
		frame.getContentPane().add(t1Number);

		int tab2 = paciencia.getMonteFileira(1).size();
		JLabel t2Number = new JLabel("(" + tab2 + ")");
		t2Number.setForeground(Color.WHITE);
		t2Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t2Number.setBounds(106, 235, 17, 14);
		frame.getContentPane().add(t2Number);

		int tab3 = paciencia.getMonteFileira(2).size();
		JLabel t3Number = new JLabel("(" + tab3 + ")");
		t3Number.setForeground(Color.WHITE);
		t3Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t3Number.setBounds(165, 235, 17, 14);
		frame.getContentPane().add(t3Number);

		int tab4 = paciencia.getMonteFileira(3).size();
		JLabel t4Number = new JLabel("(" + tab4 + ")");
		t4Number.setForeground(Color.WHITE);
		t4Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t4Number.setBounds(219, 235, 17, 14);
		frame.getContentPane().add(t4Number);

		int tab5 = paciencia.getMonteFileira(4).size();
		JLabel t5Number = new JLabel("(" + tab5 + ")");
		t5Number.setForeground(Color.WHITE);
		t5Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t5Number.setBounds(281, 235, 17, 14);
		frame.getContentPane().add(t5Number);

		int tab6 = paciencia.getMonteFileira(5).size();
		JLabel t6Number = new JLabel("(" + tab6 + ")");
		t6Number.setForeground(Color.WHITE);
		t6Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t6Number.setBounds(339, 235, 17, 14);
		frame.getContentPane().add(t6Number);

		int tab7 = paciencia.getMonteFileira(6).size();
		JLabel t7Number = new JLabel("(" + tab7 + ")");
		t7Number.setForeground(Color.WHITE);
		t7Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		t7Number.setBounds(396, 235, 17, 14);
		frame.getContentPane().add(t7Number);

		int est = paciencia.getMonteEstoque().size();
		JLabel estNumber = new JLabel("(" + est + ")");
		estNumber.setForeground(Color.WHITE);
		estNumber.setFont(new Font("Tahoma", Font.PLAIN, 7));
		estNumber.setBounds(39, 33, 17, 14);
		frame.getContentPane().add(estNumber);

		int desc = paciencia.getMonteDescarte().size();
		JLabel descNumber = new JLabel("(" + desc + ")");
		descNumber.setForeground(Color.WHITE);
		descNumber.setFont(new Font("Tahoma", Font.PLAIN, 7));
		descNumber.setBounds(106, 33, 17, 14);
		frame.getContentPane().add(descNumber);

		int f1 = paciencia.getMonteFundacao(0).size();
		JLabel f1Number = new JLabel("(" + f1 + ")");
		f1Number.setForeground(Color.WHITE);
		f1Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		f1Number.setBounds(246, 34, 17, 14);
		frame.getContentPane().add(f1Number);

		int f2 = paciencia.getMonteFundacao(1).size();
		JLabel f2Number = new JLabel("(" + f2 + ")");
		f2Number.setForeground(Color.WHITE);
		f2Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		f2Number.setBounds(305, 33, 17, 14);
		frame.getContentPane().add(f2Number);

		int f3 = paciencia.getMonteFundacao(2).size();
		JLabel f3Number = new JLabel("(" + f3 + ")");
		f3Number.setForeground(Color.WHITE);
		f3Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		f3Number.setBounds(361, 33, 17, 14);
		frame.getContentPane().add(f3Number);

		int f4 = paciencia.getMonteFundacao(3).size();
		JLabel f4Number = new JLabel("(" + f4 + ")");
		f4Number.setForeground(Color.WHITE);
		f4Number.setFont(new Font("Tahoma", Font.PLAIN, 7));
		f4Number.setBounds(417, 34, 17, 14);
		frame.getContentPane().add(f4Number);
	}

	public void colocaDescarteNaTela() {
		pilhaRecebida = paciencia.getMonteDescarte();
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			JLabel desc = new JLabel("");
			desc.setIcon(new ImageIcon(newImg));
			desc.setBounds(72, 58, 46, 64);
			frame.getContentPane().add(desc);
			perguntaPraOndeMover(desc, carta, "desc");
		}

	}

	public void colocaEstoqueNaTela() {
		pilhaRecebida = paciencia.getMonteEstoque();
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			JLabel est = new JLabel("");
			est.setIcon(new ImageIcon(newImg));
			est.setBounds(10, 58, 46, 64);
			frame.getContentPane().add(est);
			perguntaPraOndeMover(est, carta, "est");
		}

	}

	public void colocaFundacoesNaTela() {

		pilhaRecebida = paciencia.getMonteFundacao(0);
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		if (carta != null) {
			JLabel fund1 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund1.setIcon(new ImageIcon(newImg));
			fund1.setBounds(378, 58, 46, 64);
			frame.getContentPane().add(fund1);
			perguntaPraOndeMover(fund1, carta, "f1");
		}

		pilhaRecebida = paciencia.getMonteFundacao(1);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund2 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund2.setIcon(new ImageIcon(newImg));
			fund2.setBounds(322, 59, 46, 64);
			frame.getContentPane().add(fund2);
			perguntaPraOndeMover(fund2, carta, "f2");
		}

		pilhaRecebida = paciencia.getMonteFundacao(2);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund3 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund3.setIcon(new ImageIcon(newImg));
			fund3.setBounds(266, 59, 46, 64);
			frame.getContentPane().add(fund3);
			perguntaPraOndeMover(fund3, carta, "f3");
		}

		pilhaRecebida = paciencia.getMonteFundacao(3);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		if (carta != null) {
			JLabel fund4 = new JLabel("");
			img = retornaFotoDaCarta(carta);
			Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			fund4.setIcon(new ImageIcon(newImg));
			fund4.setBounds(210, 59, 46, 64);
			frame.getContentPane().add(fund4);
			perguntaPraOndeMover(fund4, carta, "f4");
		}

	}

	public void colocaFileirasNaTela() {
		pilhaRecebida = paciencia.getMonteFileira(0);
		Carta carta = pilhaRecebida.visualizarCartaDoTopo();
		Image img = new ImageIcon(this.getClass().getResource("/cards/cardBack.png")).getImage();
		JLabel tab1 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		Image newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab1.setIcon(new ImageIcon(newImg));
		tab1.setBounds(10, 171, 46, 64);
		frame.getContentPane().add(tab1);
		perguntaPraOndeMover(tab1, carta, "t1");

		pilhaRecebida = paciencia.getMonteFileira(1);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		JLabel tab2 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab2.setIcon(new ImageIcon(newImg));
		tab2.setBounds(72, 171, 46, 64);
		frame.getContentPane().add(tab2);
		perguntaPraOndeMover(tab2, carta, "t2");

		pilhaRecebida = paciencia.getMonteFileira(2);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		JLabel tab3 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab3.setIcon(new ImageIcon(newImg));
		tab3.setBounds(131, 171, 46, 64);
		frame.getContentPane().add(tab3);
		perguntaPraOndeMover(tab3, carta, "t3");

		pilhaRecebida = paciencia.getMonteFileira(3);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		JLabel tab4 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab4.setIcon(new ImageIcon(newImg));
		tab4.setBounds(187, 171, 46, 64);
		frame.getContentPane().add(tab4);
		perguntaPraOndeMover(tab4, carta, "t4");

		pilhaRecebida = paciencia.getMonteFileira(4);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		JLabel tab5 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab5.setIcon(new ImageIcon(newImg));
		tab5.setBounds(246, 171, 46, 64);
		frame.getContentPane().add(tab5);
		perguntaPraOndeMover(tab5, carta, "t5");

		pilhaRecebida = paciencia.getMonteFileira(5);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		JLabel tab6 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab6.setIcon(new ImageIcon(newImg));
		tab6.setBounds(308, 171, 46, 64);
		frame.getContentPane().add(tab6);
		perguntaPraOndeMover(tab6, carta, "t6");

		pilhaRecebida = paciencia.getMonteFileira(6);
		carta = pilhaRecebida.visualizarCartaDoTopo();
		JLabel tab7 = new JLabel("");
		img = retornaFotoDaCarta(carta);
		newImg = img.getScaledInstance(40, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		tab7.setIcon(new ImageIcon(newImg));
		tab7.setBounds(364, 171, 46, 64);
		frame.getContentPane().add(tab7);
		perguntaPraOndeMover(tab7, carta, "t7");

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

	public void perguntaPraOndeMover(JLabel labelDaCarta, Carta carta, String pilhaClicada) {
		labelDaCarta.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String[] values = {};
				Object selected = null;
				switch (pilhaClicada) {
				case "est":

					String[] values1 = { "Descarte" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Estoque",
							JOptionPane.DEFAULT_OPTION, null, values1, "0");
					break;
				case "desc":
					String[] values2 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 2", "Fileira 3", "Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Descarte",
							JOptionPane.DEFAULT_OPTION, null, values2, "0");
					break;

				case "t1":
					String[] values3 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 2",
							"Fileira 3", "Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 1",
							JOptionPane.DEFAULT_OPTION, null, values3, "0");
					break;
				case "t2":
					String[] values4 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 3", "Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 2",
							JOptionPane.DEFAULT_OPTION, null, values4, "0");
					break;
				case "t3":
					String[] values5 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 2", "Fileira 4", "Fileira 5", "Fileira 6", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 3",
							JOptionPane.DEFAULT_OPTION, null, values5, "0");
					break;
				case "t4":
					String[] values6 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 2", "Fileira 3", "Fileira 5", "Fileira 6", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 4",
							JOptionPane.DEFAULT_OPTION, null, values6, "0");
					break;
				case "t5":
					String[] values7 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 2", "Fileira 3", "Fileira 4", "Fileira 6", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 5",
							JOptionPane.DEFAULT_OPTION, null, values7, "0");
					break;
				case "t6":
					String[] values8 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 2", "Fileira 3", "Fileira 4", "Fileira 5", "Fileira 7" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 6",
							JOptionPane.DEFAULT_OPTION, null, values8, "0");
					break;
				case "t7":
					String[] values9 = { "Fundação 1", "Fundação 2", "Fundação 3", "Fundação 4", "Fileira 1",
							"Fileira 2", "Fileira 3", "Fileira 4", "Fileira 5", "Fileira 6" };
					selected = JOptionPane.showInputDialog(null, "Para onde enviar esta carta?", "Fileira 7",
							JOptionPane.DEFAULT_OPTION, null, values9, "0");
					break;
				}

				if (selected != null) {// null if the user cancels.
					// mover carta
					System.out.print(selected);
				}
			}
		});
	}
}
