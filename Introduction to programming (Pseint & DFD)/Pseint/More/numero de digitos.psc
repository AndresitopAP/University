Algoritmo num
	Escribir " Ingrese el digito"
	Leer digito
	
	Si digito >= 1 y  digito <= 9 o digito <= -1 y digito >= -9 Entonces
		Escribir " Es un solo digito"
	SiNo
		Si digito >= 10 y digito <= 99 o digito <= -10 y digito >= -99 Entonces
			Escribir " Son dos digitos"
		SiNo
			Si digito >= 100 y digito <= 999 o digito <= -100 y digito >= -999 Entonces
				Escribir " Son tres digitos"
			SiNo
				Si digito >= 1000 y digito <= 9999 o digito <= -1000 y digito >= -9999 Entonces
					Escribir " Son cuatro digitos"
				Fin Si
			Fin Si
		Fin Si
	Fin Si
FinAlgoritmo
