package br.com.jailson.Gft;

import java.util.HashMap;
import java.util.Map;

public class CalculaSaida {
	private String args[];
	final String ENTER = "\r\n";
	
	
	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public String getSaida() {
		String saida="Saída: ";
		Refeicao r = new Refeicao();
		Map<Integer, Item> mapaIds = new HashMap<Integer,Item>();
		
		if (args!=null && args.length>0) {
			String aux="";
			if (args.length>1) {
				for (int i = 0; i < args.length; i++) {
					aux+=args[i];
				}
			} else {
				aux = args[0];
			}
			
			String parametros[] = aux.split(",");
			String periodo = parametros[0];
			
			if (!periodo.toUpperCase().equals("MANHÃ") && !periodo.toUpperCase().equals("NOITE")) {
				saida ="Erro, período informado nao reconhecido.";
				return saida;
			}
			
			for (int i = 1; i < parametros.length; i++) {
				Integer chave = new Integer(parametros[i].trim());
				int index = chave.intValue();
				Refeicao refeicao = null;
				
				try {
					refeicao = r.listaRefeicao().get(index-1);
				} catch (IndexOutOfBoundsException e) {
					refeicao=null;
				}
				
				if (refeicao==null) {
					saida+=Refeicao.REFEICAO_N_EXISTE+ENTER;
					saida+="Escolha uma das opções válidas"+ENTER;
					saida+="Tipo prato		Manhã                 	Noite"+ENTER;
					for (Refeicao ref : r.listaRefeicao()) {
						if (ref.getTipo().length()<11)
								saida+=ref.id+ref.getTipo()+"       	"+ref.refeicaoManha+"			"+ref.refeicaoNoite+ENTER;
						else if (ref.getTipo().length()<13)
							if (ref.refeicaoManha.equals(Refeicao.NAO_SE_APLICA))							
								saida+=ref.id+ref.getTipo()+"       	"+ref.refeicaoManha+"		"+ref.refeicaoNoite+ENTER;
							else
								saida+=ref.id+ref.getTipo()+"       	"+ref.refeicaoManha+"			 "+ref.refeicaoNoite+ENTER;
						else
							saida+=ref.id+ref.getTipo()+"       "+ref.refeicaoManha+"			"+ref.refeicaoNoite+ENTER;
					}
					return saida;
				}
				
				Item item=mapaIds.get(chave);
				
				if (item!=null) {
					item.setQtde(item.getQtde()+1);
				} else {
					item = new Item(refeicao, 1);
					mapaIds.put(new Integer(index), item);
				}
			}			
			boolean manha = periodo.toUpperCase().equals("MANHÃ");
			
			
			for (Integer chave : mapaIds.keySet()) {
				Item item = mapaIds.get(chave);
				if (manha) {
					if (item.getQtde()>1) {
						if (item.getRefeicao().podeRepetirManha) {
							saida+=item.getRefeicao().refeicaoManha+" (x"+item.getQtde() +"), ";
						} else {
							saida+="erro, ";
						}
					} else {
						if (item.getRefeicao().refeicaoManha.equals(Refeicao.NAO_SE_APLICA)) {
							saida+="erro, ";
						} else {
							saida+=item.getRefeicao().refeicaoManha+", ";
						}
					}
				} else {
					if (item.getQtde()>1) {
						if (item.getRefeicao().podeRepetirNoite) {
							saida+=item.getRefeicao().refeicaoNoite+" (x"+item.getQtde() +"), ";
						} else {
							saida+="erro, ";
						}
					} else {
						saida+=item.getRefeicao().refeicaoNoite+", ";
					}
				}
			}
			if (saida.length()>0) {
				saida = saida.substring(0, saida.length()-2);
			}
		} else {
			saida="Erro, não foi informado nennhum parâmetro.";
		}
		return saida;
	}	

}
