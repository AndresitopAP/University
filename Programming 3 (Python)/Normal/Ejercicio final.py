#consumo de gasolina  por kilometros
#gasoline consumption per km

#ingreso por teclado
Km = float(input('Ingrese los kilometros recorridos: '))
gasoline = float(input('Ingrese los litros gastados: '))

consumption = gasoline/Km

print(f'Los litros consumidos por kilometros recorridos son = {consumption}')