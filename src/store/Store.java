package store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class Store {
	private static Store store = null;
	private Store() {}
	public static Store getInstance() {
		if (store == null)
			store = new Store();
		return store;
	}
	Scanner scan = new Scanner(System.in);
	static Manager userMgr = new Manager();
	static Manager itemMgr = new Manager();
	static Manager coffeeMgr = new Manager();
	static Manager juiceMgr = new Manager();
	static Manager smoothieMgr = new Manager();
	static Manager adeMgr = new Manager();
	static Manager teaMgr = new Manager();
	static Manager quickMgr = new Manager();
	static Manager orderMgr = new Manager();
	static Manager reviewMgr=new Manager();
	static Manager couponMgr=new Manager();
	public void run() {
		itemMgr.readAll("items.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		System.out.println("\n================= 판매 상품 리스트 =================");
		//itemMgr.printAll();
		coffeeMgr.readAll("COFFEE.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		juiceMgr.readAll("JUICE.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		smoothieMgr.readAll("SMOOTHIE.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		adeMgr.readAll("ADE.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		teaMgr.readAll("TEA.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		quickMgr.readAll("QUICKMENU.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		userMgr.readAll("users.txt", new Factory() {
			public Manageable create() {
				return new User();
			}
		});
		orderMgr.readAll("order.txt", new Factory() {
			public Manageable create() {
				return new Order();
			}
		});
		reviewMgr.readAll("REVIEW.txt", new Factory() {
			public Manageable create() {
				return new Review();
			}
		});
		couponMgr.readAll("COUPON.txt", new Factory() {
			public Manageable create() {
				return new CouponData();
			}
		});
		itemMgr.printAll();
		//System.out.println("\n================= 전체 주문 리스트 =================");
		//orderMgr.printAll();
		//System.out.println("\n=============== 사용자별 주문 리스트 =================");
		//userMgr.printAll();
	}
	static List<String> getStringList(Scanner scan, String end) {
		List<String> strList = new ArrayList<>();
		String tmp;
		while (true) {
			tmp = scan.next();
			if (tmp.contentEquals(end))
				break;
			strList.add(tmp);
		}
		return strList;
	}

	public static boolean isNumeric(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public String timeToString() {
		Calendar now=Calendar.getInstance();
		String timeStr;
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		int day=now.get(Calendar.DATE);
		int hour=now.get(Calendar.HOUR_OF_DAY);
		int min=now.get(Calendar.MINUTE);
		
		timeStr=(""+year+"년 ")+(""+month+"월 ")+
				(""+day+"일 ")+(""+hour+"시 ")+(""+min+"분");
		return timeStr;
	}
	public String timeToString(boolean c) {
		Calendar now=Calendar.getInstance();
		String timeStr;
		int hour=now.get(Calendar.HOUR_OF_DAY);
		int min=now.get(Calendar.MINUTE);
		
		timeStr=(""+hour+"시 ")+(""+min+"분");
		return timeStr;
	}
	public int timeCalculate(String time) {
		int hour;
		int min;
		int sec;
		int sum;
		String[] timeArr=time.split("시 |분");
		hour=Integer.parseInt(timeArr[0]);
		min=Integer.parseInt(timeArr[1]);
		sec=Integer.parseInt(timeArr[2]);
		sum=(hour*3600)+(min*60)+sec;
		return sum;
	}
	public static void main(String args[]) {
		Store store = new Store();
		store.run();
	}
}
