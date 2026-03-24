package cart;

import shop.ClothingItem; 

public class CartItem {
    
    private ClothingItem clothingItem; 
    private int units;                 

    // Constructor 
    public CartItem(ClothingItem clothingItem, int units) {
        this.clothingItem = clothingItem;
        this.units = units;
    }

    // Getters y Setters 
    public ClothingItem getClothingItem() {
        return clothingItem;
    }

    public void setClothingItem(ClothingItem clothingItem) {
        this.clothingItem = clothingItem;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    
    @Override
    public String toString() {
        
        return "Producto: " + clothingItem.getName() + 
               " | Talla: " + clothingItem.getSize() + 
               " | Unidades: " + units + 
               " | Precio/u: " + clothingItem.getPrice() + "€";
    }
}