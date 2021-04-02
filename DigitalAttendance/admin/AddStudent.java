package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import separate.*;

public class AddStudent extends EventClass
	{
		byte a;

		JTextField id,rollno,name;
		JPasswordField pass;
		JFormattedTextField number;
		JButton miniadd;

		public AddStudent(byte a)
			{
				this.a = a;
									String ab[] = new String[6];

        							id = new JTextField();
									id.setBounds(283,75,448,27);
									id.setBackground(new Color(0,0,0,0));
						        	id.setHorizontalAlignment(JLabel.CENTER);
						        	id.setBorder(null); 	
						       		id.setOpaque(false);
						       		id.setFont(CenterStage.f);

						       		rollno = new JTextField();
									rollno.setBounds(283,136,445,28);
									rollno.setBackground(new Color(0,0,0,0));
						        	rollno.setHorizontalAlignment(JLabel.CENTER);
						        	rollno.setBorder(null); 	
						       		rollno.setOpaque(false);
						       		rollno.setFont(CenterStage.f);

						       		name = new JTextField();
									name.setBounds(283,210,445,28);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);

									pass = new JPasswordField(20);
									pass.setBounds(271,289,448,28);
									pass.setBackground(new Color(0,0,0,0));
						        	pass.setHorizontalAlignment(JLabel.CENTER);
						        	pass.setBorder(null);
						        	pass.setOpaque(false);
						        	pass.setFont(CenterStage.f);

						        
						        	MaskFormatter mask = null;
						        	try
						        		{
						     		   		mask = new MaskFormatter("##########");
						        		}
						        	catch(Exception ex)
						        		{
						        			JOptionPane.showMessageDialog(null,ex);
						        		}
						        	number = new JFormattedTextField(mask);
						        	number.setBounds(268,360,448,28);
						        	number.setOpaque(false);
						        	number.setBackground(new Color(0,0,0,0));
						        	number.setFont(CenterStage.f);
						        	number.setBorder(null);
						        	number.setHorizontalAlignment(JLabel.CENTER);

									miniadd = new JButton();
									miniadd.setBounds(307,459,247,61);
									miniadd.setContentAreaFilled(false);
									miniadd.setBorder(null);
									miniadd.addActionListener(this);

                					CenterStage.miniframe = new JFrame();
            						CenterStage.miniframe.setUndecorated(true);
            						CenterStage.miniframe.setLayout(null);

            						CenterStage.miniframe.add(CenterStage.miniexit);

            						CenterStage.miniframe.add(id);
            						CenterStage.miniframe.add(name);
            						CenterStage.miniframe.add(pass);
            						CenterStage.miniframe.add(miniadd);
            						CenterStage.miniframe.add(rollno);
            						CenterStage.miniframe.add(number);
            						
            						CenterStage.setMiniImage(Images.Student.add);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
			}

		public void actionPerformed(ActionEvent e)
			{		
				CenterStage.performUpdate("INSERT INTO Students"+a+" VALUES('"+name.getText()+"','"+rollno.getText()+"','"+Long.parseLong(number.getText())+"','"+id.getText()+"','"+String.valueOf(pass.getPassword())+"',"+a+")");
            								
        		if(CenterStage.is_stmt_executed>0)
         			{
           				JOptionPane.showMessageDialog(null,"Student Added");
	           			name.setText("");
	           			id.setText("");
	           			rollno.setText("");
	          			pass.setText("");
	          			number.setText("");
           			}
				
			}	
	}