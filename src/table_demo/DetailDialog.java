package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import store.Item;
import store.Review;

public class DetailDialog extends javax.swing.JDialog {
	String[] itemDetails;
	String[] ingredient;// ���и� ���� ������ ������ ����
	String[] reviews;
	JLabel details[] = new JLabel[20];
	String[] revStr=new String[5];
	Item item;
	ArrayList<Review> reviewList=new ArrayList<>();
	DetailDialog(String[] texts, String[] text, Item item) {
		super(GUIMain.mainFrame);
		itemDetails = texts;
		ingredient = text;
		this.item=item;
	}

	void setup() {
		setTitle("��ǰ�󼼺���");

		if (ingredient.length > 1) {
			for (int i = 0; i < ingredient.length - 1; i++) {
				ingredient[i] = ingredient[i].concat(", " + ingredient[i + 1]);
			}
		}
		String comIngredient = ingredient[0];

		JPanel lpane = new JPanel(new GridLayout(3, 2));
		ImageIcon icon = new ImageIcon("�׸�4.png");
		JPanel pane = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null); // �̹��� ����������� �ֱ�

				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null); // ������Ʈ ����� �°�
			}
		};
		JPanel rpane = new JPanel();
		//��Ʈ����
		Font font = new Font("���� ���", Font.BOLD, 20); 
		Font font1 = new Font("���� ���", Font.BOLD, 15);
		
		setReview(item);
		details[0] = new JLabel("��ǰ�ڵ�: " + itemDetails[0]);
		details[1] = new JLabel("��ǰ��: " + itemDetails[1]);
		details[2] = new JLabel("����: " + itemDetails[2]);
		details[3] = new JLabel("����: " + comIngredient);
		details[4] = new JLabel("������:" + itemDetails[3]);		
		int index=0;
		/*for(Review rev:reviewList) {
			details[index]=new JLabel(rev.userName+" "+rev.itemName+" "+rev.rank+" "+rev.content);
			index++;
		}*/
		for(Review rev:reviewList) {
			revStr[index]="\n"+rev.userName+" "+rev.itemName+" "+rev.rank+"\n"+rev.content+"\n\n";
			index++;
		}
		JLabel photo = new JLabel(new ImageIcon("MENU/" + itemDetails[1] + ".jpg"));

		rpane.setOpaque(false);
		lpane.setOpaque(false);
		// photo.setOpaque(false); // JLabel�� �⺻�� ��� ����
		photo.setPreferredSize(new Dimension(300, 300)); // �̹���ũ�� �ϴ� 300 300 ��Ҵµ� ���߿� ���� ��

		details[0].setHorizontalAlignment(JLabel.CENTER);
		details[1].setHorizontalAlignment(JLabel.CENTER);
		details[2].setHorizontalAlignment(JLabel.CENTER);
		details[3].setHorizontalAlignment(JLabel.CENTER);
		details[4].setHorizontalAlignment(JLabel.CENTER);
		//details[5].setHorizontalAlignment(JLabel.CENTER);
		/*for(int i=5; i<index; i++) {
			details[i].setHorizontalAlignment(JLabel.CENTER);
		}*/

		// ��Ʈ ����
		details[0].setFont(font);
		details[1].setFont(font);
		details[2].setFont(font);
		details[3].setFont(font);
		details[4].setFont(font);
		//details[5].setFont(font);
		/*for(int i=5; i<index; i++) {
			details[i].setFont(font1);
		}*/
		// ���� �� ����
		details[0].setForeground(Color.white);
		details[1].setForeground(Color.white);
		details[2].setForeground(Color.white);
		details[3].setForeground(Color.white);
		details[4].setForeground(Color.white);
		//details[5].setForeground(Color.white);
		/*for(int i=5; i<index; i++) {
			details[i].setForeground(Color.red);
		}*/
		
		JTextArea review=new JTextArea();
		
		lpane.add(details[0]);
		lpane.add(details[1]);
		lpane.add(details[2]);
		lpane.add(details[3]);
		lpane.add(details[4]);
		// lpane.add(details[6]);
		for(int i=0; i<index; i++) {
			review.append(revStr[i]);
		}
		
		review.setFont(font1);
		review.setPreferredSize(new Dimension(450,150));
		review.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		review.setBackground(new Color(0,2,13));
		review.setForeground(Color.white);
		review.enable(false);
		
		/*JScrollPane scroll=new JScrollPane(review
				, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
				, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);*/
		JPanel scroll=new JPanel(new BorderLayout()) {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null); // �̹��� ����������� �ֱ�

                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null); // ������Ʈ ����� �°�
            }
        };
        scroll.add(review);
		scroll.setBorder(BorderFactory.createEmptyBorder(5,0,0,5));
		pane.add(lpane,BorderLayout.CENTER);
		pane.add(scroll,BorderLayout.AFTER_LINE_ENDS);
		pane.add(photo, BorderLayout.WEST);

		this.setMinimumSize(new Dimension(1190, 410)); // ��ȭ���� ũ�� ����
		this.setLocation(365, 540);
		this.setResizable(false);// ũ�� ���� �Ұ�
		setContentPane(pane);
	}
	
	void setReview(Item item) {
		for(Review rev:Item.revList) {
			if(rev.itemName.contentEquals(item.itemName))
				reviewList.add(rev);
		}
	}
}