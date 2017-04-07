package exercicio4.delegate;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {
	
	public static Banco criarCaixaEconomica() {
		return new SistemaBancario().criarBanco("Caixa Econômica", Moeda.BRL);				
	}
	
	public static Agencia criarTrindade(Banco caixaEconomica) {
		return caixaEconomica.criarAgencia("Trindade");
	}
	
	public static Conta criarConta(Agencia caixaEconomicaTrindade) {
		return caixaEconomicaTrindade.criarConta("João");
	}

}
