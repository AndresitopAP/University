Proceso IVA
	escribir "unidad del articulo"
	leer articulo
	escribir "precio del articulo"
	leer precio
	precio_del_articulo=articulo*precio
	si precio<150 entonces
		I_V_A=precio_del_articulo*0.16
		escribir "su precio total es, " I_V_A+precio_del_articulo
	finsi
	Si precio>150 entonces 
		pagando=I_V_A+precio_del_articulo
		descuento=pagando*0.10
		escribir "el precio gracias a su descuento es," pagando-descuento
		
		
	FinSi
FinProceso