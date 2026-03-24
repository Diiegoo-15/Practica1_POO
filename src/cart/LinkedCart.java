package cart;

public class LinkedCart {
    
    private CartItemNode first; 
    private int size;           

    // 1. Constructor: inicializa una lista vacía
    public LinkedCart() {
        this.first = null;
        this.size = 0;
    }
    
    // Comprobar si la lista está vacía 
    public boolean isEmpty() {
        return first == null;
    }

    // Obtener el número de elementos 
    public int size() {
        return size;
    }

    // Buscar posición por nombre y talla 
    public int find(String itemName, char size) {
        CartItemNode current = first;
        for (int i = 0; i < this.size; i++) {
            CartItem item = current.getData();
            if (item.getClothingItem().getName().equals(itemName) && 
                item.getClothingItem().getSize() == size) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    // Sobrecarga: buscar y devolver el CartItem en una posición dada 
    public CartItem find(int index) {
        if (index < 0 || index >= size) return null;
        
        CartItemNode current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Insertar un elemento en la posición i
    public void insert(int index, CartItem item) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            // Insertar al principio
            first = new CartItemNode(item, first);
        } else {
            CartItemNode prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            CartItemNode newNode = new CartItemNode(item, prev.getNext());
            prev.setNext(newNode);
        }
        size++;
    }

    // Eliminar el elemento de la posición i y devolverlo 
    public CartItem remove(int index) {
        if (index < 0 || index >= size) return null;

        CartItem removedData;
        if (index == 0) {
            removedData = first.getData();
            first = first.getNext();
        } else {
            CartItemNode prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            removedData = prev.getNext().getData();
            prev.setNext(prev.getNext().getNext());
        }
        size--;
        return removedData;
    }
}