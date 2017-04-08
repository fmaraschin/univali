package exercicio5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBancoAgenciaConta {
	
	private Banco bancoDoBrasil;
	private Agencia bancoDoBrasilTrindade;

/*	
	@Before
	public void configurar() {		
		bancoDoBrasil = new SistemaBancario().criarBanco("Banco do Brasil", Moeda.BRL);
		bancoDoBrasilTrindade = caixaEconomica.criarAgencia("Trindade");				
	}

	@Test
	public void caixaEconomica() throws Exception {
		assertEquals("Caixa Econômica", caixaEconomica.obterNome());
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
	}

	@Test
	public void caixaEconomicaTrindade() throws Exception {
		assertEquals("001", caixaEconomicaTrindade.obterIdentificador());
		assertEquals("Trindade", caixaEconomicaTrindade.obterNome());
		assertEquals(caixaEconomica, caixaEconomicaTrindade.obterBanco());
	}

	@Test
	public void joaoCaixaEconomicaTrindade() throws Exception {
		Conta joaoCaixaEconomicaTrindade = caixaEconomicaTrindade.criarConta("João");
		assertEquals("0001-4", joaoCaixaEconomicaTrindade.obterIdentificador());
		assertEquals("João", joaoCaixaEconomicaTrindade.obterTitular());
		assertTrue(joaoCaixaEconomicaTrindade.calcularSaldo().zero());
		assertEquals(caixaEconomicaTrindade, joaoCaixaEconomicaTrindade.obterAgencia());
	}
*/
	
}
