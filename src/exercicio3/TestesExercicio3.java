package exercicio3;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.junit.Test;

public class TestesExercicio3 {
	
	@Test
	public void verificandoQueDoisEhDiferenteDeTres() throws Exception {
		 assertEquals(3, 2);
	}
	
	@Test
	public void criarDataHoje() throws Exception {
		 LocalDate hoje = new LocalDate(2017, 4, 1);
		 assertEquals(1, hoje.getDayOfMonth());
		 assertEquals(4, hoje.getMonthOfYear());
		 assertEquals(2017, hoje.getYear());
	}
	
	//Criação de um LocalDate da data de seu nascimento.
	@Test
	public void criarDataNascimento() throws Exception {
		 LocalDate nascimento = new LocalDate(1979, 2, 22);
		 assertEquals(22, nascimento.getDayOfMonth());
		 assertEquals(2, nascimento.getMonthOfYear());
		 assertEquals(1979, nascimento.getYear());
	}		 
	
	//Criação de um LocalTime do horário em que você acordou hoje
	@Test
	public void criarHorarioAcordou() throws Exception {
		LocalTime horario = new LocalTime(7, 52);
		assertEquals(7, horario.getHourOfDay());
		assertEquals(52, horario.getMinuteOfHour());		
	}
		
	//Criação de um LocalDate e LocalTime inválidos.	
	@Test(expected = IllegalFieldValueException.class)
	public void criarDataHorarioErrado() throws Exception {
		LocalDate data = new LocalDate(2017, 2, 29);		
		LocalTime horario = new LocalTime(10, 57);		
	}		
	
	//Somar um dia à data 28/02/2017.
	@Test
	public void somarDiaNaData() throws Exception {
		LocalDate data = new LocalDate(2017, 2, 28).plusDays(1);			
		assertEquals(1, data.getDayOfMonth());
		assertEquals(3, data.getMonthOfYear());
		assertEquals(2017, data.getYear());		
	}
	
	//Subtrair um milissegundo do horário 00:00.
	@Test
	public void subtrairMilisegundo() throws Exception {
		LocalTime horario = new LocalTime(0, 0, 0, 0).minusMillis(1);
		assertEquals(23, horario.getHourOfDay());
		assertEquals(59, horario.getMinuteOfHour());
		assertEquals(59, horario.getSecondOfMinute());
		assertEquals(59, horario.getMillisOfSecond());
	}
	
	//Verificar se o horário 23.59.59.999 é antes ou depois do horário 00:00
	@Test
	public void verificarHorarioAnterior() throws Exception {
		LocalTime horario1 = new LocalTime(23, 59, 59, 999).minusMillis(1);
		LocalTime horario2 = new LocalTime(0, 0);				
		assertTrue(horario1.isAfter(horario2));
	}	
	
	//Contar o número de horas entre 31/03/2017 18:30 e 06/05/2017 18:30
	@Test
	public void contarNumeroHoras() throws Exception {		
		DateTime primeiroDia = new DateTime(2017, 3, 31, 18, 30); 
		DateTime ultimoDia = new DateTime(2017, 5, 6, 18, 30);		
		Interval intervalo = new Interval(primeiroDia, ultimoDia);		
		Period periodo = new Period(intervalo.toDurationMillis());
		//System.out.println(periodo.getHours());		
		assertEquals(864, periodo.getHours());
	}	
	
	
}
