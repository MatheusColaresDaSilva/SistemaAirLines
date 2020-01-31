package br.com.codeitairlines.local;

import java.util.ArrayList;
import java.util.List;

import br.com.codeitairlines.tripulacao.Tripulacao;

public class Local {
	
	private List<Tripulacao> tripulacao = new ArrayList<>();

	public List<Tripulacao> getTripulacao() {
		return tripulacao;
	}

	public void setTripulacao(List<Tripulacao> tripulacao) {
		this.tripulacao = tripulacao;
	}
	
	private boolean  verificaPilotoComissaria() {
		
		return false;
	}
	
	private boolean  verificaChefeOficial() {
		
		return false;
	}
	
	private boolean  verificaPoliciaBandido() {
		
		return false;
	}

}
