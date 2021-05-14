package controller;

import model.MonteDeCartas;

public class ControladorDeUpdateDePagina {
	static boolean novoJogoClicado = false;
	static Partida partida = null;
	Paciencia paciencia = null;
	MonteDeCartas pilhaRecebida = null;

	private static final ControladorDeUpdateDePagina SINGLE_INSTANCE = new ControladorDeUpdateDePagina();

	public ControladorDeUpdateDePagina() {

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

	public void setPilhaRecebida(MonteDeCartas pilha) {
		pilhaRecebida = pilha;
	}

	public MonteDeCartas getPilhaRecebida() {
		return pilhaRecebida;
	}

	public void setPaciencia(Paciencia pacienciaRecebida) {
		paciencia = pacienciaRecebida;
	}

	public Paciencia getPaciencia() {
		return paciencia;
	}

	public void setPartida(Partida partidaRecebida) {
		partida = partidaRecebida;
	}

	public Partida getPartida() {
		return partida;
	}
}
