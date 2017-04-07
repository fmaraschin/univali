package exercicio4.inline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteBanco {

	@Test
	public void caixaEconomica() throws Exception {
		Banco caixaEconomica = new SistemaBancario().criarBanco("Caixa Econ�mica", Moeda.BRL);
		assertEquals("Caixa Econ�mica", caixaEconomica.obterNome());
		assertEquals(Moeda.BRL, caixaEconomica.obterMoeda());
	}

}
