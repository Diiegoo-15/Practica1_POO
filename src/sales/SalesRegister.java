package sales;

import shop.Inventory;
import shop.ClothingItem;

public class SalesRegister {
    private static long totalSalesCount = 0;
    private static double totalSalesAmount = 0;

    public static long getTotalSalesCount() { return totalSalesCount; }
    public static double getTotalSalesAmount() { return totalSalesAmount; }

    public static void resetTotalSalesCount() { totalSalesCount = 0; }
    public static void resetTotalSalesAmount() { totalSalesAmount = 0; }

    public static ClothingItem processSale(Inventory inventory, String name, char size) {
        ClothingItem item = inventory.extractItem(name, size);
        if (item != null) {
            totalSalesCount++;
            totalSalesAmount += item.getPrice();
        }
        return item; 
    }

    public static String getBalance() {
        return "Ventas: " + totalSalesCount + " | Total: " + totalSalesAmount;
    }
}