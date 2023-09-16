package store;

import mgr.Manageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import facade.UIData;

public class Item implements Manageable, UIData {
	public String itemName;
    public String code;
    public int price;
    public int neededTime;
    boolean quickMenu; 
    String quickMenuStr;
    String[] ingredient = new String[2];
    String whipStr;
    public boolean whip;
    String size;
    String[] eachSize;
    
    public ArrayList<String> Ingredientlist = new ArrayList<>();
    public ArrayList<Review> reviewList=new ArrayList<>();
    static ArrayList<String[]> reviewList2 = new ArrayList<>();
    static public ArrayList<Review> revList=new ArrayList<>();
    public void read(Scanner scan) {
        code = scan.next();
        itemName = scan.next();
        price = scan.nextInt();
        neededTime=scan.nextInt();
        while (true) {
            String ingredient = scan.next();
            if (ingredient.contentEquals("0"))
                break;
            Ingredientlist.add(ingredient);
        }
        quickMenuStr = scan.next();
        if (quickMenuStr.equals("O")) {
        	quickMenu=true;
        }
        whipStr = scan.next();
        if(whipStr.contentEquals("O")) 
        	whip=true;
        //revCheck=scan.next();
        size=scan.nextLine();
       	eachSize=size.split("/ ");
       
    }
    
    public boolean matches(String kwd) {
        if (itemName.contains(kwd))
            return true;
        if (kwd.length() > 2 && code.contains(kwd))
            return true;
        return false;
    }

    public boolean matches(String[] kwdArr) {
        for (String kwd : kwdArr) {
            if (!matches(kwd))
                return false;
        }
        return true;
    }

    public void print() { // Item
    	System.out.format("[%s] %s (%d¿ø) ", 
				code, itemName, price);
    	for(String ing:Ingredientlist)
    		System.out.printf("%s ", ing);
        System.out.println();
         
    }
    
    void addReview(Review rev) {
    	revList.add(rev);
    }
    
	public String[] getReview(Item item) {
		Random rand=new Random();
		rand.setSeed(System.currentTimeMillis());
		int size=item.reviewList.size();
		int index;
		if(size>1)
			index=rand.nextInt(size-1);
		else
			index=0;
		Review review=item.reviewList.get(index);
		String[] revStr=new String[4];
		revStr[0]=review.userName;
		revStr[1]=review.itemName;
		revStr[2]=review.rank;
		revStr[3]=review.content;
		return revStr;
	}
	
	public String[] getIngredient(Item item) {
		int i=0;
		String[] ingList=new String[item.Ingredientlist.size()];
	    for(String ing:item.Ingredientlist) {
	    	ingList[i]=ing;
	    	i++;
	    }
		return ingList;
	}
	public String[] getwhipStr(Item item) {
        int i=0;
        String[] ingList=new String[item.Ingredientlist.size()];
         for(String ing:item.Ingredientlist) {
            ingList[i]=ing;
            i++;
         }
        return ingList;
     }
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[5];
		texts[0] = code;
		texts[1] = itemName;
		texts[2] = ""+price;
		texts[3] = size;
		return texts;
	}
}