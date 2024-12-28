document.addEventListener("DOMContentLoaded", () => {
    showCategories()
});

async function showCategories() {
    try {
        const categoriesResponse = await fetch("http://localhost:8080/Burguer/controller?ACTION=category.getall");
        const categoriesData = await categoriesResponse.json();

        const categoryFlex = document.querySelector("#categories > .flex");
        categoryFlex.innerHTML = ""; // Limpiar el contenedor antes de agregar elementos

        // Agregar la tarjeta para "All"
        const allCard = document.createElement("div");
        allCard.className = "card";
        allCard.innerHTML = `
        <div onclick="showBurguerSelling(); navigateToCategoryItems();" style="cursor: pointer;">
        <img src="./img/All.png" style="width: 100%; height: 50%; margin-top: 25%; color=white;" alt="All">
        <p style="color:white;">All</p>
        </div>
    
        `;
        categoryFlex.appendChild(allCard);

        // Agregar tarjetas para las categorías obtenidas
        for (const category of categoriesData) {
            const card = document.createElement("div");
            card.className = "card";
            card.innerHTML = `
            <div onclick="showBurguerSelling('${category.id}'); navigateToCategoryItems();" style="cursor: pointer;">
            <img src="${category.img}" style="width: 100%; height: 50%; margin-top: 25%;" alt="Imagen de ${category.name}">
            <p style="color:white;">${category.name}</p>

            </div>
        
            `;
            categoryFlex.appendChild(card);
        }
    } catch (error) {
        console.error("Error al obtener categorías:", error);
    }
}

// Llamar a la función para mostrar las categorías
showCategories();




function navigateToCategoryItems() {
    const viewportHeight = window.innerHeight || document.documentElement.clientHeight;
    let scrollPosition;

    if (window.innerWidth <= 768) {
        scrollPosition = viewportHeight + 500;
    } else {
        scrollPosition = viewportHeight + 750;
    }

    const scrollOptions = {
        top: scrollPosition,
        behavior: 'smooth'
    };

    document.body.classList.add('blur');

    window.scrollTo(scrollOptions);

    setTimeout(function() {
        document.body.classList.remove('blur');
    }, 2000);
}
