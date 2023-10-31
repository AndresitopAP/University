let status = true;

const toggle = () => {
  const getAside = document.querySelector("aside");
  const getAsideUl = document.querySelector("aside ul");
  const getAsideTitle = document.querySelector("aside span");
  const getAsideLinks = document.querySelectorAll("aside a");

  if (status) {
    getAside.style.width = "260px";
    getAsideUl.style.visibility = "visible";
    getAsideTitle.style.opacity = "0.9";

    const linksNumber = getAsideLinks.length;

    for (let i = 0; i < linksNumber; i++) {
      getAsideLinks[i].style.opacity = "1";
    }

    status = false;
  } else {
    getAside.style.width = "0";
    getAsideUl.style.visibility = "hidden";
    getAsideTitle.style.opacity = "0";

    const linksNumber = getAsideLinks.length;

    for (let i = 0; i < linksNumber; i++) {
      getAsideLinks[i].style.opacity = "0";
    }

    status = true;
  }
};