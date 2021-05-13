package controller;

import model.MonteDeCartas;

public class ControladorDeUpdateDePagina {
	boolean novoJogoClicado = true;
	static Partida partida = null;
	Paciencia paciencia = null;
	MonteDeCartas pilhaRecebida = null;

	public void setVar(boolean novoValor) {
		this.novoJogoClicado = novoValor;
	}
	
	public boolean getVar() {
		return this.novoJogoClicado;
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
