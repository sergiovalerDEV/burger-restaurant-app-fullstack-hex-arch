document.addEventListener("DOMContentLoaded", () => {
    exitRegister();
});

var registerWindow = document.getElementById("register");

function registerWindowManager(){
    if(registerWindow.style.display == "initial"){
        registerWindow.style.display = "none";
    } else {
        registerWindow.style.display = "initial";
    }
};

function openRegister(){
    registerWindow.style.display = "initial";
};

function backRegister(){
    registerWindow.style.display = "none";
    loginWindow.style.display = "initial";
}

function exitRegister(){
    registerWindow.style.display = "none";
};