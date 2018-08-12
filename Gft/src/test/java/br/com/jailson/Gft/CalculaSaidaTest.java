package br.com.jailson.Gft;

import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.TestCase;

public class CalculaSaidaTest extends TestCase {
	
	@Test
	public void testePeriodoDiferenteManhaNoite() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"TARDE 1"};
		calc.setArgs(args);
		
		
		assertEquals(calc.getSaida(), "Erro, período informado nao reconhecido.");
	}

	
	@Test
	public void testeRefeicaoNaoExiste() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"Manhã,1,5"};
		calc.setArgs(args);
		String saida = Refeicao.REFEICAO_N_EXISTE;
		
		assertEquals(true, calc.getSaida().contains(saida));
	}
	
	@Test
	public void testeEncontradoManhaNaoSeAplica() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"manhã, 1, 2, 3, 4"};
		calc.setArgs(args);
		String saida = "Saída: ovos, torrada, café, erro";
		
		assertEquals(true, calc.getSaida().equals(saida));
	}	
	
	@Test
	public void testeEncontrado1() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"manhã, 1, 2, 3"};
		calc.setArgs(args);
		String saida = "Saída: ovos, torrada, café";
		
		assertEquals(true, calc.getSaida().equals(saida));
	}
	
	@Test
	public void testeEncontradoCafe3x() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"manhã, 1, 2, 3, 3, 3"};
		calc.setArgs(args);
		String saida = "Saída: ovos, torrada, café (x3)";
		
		assertEquals(true, calc.getSaida().equals(saida));
	}
	
	@Test
	public void testeEncontradoBolo() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"noite, 1, 2, 3, 4"};
		calc.setArgs(args);
		String saida = "Saída: carne, batata, vinho, bolo";
		
		assertEquals(true, calc.getSaida().equals(saida));
	}
	
	
	@Test
	public void testeEncontradoBolo2x() {
		CalculaSaida calc = new CalculaSaida(); 
		String args[] = {"noite, 1, 2, 2, 4"};
		calc.setArgs(args);
		String saida = "Saída: carne, batata (x2), bolo";
		
		assertEquals(true, calc.getSaida().equals(saida));
	}
	
	
}
