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

const btnPlay = document.querySelector("#btn-play");
const btnPlayIcon = document.querySelector("#btn-play-icon");
const btnRepeat = document.querySelector("#btn-repeat");
const btnPrev = document.querySelector("#btn-prev");
const btnNext = document.querySelector("#btn-next");
const btnVolume = document.querySelector("#btn-volume");
const btnVolumeIcon = document.querySelector("#btn-volume i");
const playerVolume = document.querySelector("#player-volume");
const songName = document.querySelector("#song-name");
const songAuthor = document.querySelector("#song-author");
const songdate = document.querySelector("#song-date");
const playerCurrentTime = document.querySelector("#player-current-time");
const playerDuration = document.querySelector("#player-duration");
const playerProgress = document.querySelector("#player-progress");
const audioPlayer = document.querySelector("#audio-player");
const Cover = document.querySelector("#cover");

let currentSong = 0;
let repeatSong = false;


const songs = [
  {
    "name": "I love it",
    "artist": "Kanye West ft. Lil Pump",
    "year": "2018",
    "path": "http://127.0.0.1:5500/media/Kanye_West,_Lil_Pump-I_Love_It.mp3",
    "image": "../media/img/i_love_it.jpg",
  },
  {
    "name": "In the end",
    "artist": "Linkin Park",
    "year": "2000",
    "path": "http://127.0.0.1:5500/media/Linkin_Park_In_The_End_(Official_Video).mp3",
    "image": "../media/img/In_the_end.jpg",
  },
  {
    "name": "Welleman",
    "artist": "Nathan Evans",
    "year": "2021",
    "path": "http://127.0.0.1:5500/media/Nathan_Evans_Wellerman_220_KID_&_Billen_Ted_TikTok_Remix_Lyrics.mp3",
    "image": "../media/img/Willerman.jpg",
  },
  {
    "name": "Un millon de primaveras",
    "artist": "Vicente Fernandez",
    "year": "1991",
    "path": "http://127.0.0.1:5500/media/VicenteFernandezUnmillondeprimaveras.mp3",
    "image": "../media/img/Un_millon_de_primaveras.jpg",
  },
  {
    "name": "Abusadora",
    "artist": "Wisin y Yandel",
    "year": "2007",
    "path": "http://127.0.0.1:5500/media/Abusadora_Wisin_y_Yandel.m4a",
    "image": "../media/img/abusadora.jpg",
  }
]

btnPlay.addEventListener("click", () => togglePlaySong());
btnPrev.addEventListener("click", () => changeSong(false));
btnNext.addEventListener("click", () => changeSong());
btnRepeat.addEventListener("click", () => toggleRepeatSong());
playerVolume.addEventListener("input", () => changeVolume());
playerProgress.addEventListener("input", () => changeTime());
audioPlayer.addEventListener("timeupdate", () => timeUpdate());
audioPlayer.addEventListener("ended", () => ended());

const togglePlaySong = () => {
  if (audioPlayer.paused) {
    audioPlayer.play();
    btnPlayIcon.classList.replace("bi-play-fill", "bi-pause-fill");
  } else {
    audioPlayer.pause();
    btnPlayIcon.classList.replace("bi-pause-fill", "bi-play-fill");
  }
};

const changeSong = (next = true) => {
  if (next && currentSong < songs.length - 1) {
    currentSong++;
  } else if (!next && currentSong > 0) {
    currentSong--;
  } else {
    return;
  }

  updatePlayer();
  togglePlaySong();
};

const updatePlayer = () => {
  const song = songs[currentSong];
  //console.log(song);

  songName.innerHTML = song.name;
  songAuthor.innerHTML = song.artist;
  songdate.innerHTML = song.year;
  audioPlayer.src = song.path;
  Cover.src = song.image;
  playerProgress.value = audioPlayer.currentTime;
}

const toggleRepeatSong = () => {
  repeatSong = !repeatSong;
  btnRepeat.classList.toggle("btn-activated");
}

const timeUpdate = () => {
  const { currentTime, duration } = audioPlayer;

  if (isNaN(duration)) return;

  playerDuration.innerHTML = formatSecondsToMinutes(duration);
  playerCurrentTime.innerHTML = formatSecondsToMinutes(currentTime);
}

const changeVolume = () => {
  const { value } = playerVolume;

  audioPlayer.volume = value;

  if (value == 0) {
    btnVolumeIcon.classList.replace("bi-volume-up-fill", "bi-volume-mute-fill");
  } else {
    btnVolumeIcon.classList.replace("bi-volume-mute-fill", "bi-volume-up-fill");
  }
};

const changeTime = () => {
  const { value } = playerProgress;

  audioPlayer.currentTime = value;
};

const formatSecondsToMinutes = (seconds) => {
  return new Date(seconds * 1000).toISOString().slice(14, 19);
};

const ended = () => {
  repeatSong ? togglePlaySong() : changeSong(true);
};

window.onload = () => {
  updatePlayer();
};

