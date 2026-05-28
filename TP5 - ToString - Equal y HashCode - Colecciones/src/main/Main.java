package main;

import java.util.HashSet;
import java.util.Set;

import main.domain.Categoria;
import main.domain.Pedido;
import main.domain.Producto;
import main.domain.Usuario;
import main.domain.enums.FormaPago;
import main.domain.enums.Rol;

public class Main {
    public static void main(String[] args) {

        // 3 Categorias
        Categoria catElectro = new Categoria(1L, "Electrodomésticos", "Artículos para el hogar");
        Categoria catTecno = new Categoria(2L, "Tecnología", "Dispositivos móviles y hardware");
        Categoria catBazar = new Categoria(3L, "Bazar", "Cosas de cocina");

        // 10 Productos
        Producto p1 = new Producto(1L, "Televisor 4K", 450000.0, "Smart TV 50 pulgadas", 10, "tv.png", true);
        catTecno.addProducto(p1);
        Producto p2 = new Producto(2L, "Lavarropas", 600000.0, "Carga frontal 8kg", 5, "lavarropas.png", true);
        catElectro.addProducto(p2);
        Producto p3 = new Producto(3L, "Microondas", 150000.0, "Digital con grill", 12, "micro.png", true);
        catElectro.addProducto(p3);
        Producto p4 = new Producto(4L, "Celular S20 FE", 350000.0, "Samsung 128GB", 8, "s20.png", true);
        catTecno.addProducto(p4);
        Producto p5 = new Producto(5L, "Notebook", 950000.0, "Intel i5 16GB RAM", 4, "notebook.png", true);
        catTecno.addProducto(p5);
        Producto p6 = new Producto(6L, "Auriculares Bluetooth", 450000.0, "Cancelación de ruido", 25, "auriculares.png", true);
        catTecno.addProducto(p6);
        Producto p7 = new Producto(7L, "Monitor 24'", 180000.0, "Full HD 75Hz", 7, "monitor.png", true);
        catTecno.addProducto(p7);
        Producto p8 = new Producto(8L, "Sartén Antiadherente", 35000.0, "24 cm de teflón", 40, "sarten.png", true);
        catBazar.addProducto(p8);
        Producto p9 = new Producto(9L, "Juego de Vasos x6", 12000.0, "Vidrio templado", 50, "vasos.png", true);
        catBazar.addProducto(p9);
        Producto p10 = new Producto(10L, "Pava Eléctrica", 28000.0, "Corte mate automatico", 15, "pava.png", true);
        catElectro.addProducto(p10);

        // 2 Usuarios
        Usuario user1 = new Usuario(1L, "Santiago", "Caiciia", "scaiciia@mail.com", "11223344", "1234", Rol.ADMIN);
        Usuario user2 = new Usuario(2L, "Juan", "Pérez", "jperez@mail.com", "55667788", "abcd", Rol.USUARIO);

        // 3 Pedidos (2 detalles por pedido)
        Pedido ped1 = new Pedido(101L, FormaPago.TARJETA);
        ped1.addDetallePedido(1, p4);
        ped1.addDetallePedido(2, p6);

        Pedido ped2 = new Pedido(102L, FormaPago.EFECTIVO);
        ped2.addDetallePedido(1, p10);
        ped2.addDetallePedido(6, p9);

        Pedido ped3 = new Pedido(103L, FormaPago.TRANSFERENCIA);
        ped3.addDetallePedido(1, p5);
        ped3.addDetallePedido(1, p7);

        user1.addPedido(ped1);
        user2.addPedido(ped2);
        user2.addPedido(ped3);

        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(user1);
        usuarios.add(user2);
    }
}
