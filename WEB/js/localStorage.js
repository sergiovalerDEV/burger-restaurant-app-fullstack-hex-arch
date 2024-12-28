document.addEventListener("DOMContentLoaded", async () => {
    //setProperties("Sergio");
    await getProperties();
    setProperties(userName);
    loginWindowSelector();
    loadItems();
});

var userId;
var userName;
var userAddress;
var userShoppingcart;

function getProperties(){
    //console.log(localStorage.length)

    userId = localStorage.getItem("id");
    userName = localStorage.getItem("name");
    userAddress = localStorage.getItem("address");
    userShoppingcart = localStorage.getItem("shoppingcart");

    console.log(
        "--------USER--------\n" +
        "Id: " + userId + "\n" +
        "Name: " + userName + "\n" +
        "Address: " + userAddress + "\n" +
        "Shoppingcart: " + userShoppingcart
    );

    loginWindowSelector();
}

async function setProperties(name){

    const user = await fetch("http://localhost:8080/Burguer/controller?ACTION=user.getbyname&NAME=" + name);
    const userjson = await user.json();

    localStorage.setItem("id", userjson[0].id);
    localStorage.setItem("name", userjson[0].name);
    localStorage.setItem("address", userjson[0].address);

    const shoppingcart = await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcart.getopenedbyuser&USER=" + userjson[0].id);
    const shoppingcartjson = await shoppingcart.json();

    localStorage.setItem("shoppingcart", shoppingcartjson[0].id);

    getProperties();
}

async function removeProperties(){
    localStorage.removeItem("id");
    localStorage.removeItem("name");
    localStorage.removeItem("address");
    localStorage.removeItem("shoppingcart");

    getProperties();
}