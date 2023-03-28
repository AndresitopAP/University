import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="masterkey",
    database="pokedex",
    auth_plugin='mysql_native_password'
)

def insert_pokemon_db(id, name, height, weigth, type, sex):
    mycursor = mydb.cursor()
    sql = "INSERT INTO pokemon (identifier, name, height, weigth, type, sex) VALUES (%s, %s, %s, %s, %s, %s )"
    val = (id, name, height, weigth, type, sex)
    mycursor.execute(sql, val)
    mydb.commit()

    return mycursor.rowcount 

def insert_pokemon():
    id = 0
    name = '' 
    height = 0.0
    weigth = 0.0
    type = ''
    sex = ''

    """
        PEDIR VALOR y VALIDAR
    """    
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

    name = ''
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

    type = ''
    while type.strip() == '':
        type = input('Ingrese el tipo: ')

    sex = ''
    while sex.strip() == '':
        sex = input('Ingrese el sexo, en caso de no tener colocar (n): ')
        

    """
        DESPUES DE TENER LOS VALORES DEFINITIVOS METER EN BASE DE DATOS
        PASAR VALORES A LA FUNCION
    """
    ins = insert_pokemon_db(id, name, height, weigth, type, sex)

    """
        Si ins es mayor a 0 inserto de lo contrario indicar error y si quiere volver a intentar
    """
    
    if ins > 0:
        print('Guardado correctamente')
    else:
        print('Error al guardar, vualva a intetarlo')
   

