package controller;

import java.util.ArrayList;
import java.util.Stack;

import model.Carta;
import model.MonteDeCartasBB;
import model.FundacaoBB;
import model.Lado;
import model.FileiraBB;
import model.EstoqueBB;
import model.DescarteBB;

/**
 * Essa classe representa o controlador do jogo Paciência.
 */
public class PacienciaBigBertha {
	private static final int QUANTIDADE_FUNDACOES = 8;
	private static final int QUANTIDADE_FileiraBBS = 15;
	private int qtdCartasVirarEstoqueBB = 1;
	private MonteDeCartasBB EstoqueBB = new EstoqueBB();
	private MonteDeCartasBB EstoqueBBReis = new FundacaoBB();
	private MonteDeCartasBB DescarteBB = new DescarteBB();
	public MonteDeCartasBB FundacaoBB1 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB2 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB3 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB4 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB5 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB6 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB7 = new FundacaoBB();
	public MonteDeCartasBB FundacaoBB8 = new FundacaoBB();
	public MonteDeCartasBB FileiraBB1 = new FileiraBB();
	public MonteDeCartasBB FileiraBB2 = new FileiraBB();
	public MonteDeCartasBB FileiraBB3 = new FileiraBB();
	public MonteDeCartasBB FileiraBB4 = new FileiraBB();
	public MonteDeCartasBB FileiraBB5 = new FileiraBB();
	public MonteDeCartasBB FileiraBB6 = new FileiraBB();
	public MonteDeCartasBB FileiraBB7 = new FileiraBB();
	public MonteDeCartasBB FileiraBB8 = new FileiraBB();
	public MonteDeCartasBB FileiraBB9 = new FileiraBB();
	public MonteDeCartasBB FileiraBB10 = new FileiraBB();
	public MonteDeCartasBB FileiraBB11 = new FileiraBB();
	public MonteDeCartasBB FileiraBB12 = new FileiraBB();
	public MonteDeCartasBB FileiraBB13 = new FileiraBB();
	public MonteDeCartasBB FileiraBB14 = new FileiraBB();
	public MonteDeCartasBB FileiraBB15 = new FileiraBB();

	private ArrayList<MonteDeCartasBB> montes = new ArrayList<MonteDeCartasBB>(
			2 + QUANTIDADE_FileiraBBS + QUANTIDADE_FUNDACOES);
	public ArrayList<MonteDeCartasBB> montesPraInterface = new ArrayList<MonteDeCartasBB>(
			2 + QUANTIDADE_FileiraBBS + QUANTIDADE_FUNDACOES);

	/**
	 * Este construtor permite estabelecer o estado inicial do jogo.
	 */
	public PacienciaBigBertha() {

		/* Adiciona EstoqueBB e DescarteBB a lista de montes */
		montes.add(EstoqueBB);
		montes.add(DescarteBB);

		/* Adiciona as fundações a lista de montes */
		for (int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			FundacaoBB FundacaoBB = new FundacaoBB();
			montes.add(FundacaoBB);
			setMonteFundacaoBBBigBertha(FundacaoBB, i);
		}

		/* Adiciona as FileiraBBs a lista de montes */
		for (int i = 0; i < QUANTIDADE_FileiraBBS; i++) {
			FileiraBB FileiraBB = new FileiraBB();

			/* Preenche as FileiraBBs de cartas e vira a carta do topo */
			for (int j = 0; j < 6; j++) {
				Carta carta = EstoqueBB.retirarCartaDoTopo();
				FileiraBB.preencher(carta);
			}
			FileiraBB.virarCartaDoTopo();
			montes.add(FileiraBB);
			setMonteFileiraBBBigBertha(FileiraBB, i);
		}
		montes.add(EstoqueBBReis);

		setMontesDoJogoBigBertha(montes);
	}

	/**
	 * Função para setar os montes do jogo pra poder mandar pra interface
	 * 
	 * @param Os montes de cartas do jogo
	 */
	public void setMontesDoJogoBigBertha(ArrayList<MonteDeCartasBB> montes) {
		montesPraInterface = montes;
	}

	/**
	 * @param a fundação a ser setada
	 * @param o id da fundação
	 */
	public void setMonteFundacaoBBBigBertha(FundacaoBB FundacaoBB, int i) {
		switch (i) {
		case 0:
			FundacaoBB1 = FundacaoBB;
			break;
		case 1:
			FundacaoBB2 = FundacaoBB;
			break;
		case 2:
			FundacaoBB3 = FundacaoBB;
			break;
		case 3:
			FundacaoBB4 = FundacaoBB;
			break;
		case 4:
			FundacaoBB5 = FundacaoBB;
			break;
		case 5:
			FundacaoBB6 = FundacaoBB;
			break;
		case 6:
			FundacaoBB7 = FundacaoBB;
			break;
		case 7:
			FundacaoBB8 = FundacaoBB;
			break;

		}

	}

	/**
	 * @param a fileira a ser setada
	 * @param o id da fileira
	 */
	public void setMonteFileiraBBBigBertha(FileiraBB FileiraBB, int i) {
		switch (i) {
		case 0:
			FileiraBB1 = FileiraBB;
			break;
		case 1:
			FileiraBB2 = FileiraBB;
			break;
		case 2:
			FileiraBB3 = FileiraBB;
			break;
		case 3:
			FileiraBB4 = FileiraBB;
			break;
		case 4:
			FileiraBB5 = FileiraBB;
			break;
		case 5:
			FileiraBB6 = FileiraBB;
			break;
		case 6:
			FileiraBB7 = FileiraBB;
			break;
		case 7:
			FileiraBB8 = FileiraBB;
			break;
		case 8:
			FileiraBB9 = FileiraBB;
			break;
		case 9:
			FileiraBB10 = FileiraBB;
			break;
		case 10:
			FileiraBB11 = FileiraBB;
			break;
		case 11:
			FileiraBB12 = FileiraBB;
			break;
		case 12:
			FileiraBB13 = FileiraBB;
			break;
		case 13:
			FileiraBB14 = FileiraBB;
			break;
		case 14:
			FileiraBB15 = FileiraBB;
			break;
		}
	}

	/**
	 * Função para pegar os montes do jogo na interface
	 */
	public ArrayList<MonteDeCartasBB> getMontesDoJogoBigBertha() {
		return montesPraInterface;
	}

	/**
	 * 
	 * @return o monte de estoque
	 */
	public MonteDeCartasBB getMonteEstoqueBBBigBertha() {
		return EstoqueBB;
	}

	/**
	 * 
	 * @return o monte de estoque de reis
	 */
	public MonteDeCartasBB getMonteEstoqueBBReisBigBertha() {
		return EstoqueBBReis;
	}

	/**
	 * 
	 * @return o monte de descarte
	 */
	public MonteDeCartasBB getMonteDescarteBBBigBertha() {
		return DescarteBB;
	}

	/**
	 * 
	 * @param id da fundação que se quer obter
	 * @return a fundação do respectivo id
	 */
	public MonteDeCartasBB getMonteFundacaoBBBigBertha(int i) {
		switch (i) {
		case 0:
			return FundacaoBB1;
		case 1:
			return FundacaoBB2;
		case 2:
			return FundacaoBB3;
		case 3:
			return FundacaoBB4;
		case 4:
			return FundacaoBB5;
		case 5:
			return FundacaoBB6;
		case 6:
			return FundacaoBB7;
		case 7:
			return FundacaoBB8;
		}
		return FundacaoBB1;
	}

	/**
	 * 
	 * @param id da fileira que se quer obter
	 * @return a fileira do respectivo id
	 */
	public MonteDeCartasBB getMonteFileiraBBBigBertha(int i) {
		switch (i) {
		case 0:
			return FileiraBB1;
		case 1:
			return FileiraBB2;
		case 2:
			return FileiraBB3;
		case 3:
			return FileiraBB4;
		case 4:
			return FileiraBB5;
		case 5:
			return FileiraBB6;
		case 6:
			return FileiraBB7;
		case 7:
			return FileiraBB8;
		case 8:
			return FileiraBB9;
		case 9:
			return FileiraBB10;
		case 10:
			return FileiraBB11;
		case 11:
			return FileiraBB12;
		case 12:
			return FileiraBB13;
		case 13:
			return FileiraBB14;
		case 14:
			return FileiraBB15;

		}
		return FileiraBB1;
	}

	/**
	 * 
	 * @param index  da carta
	 * @param número da fileira
	 */
	public Carta getCarta(int i, int FileiraBB) {

		switch (FileiraBB) {
		case 1:
			Carta carta = FileiraBB1.getCarta(i);
			return carta;
		case 2:
			carta = FileiraBB2.getCarta(i);
			return carta;
		case 3:
			carta = FileiraBB3.getCarta(i);
			return carta;
		case 4:
			carta = FileiraBB4.getCarta(i);
			return carta;
		case 5:
			carta = FileiraBB5.getCarta(i);
			return carta;
		case 6:
			carta = FileiraBB6.getCarta(i);
			return carta;
		case 7:
			carta = FileiraBB7.getCarta(i);
			return carta;
		case 8:
			carta = FileiraBB8.getCarta(i);
			return carta;
		case 9:
			carta = FileiraBB9.getCarta(i);
			return carta;
		case 10:
			carta = FileiraBB10.getCarta(i);
			return carta;
		case 11:
			carta = FileiraBB11.getCarta(i);
			return carta;
		case 12:
			carta = FileiraBB12.getCarta(i);
			return carta;
		case 13:
			carta = FileiraBB13.getCarta(i);
			return carta;
		case 14:
			carta = FileiraBB14.getCarta(i);
			return carta;
		case 15:
			carta = FileiraBB15.getCarta(i);
			return carta;

		}

		return null;

	}

	/**
	 * Essa função permite definir a quantidade de cartas a serem viradas no
	 * EstoqueBB.
	 * 
	 * @param quantidade de cartas.
	 */
	public void definirQtdVirarEstoqueBB(int n) {
		qtdCartasVirarEstoqueBB = n;
	}

	/**
	 * Essa função permite o jogador mover a carta de um monte para outro.
	 * 
	 * @param identificador do monte de origem.
	 * @param identificador do monte de destino.
	 * @return se foi possível realizar o movimento ou não.
	 */
	public boolean moverCarta(int idOrigem, int idDestino) {
		if (idOrigem < 1 || idDestino < 1)
			return false;

		MonteDeCartasBB origem = montes.get(idOrigem - 1);
		MonteDeCartasBB destino = montes.get(idDestino - 1);

		Carta c = origem.visualizarCartaDoTopo();
		if (c == null) {
			if (origem instanceof EstoqueBB) { // o EstoqueBB está vazio, é necessário reestabelece-lo
				while (!DescarteBB.estaVazio()) {
					Carta c2 = DescarteBB.retirarCartaDoTopo();
					EstoqueBB est = (EstoqueBB) EstoqueBB;
					est.restabelecer(c2, (MonteDeCartasBB) DescarteBB);
				}
			}
			return false; // a origem não possui carta, logo não é possíel realizar o movimento.
		}

		if (origem instanceof EstoqueBB) { // a origem é o EstoqueBB, logo há possibilidade de fornecer mais de uma
											// carta
			for (int n = 0; n < qtdCartasVirarEstoqueBB; n++) {
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
		} else { // se a origem não é o EstoqueBB

			if (destino.receberCarta(c, origem)) {
				origem.retirarCartaDoTopo();
				return true;
			}

			// envio para o estoque de Reis
			if (idDestino == 26) {
				if (destino.recebeCartaEstRei(c)) {
					origem.retirarCartaDoTopo();
					return true;
				}

			}
			return false;
		}
	}

	/**
	 * Essa função retira carta do EstoqueBB para o DescarteBB.
	 * 
	 * @return se retirou ou nÃ£o.
	 */
	public boolean exibirCarta() {
		return moverCarta(1, 2); // 1 é EstoqueBB, 2 é DescarteBB
	}

	/**
	 * Essa função verifica se o jogador venceu.
	 * 
	 * @return se o jogador venceu ou não.
	 */
	public boolean verificarVitoria() {
		int qtdFundacoesCompletas = 0;
		for (MonteDeCartasBB monte : montes) {
			if (monte instanceof FundacaoBB) {
				FundacaoBB f = (FundacaoBB) monte;
				if (f.estaCompleta()) {
					qtdFundacoesCompletas++;
					if (qtdFundacoesCompletas == 8) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Essa função verifica se uma FileiraBB possui uma sequência de cartas.
	 * 
	 * @param identificador da FileiraBB.
	 * @return se tem sequencia na FileiraBB ou não.
	 */
	public boolean temSequenciaNaFileiraBB(int idMonte) {
		if (idMonte < 1)
			return false;
		MonteDeCartasBB mdc = montes.get(idMonte - 1);

		if (mdc instanceof FileiraBB) {
			FileiraBB f = (FileiraBB) mdc;

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
	 * Esta função permite o jogador mover uma sequência de uma FileiraBB para
	 * outra.
	 * 
	 * @param identificador do monte de origem.
	 * @param identificador do monte de destino.
	 * @param quantidade    de cartas que deseja mover.
	 * @return se a sequência foi movida ou não.
	 */
	public boolean moverSequencia(int idOrigem, int idDestino, int quantidadeCartas) {
		if (idOrigem < 1 || idDestino < 1)
			return false;

		MonteDeCartasBB origem = montes.get(idOrigem - 1);
		MonteDeCartasBB destino = montes.get(idDestino - 1);

		Stack<Carta> aux = new Stack<Carta>();

		if (origem instanceof FileiraBB && destino instanceof FileiraBB) {
			FileiraBB FileiraBBOrigem = (FileiraBB) origem;
			FileiraBB FileiraBBDestino = (FileiraBB) destino;

			int count = 0;
			while (count < quantidadeCartas) {
				Carta c = FileiraBBOrigem.retirar();
				if (c != null) {
					if (c.getLado() == Lado.CIMA) {
						aux.push(c);
					} else {
						FileiraBBOrigem.preencher(c);
						break;
					}
				} else {
					break;
				}
				count++;
			}

			if (aux.size() == quantidadeCartas) {
				Carta topoOrigem = aux.pop();
				boolean inseriu = FileiraBBDestino.receberCarta(topoOrigem, FileiraBBOrigem);

				if (inseriu) {
					while (!aux.isEmpty()) {
						FileiraBBDestino.preencher(aux.pop());
					}
					FileiraBBOrigem.virarCartaDoTopo();
					return true;
				} else {
					FileiraBBOrigem.preencher(topoOrigem);
				}
			}
			while (!aux.isEmpty()) {
				FileiraBBOrigem.preencher(aux.pop());
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

		for (MonteDeCartasBB monte : montes) {
			if (idMonte > 9 && espacamento.equals("  "))
				espacamento = " ";
			if (monte instanceof EstoqueBB) {
				opcoes += "   " + idMonte++ + espacamento + "- EstoqueBB:   ";
				opcoes += monte + "\n";
			} else if (monte instanceof DescarteBB) {
				opcoes += "   " + idMonte++ + espacamento + "- DescarteBB:  ";
				opcoes += monte + "\n";
			} else if (monte instanceof FundacaoBB) {
				opcoes += "   " + idMonte++ + espacamento + "- FundaçãoBB" + ":  ";
				opcoes += monte + "\n";
			} else if (monte instanceof FileiraBB) {
				opcoes += "   " + idMonte++ + espacamento + "- FileiraBB" + ":   ";
				opcoes += monte + "\n";
			}
		}

		return opcoes;
	}

}
