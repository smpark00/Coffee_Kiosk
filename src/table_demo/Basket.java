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

public class Basket extends JPanel { // ��ٱ��Ͽ� �ִ� ��ư�� �׼Ǹ����� ����
	TableSelectionDemo tableDemo = new TableSelectionDemo();

	void setupbasket(JTable basketTable,DefaultTableModel basketModel, JPanel right) {
		Coupon couponclass = new Coupon();
		Font font = new Font("���� ���", Font.BOLD, 20);

		JButton order = new JButton("�ֹ��ϱ�");
		JButton delete = new JButton("����");
		JButton coupon = new JButton("����");
		JButton detail = new JButton("�ֹ���");

		order.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		order.setFocusPainted(false); // ������ �簢��
		delete.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		delete.setFocusPainted(false); // ������ �簢��
		coupon.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		coupon.setFocusPainted(false); // ������ �簢��
		detail.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		detail.setFocusPainted(false); // ������ �簢��
		
		order.setBackground(Color.GRAY); // ��
		delete.setBackground(Color.GRAY); // ��
		coupon.setBackground(Color.GRAY); // ��
		detail.setBackground(Color.GRAY); // ��
		order.setForeground(Color.white); // ��
		delete.setForeground(Color.white); // ��
		coupon.setForeground(Color.white); // ��
		detail.setForeground(Color.white); // ��
		
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
				if (e.getActionCommand().equals("����")) {
					tableDemo.deleteBasket(basketTable, basketModel);
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�ֹ��ϱ�")) {
					tableDemo.addBasket();
				}
			}
		});
		coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("����")) {
					couponclass.setup(basketModel);
				}
			}
		});
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�ֹ���")) {
					tableDemo.basketDetail();
				}
			}
		});
	}

}