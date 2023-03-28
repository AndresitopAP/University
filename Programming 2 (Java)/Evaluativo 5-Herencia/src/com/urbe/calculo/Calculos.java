package com.urbe.calculo;

import Default.Jugador;
import Default.Entrenador;

public class Calculos {
	
	public int getTotalPosicion(Jugador[] jugadr, int Xj, String posizion) {
		//analisis de la posicion
		int cantidad = 0;
		
		for(int i = 0; i < Xj; i++) {
			String posicion_jugador = jugadr[i].getPosicion();
			if(posicion_jugador.equals(posizion)) {
				cantidad +=1;
			}
		}
		return cantidad;
	}
	
	public int getTotalPie(Jugador[] jugadr, int Xj, String pie) {
		//analisis de la posicion
		int cantidad = 0;
		
		for(int i = 0; i < Xj; i++) {
			String pie_jugador = jugadr[i].getPie_preferido();
			if(pie_jugador.equals(pie)) {
				cantidad +=1;
			}
		}
		return cantidad;
	}
	
	public int getHigherSalary(Jugador[] jugadr, int Xj) {
		double max_salary = jugadr[0].getSueldo();
		int position = 0;
		
		for(int i = 0; i < Xj; i++) {
			double sueldo = jugadr[i].getSueldo();
			if(sueldo > max_salary) {
				max_salary = sueldo;
				position = i;
			}
		}
		
		return position;
		
	}
	
	public int getMenorSalary(Jugador[] jugadr, int Xj) {
		double menor_salary = jugadr[0].getSueldo();
		int position = 0;
		
		for(int i = 0; i < Xj; i++) {
			double sueldo = jugadr[i].getSueldo();
			if(sueldo < menor_salary) {
				menor_salary = sueldo;
				position = i;
			}
		}
		
		return position;
		
	}
	
	  public int getLigther(Jugador[] jugadr, int Xj) {
		double ligher = jugadr[0].getPeso();
		int pos = 0;
		
		for(int i = 0; i < Xj; i++) {
			double peso_d_j = jugadr[i].getPeso();
			if(peso_d_j < ligher) {
				pos = i;
			}
		}
		
		return pos;
	}
	
 
	public int getHeavier(Jugador[] jugadr, int Xj) {
		double heavier = jugadr[0].getPeso();
		int pos = 0;
		
		for(int i = 0; i < Xj; i++) {
			double peso_g_j = jugadr[i].getPeso();
			if(peso_g_j > heavier) {
				pos = i;
			}
		}
		
		return pos;
	}
	 
	public int getHigherSalarye(Entrenador[] entrenador, int Xe) {
		double max_salary = entrenador[0].getSueldo();
		int position = 0;
		
		for(int i = 0; i < Xe; i++) {
			double sueldo = entrenador[i].getSueldo();
			if(sueldo > max_salary) {
				max_salary = sueldo;
				position = i;
			}
		}
		
		return position;
		
	}
	
	public int getMenorSalarye(Entrenador[] entrenador, int Xe) {
		double menor_salary = entrenador[0].getSueldo();
		int position = 0;
		
		for(int i = 0; i < Xe; i++) {
			double sueldo = entrenador[i].getSueldo();
			if(sueldo < menor_salary) {
				menor_salary = sueldo;
				position = i;
			}
		}
		
		return position;
		
	}
	
	public int getHigher(Jugador[] jugadr, int Xj) {
		double higher = jugadr[0].getAltura();
		int pos = 0;
		
		for(int i = 0; i < Xj; i++) {
			double altura_j = jugadr[i].getAltura();
			if(altura_j > higher) {
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int getLowerHeight(Jugador[] jugadr, int Xj) {
		double lower_h = jugadr[0].getAltura();
		int pos = 0;
		
		for(int i = 0; i < Xj; i++) {
			double altura_b_j = jugadr[i].getAltura();
			if(altura_b_j < lower_h) {
				pos = i;
			}
		}
		
		return pos;
	}
	
	

}
