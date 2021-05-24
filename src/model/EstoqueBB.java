package model;

import java.util.Collections;
import java.util.Stack;

public class EstoqueBB extends MonteDeCartasBB {

	public EstoqueBB() {

		super();
		final Stack<Carta> cartas2 = new Stack<Carta>();// baralho auxiliar

		/* Preenche o estoque com todas as 104 cartas disponíveis no jogo. */
		for (Naipe naipe : Naipe.values()) {
			for (Numeracao valor : Numeracao.values()) {
				Carta carta = new Carta(naipe, valor);
				this.cartas.push(carta);
				cartas2.push(carta);
			}
		}
		//adiciona as cartas do baralho auxiliar ao principal
		for (int i = 0; i < cartas2.size(); i++) {
			cartas.push(cartas2.get(i));
		}
		
		Collections.shuffle(cartas); // embaralha as cartas!!

	}

	/*
	 * Esta fun��o sobrescrita implementa como Estoque recebe uma carta.
	 * 
	 * @param carta a ser recebida.
	 * 
	 * @param monte de origem.
	 * 
	 * @return se a carta foi recebida ou não.
	 */
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartasBB origem) {
		return false; // estoque não recebe carta!!!
	}

	/*
	 * Esta fun��o sobrescrita implementa como Estoque vira a carta do topo.
	 * 
	 * @return carta do topo.
	 */
	@Override
	public Carta virarCartaDoTopo() {
		Carta topo = visualizarCartaDoTopo();

		if (!estaVazio()) {
			topo.esconder();
		}

		return topo;
	}

	/*
	 * Esta função permite o estoque se reestabelecer quando é esgotado, através
	 * do DescarteBB.
	 * 
	 * @param carta a ser inserida.
	 * 
	 * @param monte de origem.
	 * 
	 * @return se a carta foi reestabelecida ou não.
	 */
	public boolean restabelecer(Carta carta, MonteDeCartasBB origem) {
		if (origem instanceof DescarteBB) {
			carta.esconder();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}

}
