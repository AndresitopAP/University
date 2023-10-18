/*Realizar una app web que permita reproducir audio o video. (5 canciones)

Controles
1. La cancion o video al teminar debe pasar a la siguiente automaticamente.
2. Debe tener los botones de atras y adelante.
3. Debe tener el boton de repetir la cancion al terminar.

Cada cancion debe tener la siguiente informacion
1. Cantante
2. Fecha de estreno
3. Se prodra Agregar comentario por pantalla (por audio o video)
	* Nombre
	* Comentario

Debe tener un diseño unico aplicando CSS */

const songs = [
  {
    "name": "I love you",
    "artist": "Kanye West ft. Lil Pump",
    "year": "2018",
    "path": "https://127.0.0.1:300/media/Kanye_West,_Lil_Pump-I_Love_It.mp3",
    "image": "../media/img/i_love_it.jpg",
  },
  {
    "name": "In the end",
    "artist": "Linkin Park",
    "year": "2000",
    "path": "https://127.0.0.1:300/media/Linkin_Park_In_The_End_(Official_Video).mp3",
    "image": "../media/img/In_the_end.jpg",
  },
  {
    "name": "Welleman",
    "artist": "Nathan Evans",
    "year": "2021",
    "path": "https://127.0.0.1:300/media/Nathan_Evans_Wellerman_220_KID_&_Billen_Ted_TikTok_Remix_Lyrics.mp3",
    "image": "../media/img/Willerman.jpg",
  },
  {
    "name": "Un millon de primaveras",
    "artist": "Vicente Fernandez",
    "year": "1991",
    "path": "https://127.0.0.1:300/media/VicenteFernandezUnmillondeprimaveras.mp3",
    "image": "../media/img/Un_millon_de_primaveras.jpg",
  },
  {
    "name": "Abusadora",
    "artist": "Wisin y Yandel",
    "year": "2007",
    "path": "https://127.0.0.1:300/media/Abusadora_Wisin_y_Yandel.mp3",
    "image": "../media/img/abusadora.jpg",
  }
]


