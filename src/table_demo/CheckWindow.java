package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckWindow {
	int orderId;
	JFrame window=new JFrame("Order Complete");
	JPanel pane=new JPanel(new BorderLayout());
	JButton button=new JButton("Ȯ��");
	JLabel string;
	CheckWindow(int orderId){
		this.orderId=orderId;
	}
	
	void check() {
		string=new JLabel("              "+orderId+"�� �ֹ��� �Ϸ�Ǿ����ϴ�.");
		button.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		button.setFocusPainted(false); // ������ �簢��
		string.setForeground(Color.white);
		button.setBackground(Color.gray);
		button.setForeground(Color.white);
		pane.setBackground(Color.DARK_GRAY);
		pane.add(string, BorderLayout.CENTER);
		pane.add(button, BorderLayout.AFTER_LINE_ENDS);
		window.setBounds(850,450,300,100);
		window.add(pane);
		window.setUndecorated(true);
		window.setSize(300,38);
		window.setVisible(true);
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("Ȯ��")) {
        			window.dispose();
            	}
           }
        });
	}
}
