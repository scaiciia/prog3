const listaCategorias = document.getElementById("lista-categorias");
const contenedorProductos = document.getElementById("contenedor-productos");

function cargarCategorias() {
    categorias.forEach(cat => {
        const li = document.createElement("li");
        li.innerHTML = `<a href=# >${cat}</a>`;
        listaCategorias.appendChild(li);
    });
}

function cargarProductos() {
    productos.forEach(prod => {
        const articulo = document.createElement("article");
        articulo.className = "prod-destacado";
        const contenedorImg = document.createElement("div");
        contenedorImg.className = "contenedorImg";
        const img = document.createElement("img");
        img.src = prod.imagen;
        img.alt = prod.descripcion;
        contenedorImg.appendChild(img);
        const contenedorInfo = document.createElement("div");
        contenedorInfo.className = "contenedorInfo";
        const nomProd = document.createElement("h3");
        nomProd.textContent = prod.nombre;
        const desc = document.createElement("p");
        desc.textContent = prod.descripcion;
        const precio = document.createElement("p");
        precio.innerHTML = `$<strong>${prod.precio}</strong>`;
        contenedorInfo.append(nomProd, desc, precio);
        const contenedorBotones = document.createElement("div");
        contenedorBotones.className = "contenedorBtn";
        const verDetalles = document.createElement("button");
        verDetalles.textContent = "Ver Detalles";
        const agregarCarrito = document.createElement("button");
        agregarCarrito.textContent = "Agregar al Carrito";
        contenedorBotones.append(verDetalles, agregarCarrito);
        articulo.append(contenedorImg, contenedorInfo, contenedorBotones);
        contenedorProductos.appendChild(articulo);
    });
}

document.addEventListener("DOMContentLoaded", function(){
    cargarCategorias();
    cargarProductos();
});