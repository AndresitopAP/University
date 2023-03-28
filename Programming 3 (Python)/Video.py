from os import link
from pytube import YouTube 
link = input('Ingrese el enlace a descargar: ')
#link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
yt = YouTube(link)
yt.streams.first().download()