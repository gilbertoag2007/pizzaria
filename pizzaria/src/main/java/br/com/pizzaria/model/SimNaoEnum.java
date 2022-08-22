package br.com.pizzaria.model;

public enum SimNaoEnum {

	SIM("S"), NAO("N");
	
	public String valorEnum;
		SimNaoEnum(String valor) {
		valorEnum = valor;
	}
		public String getValorEnum() {
			return valorEnum;
		}
		public void setValorEnum(String valorEnum) {
			this.valorEnum = valorEnum;
		}
	
		
}
