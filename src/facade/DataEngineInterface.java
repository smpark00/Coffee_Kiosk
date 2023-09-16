package facade;

import java.util.List;

import mgr.Manageable;

public interface DataEngineInterface {
	// �� �Ŵ����� �����ϴ� �����͸� ���̺� �����ֱ� ���� 
	// �������� ������ �迭�� ��ȯ. �ʿ��� ���� ������ŭ �迭�� ��ȯ��
	int getColumnCount();
	String[] getColumnNames();
	// ���Ͽ��� Manager�� �����͸� ��� �о����
	void readAll(String filename);
	// Ű���忡 ��ġ�Ǵ� ���� ��� ã�� ����Ʈ�� ��ȯ
	List<Manageable> search(String kwd);
	// UI ���̺��� �࿡ �ִ� �����͸� ��Ʈ�� �迭�� �޾ƿͼ� ���ο� ��ü �߰�
	void addNewItem(String[] uiTexts);
	// UI ���̺��� �࿡ �ִ� �����͸� ��Ʈ�� �迭�� �޾ƿͼ� �ش� ��ü ����
	void update(String[] uiTexts);
	// UI ���̺��� ���� ù��° �����͸� Ű�� �޾ƿ� �ش� ��ü�� ã�� ����
	void remove(String kwd);
}
