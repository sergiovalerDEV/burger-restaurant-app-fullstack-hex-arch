document.addEventListener("DOMContentLoaded", () => {
    exitTickets();
    //loginWindowSelector();
});

const ticketsWindow = document.getElementById("ticketsWindow");

function ticketsWindowManager(){
    if(ticketsWindow.style.display == "initial"){
        ticketsWindow.style.display = "none";
    } else {
        ticketsWindow.style.display = "initial";
    }
};

function openTickets(){
    ticketsWindow.style.display = "initial";
};

function exitTickets(){
    ticketsWindow.style.display = "none";
};