package br.com.pizzaria.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import antlr.StringUtils;

public class FormatadorData {


	/**
	 * Converte string para LocalDate. 
	 */
	public static LocalDate StringParaLocalDate ( String dataTexto) {
	
		LocalDate resultado;
		
		
		if(dataTexto != null) {
			
			int dia = Integer.valueOf(dataTexto.substring(0, 2));
			int mes = Integer.valueOf(dataTexto.substring(3, 5));
		    Month month = Month.of(mes);
		    int ano = Integer.valueOf(dataTexto.substring(6, 10));
		    resultado = LocalDate.of(ano, month, dia);
		    return resultado;
		}
		
	    return null;
	}	

	/**
	 *  Converte localDate para String.
	 */
	public static String LocalDateParaString (LocalDate data) {
		
		String dataFormatada;
		
		if(data != null) {
			DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dataFormatada = data.format(formatadorData);
			return dataFormatada;
		}
		return null;
	}	

	/**
	 * Converte string para LocalDateTime. 
	 */
	public static LocalDateTime StringParaLocalDateTime ( String dataHoraTexto) {
	
		 LocalDateTime resultado;
		 
		 
		if(dataHoraTexto != null) {
			
			int dia = Integer.valueOf(dataHoraTexto.substring(0, 2));
			int mes = Integer.valueOf(dataHoraTexto.substring(3, 5));
		    int ano = Integer.valueOf(dataHoraTexto.substring(6, 10));
		    int hora = Integer.valueOf(dataHoraTexto.substring(11, 13));
		    int minutos = Integer.valueOf(dataHoraTexto.substring(14, 16));
		    
		     resultado = LocalDateTime.of(ano, mes, dia, hora, minutos );
		     return resultado;
		}
	    return null;
	}	

	/**
	 *  Converte localDateTime para String.
	 */
	public static String LocalDateTimeParaString ( LocalDateTime dataHora) {
		
		String dataHoraFormatada;
		
		if(dataHora != null) {
			DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			dataHoraFormatada = dataHora.format(formatadorData);
			return dataHoraFormatada;
		}
		return null;
	}
	
}
