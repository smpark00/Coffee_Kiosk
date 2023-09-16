package table_demo;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import facade.DataEngineInterface;
import store.Item;

public class TableEvent extends JPanel implements MouseListener{
	TableSelectionDemo table;
	JTable jTable;
	//table을 받아서 오른쪽처럼 해보기
	public TableEvent(TableSelectionDemo tableDemo) {
		this.table=tableDemo;
		jTable=tableDemo.table;
	}
	public void addEvent() {
		jTable.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			//table.getImage();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
