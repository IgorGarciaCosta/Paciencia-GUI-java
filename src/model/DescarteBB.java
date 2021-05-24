package model;
import model.EstoqueBB;

/**
* Esta classe representa um Monte de Cartas do tipo Descarte.
*/
public class DescarteBB extends MonteDeCartasBB{
	
	public DescarteBB () {
		super();
	}
	
	/*
	* Esta função sobrescrita implementa como Descarte recebe uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou não.
	*/
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartasBB origem) {
		if (origem instanceof EstoqueBB) {
			carta.mostrar();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}
	
}
