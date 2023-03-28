import mysql.connector
from time import sleep

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="masterkey",
    database="pokedex",
    auth_plugin='mysql_native_password'
)

def pokemon_stats():

    mycursor = mydb.cursor()
    mycursor.execute("SELECT * FROM pokemon ORDER BY identifier ASC")
    myresult = mycursor.fetchall()
    male = 0
    female = 0
    no = 0
    higher = 0.00
    lower = 0.00
    heavier = 0.00
    lighter = 0.00
    height = []
    weigth = []

    for s in myresult:
        if s[6] == 'm':
            male += 1
        elif s[6] == 'f':
            female += 1
        elif s[6] == 'n':
            no += 1

    for e in myresult:
        pruba = e[3]
        pruba_2 = e [4]
        height.append(pruba)
        weigth.append(pruba_2)
    
    length = len(myresult)
    higher = max(height)
    heavier = max(weigth)
    lower = min(height)
    lighter = min(weigth)

    print(f'Cantidad de pokemones registrados: {length}')
    print("")
    
    print(f'Cantidad de pokemones machos: {male}')
    print(f'Cantidad de pokemones hembras: {female}')
    print(f'Cantidad de pokemones sin sexo: {no}')
    print("")

    print(f'Pokemon mas alto: {higher}')
    print(f'Pokemon menos alto: {lower}')
    print("")

    print(f'Pokemon mas pesado: {heavier}')
    print(f'Pokemon menos pesado: {lighter}')
    
    input("Presionar para continuar")
