package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanel extends JPanel {
	// Item 검색 탭의 상단 패널 구성하기
	void setupTopPane(TableSelectionDemo tableDemo) {
		JPanel topPane = new JPanel();
		add(topPane);
		topPane.setBackground(Color.GRAY);// 색깔
		JButton detail = new JButton("상세보기");
		detail.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		detail.setFocusPainted(false); // 누르면 사각형
		detail.setBackground(Color.white);
		topPane.add(detail);
		JButton order = new JButton("주문하기");
		order.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		order.setFocusPainted(false); // 누르면 사각형
		//order.setBackground(Color.white);
		//order.setForeground(Color.black);
		order.setBackground(Color.black);
		order.setForeground(Color.white);
		topPane.add(order);

		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("상세보기")) {
					tableDemo.showDetail();
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("주문하기")) {
					tableDemo.callOption();
				}
			}
		});

	}
}
