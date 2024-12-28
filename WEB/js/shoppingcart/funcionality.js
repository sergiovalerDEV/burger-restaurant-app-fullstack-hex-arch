document.addEventListener("DOMContentLoaded", () => {
    //loadItems();
});
/*async function loadItems(){
    const items = await fetch("http://localhost:8080/Burguer/controller/shoppingcartitem/getbyshoppingcart?SHOPPINGCART=" + userShoppingcart);
    const itemsJson = await items.json();
    
    const shoppingcartFlex = document.querySelector("#shoppingcart > .flex")
    shoppingcartFlex.innerHTML = ``;

    for(const item of itemsJson){
        //console.log("1")
        const itemInfo = await fetch("http://localhost:8080/Burguer/controller/item/getbyid?ID=" + item.item);
        const itemInfoJson = await itemInfo.json();
        console.log(itemInfoJson)

        const card = document.createElement("div");

        card.className = "item";

        card.innerHTML = `
        <div class="commonInfo">
            <img src="${itemInfoJson[0].image}">
            <p>${itemInfoJson[0].name}</p>
        </div>
        <div class="priceInfo">
            <p>${item.ammount * itemInfoJson[0].price}</p>
            <div class="buttons">
                <button onclick="increaseAmount(${item.item}, ${item.ammount})">+</button>
                <input type="text" value="${item.ammount}" onblur="updateAmount(${item.item}, value)">
                <button onclick="decreaseAmount(${item.item}, ${item.ammount})">-</button>
                <button onclick="renderProductExtras(${item.id})">X</button>
            </div>
        </div>
        `;

        shoppingcartFlex.appendChild(card);
    }
}
async function renderProductExtras(itemId) {
    const response = await fetch(`http://localhost:8080/Burguer/controller/shoppingcartitemextra/getbyshoppingcartitem?SHOPPINGCARTITEM=${itemId}`);
    const items = await response.json();
    
    const itemsContainer = document.querySelector('#ticketsWindow > .flex');
    itemsContainer.innerHTML = ''; 

    for (const item of items) {
        const itemDiv = document.createElement('div');
        itemDiv.classList.add('item');
        itemsContainer.appendChild(itemDiv);

        const itemDetailsResponse = await fetch(`http://localhost:8080/Burguer/controller/extra/getbyid?ID=${item.extra}`);
        const itemDetails = await itemDetailsResponse.json();
        const itemDetail = itemDetails[0]; 

        itemDiv.innerHTML = `
            <p>Nombre del extra: ${itemDetail.name}</p> 
            <p>Cantidad: ${item.ammount}</p>
        `;
    }
}*/

let totalPriceShoppingcart;

async function loadItems() {
    console.log("Cargando items...");
    const items = await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.getbyshoppingcart&SHOPPINGCART=" + userShoppingcart);
    const itemsJson = await items.json();
    // itemsJson.add();
    console.log("Items cargados:", itemsJson);

    const shoppingcartFlex = document.querySelector("#shoppingcart > .flex")
    shoppingcartFlex.innerHTML = ``;

    let percent = 0;
    totalPriceShoppingcart = 0;

    const allBurguersList = await fetch("http://localhost:8080/Burguer/controller?ACTION=item.getallburguers");
    const allBurguersListJson = await allBurguersList.json();

    for(const item of listOfItemsShoppingcart) {
        // const itemInfo = await fetch("http://localhost:8080/Burguer/controller?ACTION=item.getbyid&ID=" + item.item);
        // const itemInfoJson = await itemInfo.json();

        // percent += 1;        
        // console.log(("Porcentaje: " + percent/listOfItemsShoppingcart.length*100) + "%");
        // // console.log("Detalles del item:", itemInfoJson);
        // console.log("Procesando item:", item);

        // const bar = document.getElementById("innerBar");
        // bar.style.width = percent/listOfItemsShoppingcart.length*100 + "%";

        // bar.style.display = 'flex';
        // bar.style.alignItems = 'center';
        // bar.style.justifyContent = 'center';
        // bar.textContent = `${percent/listOfItemsShoppingcart.length*100}%`; // Actualizar el texto del porcentaje

        if(item.ammount > 0){
        const card = document.createElement("div");
        card.className = "item";

        let innerHTMLText

        // innerHTMLText = `
        //     <div class="commonInfo">
        //         <img src="${itemInfoJson[0].image}">
        //         <p>${itemInfoJson[0].name}</p>
        //     </div>
        //     <div class="priceInfo">
        //         <p>${item.ammount * itemInfoJson[0].price}€</p>
        //         <div class="buttons">
        //             <button onclick="increaseAmount(${item.item}, ${item.ammount})">+</button>
        //             <input type="text" value="${item.ammount}" onblur="updateAmount(${item.item}, value)">
        //             <button onclick="decreaseAmount(${item.item}, ${item.ammount})" style="width: 30px">-</button>
        //             `

        // for(const burguer of allBurguersListJson){
        //     if(item.item == burguer.id){
        //     innerHTMLText += `
        //                 <button onclick="openExtras(${item.item})">Extras</button>
        //                 `
        //     break;
        //     }
        // }

        // innerHTMLText += `
        //         </div>
        //     </div>
        //     <div class="extras-container" id="ei${item.item}" style="transform: translateX(calc(0px))"></div>
        // `;
        innerHTMLText = `
        <div class="commonInfo">
                <img src="${item.image}">
                <p>${item.name}</p>
            </div>
            <div class="priceInfo">
                <p>${item.ammount * item.initialPrice}€</p>
                <div class="buttons">
                    <button onclick="increaseAmount(${item.id}, ${item.ammount})">+</button>
                    <input type="text" value="${item.ammount}" onblur="updateAmount(${item.id}, value)">
                    <button onclick="decreaseAmount(${item.id}, ${item.ammount})" style="width: 30px">-</button>
                </div>
            </div>
            <div class="extras-container" id="ei${item.id}" style="transform: translateX(calc(0px))"></div>
        `;

        card.innerHTML = innerHTMLText;

        totalPriceShoppingcart += item.ammount * item.initialPrice;
        // totalPriceShoppingcart = parseFloat(totalPriceShoppingcart.toFixed(2));

        shoppingcartFlex.appendChild(card);

        // const cardExtras = document.createElement("div")
        // cardExtras.className = "extras-container";

        // shoppingcartFlex.appendChild(cardExtras);

        // Llamamos a la función renderProductExtras para cargar los extras del artículo
        // console.log("Cargando extras para el item:", item.item);
        //await renderProductExtras(item.item);
        // console.log("Extras cargados para el item:", item.item);
        }
    }

    console.log("Todos los items procesados. Precio total: " + totalPriceShoppingcart);
}

// async function loadItems() {
//     console.log("Cargando items...");
//     const items = await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.getbyshoppingcart&SHOPPINGCART=" + userShoppingcart);
//     const itemsJson = await items.json();
//     // itemsJson.add();
//     console.log("Items cargados:", itemsJson);

//     const shoppingcartFlex = document.querySelector("#shoppingcart > .flex")
//     shoppingcartFlex.innerHTML = ``;

//     let percent = 0;
//     totalPriceShoppingcart = 0;

//     const allBurguersList = await fetch("http://localhost:8080/Burguer/controller?ACTION=item.getallburguers");
//     const allBurguersListJson = await allBurguersList.json();

//     for(const item of itemsJson) {
//         const itemInfo = await fetch("http://localhost:8080/Burguer/controller?ACTION=item.getbyid&ID=" + item.item);
//         const itemInfoJson = await itemInfo.json();

//         percent += 1;        
//         console.log(("Porcentaje: " + percent/itemsJson.length*100) + "%");
//         console.log("Detalles del item:", itemInfoJson);
//         console.log("Procesando item:", item);

//         const bar = document.getElementById("innerBar");
//         bar.style.width = percent/itemsJson.length*100 + "%";

//         bar.style.display = 'flex';
//         bar.style.alignItems = 'center';
//         bar.style.justifyContent = 'center';
//         bar.textContent = `${percent/itemsJson.length*100}%`; // Actualizar el texto del porcentaje

//         const card = document.createElement("div");
//         card.className = "item";

//         let innerHTMLText

//         innerHTMLText = `
//             <div class="commonInfo">
//                 <img src="${itemInfoJson[0].image}">
//                 <p>${itemInfoJson[0].name}</p>
//             </div>
//             <div class="priceInfo">
//                 <p>${item.ammount * itemInfoJson[0].price}€</p>
//                 <div class="buttons">
//                     <button onclick="increaseAmount(${item.item}, ${item.ammount})">+</button>
//                     <input type="text" value="${item.ammount}" onblur="updateAmount(${item.item}, value)">
//                     <button onclick="decreaseAmount(${item.item}, ${item.ammount})" style="width: 30px">-</button>
//                     `

//         for(const burguer of allBurguersListJson){
//             if(item.item == burguer.id){
//             innerHTMLText += `
//                         <button onclick="openExtras(${item.item})">Extras</button>
//                         `
//             break;
//             }
//         }

//         innerHTMLText += `
//                 </div>
//             </div>
//             <div class="extras-container" id="ei${item.item}" style="transform: translateX(calc(0px))"></div>
//         `;

//         card.innerHTML = innerHTMLText;

//         totalPriceShoppingcart += item.ammount * itemInfoJson[0].price;
//         totalPriceShoppingcart = parseFloat(totalPriceShoppingcart.toFixed(2));

//         shoppingcartFlex.appendChild(card);

//         // const cardExtras = document.createElement("div")
//         // cardExtras.className = "extras-container";

//         // shoppingcartFlex.appendChild(cardExtras);

//         // Llamamos a la función renderProductExtras para cargar los extras del artículo
//         // console.log("Cargando extras para el item:", item.item);
//         //await renderProductExtras(item.item);
//         // console.log("Extras cargados para el item:", item.item);
//     }

//     console.log("Todos los items procesados. Precio total: " + totalPriceShoppingcart);
// }

async function openExtras(id){
    // alert(id)
    
    // alert("llego")
    const extrasWindow = document.querySelector(".item > #ei" + id);
    const otherExtrasWindow = document.querySelectorAll(".item > .extras-container")
    if(extrasWindow.style.transform == "translateX(calc(0px))"){
        loadExtras(id);
        otherExtrasWindow.forEach(element => {
            element.style.zIndex = "-1";
            element.style.transform = "translateX(calc(0px))"
        });
        // otherExtrasWindow.style.
        extrasWindow.style.transform = "translateX(calc(60px - 5px))";
        extrasWindow.style.zIndex = "0";
    } else{
        otherExtrasWindow.forEach(element => {
            element.style.zIndex = "-1";
            element.style.transform = "translateX(calc(0px))"
        });
        // otherExtrasWindow.style.transform = "translateX(calc(0px))"
        extrasWindow.style.zIndex = "-1";
        extrasWindow.style.transform = "translateX(calc(0px))"
    }
}

async function loadExtras(id){
    const extrasWindow = document.querySelector(".item > #ei" + id);
    // alert("a")
    const extras = await fetch("http://localhost:8080/Burguer/controller?ACTION=extra.getall")
    const extrasJson = await extras.json();

    extrasWindow.innerHTML = ``;

    for(const extra of extrasJson){
        const card = document.createElement("div");
        card.id = "eii" + extra.id;

        card.innerHTML = `
        <img src="${extra.image}" onclick="updateExtras(${id}, ${extra.id})">
        `
        console.log(extrasWindow)
        extrasWindow.appendChild(card)
    }

    console.log(extrasJson)

    const itemExtras = await selectExtras(id);

    console.log("Splitted", itemExtras)

    for(const a of itemExtras){
        for(const b of extrasJson){
            if(a == b.id){
                const addedItemExtra = document.querySelector("#ei" + id + " > #eii" + b.id + " > img");
                addedItemExtra.style.border = "4px green solid"
                // console.log("#ei" + id + " > #eii" + b.id)

                // addedItemExtra.addEventListener("click", () => {
                //     updateExtras(addedItemExtra)
                // });
            }
        }
    }
}

let itemExtrasSplitted;

async function selectExtras(id){
    const itemExtras = await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.getbyshoppingcartanditem&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + id);
    let itemExtrasJson = await itemExtras.json();

    // itemExtrasJson = "1, 2 , 3 , 4";

    itemExtrasSplitted = itemExtrasJson[0].ingredients.split(",");

    // console.log("Splitted", itemExtrasSplitted);
    return itemExtrasSplitted;
}

// async function renderProductExtras(itemId) {
//     console.log("Cargando extras para el item:", itemId);
//     const response = await fetch(`http://localhost:8080/Burguer/controller/shoppingcartitemextra/getbyshoppingcartitem?SHOPPINGCARTITEM=${itemId}`);
//     const items = await response.json();
//     console.log("Extras cargados para el item:", itemId, items);
    
//     const extrasContainer = document.querySelector(`#extras-${itemId}`);
//     extrasContainer.innerHTML = ''; 

//     for (const item of items) {
//         const itemDetailsResponse = await fetch(`http://localhost:8080/Burguer/controller/extra/getbyid?ID=${item.extra}`);
//         const itemDetails = await itemDetailsResponse.json();
//         const itemDetail = itemDetails[0]; 

//         const itemDiv = document.createElement('div');
//         itemDiv.classList.add('extra');
//         itemDiv.innerHTML = `
//             <p>Nombre del extra: ${itemDetail.name}</p> 
//             <p>Cantidad: ${item.ammount}</p>
//         `;
//         extrasContainer.appendChild(itemDiv);
//     }

//     console.log("Todos los extras procesados para el item:", itemId);
// }


let ingredients = "";

async function updateExtras(id, id2){
    
    // alert("llego")
    alert(id + "," + id2)
    const extra = document.querySelector(".item > #ei" + id + " > #eii" + id2 + " > img")
    console.log(".item > #ei" + id + " > #eii" + id2 + " > img", extra)

    ingredients = "";

    if(extra.style.border == "4px solid green"){
        // alert("verde");
        for(const extraa of itemExtrasSplitted){
            if(extraa != id2){
            ingredients += extraa + ",";
            // alert("ya")
            }
            console.log(ingredients)
        }
    } else {
        // alert("rojo")
        for(const extraa of itemExtrasSplitted){
            ingredients += extraa + ","
        }
        ingredients += id2
    }
    console.log("ingredients: " + ingredients)
        await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.updateByIngredients&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + id + "&EXTRAS=" + ingredients);
        loadExtras(id);
}

function getIngredients(){
    console.log(ingredients)
}































function toggleExtras(itemId) {
    const extrasContainer = document.querySelector(`#extras-${itemId}`);
    extrasContainer.style.display = extrasContainer.style.display === 'none' ? 'block' : 'none';
}

async function buyShoppingcart(){
    await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcart.add&USER=" + userId)
    // loadItems();
}

async function closeShoppingcart(){
    for(const item of listOfItemsShoppingcart){
        await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.add&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + item.id + "&AMMOUNT=" + item.ammount);
    }
    await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcart.update&ID=" + userShoppingcart + "&PRICE=" + totalPriceShoppingcart + "&OPENED=false")
    listOfItemsShoppingcart = [];
    //await setProperties(userName);
    // loadItems();
}

// async function closeShoppingcart(){
//     await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcart.update&ID=" + userShoppingcart + "&PRICE=" + totalPriceShoppingcart + "&OPENED=false")
//     //await setProperties(userName);
//     // loadItems();
// }

async function updateAmount(item, amount) {
    const updatedAmount = amount;
    for(const itemm of listOfItemsShoppingcart){
        // console.log(itemm.id, item)
        if(itemm.id == item){
            itemm.ammount = updatedAmount;
            itemm.price = itemm.initialPrice * amount;
            itemm.price = parseFloat(itemm.price.toFixed(2));
            // console.log(itemm.ammount, amount)
        }
    }

    // await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.update&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + item + "&AMMOUNT=" + updatedAmount);
    
    loadItems();
}

async function increaseAmount(item, amount) {
    console.log("12")
    const updatedAmount = amount + 1;
    for(const itemm of listOfItemsShoppingcart){
        // console.log(itemm.id, item)
        if(itemm.id == item){
            itemm.ammount = updatedAmount;
            itemm.price = itemm.initialPrice * amount;
            // console.log(itemm.ammount, amount)
        }
    }
    //await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.update&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + item + "&AMMOUNT=" + updatedAmount);
    
    loadItems();
}

async function decreaseAmount(item, amount) {
    const updatedAmount = amount -1;
    for(const itemm of listOfItemsShoppingcart){
        // console.log(itemm.id, item)
        if(itemm.id == item){
            itemm.ammount = updatedAmount;
            itemm.price = itemm.initialPrice * amount;
            // console.log(itemm.ammount, amount)
        }
    }
    //await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcartitem.update&SHOPPINGCART=" + userShoppingcart + "&ITEM=" + item + "&AMMOUNT=" + updatedAmount);

    loadItems();
}



/*
<div class="commonInfo">
    <img src="${itemInfoJson.img}">
    <p>${itemInfoJson.name}</p>
</div>
<div class="priceInfo">
    <p>${item.price}</p>
    <div class="buttons">
        <button>+</button>
        <input type="text" value="${item.ammount}">
        <button>-</button>
    </div>
</div>*/