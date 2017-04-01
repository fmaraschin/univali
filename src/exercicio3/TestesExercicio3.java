package exercicio3;

import static org.junit.Assert.*;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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
	
	@Test
	public void criarDataNascimento() throws Exception {
		 LocalDate nascimento = new LocalDate(1979, 2, 22);
		 assertEquals(22, nascimento.getDayOfMonth());
		 assertEquals(2, nascimento.getMonthOfYear());
		 assertEquals(1979, nascimento.getYear());
	}		 
	
	@Test
	public void criarHorarioAcordou() throws Exception {
		LocalTime horario = new LocalTime(7, 52);
		assertEquals(7, horario.getHourOfDay());
		assertEquals(52, horario.getMinuteOfHour());		
	}
		
	@Test(expected = IllegalFieldValueException.class)
	public void criarDataHorarioErrado() throws Exception {
		LocalDate data = new LocalDate(2017, 2, 29);		
		LocalTime horario = new LocalTime(10, 57);		
	}		
	
	@Test
	public void somarDiaNaData() throws Exception {
		LocalDate data = new LocalDate(2017, 2, 28).plusDays(1);			
		assertEquals(1, data.getDayOfMonth());
		assertEquals(3, data.getMonthOfYear());
		assertEquals(2017, data.getYear());		
	}		
	
	
}
