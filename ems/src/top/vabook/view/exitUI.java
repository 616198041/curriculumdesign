package top.vabook.view;

import javax.swing.JTextField;

//�˳���ϵͳ���ָ�ϵͳ��ʵʼ״̬
public class exitUI {

	public exitUI(JTextField nameField, JTextField passwordField, BuyUI buyUI, LendUI lendUI, RepairUI repairUI, StoreUI storeUI, ScrapUI scrapUI, UserUI userUI) {
		nameField.setText("");
		passwordField.setText("");
		
		//���ж��Ƿ�㿪��,�ٹر�
		if (buyUI.jFrame != null) {
			buyUI.close();
		}
		if (lendUI.jFrame != null) {
			lendUI.close();
		}
		if (repairUI.jFrame != null) {
			repairUI.close();
		}
		if (storeUI.jFrame != null) {
			storeUI.close();
		}
		if (scrapUI.jFrame != null) {
			scrapUI.close();
		}
	}
	
}
