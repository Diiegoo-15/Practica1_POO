package test;

import cart.CartItem;
import cart.LinkedCart;
import shop.ClothingItem;
import shop.Inventory;

public class TestLinkedCart {

	public static void checkLinkedCart() {
		double totalScore = 0.0;

		System.out.println("Verifying the LinkedCart class.");

		totalScore += testIsEmpty();
		totalScore += testSize();
		totalScore += testFind();
		totalScore += testInsert();
		totalScore += testRemove();

		System.out.println("Total Score TestLinkedCart: " + totalScore + " / 10.0\n");
	}

	private static double testIsEmpty() {
		double score = 0.0;

		System.out.println("Testing isEmpty method...");

		LinkedCart linkedCart = new LinkedCart();

		// Check if cart is initially empty
		if (linkedCart.isEmpty()) {
			System.out.println("isEmpty test passed: cart is initially empty.");
			score += 1.0; // 2 puntos por el éxito del test
		} else {
			System.out.println("ERROR: isEmpty test failed - cart is not initially empty.");
		}

		return score;
	}

	private static double testSize() {
		double score = 0.0;
		System.out.println("Testing size method...");
		LinkedCart linkedCart = new LinkedCart();
		if (linkedCart.size() == 0) {
			System.out.println("size test passed: initial size is 0.");
			score += 1.0; // 2 puntos por el éxito del test
		} else {
			System.out.println("ERROR: size test failed - initial size is not 0.");
		}

		return score;
	}

	private static double testFind() {
		double score = 0.0;
		System.out.println("Testing find method...");
		LinkedCart linkedCart = new LinkedCart();
		int index = linkedCart.find("Shirt", 'M');
		if (index == -1) {
			System.out.println("find test passed: item not found in empty cart.");
			score += 2.0; // 2 puntos por el éxito del test
		} else {
			System.out.println("ERROR: find test failed - item found in empty cart.");
		}
		ClothingItem item = new ClothingItem("Shirt", 19.99, 'M');
		linkedCart.insert(0, new CartItem(item, 1));
		index = linkedCart.find("Shirt", 'M');
		if (index == 0) {
			System.out.println("find test passed: item found after insertion.");
			score += 2.0; // 2 puntos por el éxito del test
		} else {
			System.out.println("ERROR: find test failed - item not found after insertion.");
		}

		return score;
	}

	private static double testInsert() {
		double score = 0.0;
		System.out.println("Testing insert method...");
		LinkedCart linkedCart = new LinkedCart();
		ClothingItem item = new ClothingItem("Shirt", 19.99, 'M');
		linkedCart.insert(0, new CartItem(item, 1));
		if (linkedCart.size() == 1) {
			System.out.println("insert test passed: item inserted and size increased.");
			score += 2.0; // 2 puntos por el éxito del test
		} else {
			System.out.println("ERROR: insert test failed - item not inserted or size not increased.");
		}

		return score;
	}

	private static double testRemove() {
		double score = 0.0;
		System.out.println("Testing remove method...");
		LinkedCart linkedCart = new LinkedCart();
		ClothingItem item = new ClothingItem("Shirt", 19.99, 'M');
		linkedCart.insert(0, new CartItem(item, 1));
		linkedCart.remove(0);
		if (linkedCart.size() == 0) {
			System.out.println("remove test passed: item removed and size decreased.");
			score += 2.0; // 2 puntos por el éxito del test
		} else {
			System.out.println("ERROR: remove test failed - item not removed or size not decreased.");
		}
		return score;
	}
}
