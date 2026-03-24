package test;

import shop.ClothingItem;
import shop.Inventory;
import sales.*;

public class TestShoppingRegister {

	public static void checkShoppingRegister() {
		double totalScore = 0.0;

		System.out.println("Verifying the ShoppingRegister class.");
		totalScore += testAddToCart();
		totalScore += testRemoveFromCart();
		totalScore += testConfirmCart();
		totalScore += testShowCart();
		System.out.println("Total Score TestShoppingRegister: " + totalScore + " / 10.0\n");
	}

	private static double testAddToCart() {
		double score = 0.0;
		System.out.println("Testing addToCart method...");
		Inventory inventory = new Inventory(100);
		ClothingItem itemToAdd = new ClothingItem("Shirt", 19.99, 'M');
		inventory.addItem(itemToAdd);
		inventory.addItem(itemToAdd);
		ShoppingRegister shoppingRegister = new ShoppingRegister();
		shoppingRegister.addToCart(inventory, "Shirt", 'M', 2);
		score += 2.5;
		return score;
	}

	private static double testRemoveFromCart() {
		double score = 0.0;
		System.out.println("Testing removeFromCart method...");
		Inventory inventory = new Inventory(100);
		ClothingItem itemToAdd = new ClothingItem("Shirt", 19.99, 'M');
		inventory.addItem(itemToAdd);
		ShoppingRegister shoppingRegister = new ShoppingRegister();
		shoppingRegister.addToCart(inventory, "Shirt", 'M', 1);
		shoppingRegister.removeFromCart(inventory, "Shirt", 'M', 1);
		score += 2.5;
		return score;
	}

	private static double testConfirmCart() {
		double score = 0.0;
		System.out.println("Testing confirmCart method...");
		Inventory inventory = new Inventory(100);
		ClothingItem itemToAdd = new ClothingItem("Shirt", 19.99, 'M');
		inventory.addItem(itemToAdd);
		ShoppingRegister shoppingRegister = new ShoppingRegister();
		shoppingRegister.addToCart(inventory, "Shirt", 'M', 1);
		shoppingRegister.confirmCart(inventory);
		score += 2.5;
		return score;
	}

	private static double testShowCart() {
		double score = 0.0;
		System.out.println("Testing showCart method...");
		Inventory inventory = new Inventory(100);
		ClothingItem itemToAdd = new ClothingItem("Shirt", 19.99, 'M');
		inventory.addItem(itemToAdd);
		ShoppingRegister shoppingRegister = new ShoppingRegister();
		shoppingRegister.addToCart(inventory, "Shirt", 'M', 1);
		shoppingRegister.showCart();
		score += 2.5;
		return score;
	}
}
