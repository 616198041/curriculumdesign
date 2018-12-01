package top.vabook.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import top.vabook.dao.StoreDao;
import top.vabook.domain.StoreEm;

//�����������ִ��豸�������豸�ţ��豸��,�豸״̬
public class StoreUI implements ActionListener{

	 JFrame jFrame;

	private static Container container;

	private JPanel panel;

	private JScrollPane scrollPane;

	private static JTable table;

	private static List<StoreEm> storeEms;

	private static Button queryButton, exitButton;

	//
	private static String[] columns = { "����", "�豸��", "�豸��", "�豸״̬" };

	private static String[][] data = new String[24][4];

	private DefaultTableModel tableModel;

	private TableRowSorter<TableModel> sorter;

	private static StoreDao storeDao;

	public StoreUI() {
		
	}
	public void show() {

		jFrame = new JFrame("�洢����");

		jFrame.setLocation(500, 300);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setSize(600, 400);

		container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());

		panel = new JPanel();
//		panel.setLayout(new GridLayout(4, 2));

		// ���ݲ�ѯ
		setData();

		// ����չʾ��table��
		tableModel = new DefaultTableModel(data, columns);
		table = new JTable(tableModel);

		// ������
		sorter = new TableRowSorter<TableModel>(table.getModel());
		sorter.setSortable(1, true);
		table.setRowSorter(sorter);

		// ���Թ��������,����������
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 300));

		// ���
		container.add(scrollPane);
		panel.add(scrollPane);

		
		/*queryButton = new Button("��ѯ");
		container.add(queryButton);
		panel.add(queryButton);
		queryButton.addActionListener(this);*/
		
		exitButton = new Button("�˳�");
		exitButton.setLocation(240, 300);
		exitButton.setBackground(Color.gray);
		exitButton.setPreferredSize(new Dimension(600, 50));
		exitButton.addActionListener(this);
		
		jFrame.add(panel);
		jFrame.add(exitButton);
		jFrame.setVisible(true);

	}

	public static String[][] setData() {

		storeEms = new ArrayList<StoreEm>();

		storeDao = new StoreDao();
		storeEms = storeDao.query();

		int size = storeEms.size();
		System.out.println(storeEms.size());

		for (int j = 0; j < size; j++) {

			StoreEm storeEm = storeEms.get(j);

			data[j][0] = storeEm.emCount + "";
			data[j][1] = storeEm.emNo;
			data[j][2] = storeEm.emName;
			data[j][3] = storeEm.emStatus;

			System.out.println(storeEm.emCount + storeEm.emNo + storeEm.emName + storeEm.emStatus);
		}

		return data;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exitButton) {
			jFrame.dispose();
		}
	}
	
	public void close() {
		jFrame.dispose();
	}
	

}
