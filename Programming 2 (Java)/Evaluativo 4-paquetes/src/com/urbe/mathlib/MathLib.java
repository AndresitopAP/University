package com.urbe.mathlib;

public class MathLib {

	public double totalBruto(double price, double DESC, int quantity) {
		double total_compra = price * (1 - (DESC/100)) * quantity;
		return total_compra;
	}
	
	public double totalNeto(double price, double IVA, double DESC, int quantity) {
		double total_compra = price * (1 + (IVA/100)) * (1 - (DESC/100)) * quantity;
		return total_compra;
	}
	
	public double[] totalesCompra(int[] option, int[] cant_comprar, double[] descuento, double[] price, int cant_articulo, double IVA) {
		double total_bruto = 0;
		for(int i = 0; i < cant_articulo; i++) {
			total_bruto = total_bruto + ((price[option[i]-1])*(1-(descuento[i]/100))*(cant_comprar[i]));
		}
		
		double total_neto = total_bruto * (1+ (IVA/100));
		
		double[] totales = {total_bruto, total_neto};
		
		return totales;
	}
	
	public double[] suma_totales(double[] total_bruto, double[] total_neto, int cant_clientes) {
		double suma_bruto = 0, suma_neto = 0;
		
		for(int i = 0; i < cant_clientes; i++) {
			suma_bruto = suma_bruto + total_bruto[i];
			suma_neto = suma_neto + total_neto[i];
		}
		
		double[] totales = {suma_bruto, suma_neto};
		
		return totales;
	}
	
	public double dollarToBs(double valorDollar, double bolivar) {
		double bolivares = valorDollar * bolivar;
		return bolivares;
	}
	
	
}
