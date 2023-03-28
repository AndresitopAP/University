import os
from src.view.list_pokemon import get_all_pokemon
from src.add.add_pokemon import insert_pokemon
from src.edit.edit_pokemon import Edit_Pokemon
from src.stats.stats_pokemon import pokemon_stats


SYS = True

while (SYS == True):
    os.system('cls')
    print ("BIENVENIDO A SU POKEDEX")
    print ("1. Ingresar pokemon")
    print ("2. Visualizar pokemon")
    print ("3. Editar pokemon")
    print ("4. Estadistica")
    print ("5. Salir del programa")

    while True:
        try:
            option = int(input("Seleccione una opcion: "))
        except ValueError:
            print("Debes escribir un número.")
            continue
        if option < 0:
            print("Debes escribir un número positivo.")
            continue
        else:
            break
    
    if option == 1:
        insert_pokemon()
    elif option == 2:
        get_all_pokemon()
    elif option == 3:
        Edit_Pokemon()
    elif option == 4:
        pokemon_stats()
    elif option == 5:
        SYS = False
    else:
        print("Error !!!")

