document.addEventListener("DOMContentLoaded", () => {
    showBurguers()
});

//const burguerSelling = document.getElementById("burguerSelling");

async function showBurguers(category) {
    let items;

    if (category === undefined) {
        items = await fetch("http://localhost:8080/Burguer/controller/item/getall");
    } else {
        items = await fetch("http://localhost:8080/Burguer/controller/item/getbycategory?CATEGORY=" + category);
    }

    const itemsJson = await items.json();
    const burguerSellingFlex = document.querySelector("#burguerSelling > .flex");

    burguerSellingFlex.innerHTML = ``;

    for (const item of itemsJson) {
        const card = document.createElement("div");
        card.className = "card";
        card.innerHTML = `
                <img src="${item.image}" alt="Imagen de ${item.name}">
                <p>${item.name}</p>
                <p>${item.price}$</p>
                <button onclick="buyItem(${item.id})"></button>
        `;
        /*Aparece el precio con burguer.description a pesar de que no debería ser así, modificar*/
        burguerSellingFlex.appendChild(card);
    }
}

async function buyItem(item){
    //CODIGO ORIGINAL CON BASE DE DATOS
    console.log("Buying " + item + "item");
    await fetch("http://localhost:8080/Burguer/controller/shoppingcartitem/add?SHOPPINGCART=" + userShoppingcart + "&ITEM=" + item + "&AMMOUNT=" + "1");
    loadItems();
}