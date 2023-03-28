import os
#os.system('cls')
#from time import sleep 
#sleep(4) 
SOS = True
SYS = True
IVA = 0.16 #equivale al 16%
Tasa = 4.50

productos = [
    {
        'name':'papas',
        'price': 1.02,
        'quantity':100
    },
    {
        'name':'refresco',
        'price': 4.00,
        'quantity':200
    },
    {
        'name':'carne',
        'price': 5.50,
        'quantity':150
    },
    {
        'name':'mayonesa',
        'price': 2.15,
        'quantity':90
    },
    {
        'name':'queso',
        'price': 3.25,
        'quantity':180
    },
    {
        'name':'huevos',
        'price': 0.80,
        'quantity':50
    }
]
carrito = []
user = {
    'name': '',
    'last_name': '',
    'card_id': '',
    'phone': '',
    'address': ''
}

def mostrar_inventario():
    for index, val in enumerate(productos):
        name = val['name']
        price = val['price']
        quantity = val['quantity']
        print(f'#{index}')
        print(f'Nombre: {name}')
        print(f'Precio: {price}')
        print(f'Cantidad: {quantity}')
        print('')

def compra():
    mostrar_inventario()

    while(SOS == True):
        inx = input("Seleccione el prodcuto: ")
        qty = input('Selecione cantidad del producto: ')
        print('')

        index = int(inx)
        producto = productos[index]

        carrito.append({
            'index': index,
            'name': producto['name'],
            'price': producto['price'],
            'quantity': qty
        })

        val = input("Presione 0 para dejar de comprar u otro para seguir: ")
        if int(val) != 1:
            break
            #SOS = False

def ID():
    print('')
    print("Ingrese datos personales")
    print('')
    
    name = ''
    while name.strip() == '':
        name = input('Ingrese nombre: ')
    
    last_name = ''
    while last_name.strip() == '':
        last_name = input('Ingrese apellido: ')

    card_id = ''
    while card_id.strip() == '':
        card_id = input('Ingrese cedula: ')

    phone = ''
    while phone.strip() == '':
        phone = input('Ingrese numero de telefono: ')

    address = ''
    while address.strip() == '':
        address = input('Ingrese direccion: ')

    user['name'] = name.strip()
    user['last_name'] = last_name.strip()
    user['card_id'] = card_id.strip()
    user['phone'] = phone.strip()
    user['address'] = address.strip()

def Info():
    name = user['name']
    last_name = user['last_name']
    card_id = user['card_id']
    phone = user['phone']
    address = user['address']

    print('')
    print(f"Nombre: {name}")
    print(f"Apellido: {last_name}")
    print(f"Cedula: {card_id}")
    print(f"Telefono: {phone}")
    print(f"Direccion: {address}")
    print('')

def bills():
    sub_total = 0.00
    total = 0.00 #ese total es la multiplicacion del total mas el iva
    precio_dolar = 0.00 #multiplicacion del total por la tasa

    for x in range ( len (carrito)):
        qty = carrito[x]['quantity']
        quantity = productos[x]['quantity']

        cnt = float(qty)
        cantidad = float(quantity)
        
        productos[x]['quanity'] = cantidad - cnt 
        price = productos[x]['price']
        sub_total += price * cnt

    
    total = (sub_total*IVA) + sub_total
    dolar = total/Tasa
    print(f"Subtotal: {(sub_total)}")
    print(f"Total: {(total)}")
    print(f"Dolares: {(dolar)}")


while (SYS == True):
    print ("1. Motrar lista de productos")
    print ("2. Realizar compra")

    option = input ("Seleccione una opcion: ")
    if int(option) == 1:
        mostrar_inventario()
    elif int(option) == 2:
        compra()
        ID()
        Info()
        bills()
        print('')
    else:
        print("Error !!!")

    print('Cualquier tecla para continuar')
    print('o')
    finish = input("0 para salir ")
    if int(finish) == 0:
        SYS = False
    os.system('cls')