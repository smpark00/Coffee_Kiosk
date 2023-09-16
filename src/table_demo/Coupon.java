package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Coupon {
	JFrame window = new JFrame("Coupon");
	JPanel pane = new JPanel(new BorderLayout());
	JPanel pane2 = new JPanel(new FlowLayout());
	JButton button = new JButton("Ȯ��");
	JButton button2 = new JButton("���");
	JTable table = new JTable();
	static JTextField kwdTextField;
	TableSelectionDemo tableDemo = new TableSelectionDemo();

	void setup(DefaultTableModel basketModel) {
		table.setModel(basketModel);
		if (table.getRowCount() == 0) {
			AlarmWindow window = new AlarmWindow("                 �ֹ��� ���� �߰��ϼ���.");
			window.alarm();
			return;
		}
		button.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		button.setFocusPainted(false); // ������ �簢��
		button.setBackground(Color.white);
		button2.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		button2.setFocusPainted(false); // ������ �簢��
		button2.setBackground(Color.white);
		window.setBounds(850, 450, 300, 100);
		window.add(pane);
		window.setUndecorated(true);
		window.setSize(300, 40);
		window.setVisible(true);
		kwdTextField = new JTextField("", 10);
		pane.add(pane2, BorderLayout.CENTER);
		pane2.add(kwdTextField, BorderLayout.WEST);
		pane2.add(button);
		pane2.add(button2);
		pane2.setBackground(Color.gray);
		pane2.setForeground(Color.white);
		button.setBackground(Color.white);
		button2.setBackground(Color.white);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ȯ��")) {
					tableDemo.discount(kwdTextField.getText());
					kwdTextField.hide();
					window.dispose();
					return;
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("���")) {
					kwdTextField.hide();
					window.dispose();
				}
			}
		});

	}
}