package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import separate.*;

public class AddTeacher extends EventClass
	{
		byte a;

		JTextField id,name;
		JPasswordField pass;
		JComboBox <String> subject;
		JFormattedTextField number;
		JButton miniadd;

		public AddTeacher(byte a)
			{
				this.a = a;
									String ab[] = new String[6];

        							id = new JTextField();
									id.setBounds(298,147,433,25);
									id.setBackground(new Color(0,0,0,0));
						        	id.setHorizontalAlignment(JLabel.CENTER);
						        	id.setBorder(null); 	
						       		id.setOpaque(false);
						       		id.setFont(CenterStage.f);

						       		name = new JTextField();
									name.setBounds(298,213,430,25);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);

									pass = new JPasswordField(20);
									pass.setBounds(304,283,430,25);
									pass.setBackground(new Color(0,0,0,0));
						        	pass.setHorizontalAlignment(JLabel.CENTER);
						        	pass.setBorder(null);
						        	pass.setOpaque(false);
						        	pass.setFont(CenterStage.f);

						        	subject = new JComboBox <String>(ab);
						        	subject.removeAllItems();
							
									CenterStage.performQuery("Select * from subjects"+a);
							       	try
						        		{
						        			while(CenterStage.rs.next())
						        				{
						        					subject.addItem(CenterStage.rs.getString("sname"));
						        				}
						        		}
						        	catch(Exception ex)
						        		{
						        			JOptionPane.showMessageDialog(null,ex);
						        		}

						        	subject.setSelectedIndex(-1);
						        	subject.setBounds(301,349,430,25);
						        	subject.setFont(CenterStage.f);
						        	subject.setBackground(new Color(0,0,0,0));
						        	//subject.setHorizontalAlignment(JLabel.CENTER);
						        	subject.setBorder(null);
						        	subject.setOpaque(false);
						        	subject.updateUI();

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
						        	number.setBounds(307,420,430,25);
						        	number.setOpaque(false);
						        	number.setBackground(new Color(0,0,0,0));
						        	number.setFont(CenterStage.f);
						        	number.setBorder(null);
						        	number.setHorizontalAlignment(JLabel.CENTER);

									miniadd = new JButton();
									miniadd.setBounds(340,507,241,55);
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
            						CenterStage.miniframe.add(subject);
            						CenterStage.miniframe.add(number);

            						//CenterStage.miniframe.setAlwaysOnTop(true);

            						CenterStage.setMiniImage(Images.Teacher.add);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocation(200,200);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
			}

		public void actionPerformed(ActionEvent e)
			{		
				CenterStage.performUpdate("INSERT INTO Teachers"+a+" VALUES('"+name.getText()+"','"+id.getText()+"','"+String.valueOf(pass.getPassword())+"',"+Long.parseLong(number.getText())+",'"+String.valueOf(subject.getSelectedItem())+"',"+a+")");
            								
        		if(CenterStage.is_stmt_executed>0)
         			{
           				JOptionPane.showMessageDialog(null,"Teacher Added");
	           			name.setText("");
	           			id.setText("");
	          			pass.setText("");
	          			number.setText("");
	           			subject.setSelectedIndex(-1); 
           			}
				
			}	
	}