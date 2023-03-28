def spaces():
    for index in range(3):
        print('')

#funcion para saber si es par o impar
#function to know if it is even or odd
def evorod():
    print('Par o impar')
    number = int(input('Ingrese el valor: '))
    if number & 1 == 0:
        print("El número es par")
    else:
        print("El número es impar")

#funcion para el mayor y el menor 
#function for major and minor
def mom():
    print('Mayor o menor')
    X = int(input('Ingrese el primer valor: '))
    Y = int(input('Ingrese el segundo valor: '))

    if X > Y :
        print(f'El numero mayor es: {X}')

    elif X < Y:
        print(f'El numero mayor es: {Y}')

#funcion para el producto con IVA
#function for product with IVA
def IVA():
    print('Precio mas iva')
    iva = float(16)
    price = float(input('Ingrese el precio del producto deseado: '))
    total = price * (1 + iva/100)
    print(f'El precio total del producto con el iva es = {total}')


#funcion para igualar el bitcoin al dolar
#function to equalize the bitcoin to the dollar
def bitcoin():
    print('Cantidad de dolares en bitcoin')
    bitcoin = float(input('Ingrese cantidad de bitcoins: '))
    dolar = float(input('Ingrese el valor actual del bitcoin: '))

    total = bitcoin * (dolar/1)
    print(f'Cantidad total que usted posee es = {total}')


#functions call
evorod()
spaces()
mom()
spaces()
IVA()
spaces()
bitcoin()

