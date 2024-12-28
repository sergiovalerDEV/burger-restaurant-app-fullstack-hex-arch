async function showClosedCarts(userId) {
    //alert("llego")
    //try {
        console.log(userId)
        const closedCarts = await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcart.getclosedbyuser&USER=" + userId);
        console.log(closedCarts)
        const closedCartsJson = await closedCarts.json();
        console.log(closedCartsJson)

        /*if (!closedCarts.ok) {
            throw new Error('No se pudo obtener los carritos cerrados');
        }*/
        
        const cartContainer = document.querySelector("#ticketsWindow > .flex");

        cartContainer.innerHTML = ``;

        for (const cart of closedCartsJson) {
            const cartCard = document.createElement("div");
            cartCard.className = "cart-card";
            cartCard.innerHTML = `
                <p>Carrito ID: ${cart.id}</p>
                <p>Fecha: ${cart.date}</p>
                <p>Precio total: ${cart.price}$</p>
                <button onclick="showItemsShoppingcart(${cart.id}); exitTickets()">Ver CartItems</button>
            `;
            cartContainer.appendChild(cartCard);
        }
    // } catch (error) {
    //     console.error('Error:', error);
    // }
}


// function renderItems(carritoId) {
//     fetch(`http://localhost:8080/Burguer/controller/shoppingcartitem/getbyshoppingcart?SHOPPINGCART=${carritoId}`)
//         .then(response => response.json())
//         .then(items => {
//             const itemsContainer = document.getElementById('closedCartContainer2');
//             itemsContainer.innerHTML = ''; // Limpiar el contenedor antes de agregar los nuevos items
//             items.forEach(item => {
//                 const itemDiv = document.createElement('div');
//                 itemDiv.classList.add('item');
//                 itemsContainer.appendChild(itemDiv);

//                 fetch(`http://localhost:8080/Burguer/controller/item/getbyid?ID=${item.item}`)
//                     .then(response => response.json())
//                     .then(itemDetails => {
//                         const itemDetail = itemDetails[0]; // Acceder al primer elemento del array
//                         itemDiv.innerHTML = `
//                             <p>ID del Item: ${item.item}</p>
//                             <p>Nombre: ${itemDetail.name}</p> 
//                             <p>Cantidad: ${item.ammount}</p>
//                         `;
//                     })
//                     .catch(error => console.error('Error al obtener los detalles del artículo:', error));
//             });
//         })
//         .catch(error => console.error('Error al obtener los items:', error));
// }