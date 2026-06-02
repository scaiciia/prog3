package com.utn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.utn.dtos.UsuarioDTO;
import com.utn.entities.Categoria;
import com.utn.entities.Pedido;
import com.utn.entities.Producto;
import com.utn.entities.Usuario;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================================================");
        System.out.println("3 - Instanciaciones");

        // 3 Categorias
        Categoria catElectro = Categoria.builder()
                .id(1L)
                .nombre("Electrodomésticos")
                .descripcion("Artículos para el hogar")
                .build();

        Categoria catTecno = Categoria.builder()
                .id(2L)
                .nombre("Tecnología")
                .descripcion("Dispositivos móviles y hardware")
                .build();

        Categoria catBazar = Categoria.builder()
                .id(3L)
                .nombre("Bazar")
                .descripcion("Cosas de cocina y decoración")
                .build();

        // 10 Productos
        Producto p1 = Producto.builder()
                .id(1L).nombre("Televisor 4K").precio(450000.0)
                .descripcion("Smart TV 50 pulgadas").stock(10)
                .imagen("tv.png").disponible(true).build();
        catTecno.addProducto(p1);

        Producto p2 = Producto.builder()
                .id(2L).nombre("Lavarropas").precio(600000.0)
                .descripcion("Carga frontal 8kg").stock(5)
                .imagen("lavarropas.png").disponible(true).build();
        catElectro.addProducto(p2);

        Producto p3 = Producto.builder()
                .id(3L).nombre("Microondas").precio(150000.0)
                .descripcion("Digital con grill").stock(12)
                .imagen("micro.png").disponible(true).build();
        catElectro.addProducto(p3);

        Producto p4 = Producto.builder()
                .id(4L).nombre("Celular S20 FE").precio(350000.0)
                .descripcion("Samsung 128GB").stock(8)
                .imagen("s20.png").disponible(true).build();
        catTecno.addProducto(p4);

        Producto p5 = Producto.builder()
                .id(5L).nombre("Notebook").precio(950000.0)
                .descripcion("Intel i5 16GB RAM").stock(4)
                .imagen("notebook.png").disponible(true).build();
        catTecno.addProducto(p5);

        Producto p6 = Producto.builder()
                .id(6L).nombre("Auriculares Bluetooth").precio(85000.0)
                .descripcion("Cancelación de ruido").stock(25)
                .imagen("auriculares.png").disponible(true).build();
        catTecno.addProducto(p6);

        Producto p7 = Producto.builder()
                .id(7L).nombre("Monitor 24'").precio(180000.0)
                .descripcion("Full HD 75Hz").stock(7)
                .imagen("monitor.png").disponible(true).build();
        catTecno.addProducto(p7);

        Producto p8 = Producto.builder()
                .id(8L).nombre("Sartén Antiadherente").precio(35000.0)
                .descripcion("24 cm de teflón").stock(40)
                .imagen("sarten.png").disponible(true).build();
        catBazar.addProducto(p8);

        Producto p9 = Producto.builder()
                .id(9L).nombre("Juego de Vasos x6").precio(12000.0)
                .descripcion("Vidrio templado").stock(50)
                .imagen("vasos.png").disponible(true).build();
        catBazar.addProducto(p9);

        Producto p10 = Producto.builder()
                .id(10L).nombre("Pava Eléctrica").precio(28000.0)
                .descripcion("Corte automático").stock(15)
                .imagen("pava.png").disponible(true).build();
        catElectro.addProducto(p10);

        List<Producto> inventario = new ArrayList<>(
                List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)
        );

        // 2 Usuarios
        Usuario user1 = Usuario.builder()
                .id(1L).nombre("Santiago").apellido("Caiciia")
                .mail("scaiccia@mail.com").celular("11223344")
                .contraseña("1234").rol(Rol.ADMIN).build();

        Usuario user2 = Usuario.builder()
                .id(2L).nombre("Juan").apellido("Pérez")
                .mail("jperez@mail.com").celular("55667788")
                .contraseña("abcd").rol(Rol.USUARIO).build();

        // 3 Pedidos (al menos 2 detalles cada uno)
        Pedido ped1 = Pedido.builder()
                .id(101L).formaPago(FormaPago.TARJETA).build();
        ped1.addDetallePedido(1, p4);
        ped1.addDetallePedido(2, p6);

        Pedido ped2 = Pedido.builder()
                .id(102L).formaPago(FormaPago.EFECTIVO).build();
        ped2.addDetallePedido(1, p10);
        ped2.addDetallePedido(6, p9);

        Pedido ped3 = Pedido.builder()
                .id(103L).formaPago(FormaPago.TRANSFERENCIA).build();
        ped3.addDetallePedido(1, p5);
        ped3.addDetallePedido(1, p7);

        user1.addPedido(ped1);
        user2.addPedido(ped2);
        user2.addPedido(ped3);

        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(user1);
        usuarios.add(user2);

        System.out.println("=========================================================================");
        System.out.println("4 - Reportes por consola");
        System.out.println("Producto:");
        System.out.println(p4.toString());
        System.out.println("");
        System.out.println("Listado de productos cargados:");
        inventario.forEach(prod -> System.out.println(prod.toString()));
        System.out.println("");
        System.out.println("Pedidos del usuario con más compras:");
        Usuario usuarioConMasPedidos = user1.getPedidos().size() >= user2.getPedidos().size()
                ? user1 : user2;
        System.out.println("Usuario: " + usuarioConMasPedidos.toString());
        System.out.println("=========================================================================");
        System.out.println("5 - Instancia duplicada");
        Producto productoChino = Producto.builder()
                .id(4L)
                .nombre("Celular S20 FE")   // mismo id y nombre que p4
                .precio(999999.0)
                .descripcion("Replica china")
                .stock(3)
                .imagen("celuChino.png")
                .disponible(false)
                .build();

        // Comparar "productoChino" con todos los elementos de la colección de productos y mostrar los resultados por pantalla tal como dice la consigna.
        System.out.println("\nBuscando coincidencia: ");
        for(Producto prod : inventario) {
            if(prod.equals(productoChino)) {
                System.out.println("Producto: " + prod.toString() + " coincide con 'productoChino'.");
            } else {
                System.out.println("Producto: " + prod.toString() + " NO coincide con 'productoChino'.");
            }
        }

        System.out.println("=========================================================================");
        System.out.println("6 - UsuarioDTO");
        UsuarioDTO dto1 = UsuarioDTO.fromEntity(user1);
        System.out.println("Usuario1: " + dto1.toString());
        UsuarioDTO dto2 = UsuarioDTO.fromEntity(user2);
        System.out.println("Usuario2: " + dto2.toString());

    }
}
