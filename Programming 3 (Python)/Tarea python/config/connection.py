import mysql.connector

def conn():
    mydb = mysql.connector.connect(
        host="localhost",
        user="root",
        password="masterkey",
        database="pokedex"
    )

    return mydb.cursor()
