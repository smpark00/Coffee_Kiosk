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
	JButton button = new JButton("확인");

	DetailBasket(String[] content) {
		this.content = content;
	}

	void detail() {
		pane.setBackground(Color.darkGray);

		contentLabel[0] = new JLabel("상품명: " + content[1]);
		contentLabel[1] = new JLabel("개수: " + content[2]);
		contentLabel[2] = new JLabel("사이즈: " + content[3]);
		contentLabel[3] = new JLabel("휘핑크림: " + content[4]);
		contentLabel[4] = new JLabel("소계: " + content[5]);
		
		contentLabel[0].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[1].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[2].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[3].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[4].setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < 5; i++) {
			contentLabel[i].setForeground(Color.white);
			pane.add(contentLabel[i]);
		}
		
		button.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		button.setFocusPainted(false); // 누르면 사각형
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
				if (e.getActionCommand().equals("확인")) {
					frame.dispose();
				}
			}
		});
	}
}
