package shop;

public class Inventory {
    
    private ClothingItem[] items;   
    private int itemLength;         
    private final int MAX_SIZE;     

    
    public Inventory(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.items = new ClothingItem[MAX_SIZE]; 
        this.itemLength = 0; 
    }

    public int getItemCount() {
        return itemLength;
    }

   
    public void addItem(ClothingItem item) {
      
        if (itemLength < MAX_SIZE) {
            items[itemLength] = item; 
            itemLength++; 
        }
    }

    
    public int checkStock(String name, char size) {
        int count = 0;
        
        for (int i = 0; i < itemLength; i++) {
            
            if (items[i].getName().equals(name) && items[i].getSize() == size) {
                count++;
            }
        }
        return count;
    }

    public void removeItem(String name, char size) {
   
        int indexParaBorrar = -1;
        for (int i = 0; i < itemLength; i++) {
            if (items[i].getName().equals(name) && items[i].getSize() == size) {
                indexParaBorrar = i;
                break; 
            }
        }

        if (indexParaBorrar != -1) {
            for (int j = indexParaBorrar; j < itemLength - 1; j++) {
                items[j] = items[j + 1]; 
            }
          
            items[itemLength - 1] = null;
            itemLength--; 
        }
    }

    public ClothingItem extractItem(String name, char size) {

        for (int i = 0; i < itemLength; i++) {
            if (items[i].getName().equals(name) && items[i].getSize() == size) {
                ClothingItem temp = items[i]; 
                removeItem(name, size);       
                return temp;                 
            }
        }
        return null; 
    }

    
    @Override
    public String toString() {
        
        String res = "Inventario: => itemLength=" + itemLength + ", MAX_SIZE=" + MAX_SIZE + "\n";
        res += "Nombre\t\tPrecio\t\tTalla\n";
        res += "--------------------------------------------\n";
        
        for (int i = 0; i < itemLength; i++) {
            res += items[i].getName() + "\t\t" + items[i].getPrice() + "\t\t" + items[i].getSize() + "\n";
        }
        return res;
    }
}