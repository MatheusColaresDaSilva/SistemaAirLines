package br.com.codeitairlines.principal;

import java.awt.GraphicsConfiguration;

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
	static GraphicsConfiguration gc;

	public static void main(String[] args) {

		JFrame f = new JFrame("Test");
		JFrame f2 = new JFrame("Test2");
		String[] data;
		String[] data2;


			
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


	 do {
		do {
			data= new String[30] ;
			data2= new String[30] ;
			jcb.removeAllItems();	
			for (int i = 0; i < origem.getTripulacao().size(); i++) {
				jcb.addItem(origem.getTripulacao().get(i));
				
				
				data[i] = origem.getTripulacao().get(i).getNome() +" : "+ origem.getTripulacao().get(i).getClass().getSimpleName();
		        f.add(new JList(data));
		        f.setTitle("Terminal");
		        f.setSize(300, 300);
		        f.setLocation(200, 200);
		        f.setVisible(true);

			}
			for (int i = 0; i < destino.getTripulacao().size(); i++) {
			
				data2[i] = destino.getTripulacao().get(i).getNome() +" : "+ destino.getTripulacao().get(i).getClass().getSimpleName();		        
				f2.add(new JList(data2));
		        f2.setTitle("Aviao");
		        f2.setSize(300, 300);
		        f2.setLocation(880, 200);
		        f2.setVisible(true);
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
					origem.validaRegras();
					fase1 = true;
				} catch (PilotoSozinhoComissariaException e) {
					JOptionPane.showMessageDialog (null, e);
					origem.addAoLocal((Tripulacao) carro.getMotorista());
					origem.addAoLocal((Tripulacao) carro.getPassageiro());
					e.printStackTrace();
					
				} catch (ChefeSozinhoOficialException e) {
					JOptionPane.showMessageDialog (null, e);
					origem.addAoLocal((Tripulacao) carro.getMotorista());
					origem.addAoLocal((Tripulacao) carro.getPassageiro());
					e.printStackTrace();
					
				} catch (PoliciaSemBandidoException e) {
					JOptionPane.showMessageDialog (null, e);
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
			JOptionPane.showMessageDialog (null, e);
			origem.addAoLocal((Tripulacao) carro.getMotorista());
			origem.addAoLocal((Tripulacao) carro.getPassageiro());
			destino.removeDoLocal((Tripulacao) carro.getPassageiro());
			e.printStackTrace();
			
		} catch (ChefeSozinhoOficialException e) {
			JOptionPane.showMessageDialog (null, e);
			origem.addAoLocal((Tripulacao) carro.getMotorista());
			origem.addAoLocal((Tripulacao) carro.getPassageiro());
			destino.removeDoLocal((Tripulacao) carro.getPassageiro());
			e.printStackTrace();
			
		} catch (PoliciaSemBandidoException e) {
			System.out.println("wygwywgywgy");
			if(destino.isContainMotorista()) {
				System.out.println("sim");
				
				for(Tripulacao tripulante : destino.getTripulacao()) {
					if(tripulante instanceof Motorista) {
						origem.addAoLocal((Tripulacao) tripulante);
						destino.removeDoLocal((Tripulacao) tripulante);
						
						System.out.println(tripulante.getNome());
						System.out.println(carro.getMotorista());
						break;
						}
				}
				destino.addAoLocal((Tripulacao) carro.getMotorista());

			}
			else {
				JOptionPane.showMessageDialog (null, "Não existe nenhum motorista para voltar com o carro!");
				origem.addAoLocal((Tripulacao) carro.getMotorista());
				origem.addAoLocal((Tripulacao) carro.getPassageiro());
				destino.removeDoLocal((Tripulacao) carro.getPassageiro());
			}
			
		}
		
		
		System.out.println(origem.getTripulacao());

		System.out.println(destino.getTripulacao());
	
	 }while(!fase2);	
	 


		data2= new String[30] ;

	        f.setVisible(false);

		for (int i = 0; i < destino.getTripulacao().size(); i++) {
		
			data2[i] = destino.getTripulacao().get(i).getNome() +" : "+ destino.getTripulacao().get(i).getClass().getSimpleName();		        
			f2.add(new JList(data2));
	        f2.setTitle("Aviao");
	        f2.setSize(300, 300);
	        f2.setLocation(880, 200);
	        f2.setVisible(true);
		}
		
	 JOptionPane.showMessageDialog (null, "Fim");
	}
}
