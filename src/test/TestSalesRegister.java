package test;

import shop.ClothingItem;
import shop.Inventory;
import sales.SalesRegister;

public class TestSalesRegister {

    public static void checkSalesRegister() {
        double totalScore = 0.0;

        System.out.println("Verificando la clase SalesRegister.");

        totalScore += testProcessSale();
        totalScore += testGetTotalSalesCount();
        totalScore += testGetTotalSalesAmount();
        totalScore += testGetBalance();

        System.out.println("Puntuación Total test.TestSalesRegister: " + totalScore + " / 10.0\n");
    }

    private static double testProcessSale() {
        double score = 0.0;

        System.out.println("Probando el método processSale...");

        // Crear una instancia de Inventory
        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 29.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Procesar una venta
        ClothingItem soldItem = SalesRegister.processSale(inventory, "Camisa", 'M');

        // Verificar que se devuelve un artículo válido
        if (soldItem != null) {
            System.out.println("Prueba de processSale pasada: venta procesada exitosamente.");
            score += 2.5; // 2.5 punto por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de processSale falló - venta no procesada.");
        }

        return score;
    }

    private static double testGetTotalSalesCount() {
        double score = 0.0;

        System.out.println("Probando el método getTotalSalesCount...");

        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 29.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Restablecer totalSalesCount para fines de prueba
        SalesRegister.resetTotalSalesCount();

        // Verificar si getTotalSalesCount devuelve el valor correcto después de procesar una venta
        SalesRegister.processSale(inventory, "Camisa", 'M');
        long totalSalesCount = SalesRegister.getTotalSalesCount();

        // Verificar que totalSalesCount es correcto
        if (totalSalesCount == 1) {
            System.out.println("Prueba de getTotalSalesCount pasada: conteo correcto.");
            score += 2.5; // 2.5 punto por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de getTotalSalesCount falló - conteo incorrecto.");
        }

        return score;
    }

    private static double testGetTotalSalesAmount() {
        double score = 0.0;

        System.out.println("Probando el método getTotalSalesAmount...");

        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 29.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Restablecer totalSalesAmount para fines de prueba
        SalesRegister.resetTotalSalesAmount();

        // Verificar si getTotalSalesAmount devuelve el valor correcto después de procesar una venta
        SalesRegister.processSale(inventory, "Camisa", 'M');
        double totalSalesAmount = SalesRegister.getTotalSalesAmount();

        // Verificar que totalSalesAmount es correcto
        if (totalSalesAmount == 29.99) {
            System.out.println("Prueba de getTotalSalesAmount pasada: monto correcto.");
            score += 2.5; // 2.5 puntos por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de getTotalSalesAmount falló - monto incorrecto.");
        }

        return score;
    }

    private static double testGetBalance() {
        double score = 0.0;

        System.out.println("Probando el método getBalance...");

        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 29.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Restablecer totalSalesCount y totalSalesAmount para fines de prueba
        SalesRegister.resetTotalSalesCount();
        SalesRegister.resetTotalSalesAmount();

        // Procesar una venta
        SalesRegister.processSale(inventory, "Camisa", 'M');

        // Obtener el saldo
        String balance = SalesRegister.getBalance();

        // Verificar que el saldo contiene la información correcta
        if (balance.contains("1") && balance.contains("29.99")) {
            System.out.println("Prueba de getBalance pasada: balance correcto.");
            score += 2.5; // 2.5 puntos por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de getBalance falló - balance incorrecto.");
        }

        return score;
    }
}