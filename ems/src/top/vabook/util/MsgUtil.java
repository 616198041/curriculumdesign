package top.vabook.util;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MsgUtil {
	private static JFrame jFrame = new JFrame("������ʾ��");
	
	
	private static JLabel jLabel;
	
	private static String errMsg = "��������,������";
	
	private static String sucMsg = "�����ɹ�,�����...";
	

	public static void show(boolean flag) {
		
		jFrame.setSize(300, 200);
		
		if (flag) {
			jLabel = new JLabel(sucMsg,JLabel.CENTER);
		}else {
			jLabel = new JLabel(errMsg,JLabel.CENTER);
		}
		
		jFrame.add(jLabel);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.HIDE_ON_CLOSE);
		jFrame.setLocation(500, 300);
	}
	
}
