/*
 * LookCourse.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.AddCourses;
import model.DataConnection;
import model.ModelFactory;
import model.Teacher;

/**
 *
 * @author  __USER__
 */
public class LookCourse extends javax.swing.JFrame {

	/** Creates new form LookCourse */
	public LookCourse() {
		initComponents();
		this.setTitle("�鿴�γ�");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		DataConnection dc = new DataConnection();
		try {
			ArrayList<AddCourses> res = ModelFactory.LookCourses(dc.getStat());
			String title[] = { "�γ̱��", "�γ�����", "�ڿ���ʦ", "�Ͽ�ʱ��","�γ�״̬"};
			Object o[][] = new Object[res.size()][5];
			for (int i = 0; i < res.size(); i++) {
				o[i][0] = res.get(i).getCid();
				o[i][1] = res.get(i).getCname();
				o[i][2] = res.get(i).getCteacher();
				o[i][3] = res.get(i).getCtime();
				o[i][4] = res.get(i).getState();
			}
			DefaultTableModel dtm = new DefaultTableModel(o, title);
			this.jTable1.setModel(dtm);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LookCourse().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables

}