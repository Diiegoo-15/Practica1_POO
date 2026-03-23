package sales;

import shop.Inventory;
import shop.ClothingItem;

public class SalesRegister {
   
    private static long totalSalesCount = 0;  
    private static double totalSalesAmount = 0; 

    public static long getTotalSalesCount() {
        return totalSalesCount;
    }

    public static double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public static void processSale(Inventory inventory, String name, char size) {
       
        ClothingItem item = inventory.extractItem(name, size);

        if (item != null) {
            totalSalesCount++; 
            totalSalesAmount += item.getPrice(); 
            System.out.println("Venta procesada: " + item.getName() + " vendida con éxito.");
        } else {
            System.out.println("Error: No hay stock de " + name + " (Talla " + size + ")");
        }
    }
}