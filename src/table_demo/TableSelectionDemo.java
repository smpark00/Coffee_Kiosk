package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ScrollPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import facade.DataEngineInterface;
import facade.UIData;
import store.CouponData;
import store.Item;
import store.Order;
import store.OrderedItem;
import store.OrderedItemMgr;
import store.Review;
import store.Store;
import store.User;

public class TableSelectionDemo extends JPanel implements ListSelectionListener {
   private static final long serialVersionUID = 1L;
   DefaultTableModel tableModel;
   JTable table;
   int selectedIndex = -1;
   DataEngineInterface dataMgr;

   public TableSelectionDemo() {
      super(new BorderLayout());
   }

   void addComponentsToPane(DataEngineInterface mgr) {
      init(mgr);
      JScrollPane center = new JScrollPane(table);
      add(center, BorderLayout.EAST);
   }

   @SuppressWarnings("serial")
   void init(DataEngineInterface mgr) {
      dataMgr = mgr;
      tableModel = new DefaultTableModel(mgr.getColumnNames(), 0) { // 셀 수정 못하게 하는 부분
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      };
      loadData("");
      table = new JTable(tableModel);
      table.setBackground(Color.gray);
      table.setForeground(Color.white);
      ListSelectionModel rowSM = table.getSelectionModel();
      rowSM.addListSelectionListener(this);
      table.setPreferredSize(new Dimension(1200, 308));// 크기 키우면 스크롤 구현
      table.setFillsViewportHeight(false);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      // 테이블 내용 가운데 정렬하기
      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
      dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
      TableColumnModel tcm = table.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
      tcm.getColumn(0).setCellRenderer(dtcr);
      tcm.getColumn(1).setCellRenderer(dtcr);
      tcm.getColumn(2).setCellRenderer(dtcr);
      tcm.getColumn(3).setCellRenderer(dtcr);
      table.getTableHeader().setReorderingAllowed(false);
   }

   // 매니저에서 검색된 객체들을 테이블에 보여준다. kwd가 ""면 모두 출력
   void loadData(String kwd) {
      List<?> result = dataMgr.search(kwd);
      tableModel.setRowCount(0);
      for (Object m : result)
         tableModel.addRow(((UIData) m).getUiTexts());
   }

   void showDetail() {
      int selectedIndex=GUIMain.nowRow;
      if (!GUIMain.isSelectedOrder)
         return;
      String[] ingredient;
      String[] rev;
      String[] rowTexts = new String[GUIMain.orderTable.getColumnCount()];
      for (int i = 0; i < rowTexts.length; i++)
         rowTexts[i] = (String) tableModel.getValueAt(selectedIndex, i);
      List<?> result = dataMgr.search(rowTexts[0]); // code로 찾기
      Object od = result.get(0);
      Item item = (Item) od; // item에는 선택한 행의 아이템 정보가 들어가있음
      ingredient = item.getIngredient(item);
      DetailDialog dlg = new DetailDialog(rowTexts, ingredient, item);
      dlg.setup();
      dlg.pack();
      dlg.setVisible(true);
   }

   void callOption() {
      int selectedIndex=GUIMain.nowRow;
      if (!GUIMain.isSelectedOrder)
         return;
      String[] rowTexts = new String[GUIMain.orderTable.getColumnCount()];
      for (int i = 0; i < rowTexts.length; i++)
         rowTexts[i] = (String) tableModel.getValueAt(selectedIndex, i);
      List<?> result = dataMgr.search(rowTexts[0]); // code로 찾기
      Object od = result.get(0);
      Item item = (Item) od; // item에는 선택한 행의 아이템 정보가 들어가있음
      Order ord = new Order();
      ord.read(rowTexts, (Item) od);
      OptionDialog op = new OptionDialog(rowTexts, ord, this);
      op.setup();
      op.pack();
   }

   void callWhip(TableSelectionDemo table, String size, int price) {
      int selectedIndex=GUIMain.nowRow;
      if (!GUIMain.isSelectedOrder)
         return;
      String[] rowTexts = new String[GUIMain.orderTable.getColumnCount()];
      for (int i = 0; i < rowTexts.length; i++)
         rowTexts[i] = (String) tableModel.getValueAt(selectedIndex, i);
      List<?> result = dataMgr.search(rowTexts[0]); // code로 찾기
      Object od = result.get(0);
      Item item = (Item) od; // item에는 선택한 행의 아이템 정보가 들어가있음
      Order ord = new Order();
      ord.read(rowTexts, (Item) od);
      if (ord.item.whip) {
         String size1 = size;
         OptionDialog2 op2 = new OptionDialog2(rowTexts, ord, size1, price, this);
         op2.setup();
         op2.pack();
      } else {
         String size1 = size;
         OptionDialog2 op2 = new OptionDialog2(rowTexts, ord, size1, price, this);
         op2.setup(ord.item.whip);
         op2.pack();
      }
   }


      static int priceSum = 0;
      static ArrayList<JToggleButton> buttonList=new ArrayList<>();
      static ArrayList<JToggleButton> shoppingListButton=new ArrayList<>();
      static JToggleButton nowButton;
      static boolean isSelected=false;
      private static ButtonGroup bg = new ButtonGroup();
      void addOrder(String size, String whip, int extraprice) {
         int selectedIndex=GUIMain.nowRow;
         if (!GUIMain.isSelectedOrder)
            return;
         String[] rowTexts = new String[GUIMain.orderTable.getColumnCount()];
         String[] whipStr;
         
         for (int i = 0; i < rowTexts.length; i++)
            rowTexts[i] = (String) tableModel.getValueAt(selectedIndex, i);
         List<?> result = dataMgr.search(rowTexts[0]); // code로 찾기
         Object od = result.get(0);
         Item item = (Item) od; // item에는 선택한 행의 아이템 정보가 들어가있음
         whipStr = item.getwhipStr(item);
         Order ord = new Order();
         ord.read(rowTexts, (Item) od);
         ord.size = size;
         ord.whipStr = whip;
         ord.item.price += extraprice; // 사이즈업 가격추가
         if (whipStr.equals("O"))
            ord.whip = true;
         else if (whipStr.equals("X"))
            ord.whip = false;
         OrderedItem ordItem = ord.orderedItemList.get(0);
         User.shoppingList.add(ord);
         User.nowShoppingList.add(ord);
         Order.orderList.add(ord);
         GUIMain.basketModel.addRow(ordItem.getUiTexts());
         GUIMain.pricePane.removeAll();
         JLabel totalPrice;
         priceSum += ord.item.price;
         ord.item.price -= extraprice; // 사이즈업 가격 복구
         totalPrice = new JLabel("금액: " + priceSum);
         waitTime[Order.orderId-1]+=ord.item.neededTime;

         GUIMain.pricePane.add(totalPrice);

         DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
         dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
         TableColumnModel tcm = GUIMain.basketTable.getColumnModel();
         tcm.getColumn(0).setCellRenderer(dtcr);
         tcm.getColumn(1).setCellRenderer(dtcr);
         tcm.getColumn(2).setCellRenderer(dtcr);
         tcm.getColumn(3).setCellRenderer(dtcr);
         tcm.getColumn(4).setCellRenderer(dtcr);
         tcm.getColumn(5).setCellRenderer(dtcr);
         
         ImageIcon image = new ImageIcon("MENU/" + item.itemName + ".jpg");
          Image image2 = image.getImage();
          Image i4 = image2.getScaledInstance(200, 260, java.awt.Image.SCALE_SMOOTH);
          ImageIcon i5 = new ImageIcon(i4); // Image로 ImageIcon 생성
          JToggleButton b = new JToggleButton(item.itemName, i5);
          b.setHorizontalTextPosition(SwingConstants.CENTER);
          b.setVerticalTextPosition(SwingConstants.BOTTOM);
         b.setBorderPainted(false); // 테두리
         //b.setContentAreaFilled(false); // 누를때 파랑색
         b.setFocusPainted(false); // 누르면 사각형
         b.setBackground(Color.white);
           b.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ev) {
               // TODO Auto-generated method stub
               if(ev.getStateChange()==ItemEvent.SELECTED){
                  TableSelectionDemo.menuName=item.itemName;
                  nowButton=b;
                  isSelected=true;
                   }
               else if(ev.getStateChange()==ItemEvent.DESELECTED){
                  TableSelectionDemo.menuName="";
                  isSelected=false;
                   }
            }
          });
           buttonList.add(b);
           bg.add(b);shoppingListButton.add(b);
           GUIMain.imagePane.add(b);
      }
   static String[] uiTexts = { " ", " ", " ", " " };
   static int orderId1 = 1;
   static int lowestOrderId = 1;
   static int latestIndex = 0;
   static Integer[] waitTime= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

   void addBasket() { // 각 테이블이나 펜의 크기를 지정해보기
	      ArrayList<Order> basketList = User.nowShoppingList;
	      int waitSum = 0;
	      String time = GUIMain.store.timeToString(true);
	      int orderId = 0;
	      int rowCount;
	      Calendar now = Calendar.getInstance();
	      JTable basket = new JTable();
	      basket.setModel(GUIMain.basketModel);
	      if (basket.getRowCount() == 0)
	         return;
	      // int orderId=(int) basket.getValueAt(0, 0);

	      // 이거 orderId받을 때 static이라 계속 같은값만 갖고올수도 있음, 일단 기능 완성후 수정

	      for (Order ord : basketList) {
	         if (orderId1 == ord.orderId) {
	            waitSum += ord.item.neededTime;
	            uiTexts[0] = "" + ord.orderId;
	            orderId = ord.orderId;
	            uiTexts[1] = "" + ord.user.userId;
	            uiTexts[2] = time;
	         } else
	            break; // 어차피 orderId는 순서대로 되어있으므로 한번 다르면 계속 다른거
	      }
	      if (uiTexts[0].contentEquals("a"))
	         return;
	      uiTexts[3] = "" + waitSum + "분";

	      time = time + (now.get(Calendar.SECOND));
	      for (Order ord : Order.orderList)
	         if (ord.orderNum == orderId)
	            ord.time = time; // 현재 넣는 Order에 time 추가

	      GUIMain.orderModel.addRow(uiTexts);
	      uiTexts[0] = "a";
	      // uiTexts[3]=0
	      rowCount = GUIMain.basketModel.getRowCount();
	      for (int i = 0; i < rowCount; i++)
	         GUIMain.basketModel.removeRow(0);

	      int ordTimeSum = 0;
	      int timeSum = 0;
	      int nowTimeSum = 0;
	      // int length=orderId-lowestOrderId+1;

	      // waitTime = new Integer[orderId - lowestOrderId + 1];
	      String[] timeArr = new String[orderId - lowestOrderId + 1];// 현재 들어있는 주문 수

	      int i = 0;
	      int index = 0;
	      int number = 0;
	      Integer[] ordNumber = new Integer[orderId];
	      for (Order ord : Order.orderList) {
	         if (lowestOrderId + i < orderId) { // 현재 들어온 주문에 대해서는 시간계산 X
	            if (ord.orderNum != lowestOrderId + i) {
	               ordNumber[lowestOrderId - 1 + index] = number; // order번호당 나온 ord숫자
	               i++;
	               index++;
	            } else
	               number++;
	            timeSum += ord.item.neededTime;
	            // waitTime[i] = timeSum;
	            timeArr[i] = ord.time;
	         }
	      }

	      nowTimeSum = GUIMain.store.timeCalculate(time);
	      for (int j = 0; lowestOrderId < orderId; j++) {
	         ordTimeSum = GUIMain.store.timeCalculate(timeArr[j]);
	         if (nowTimeSum - ordTimeSum > waitTime[lowestOrderId - 1] * 60) {
	            GUIMain.orderModel.removeRow(0);
	            CheckWindow check = new CheckWindow(lowestOrderId);
	            check.check();
	            // int k=latestIndex;
	            for (int z = 0; z <= ordNumber[lowestOrderId - 1] - 1; z++) {
	               Order.orderList.remove(0);
	               latestIndex++;
	            }
	            lowestOrderId++;
	         } else
	            break;
	      }
	      orderId1++;
	      Order.orderId++;
	      User.userId++;
	      User.nowShoppingList.clear();
	      priceSum = 0;

	      String timer = GUIMain.store.timeToString();
	      JLabel newTime = new JLabel(timer);

	      shoppingListButton.clear();
	      buttonList.clear();

	      GUIMain.imagePane.removeAll();

	      GUIMain.timePane.removeAll();
	      GUIMain.timePane.add(newTime);
	      GUIMain.pricePane.removeAll();
	      GUIMain.center.setVisible(false);
	      GUIMain.center.setVisible(true);

	      AlarmWindow alarm = new AlarmWindow("                   주문이 완료되었습니다.");
	      alarm.alarm();
	   }
   
   static String menuName;
   public void deleteBasket(JTable basketTable, DefaultTableModel basketModel) {
      JLabel totalPrice;
      JTable table = new JTable();
      table.setModel(basketModel);
      if(!isSelected || basketModel.getRowCount()==0)
         return;
      int rowCount;
      int rowCountNow;
      
      rowCount=shoppingListButton.indexOf(nowButton);
      rowCountNow=buttonList.indexOf(nowButton);
      Order ord=User.nowShoppingList.get(rowCountNow);      
      String priceStr = (String) table.getValueAt(rowCountNow, 5);
      int price = Integer.parseInt(priceStr);
      GUIMain.basketModel.removeRow(rowCountNow);//
      buttonList.remove(rowCountNow);//
      //nowButton.removeAll();
      GUIMain.imagePane.remove(nowButton);
      User.shoppingList.remove(rowCountNow);
      User.nowShoppingList.remove(rowCountNow);//
      //GUIMain.basketModel.removeRow(basketTable.getSelectedRow());// 화면에서 삭제
      GUIMain.pricePane.removeAll();
         if(priceSum>4100) {
            priceSum = priceSum - price;
         }
         else {
            priceSum=0;
         }
      totalPrice = new JLabel("금액: " + priceSum);
      GUIMain.pricePane.add(totalPrice);
      System.out.println(priceSum);
      waitTime[Order.orderId-lowestOrderId]-=ord.item.neededTime;
   
      GUIMain.imagePane.setVisible(false);
      GUIMain.imagePane.setVisible(true);
      GUIMain.pricePane.setVisible(false);
      GUIMain.pricePane.setVisible(true);
   }

   static ArrayList<String> deleteList = new ArrayList<>();
   static ArrayList<String> codeList = new ArrayList<>();

   public void discount(String text) {
      JLabel totalPrice;
      int i = -1;
      GUIMain.pricePane.removeAll();
      for (CouponData code : CouponData.couponList)
         codeList.add(code.coupon);
      for (String code : codeList) {
         i++;
         int cancle=0;
         if (code.matches(text)) {
            if (deleteList.contains(text)) {
               AlarmWindow window = new AlarmWindow("쿠폰 코드가 틀렸거나 만료된 코드입니다.");
               window.alarm();
               Coupon.kwdTextField.selectAll();
               Coupon.kwdTextField.replaceSelection("");
               break;
            } else if (priceSum < 4100) {
               priceSum = priceSum - 0;
               AlarmWindow window = new AlarmWindow("                쿠폰 적용이 불가능합니다.");
               window.alarm();
               Coupon.kwdTextField.selectAll();
               Coupon.kwdTextField.replaceSelection("");
               break;
            } else {
               // CouponData.couponList.remove(code);
               deleteList.add(code);
               priceSum = priceSum - 4100;
               AlarmWindow window = new AlarmWindow("                쿠폰 사용이 완료되었습니다.");
               window.alarm();
               Coupon.kwdTextField.selectAll();
               Coupon.kwdTextField.replaceSelection("");
               break;
            }
         }
         else if(!(codeList.contains(text))&&!text.contentEquals("")){
            AlarmWindow window = new AlarmWindow("                쿠폰 코드가 틀렸습니다.");
            window.alarm();
            Coupon.kwdTextField.selectAll();
            Coupon.kwdTextField.replaceSelection("");
            cancle++;
            break;
         }
      }
      // priceSum = priceSum - 4100;
      totalPrice = new JLabel("금액: " + priceSum);
      GUIMain.pricePane.add(totalPrice);
      GUIMain.pricePane.setVisible(false);
      GUIMain.pricePane.setVisible(true);

   }
   void basketDetail() {
         JTable table = new JTable();
         String[] basketContent=new String[6];
         table.setModel(GUIMain.basketModel);
         if(!isSelected || GUIMain.basketModel.getRowCount()==0)
            return;
         int rowCount;
         
         rowCount=buttonList.indexOf(nowButton);
         basketContent[0]=(String) table.getValueAt(rowCount, 0);
         basketContent[1]=(String) table.getValueAt(rowCount, 1);
         basketContent[2]=(String) table.getValueAt(rowCount, 2);
         basketContent[3]=(String) table.getValueAt(rowCount, 3);
         basketContent[4]=(String) table.getValueAt(rowCount, 4);
         basketContent[5]=(String) table.getValueAt(rowCount, 5);
         
         DetailBasket dlg = new DetailBasket(basketContent);
         dlg.detail();
      }

   public void selectSize(OptionDialog optionD) {
      optionD.ord.size = "S";
      optionD.size = "S";
   }

   // 선택된 행이 변경되면 그 내용을 편집창으로 보냄
   public void valueChanged(ListSelectionEvent e) {
      ListSelectionModel lsm = (ListSelectionModel) e.getSource();
      if (!lsm.isSelectionEmpty()) {
         selectedIndex = lsm.getMinSelectionIndex();
      }
   }

}