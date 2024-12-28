document.addEventListener("DOMContentLoaded", () => {
    showBurguers()
});

//const burguerSelling = document.getElementById("burguerSelling");

async function showBurguers(category) {
    let items;

    if (category === undefined) {
        items = await fetch("http://localhost:8080/Burguer/controller?ACTION=item.getall");
    } else {
        items = await fetch("http://localhost:8080/Burguer/controller?ACTION=item.getbycategory&CATEGORY=" + category);
    }

    const itemsJson = await items.json();
    const burguerSellingFlex = document.querySelector("#burguerSelling > .flex");

    burguerSellingFlex.innerHTML = ``;

    for (const item of itemsJson) {
        //console.log(item)
        const card = document.createElement("div");
        card.className = "card";
        card.innerHTML = `
                <img src="${item.image}" alt="Imagen de ${item.name}">
                <p>${item.name}</p>
                <p>${item.price}$</p>
                <button onclick="buyItem(${item.id})">Comprar</button>
        `;
        /*Aparece el precio con burguer.description a pesar de que no debería ser así, modificar*/
        burguerSellingFlex.appendChild(card);
    }
}

// async function buyItem(item){
//     console.log("Buying " + item + "item");
//     await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.add&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + item + "&AMMOUNT=" + "1");
//     loadItems();
// }

let listOfItemsShoppingcart = [];

async function buyItem(itemId){
    console.log(itemId)
    const itemm = await fetch('http://localhost:8080/Burguer/controller?ACTION=item.getbyid&ID=' + itemId);
    const itemmJson = await itemm.json();

    // console.log(itemmJson)

    const item = {
        id: itemmJson[0].id,
        name: itemmJson[0].name,
        image: itemmJson[0].image,
        initialPrice: itemmJson[0].price,
        price: itemmJson[0].price,
        ammount: 1
    }
    console.log("Buying " + item + "item");
    for(const a of listOfItemsShoppingcart){
        if(a.id == item.id){
            console.log("Ya has comprado el item")
            loadItems();
            return;
        }
    }
    listOfItemsShoppingcart.push(item);
    console.log(listOfItemsShoppingcart);
    loadItems();
}