Proceso sin_titulo
	Vi <- 1
	Vf <- 5
	ContaPos <- 0
	SumaPos <- 0
	Para Vc <- Vi Hasta Vf Hacer
		Escribir "INgrese el numero POsitivo,"
		Escribir "En orden Numerica [ " , Vc, "° ]"
		Leer Num
		Si Num>0 Entonces
			ContaPos<- ContaPos + 1
			SumaPos<- SumaPos + Num
		Fin Si
	Fin Para
	Escribir " De < " ,Vf, " > numeros ingresados"
	Escribir "    < ",Contapos, " > Fueron Positivos"
	Escribir " Y la suma de ellos es = ",SumaPos
FinProceso
