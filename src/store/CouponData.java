package store;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

public class CouponData implements Manageable{
	public String coupon;
	static public ArrayList<CouponData> couponList=new ArrayList<>();
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		coupon=scan.next();
		couponList.add(this);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if(kwd.contentEquals(coupon))
			return true;
		return false;
	}

}
