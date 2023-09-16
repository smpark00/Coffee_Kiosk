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

public class OptionDialog extends javax.swing.JDialog {
	String[] itemDetails;
	String[] ingredient;// 성분만 따로 받을수 있을까 생각
	JLabel details[] = new JLabel[5];
	Order ord;
	String size;
	int extraprice;
	OptionDialog op = this;
	JFrame window = new JFrame("Size Selection");
	TableSelectionDemo table;

	OptionDialog(String[] texts, Order od, TableSelectionDemo table) {
		// super(GUIMain.mainFrame);
		itemDetails = texts;
		ord = od;
		this.table = table;
	}

	void setup() {
		JPanel pane = new JPanel(new FlowLayout());
		pane.setBackground(Color.darkGray); // 색
		details[4] = new JLabel("사이즈 ");
		details[4].setForeground(Color.white);
		pane.add(details[4]);

		JButton S = new JButton("S");
		S.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		S.setFocusPainted(false); // 누르면 사각형
		S.setBackground(Color.gray);
		S.setForeground(Color.white);
		JButton M = new JButton("M");
		M.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		M.setFocusPainted(false); // 누르면 사각형
		M.setBackground(Color.gray);
		M.setForeground(Color.white);
		JButton L = new JButton("L");
		L.setBorderPainted(false); // 테두리
		// b.setContentAreaFilled(false); // 누를때 파랑색
		L.setFocusPainted(false); // 누르면 사각형
		L.setBackground(Color.gray);
		L.setForeground(Color.white);
		selectedButton(pane, S, M, L);

		window.setBounds(850, 450, 300, 100);
		window.add(pane);
		window.setUndecorated(true);
		window.setSize(300, 38);
		window.setVisible(true);

		S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("S")) {
					size = "S";
					extraprice += 0;
					window.dispose();
					table.callWhip(table, size, extraprice);
				}
			}
		});
		M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("M")) {
					size = "M";
					extraprice += 500;
					window.dispose();
					table.callWhip(table, size, extraprice);
				}
			}
		});
		L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("L")) {
					size = "L";
					extraprice += 1000;
					window.dispose();
					table.callWhip(table, size, extraprice);
				}
			}
		});
	}

	private void selectedButton(JPanel pane, JButton S, JButton M, JButton L) {
		switch (itemDetails[3]) {
		case " S/ M/ L":
			pane.add(S);
			pane.add(M);
			pane.add(L);
			break;
		case " S/ M":
			pane.add(S);
			pane.add(M);
			break;
		case " M/ L":
			pane.add(M);
			pane.add(L);
			extraprice -= 500;
			break;
		case " S/ L":
			pane.add(S);
			pane.add(L);
			break;
		case " S":
			pane.add(S);
			break;
		case " M":
			pane.add(M);
			extraprice -= 500;
			break;
		case " L":
			pane.add(L);
			extraprice -= 1000;
			break;
		}
	}

}