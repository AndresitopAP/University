import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="masterkey",
    database="pokedex",
    auth_plugin='mysql_native_password'
)


def get_all_pokemon(): 
    mycursor = mydb.cursor()
    mycursor.execute("SELECT * FROM pokemon ORDER BY identifier ASC")
    myresult = mycursor.fetchall()

    male = ""
    female = ""
    no = ""

    list = []
    sex_pokemon = []

    #meter toda la informacion
    for x in myresult:
        pokedex_d = {
            'numero' : x[1],
            'nombre': x[2],
            'tipo' : x[5],
            'sexo' : x[6]
        }
        list.append(pokedex_d)
    #print(list)
    for s in myresult:
        if s[6] == "m":
            male = s[6]
        elif s[6] == "f":
            female = s[6]
        elif s[6] == "n":
            no = s[6]
        sex_pokemon.append(male)
        sex_pokemon.append(female)
        sex_pokemon.append(no)
            

    for index, inv in enumerate(list):
        number = inv["numero"]
        name = inv["nombre"]
        type = inv["tipo"]
        print(f"#{index}")
        print(f"Pokedex: {number}")
        print(f"Nombre: {name}")
        print(f"Tipo: {type}")
        #print(sex_pokemon)
        print("_________________")

    input("Presionar para continuar")
