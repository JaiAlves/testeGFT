package br.com.jailson.Gft;

import java.util.ArrayList;
import java.util.List;

public class Refeicao {
	int id;
	String tipo;
	String refeicaoManha;
	String refeicaoNoite;
	boolean podeRepetirManha;
	boolean podeRepetirNoite;
	public static String NAO_SE_APLICA = "Não se aplica";
	public static String REFEICAO_N_EXISTE="erro , refeição não encontrada";
	
	
	public Refeicao(int id,String tipo, String refeicaoManha, String refeicaoNoite, boolean podeRepetirManha, boolean podeRepetirNoite) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.refeicaoManha = refeicaoManha;
		this.refeicaoNoite = refeicaoNoite;
		this.podeRepetirManha = podeRepetirManha;
		this.podeRepetirNoite = podeRepetirNoite;
	}

	public Refeicao() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRefeicaoManha() {
		return refeicaoManha;
	}
	public void setRefeicaoManha(String refeicaoManha) {
		this.refeicaoManha = refeicaoManha;
	}
	public String getRefeicaoNoite() {
		return refeicaoNoite;
	}
	public void setRefeicaoNoite(String refeicaoNoite) {
		this.refeicaoNoite = refeicaoNoite;
	}
	public boolean isPodeRepetirManha() {
		return podeRepetirManha;
	}
	public void setPodeRepetirManha(boolean podeRepetirManha) {
		this.podeRepetirManha = podeRepetirManha;
	}
	
	public boolean isPodeRepetirNoite() {
		return podeRepetirNoite;
	}
	public void setPodeRepetirNoite(boolean podeRepetirNoite) {
		this.podeRepetirNoite = podeRepetirNoite;
	}
	
	
	public List<Refeicao> listaRefeicao() {
		List<Refeicao> lista = new ArrayList<Refeicao>();
		
		lista.add(new Refeicao(1,"(entrada)", "ovos","carne",false, false));
		lista.add(new Refeicao(2,"(acompanhamento)","torrada","batata",false, true));
		lista.add(new Refeicao(3,"(bebida)","café","vinho",true, false));
		lista.add(new Refeicao(4,"(sobremesa)",NAO_SE_APLICA,"bolo",false, false));
				
		return lista;
	}
	
}