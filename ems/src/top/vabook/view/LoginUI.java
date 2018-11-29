package top.vabook.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginUI implements ActionListener{
	static String title = "��ӭ��½�豸����ϵͳ";
	private static JFrame jFrame = new JFrame(title);
	//�û���½
	private static JLabel nameLabel,passwordLabel,errorLaebl;
	
	private static JPanel loginPanel,namePanel,passPanel,functionPanel;
	
	private static JTextField nameField,passwordField;
	
	private static JButton loginButton ;
	//����
	private static Container container;
	
	private static boolean login_success = false;
	
	//�߸�����ģ��,���ð�ť������
	private static Button buyButton,lendButton,repairButton,storeButton,scrapButton,userButton,exitButton;
	
	//��ʼ��
	public LoginUI() {
		
		//��JFrame��������
		jFrame.setSize(598,500);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��jFrame��������
		container = jFrame.getContentPane();
		//��������,���ж���,Ĭ��5��Ԫˮƽ�ʹ�ֱ��϶
		container.setLayout(new FlowLayout());
		
		//��½���,����һ���µı߽粼�֣����֮��û�м�϶
		namePanel = new JPanel();
		namePanel.setLayout(new BorderLayout());
//		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		passPanel = new JPanel();
		passPanel.setLayout(new BorderLayout());
//		passPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		//�����˸���Ч��
//		loginPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//�û���
		nameLabel = new JLabel("�û��� :");
		container.add(nameLabel);
		namePanel.add(nameLabel,BorderLayout.WEST);
		
		nameField = new JTextField("",15);
		container.add(nameField);
		namePanel.add(nameField,BorderLayout.EAST);
		nameField.addActionListener(this);
		
		//����
		passwordLabel = new JLabel("����:");
		container.add(passwordLabel);
		passPanel.add(passwordLabel,BorderLayout.WEST);
		
		passwordField = new JTextField("",15);
		container.add(passwordField);
		passPanel.add(passwordField,BorderLayout.EAST);
		passwordField.addActionListener(this);
		
		//��½��ť
		loginButton = new JButton("��½");
		container.add(loginButton);
		loginPanel.add(loginButton,BorderLayout.WEST);
		loginButton.addActionListener(this);
		
		//��¼����
		errorLaebl = new JLabel("���¼");
		errorLaebl.setForeground(Color.red);
		container.add(errorLaebl);
		loginPanel.add(errorLaebl,BorderLayout.EAST);
		
		//����ģ��
		functionPanel = new JPanel();
//		functionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//�����񲼾�!
		functionPanel.setLayout(new GridLayout(7, 1));
//		functionPanel.setSize(160, 300);
		
		//�������
		buyButton = new Button("�������");
		container.add(buyButton);
		functionPanel.add(buyButton);
		buyButton.addActionListener(this);
		
		//ת�����
		lendButton = new Button("ת�����");
		container.add(lendButton);
		functionPanel.add(lendButton);
		lendButton.addActionListener(this);
		
		//repairButton,storeButton,scrapButton,userButton,exitButton;
		
		//ά�޹���
		repairButton = new Button("ά�޹���");
		container.add(repairButton);
		functionPanel.add(repairButton);
		repairButton.addActionListener(this);
		
		//�洢����
		storeButton = new Button("�洢����");
		container.add(storeButton);
		functionPanel.add(storeButton);
		storeButton.addActionListener(this);
		
		//���Ϲ���
		scrapButton = new Button("���Ϲ���");
		container.add(scrapButton);
		functionPanel.add(scrapButton);
		scrapButton.addActionListener(this);
		
		//�û�����
		userButton = new Button("�û�����");
		container.add(userButton);
		functionPanel.add(userButton);
		userButton.addActionListener(this);
		
		//�˳�ϵͳ
		exitButton = new Button("�˳�ϵͳ");
		container.add(exitButton);
		functionPanel.add(exitButton);
		exitButton.addActionListener(this);
		
		//�������ӵ������
		jFrame.add(namePanel);
		jFrame.add(passPanel);
		jFrame.add(loginPanel);
		jFrame.add(functionPanel,BorderLayout.CENTER);

		jFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText();
		String password = passwordField.getText();
		if(e.getSource() == loginButton) {
			if ("admin".equals(name) && "root".equals(password)) {
				errorLaebl.setText("��¼�ɹ�!");
				login_success = true;
			}else {
				errorLaebl.setText("��¼ʧ��");
				login_success = false;
			}
		}
		if (e.getSource() == buyButton) {
			
		}
		if (e.getSource() == lendButton) {
			
		}
		if (e.getSource() == repairButton) {
			
		}
		if (e.getSource() == storeButton) {
			
		}
		if (e.getSource() == scrapButton) {
			
		}
		if (e.getSource() == userButton) {
			
		}
		if (e.getSource() == exitButton) {
			
		}
		if (e.getSource() == buyButton) {
			
		}
	}
	
	public static void main(String[] args) {
		new  LoginUI();
	}
}
