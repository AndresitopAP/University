Algoritmo Cumpleaños
	
	Escribir " Ingrese el dia de cumpleaños"
	Leer dc
	Escribir " Ingrese el mes de cumpleaños"
	Leer mc
	Escribir " Ingrese el año de cumpleaños"
	Leer ac
	
	Escribir " Ingrese el dia deseado"
	Leer d
	Escribir " Ingrese el mes deseado"
	Leer m
	Escribir " Ingrese el año deseado"
	Leer a
	
	
	Si dc >= d y mc >= m Entonces
		e <- a - ac - 1
	SiNo
		e <- a - ac 
	Fin Si
	
	Escribir " Usted tiene " ,e
	
FinAlgoritmo
