package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class TestClothingItem {

    public static void checkClass(Class<?> clazz) {
        double totalScore = 0.0;

        System.out.println("Verificando la clase: " + clazz.getName());

        totalScore += checkConstructors(clazz);
        totalScore += checkFields(clazz);
        totalScore += checkGettersAndSetters(clazz);
        totalScore += checkToStringMethod(clazz);
        totalScore += checkPrivateFields(clazz);

        System.out.println("Puntuación total test.TestClothingItem: " + totalScore + " / 10.0\n");
    }

    private static double checkConstructors(Class<?> clazz) {
        double score = 0.0;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        if (constructors.length != 1) {
            System.out.println("ERROR: La clase debe tener exactamente un constructor.");
        } else {
            System.out.println("Constructor verificado.");
            score += 1.0; // 1 punto por el constructor
        }

        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        if (parameterTypes.length != 3) {
            System.out.println("ERROR: El constructor debe tener exactamente tres parámetros.");
        } else {
            System.out.println("Parámetros del constructor verificados.");
            score += 1.0; // 1 punto por cada parámetro
        }

        return score;
    }

    private static double checkFields(Class<?> clazz) {
        double score = 0.0;
        Field[] fields = clazz.getDeclaredFields();

        List<String> expectedFieldNames = List.of("name", "price", "size");

        for (Field field : fields) {
            if (!expectedFieldNames.contains(field.getName())) {
                System.out.println("ERROR: Campo inesperado en la clase - " + field.getName());
            }
        }

        System.out.println("Atributos verificados.");
        score += 2.0; // 2 puntos por los atributos

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
                Method setter = clazz.getMethod("set" + capitalizedFieldName, field.getType());

                System.out.println("Getter y setter verificados para: " + fieldName);
                score += 1.0; // 1.5 puntos por cada getter y setter
            } catch (NoSuchMethodException e) {
                System.out.println("ERROR: Falta getter o setter para el campo - " + fieldName);
            }
        }
        if (score>=2.0)
            return 2.0;
        else
            return score;

    }

    private static double checkToStringMethod(Class<?> clazz) {
        double score = 0.0;

        try {
            Method toStringMethod = clazz.getMethod("toString");
            System.out.println("Método toString verificado.");
            score += 2.0; // 1.5 puntos por el método toString
        } catch (NoSuchMethodException e) {
            System.out.println("ERROR: Falta el método toString en la clase.");
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
        score += 2.0; // 2.0 puntos por los atributos privados

        return score;
    }
}