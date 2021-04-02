package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import separate.*;

public class DeleteSubject extends EventClass
	{
		byte a;
		JFormattedTextField code;
		JTextField name;
		JButton delete;

		public DeleteSubject(byte a)
			{
				this.a = a;
									MaskFormatter mask = null;
								   	try
							      		{
											mask = new MaskFormatter("####");
							      		}
									catch(Exception ex)
										{
							     			JOptionPane.showMessageDialog(null,ex);
								   		}
							      	code = new JFormattedTextField(mask);
							     	code.setBounds(292,132,445,52);
							     	code.setOpaque(false);
								  	code.setBackground(new Color(0,0,0,0));
						        	code.setFont(CenterStage.f);
							       	code.setBorder(null);
							       	code.setHorizontalAlignment(JLabel.CENTER);
							       	code.addKeyListener(this);

						       		name = new JTextField();
									name.setBounds(295,254,448,52);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);
						       		name.setEditable(false);

						        	delete = new JButton();
									delete.setBounds(280,390,250,109);
									delete.setContentAreaFilled(false);
									delete.setBorder(null);
									delete.addActionListener(this);
									delete.setEnabled(false);

						        	CenterStage.miniframe = new JFrame();
            						CenterStage.miniframe.setUndecorated(true);
            						CenterStage.miniframe.setLayout(null);

            						CenterStage.miniframe.add(CenterStage.miniexit);

            						CenterStage.miniframe.add(code);
            						CenterStage.miniframe.add(name);
            						CenterStage.miniframe.add(delete);
            			
            						CenterStage.setMiniImage(Images.Subject.delete);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocation(200,200);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
			}

		public void keyReleased(KeyEvent e)
			{
				CenterStage.establishConnection("localhost","DigitalAttendance");
				CenterStage.performQuery("SELECT * FROM Subjects"+a+" where scode = "+Integer.parseInt(code.getText()));
								try
									{
										if(CenterStage.isFirstRow())
											{		
												delete.setEnabled(true);
												name.setText(CenterStage.rs.getString("sname"));
											}
									}
								catch(Exception ex)
									{
										
									}
			}

		public void actionPerformed(ActionEvent e)
			{
				CenterStage.performUpdate("DELETE FROM Subjects"+a+" where scode = "+Integer.parseInt(code.getText()));
				JOptionPane.showMessageDialog(null,"Subject Deleted");

				name.setText("");
				code.setText("");


			}
}