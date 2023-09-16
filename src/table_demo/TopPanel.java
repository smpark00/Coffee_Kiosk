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
	// Item �˻� ���� ��� �г� �����ϱ�
	void setupTopPane(TableSelectionDemo tableDemo) {
		JPanel topPane = new JPanel();
		add(topPane);
		topPane.setBackground(Color.GRAY);// ����
		JButton detail = new JButton("�󼼺���");
		detail.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		detail.setFocusPainted(false); // ������ �簢��
		detail.setBackground(Color.white);
		topPane.add(detail);
		JButton order = new JButton("�ֹ��ϱ�");
		order.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		order.setFocusPainted(false); // ������ �簢��
		//order.setBackground(Color.white);
		//order.setForeground(Color.black);
		order.setBackground(Color.black);
		order.setForeground(Color.white);
		topPane.add(order);

		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�󼼺���")) {
					tableDemo.showDetail();
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�ֹ��ϱ�")) {
					tableDemo.callOption();
				}
			}
		});

	}
}
