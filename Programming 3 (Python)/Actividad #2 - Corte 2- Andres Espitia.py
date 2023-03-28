from time import sleep 
"""""
para este programa que tiene que ser para uso de la vida cotidiana utilizando los ciclos for, while
acumuladores, contadores y toma de decicion 
este sera un programa para sacar los promedios, util para todos los tipos de profesores

"""""
#calculation of a grade point average 

SOS = True
while (SOS == True):
    notes = int(input("Ingrese cantidad de notas a evaluar: "))
    print("")

    addition = 0
    note = 0
    for x in range (notes):
        SYS = True
        while (SYS == True):
            note = float(input("Ingrese la nota: "))
            print("")
            
            if note >= 0 and note <= 20:
                SYS = False
            else:
                print("Nota invalida")
                sleep(2) 
                print("")
                SYS = True
        
        addition = addition + note
    percentage = int(input("Ingrese el valor del corte (en porcentaje): "))
    print("")
    #print(f"{(addition)}")
    aux = percentage / 100
    prom = addition / notes
    average = prom * aux
    print(f"Su nota es: {(prom)}")
    print(f"Su nota acumulada es: {(average)}")

    print("")

    print("1. Para calcular otro promedio")
    print("Caulquier otro para terminar")
    op = int(input("Seleccione una opcion: "))
    if op == 1:
        SOS = True
    elif op != 1:
        print("Fin del comunicado...")
        SOS = False
        
