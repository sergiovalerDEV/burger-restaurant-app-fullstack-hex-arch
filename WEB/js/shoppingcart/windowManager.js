document.addEventListener("DOMContentLoaded", () => {
    exitShoppingcart();
});

var shoppingcartWindow = document.getElementById("shoppingcart");

function shoppingcartWindowManager(){
    if(shoppingcartWindow.style.display == "flex"){
        shoppingcartWindow.style.display = "none";
    } else {
        shoppingcartWindow.style.display = "flex";
    }
};

function exitShoppingcart(){
    shoppingcartWindow.style.display = "none";
}

function openShoppingcart(){
    shoppingcartWindowSelector();
    shoppingcartWindow.style.display = "flex";
};

function exitShoppingcart(){
    shoppingcartWindow.style.display = "none";
};