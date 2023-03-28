#por seleccino
def selectShort( array ):
    length = len(array) - 1

    for a in range(0, length):
        min_index = a 
        min_value = array[min_index]

        for e in range(a, length):
            if min_value > array[e + 1]:
                min_value = array[e + 1]
                min_index = e + 1

        if min_index != 0:
            aux = array[a]
            array[a] = array[min_index]
            array[min_index] = aux

            
    return array



scores = [29, 19, 0, 4, 22, 16]  
print('Antes de ordenar: ')
print(scores)
print('Despues de ordenar: ')
print( selectShort(scores) )



