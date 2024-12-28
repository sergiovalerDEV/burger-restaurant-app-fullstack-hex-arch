document.addEventListener("DOMContentLoaded", () => {

    //  LOGIN

    loadEvents("loginHeaderButton");

    //  REGISTER

    loadEvents("backRegisterButton");
    loadEvents("exitRegisterButton");
    loadEvents("registerButton");

    //  SHOPPINGCART

    loadEvents("shoppingcartHeaderButton");
    loadEvents("exitShoppingcartButton");
    loadEvents("buyShoppingcartButton");
    loadEvents("ticketsButton");

    loadEvents("exitItemsTicketButton");
    loadEvents("backItemTicketButton");
    loadEvents("exitTicketsButton");
});

function loadEvents(event){

        //  LOGIN

    switch (event){
        case "loginHeaderButton":
            console.log("Updating event listener " + event);
            try{
                let loginHeaderButton = document.getElementById("loginHeaderButton");
                loginHeaderButton.addEventListener("click", () => {
                    loginWindowManager();
                    exitRegister();
                });
            } catch (error) { console.log(error); }
        break;

        case "loginButton":
            console.log("Updating event listener " + event);
            try{
                let loginButton = document.getElementById("loginButton");
                loginButton.addEventListener("click", () => {
                    login();
                });
            } catch (error) { console.log(error); }
        break;

        case "exitLoginButton":
            console.log("Updating event listener " + event);
            try{
                let exitLoginButton = document.getElementById("exitLogin");
                exitLoginButton.addEventListener("click", () => {
                    exitLogin();
                });
            } catch (error) { console.log(error); }
        break;
        
        case "logoutButton":
            console.log("Updating event listener " + event);
            try{
                let logoutButton = document.getElementById("logoutButton");
                logoutButton.addEventListener("click", () => {
                    logout();
                });
            } catch (error) { console.log(error); }
        break;

        //  REGISTER

        case "registerLoginButton":
            console.log("Updating event listener " + event);
            try{
                let registerLoginButton = document.getElementById("registerLoginButton");
                registerLoginButton.addEventListener("click", () => {
                    openRegister();
                    exitLogin();
                });
            } catch (error) { console.log(error); }
        break;

        case "exitRegisterButton":
            console.log("Updating event listener " + event);
            try{
                let exitRegisterButton = document.getElementById("exitRegister");
                exitRegisterButton.addEventListener("click", () => {
                    exitRegister();
                });
            } catch (error) { console.log(error); }
        break;

        case "registerButton":
            console.log("Updating event listener " + event);
            try{
                let registerButton = document.getElementById("registerButton");
                registerButton.addEventListener("click", () => {
                    register();
                });
            } catch (error) { console.log(error); }
        break;

        case "backRegisterButton":
            console.log("Updating event listener " + event);
            try{
                let backRegisterButton = document.getElementById("backRegister");
                backRegisterButton.addEventListener("click", () => {
                    backRegister();
                });
            } catch (error) { console.log(error); }
        break;
        
        //  SHOPPINGCART

        case "shoppingcartHeaderButton":
            console.log("Updating event listener " + event);
            try{
                let shoppingcartHeaderButton = document.getElementById("shoppingcartHeader");
                shoppingcartHeaderButton.addEventListener("click", () => {
                    shoppingcartWindowManager();
                });
            } catch (error) { console.log(error); }
        break;

        case "exitShoppingcartButton":
            console.log("Updating event listener " + event);
            try{
                let exitShoppingcartButton = document.getElementById("exitShoppingcart");
                exitShoppingcartButton.addEventListener("click", () => {
                    exitShoppingcart();
                });
            } catch (error) { console.log(error); }
        break;

        case "buyShoppingcartButton":
            console.log("Updating event listener " + event);
            try{
                let buyShoppingcartButton = document.getElementById("buyShoppingcart");
                buyShoppingcartButton.addEventListener("click", async () => {
                    if(listOfItemsShoppingcart.length > 0){
                        await closeShoppingcart();
                        await buyShoppingcart();
                        await setProperties(userName);
                        loadItems();
                    } else {
                        alert("El carrito está vacio!!!")
                    }
                });
            } catch (error) { console.log(error); }
        break;

        case "ticketsButton":
            console.log("Updating event listener " + event);
            try{
                let ticketsButton = document.getElementById("tickets");
                ticketsButton.addEventListener("click", () => {
                    ticketsWindowManager();
                    showClosedCarts(userId);
                });
            } catch (error) { console.log(error); }
        break;



        case "exitTicketsButton":
            console.log("Updating event listener " + event);
            try{
                let ticketsButton = document.getElementById("exitTicketsWindow");
                ticketsButton.addEventListener("click", () => {
                    exitTickets();
                });
            } catch (error) { console.log(error); }
        break;

        case "backItemTicketButton":
            console.log("Updating event listener " + event);
            try{
                let ticketsButton = document.getElementById("backItemsTicketWindow");
                ticketsButton.addEventListener("click", () => {
                    exitItemsTicket();
                    openTickets();
                });
            } catch (error) { console.log(error); }
        break;

        case "exitItemsTicketButton":
            console.log("Updating event listener " + event);
            try{
                let ticketsButton = document.getElementById("exitItemsTicketWindow");
                ticketsButton.addEventListener("click", () => {
                    exitItemsTicket();
                });
            } catch (error) { console.log(error); }
        break;
    }
};