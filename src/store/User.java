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
    public void read(Scanner scan) {// id 0���� 1 �� ����
        //++userId;
        //id = "a"+Integer.toString(userId);
    	id = scan.next();
		pwd = scan.next();
		point = scan.nextInt();
    }
    @Override
    public void print() { //��ٱ��� ���
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
           if (od.matches(kwd)) // �ֹ�id���� ��ġ
              return true;
        return false;
    }
    public void couponcheck() {// ���� ���ڰ� 10�� �Ǹ� �Ƹ޸�ī�� ���ݸ�ŭ ����
        if(coupon == 10) {
            coupon = 0;
            onecoffeefree();
        }
    }
    public void onecoffeefree() { //�Ƹ޸�ī�� ���� ����
        price = price - 4100;
    }
    public void shoppingListsub(String coffee) {// ��ٱ��Ͽ��� ���� ����
        for(Order od: shoppingList) {
            shoppingList.remove("coffee");
        }
    }
    public void shoppingListinit() {// �ֹ� ������ ��ٱ��� �ʱ�ȭ
        shoppingList.clear();
    }
    public void addOrder(Order ord) {//��ٱ��Ͽ� �߰�
        shoppingList.add(ord);
         for(Order od:shoppingList) {
             price+=od.item.price;
         }
    }
}