package br.com.codeitairlines.local;

import br.com.codeitairlines.exception.ChefeSozinhoOficialException;
import br.com.codeitairlines.exception.PilotoSozinhoComissariaException;
import br.com.codeitairlines.exception.PoliciaSemBandidoException;
import br.com.codeitairlines.tripulacao.Tripulacao;

public class Aviao extends Local{

	@Override
	public void addAoLocal(Tripulacao tripulacao){
		if(!this.getTripulacao().contains(tripulacao)) {
			this.getTripulacao().add(tripulacao);
			validaTripulantes();}
	}
	
	@Override
	public void removeDoLocal(Tripulacao tripulacao) {
		this.getTripulacao().remove(tripulacao);
		validaTripulantes();
	}
	
	public void validaRegras() throws PilotoSozinhoComissariaException, ChefeSozinhoOficialException, PoliciaSemBandidoException {
    	if(verificaPilotoComissaria()) {
    	
    		throw new PilotoSozinhoComissariaException(
    					"Piloto nao pode ficar sozinho com Comissaria no Aviao");
    	}
    	
    	if(verificaChefeOficial()) {
    		
    		throw new ChefeSozinhoOficialException(
					"Chefe de Bordo nao pode ficar sozinho com Oficial no Aviao");
    	}
    	
    	if(verificaPoliciaBandido()) {
    		
    		throw new PoliciaSemBandidoException(
					"Bandico nao pode ficar sozinho sem Policial no Aviao");
    	}
    }
}
