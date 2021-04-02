package admin;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import separate.*;

public class UpdateStudent extends EventClass
	{
		byte a;
		JTextField id,name;
		JTextField pass;
		JComboBox <String> semester;
		JFormattedTextField number;
		JButton miniupdate;

		public UpdateStudent(byte a)
			{
				this.a=a;
									String ab[] = new String[6];

            						id = new JTextField();
									id.setBounds(250,107,475,28);
									id.setBackground(new Color(0,0,0,0));
						        	id.setHorizontalAlignment(JLabel.CENTER);
						        	id.setBorder(null); 	
						       		id.setOpaque(false);
						       		id.setFont(CenterStage.f);
						       		id.addKeyListener(this);

						       		name = new JTextField();
									name.setBounds(253,175,469,26);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);
						       		name.setEnabled(false);

									pass = new JTextField();
									pass.setBounds(256,250,471,25);
									pass.setBackground(new Color(0,0,0,0));
						        	pass.setHorizontalAlignment(JLabel.CENTER);
						        	pass.setBorder(null);
						        	pass.setOpaque(false);
						        	pass.setFont(CenterStage.f);
						        	pass.setEnabled(false);

						        	String[] semester_list = {"1","2","3","4","5","6"};
						        	semester = new JComboBox <String>(semester_list);

						        	semester.setBounds(259,321,472,25);
						        	semester.setFont(CenterStage.f);
						        	semester.setBackground(new Color(0,0,0,0));
						        	semester.setSelectedIndex(0);
						        	semester.setBorder(null);
						        	semester.setOpaque(false);
						        	semester.updateUI();
						        	semester.setEnabled(false);
						        	semester.addActionListener(this);

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
						        	number.setBounds(256,384,475,25);
						        	number.setOpaque(false);
						        	number.setBackground(new Color(0,0,0,0));
						        	number.setFont(CenterStage.f);
						        	number.setBorder(null);
						        	number.setHorizontalAlignment(JLabel.CENTER);
						        	number.setEnabled(false);

									miniupdate = new JButton();
									miniupdate.setBounds(295,475,265,59);
									miniupdate.setContentAreaFilled(false);
									miniupdate.setBorder(null);
									miniupdate.addActionListener(this);
									miniupdate.setEnabled(false);

                					CenterStage.miniframe = new JFrame();
            						CenterStage.miniframe.setUndecorated(true);
            						CenterStage.miniframe.setLayout(null);

            						CenterStage.miniframe.add(CenterStage.miniexit);

            						CenterStage.miniframe.add(id);
            						CenterStage.miniframe.add(name);
            						CenterStage.miniframe.add(pass);
            						CenterStage.miniframe.add(miniupdate);
            						CenterStage.miniframe.add(semester);
            						CenterStage.miniframe.add(number);

            						CenterStage.setMiniImage(Images.Student.update);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
    		}

    		public void actionPerformed(ActionEvent e)
    				{
								if((semester.getSelectedIndex()+1) == a )					
    								{
    									CenterStage.performUpdate("Update students"+a+" set Name='"+name.getText()+"',mobile_no="+Long.parseLong(number.getText())+",password='"+pass.getText()+"' where id='"+id.getText()+"'");
            							if(CenterStage.is_stmt_executed>0)
         								{
           									JOptionPane.showMessageDialog(null,"Student Updated");
           									name.setText("");
           									id.setText("");
           									pass.setText("");
           									number.setText("");
           									semester.setSelectedIndex(0); 

           									name.setEnabled(false);
											pass.setEnabled(false);
											semester.setEnabled(false);
											number.setEnabled(false); 
											miniupdate.setEnabled(false);
            							}
            						}
            					else
            						{
            							CenterStage.performUpdate("Delete from students"+a+" where id='"+id.getText()+"'");
            							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.students"+(semester.getSelectedIndex()+1)+" ( name varchar(40) , rollno varchar(8) Primary key , mobile_no bigint(11) , id varchar(10) , password varchar(15) , semester int(2) ) " );
            							CenterStage.performUpdate("INSERT INTO students"+(semester.getSelectedIndex()+1)+"(name,mobile_no,id,password,semester) VALUES('"+name.getText()+"',"+Long.parseLong(number.getText())+",'"+id.getText()+"','"+pass.getText()+"',"+(semester.getSelectedIndex()+1)+")");
            							
            							if(CenterStage.is_stmt_executed>0)
            								{
            									JOptionPane.showMessageDialog(null,"Student Successfullly moved to Semester"+(semester.getSelectedIndex()+1));
            									name.setText("");
           										id.setText("");
           										pass.setText("");
           										number.setText("");
           										semester.setSelectedIndex(0); 

           										name.setEnabled(false);
												pass.setEnabled(false);
												semester.setEnabled(false);
												number.setEnabled(false); 
												miniupdate.setEnabled(false);
            								}
            						}		
    						}

    		public void keyReleased(KeyEvent e)
					{
						CenterStage.establishConnection("localhost","DigitalAttendance");

						if(e.getSource().equals(id))
							{
								CenterStage.performQuery("SELECT * FROM students"+a+" where id ='"+id.getText()+"'");

								try
									{
										if(CenterStage.isFirstRow())
											{		
												name.setEnabled(true);
												pass.setEnabled(true);
												semester.setEnabled(true);
												number.setEnabled(true); 
												miniupdate.setEnabled(true);
											
												name.setText(CenterStage.rs.getString("name"));
												pass.setText(CenterStage.rs.getString("password"));
												semester.setSelectedIndex(a-1);
												number.setText(String.valueOf(CenterStage.rs.getLong("mobile_no")));
											}
									}
								catch(Exception ex)
									{
										JOptionPane.showMessageDialog(null,ex);
									}

							}

    				}
    }
