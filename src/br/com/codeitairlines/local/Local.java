package br.com.codeitairlines.local;

import java.util.ArrayList;
import java.util.List;

import br.com.codeitairlines.exception.ChefeSozinhoOficialException;
import br.com.codeitairlines.exception.PilotoSozinhoComissariaException;
import br.com.codeitairlines.exception.PoliciaSemBandidoException;
import br.com.codeitairlines.tripulacao.Bandido;
import br.com.codeitairlines.tripulacao.ChefeServico;
import br.com.codeitairlines.tripulacao.Comissaria;
import br.com.codeitairlines.tripulacao.Oficial;
import br.com.codeitairlines.tripulacao.Piloto;
import br.com.codeitairlines.tripulacao.Policia;
import br.com.codeitairlines.tripulacao.Tripulacao;

public class Local{
	
	private List<Tripulacao> tripulacao = new ArrayList<>();

	private boolean containPiloto = false;
	private boolean containOficial = false;
	private boolean containChefeServico = false;
	private boolean containComissaria = false;
	private boolean containPolicia = false;
	private boolean containBandido = false;
	private boolean containMotorista = false;


	public void addAoLocal(Tripulacao tripulacao) { }

	public void removeDoLocal(Tripulacao tripulacao) { }
	
	public boolean verificaPilotoComissaria() {

		return  isContainPiloto() && isContainComissaria() && !isContainChefeServico() && !isContainOficial() && !isContainPolicia() && !isContainBandido();
	}
	
	public boolean verificaChefeOficial() {
		
		return  !isContainPiloto() && !isContainComissaria() && isContainChefeServico() && isContainOficial() && !isContainPolicia() && !isContainBandido();
	}
	
	public boolean  verificaPoliciaBandido() {

		return (!isContainPolicia() && isContainBandido()) && (isContainPiloto() || isContainComissaria() || isContainChefeServico() || !isContainOficial());
	}

	protected void validaTripulantes(){
		this.inicarVariaveisValidacao();
		for (Tripulacao tripulante : tripulacao) {
				 if(tripulante instanceof Piloto)			{setContainPiloto(true);setContainMotorista(true);}			
			else if(tripulante instanceof Oficial)			{setContainOficial(true);}
			else if(tripulante instanceof ChefeServico)		{setContainChefeServico(true);setContainMotorista(true);}
			else if(tripulante instanceof Comissaria)		{setContainComissaria(true);}
			else if(tripulante instanceof Policia)			{setContainPolicia(true);}
			else if(tripulante instanceof Bandido)			{setContainBandido(true);}
		}
	}

	protected void inicarVariaveisValidacao(){
		setContainPiloto(false);		
		setContainOficial(false);
		setContainChefeServico(false);
		setContainComissaria(false);
		setContainPolicia(false);
		setContainBandido(false);
		setContainMotorista(false);
	}
 
	public List<Tripulacao> getTripulacao() {
		return tripulacao;
	}

	public void setTripulacao(List<Tripulacao> tripulacao) {
		this.tripulacao = tripulacao;
	}

	public boolean isContainPiloto() {
		return containPiloto;
	}

	private void setContainPiloto(boolean containPiloto) {
		this.containPiloto = containPiloto;
	}

	public boolean isContainOficial() {
		return containOficial;
	}

	private void setContainOficial(boolean containOficial) {
		this.containOficial = containOficial;
	}

	public boolean isContainChefeServico() {
		return containChefeServico;
	}

	private void setContainChefeServico(boolean containChefeServico) {
		this.containChefeServico = containChefeServico;
	}

	public boolean isContainComissaria() {
		return containComissaria;
	}

	private void setContainComissaria(boolean containComissaria) {
		this.containComissaria = containComissaria;
	}

	public boolean isContainPolicia() {
		return containPolicia;
	}

	private void setContainPolicia(boolean containPolicia) {
		this.containPolicia = containPolicia;
	}

	public boolean isContainBandido() {
		return containBandido;
	}

	private void setContainBandido(boolean containBandido) {
		this.containBandido = containBandido;
	}

	public boolean isContainMotorista() {
		return containMotorista;
	}

	private void setContainMotorista(boolean containMotorista) {
		this.containMotorista = containMotorista;
	}
	
	public void validaRegras() throws PilotoSozinhoComissariaException, ChefeSozinhoOficialException, PoliciaSemBandidoException {}

}
