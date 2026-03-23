package app;

import java.util.Scanner;
import shop.ClothingItem;
import shop.Inventory;
import sales.SalesRegister;

public class Main {
    public static void main(String[] args) {
    	
        Scanner tec = new Scanner(System.in);
        Inventory miTienda = new Inventory(100);
        int opcion = 0;

        System.out.println("--- BIENVENIDO A LA GESTIÓN DE TIENDA ---");

        //Menu
        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Añadir prenda al inventario");
            System.out.println("2. Ver inventario completo");
            System.out.println("3. Vender una prenda");
            System.out.println("4. Ver balance de ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = tec.nextInt();
            tec.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la prenda: ");
                    String nombre = tec.nextLine();
                    System.out.print("Precio: ");
                    double precio = tec.nextDouble();
                    System.out.print("Talla (S, M, L): ");
                    char talla = tec.next().toUpperCase().charAt(0);
                    
                    ClothingItem nuevaPrenda = new ClothingItem(nombre, precio, talla);
                    miTienda.addItem(nuevaPrenda);
                    System.out.println("Prenda añadida correctamente.");
                    break;

                case 2:

                    System.out.println(miTienda.toString());
                    break;

                case 3:
                    System.out.print("Nombre de la prenda a vender: ");
                    String nomVenta = tec.nextLine();
                    System.out.print("Talla: ");
                    char tallaVenta = tec.next().toUpperCase().charAt(0);
                    
                    SalesRegister.processSale(miTienda, nomVenta, tallaVenta);
                    break;

                case 4:
                    System.out.println("--- BALANCE DE CAJA ---");
                    System.out.println("Artículos vendidos: " + SalesRegister.getTotalSalesCount());
                    System.out.println("Total recaudado: " + SalesRegister.getTotalSalesAmount() + "€");
                    break;

                case 5:
                    System.out.println("Cerrando sistema... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 5);

        tec.close();
    }
}