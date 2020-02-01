package br.com.codeitairlines.principal;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import br.com.codeitairlines.exception.ChefeSozinhoOficialException;
import br.com.codeitairlines.exception.PilotoSozinhoComissariaException;
import br.com.codeitairlines.exception.PoliciaSemBandidoException;
import br.com.codeitairlines.local.Aviao;
import br.com.codeitairlines.local.Carro;
import br.com.codeitairlines.local.Local;
import br.com.codeitairlines.local.Terminal;
import br.com.codeitairlines.tripulacao.Bandido;
import br.com.codeitairlines.tripulacao.ChefeServico;
import br.com.codeitairlines.tripulacao.Comissaria;
import br.com.codeitairlines.tripulacao.Motorista;
import br.com.codeitairlines.tripulacao.Oficial;
import br.com.codeitairlines.tripulacao.Piloto;
import br.com.codeitairlines.tripulacao.Policia;
import br.com.codeitairlines.tripulacao.Tripulacao;
import br.com.codeitairlines.tripulacao.TripulacaoCabine;
import br.com.codeitairlines.tripulacao.TripulacaoExtra;
import br.com.codeitairlines.tripulacao.TripulacaoTecnica;

public class Main {

	public static void main(String[] args) {

		JFrame jFrameTerminal = new JFrame("Terminal");
		JFrame jFrameAviao = new JFrame("Aviao");
		String[] listaTripulantesTerminal;
		String[] listaTripulantesAviao;
			
		Local origem = new Terminal();
		Local destino = new Aviao();
		Carro carro = new Carro();

		TripulacaoTecnica piloto = new Piloto("Matheus");
		TripulacaoTecnica oficial1 = new Oficial("Frank");
		TripulacaoTecnica oficial2 = new Oficial("Gustavo");
		TripulacaoCabine chefeservico = new ChefeServico("Paulo");
		TripulacaoCabine comissaria1 = new Comissaria("Danielle");
		TripulacaoCabine comissaria2 = new Comissaria("Tatiane");
		TripulacaoExtra policia = new Policia("Hank");
		TripulacaoExtra bandido = new Bandido("Walter");
		
		origem.addAoLocal(piloto);
		origem.addAoLocal(chefeservico);
		origem.addAoLocal(comissaria1);
		origem.addAoLocal(comissaria2);
		origem.addAoLocal(oficial1);
		origem.addAoLocal(oficial2);
		origem.addAoLocal(policia);
		origem.addAoLocal(bandido);
		
		JComboBox jcb = new JComboBox();
		
		boolean fase1 = false;
		boolean fase2 = false;


	 do { /*do principal*/
		do { /*do secundário*/
			
			listaTripulantesTerminal= new String[30] ;
			listaTripulantesAviao= new String[30] ;
			jcb.removeAllItems();	
			for (int i = 0; i < origem.getTripulacao().size(); i++) {
				jcb.addItem(origem.getTripulacao().get(i));
				
				
				listaTripulantesTerminal[i] = origem.getTripulacao().get(i).getNome() +" : "+ origem.getTripulacao().get(i).getClass().getSimpleName();
		        jFrameTerminal.add(new JList(listaTripulantesTerminal));
		        jFrameTerminal.setTitle("Terminal");
		        jFrameTerminal.setSize(300, 300);
		        jFrameTerminal.setLocation(200, 200);
		        jFrameTerminal.setVisible(true);

			}
			for (int i = 0; i < destino.getTripulacao().size(); i++) {
			
				listaTripulantesAviao[i] = destino.getTripulacao().get(i).getNome() +" : "+ destino.getTripulacao().get(i).getClass().getSimpleName();		        
				jFrameAviao.add(new JList(listaTripulantesAviao));
		        jFrameAviao.setTitle("Aviao");
		        jFrameAviao.setSize(300, 300);
		        jFrameAviao.setLocation(880, 200);
		        jFrameAviao.setVisible(true);
			}
		
			do{
				JOptionPane.showMessageDialog(null, jcb, "Selecione o Motorista", JOptionPane.QUESTION_MESSAGE);
			}while(!carro.addMotorista((Tripulacao) jcb.getSelectedItem()));
		
			origem.removeDoLocal((Tripulacao) jcb.getSelectedItem());
		
			jcb.removeAllItems();
			for (int i = 0; i < origem.getTripulacao().size(); i++) {
				jcb.addItem(origem.getTripulacao().get(i));
			}

			do{
				JOptionPane.showMessageDialog(null, jcb, "Selecione o Passageiro", JOptionPane.QUESTION_MESSAGE);
			}while(!carro.addPassageiro((Tripulacao) jcb.getSelectedItem()));
		
			origem.removeDoLocal((Tripulacao) jcb.getSelectedItem());
			
			try {
				carro.validaRegra();
				origem.validaRegras();
				fase1 = true;
			} catch (PilotoSozinhoComissariaException e) {
				JOptionPane.showMessageDialog (null, e, null, JOptionPane.ERROR_MESSAGE);
				origem.addAoLocal((Tripulacao) carro.getMotorista());
				origem.addAoLocal((Tripulacao) carro.getPassageiro());
				e.printStackTrace();
				
			} catch (ChefeSozinhoOficialException e) {
				JOptionPane.showMessageDialog (null, e, null, JOptionPane.ERROR_MESSAGE);
				origem.addAoLocal((Tripulacao) carro.getMotorista());
				origem.addAoLocal((Tripulacao) carro.getPassageiro());
				e.printStackTrace();
				
			} catch (PoliciaSemBandidoException e) {
				JOptionPane.showMessageDialog (null, e, null, JOptionPane.ERROR_MESSAGE);
				origem.addAoLocal((Tripulacao) carro.getMotorista());
				origem.addAoLocal((Tripulacao) carro.getPassageiro());
				fase1 = false;
				
				e.printStackTrace();
			}
	
		}while(!fase1);
		
		JOptionPane.showMessageDialog (null, "Carro em trânsito");
		
		destino.addAoLocal((Tripulacao) carro.getPassageiro());
		try {

			if(!origem.getTripulacao().isEmpty()) {
				destino.validaRegras();
				origem.addAoLocal((Tripulacao) carro.getMotorista());
				origem.validaRegras();
			}
			else {
				
				destino.addAoLocal((Tripulacao) carro.getMotorista());
				destino.addAoLocal((Tripulacao) carro.getPassageiro());
				fase2=true;
				}
		} catch (PilotoSozinhoComissariaException e) {
			JOptionPane.showMessageDialog (null, e, null, JOptionPane.ERROR_MESSAGE);
			origem.addAoLocal((Tripulacao) carro.getMotorista());
			origem.addAoLocal((Tripulacao) carro.getPassageiro());
			destino.removeDoLocal((Tripulacao) carro.getPassageiro());
			e.printStackTrace();
			
		} catch (ChefeSozinhoOficialException e) {
			JOptionPane.showMessageDialog (null, e, null, JOptionPane.ERROR_MESSAGE);
			origem.addAoLocal((Tripulacao) carro.getMotorista());
			origem.addAoLocal((Tripulacao) carro.getPassageiro());
			destino.removeDoLocal((Tripulacao) carro.getPassageiro());
			e.printStackTrace();
			
		} catch (PoliciaSemBandidoException e) {

			if(destino.isContainMotorista()) {
			
				for(Tripulacao tripulante : destino.getTripulacao()) {
					if(tripulante instanceof Motorista) {
						origem.addAoLocal((Tripulacao) tripulante);
						destino.removeDoLocal((Tripulacao) tripulante);
						break;
						}
				}
				destino.addAoLocal((Tripulacao) carro.getMotorista());

			}
			else {
				JOptionPane.showMessageDialog (null, "Não existe nenhum motorista para voltar com o carro!", null, JOptionPane.ERROR_MESSAGE);
				origem.addAoLocal((Tripulacao) carro.getMotorista());
				origem.addAoLocal((Tripulacao) carro.getPassageiro());
				destino.removeDoLocal((Tripulacao) carro.getPassageiro());
			}
			
		}
		
	 }while(!fase2);	
	 
	listaTripulantesAviao= new String[30] ;

    jFrameTerminal.setVisible(false);

	for (int i = 0; i < destino.getTripulacao().size(); i++) {
	
		listaTripulantesAviao[i] = destino.getTripulacao().get(i).getNome() +" : "+ destino.getTripulacao().get(i).getClass().getSimpleName();		        
		jFrameAviao.add(new JList(listaTripulantesAviao));
        jFrameAviao.setTitle("Aviao");
        jFrameAviao.setSize(300, 300);
        jFrameAviao.setLocation(880, 200);
        jFrameAviao.setVisible(true);
	}
		
	 JOptionPane.showMessageDialog (null, "Fim", null, JOptionPane.PLAIN_MESSAGE);

	}
}
