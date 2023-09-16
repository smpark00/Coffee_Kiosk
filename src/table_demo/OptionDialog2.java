package table_demo;

import javax.swing.JLabel;
import javax.swing.JPanel;

import facade.UIData;
import store.Order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class OptionDialog2 extends javax.swing.JDialog {
	String[] itemDetails;
	JLabel details[] = new JLabel[5];
	Order ord;
	String size;
	Boolean whip;
	int extraprice;
	TableSelectionDemo table;
	JFrame window = new JFrame("Whipping Selection");

	OptionDialog2(String[] texts, Order od, String size, int price, TableSelectionDemo table) {
		// super(GUIMain.mainFrame);
		itemDetails = texts;
		ord = od;
		this.size = size;
		extraprice = price;
		this.table = table;
	}

	void setup() {

		JPanel pane = new JPanel(new FlowLayout());
		pane.setBackground(Color.darkGray); // ��
		details[4] = new JLabel("����ũ�� ");
		details[4].setForeground(Color.white);
		pane.add(details[4]);
		JButton O = new JButton("O");
		O.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		O.setFocusPainted(false); // ������ �簢��
		O.setBackground(Color.gray);
		O.setForeground(Color.white);
		pane.add(O);
		JButton X = new JButton("X");
		X.setBorderPainted(false); // �׵θ�
		// b.setContentAreaFilled(false); // ������ �Ķ���
		X.setFocusPainted(false); // ������ �簢��
		X.setBackground(Color.gray);
		X.setForeground(Color.white);
		pane.add(X);
		// ���� �ƿ� �߰� ������ �ؾ���
		window.setBounds(500, 500, 700, 300);
		O.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("O")) {
					whip = true;
					window.dispose();
					table.addOrder(size, "O", extraprice);
				}
			}
		});
		X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("X")) {
					whip = false;
					window.dispose();
					table.addOrder(size, "X", extraprice);
				}
			}
		});
		window.setBounds(850, 450, 300, 100);
		window.add(pane);
		window.setUndecorated(true);
		window.setSize(300, 38);
		window.setVisible(true);
	}

	void setup(boolean whipping) {
		table.addOrder(size, "����", extraprice);

	}
}