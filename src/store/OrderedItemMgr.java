package store;

import java.util.ArrayList;
import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class OrderedItemMgr implements DataEngineInterface {
	private static OrderedItemMgr mgr = null;
	private OrderedItemMgr() {}
	public static OrderedItemMgr getInstance() {
		if (mgr == null)
			mgr = new OrderedItemMgr();
		return mgr;
	}
	List<OrderedItem> mylist;
	public void setOrder(Order order) {
		mylist = order.orderedItemList;
	}
	private String[] headers = {"�ֹ���ȣ", "��ǰ��", "����", "������","����ũ��", "�Ұ�"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		List<Manageable> result = new ArrayList();
		//for (OrderedItem od: mylist)
			//result.add(od);
		Order ord=new Order();
		result.add(ord);
		return result;  // mylist ���� �ȵ�. <OrderedItem> -> <Manageable> �Ұ�
	}

	@Override
	public void addNewItem(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String kwd) {
		// TODO Auto-generated method stub
		
	}

}
