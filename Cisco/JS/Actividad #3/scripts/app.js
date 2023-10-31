const takeID = window.location.search.slice(4);

const pokemonNameBox = document.getElementById("pokemon-name-box");

const pokemonMainBox1 = document.getElementById("pokemon-main-box-1");
const pokemonMainBox2 = document.getElementById("pokemon-main-box-2");
const pokemonMainBox3 = document.getElementById("pokemon-main-box-3");

const buttonBox = document.getElementById("button-main-box");

const footer = document.querySelector("footer");

const preloader = document.getElementById("pre-loader");

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
  ice: "#3B83BD",
  dark: "#696969",
  ghost: "#F8F8FF",
  steel: "#43464B",
};

const colorsArray = Object.keys(colors);

const getPokemon = async (IDPokemon) => {
  const url = `https://pokeapi.co/api/v2/pokemon/${IDPokemon}`;
  const res = await axios(url);
  await request(res.data);
};

const request = async (pokemon) => {
  // PETITION NUM°1 - POKÉMON SPECIES
  const requestURL1 = `https://pokeapi.co/api/v2/pokemon-species/${pokemon.id}`;
  const requestRes1 = await axios(requestURL1);

  // PETITION NUM°2 - POKEMON EVOLUTION
  const requestURL2 = requestRes1.data.evolution_chain.url;
  const requestRes2 = await axios(requestURL2);

  const packNum1 = pokemon;
  const packNum2 = requestRes1.data;
  const packNum3 = requestRes2.data;

  dataManagement(packNum1, packNum2, packNum3);
};

const dataManagement = (packNum1, packNum2, packNum3) => {
  // POKEMON DATA
  const IDPokemon = packNum1.id;
  const pokemonName = packNum1.name[0].toUpperCase() + packNum1.name.slice(1);
  const pokemonType = packNum1.types.map((type) => type.type.name);
  const pokemonImg = `https://cdn.traction.one/pokedex/pokemon/${packNum1.id}.png`;

  // OTHER DATA
  const pokemonGroup = packNum2.egg_groups.map((group) => group.name);
  const pokemonGender = packNum2.gender_rate;
  const pokemonAbility = packNum1.abilities.map(
    (ability) => ability.ability.name
  );

  // POKEMON HABITAT
  const pokemonHabitat = packNum2.habitat;

  const habitatAnalysis =
    pokemonHabitat != null ? pokemonHabitat.name : "has no habitat";

  // POKEMON - TYPES SELECTION
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

  let colorBox1 = `<div style = 'background-color: ${colorNum1}; width: 100px; height: 40px; border-radius: 2px; display: flex; justify-content: center; align-items: center'> <span>${pokemonType}</span> </div>`;
  let colorBox2 = `<div style = 'background-color: ${colorNum2}; width: 100px; height: 40px; border-radius: 2px; margin-right: 5px; display: flex; justify-content: center; align-items: center'> <span>${pokemonType[0]}</span> </div> <div style = 'background-color: ${colorNum3}; width: 100px; height: 40px; border-radius: 2px; margin-left: 5px; display: flex; justify-content: center; align-items: center'> <span>${pokemonType[1]}</span> </div>`;

  const thisColor = `<div style = 'display: flex; justify-content:center;'>${
    typeLength == 1 ? colorBox1 : colorBox2
  }</div>`;

  // POKEMON - GROUP SELECTION
  const groupLength = pokemonGroup.length;

  const groupBox1 = `<span> ${pokemonGroup} </span>`;
  const groupBox2 = `<span> ${pokemonGroup[0]} </span> , <span> ${pokemonGroup[1]} </span>`;
  const groupBox3 = `<span> Has no group </span>`;

  const hasGroup = `<div> ${groupLength == 1 ? groupBox1 : groupBox2} </div>`;

  const groupAnalysis = pokemonGroup[0];

  const groupResult = groupAnalysis == "no-eggs" ? groupBox3 : hasGroup;

  // POKEMON - GENDER SELECTION
  const hasGender = `<div class = 'male-gender'> <i class="fas fa-mars"></i> </div>  <div class = 'female-gender'> <i class="fas fa-venus"></i> </div>`;
  const noGender = `<div> <i class="fas fa-genderless"></i> </div>`;

  const genderAnalysis = pokemonGender == -1 ? noGender : hasGender;

  // POKEMON - ABILITY SELECTION
  const abilityLength = pokemonAbility.length;

  const abilityBox1 = `<span> ${pokemonAbility} </span>`;
  const abilityBox2 = `<span> ${pokemonAbility[0]} </span> <span style = 'margin-top: 5px'> ${pokemonAbility[1]} </span>`;

  const abilityAnalysis = abilityLength == 1 ? abilityBox1 : abilityBox2;

  // CREATE JSON FILE
  const JSONFile = {
    packNum1: packNum1,
    packNum2: packNum2,
    packNum3: packNum3,
    pokemon: [IDPokemon, pokemonName, pokemonImg, habitatAnalysis],
    cardStructure: [thisColor, groupResult, genderAnalysis, abilityAnalysis],
  };

  pokemonCard(JSONFile);
};

const pokemonCard = (JSONFile) => {
  const pokemon = JSONFile.pokemon;
  pokemonName(pokemon);

  // console.log(JSONFile);

  const pokemonBox = document.createElement("div");
  pokemonBox.classList.add("pokemon-box");

  // POKEMON DATA
  const pokemonImg = JSONFile.pokemon[2];
  const pokemonType = JSONFile.cardStructure[0];

  // OTHER POKEMON DATA

  // POKEMON HEIGHT
  const pokemonHeight = JSONFile.packNum1.height;
  const height = pokemonHeight < 10 ? "0," + pokemonHeight : pokemonHeight;

  // POKEMON WEIGHT
  const pokemonWeight = JSONFile.packNum1.weight;

  // POKEMON GENDER
  const pokemonGender = JSONFile.cardStructure[2];

  // POKEMON GROUP
  const pokemonGroup = JSONFile.cardStructure[1];

  // POKEMON HABITAT
  const pokemonHabitat = JSONFile.pokemon[3];

  // POKEMON ABILITIES
  const pokemonAbility = JSONFile.cardStructure[3];

  const innerHTML = `
        <div class = 'pokemon-card'>
            <img src = '${pokemonImg}'>
        </div>

        <div class = 'pokemon-qualities-cart'>
            <div> ${pokemonType} </div>

            <div class = 'pokemon-data-cart'>
                <div class = 'data-box-1'>
                    <span class = 'title-1'> Height </span>

                    <span class = 'data'> ${height}m </span>

                    <span class = 'title-2'> Weight </span>

                    <span class = 'data'> ${pokemonWeight}kg </span>

                    <span class = 'title-3'> Gender </span>

                    <div class = 'gender-box'> ${pokemonGender} </div>
                </div>

                <div class = 'data-box-2'>
                    <span class = 'box-2-title-1'> Group </span>

                    <span class = 'data'> ${pokemonGroup} </span>

                    <span class = 'box-2-title-2'> Habitat </span>

                    <span class = 'data'> ${pokemonHabitat} </span>
                </div>

                <div class = 'data-box-3'>
                    <span class = 'box-3-title-1'> Abilities </span>

                    <span class = 'data'> ${pokemonAbility} </span>
                </div>
            </div>
        </div>
    `;

  pokemonBox.innerHTML = innerHTML;

  pokemonMainBox1.appendChild(pokemonBox);

  // FUNCTION
  qualitiesRequest(JSONFile);

  // EVOLUTION FUNCTION;
  const pass = JSONFile.packNum3.chain.evolves_to.length;

  if (pass == 1) {
    const pass = JSONFile.packNum3.chain.evolves_to[0].evolves_to.length;

    if (pass == 1) {
      const passNum = 3;
      pokemonEvolution(passNum, JSONFile.packNum3);
    } else {
      const passNum = 2;
      pokemonEvolution(passNum, JSONFile.packNum3);
    }
  }

  // BUTTON
  button();
};

const pokemonName = (pokemon) => {
  const pokemonChangeBox = document.createElement("div");
  pokemonChangeBox.classList.add("pokemon-change-box");

  const nameBox = document.createElement("div");
  nameBox.classList.add("name-box");

  const innerChange = `
        <div class = 'icon-num1'> <i class="fas fa-chevron-left" onclick = 'back(${
          pokemon[0]
        })'></i> </div>

        <div class = 'id-box'>
            <span> N.°${pokemon[0].toString().padStart(3, "0")} </span>
        </div>

        <div class = 'icon-num2'> <i class="fas fa-chevron-right" onclick = 'next(${
          pokemon[0]
        })'></i> </div>
    `;

  const innerName = `<span> ${pokemon[1]} </span>`;

  pokemonChangeBox.innerHTML = innerChange;
  nameBox.innerHTML = innerName;

  pokemonNameBox.appendChild(pokemonChangeBox);
  pokemonNameBox.appendChild(nameBox);
};

const qualitiesRequest = async (JSONFile) => {
  // URL TYPES ARRAY
  const arrayNum1 = [];
  const arrayNum2 = [];

  // URL TYPES
  const url = JSONFile.packNum1.types.map((type) => type.type.url);

  for (let i = 0; i < url.length; i++) {
    const res = await axios(url[i]);

    // GET QUALITIES
    const dataNum1 = res.data.damage_relations.double_damage_to.map(
      (element) => element.name
    );

    const dataNum2 = res.data.damage_relations.double_damage_from.map(
      (element) => element.name
    );

    // DATANUM1
    for (let i = 0; i < dataNum1.length; i++) {
      arrayNum1.push(dataNum1[i]);
    }

    // DATANUM3
    for (let i = 0; i < dataNum2.length; i++) {
      arrayNum2.push(dataNum2[i]);
    }
  }

  const File = {
    dataNum1: arrayNum1,
    dataNum2: arrayNum2,
  };

  pokemonQualities(File);
};

const pokemonQualities = (File) => {
  const qualitiesBox = document.createElement("div");
  qualitiesBox.classList.add("qualities-box");

  const innerHTML = `
        <div class = 'box-1'>
            <div class = 'qualities-title'> <span> Advantages against types: </span> </div>

            <div id = 'type-box-1' class = 'qualities-tag'>  </div>
        </div>

        <div class = 'box-2'>
            <div class = 'qualities-title'> <span> Weak against types: </span> </div>

            <div id = 'type-box-2' class = 'qualities-tag'> </div>
        </div>
    `;

  qualitiesBox.innerHTML = innerHTML;

  pokemonMainBox2.appendChild(qualitiesBox);

  for (let i = 0; i < File.dataNum1.length; i++) {
    let find = colorsArray.find((type) => File.dataNum1[i].indexOf(type) > -1);
    let color = colors[find];
    let colorBox = `<div style = 'background-color: ${color}; width: 100px; height: 40px; margin: 5px; border-radius: 2px; display: flex; justify-content: center; align-items: center'> <span>${File.dataNum1[i]}</span> </div>`;

    document.getElementById("type-box-1").innerHTML += colorBox;
  }

  for (let i = 0; i < File.dataNum2.length; i++) {
    let find = colorsArray.find((type) => File.dataNum2[i].indexOf(type) > -1);
    let color = colors[find];
    let colorBox = `<div style = 'background-color: ${color}; width: 100px; height: 40px; margin: 5px; border-radius: 2px; display: flex; justify-content: center; align-items: center'> <span>${File.dataNum2[i]}</span> </div>`;

    document.getElementById("type-box-2").innerHTML += colorBox;
  }
};

const pokemonEvolution = async (pass, pack) => {
  const evolBox = document.createElement("div");
  evolBox.classList.add("pokemon-evolution-box");

  if (pass == 3) {
    // console.log("Tres evoluciones");

    const pokemonNum1 = pack.chain.species.name;
    const pokemonNum2 = pack.chain.evolves_to[0].species.name;
    const pokemonNum3 = pack.chain.evolves_to[0].evolves_to[0].species.name;

    const array = [pokemonNum1, pokemonNum2, pokemonNum3];

    const IDArray = [];
    const imgArray = [];

    for (let i = 0; i < array.length; i++) {
      const url = `https://pokeapi.co/api/v2/pokemon/${array[i]}`;
      const res = await axios(url);
      const pokemon = res.data;

      IDArray.push(pokemon.id);
    }

    for (let i = 0; i < IDArray.length; i++) {
      const pokemonImg = `https://cdn.traction.one/pokedex/pokemon/${IDArray[i]}.png`;

      imgArray.push(pokemonImg);
    }

    const innerHTML = `
            <div class = 'evolution-title'> <span> Evolutions </span> </div>

            <div class = 'evolution-box'>
                <div id = 'evolution-data-box-1' class = 'evolution-data-box' onclick = 'newPokemon(${
                  IDArray[0]
                })'>
                    <div class = 'img-card'>
                        <img src = '${imgArray[0]}'>
                    </div>

                    <div class = 'data-box'>
                        <span class = 'pokemon-name'> ${array[0]} </span>

                        <span class = 'pokemon-id'> N°${IDArray[0]
                          .toString()
                          .padStart(3, "0")} </span>
                    </div>

                    ${await pokemonType(array[0])}
                </div>

                <div class = 'icon-box'> 
                    <i id = 'icon-1' class="fas fa-chevron-right"></i> 

                    <i id = 'icon-2' class="fas fa-chevron-down"></i>
                </div>

                <div id = 'evolution-data-box-2' class = 'evolution-data-box' onclick = 'newPokemon(${
                  IDArray[1]
                })'>
                    <div class = 'img-card'>
                        <img src = '${imgArray[1]}'>
                    </div>

                    <div class = 'data-box'>
                        <span class = 'pokemon-name'> ${array[1]} </span>

                        <span class = 'pokemon-id'> N°${IDArray[1]
                          .toString()
                          .padStart(3, "0")} </span>
                    </div>

                    ${await pokemonType(array[1])}
                </div> 

                <div class = 'icon-box'> 
                    <i id = 'icon-1' class="fas fa-chevron-right"></i> 

                    <i id = 'icon-2' class="fas fa-chevron-down"></i>
                </div>

                <div id = 'evolution-data-box-3' class = 'evolution-data-box' onclick = 'newPokemon(${
                  IDArray[2]
                })'>
                    <div class = 'img-card'>
                        <img src = '${imgArray[2]}'>
                    </div>

                    <div class = 'data-box'>
                        <span class = 'pokemon-name'> ${array[2]} </span>

                        <span class = 'pokemon-id'> N°${IDArray[2]
                          .toString()
                          .padStart(3, "0")} </span>
                    </div>

                    ${await pokemonType(array[2])}
                </div> 
            </div>
        `;

    evolBox.innerHTML = innerHTML;

    pokemonMainBox3.appendChild(evolBox);
  } else {
    const pokemonNum1 = pack.chain.species.name;
    const pokemonNum2 = pack.chain.evolves_to[0].species.name;

    const array = [pokemonNum1, pokemonNum2];

    const IDArray = [];
    const imgArray = [];

    for (let i = 0; i < array.length; i++) {
      const url = `https://pokeapi.co/api/v2/pokemon/${array[i]}`;
      const res = await axios(url);
      const pokemon = res.data;

      IDArray.push(pokemon.id);
    }

    for (let i = 0; i < IDArray.length; i++) {
      const pokemonImg = `https://cdn.traction.one/pokedex/pokemon/${IDArray[i]}.png`;

      imgArray.push(pokemonImg);
    }

    const innerHTML = `
            <div class = 'evolution-title'> <span> Evolutions </span> </div>

            <div class = 'evolution-box'>
                <div id = 'evolution-data-box-1' class = 'evolution-data-box' onclick = 'newPokemon(${
                  IDArray[0]
                })'>
                    <div class = 'img-card'>
                        <img src = '${imgArray[0]}'>
                    </div>

                    <div class = 'data-box'>
                        <span class = 'pokemon-name'> ${array[0]} </span>

                        <span class = 'pokemon-id'> N°${IDArray[0]
                          .toString()
                          .padStart(3, "0")} </span>
                    </div>

                    ${await pokemonType(array[0])}
                </div>

                <div class = 'icon-box'> 
                    <i id = 'icon-1' class="fas fa-chevron-right"></i> 

                    <i id = 'icon-2-2' class="fas fa-chevron-down"></i>
                </div>

                <div id = 'evolution-data-box-2' class = 'evolution-data-box' onclick = 'newPokemon(${
                  IDArray[1]
                })'>
                    <div class = 'img-card'>
                        <img src = '${imgArray[1]}'>
                    </div>

                    <div class = 'data-box'>
                        <span class = 'pokemon-name'> ${array[1]} </span>

                        <span class = 'pokemon-id'> N°${IDArray[1]
                          .toString()
                          .padStart(3, "0")} </span>
                    </div>

                    ${await pokemonType(array[1])}
                </div> 
            </div>
        `;

    evolBox.innerHTML = innerHTML;

    pokemonMainBox3.appendChild(evolBox);
  }
};

const pokemonType = async (pokemon) => {
  const url = `https://pokeapi.co/api/v2/pokemon/${pokemon}`;
  const res = await axios(url);

  const pokemonType = res.data.types.map((type) => type.type.name);

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

  let colorBox1 = `<div style = 'background-color: ${colorNum1}; width: 90px; height: 30px; border-radius: 2px; margin-top: 9px; display: flex; justify-content: center; align-items: center'> <span>${pokemonType}</span> </div>`;
  let colorBox2 = `<div style = 'background-color: ${colorNum2}; width: 90px; height: 30px; border-radius: 2px; margin-top: 9px; margin-right: 5px; display: flex; justify-content: center; align-items: center'> <span>${pokemonType[0]}</span> </div> <div style = 'background-color: ${colorNum3}; width: 90px; height: 30px; border-radius: 2px; margin-top: 9px; margin-left: 5px; display: flex; justify-content: center; align-items: center'> <span>${pokemonType[1]}</span> </div>`;

  const thisColor = `<div style = 'display: flex; justify-content:center;'>${
    typeLength == 1 ? colorBox1 : colorBox2
  }</div>`;

  return thisColor;
};

const button = () => {
  const button = document.createElement("div");
  button.classList.add("button-box");

  const innerHTML = `<button type = 'button' onclick = 'location.href = "./../index.html"'> Go to Pokédex </button>`;

  button.innerHTML = innerHTML;

  buttonBox.appendChild(button);
};

window.onload = async () => {
  await getPokemon(takeID);

  preloader.style.opacity = "0";
  footer.style.opacity = "1";
};

// TESTING

const back = (pokemon) => {
  if (pokemon == 1) {
    const IDPokemon = 800;
    newPokemon(IDPokemon);
  } else {
    const IDPokemon = pokemon - 1;
    newPokemon(IDPokemon);
  }
};

const next = async (pokemon) => {
  if (pokemon == 800) {
    const IDPokemon = 1;
    newPokemon(IDPokemon);
  } else {
    const IDPokemon = pokemon + 1;
    newPokemon(IDPokemon);
  }
};

const newPokemon = (IDPokemon) => {
  location.href = `../view.html?id=${IDPokemon}`;
};