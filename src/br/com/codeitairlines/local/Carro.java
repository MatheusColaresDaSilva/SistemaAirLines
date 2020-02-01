package br.com.codeitairlines.local;

import javax.swing.JOptionPane;

import br.com.codeitairlines.exception.PoliciaSemBandidoException;
import br.com.codeitairlines.tripulacao.Bandido;
import br.com.codeitairlines.tripulacao.Motorista;
import br.com.codeitairlines.tripulacao.Policia;
import br.com.codeitairlines.tripulacao.Tripulacao;

public class Carro {

	private Motorista motorista;
	
	private Tripulacao passageiro;
	
	public Motorista getMotorista() {
		return motorista;
	}

	public boolean addMotorista(Tripulacao motorista) {
		try {
			this.motorista = (Motorista) motorista;
	
		} catch (Exception e) {
			JOptionPane.showMessageDialog (null, "Tripulante escolhido nao pode ser motorista", null, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;		
	}

	public Tripulacao getPassageiro() {
		return passageiro;
	}

	public boolean addPassageiro(Tripulacao passageiro) {
		try {
			this.passageiro = passageiro;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void validaRegra() throws PoliciaSemBandidoException {
		if(verificaPoliciaBandidoNoCarro()) {
			throw new PoliciaSemBandidoException(
					"Policia e Bandido deve andar juntos");
		}
	}
		
	public boolean  verificaPoliciaBandidoNoCarro() {

		return ((this.motorista instanceof Policia) && !(this.passageiro instanceof Bandido)) 
				|| (!(this.motorista instanceof Policia) && (this.passageiro instanceof Bandido))
				|| (!(this.motorista instanceof Policia) && (this.passageiro instanceof Policia));
		
	}
}
