package store;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;


public class User implements Manageable{

    String id;
    static public int userId = 1;
    int coupon;
    int price;
    String pwd;
    int point;
    static public ArrayList<Order> shoppingList = new ArrayList<>();
    static public ArrayList<Order> nowShoppingList = new ArrayList<>();
    @Override
    public void read(Scanner scan) {// id 0에서 1 씩 증가
        //++userId;
        //id = "a"+Integer.toString(userId);
    	id = scan.next();
		pwd = scan.next();
		point = scan.nextInt();
    }
    @Override
    public void print() { //장바구니 출력
        System.out.printf("[%s] ", id);
        for(Order ord:shoppingList) {
            System.out.print("\t");
            ord.print(false);
        }
    }
    @Override
    public boolean matches(String kwd) {
        if (kwd.length() == 0)
            return true;
        if(kwd.contentEquals(""+id))
            return true;
        for (Order od: shoppingList)
           if (od.matches(kwd)) // 주문id에만 매치
              return true;
        return false;
    }
    public void couponcheck() {// 쿠폰 숫자가 10이 되면 아메리카노 가격만큼 할인
        if(coupon == 10) {
            coupon = 0;
            onecoffeefree();
        }
    }
    public void onecoffeefree() { //아메리카노 가격 할인
        price = price - 4100;
    }
    public void shoppingListsub(String coffee) {// 장바구니에서 빼면 삭제
        for(Order od: shoppingList) {
            shoppingList.remove("coffee");
        }
    }
    public void shoppingListinit() {// 주문 끝나면 장바구니 초기화
        shoppingList.clear();
    }
    public void addOrder(Order ord) {//장바구니에 추가
        shoppingList.add(ord);
         for(Order od:shoppingList) {
             price+=od.item.price;
         }
    }
}