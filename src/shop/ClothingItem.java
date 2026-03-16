package shop;

public class ClothingItem {
	
	private String name; 
	private double price; 
	private char size; 
	
	public ClothingItem(String name, double price, char size) {
		
		this.name = name; 
		this.price = price; 
		if(size == 'S' || size == 'M' || size == 'L') {
			this.size = size; 
		}else {
			this.size = 'M'; 
		}
		
	}
	
	public String getName() {return this.name;}
	public double getPrice() {return this.price;}
	public char getSize() {return this.size;}
	
	public void setName(String name) {this.name = name;}
	public void setPrice(double price) {this.price = price;}
	public void setSize(char size) {
		if(size == 'S' || size == 'M' || size == 'L') {
			this.size = size;
		}
	}
	
	@Override
	public String toString() {
		return this.name + " - " + this.price + "€ Talla: " + this.size;
	}
	
	
}




