package br.com.codeitairlines.principal;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.codeitairlines.exception.PilotoSozinhoComissariaException;
import br.com.codeitairlines.local.Aviao;
import br.com.codeitairlines.local.Carro;
import br.com.codeitairlines.local.Local;
import br.com.codeitairlines.local.Terminal;
import br.com.codeitairlines.tripulacao.Bandido;
import br.com.codeitairlines.tripulacao.ChefeServico;
import br.com.codeitairlines.tripulacao.Comissaria;
import br.com.codeitairlines.tripulacao.Oficial;
import br.com.codeitairlines.tripulacao.Piloto;
import br.com.codeitairlines.tripulacao.Policia;
import br.com.codeitairlines.tripulacao.Tripulacao;
import br.com.codeitairlines.tripulacao.TripulacaoCabine;
import br.com.codeitairlines.tripulacao.TripulacaoExtra;
import br.com.codeitairlines.tripulacao.TripulacaoTecnica;

public class Main {

	public static void main(String[] args) {

		Local origem = new Terminal();
		Local destino = new Aviao();

		Carro carro = new Carro();

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

		try {
			origem.addAoLocal(piloto);
			origem.addAoLocal(chefeservico);
			origem.addAoLocal(comissaria1);
			origem.addAoLocal(comissaria2);
		} catch (PilotoSozinhoComissariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//origem.addAoLocal(oficial1);
		//origem.addAoLocal(oficial2);

		//origem.addAoLocal(policia);
		//origem.addAoLocal(bandido);
		
		/*origem.imprimiTripulacaoLocal();
		
		if(carro.addMotorista(origem.getTripulacao().get(0))){
			origem.removeDoLocal(origem.getTripulacao().get(0));
		}

		origem.imprimiTripulacaoLocal();*/

		JComboBox jcb = new JComboBox();

		for (int i = 0; i < origem.getTripulacao().size(); i++) {
			jcb.addItem(origem.getTripulacao().get(i));
		}

		
		do{
			JOptionPane.showMessageDialog(null, jcb, "Selecione o Motorista", JOptionPane.QUESTION_MESSAGE);
		}while(!carro.addMotorista((Tripulacao) jcb.getSelectedItem()));
		
		try {
			origem.removeDoLocal((Tripulacao) jcb.getSelectedItem());
		} catch (PilotoSozinhoComissariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(origem.getTripulacao());
		jcb.removeAllItems();

		for (int i = 0; i < origem.getTripulacao().size(); i++) {
			jcb.addItem(origem.getTripulacao().get(i));
		}

		do{
			JOptionPane.showMessageDialog(null, jcb, "Selecione o Passageiro", JOptionPane.QUESTION_MESSAGE);
		}while(!carro.addPassageiro((Tripulacao) jcb.getSelectedItem()));

		try {
			origem.removeDoLocal((Tripulacao) jcb.getSelectedItem());
		} catch (PilotoSozinhoComissariaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog (null, "Piloto nao pode ficar sozinho com Comissaria");

		}

		System.out.println(origem.verificaPoliciaBandido());
		
		//JOptionPane.showMessageDialog(null, jcb.getSelectedItem(), "Opção selecionada", JOptionPane.INFORMATION_MESSAGE);
	}

}
