package top.vabook.view;

import javax.swing.JLabel;
import javax.swing.JTextField;

//�˳���ϵͳ���ָ�ϵͳ��ʵʼ״̬
public class exitUI {

	public exitUI(JTextField nameField, JTextField passwordField, BuyUI buyUI, LendUI lendUI, RepairUI repairUI, StoreUI storeUI, ScrapUI scrapUI, UserUI userUI, JLabel errorLaebl) {
		nameField.setText("");
		passwordField.setText("");
		errorLaebl.setText("���ȵ�¼");
		//���ж��Ƿ�㿪��,�ٹر�
		if (BuyUI.jFrame != null) {
			buyUI.close();
		}
		if (LendUI.jFrame != null) {
			lendUI.close();
		}
		if (repairUI.jFrame != null) {
			repairUI.close();
		}
		if (storeUI.jFrame != null) {
			storeUI.close();
		}
		if (ScrapUI.jFrame != null) {
			scrapUI.close();
		}
		if (UserUI.jFrame != null) {
			userUI.close();
		}
	}
	
}
