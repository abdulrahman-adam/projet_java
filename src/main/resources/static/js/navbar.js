/**
 * 
 */

 // console.log("slut");

const currentLocation = location.href;
const menuItem = document.querySelectorAll("nav ul li a");
const menuLength = menuItem.length;

// console.log(menuLength);

for (var i = 0; i < menuLength; i++) {
  if (menuItem[i].href === currentLocation) {
    menuItem[i].className = "active";
  }
}

// La section dropdown

let liSpan = document.querySelector("ul li span");
let liSpanDrop = document.querySelector(".fa-solid");
let ulElement = document.querySelector("ul li ul");

liSpan.addEventListener("click", function (e) {
  liSpanDrop.classList.toggle("dropdown");
  liSpanDrop.classList.toggle("salut");
  ulElement.classList.toggle("active");
});

let parentSpan = document.querySelector(".parentSpan");
let ulElement1 = document.querySelector("nav ul");

parentSpan.addEventListener("click", (eo) => {
  parentSpan.classList.toggle("active11");
  ulElement1.classList.toggle("active22");
});
