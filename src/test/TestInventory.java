package test;

import shop.ClothingItem;
import shop.Inventory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


public class TestInventory {

    public static void checkClass(Class<?> clazz) {
        double totalScore = 0.0;

        System.out.println("Verificando la clase: " + clazz.getName());

        totalScore += checkConstructors(clazz);
        totalScore += checkFields(clazz);
        totalScore += checkGettersAndSetters(clazz);
        totalScore += checkMethods(clazz);
        totalScore += checkPrivateFields(clazz);

        totalScore += testAddItem();
        totalScore += testCheckStock();
        totalScore += testRemoveItem();
        totalScore += testExtractItem();

        System.out.println("Puntuación Total test.TestInventory: " + totalScore + " / 10.0\n");
    }

    private static double checkConstructors(Class<?> clazz) {
        double score = 0.0;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        if (constructors.length != 1) {
            System.out.println("ERROR: La clase debería tener exactamente un constructor.");
        } else {
            System.out.println("Constructor verificado.");
            score += 1.0; // 2 puntos por el constructor
        }

        return score;
    }

    private static double checkFields(Class<?> clazz) {
        double score = 0.0;
        Field[] fields = clazz.getDeclaredFields();

        List<String> expectedFieldNames = List.of("items", "itemLength", "MAX_SIZE");

        for (Field field : fields) {
            if (!expectedFieldNames.contains(field.getName())) {
                System.out.println("ERROR: Campo inesperado en la clase - " + field.getName());
            }
        }

        System.out.println("Atributos verificados.");
        score += 1.0; // 2 puntos por los atributos

        return score;
    }

    private static double checkGettersAndSetters(Class<?> clazz) {
        double score = 0.0;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            String capitalizedFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            try {
                Method getter = clazz.getMethod("get" + capitalizedFieldName);
                if (!java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                    Method setter = clazz.getMethod("set" + capitalizedFieldName, field.getType());
                    System.out.println("Getter y setter verificados para: " + fieldName);
                    score += 1.5; // 1.5 puntos por cada getter y setter
                } else {
                    System.out.println("Getter verificado para el campo constante: " + fieldName);
                    score += 1.0; // 1 punto por getter de campo constante
                }
            } catch (NoSuchMethodException e) {
                System.out.println("ERROR: Falta getter o setter para el campo - " + fieldName + " " + e.toString());
            }
        }

        if (score >= 2.0)
            return 2.0;
        else
            return score;
    }

    private static double checkMethods(Class<?> clazz) {
        double score = 0.0;

        try {
            Method getItemCountMethod = clazz.getMethod("getItemCount");
            Method addItemMethod = clazz.getMethod("addItem", ClothingItem.class);
            Method checkStockMethod = clazz.getMethod("checkStock", String.class, char.class);
            Method removeItemMethod = clazz.getMethod("removeItem", String.class, char.class);
            Method removeExtractMethod = clazz.getMethod("extractItem", String.class, char.class);
            Method toStringMethod = clazz.getMethod("toString");

            System.out.println("Métodos verificados.");
            score += 1.0; // 1 punto por cada método requerido
        } catch (NoSuchMethodException e) {
            System.out.println("ERROR: Falta uno o más métodos requeridos." + e.toString());
        }

        return score;
    }

    private static double checkPrivateFields(Class<?> clazz) {
        double score = 0.0;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (!java.lang.reflect.Modifier.isPrivate(field.getModifiers())) {
                System.out.println("ERROR: El campo no es privado - " + field.getName());
            }
        }

        System.out.println("Atributos privados verificados.");
        score += 1.0; // 1.0 puntos por los atributos privados

        return score;
    }

    private static double testAddItem() {
        double score = 0.0;

        System.out.println("Probando el método addItem...");

        // Crear una instancia de Inventory
        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 19.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Verificar que itemLength ha aumentado
        if (inventory.getItemCount() == 1) {
            System.out.println("Prueba de addItem pasada: artículo añadido exitosamente.");
            score += 1.0; // 1 punto por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de addItem falló - artículo no añadido.");
        }

        return score;
    }

    private static double testCheckStock() {
        double score = 0.0;

        System.out.println("Probando el método checkStock...");

        // Crear una instancia de Inventory
        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 19.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Comprobar si el artículo está en stock
        int stockCount = inventory.checkStock("Camisa", 'M');

        // Verificar que el recuento de stock es correcto
        if (stockCount == 1) {
            System.out.println("Prueba de checkStock pasada: artículo encontrado en stock.");
            score += 1.0; // 1 punto por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de checkStock falló - artículo no encontrado en stock.");
        }

        return score;
    }

    private static double testRemoveItem() {
        double score = 0.0;

        System.out.println("Probando el método removeItem...");

        // Crear una instancia de Inventory
        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 19.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Eliminar el artículo del inventario
        inventory.removeItem("Camisa", 'M');

        // Verificar que itemLength ha disminuido
        if (inventory.getItemCount() == 0) {
            System.out.println("Prueba de removeItem pasada: artículo eliminado exitosamente.");
            score += 1.0; // 1 punto por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de removeItem falló - artículo no eliminado.");
        }

        return score;
    }


    private static double testExtractItem() {
        double score = 0.0;

        System.out.println("Probando el método extractItem...");

        // Crear una instancia de Inventory
        Inventory inventory = new Inventory(100);

        // Crear un ClothingItem para añadir al inventario
        ClothingItem itemToAdd = new ClothingItem("Camisa", 19.99, 'M');

        // Añadir el artículo al inventario
        inventory.addItem(itemToAdd);

        // Extraer el artículo del inventario
        ClothingItem extractedItem = inventory.extractItem("Camisa", 'M');

        // Verificar que itemLength ha disminuido
        if (inventory.getItemCount() == 0) {
            System.out.println("Prueba de extractItem pasada: artículo extraído exitosamente.");
            score += 1.0; // 1 punto por el éxito del test
        } else {
            System.out.println("ERROR: La prueba de extractItem falló - artículo no extraído.");
        }

        return score;
    }
}