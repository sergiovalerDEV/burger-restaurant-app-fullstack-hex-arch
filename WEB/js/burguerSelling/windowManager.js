let burguerSellingWindow = document.getElementById("burguerSelling");

document.addEventListener("DOMContentLoaded", () => {
    burguerSellingWindow.style.display = "none";
})

function showBurguerSelling(category){
    showBurguers(category);

    burguerSellingWindow.style.display = "initial";
    /*categoryWindow.style.display = "none";*/
}