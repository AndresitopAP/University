const buttonUp = document.getElementById("button-up");

const scrollUp = () => {
  let currentScroll = document.documentElement.scrollTop;
  let scrolling = currentScroll / 10;
  if (currentScroll > 0) {
    window.requestAnimationFrame(scrollUp);
    window.scrollTo(0, currentScroll - scrolling);
  }
};

window.onscroll = function () {
  let scroll = document.documentElement.scrollTop;
  if (scroll > 450) {
    buttonUp.style.transform = "scale(1)";
  } else {
    buttonUp.style.transform = "scale(0)";
  }
};