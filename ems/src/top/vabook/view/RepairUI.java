package top.vabook.view;

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

import org.omg.PortableServer.POA;

import top.vabook.dao.RepairDao;
import top.vabook.util.DateUtil;
import top.vabook.util.MsgUtil;

//ά�޹���ά�����ڣ�ά����Ա��ά�޾��ѣ��豸�����豸�š�
public class RepairUI implements ActionListener{
	
	private JFrame jFrame ;
	
	private Container container;
	
	private static JLabel dateLabel,peopleLabel,costLabel,emNoLabel,emNameLabel;
	
	private JPanel panel,datePanel;
	static String[] peopleNames = { "repair-tom", "repair-tomas", "repair-tomcat", "repair-mycat" };

	static String[] emNos = { "0", "1", "2", "3", "4", "5" };

	static String[] emNames = { "Computer", "Aircondition", "Projector", "Disk", "Sofa", "Cup" };

	private static JComboBox peopleBox,emNoBox,emNameBox;
	
	private JTextField costField;
	
	private static Button submitButton, exitButton;
	
	public RepairUI() {
		jFrame = new JFrame("ά�޹���");
		jFrame.setLocation(500, 300);
		jFrame.setSize(500, 400);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setSize(250,300);
		panel.setLayout(new GridLayout(6, 2));
		
		//ά������
		dateLabel = new JLabel("ά������");
		container.add(dateLabel);
		panel.add(dateLabel);
		datePanel = DateUtil.getDatePanel();
		container.add(datePanel);
		panel.add(datePanel);
		
		
		//ά����Ա
		peopleLabel = new JLabel("ά����Ա");
		container.add(peopleLabel);
		panel.add(peopleLabel);
		peopleBox = new JComboBox<>(peopleNames);
		container.add(peopleBox);
		panel.add(peopleBox);
		
		//costLabel����
		costLabel = new JLabel("ά�޻���");
		container.add(costLabel);
		panel.add(costLabel);
		costField = new JTextField("",4);
		costField.setForeground(Color.red);
		container.add(costField);
		panel.add(costField);
		
		//ά���豸��
		emNoLabel = new JLabel("�豸��");
		container.add(emNoLabel);
		panel.add(emNoLabel);
		emNoBox = new JComboBox<>(emNos);
		container.add(emNoBox);
		panel.add(emNoBox);
		
		//ά���豸��
		emNameLabel = new JLabel("�豸����");
		container.add(emNameLabel);
		panel.add(emNameLabel);
		emNameBox = new JComboBox<>(emNames);
		container.add(emNameBox);
		panel.add(emNameBox);
		
		submitButton = new Button("�ύ");
		submitButton.addActionListener(this);
//		submitButton.setBackground(Color.gray);
		container.add(submitButton);
		panel.add(submitButton);
		
		exitButton = new Button("�˳�");
		exitButton.addActionListener(this);
		container.add(exitButton);
		panel.add(exitButton);
		
		jFrame.add(panel);
		jFrame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new RepairUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String date,people,emNO,emName;
		int cost = 0;
		date = ((JComboBox)datePanel.getComponent(0)).getSelectedItem().toString() + "-" +
				((JComboBox)datePanel.getComponent(1)).getSelectedItem().toString() + "-" +
				((JComboBox)datePanel.getComponent(2)).getSelectedItem().toString()
				;
		people = peopleBox.getSelectedItem().toString();
		
		cost = Integer.parseInt(costField.getText());
		
		emNO = emNoBox.getSelectedItem().toString();
		
		emName = emNameBox.getSelectedItem().toString();
		
		if (e.getSource() == submitButton) {
			if (cost == 0) {
				MsgUtil.show(false);
			}
			RepairDao repairDao = new RepairDao();
			repairDao.insert(date,people,cost,emNO,emName);
			MsgUtil.show(true);
		}
		
		if (e.getSource() == exitButton) {
			jFrame.dispose();
			System.exit(0);
		}
	}
	
}
