package top.vabook.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import top.vabook.dao.StoreDao;
import top.vabook.dao.UserDao;
import top.vabook.domain.StoreEm;
import top.vabook.domain.User;
import top.vabook.util.MsgUtil;
import top.vabook.util.QueryUtil;

//������ѯ�豸������Ϣ���û���½ϵͳ���޸�����
public class UserUI implements ActionListener {

	static JFrame jFrame;

	private static Container container;

	private static JLabel findInNameLabel, userLabel, changePasswordLabel,errorLabel;

	private static JTable emTable, userTable;

	private static DefaultTableModel emTableModel, userTableModel;

	private static TableRowSorter<TableModel> sorter;

	private static JTextField textField,nameField,passwordField,passwordLastField1,passwordLastField2;

	private static JPanel panel,panel1, panel2,panel3, emPanel, userPanel, emtablePanel, usertablePanel;
	
	//������Ҫ�Ļ������
	private static JScrollPane jScrollPane;

	private static Button queryButton,userSubmitButton,cancleButton;

	private static String[] emColumns = { "�豸��", "�豸��", "�豸״̬", "����" };

	private static String[][] data = {};
	
	private static List<StoreEm> storeEms,queryEms;
	
	private StoreDao storeDao;
	
	
	private List<User> users;
	
	private static Boolean usernameFlag = false;
	private static Boolean passwordFlag = false;
	private static Boolean newPasswordFlag = false;
	private static Boolean againPasswordFlag = false;
	

	public UserUI() {
		
	}
	public void show() {

		jFrame = new JFrame("�û�����");
		jFrame.setSize(700, 620);
		jFrame.setLocation(400, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());

		panel = new JPanel();
		//���ú�,panel1,panel2,panel3��ƽ������ĸ߶�
//		panel.setPreferredSize(new Dimension(620, 480));
		panel.setLayout(new GridLayout(3, 1));
		
		// panel1�����˲�ѯ�豸,�Լ���ѯ���
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(400, 250));
		panel1.setLayout(new GridLayout(2, 1));
		

		// emPanel ���ز�ѯ
		emPanel = new JPanel();
		emPanel.setPreferredSize(new Dimension(380, 30));
		emPanel.setLayout(new FlowLayout());

		// ��ѯ
		findInNameLabel = new JLabel("�����豸��");
		container.add(findInNameLabel);
		emPanel.add(findInNameLabel, new FlowLayout(FlowLayout.LEFT));

		textField = new JTextField("", 15);
		container.add(textField);
		emPanel.add(textField, new FlowLayout(FlowLayout.LEFT));

		queryButton = new Button("��ѯ");
		container.add(queryButton);
		emPanel.add(queryButton, new FlowLayout(FlowLayout.LEFT));
		queryButton.addActionListener(this);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		container.add(errorLabel);
		emPanel.add(errorLabel,new FlowLayout(FlowLayout.LEFT));

		// emTablePanel �����豸��ѯ���
		emtablePanel = new JPanel();
		emtablePanel.setPreferredSize(new Dimension(340, 210));
		emtablePanel.setLayout(new BorderLayout());

		// �豸��
		emTableModel = new DefaultTableModel(data, emColumns);
		emTable = new JTable(emTableModel);
		emTable.setSize(new Dimension(330, 200));
		sorter = new TableRowSorter<TableModel>(emTable.getModel());
		emTable.setRowSorter(sorter);
		
		emtablePanel.add(emTable);
		jScrollPane = new JScrollPane(emTable);
		jScrollPane.setPreferredSize(new Dimension(330, 200));
		emtablePanel.add(jScrollPane);
		
		panel1.add(emPanel);
		panel1.add(emtablePanel);

		
		/**
		 * ����ϵͳ�û�
		 * 
		 * ϵͳ�û������޸�
		 * ���ڴ˴������û���
		 * ������ԭʼ����
		 * ������������
		 * ���ٴ�����������
		 */
		
		
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(300, 280));
		
		users = UserDao.query();
		
		userPanel = new JPanel();
		userPanel.setPreferredSize(new Dimension(290, 180));
		userPanel.setLayout(new GridLayout(5, 1));
		
		userLabel = new JLabel("ϵͳ�û������޸�");
		container.add(userLabel);
		userPanel.add(userLabel);
		
		nameField = new JTextField("���ڴ˴������û���");
		nameField.setForeground(Color.red);
		nameField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String string = nameField.getText();
				
					if (!QueryUtil.searchUserName(string, users)) {
						nameField.setText("û�д��û�");
					}else {
						usernameFlag = true;
					}
				
			}
			@Override
			//������
			public void focusGained(FocusEvent e) {
				String string = nameField.getText();
				if ("���ڴ˴������û���".equals(string) || "û�д��û�".equals(string)) {
					nameField.setText("");
				}
			}
		});
		nameField.addActionListener(this);
		container.add(nameField);
		userPanel.add(nameField);
		
		passwordField = new JTextField("������ԭʼ����");
		passwordField.setForeground(Color.red);
		passwordField.addFocusListener(new FocusListener() {
			
			//�û����������
			@Override
			public void focusLost(FocusEvent e) {
				String string = passwordField.getText();
				//��ѯ���ݿ��е������Ƿ�һ��,ֱ����ʾ
				users = UserDao.query();
				if (!QueryUtil.searchPassword(string, users)) {
					passwordField.setText("��������ȷ������");
				}else {
					passwordFlag = true;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				String string = passwordField.getText();
				if ("��������ȷ������".equals(string) || "������ԭʼ����".equals(string)) {
					passwordField.setText("");
				}
			}
		});
		passwordField.addActionListener(this);
		container.add(passwordField);
		userPanel.add(passwordField);
		
		passwordLastField1 = new JTextField("������������");
		passwordLastField1.setForeground(Color.red);
		passwordLastField1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String string = passwordLastField1.getText();
				if (string.isEmpty()) {
					passwordLastField1.setText("������������");
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				String string = passwordLastField1.getText();
				if ("������������".equals(string)) {
					passwordLastField1.setText("");
				}
			}
		});
		passwordLastField1.addActionListener(this);
		container.add(passwordLastField1);
		userPanel.add(passwordLastField1);
		
		passwordLastField2 = new JTextField("���ٴ�����������");
		passwordLastField2.setForeground(Color.red);
		passwordLastField2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String string = passwordLastField2.getText();
				if (string.isEmpty()) {
					passwordLastField2.setText("���ٴ�����������");
				}
				if (!string.equals(passwordLastField1.getText())) {
					passwordLastField2.setText("�������벻һ��");
				}else {
					againPasswordFlag = true;
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				String string = passwordLastField2.getText();
				if ("���ٴ�����������".equals(string) || "�������벻һ��".equals(string)) {
					passwordLastField2.setText("");
				}
				
			}
		});
		
		
		
		panel2.add(userPanel);
		
		panel.add(panel1);
		panel.add(panel2);
		
		container.add(passwordLastField2);
		userPanel.add(passwordLastField2);
		
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2));
		panel3.setPreferredSize(new Dimension(180, 40));
		
		userSubmitButton = new Button("�޸�");
		container.add(userSubmitButton);
		panel3.add(userSubmitButton);
		userSubmitButton.addActionListener(this);
		
		cancleButton = new Button("ȡ���޸�");
		container.add(cancleButton);
		panel3.add(cancleButton);
		cancleButton.addActionListener(this);
		
		
		jFrame.add(panel);
		jFrame.add(panel3);
		jFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == queryButton) {
			
			//ÿһ�β�ѯʱ���ÿ�
			emTableModel.setRowCount(0);
			String emName = textField.getText();  
			if (!emName.isEmpty()) {
				
				//������ʾ��Ϣ
				errorLabel.setText("���ڲ�ѯ...");
				
				storeDao = new StoreDao();
				//��ѯȫ�����
				storeEms = storeDao.query();
				//ɸѡ
				queryEms =  QueryUtil.searchInName(emName, storeEms);
				if (queryEms.size() > 0) {
					for(StoreEm store :queryEms) {
						emTableModel.addRow(store.covertArray());
					}
					errorLabel.setText("��ѯ�ɹ�");
				}else {
					errorLabel.setText("û�д��豸");
				}
				
			}else {
				errorLabel.setText("�������豸��!");
			}
		}
		
		if (e.getSource() == userSubmitButton) {
			String newName = nameField.getText();
			String newpassword = passwordLastField1.getText();
			MsgUtil.show((UserDao.update(newName, newpassword)));
			
		}
		if (e.getSource() == cancleButton) {
			nameField.setText("���ڴ˴������û���");
			passwordField.setText("������ԭʼ����");
			passwordLastField1.setText("������������");
			passwordLastField2.setText("���ٴ�����������");
		}
	}

	public void close() {
		jFrame.dispose();
	}
}
