const pokemonBox = document.getElementById("pokemon-box");

const preloader = document.getElementById("pre-loader");

const footer = document.querySelector("footer");

const colors = {
  fire: "#FDDFDF",
  grass: "#DEFDE0",
  electric: "#FCF7DE",
  water: "#DEF3FD",
  ground: "#F4E7DA",
  rock: "#D5D5D4",
  fairy: "#FCEAFF",
  poison: "#98D7A5",
  bug: "#F8D5A3",
  dragon: "#97B3E6",
  psychic: "#EAEDA1",
  flying: "#51D1F6",
  fighting: "#E6E0D4",
  normal: "#727272",
};

const colorsArray = Object.keys(colors);

let start = 1;
let end = 6;

let countChange = 0;
let countChangeArray = [];
let loadCount = 0;
let internalLoadCount = 0;
let countArray = [];

const getPokemon = async (IDPokemon) => {
  try {
    const url = `https://pokeapi.co/api/v2/pokemon/${IDPokemon}`;
    const res = await axios(url);
    pokemonCard(res.data);
  } catch (error) {
    console.log(error);
    location.reload();
  }
};

const pokemonCard = (pokemon) => {
  const pokemonCard = document.createElement("div");
  pokemonCard.classList.add("pokemon-card");

  const IDPokemon = pokemon.id;
  const pokemonName = pokemon.name[0].toUpperCase() + pokemon.name.slice(1);
  const pokemonType = pokemon.types.map((type) => type.type.name);
  const pokemonImg = `https://cdn.traction.one/pokedex/pokemon/${pokemon.id}.png`;

  const accessChange = false;

  card(
    accessChange,
    pokemonCard,
    IDPokemon,
    pokemonName,
    pokemonType,
    pokemonImg
  );
};

const fetchPokemon = async (start, end) => {
  for (let i = start; i <= end; i++) {
    await getPokemon(i);
  }
};

window.onload = async () => {
  const loadButton = document.getElementById("load");

  await fetchPokemon(start, end);

  preloader.style.opacity = "0";
  pokemonBox.style.opacity = "1";
  loadButton.style.opacity = "1";
  footer.style.opacity = "1";
};

const loadNum1 = async () => {
  start = start + 6;
  end = end + 6;
  console.log(start);
  console.log(end);

  preloader.style.opacity = "1";

  await fetchPokemon(start, end);

  preloader.style.opacity = "0";
};

const loadNum2 = async (JSONFile) => {
  let countChangeArrayLength = countChangeArray.length;

  if (JSONFile.countChange >= 1) {
    countArray.push(countChangeArrayLength);

    loadCount++;

    let penultimateArrayIndex = countArray.length - 2;
    let lastedArrayIndex = countChangeArrayLength - 1;

    if (loadCount == 1) {
      if (loadCount == 1) {
        count1 = JSONFile.IDPokemon + 1;
        count2 = count1 + 4;

        preloader.style.opacity = "1";
        await fetchPokemon(count1, count2);
        preloader.style.opacity = "0";
      }
    } else {
      if (
        countChangeArray[lastedArrayIndex] == countArray[penultimateArrayIndex]
      ) {
        internalLoadCount++;
        if (internalLoadCount == 1) {
          count1 = count2 + 1;
          count2 = count1 + 4;

          preloader.style.opacity = "1";
          await fetchPokemon(count1, count2);
          preloader.style.opacity = "0";
        } else {
          count1 = count2 + 1;
          count2 = count1 + 4;

          preloader.style.opacity = "1";
          await fetchPokemon(count1, count2);
          preloader.style.opacity = "0";
        }
      } else {
        internalLoadCount = 0;

        count1 = 0;
        count2 = 0;

        loadCount = 0;

        return loadNum2(JSONFile);
      }
    }
  }
};

const searchPokemon = async () => {
  const takeID = document.getElementById("take-id").value;

  const loadButton = document.getElementById("load");

  if (takeID != "") {
    pokemonBox.style.transition = "none";
    pokemonBox.style.opacity = "0";
    loadButton.style.opacity = "0";
    footer.style.transition = "none";
    footer.style.opacity = "0";
    preloader.style.opacity = "1";

    while (pokemonBox.firstChild) {
      pokemonBox.removeChild(pokemonBox.firstChild);
    }

    const pokemonCard = document.createElement("div");
    pokemonCard.classList.add("pokemon-card");

    const url = `https://pokeapi.co/api/v2/pokemon/${takeID}`;
    const res = await axios(url);
    const pokemon = res.data;

    const IDPokemon = pokemon.id;
    const pokemonName = pokemon.name[0].toUpperCase() + pokemon.name.slice(1);
    const pokemonType = pokemon.types.map((type) => type.type.name);
    const pokemonImg = `https://cdn.traction.one/pokedex/pokemon/${takeID}.png`;

    const accessChange = true;

    card(
      accessChange,
      pokemonCard,
      IDPokemon,
      pokemonName,
      pokemonType,
      pokemonImg
    );

    preloader.style.opacity = "0";
    pokemonBox.style.transition = "all 0.3s ease-in-out";
    pokemonBox.style.opacity = "1";
    loadButton.style.opacity = "1";
    footer.style.transition = "all 0.3s ease-in-out";
    footer.style.opacity = "1";
  }
};

const card = (
  accessChange,
  pokemonCard,
  IDPokemon,
  pokemonName,
  pokemonType,
  pokemonImg
) => {
  let typeArray1 = [];
  let typeArray2 = [];

  let typeLength = pokemonType.length;

  typeLength == 1 ? (typeArray1 = pokemonType) : (typeArray2 = pokemonType);

  let firstType = [];
  let secondType = [];

  firstType.push(typeArray2[0]);
  secondType.push(typeArray2[1]);

  const findNum1 = colorsArray.find((type) => typeArray1.indexOf(type) > -1);
  const findNum2 = colorsArray.find((type) => firstType.indexOf(type) > -1);
  const findNum3 = colorsArray.find((type) => secondType.indexOf(type) > -1);

  const colorNum1 = colors[findNum1];
  const colorNum2 = colors[findNum2];
  const colorNum3 = colors[findNum3];

  let colorBox1 = `<div style = 'background-color: ${colorNum1}; width: 70px; border-radius: 2px;'> <small>${pokemonType}</small> </div>`;
  let colorBox2 = `<div style = 'background-color: ${colorNum2}; width: 70px; border-radius: 2px; margin-right: 5px;'> <small>${pokemonType[0]}</small> </div> <div style = 'background-color: ${colorNum3}; width: 70px; border-radius: 2px; margin-left: 5px;'> <small>${pokemonType[1]}</small> </div>`;

  let thisColor = `<div style = 'display: flex; justify-content:center;'>${
    typeLength == 1 ? colorBox1 : colorBox2
  }</div>`;

  const innerHTML = `
        <div class = 'pokemon-img-box'>
            <img src = '${pokemonImg}'>
        </div>

        <div class = 'pokemon-data'>
            <span class = 'pokemon-id'> #${IDPokemon.toString().padStart(
              "3",
              0
            )} </span>
            <h3 class = 'pokemon-name'> ${pokemonName} </h3>
            ${thisColor}
        </div>
    `;

  if (accessChange == false) {
    pokemonCard.innerHTML = innerHTML;

    pokemonCard.onclick = function () {
      const url = `./view.html?id=${IDPokemon}`;
      location.href = url;
    };

    pokemonBox.appendChild(pokemonCard);
  } else {
    const searchInput = document.querySelector(".search-txt");
    const searchButton = document.querySelector(".search-btn");
    const buttonBox = document.getElementById("button-box");
    const loadButton = document.getElementById("load");

    pokemonCard.innerHTML = innerHTML;

    pokemonCard.onclick = function () {
      const url = `./view.html?id=${IDPokemon}`;
      location.href = url;
    };

    pokemonBox.appendChild(pokemonCard);

    pokemonBox.style.width = "auto";
    pokemonBox.style.padding = "0";
    pokemonCard.style.margin = "10px";

    searchInput.style.width = "215px";
    searchInput.style.margin = "5px";
    searchButton.style.backgroundColor = "orangered";

    buttonBox.removeChild(loadButton);

    countChange++;
    countChangeArray.push(countChange);

    let OBJ = {
      IDPokemon: IDPokemon,
      countChange: countChange,
      countChangeArray: countChangeArray,
    };

    let JSONFile = JSON.stringify(OBJ);

    const newButton = `<button id = 'load' style = 'opacity: 1' type = 'button' onclick = 'loadNum2(${JSONFile})'>More Pokémons</button>`;

    buttonBox.innerHTML = newButton;
  }
};