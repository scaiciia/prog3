package com.utn;

import com.utn.entities.*;
import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_DB");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            System.out.println("=========================================================================");
            System.out.println("4 - Instanciar y Persistir");
            // 1. Instanciar y Persistir 3 Categorías
            Categoria catElectro = Categoria.builder()
                    .nombre("Electrodomésticos")
                    .descripcion("Artículos para el hogar")
                    .build();

            Categoria catTecno = Categoria.builder()
                    .nombre("Tecnología")
                    .descripcion("Dispositivos móviles y hardware")
                    .build();

            Categoria catBazar = Categoria.builder()
                    .nombre("Bazar")
                    .descripcion("Cosas de cocina y decoración")
                    .build();

            // 2. Instanciar y Persistir 10 Productos
            Producto p1 = Producto.builder()
                    .nombre("Televisor 4K")
                    .precio(450000.0)
                    .descripcion("Smart TV 50 pulgadas")
                    .stock(10)
                    .imagen("tv.png")
                    .disponible(true)
                    .categoria(catTecno)
                    .build();
            em.persist(p1);

            Producto p2 = Producto.builder()
                    .nombre("Lavarropas")
                    .precio(600000.0)
                    .descripcion("Carga frontal 8kg")
                    .stock(5)
                    .imagen("lavarropas.png")
                    .disponible(true)
                    .categoria(catElectro)
                    .build();
            em.persist(p2);

            Producto p3 = Producto.builder()
                    .nombre("Microondas")
                    .precio(150000.0)
                    .descripcion("Digital con grill")
                    .stock(12)
                    .imagen("micro.png")
                    .disponible(true)
                    .categoria(catElectro)
                    .build();
            em.persist(p3);

            Producto p4 = Producto.builder()
                    .nombre("Celular S20 FE")
                    .precio(350000.0)
                    .descripcion("Samsung 128GB")
                    .stock(8)
                    .imagen("s20.png")
                    .disponible(true)
                    .categoria(catTecno)
                    .build();
            em.persist(p4);

            Producto p5 = Producto.builder()
                    .nombre("Notebook")
                    .precio(950000.0)
                    .descripcion("Intel i5 16GB RAM")
                    .stock(4)
                    .imagen("notebook.png")
                    .disponible(true)
                    .categoria(catTecno)
                    .build();
            em.persist(p5);

            Producto p6 = Producto.builder()
                    .nombre("Auriculares Bluetooth")
                    .precio(85000.0)
                    .descripcion("Cancelación de ruido")
                    .stock(25)
                    .imagen("auriculares.png")
                    .disponible(true)
                    .categoria(catTecno)
                    .build();
            em.persist(p6);

            Producto p7 = Producto.builder()
                    .nombre("Monitor 24'")
                    .precio(180000.0)
                    .descripcion("Full HD 75Hz")
                    .stock(7)
                    .imagen("monitor.png")
                    .disponible(true)
                    .categoria(catTecno)
                    .build();
            em.persist(p7);

            Producto p8 = Producto.builder()
                    .nombre("Sartén Antiadherente")
                    .precio(35000.0)
                    .descripcion("24 cm de teflón")
                    .stock(40)
                    .imagen("sarten.png")
                    .disponible(true)
                    .categoria(catBazar)
                    .build();
            em.persist(p8);

            Producto p9 = Producto.builder()
                    .nombre("Juego de Vasos x6")
                    .precio(12000.0)
                    .descripcion("Vidrio templado")
                    .stock(50)
                    .imagen("vasos.png")
                    .disponible(true)
                    .categoria(catBazar)
                    .build();
            em.persist(p9);

            Producto p10 = Producto.builder()
                    .nombre("Pava Eléctrica")
                    .precio(28000.0)
                    .descripcion("Corte automático")
                    .stock(15)
                    .imagen("pava.png")
                    .disponible(true)
                    .categoria(catElectro)
                    .build();
            em.persist(p10);

            em.getTransaction().commit();

            em.getTransaction().begin();

            // 3 Pedidos (al menos 2 detalles cada uno)
            Pedido ped1 = Pedido.builder()
                    .fecha(LocalDate.now())
                    .estado(Estado.TERMINADO)
                    .formaPago(FormaPago.TARJETA)
                    .build();
            ped1.addDetallePedido(1, p4);
            ped1.addDetallePedido(2, p6);

            Pedido ped2 = Pedido.builder()
                    .fecha(LocalDate.now())
                    .estado(Estado.CONFIRMADO)
                    .formaPago(FormaPago.EFECTIVO)
                    .build();
            ped2.addDetallePedido(1, p10);
            ped2.addDetallePedido(6, p9);

            Pedido ped3 = Pedido.builder()
                    .fecha(LocalDate.now())
                    .estado(Estado.PENDIENTE)
                    .formaPago(FormaPago.TRANSFERENCIA)
                    .build();
            ped3.addDetallePedido(1, p5);
            ped3.addDetallePedido(1, p7);

            // 2 Usuarios
            Usuario user1 = Usuario.builder()
                    .nombre("Santiago")
                    .apellido("Caiciia")
                    .mail("scaiciia@mail.com")
                    .celular("11223344")
                    .contrasena("1234")
                    .rol(Rol.ADMIN)
                    .build();
            user1.addPedido(ped1);

            Usuario user2 = Usuario.builder()
                    .nombre("Juan")
                    .apellido("Pérez")
                    .mail("jperez@mail.com")
                    .celular("55667788")
                    .contrasena("abcd")
                    .rol(Rol.USUARIO)
                    .build();
            user2.addPedido(ped2);
            user2.addPedido(ped3);

            em.persist(user1);
            em.persist(user2);

            em.getTransaction().commit();

            // 5. Actualizar al menos 2 productos

            em.getTransaction().begin();

            System.out.println("=========================================================================");
            System.out.println("5 - Actualizar al menos 2 productos\n");

            Producto prodActualizar1 = em.find(Producto.class, p1.getId());
            prodActualizar1.setPrecio(415000.0);
            em.merge(prodActualizar1);

            Producto prodActualizar2 = em.find(Producto.class, p2.getId());
            prodActualizar2.setStock(40);
            em.merge(prodActualizar2);

            em.getTransaction().commit();

            // 6. Buscar Usuario por id

            System.out.println("=========================================================================");
            System.out.println("6 - Buscar Usuario por id");

            Usuario userById = em.find(Usuario.class, user1.getId());
            System.out.println(userById.toString());

            System.out.println("=========================================================================");
            System.out.println("7 - Buscar Usuario por mail");

            String mailABuscar = "scaiciia@mail.com";
            Usuario userByEmail = em.createQuery("SELECT u FROM Usuario u WHERE u.mail = :mailDeseado", Usuario.class)
                    .setParameter("mailDeseado", mailABuscar)
                    .getSingleResult();

            System.out.println("Usuario: " + userByEmail.toString());

            System.out.println("=========================================================================");
            System.out.println("8 - Borrar 1 producto");

            Producto productoAEliminar = em.find(Producto.class, p3.getId());
            if (productoAEliminar != null) {
                em.remove(productoAEliminar);
                System.out.println("El producto '" + productoAEliminar.getNombre() + "' fue eliminado exitosamente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
