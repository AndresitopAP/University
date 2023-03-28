from cgi import print_form
import os
from re import S

exchage_money = 4.60
TAX = 0.16 #Equivale al 16%
SYS = True

inventory = [
  {
    "name": 'Coca-Cola',
    "price": 4.30,
    "quantity": 150
  },
  {
    "name": 'Bolsa de limones',
    "price": 1.08,
    "quantity": 35
  },
  {
    "name": 'Agua',
    "price": 3.33,
    "quantity": 100
  },
  {
    "name": 'Doritos',
    "price": 5.02,
    "quantity": 70
  },
  {
    "name": 'Ron',
    "price": 6.80,
    "quantity": 40
  },
]
cart = []
user = {
  "name": '',
  "last_name": '',
  "cardId": '',
  "phone": '',
  "address": ''
}

def showInventory():
  for index, inv in enumerate(inventory):
    name = inv["name"]
    price = inv["price"]
    quantity = inv["quantity"]
    print(f"#{index}")
    print(f"Nombre: {name}")
    print(f"Precio: {price}")
    print(f"Disponibilidad: {quantity}")
    print("-----------------------")

def makeShopping():
  CART = True

  showInventory()

  while(CART == True):
    inx = input("Seleccione producto a llevar: ")
    qty = input("Seleccione cantidad a llevar: ")

    index = int(inx)
    invt = inventory[index]

    cart.append({
      "index": index,
      "name": invt["name"],
      "price": invt["price"],
      "quantity": qty
    })

    more = input("Presione 1 para continuar: ")
    if(int(more) != 1):
      CART = False


def getInfo(): 
  print("***** DATOS PERSONALES *****")

  name = ''
  while(name.rstrip() == ""):
    name = input("Ingrese nombre: ")

  last_name = ''
  while(last_name.rstrip() == ""):
    last_name = input("Ingrese apellido: ")

  cardId = ''
  while(cardId.rstrip() == ""):
    cardId = input("Ingrese cedula: ")

  phone = ''
  while(phone.rstrip() == ""):
    phone = input("Ingrese telefono: ")

  address = ''
  while(address.rstrip() == ""):
    address = input("Ingrese direccion: ")

  user["name"] = name
  user["last_name"] = last_name
  user["cardId"] = cardId
  user["phone"] = phone
  user["address"] = address

def showUser(): 
  name = user["name"]
  last_name = user["last_name"]
  cardId = user["cardId"]
  phone = user["phone"]
  address = user["address"]
  print(f"Nombre: {name}")
  print(f"Apellido: {last_name}")
  print(f"Cedula: {cardId}")
  print(f"Telefono: {phone}")
  print(f"Direccion: {address}")
  print("-----------------------")

def showBill():
  subtotal = 0.00
  total=0.00
  dollar = 0.00 

  for c in cart:
    subtotal += float(c["price"]) * float(c["quantity"])
    index = c["index"]
    invt = inventory[index]
    invt["quantity"] = int(invt["quantity"]) - (int(c["quantity"]))

  total = (subtotal * TAX) + subtotal
  dollar = total/exchage_money

  print(f"Subtotal: {round(subtotal,2)}")
  print(f"Total: {round(total,2)}")
  print(f"Dolares: {round(dollar,2)}")


  
while(SYS == True):
  print("1. Mostrar lista de productos")
  print("2. Realizar compra")

  option = input("Seleccionar opcion: ")

  if(int(option) == 1):
    showInventory()
  elif (int(option) == 2):
    makeShopping()
    getInfo()
    showUser()
    showBill()
  else:
    print("Error !!!")

  finsh = input('Ingrese 0 para finalizar: ')
  if int(finsh) == 0:
    SYS = False
  
  os.system("cls")

