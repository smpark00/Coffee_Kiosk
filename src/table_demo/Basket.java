package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Basket extends JPanel { // 장바구니에 있는 버튼들 액션리스너 설계
	TableSelectionDemo tableDemo = new TableSelectionDemo();

	void setupbasket(JTable basketTable,DefaultTableModel basketModel, JPanel right) {
		Coupon couponclass = new Coupon();
		Font font = new Font("맑은 고딕", Font.BOLD, 20);

		JButton order = new JButton("주문하기");
		JButton delete = new JButton("삭제");
		JButton coupon = new JButton("쿠폰");
		JButton detail = new JButton("주문상세");

		order.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		order.setFocusPainted(false); // 누르면 사각형
		delete.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		delete.setFocusPainted(false); // 누르면 사각형
		coupon.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		coupon.setFocusPainted(false); // 누르면 사각형
		detail.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		detail.setFocusPainted(false); // 누르면 사각형
		
		order.setBackground(Color.GRAY); // 색
		delete.setBackground(Color.GRAY); // 색
		coupon.setBackground(Color.GRAY); // 색
		detail.setBackground(Color.GRAY); // 색
		order.setForeground(Color.white); // 색
		delete.setForeground(Color.white); // 색
		coupon.setForeground(Color.white); // 색
		detail.setForeground(Color.white); // 색
		
		order.setFont(font);
		delete.setFont(font);
		coupon.setFont(font);
		detail.setFont(font);

		right.add(order);
		right.add(delete);
		right.add(coupon);
		right.add(detail);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("삭제")) {
					tableDemo.deleteBasket(basketTable, basketModel);
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("주문하기")) {
					tableDemo.addBasket();
				}
			}
		});
		coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("쿠폰")) {
					couponclass.setup(basketModel);
				}
			}
		});
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("주문상세")) {
					tableDemo.basketDetail();
				}
			}
		});
	}

}