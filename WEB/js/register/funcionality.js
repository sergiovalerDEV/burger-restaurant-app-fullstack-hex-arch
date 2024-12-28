async function register(){
    const name = document.querySelector("#register > .fields > .name").value;
    const password = document.querySelector("#register > .fields > .password").value;
    const address = document.querySelector("#register > .fields > .address").value;

    const user = await fetch("http://localhost:8080/Burguer/controller?ACTION=user.getbyname&NAME=" + name);
    const userjson = await user.json();

    if(name.length >= 4 && userjson.length < 1){
        if(password.length >= 4){
            if(address.includes("@") && address.includes(".com") && address.indexOf("@") < address.indexOf(".") && address.indexOf("@") > 0 && address.indexOf(".") >= address.indexOf("@") + 2){
                Swal.fire({
                    icon: 'success',
                    title: 'Success!',
                    text: 'Login successful!',
                    customClass: {
                      popup: 'sweet-alert-custom',
                      icon: 'sweet-alert-icon-custom',
                      confirmButton: 'sweet-alert-btn-custom'
                    }
                });
                registerUpdater(name, address, password);
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Address must be like _@_.com',
                    customClass: {
                      popup: 'sweet-alert-custom',
                      icon: 'sweet-alert-icon-custom',
                      confirmButton: 'sweet-alert-btn-custom'
                    }
                });
            }
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Password must be longer!!',
                customClass: {
                  popup: 'sweet-alert-custom',
                  icon: 'sweet-alert-icon-custom',
                  confirmButton: 'sweet-alert-btn-custom'
                }
            });
        }
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Name must be longer or already exists!!',
            customClass: {
              popup: 'sweet-alert-custom',
              icon: 'sweet-alert-icon-custom',
              confirmButton: 'sweet-alert-btn-custom'
            }
        });
    }
};

async function registerUpdater(name, address, password){
    await fetch("http://localhost:8080/Burguer/controller?ACTION=user.add&NAME=" + name + "&ADDRESS=" + address + "&PASSWORD=" + password);

    const user = await fetch("http://localhost:8080/Burguer/controller?ACTION=user.getbyname&NAME=" + name);
    const userjson = await user.json();

    await fetch("http://localhost:8080/Burguer/controller?ACTION=shoppingcart.add&USER=" + userjson[0].id);

    setProperties(name);
    //getProperties();
}