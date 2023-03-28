from lib2to3.pygram import Symbols
from random import sample
import random
import string
LETTERS = string.ascii_letters
NUMS = '0123456789'
SPE = '+*%&$!_'
SYMBOLS = LETTERS + NUMS + SPE
len = int(input("ENTER PASS. LENGTH:"))
password = ''.join(random.sample(
    SYMBOLS,len))

print(password)
