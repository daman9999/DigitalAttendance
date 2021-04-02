package admin;

import javax.swing.*;
import separate.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class AddSubject extends EventClass
	{
		byte a;
		JTextField name;
		JFormattedTextField code;
		JButton add;

		public AddSubject(byte a)
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
		     	code.setBounds(304,147,409,46);
		     	code.setOpaque(false);
			  	code.setBackground(new Color(0,0,0,0));
	        	code.setFont(CenterStage.f);
		       	code.setBorder(null);
		       	code.setHorizontalAlignment(JLabel.CENTER);

				name = new JTextField();
				name.setBounds(307,274,403,46);
				name.setBackground(new Color(0,0,0,0));
			  	name.setHorizontalAlignment(JLabel.CENTER);
				name.setBorder(null); 	
				name.setOpaque(false);
				name.setFont(CenterStage.f);

				add = new JButton();
				add.setBounds(289,415,235,100);
				add.setContentAreaFilled(false);
				add.setBorder(null);
				add.addActionListener(this);

                CenterStage.miniframe = new JFrame();
        		CenterStage.miniframe.setUndecorated(true);
            	CenterStage.miniframe.setLayout(null);

            	CenterStage.miniframe.add(CenterStage.miniexit);

            	CenterStage.miniframe.add(code);
            	CenterStage.miniframe.add(name);
            	CenterStage.miniframe.add(add);

            	//CenterStage.miniframe.setAlwaysOnTop(true);

            	CenterStage.setMiniImage(Images.Subject.add);
            	CenterStage.miniframe.setSize(800,600);
            	CenterStage.miniframe.setLocation(200,200);
            	CenterStage.miniframe.setLocationRelativeTo(null);
            	CenterStage.miniframe.setVisible(true);
			}

			public void actionPerformed(ActionEvent e)
				{
					CenterStage.establishConnection("localhost","DigitalAttendance");
					CenterStage.performUpdate("INSERT INTO Subjects"+a+" VALUES('"+name.getText()+"',"+Integer.parseInt(code.getText())+","+a+")");

					if(CenterStage.is_stmt_executed>0)
						{
							JOptionPane.showMessageDialog(null,"Subject Added Successfully!");
							name.setText("");
							code.setText("");
						}

					CenterStage.closeConnections();
				}
	}