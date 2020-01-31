package br.com.codeitairlines.principal;

import br.com.codeitairlines.tripulacao.Bandido;
import br.com.codeitairlines.tripulacao.ChefeServico;
import br.com.codeitairlines.tripulacao.Comissaria;
import br.com.codeitairlines.tripulacao.Oficial;
import br.com.codeitairlines.tripulacao.Piloto;
import br.com.codeitairlines.tripulacao.Policia;
import br.com.codeitairlines.tripulacao.TripulacaoCabine;
import br.com.codeitairlines.tripulacao.TripulacaoExtra;
import br.com.codeitairlines.tripulacao.TripulacaoTecnica;

public class Main {

	public static void main(String[] args) {
		
		TripulacaoTecnica piloto = new Piloto();
		TripulacaoTecnica oficial1 = new Oficial();
		TripulacaoTecnica oficial2 = new Oficial();
		
		TripulacaoCabine chefeservico = new ChefeServico();
		TripulacaoCabine comissaria1 = new Comissaria();
		TripulacaoCabine comissaria2 = new Comissaria();
		
		TripulacaoExtra policia = new Policia();
		TripulacaoExtra bandido = new Bandido();
		
		piloto.setNome("Matheus");
		oficial1.setNome("Paulo");
		oficial2.setNome("Gilberto");
		
		chefeservico.setNome("Frank");
		comissaria1.setNome("Danielle");
		comissaria2.setNome("Tatiane");
		
		policia.setNome("Hank");
		bandido.setNome("Walter");
		
			
	}

}
