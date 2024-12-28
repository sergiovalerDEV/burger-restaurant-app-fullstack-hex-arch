document.addEventListener("DOMContentLoaded", () => {
    exitItemsTicket();
    //loginWindowSelector();
});

const itemsTicketWindow = document.getElementById("itemsTicketWindow");

function itemTicketWindowManager(){
    if(itemsTicketWindow.style.display == "initial"){
        itemsTicketWindow.style.display = "none";
    } else {
        itemsTicketWindow.style.display = "initial";
    }
};

function openItemsTicket(){
    itemsTicketWindow.style.display = "initial";
};

function exitItemsTicket(){
    itemsTicketWindow.style.display = "none";
};