package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import separate.*;

public class DeleteTeacher extends EventClass
	{
		byte a;
		JTextField id,name,subject;
		JButton delete;

		public DeleteTeacher(byte a)
			{
				this.a = a;

									id = new JTextField();
									id.setBounds(247,127,463,37);
									id.setBackground(new Color(0,0,0,0));
						        	id.setHorizontalAlignment(JLabel.CENTER);
						        	id.setBorder(null); 	
						       		id.setOpaque(false);
						       		id.setFont(CenterStage.f);
						       		id.addActionListener(this);
						       		id.addKeyListener(this);

						       		name = new JTextField();
									name.setBounds(250,228,457,37);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);
						       		name.setEnabled(false);

									subject = new JTextField();
									subject.setBounds(247,344,460,37);
									subject.setBackground(new Color(0,0,0,0));
						        	subject.setHorizontalAlignment(JLabel.CENTER);
						        	subject.setBorder(null);
						        	subject.setOpaque(false);
						        	subject.setFont(CenterStage.f);
						        	subject.setEnabled(false);

						        	delete = new JButton();
									delete.setBounds(292,447,265,79);
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
            						CenterStage.miniframe.add(subject);
            						CenterStage.miniframe.add(delete);
            			
            						CenterStage.setMiniImage(Images.Teacher.delete);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocation(200,200);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
			}

		public void keyReleased(KeyEvent e)
			{
				CenterStage.establishConnection("localhost","DigitalAttendance");
				CenterStage.performQuery("SELECT * FROM Teachers"+a+" where id = '"+id.getText()+"'");

								try
									{
										if(CenterStage.isFirstRow())
											{		
												name.setEnabled(true);
												subject.setEnabled(true);
												delete.setEnabled(true);
											
												name.setText(CenterStage.rs.getString("name"));
												subject.setText(CenterStage.rs.getString("subject"));
											}
									}
								catch(Exception ex)
									{
										
									}
			}

		public void actionPerformed(ActionEvent e)
			{
				CenterStage.performUpdate("DELETE FROM Teachers"+a+" where id = '"+id.getText()+"'");
				JOptionPane.showMessageDialog(null,"Teacher Deleted");
				id.setText("");
				name.setText("");
				subject.setText("");
			}
}