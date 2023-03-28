import statistics

def spaces():
    for index in range(3):
        print('')

#sumatoria
#summation
print('Sumatoria')
A = input('Ingrese un valor: ')
B = input('Ingrese otro valor: ')
print('')

a = float(A)
b = float(B)

AB = a + b

print(f'La sumatoria es = {AB}')

spaces()

#media aritmetica
#arithmetic mean
print('Media aritmetica')
C = input('Ingrese un valor: ')
D = input('Ingrese otro valor: ')

c = float(C)
d = float(D)

media = (c + d) / 2
print(f'La media es = {media}')

spaces()

#Calculo de la masa corporal
#Calculation of body mass
print('Masa corporal')
height = input('Ingrese la altura: ')
weight = input('Ingrese el peso: ')

Al = float(height)
P = float(weight)

masa = P/pow(Al, 2)

print(f'La masa corporal es = {masa}')