Proceso Brrrr
	Escribir " Ingrese el valor de A "
	Leer A
	Escribir " Ingrese el valor de B "
	Leer B
	Escribir " Ingrese el valor de C "
	Leer C
	
	D <- (B^2) - (4 * A * C)
	
	Si A = 0 Entonces
		Escribir " No hay raiz "
	Sino
		Si D < 0 Entonces
			Escribir " No hay solución real "
		Sino
			X1 = (-B + RC (D)) / (2 * A)
			X2 = (-B - RC (D)) / (2 * A)
			Escribir " Raiz 1 = " " [ ",X1, " ] "
			Escribir " Raiz 2 = " " [ ",X2, " ] "
		Fin Si
	Fin Si
	
	
	
FinProceso
