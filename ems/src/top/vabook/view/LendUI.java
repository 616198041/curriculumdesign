package top.vabook.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import top.vabook.dao.LendDao;
import top.vabook.util.DateUtil;
import top.vabook.util.ErrorUtil;
import top.vabook.util.MsgUtil;

//ת�������Ҫ����ת���豸�ţ�ת���豸���������ˣ�������ڣ��黹���ڡ�
public class LendUI implements ActionListener {

	static JFrame jFrame;

	private JLabel emNoLabel, emNameLabel, emPeopleLabel, lendDateLabel, returnDateLabel;

	private JComboBox<String> emNoBox, emNameBox, emPeopleBox;

	private static JTextField lendDateField, returnDateField;

	private static JPanel panel, datePanel1, datePanel2;

	private static Container container;

	private static Button submitButton, exitButton;

	static String[] peopleNames = { "tom", "tomas", "tomcat", "mycat" };

	static String[] emNos = { "0", "1", "2", "3", "4", "5" };

	static String[] emNames = { "Computer", "Aircondition", "Projector", "Disk", "Sofa", "Cup" };

	public LendUI() {
		
	}
	public void show() {

		jFrame = new JFrame("ת�����");
		jFrame.setLocation(500, 300);
		jFrame.setSize(500, 600);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());

		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2));
		panel.setSize(400, 500);
		datePanel1 = new JPanel();
		datePanel1 = DateUtil.getDatePanel();
		datePanel2 = new JPanel();
		datePanel2 = DateUtil.getDatePanel();

		// ת���豸��
		emNoLabel = new JLabel("ת���豸��");
		emNoBox = new JComboBox<>(emNos);
		container.add(emNoLabel);
		panel.add(emNoLabel);
		container.add(emNoBox);
		panel.add(emNoBox);

		// ת���豸��
		emNameLabel = new JLabel("ת���豸��");
		emNameBox = new JComboBox<>(emNames);
		container.add(emNameLabel);
		panel.add(emNameLabel);
		container.add(emNameBox);
		panel.add(emNameBox);

		// ������
		emPeopleLabel = new JLabel("������");
		emPeopleBox = new JComboBox<>(peopleNames);
		container.add(emPeopleLabel);
		panel.add(emPeopleLabel);
		container.add(emPeopleBox);
		panel.add(emPeopleBox);

		// ��������
		lendDateLabel = new JLabel("��������");
		container.add(lendDateLabel);
		panel.add(lendDateLabel);
		container.add(datePanel1);
		panel.add(datePanel1);

		// �黹����
		returnDateLabel = new JLabel("�黹����");
		container.add(returnDateLabel);
		panel.add(returnDateLabel);
		container.add(datePanel2);
		panel.add(datePanel2);

		// �ύ
		submitButton = new Button("�ύ");
		submitButton.setForeground(Color.BLUE);
//		submitButton.setBackground(Color.red);
		container.add(submitButton);
		panel.add(submitButton);
		submitButton.addActionListener(this);

		// ȡ��
		exitButton = new Button("�˳�");
		exitButton.setForeground(Color.BLUE);
		container.add(exitButton);
		panel.add(exitButton);
		exitButton.addActionListener(this);

		jFrame.add(panel);
//		jFrame.add(submitButton);
//		jFrame.add(exitButton);

		jFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String emNo, emName, peopleName, lendDate, returnDate;
		emNo = emNos[emNoBox.getSelectedIndex()];
		emName = emNames[emNameBox.getSelectedIndex()];
		peopleName = peopleNames[emPeopleBox.getSelectedIndex()];
		JComboBox yearBox1 = (JComboBox) datePanel1.getComponent(0);
		JComboBox monthBox1 = (JComboBox) datePanel1.getComponent(1);
		JComboBox dayBox1 = (JComboBox) datePanel1.getComponent(2);
		String year1 = yearBox1.getSelectedItem().toString();
		String month1 = monthBox1.getSelectedItem().toString();
		String day1 = dayBox1.getSelectedItem().toString();
		lendDate = year1 + "-" + month1 + "-" + day1;

		JComboBox yearBox = (JComboBox) datePanel2.getComponent(0);
		JComboBox monthBox = (JComboBox) datePanel2.getComponent(1);
		JComboBox dayBox = (JComboBox) datePanel2.getComponent(2);
		String year = yearBox.getSelectedItem().toString();
		String month = monthBox.getSelectedItem().toString();
		String day = dayBox.getSelectedItem().toString();
		returnDate = year + "-" + month + "-" + day;

		if (e.getSource() == submitButton) {
			if (lendDate.compareTo(returnDate) < 0) {
				LendDao lendDao = new LendDao();
				lendDao.insert(emNo,emName,peopleName,lendDate,returnDate);
				MsgUtil.show(true);
			}else {
				String errMsg = "�������ڱ�����ڽ�������,������";
				ErrorUtil.show(errMsg);
			}
		}
		if (e.getSource() == exitButton) {
			jFrame.dispose();
		}

	}

	public void close() {
		jFrame.dispose();
	}
}
