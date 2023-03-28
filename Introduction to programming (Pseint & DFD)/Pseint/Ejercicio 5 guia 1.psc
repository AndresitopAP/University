Proceso Quien_es_Mayor
	
	Escribir " Asignar el pimer numero"
	
	Leer A
	
	Escribir " Asignar el segundo numero "
	
	Leer B
	
	Escribir " Asignar el trecer numero"
	
	Leer C
	
	Si A > B Entonces
		Mv <-A
	Sino
		Mv <- B
	Fin Si
	
	Si C > Mv Entonces
		MV <- C
	Fin Si
	
	Escribir " Entre < " ,A, " > ; < " ,B, " > y < " ,C, " > El mayor es " " [ " ,Mv," ] "
FinProceso
