package app;

import java.util.Scanner;
import shop.ClothingItem;
import shop.Inventory;
import sales.SalesRegister;
import sales.ShoppingRegister;
import test.TestLinkedCart;
import test.TestShoppingRegister;

public class Main {
    public static void main(String[] args) {
   
        Scanner tec = new Scanner(System.in); 
        Inventory inventory = new Inventory(100);
        ShoppingRegister shoppingRegister = new ShoppingRegister();
        int opcion = 0;

        System.out.println("Ejecutando verificadores...");
        TestLinkedCart.checkLinkedCart();
        TestShoppingRegister.checkShoppingRegister();

        System.out.println("*** Bienvenido a Strafalarius ***");

        do {
            // Menú 
            System.out.println("\nSeleccione opción:");
            System.out.println("1. Agregar nueva prenda al inventario");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Procesar venta directa");
            System.out.println("4. Mostrar estadísticas de ventas");
            System.out.println("5. Agregar prenda al carrito");
            System.out.println("6. Eliminar prenda del carrito");
            System.out.println("7. Confirmar carrito de compra");
            System.out.println("8. Mostrar productos del carrito");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción (1-9): ");

            try {
                opcion = tec.nextInt();
                tec.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la prenda: ");
                        String nom = tec.nextLine();
                        System.out.print("Precio: ");
                        double pre = tec.nextDouble();
                        System.out.print("Talla (S, M, L): ");
                        char tal = tec.next().toUpperCase().charAt(0);
                        inventory.addItem(new ClothingItem(nom, pre, tal));
                        System.out.println("Prenda añadida al inventario.");
                        break;

                    case 2:
                        System.out.println(inventory.toString());
                        break;

                    case 3:
                        System.out.print("Nombre de la prenda: ");
                        String nV = tec.nextLine();
                        System.out.print("Talla: ");
                        char tV = tec.next().toUpperCase().charAt(0);
                        SalesRegister.processSale(inventory, nV, tV);
                        break;

                    case 4:
                        System.out.println(SalesRegister.getBalance());
                        break;

                    case 5: 
                        System.out.print("Nombre de la prenda: ");
                        String nC = tec.nextLine();
                        System.out.print("Talla: ");
                        char tC = tec.next().toUpperCase().charAt(0);
                        System.out.print("Cantidad de unidades: ");
                        int cantA = tec.nextInt();
                        shoppingRegister.addToCart(inventory, nC, tC, cantA);
                        break;

                    case 6: 
                        System.out.print("Nombre de la prenda: ");
                        String nR = tec.nextLine();
                        System.out.print("Talla: ");
                        char tR = tec.next().toUpperCase().charAt(0);
                        System.out.print("Cantidad a eliminar: ");
                        int cantR = tec.nextInt();
                        shoppingRegister.removeFromCart(inventory, nR, tR, cantR);
                        break;

                    case 7: 
                        shoppingRegister.confirmCart(inventory);
                        break;

                    case 8: 
                        shoppingRegister.showCart();
                        break;

                    case 9:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada de datos. Reintentando...");
                tec.nextLine(); 
            }
        } while (opcion != 9);

        tec.close(); 
    }
}