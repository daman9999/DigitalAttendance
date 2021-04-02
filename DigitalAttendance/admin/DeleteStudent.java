package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import separate.*;

public class DeleteStudent extends EventClass
	{
		byte a;
		JTextField id,name,subject;
		JButton delete;

		public DeleteStudent(byte a)
			{
				this.a = a;

									id = new JTextField();
									id.setBounds(256,171,514,43);
									id.setBackground(new Color(0,0,0,0));
						        	id.setHorizontalAlignment(JLabel.CENTER);
						        	id.setBorder(null); 	
						       		id.setOpaque(false);
						       		id.setFont(CenterStage.f);
						       		id.addKeyListener(this);

						       		name = new JTextField();
									name.setBounds(256,283,511,41);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);
						       		name.setEnabled(false);

						        	delete = new JButton();
									delete.setBounds(307,411,289,88);
									delete.setContentAreaFilled(false);
									delete.setBorder(null);
									delete.addActionListener(this);
									delete.setEnabled(false);

						        	CenterStage.miniframe = new JFrame();
            						CenterStage.miniframe.setUndecorated(true);
            						CenterStage.miniframe.setLayout(null);

            						CenterStage.miniframe.add(CenterStage.miniexit);

            						CenterStage.miniframe.add(id);
            						CenterStage.miniframe.add(name);
            						CenterStage.miniframe.add(delete);
            			
            						CenterStage.setMiniImage(Images.Student.delete);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocation(200,200);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
			}

		public void keyReleased(KeyEvent e)
			{
				CenterStage.establishConnection("localhost","DigitalAttendance");
				CenterStage.performQuery("SELECT * FROM Students"+a+" where id = '"+id.getText()+"'");

								try
									{
										if(CenterStage.isFirstRow())
											{		
												name.setEnabled(true);
												delete.setEnabled(true);
											
												name.setText(CenterStage.rs.getString("name"));
											}
									}
								catch(Exception ex)
									{
										
									}
			}

		public void actionPerformed(ActionEvent e)
			{
				CenterStage.performUpdate("DELETE FROM Students"+a+" where id = '"+id.getText()+"'");
				JOptionPane.showMessageDialog(null,"Student Deleted");
				id.setText("");
				name.setText("");
			}
}