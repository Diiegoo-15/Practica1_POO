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

    public ClothingItem[] getItems() { return items; }
    public void setItems(ClothingItem[] items) { this.items = items; }

    public int getItemLength() { return itemLength; }
    public void setItemLength(int itemLength) { this.itemLength = itemLength; }

    public int getMAX_SIZE() { return MAX_SIZE; }

  
    public int getItemCount() { return itemLength; }

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
        int index = -1;
        for (int i = 0; i < itemLength; i++) {
            if (items[i].getName().equals(name) && items[i].getSize() == size) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int j = index; j < itemLength - 1; j++) {
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
        for (int i = 0; i < itemLength; i++) {
            res += items[i].getName() + "\t\t" + items[i].getPrice() + "\t\t" + items[i].getSize() + "\n";
        }
        return res;
    }
}