import mysql.connector
from src.view.list_pokemon import get_all_pokemon

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="masterkey",
    database="pokedex",
    auth_plugin='mysql_native_password'
)

def update_pokemon_db(id, name, height, weigth, type, sex):
    mycursor = mydb.cursor()
    sql = "UPDATE pokemon SET name=%s, height=%s, weigth=%s, type=%s, sex=%s WHERE identifier=%s"
    val = (name, height, weigth, type, sex, id)
    mycursor.execute(sql, val)
    mydb.commit()
    return mycursor.rowcount 

def Edit_Pokemon():
    id = 0
    name = '' 
    height = 0.0
    weigth = 0.0
    type = ''
    sex = ''

    print(get_all_pokemon())

    num = int(input("Seleccione un pokemon a editar: "))
    
    while True:
        try:
            id = int(input('Ingrese numero de pokedex: '))
        except ValueError:
            print("Debes escribir un número.")
            continue
        if id < 0:
            print("Debes escribir un número positivo.")
            continue
        else:
            break

    while name.strip() == '':
        name = input('Ingrese nombre: ')

    while True:
        try:
            height = float(input('Ingrese la altura: '))
        except ValueError:
            print("Debes escribir un número.")
            continue
        if height < 0:
            print("Debes escribir un número positivo.")
            continue
        else:
            break

    while True:
        try:
            weigth = float(input('Ingrese el peso: '))
        except ValueError:
            print("Debes escribir un número.")
            continue
        if weigth < 0:
            print("Debes escribir un número positivo.")
            continue
        else:
            break

    while type.strip() == '':
        type = input('Ingrese el tipo: ')

    while sex.strip() == '':
        sex = input('Ingrese el sexo (f-m), en caso de no tener colocar (n): ')
    
    valid = update_pokemon_db(id, name, height, weigth, type, sex)

    if valid > 0:
        print("Pokemon actualizado correctamente")
    else:
        print("Ha ocurrido un error")
