package controller;

import java.util.ArrayList;
import java.util.Stack;

import model.Carta;
import model.MonteDeCartas;
import model.Numeracao;
import model.Fundacao;
import model.Lado;
import model.Fileira;
import model.Estoque;
import model.Descarte;

/**
 * Essa classe representa o controlador do jogo Paci?ncia.
 */
public class Paciencia {
	private static final int QUANTIDADE_FUNDACOES = 4;
	private static final int QUANTIDADE_FILEIRAS = 7;
	private int qtdCartasVirarEstoque = 1;
	private MonteDeCartas estoque = new Estoque();
	private MonteDeCartas descarte = new Descarte();
	public MonteDeCartas fundacao1 = new Fundacao();
	public MonteDeCartas fundacao2 = new Fundacao();
	public MonteDeCartas fundacao3 = new Fundacao();
	public MonteDeCartas fundacao4 = new Fundacao();

	public MonteDeCartas fileira1 = new Fileira();
	public MonteDeCartas fileira2 = new Fileira();
	public MonteDeCartas fileira3 = new Fileira();
	public MonteDeCartas fileira4 = new Fileira();
	public MonteDeCartas fileira5 = new Fileira();
	public MonteDeCartas fileira6 = new Fileira();
	public MonteDeCartas fileira7 = new Fileira();

	private ArrayList<MonteDeCartas> montes = new ArrayList<MonteDeCartas>(
			2 + QUANTIDADE_FILEIRAS + QUANTIDADE_FUNDACOES);
	public ArrayList<MonteDeCartas> montesPraInterface = new ArrayList<MonteDeCartas>(
			2 + QUANTIDADE_FILEIRAS + QUANTIDADE_FUNDACOES);

	/**
	 * Este construtor permite estabelecer o estado inicial do jogo.
	 */
	public Paciencia() {

		/* Adiciona estoque e descarte a lista de montes */
		montes.add(estoque);
		montes.add(descarte);

		/* Adiciona as funda??es a lista de montes */
		for (int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			Fundacao fundacao = new Fundacao();
			montes.add(fundacao);
			setMonteFundacao(fundacao, i);
		}

		/* Adiciona as fileiras a lista de montes */
		for (int i = 0; i < QUANTIDADE_FILEIRAS; i++) {
			Fileira fileira = new Fileira();

			/* Preenche as fileiras de cartas e vira a carta do topo */
			for (int j = 0; j <= i; j++) {
				Carta carta = estoque.retirarCartaDoTopo();
				fileira.preencher(carta);
			}
			fileira.virarCartaDoTopo();
			montes.add(fileira);
			setMonteFileira(fileira, i);
		}

		setMontesDoJogo(montes);
	}

	/**
	 * Fun??o para setar os montes do jogo pra poder mandar pra interface
	 * 
	 * @param Os montes de cartas do jogo
	 */
	public void setMontesDoJogo(ArrayList<MonteDeCartas> montes) {
		montesPraInterface = montes;
	}

	/**
	 * @param a funda??o a ser setada
	 * @param o id da funda??o
	 */
	public void setMonteFundacao(Fundacao fundacao, int i) {
		switch (i) {
		case 0:
			fundacao1 = fundacao;
			break;
		case 1:
			fundacao2 = fundacao;
			break;
		case 2:
			fundacao3 = fundacao;
			break;
		case 3:
			fundacao4 = fundacao;
			break;
		}
	}

	/**
	 * @param a fileira a ser setada
	 * @param o id da fileira
	 */
	public void setMonteFileira(Fileira fileira, int i) {
		switch (i) {
		case 0:
			fileira1 = fileira;
			break;
		case 1:
			fileira2 = fileira;
			break;
		case 2:
			fileira3 = fileira;
			break;
		case 3:
			fileira4 = fileira;
			break;
		case 4:
			fileira5 = fileira;
			break;
		case 5:
			fileira6 = fileira;
			break;
		case 6:
			fileira7 = fileira;
			break;
		}
	}

	/**
	 * Fun??o para pegar os montes do jogo na interface
	 */
	public ArrayList<MonteDeCartas> getMontesDoJogo() {
		return montesPraInterface;
	}

	/**
	 * 
	 * @return o monte de estoque
	 */
	public MonteDeCartas getMonteEstoque() {
		return estoque;
	}

	/**
	 * 
	 * @return o monte de descarte
	 */
	public MonteDeCartas getMonteDescarte() {
		return descarte;
	}

	/**
	 * 
	 * @param id da funda??o que se quer obter
	 * @return a funda??o do respectivo id
	 */
	public MonteDeCartas getMonteFundacao(int i) {
		switch (i) {
		case 0:
			return fundacao1;
		case 1:
			return fundacao2;
		case 2:
			return fundacao3;
		case 3:
			return fundacao4;
		}
		return fundacao1;
	}

	/**
	 * 
	 * @param id da fileira que se quer obter
	 * @return a fileira do respectivo id
	 */
	public MonteDeCartas getMonteFileira(int i) {
		switch (i) {
		case 0:
			return fileira1;
		case 1:
			return fileira2;
		case 2:
			return fileira3;
		case 3:
			return fileira4;
		case 4:
			return fileira5;
		case 5:
			return fileira6;
		case 6:
			return fileira7;
		}
		return fileira1;
	}

	/**
	 * 
	 * @param index  da carta
	 * @param n?mero da fileira
	 */
	public Carta getCarta(int i, int fileira) {

		switch (fileira) {
		case 1:
			Carta carta = fileira1.getCarta(i);
			return carta;
		case 2:
			carta = fileira2.getCarta(i);
			return carta;
		case 3:
			carta = fileira3.getCarta(i);
			return carta;
		case 4:
			carta = fileira4.getCarta(i);
			return carta;
		case 5:
			carta = fileira5.getCarta(i);
			return carta;
		case 6:
			carta = fileira6.getCarta(i);
			return carta;
		case 7:
			carta = fileira7.getCarta(i);
			return carta;
		}
		return null;

	}

	/**
	 * Essa fun??o permite definir a quantidade de cartas a serem viradas no
	 * estoque.
	 * 
	 * @param quantidade de cartas.
	 */
	public void definirQtdVirarEstoque(int n) {
		qtdCartasVirarEstoque = n;
	}

	/**
	 * Essa fun??o permite o jogador mover a carta de um monte para outro.
	 * 
	 * @param identificador do monte de origem.
	 * @param identificador do monte de destino.
	 * @return se foi poss?vel realizar o movimento ou n?o.
	 */
	public boolean moverCarta(int idOrigem, int idDestino) {
		if (idOrigem < 1 || idDestino < 1)
			return false;

		MonteDeCartas origem = montes.get(idOrigem - 1);
		MonteDeCartas destino = montes.get(idDestino - 1);

		Carta c = origem.visualizarCartaDoTopo();
		if (c == null) {
			if (origem instanceof Estoque) { // o estoque est? vazio, ? necess?rio reestabelece-lo
				while (!descarte.estaVazio()) {
					Carta c2 = descarte.retirarCartaDoTopo();
					Estoque est = (Estoque) estoque;
					est.restabelecer(c2, (MonteDeCartas) descarte);
				}
			}
			return false; // a origem n?o possui carta, logo n?o ? poss?el realizar o movimento.
		}

		if (origem instanceof Estoque) { // a origem ? o estoque, logo h? possibilidade de fornecer mais de uma carta
			for (int n = 0; n < qtdCartasVirarEstoque; n++) {
				c = origem.visualizarCartaDoTopo();

				if (!origem.estaVazio()) {
					if (destino.receberCarta(c, origem)) {
						origem.retirarCartaDoTopo();
					} else {
						return false;
					}
				}
			}
			return true;
		} else { // se a origem n?o ? o estoque
			if (destino.receberCarta(c, origem)) {
				origem.retirarCartaDoTopo();
				return true;
			}
			return false;
		}
	}

	/**
	 * Essa fun??o retira carta do estoque para o descarte.
	 * 
	 * @return se retirou ou não.
	 */
	public boolean exibirCarta() {
		return moverCarta(1, 2); // 1 ? estoque, 2 ? descarte
	}

	/**
	 * Essa fun??o verifica se o jogador venceu.
	 * 
	 * @return se o jogador venceu ou n?o.
	 */
	public boolean verificarVitoria() {
		int qtdFundacoesCompletas = 0;
		for (MonteDeCartas monte : montes) {
			if (monte instanceof Fundacao) {
				Fundacao f = (Fundacao) monte;
				if (f.estaCompleta()) {
					qtdFundacoesCompletas++;
					if (qtdFundacoesCompletas == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Essa fun??o verifica se uma fileira possui uma sequ?ncia de cartas.
	 * 
	 * @param identificador da fileira.
	 * @return se tem sequencia na fileira ou n?o.
	 */
	public boolean temSequenciaNaFileira(int idMonte) {
		if (idMonte < 1)
			return false;
		MonteDeCartas mdc = montes.get(idMonte - 1);

		if (mdc instanceof Fileira) {
			Fileira f = (Fileira) mdc;

			Stack<Carta> aux = new Stack<Carta>();
			while (true) {
				Carta c = f.retirar();
				if (c != null) {
					if (c.getLado() == Lado.CIMA) {
						aux.push(c);
					} else {
						f.preencher(c);
						break;
					}
				} else {
					break;
				}

			}
			int tamanhoDaSequencia = aux.size();

			while (!aux.isEmpty()) {
				f.preencher(aux.pop());
			}

			return (tamanhoDaSequencia > 1 ? true : false);
		}
		return false;
	}

	/**
	 * Esta fun??o permite o jogador mover uma sequ?ncia de uma fileira para outra.
	 * 
	 * @param identificador do monte de origem.
	 * @param identificador do monte de destino.
	 * @param quantidade    de cartas que deseja mover.
	 * @return se a sequ?ncia foi movida ou n?o.
	 */
	public boolean moverSequencia(int idOrigem, int idDestino, int quantidadeCartas) {
		if (idOrigem < 1 || idDestino < 1)
			return false;

		MonteDeCartas origem = montes.get(idOrigem - 1);
		MonteDeCartas destino = montes.get(idDestino - 1);

		Stack<Carta> aux = new Stack<Carta>();

		if (origem instanceof Fileira && destino instanceof Fileira) {
			Fileira fileiraOrigem = (Fileira) origem;
			Fileira fileiraDestino = (Fileira) destino;

			int count = 0;
			while (count < quantidadeCartas) {
				Carta c = fileiraOrigem.retirar();
				if (c != null) {
					if (c.getLado() == Lado.CIMA) {
						aux.push(c);
					} else {
						fileiraOrigem.preencher(c);
						break;
					}
				} else {
					break;
				}
				count++;
			}

			if (aux.size() == quantidadeCartas) {
				Carta topoOrigem = aux.pop();
				boolean inseriu = fileiraDestino.receberCarta(topoOrigem, fileiraOrigem);

				if (inseriu) {
					while (!aux.isEmpty()) {
						fileiraDestino.preencher(aux.pop());
					}
					fileiraOrigem.virarCartaDoTopo();
					return true;
				} else {
					fileiraOrigem.preencher(topoOrigem);
				}
			}
			while (!aux.isEmpty()) {
				fileiraOrigem.preencher(aux.pop());
			}
			return false;

		}
		return false;
	}

	@Override
	public String toString() {
		String opcoes = "";
		String espacamento = "  ";
		int idMonte = 1;

		for (MonteDeCartas monte : montes) {
			if (idMonte > 9 && espacamento.equals("  "))
				espacamento = " ";
			if (monte instanceof Estoque) {
				opcoes += "   " + idMonte++ + espacamento + "- Estoque:   ";
				opcoes += monte + "\n";
			} else if (monte instanceof Descarte) {
				opcoes += "   " + idMonte++ + espacamento + "- Descarte:  ";
				opcoes += monte + "\n";
			} else if (monte instanceof Fundacao) {
				opcoes += "   " + idMonte++ + espacamento + "- Funda??o" + ":  ";
				opcoes += monte + "\n";
			} else if (monte instanceof Fileira) {
				opcoes += "   " + idMonte++ + espacamento + "- Fileira" + ":   ";
				opcoes += monte + "\n";
			}
		}

		return opcoes;
	}

}
