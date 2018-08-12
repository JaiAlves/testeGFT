package br.com.jailson.Gft;

public class Item {
	
	private Refeicao refeicao;
	private int qtde;
	
	public Item(Refeicao refeicao, int qtde) {
		super();
		this.refeicao = refeicao;
		this.qtde = qtde;
	}
	
	public Refeicao getRefeicao() {
		return refeicao;
	}
	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

}
