Algoritmo Mayor_o_igual
	
	Escribir " Ingrese el Primer numero"
	Leer A
	Escribir " Ingrese el Segundo numero"
	Leer B
	Escribir " Ingrese el Tercer numero"
	Leer C
	
	Si A > B y A > C Entonces
		Escribir " A es mayor que B y C"
	SiNo
		Si A<B y A<C Entonces
			Escribir " A es menor que B y C"
		Fin Si
	Fin Si
	
	Si B > A y B > C Entonces
		Escribir " B es mayor que A y C"
	SiNo
		Si B<A y B<C Entonces
			Escribir " B es menor que A y C"
		Fin Si
	Fin Si
	
	Si C > A y C > B Entonces
		Escribir " C es mayor que A y B"
	SiNo
		Si C<A y C<B Entonces
			Escribir " C es menor que A y B"
		Fin Si
	Fin Si
	
	Si A=B o B=A Entonces
		Escribir " A es igual a B"
	SiNo
		Si A=C o C=A Entonces
			Escribir " A es igual a C"
		Fin Si
	Fin Si
	
	Si C=B o B=C Entonces
		Escribir " C es igual a B"
	Fin Si
FinAlgoritmo
