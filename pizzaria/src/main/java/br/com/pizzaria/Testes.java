package br.com.pizzaria;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.pizzaria.util.FormatadorData;

public class Testes {

	public static void main(String[] args) {
		
		
		String dataHoraTexto = "20/08/2022 15:07:00";
		
		System.out.println(FormatadorData.LocalDateParaString(LocalDate.now()));
		System.out.println(FormatadorData.StringParaLocalDate("20/08/2022"));
		
		System.out.println(FormatadorData.LocalDateTimeParaString(LocalDateTime.now()));
		System.out.println(FormatadorData.StringParaLocalDateTime("20/08/2022 15:07:00"));
	}
}
