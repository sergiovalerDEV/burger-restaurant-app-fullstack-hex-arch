async function login(){
    const name = document.querySelector("#login > .fields > .name").value;
    const password = document.querySelector("#login > .fields > .password").value;
    const address = document.querySelector("#login > .fields > .address").value;
    
    const user = await fetch("http://localhost:8080/Burguer/controller?ACTION=user.getbyname&NAME=" + name);
    const userjson = await user.json();

    console.log(userjson[0])

    if(userjson.length == 1){
        console.log(userjson[0].password);
        if(password == userjson[0].password){
            if(address == userjson[0].address){
                loginUpdater(name);
            } else {
                alert("Incorrect Address")
            }
        } else {
            alert("Incorrect Password");
        }
    } else {
        alert("Incorrect User");
    }
};

async function loginUpdater(name){
    await setProperties(name);
    loginWindowSelector();
    loadItems();
    //getProperties();
}

async function logout(){
    await removeProperties();
    loginWindowSelector();
}