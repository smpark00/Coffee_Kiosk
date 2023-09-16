package store;

import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class OrderedItem implements Manageable, UIData {
	Order order;
	Item item;

	OrderedItem(Order order, Item item, Scanner scan) {
		this.item = item;
		this.order = order;
	}
	int subTotal() {
		return item.price * 1;
	}
	public void print() {
		System.out.format("[%s] %d¿ø x 1°³ = %d¿ø\n", 
				item.itemName, item.price, subTotal());
	}
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getUiTexts() { 
		// TODO Auto-generated method stub
		String[] texts = new String[6];
		texts[0] = ""+Order.orderId;
		texts[1] = item.itemName;
		texts[2] = "1";
		texts[3] = order.size;
		texts[4] = order.whipStr;
		texts[5] = ""+item.price;
		return texts;
	}
}