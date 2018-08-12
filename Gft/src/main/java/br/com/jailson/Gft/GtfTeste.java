package br.com.jailson.Gft;

public class GtfTeste {

	public static void main(String[] args) {

		CalculaSaida calc = new CalculaSaida();
		calc.setArgs(args);
		
		System.out.println(calc.getSaida());
	}
}

