package store;

import java.util.ArrayList;
import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class Review implements Manageable, UIData {
	public String userName;
	public String itemName;
	public String rank;
	public String content;
	Item item;
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		userName=scan.next();
		itemName=scan.next();
		rank=scan.next();
		content=scan.nextLine();
		item = (Item)Store.itemMgr.find(itemName);
		item.addReview(this);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if(kwd.contentEquals(itemName))
			return true;
		return false;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
