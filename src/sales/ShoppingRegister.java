package sales;

import shop.Inventory;
import shop.ClothingItem;
import cart.LinkedCart;
import cart.CartItem;

public class ShoppingRegister {
    
    private LinkedCart cart;

    // Constructor
    public ShoppingRegister() {
        this.cart = new LinkedCart();
    }

    //Añadir al carrito
    public void addToCart(Inventory inventory, String itemName, char size, int quantity) {
        
    	int stockDisponible = inventory.checkStock(itemName, size);
        
        if (stockDisponible < quantity) {
            System.out.println("Error: Stock insuficiente de " + itemName + ". Disponible: " + stockDisponible);
            return;
        }

        int indexEnCarrito = cart.find(itemName, size);
        
        if (indexEnCarrito != -1) {
            CartItem existente = cart.find(indexEnCarrito);
            existente.setUnits(existente.getUnits() + quantity);
        } else {
            ClothingItem item = inventory.extractItem(itemName, size);
            if (item != null) {
                CartItem nuevoNodo = new CartItem(item, quantity);
                cart.insert(0, nuevoNodo);
               
                for (int i = 0; i < quantity - 1; i++) {
                    inventory.extractItem(itemName, size);
                }
            } else {
                System.out.println("Producto no encontrado en el inventario.");
            }
        }
        System.out.println(quantity + " unidades de " + itemName + " añadidas al carrito.");
    }

    // Eliminar del carrito
    public void removeFromCart(Inventory inventory, String itemName, char size, int quantity) {
        int index = cart.find(itemName, size);
        
        if (index == -1) {
            System.out.println("El producto no está en el carrito.");
            return;
        }

        CartItem itemEnCarrito = cart.find(index);
        
        if (itemEnCarrito.getUnits() >= quantity) { 
            itemEnCarrito.setUnits(itemEnCarrito.getUnits() - quantity);
            
            for (int i = 0; i < quantity; i++) {
                inventory.addItem(itemEnCarrito.getClothingItem());
            }
            if (itemEnCarrito.getUnits() == 0) {
                cart.remove(index);
            }
            System.out.println("Eliminadas " + quantity + " unidades del carrito.");
        } else {
            System.out.println("Error: No tienes tantas unidades en el carrito.");
        }
    }

    // Mostrar carrito
    public void showCart() {
        if (cart.isEmpty()) { 
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("--- PRODUCTOS EN EL CARRITO ---");
            for (int i = 0; i < cart.size(); i++) {
                CartItem ci = cart.find(i); 
                System.out.println("- " + ci.getClothingItem().getName() + 
                                   " [" + ci.getClothingItem().getSize() + "] x" + 
                                   ci.getUnits() + " | Precio: " + 
                                   ci.getClothingItem().getPrice() + "€");
            }
        }
    }

    //Confirmar compra
    public void confirmCart(Inventory inventory) {
        if (cart.isEmpty()) {
            System.out.println("Nada que confirmar, el carrito está vacío.");
            return;
        }

        double totalPedido = 0;
        System.out.println("Confirmando compra...");

        while (!cart.isEmpty()) {
            CartItem item = cart.remove(0);
            double subtotal = item.getUnits() * item.getClothingItem().getPrice();
            totalPedido += subtotal;

            System.out.println("Procesando: " + item.getClothingItem().getName() + " x" + item.getUnits()); 

            for (int i = 0; i < item.getUnits(); i++) {
                SalesRegister.processSale(inventory, item.getClothingItem().getName(), item.getClothingItem().getSize());
            }
        }
        System.out.println("Compra finalizada. Costo total: " + totalPedido + "€");
    }
}
