package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailBasket {
	String[] content;
	JFrame frame = new JFrame("CAFE UNIVERSE");
	JLabel[] contentLabel = new JLabel[5];
	JPanel pane = new JPanel(new GridLayout(0,1));
	JButton button = new JButton("Ȯ��");

	DetailBasket(String[] content) {
		this.content = content;
	}

	void detail() {
		pane.setBackground(Color.darkGray);

		contentLabel[0] = new JLabel("��ǰ��: " + content[1]);
		contentLabel[1] = new JLabel("����: " + content[2]);
		contentLabel[2] = new JLabel("������: " + content[3]);
		contentLabel[3] = new JLabel("����ũ��: " + content[4]);
		contentLabel[4] = new JLabel("�Ұ�: " + content[5]);
		
		contentLabel[0].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[1].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[2].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[3].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[4].setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < 5; i++) {
			contentLabel[i].setForeground(Color.white);
			pane.add(contentLabel[i]);
		}
		
		button.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		button.setFocusPainted(false); // ������ �簢��
		button.setBackground(Color.gray);
		button.setForeground(Color.white);
		
		pane.add(button);
		frame.setBounds(850, 450, 300, 100);
		frame.add(pane);
		frame.setUndecorated(true);
		frame.setSize(300, 140);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ȯ��")) {
					frame.dispose();
				}
			}
		});
	}
}
