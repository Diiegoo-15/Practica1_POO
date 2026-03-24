package cart;

public class CartItemNode {
    
    private CartItem data;      
    private CartItemNode next; 

    // Constructor 1: Nodo que no apunta a nadie
    public CartItemNode(CartItem data) {
        this.data = data;
        this.next = null;
    }

    // Constructor 2: Nodo que apunta a un nodo existente 
    public CartItemNode(CartItem data, CartItemNode next) {
        this.data = data;
        this.next = next;
    }

    // Getters y Setters 
    public CartItem getData() {
        return data;
    }

    public void setData(CartItem data) {
        this.data = data;
    }

    public CartItemNode getNext() {
        return next;
    }

    public void setNext(CartItemNode next) {
        this.next = next;
    }
}