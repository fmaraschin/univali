package exercicio6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;
import br.ufsc.ine.leb.sistemaBancario.ValorMonetario;

public class CoberturaSistemaBancario {

	
	private SistemaBancario sistemaBancario;
	private Banco bancoBrasil;
	private Agencia bancoBrasilCentro;

	
	@Before
	public void configurar() {		
		sistemaBancario = new SistemaBancario(); 
		bancoBrasil = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
		bancoBrasilCentro = bancoBrasil.criarAgencia("Centro");				
	}

	@Test
	public void bancoBrasil() throws Exception {
		assertEquals("Banco do Brasil", bancoBrasil.obterNome());
		assertEquals(Moeda.BRL, bancoBrasil.obterMoeda());
	}

	@Test
	public void bancoBrasilCentro() throws Exception {
		assertEquals("001", bancoBrasilCentro.obterIdentificador());
		assertEquals("Centro", bancoBrasilCentro.obterNome());
		assertEquals(bancoBrasil, bancoBrasilCentro.obterBanco());
	}

	@Test
	public void mariaBancoBrasilCentro() throws Exception {
		Conta mariaBancoBrasilCentro = bancoBrasilCentro.criarConta("Maria");
		assertEquals("0001-5", mariaBancoBrasilCentro.obterIdentificador());
		assertEquals("Maria", mariaBancoBrasilCentro.obterTitular());
		assertTrue(mariaBancoBrasilCentro.calcularSaldo().zero());
		assertEquals(bancoBrasilCentro, mariaBancoBrasilCentro.obterAgencia());
	}
	
	@Test
	public void mariaBancoBrasilCentroDeposito() throws Exception {
		Conta mariaBancoBrasilCentro = bancoBrasilCentro.criarConta("Maria");		
		sistemaBancario.depositar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 10, 0));
		
		ValorMonetario valorMonetario = new ValorMonetario(Moeda.BRL);
		valorMonetario.somar(new Dinheiro(Moeda.BRL, 10, 0));

		assertEquals("0001-5", mariaBancoBrasilCentro.obterIdentificador());
		assertEquals("Maria", mariaBancoBrasilCentro.obterTitular());
		assertEquals(valorMonetario, mariaBancoBrasilCentro.calcularSaldo());
		assertEquals(bancoBrasilCentro, mariaBancoBrasilCentro.obterAgencia());
	}	
	
	@Test
	public void mariaBancoBrasilCentroSaque() throws Exception {		
		Conta mariaBancoBrasilCentro = bancoBrasilCentro.criarConta("Maria");		
		sistemaBancario.depositar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 10, 0));
		sistemaBancario.sacar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 6, 0));		 			
		
		ValorMonetario valorMonetario = new ValorMonetario(Moeda.BRL);
		valorMonetario.somar(new Dinheiro(Moeda.BRL, 4, 0));

		assertEquals("0001-5", mariaBancoBrasilCentro.obterIdentificador());
		assertEquals("Maria", mariaBancoBrasilCentro.obterTitular());
		assertEquals(valorMonetario, mariaBancoBrasilCentro.calcularSaldo());
		assertEquals(bancoBrasilCentro, mariaBancoBrasilCentro.obterAgencia());
	}		
	
	@Test
	public void mariaBancoBrasilCentroSaldoNegativo() throws Exception {
		Conta mariaBancoBrasilCentro = bancoBrasilCentro.criarConta("Maria");	
		
		sistemaBancario.depositar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 10, 0));
		sistemaBancario.sacar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 6, 0));		
			
		if (!mariaBancoBrasilCentro.calcularSaldo().negativo()) 		
			sistemaBancario.sacar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 6, 0));		
		
		ValorMonetario valorMonetario = new ValorMonetario(Moeda.BRL);
		valorMonetario.somar(new Dinheiro(Moeda.BRL, 4, 0));

		assertEquals("0001-5", mariaBancoBrasilCentro.obterIdentificador());
		assertEquals("Maria", mariaBancoBrasilCentro.obterTitular());
		assertEquals(valorMonetario, mariaBancoBrasilCentro.calcularSaldo());
		assertEquals(bancoBrasilCentro, mariaBancoBrasilCentro.obterAgencia());
	}	


	@Test
	public void mariaBancoBrasilCentroTransferencia() throws Exception {
		
		Conta mariaBancoBrasilCentro = bancoBrasilCentro.criarConta("Maria");	
		Conta joseBancoBrasilCentro = bancoBrasilCentro.criarConta("Jose");
		Operacao deposito = sistemaBancario.depositar(mariaBancoBrasilCentro, new Dinheiro(Moeda.BRL, 1000, 0));
		Operacao transferenciaMoedaUSD = sistemaBancario.transferir(mariaBancoBrasilCentro, joseBancoBrasilCentro, new Dinheiro(Moeda.USD, 55, 0));
		Operacao transferenciaMoedaBRL = sistemaBancario.transferir(mariaBancoBrasilCentro, joseBancoBrasilCentro, new Dinheiro(Moeda.BRL, 50, 0));
					
		assertEquals("0001-5", mariaBancoBrasilCentro.obterIdentificador());
		assertEquals("Maria", mariaBancoBrasilCentro.obterTitular());
		assertEquals(bancoBrasilCentro, mariaBancoBrasilCentro.obterAgencia());
			
		assertEquals("0002-4", joseBancoBrasilCentro.obterIdentificador());
		assertEquals("Jose", joseBancoBrasilCentro.obterTitular());
		assertEquals(bancoBrasilCentro, joseBancoBrasilCentro.obterAgencia());	
		assertEquals("+50,00 BRL", joseBancoBrasilCentro.calcularSaldo().formatado());
		
		assertEquals(deposito.obterEstado(), EstadosDeOperacao.SUCESSO);
		assertEquals(transferenciaMoedaUSD.obterEstado(), EstadosDeOperacao.MOEDA_INVALIDA);
		assertEquals(transferenciaMoedaBRL.obterEstado(), EstadosDeOperacao.SUCESSO);	
		
	}
	
	
}
