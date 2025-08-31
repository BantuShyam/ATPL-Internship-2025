const users = [
  { name: "Shyam", age: 25 },
  { name: "Balaram", age: 22 },
  { name: "Akbar", age: 30 }
];

const container = document.getElementById("card-container");

users.forEach(user => {
  let card = document.createElement("div");
  card.className = "card";

  card.innerHTML = `
    <h3>${user.name}</h3>
    <p>Age: ${user.age}</p>
  `;

  container.appendChild(card);
});
