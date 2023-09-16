package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlarmWindow {
	String content;
	JFrame frame=new JFrame("CAFE UNIVERSE");
	JLabel contentLabel;
	JPanel pane=new JPanel(new BorderLayout());
	JButton button=new JButton("확인");
	AlarmWindow(String content){
		this.content=content;
	}
	void alarm() {
		button.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		button.setFocusPainted(false); // 누르면 사각형
		button.setBackground(Color.gray);
		button.setForeground(Color.white);
		pane.setBackground(Color.darkGray);
		contentLabel=new JLabel(content);
		contentLabel.setForeground(Color.white);
		pane.add(contentLabel, BorderLayout.CENTER);
		pane.add(button, BorderLayout.AFTER_LINE_ENDS);
		frame.setBounds(850,450,300,100);
		frame.add(pane);
		frame.setUndecorated(true);
		frame.setSize(300,38);
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
