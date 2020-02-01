package br.com.codeitairlines.local;

import javax.swing.JOptionPane;

import br.com.codeitairlines.tripulacao.Motorista;
import br.com.codeitairlines.tripulacao.Tripulacao;

public class Carro {

	private Motorista motorista;
	
	private Tripulacao passageiro;
	
	private Terminal origem;
	
	private Aviao destino;

	public Motorista getMotorista() {
		return motorista;
	}

	public boolean addMotorista(Tripulacao motorista) {
		try {
			this.motorista = (Motorista) motorista;
	
		} catch (Exception e) {
			JOptionPane.showMessageDialog (null, "Tripulante escolhido nao pode ser motorista");
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

	public Terminal getOrigem() {
		return origem;
	}

	public void setOrigem(Terminal origem) {
		this.origem = origem;
	}

	public Aviao getDestino() {
		return destino;
	}

	public void setDestino(Aviao destino) {
		this.destino = destino;
	}
		
}
