document.addEventListener("DOMContentLoaded", () => {
    exitLogin();
    //loginWindowSelector();
});

var loginWindow = document.getElementById("login");

function loginWindowManager(){
    if(loginWindow.style.display == "initial"){
        loginWindow.style.display = "none";
    } else {
        loginWindow.style.display = "initial";
    }
};

function loginWindowSelector(){
    console.log(userName);
    if(userName === null){
        loginWindow.innerHTML = `
        <div class="windowButtons">
            <button id="exitLogin">Exit</button>
        </div>
        <div class="fields">
            <input class="name" type="text" placeholder="Name">
            <input class="password" type="password" placeholder="Password">
            <input class="address" type="text" placeholder="Address">
        </div>
        <div class="finalButtons">
        <button id="loginButton">Login</button>
        <p id="registerLoginButton">Don't have an account? Register one</p>
        </div>
        `;

        
        loadEvents("exitLoginButton");
        loadEvents("loginButton");
        loadEvents("registerLoginButton");
    } else {
        loginWindow.innerHTML = `
        <div class="windowButtons">
            <button id="exitLogin">Exit</button>
        </div>
        <div id="userInfo">
        <p>Id: ${userId}</p>
        <p>Name: ${userName}</p>
        <p>Address: ${userAddress}</p>
        <p>Shoppingcart: ${userShoppingcart}</p>
        </div>
        <div class="finalButtons">
        <button id="logoutButton">Logout</button>
        </div>
        `;

        loadEvents("exitLoginButton");
        loadEvents("logoutButton");
    }
    //loadEvents("loginHeaderButton");
};

function openLogin(){
    loginWindowSelector();
    loginWindow.style.display = "initial";
};

function exitLogin(){
    loginWindow.style.display = "none";
};