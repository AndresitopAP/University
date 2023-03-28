Algoritmo Factora
	
	Escribir " Combo de Hamburgesas "
	Escribir " Cantidad "
	Leer A1
	Escribir " Precio "
	Leer A2
	
	Escribir " Coca-Cola "
	Escribir " Cantidad "
	Leer B1
	Escribir " Precio "
	Leer B2
	
	Escribir " Papas Fritas "
	Escribir " Cantidad "
	Leer C1
	Escribir " Precio "
	Leer C2
	
	A3 <- A2* A1
	B3 <- B2* B1
	C3 <- C2* C1
	
	D <- A3 + B3 + C3
	
	H <- D * 0.16
	F <- H + D
	
	Escribir " Su Cuenta es = " ,D
	Escribir " El total a Pagar con IVA es = " ,F
	
FinAlgoritmo
