package br.com.codeitairlines.local;

import br.com.codeitairlines.exception.ChefeSozinhoOficialException;
import br.com.codeitairlines.exception.PilotoSozinhoComissariaException;
import br.com.codeitairlines.exception.PoliciaSemBandidoException;
import br.com.codeitairlines.tripulacao.Tripulacao;

public class Terminal extends Local {

	
    public void validaRegras() throws PilotoSozinhoComissariaException, ChefeSozinhoOficialException, PoliciaSemBandidoException {
    	if(verificaPilotoComissaria()) {
    	
    		throw new PilotoSozinhoComissariaException(
    				"Piloto nao pode ficar sozinho com Comissaria no Terminal");
    	}
    	
    	if(verificaChefeOficial()) {
    		
    		throw new ChefeSozinhoOficialException(
					"Chefe de Bordo nao pode ficar sozinho com Oficial no Terminal");
    	}
    	
    	if(verificaPoliciaBandido()) {
    		
    		throw new PoliciaSemBandidoException(
					"Bandico nao pode ficar sozinho sem Policial no Terminal");
    	}
    }
}
