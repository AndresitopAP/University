#funcion para espacios
def spaces():
    for index in range(3):
        print('')

#numero mayor
#bigger number

#ingreso de valores por teclado
print('Imprmir el numero mayor')
A = input('Ingrese un valor: ')
B = input('Ingrese otro valor: ')

#ajuste de tipo de variable
X = int(A)
Y = int(B)

#desicion para el mayor numero
if X > Y :
    print(f'El numero mayor es: {X}')

elif X < Y:
    print(f'El numero mayor es: {Y}')

spaces()

#par o impar
#even or odd

#ingreso del valor
print('Muestra del numero par o impar')
even = input('Ingrese un numero: ')

#ajuste de variable
odd = int(even)

#desicion del par o impar
if odd & 1 == 0:
    print("El número es par")
else:
    print("El número es impar")

spaces()

#numero mayor entre 3
#find the greatest number among the 3

#ingreso de numeros
print('Saber el mayor entre 3 numeros')
one = int(input('Ingrese el primer numero: '))
two = int(input('Ingrese el segundo numero: '))
tree = int(input('Ingrese el tercer numero: '))

#desicion para saber el mayor enter 3 
if one > two and one > tree:
    print(f'El mayor es: {one}')
elif two > one and two > tree:
    print(f'El mayor es: {two}')
elif tree > one and tree > two:
    print(f'El mayor es: {tree}')
else:
    print('No se pudo establecer el mayor')

spaces()

#numero entre 10 y 15
#check if the number is between 10 and 15

#ingreso del valor
print('Mostrar si el numero esta entre el 10 y el 15')
num = int(input('Ingrese el valor: '))

#desicion para saber el numero entre los valores
if num >= 10 and num <= 15:
    print('El numero se encuentra entre los valores ')
else:
    print('El numero no se encuentra entre los valores ')