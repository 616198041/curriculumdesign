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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.Current;

import top.vabook.dao.BuyDao;
import top.vabook.util.DBConnection;
import top.vabook.util.MsgUtil;

//�������
public class BuyUI implements ActionListener {

	static JFrame jFrame;
	private static Container container;
	private static JPanel panel;
	private static JLabel countLabel, dateLabel, costLabel;
	private static JTextField countField, dateField, costField;

	// ������,������Ա
	private static JComboBox<String> peopleBox, emNoBox, emNameBox;

	private static JLabel peopleLabel, emNoLabel, emNameLabel, msg;

	private static Button submitButton, exitButton;

	private static Boolean flag;

	private static BuyDao buyDao;

	// ������Ա���豸�ţ��豸����
	static String[] peopleNames = { "tom", "tomas", "tomcat", "mycat" };
	static String[] emNos = { "0", "1", "2", "3", "4", "5" };
	static String[] emNames = { "Computer", "Aircondition", "Projector", "Disk", "Sofa", "Cup" };

	public BuyUI() {
		
	}
	public void show() {

		jFrame = new JFrame("�������");
		jFrame.setSize(500, 500);
		jFrame.setLocation(700, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());

		// �������
		panel = new JPanel();
		Dimension preferredSize = new Dimension(250, 200);
		panel.setPreferredSize(preferredSize);
		panel.setLayout(new GridLayout(6, 2));
		
		

		// ��������
		countLabel = new JLabel("��������:");
		container.add(countLabel);
		panel.add(countLabel);

		countField = new JTextField("", 4);
		container.add(countField);
		panel.add(countField);

		// ��������
		dateLabel = new JLabel("��������:");
		container.add(dateLabel);
		panel.add(dateLabel);

		dateField = new JTextField("Ĭ��ʹ��ϵͳ��ǰʱ��");
		dateField.setForeground(Color.RED);
		container.add(dateField);
		panel.add(dateField);

		// ���򾭷�
		costLabel = new JLabel("���򾭷�");
		container.add(costLabel);
		panel.add(costLabel);

		costField = new JTextField("", 4);
		container.add(costField);
		panel.add(costField);

		// ��Ա
		peopleBox = new JComboBox<String>(peopleNames);
		peopleLabel = new JLabel("��Ա");
		container.add(peopleLabel);
		panel.add(peopleLabel);
		container.add(peopleBox);
		panel.add(peopleBox);

		// �豸��
		emNoBox = new JComboBox<String>(emNos);
		emNoLabel = new JLabel("�豸��");
		container.add(emNoLabel);
		panel.add(emNoLabel);
		container.add(emNoBox);
		panel.add(emNoBox);
//		int[] nos = {0,1,2,3,4,5};

		// �豸����
		emNameBox = new JComboBox<String>(emNames);
		emNameLabel = new JLabel("�豸����");
		container.add(emNameLabel);
		panel.add(emNameLabel);
		container.add(emNameBox);
		panel.add(emNameBox);

		// ������ť
		submitButton = new Button("�ύ");
		submitButton.addActionListener(this);

		exitButton = new Button("�˳�");
		exitButton.addActionListener(this);

		jFrame.add(panel);
		
		container.add(submitButton);
		jFrame.add(submitButton,new FlowLayout(FlowLayout.LEFT));
		container.add(exitButton);
		jFrame.add(exitButton,new FlowLayout(FlowLayout.RIGHT));

		jFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int count = 0;
//		String date;
		int cost = 0;

		String peopleName, emNo, emName;
		peopleName = peopleNames[peopleBox.getSelectedIndex()];
		emNo = emNos[emNoBox.getSelectedIndex()];
		emName = emNames[emNameBox.getSelectedIndex()];

		// ���������п�
		if ( !(countField.getText()).isEmpty()) {
			count = Integer.parseInt(countField.getText());
		}

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);

		if (!(costField.getText()).isEmpty()) {
			cost = Integer.parseInt(costField.getText());
		}

		if (e.getSource() == submitButton) {
			if (count != 0 && cost != 0 && peopleName != null && emNo != null && emName != null) {

				System.out.println(count + "  " + cost + peopleName + emName + emNo + dateStr);
				// �������ݿ���
				buyDao = new BuyDao();
				buyDao.insert(count, dateStr, cost, peopleName, emNo, emName);
				flag = true;
			} else {
				flag = false;
			}

			MsgUtil.show(flag);
		}
		
		if (e.getSource() == exitButton) {
			jFrame.dispose();
		}
	}


	public void close() {
		jFrame.dispose();
	}

}
