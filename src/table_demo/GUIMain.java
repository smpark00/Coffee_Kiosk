package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import store.AdeMgr;
import store.CoffeeMgr;
import store.JuiceMgr;
import store.OrderMgr;
import store.OrderedItemMgr;
import store.QuickMgr;
import store.SmoothieMgr;
import store.Store;
import store.TeaMgr;

public class GUIMain {
   static Store store = Store.getInstance();

   public static void main(String args[]) {
      store.run();
      startGUI();
   }

   public static void startGUI() {
      // Schedule a job for the event-dispatching thread:
      // creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

   /**
    * Create the GUI and show it. For thread safety, this method should be invoked
    * from the event-dispatching thread.
    */
   static JFrame mainFrame = new JFrame("CAFE UNIVERSE");

   private static void createAndShowGUI() {
      mainFrame.setBounds(100, 100, 900, 600);
      // Create and set up the window.
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JTabbedPane jtab = new JTabbedPane();
      // 색
      jtab.setBackground(Color.gray);
      jtab.setForeground(Color.white);
      setupItemPane("COFFEE");
      jtab.add("COFFEE", coffeePane);
      setupItemPane("ADE");
      jtab.add("ADE", adePane);
      setupItemPane("TEA");
      jtab.add("TEA", teaPane);
      setupItemPane("JUICE");
      jtab.add("JUICE", juicePane);
      setupItemPane("SMOOTHIE");
      jtab.add("SMOOTHIE", smoothiePane);
      setupItemPane("QUICKMENU");
      jtab.add("QUICKMENU", quickPane);
      setupOrderPane();
      jtab.add("장바구니", orderPane);
      jtab.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            photoPane.removeAll();
         }
      });
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Image img = toolkit.getImage("Cosat.png");
      mainFrame.setIconImage(img);
      mainFrame.getContentPane().add(jtab);
      // Display the window.
      mainFrame.pack();
      mainFrame.setVisible(true);
      mainFrame.setBounds(100, 100, 1200, 900);
      mainFrame.setLocationRelativeTo(null);// 중앙에서 나오게
      //mainFrame.setResizable(false);// 크기 조절 불가
   }

   // private static JPanel backgroundPane=new JPanel(new BorderLayout());
   private static Container backgroundPane = mainFrame.getContentPane();

   // static JPanel photoPane=new JPanel(new GridLayout(1,1,5,5));
   static JPanel photoPane = new JPanel(new BorderLayout());
   private static JPanel coffeePane;
   private static JPanel coffeePane2;
   private static JPanel juicePane;
   private static JPanel juicePane2;
   private static JPanel smoothiePane;
   private static JPanel smoothiePane2;
   private static JPanel adePane;
   private static JPanel adePane2;
   private static JPanel teaPane;
   private static JPanel teaPane2;
   private static JPanel quickPane;
   private static JPanel quickPane2;
   private static JScrollPane scroll;
   private static ButtonGroup bg = new ButtonGroup();

   private static void setupItemPane(String type) {
      // Create and set up the content pane.
      TableSelectionDemo itemTable = new TableSelectionDemo();
      photoPane.setBackground(Color.DARK_GRAY); // 색
      // itemTable.addComponentsToPane(ItemMgr.getInstance()); // 싱글톤
      if (type.contentEquals("COFFEE")) {
         coffeePane2 = new JPanel(new GridLayout(7, 3, 20, 20));
         coffeePane = new JPanel(new BorderLayout());
         itemTable.addComponentsToPane(CoffeeMgr.getInstance());
         TopPanel itemTop = new TopPanel(); // 검색과 상세보기 버튼을 가진 패널
         itemTop.setupTopPane(itemTable);
         itemTop.setBackground(Color.GRAY);
         coffeePane.add(itemTop, BorderLayout.NORTH);
         coffeePane2.setBackground(Color.white);
         scroll = new JScrollPane(coffeePane2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getVerticalScrollBar().setUnitIncrement(18);
         coffeePane.add(scroll, BorderLayout.CENTER);
         coffeePane.add(itemTable, BorderLayout.CENTER);
         coffeePane.add(scroll, BorderLayout.CENTER);
         itemTable.setVisible(false);
         backgroundPane.add(coffeePane, BorderLayout.CENTER);
         TableEvent tableEvent = new TableEvent(itemTable);
         tableEvent.addEvent();

         int row = 0;

         JToggleButton b = set(itemTable.tableModel, row);
         row++;
         JToggleButton b2 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b3 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b4 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b5 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b6 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b7 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b8 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b9 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b10 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b11 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b12 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b13 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b14 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b15 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b16 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b17 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b18 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b19 = set(itemTable.tableModel, row);
         row++;
         
         ImageIcon C = new ImageIcon("Codeby.png");
         JToggleButton c = new JToggleButton(C);         
         c.setBackground(Color.white);
         c.setBorderPainted(false); // 테두리
         c.setContentAreaFilled(false); // 누를때 파랑색
         c.setFocusPainted(false); // 누르면 사각형
         JToggleButton c1 = new JToggleButton();
         c1.setBackground(Color.white);
         c1.setBorderPainted(false); // 테두리
         c1.setContentAreaFilled(false); // 누를때 파랑색
         c1.setFocusPainted(false); // 누르면 사각형

            bg.add(b);coffeePane2.add(b);
            bg.add(b2);coffeePane2.add(b2);
            bg.add(b3);coffeePane2.add(b3);
            bg.add(b4);coffeePane2.add(b4);
            bg.add(b5);coffeePane2.add(b5);
            bg.add(b6);coffeePane2.add(b6);
            bg.add(b7);coffeePane2.add(b7);
            bg.add(b8);coffeePane2.add(b8);
            bg.add(b9);coffeePane2.add(b9);
            bg.add(b10);coffeePane2.add(b10);
            bg.add(b11);coffeePane2.add(b11);
            bg.add(b12);coffeePane2.add(b12);
            bg.add(b13);coffeePane2.add(b13);
            bg.add(b14);coffeePane2.add(b14);
            bg.add(b15);coffeePane2.add(b15);
            bg.add(b16);coffeePane2.add(b16);
            bg.add(b17);coffeePane2.add(b17);
            bg.add(b18);coffeePane2.add(b18);
            bg.add(b19);coffeePane2.add(b19);
            bg.add(c1);coffeePane2.add(c1);
            bg.add(c);coffeePane2.add(c);
         
      } else if (type.contentEquals("ADE")) {
         adePane2 = new JPanel(new GridLayout(3, 3, 20, 20));
         adePane = new JPanel(new BorderLayout());
         itemTable.addComponentsToPane(AdeMgr.getInstance());
         TopPanel itemTop = new TopPanel(); // 검색과 상세보기 버튼을 가진 패널
         itemTop.setupTopPane(itemTable);
         itemTop.setBackground(Color.GRAY);
         adePane.add(itemTop, BorderLayout.NORTH);
         adePane2.setBackground(Color.white);
         scroll = new JScrollPane(adePane2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getVerticalScrollBar().setUnitIncrement(18);
         adePane.add(scroll, BorderLayout.CENTER);
         adePane.add(itemTable, BorderLayout.CENTER);
         adePane.add(scroll, BorderLayout.CENTER);
         itemTable.setVisible(false);
         backgroundPane.add(adePane, BorderLayout.CENTER);
         TableEvent tableEvent = new TableEvent(itemTable);
         tableEvent.addEvent();

         int row = 0;

         JToggleButton b = set(itemTable.tableModel, row);
         row++;
         JToggleButton b2 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b3 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b4 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b5 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b6 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b7 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b8 = set(itemTable.tableModel, row);
         row++;

         ImageIcon C = new ImageIcon("Codeby.png");
         JToggleButton c = new JToggleButton(C);         
         c.setBackground(Color.white);
         c.setBorderPainted(false); // 테두리
         c.setContentAreaFilled(false); // 누를때 파랑색
         c.setFocusPainted(false); // 누르면 사각형
         
            bg.add(b);adePane2.add(b);
            bg.add(b2);adePane2.add(b2);
            bg.add(b3);adePane2.add(b3);
            bg.add(b4);adePane2.add(b4);
            bg.add(b5);adePane2.add(b5);
            bg.add(b6);adePane2.add(b6);
            bg.add(b7);adePane2.add(b7);
            bg.add(b8);adePane2.add(b8);
            bg.add(c);adePane2.add(c);
            
      } else if (type.contentEquals("TEA")) {
         teaPane2 = new JPanel(new GridLayout(3, 3, 20, 20));
         teaPane = new JPanel(new BorderLayout());
         itemTable.addComponentsToPane(TeaMgr.getInstance());
         TopPanel itemTop = new TopPanel(); // 검색과 상세보기 버튼을 가진 패널
         itemTop.setupTopPane(itemTable);
         itemTop.setBackground(Color.GRAY);
         teaPane.add(itemTop, BorderLayout.NORTH);
         teaPane2.setBackground(Color.white);
         scroll = new JScrollPane(teaPane2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getVerticalScrollBar().setUnitIncrement(18);
         teaPane.add(scroll, BorderLayout.CENTER);
         teaPane.add(itemTable, BorderLayout.CENTER);
         teaPane.add(scroll, BorderLayout.CENTER);
         itemTable.setVisible(false);
         backgroundPane.add(teaPane, BorderLayout.CENTER);
         TableEvent tableEvent = new TableEvent(itemTable);
         tableEvent.addEvent();

         int row = 0;

         JToggleButton b = set(itemTable.tableModel, row);
         row++;
         JToggleButton b2 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b3 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b4 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b5 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b6 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b7 = set(itemTable.tableModel, row);
         row++;
         
         ImageIcon C = new ImageIcon("Codeby.png");
         JToggleButton c = new JToggleButton(C);         
         c.setBackground(Color.white);
         c.setBorderPainted(false); // 테두리
         c.setContentAreaFilled(false); // 누를때 파랑색
         c.setFocusPainted(false); // 누르면 사각형
         JToggleButton c1 = new JToggleButton();
         c1.setBackground(Color.white);
         c1.setBorderPainted(false); // 테두리
         c1.setContentAreaFilled(false); // 누를때 파랑색
         c1.setFocusPainted(false); // 누르면 사각형
         
         bg.add(b);teaPane2.add(b);
            bg.add(b2);teaPane2.add(b2);
            bg.add(b3);teaPane2.add(b3);
            bg.add(b4);teaPane2.add(b4);
            bg.add(b5);teaPane2.add(b5);
            bg.add(b6);teaPane2.add(b6);
            bg.add(b7);teaPane2.add(b7);
            bg.add(c1);teaPane2.add(c1);
            bg.add(c);teaPane2.add(c);

      } else if (type.contentEquals("JUICE")) {
         juicePane2 = new JPanel(new GridLayout(4, 3, 20, 20));
         juicePane = new JPanel(new BorderLayout());
         itemTable.addComponentsToPane(JuiceMgr.getInstance());
         TopPanel itemTop = new TopPanel(); // 검색과 상세보기 버튼을 가진 패널
         itemTop.setupTopPane(itemTable);
         itemTop.setBackground(Color.GRAY);
         juicePane.add(itemTop, BorderLayout.NORTH);
         juicePane2.setBackground(Color.white);
         scroll = new JScrollPane(juicePane2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getVerticalScrollBar().setUnitIncrement(18);
         juicePane.add(scroll, BorderLayout.CENTER);
         juicePane.add(itemTable, BorderLayout.CENTER);
         juicePane.add(scroll, BorderLayout.CENTER);
         itemTable.setVisible(false);
         backgroundPane.add(juicePane, BorderLayout.CENTER);
         TableEvent tableEvent = new TableEvent(itemTable);
         tableEvent.addEvent();

         int row = 0;

         JToggleButton b = set(itemTable.tableModel, row);
         row++;
         JToggleButton b2 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b3 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b4 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b5 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b6 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b7 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b8 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b9 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b10 = set(itemTable.tableModel, row);
         row++;
         
         ImageIcon C = new ImageIcon("Codeby.png");
         JToggleButton c = new JToggleButton(C);         
         c.setBackground(Color.white);
         c.setBorderPainted(false); // 테두리
         c.setContentAreaFilled(false); // 누를때 파랑색
         c.setFocusPainted(false); // 누르면 사각형
         JToggleButton c1 = new JToggleButton();
         c1.setBackground(Color.white);
         c1.setBorderPainted(false); // 테두리
         c1.setContentAreaFilled(false); // 누를때 파랑색
         c1.setFocusPainted(false); // 누르면 사각형

         bg.add(b);juicePane2.add(b);
            bg.add(b2);juicePane2.add(b2);
            bg.add(b3);juicePane2.add(b3);
            bg.add(b4);juicePane2.add(b4);
            bg.add(b5);juicePane2.add(b5);
            bg.add(b6);juicePane2.add(b6);
            bg.add(b7);juicePane2.add(b7);
            bg.add(b8);juicePane2.add(b8);
            bg.add(b9);juicePane2.add(b9);
            bg.add(b10);juicePane2.add(b10);
            bg.add(c1);juicePane2.add(c1);
            bg.add(c);juicePane2.add(c);

      } else if (type.contentEquals("SMOOTHIE")) {
         smoothiePane2 = new JPanel(new GridLayout(4, 3, 20, 20));
         smoothiePane = new JPanel(new BorderLayout());
         itemTable.addComponentsToPane(SmoothieMgr.getInstance());
         TopPanel itemTop = new TopPanel(); // 검색과 상세보기 버튼을 가진 패널
         itemTop.setupTopPane(itemTable);
         itemTop.setBackground(Color.GRAY);
         smoothiePane.add(itemTop, BorderLayout.NORTH);
         smoothiePane2.setBackground(Color.white);
         scroll = new JScrollPane(smoothiePane2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getVerticalScrollBar().setUnitIncrement(18);
         smoothiePane.add(scroll, BorderLayout.CENTER);
         smoothiePane.add(itemTable, BorderLayout.CENTER);
         smoothiePane.add(scroll, BorderLayout.CENTER);
         itemTable.setVisible(false);
         backgroundPane.add(smoothiePane, BorderLayout.CENTER);
         TableEvent tableEvent = new TableEvent(itemTable);
         tableEvent.addEvent();

         int row = 0;

         JToggleButton b = set(itemTable.tableModel, row);
         row++;
         JToggleButton b2 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b3 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b4 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b5 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b6 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b7 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b8 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b9 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b10 = set(itemTable.tableModel, row);
         row++;
         
         ImageIcon C = new ImageIcon("Codeby.png");
         JToggleButton c = new JToggleButton(C);         
         c.setBackground(Color.white);
         c.setBorderPainted(false); // 테두리
         c.setContentAreaFilled(false); // 누를때 파랑색
         c.setFocusPainted(false); // 누르면 사각형
         JToggleButton c1 = new JToggleButton();
         c1.setBackground(Color.white);
         c1.setBorderPainted(false); // 테두리
         c1.setContentAreaFilled(false); // 누를때 파랑색
         c1.setFocusPainted(false); // 누르면 사각형

         bg.add(b);smoothiePane2.add(b);
            bg.add(b2);smoothiePane2.add(b2);
            bg.add(b3);smoothiePane2.add(b3);
            bg.add(b4);smoothiePane2.add(b4);
            bg.add(b5);smoothiePane2.add(b5);
            bg.add(b6);smoothiePane2.add(b6);
            bg.add(b7);smoothiePane2.add(b7);
            bg.add(b8);smoothiePane2.add(b8);
            bg.add(b9);smoothiePane2.add(b9);
            bg.add(b10);smoothiePane2.add(b10);
            bg.add(c1);smoothiePane2.add(c1);
            bg.add(c);smoothiePane2.add(c);

      } else if (type.contentEquals("QUICKMENU")) {
         quickPane2 = new JPanel(new GridLayout(4, 3, 20, 20));
         quickPane = new JPanel(new BorderLayout());
         itemTable.addComponentsToPane(QuickMgr.getInstance());
         TopPanel itemTop = new TopPanel(); // 검색과 상세보기 버튼을 가진 패널
         itemTop.setupTopPane(itemTable);
         itemTop.setBackground(Color.GRAY);
         quickPane.add(itemTop, BorderLayout.NORTH);
         quickPane2.setBackground(Color.white);
         scroll = new JScrollPane(quickPane2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getVerticalScrollBar().setUnitIncrement(18);
         quickPane.add(scroll, BorderLayout.CENTER);
         quickPane.add(itemTable, BorderLayout.CENTER);
         quickPane.add(scroll, BorderLayout.CENTER);
         itemTable.setVisible(false);
         backgroundPane.add(quickPane, BorderLayout.CENTER);
         TableEvent tableEvent = new TableEvent(itemTable);
         tableEvent.addEvent();

         int row = 0;

         JToggleButton b = set(itemTable.tableModel, row);
         row++;
         JToggleButton b2 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b3 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b4 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b5 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b6 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b7 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b8 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b9 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b10 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b11 = set(itemTable.tableModel, row);
         row++;
         JToggleButton b12 = set(itemTable.tableModel, row);
         row++;

         bg.add(b);quickPane2.add(b);
            bg.add(b2);quickPane2.add(b2);
            bg.add(b3);quickPane2.add(b3);
            bg.add(b4);quickPane2.add(b4);
            bg.add(b5);quickPane2.add(b5);
            bg.add(b6);quickPane2.add(b6);
            bg.add(b7);quickPane2.add(b7);
            bg.add(b8);quickPane2.add(b8);
            bg.add(b9);quickPane2.add(b9);
            bg.add(b10);quickPane2.add(b10);
            bg.add(b11);quickPane2.add(b11);
            bg.add(b12);quickPane2.add(b12);

      }
   }

   static JPanel orderPane;
   static JPanel center = new JPanel(new BorderLayout());
   static DefaultTableModel basketModel;
   static JTable basketTable;
   static DefaultTableModel orderModel;
   static JTable orderTable;
   static JLabel price;
   static JPanel timePane = new JPanel(new FlowLayout());
   static JPanel pricePane = new JPanel(new FlowLayout());
   static JScrollPane scrollPane;
   static JPanel imagePane = new JPanel(new GridLayout(1, 1));

   @SuppressWarnings("serial")
   private static void setupOrderPane() {
      basketModel = new DefaultTableModel(OrderedItemMgr.getInstance().getColumnNames(), 0) {
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      };
      basketTable = new JTable(basketModel);
      // static JScrollPane scroll = new JScrollPane(basketTable);
      orderModel = new DefaultTableModel(OrderMgr.getInstance().getColumnNames(), 0) {
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      };
      orderModel.setRowCount(0);
      // basketModel.addColumn(OrderedItemMgr.getInstance().getColumnNames(), s);
      orderTable = new JTable(orderModel);
      orderPane = new JPanel(new BorderLayout());
      basketTable.setFillsViewportHeight(false);
      basketTable.setBackground(Color.GRAY); // 색
      basketTable.setForeground(Color.white); // 색
      orderPane.setBackground(Color.GRAY); // 색
      basketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      orderTable.setFillsViewportHeight(false);
      orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      orderTable.setBackground(Color.GRAY); // 색
      // JPanel timePane = new JPanel();
      // timePane.setBackground(Color.GRAY); // 색
      String time = store.timeToString();
      // JPanel timePane = new JPanel(new FlowLayout());
      timePane.add(new JLabel(time));
      timePane.setForeground(Color.white); // 색
      timePane.setBackground(Color.GRAY); // 색
      JScrollPane scroll1 = new JScrollPane(orderTable);
      orderPane.add(timePane, BorderLayout.NORTH);
      orderPane.add(scroll1, BorderLayout.SOUTH);
      JScrollPane scroll2 = new JScrollPane(basketTable);
      Basket basket = new Basket();
      JPanel right = new JPanel(new GridLayout(4, 1));
      basket.setupbasket(basketTable, basketModel, right);
      JLabel price = new JLabel("금액: ");
      scrollPane = new JScrollPane(imagePane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      imagePane.setBackground(Color.white);
      pricePane.add(price);
      center.add(scroll2);
      center.add(scrollPane);
      center.add(pricePane, BorderLayout.SOUTH);
      orderPane.add(right, BorderLayout.LINE_END);
      orderPane.add(center, BorderLayout.CENTER);
      scroll2.setVisible(false);
      // center.setVisible(false);
   }

   static JToggleButton nowOrderButton;
   static boolean isSelectedOrder = false;
   static String nowCode;
   static int nowRow;

   private static JToggleButton set(DefaultTableModel model, int row) {
      JTable table = new JTable();
      table.setModel(model);
      String name;
      String price;
      String code;
      name = (String) table.getValueAt(row, 1);
      price = (String) table.getValueAt(row, 2);
      code = (String) table.getValueAt(row, 0);
      ImageIcon image = new ImageIcon("MENU/" + name + ".jpg");
      Image image2 = image.getImage();
      Image i4 = image2.getScaledInstance(200, 260, java.awt.Image.SCALE_SMOOTH);
      ImageIcon i5 = new ImageIcon(i4); // Image로 ImageIcon 생성
      JToggleButton b = new JToggleButton(name + " " + price + "원", i5);
      b.setHorizontalTextPosition(SwingConstants.CENTER);
      b.setVerticalTextPosition(SwingConstants.BOTTOM);
      b.setBorderPainted(false); // 테두리
      // b.setContentAreaFilled(false); // 누를때 파랑색
      b.setFocusPainted(false); // 누르면 사각형
      b.setBackground(Color.white); // 누르면 사각형
      b.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent ev) {
            // TODO Auto-generated method stub
            if (ev.getStateChange() == ItemEvent.SELECTED) {
               TableSelectionDemo.menuName = name;
               nowOrderButton = b;
               isSelectedOrder = true;
               nowCode = code;
               nowRow = row;
            } else if (ev.getStateChange() == ItemEvent.DESELECTED) {
               TableSelectionDemo.menuName = "";
               nowCode = "";
               isSelectedOrder = false;
            }
         }
      });
      return b;
   }
}