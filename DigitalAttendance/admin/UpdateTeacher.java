package admin;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import separate.*;

public class UpdateTeacher extends EventClass
	{
		byte a;
		JTextField id,name;
		JTextField pass;
		JComboBox <String> subject,semester;
		JFormattedTextField number;
		JButton miniupdate;

		public UpdateTeacher(byte a)
			{
				this.a=a;
									String ab[] = new String[6];

            						id = new JTextField();
									id.setBounds(250,79,442,25);
									id.setBackground(new Color(0,0,0,0));
						        	id.setHorizontalAlignment(JLabel.CENTER);
						        	id.setBorder(null); 	
						       		id.setOpaque(false);
						       		id.setFont(CenterStage.f);
						       		id.addKeyListener(this);

						       		name = new JTextField();
									name.setBounds(250,148,445,25);
									name.setBackground(new Color(0,0,0,0));
						        	name.setHorizontalAlignment(JLabel.CENTER);
						        	name.setBorder(null); 	
						       		name.setOpaque(false);
						       		name.setFont(CenterStage.f);
						       		name.setEnabled(false);

									pass = new JTextField();
									pass.setBounds(253,217,442,25);
									pass.setBackground(new Color(0,0,0,0));
						        	pass.setHorizontalAlignment(JLabel.CENTER);
						        	pass.setBorder(null);
						        	pass.setOpaque(false);
						        	pass.setFont(CenterStage.f);
						        	pass.setEnabled(false);

						        	String[] semester_list = {"1","2","3","4","5","6"};
						        	semester = new JComboBox <String>(semester_list);

						        	semester.setBounds(250,283,442,25);
						        	semester.setFont(CenterStage.f);
						        	semester.setBackground(new Color(0,0,0,0));
						        	semester.setSelectedIndex(0);
						        	semester.setBorder(null);
						        	semester.setOpaque(false);
						        	semester.updateUI();
						        	semester.setEnabled(false);
						        	semester.addActionListener(this);

						        	subject = new JComboBox <String>(ab);
						        	subject.removeAllItems();

									CenterStage.performQuery("Select * from subjects"+a);
							       	try
						        		{
						        			CenterStage.rs.beforeFirst();
						        			while(CenterStage.rs.next())
						        				{
						        					subject.addItem(CenterStage.rs.getString("sname"));
						        				}
						        		}
						        	catch(Exception ex)
						        		{
						        			JOptionPane.showMessageDialog(null,ex);
						        		}

						        	subject.setSelectedIndex(0);
						        	subject.setBounds(250,349,442,25);
						        	subject.setFont(CenterStage.f);
						        	subject.setBackground(new Color(0,0,0,0));
						        	//subject.setHorizontalAlignment(JLabel.CENTER);
						        	subject.setBorder(null);
						        	subject.setOpaque(false);
						        	subject.updateUI();
						        	subject.setEnabled(false);

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
						        	number.setBounds(253,417,445,26);
						        	number.setOpaque(false);
						        	number.setBackground(new Color(0,0,0,0));
						        	number.setFont(CenterStage.f);
						        	number.setBorder(null);
						        	number.setHorizontalAlignment(JLabel.CENTER);
						        	number.setEnabled(false);

									miniupdate = new JButton();
									miniupdate.setBounds(292,492,247,55);
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
            						CenterStage.miniframe.add(subject);
            						CenterStage.miniframe.add(number);

            						//CenterStage.miniframe.setAlwaysOnTop(true);

            						CenterStage.setMiniImage(Images.Teacher.update);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocation(200,200);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
    		}

    		public void actionPerformed(ActionEvent e)
    				{
    					if(e.getSource() == semester)
    						{
    							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.subjects"+(semester.getSelectedIndex()+1)+"(sname varchar(25), scode int(7) primary key , semester int(1)  )");
    							CenterStage.performQuery("Select * from subjects"+(semester.getSelectedIndex()+1));
							       		if(CenterStage.isFirstRow())
							       			{
										       	try
									        		{
									        			subject.removeAllItems();
									        			CenterStage.rs.beforeFirst();
									        			while(CenterStage.rs.next())
									        				{
									        					subject.addItem(CenterStage.rs.getString("sname"));
									        				}
									        			subject.setSelectedIndex(0);
									        		}
									        	catch(Exception ex)
									        		{
									        			JOptionPane.showMessageDialog(null,ex);
									        		}
									        }
									     else
									     	{
									     		JOptionPane.showMessageDialog(null,"There Is No Subject Added For The Semester"+(semester.getSelectedIndex()+1)+" ,Add A Subject");
									     		new AddSubject((byte)(semester.getSelectedIndex()+1));
									     	}
    						}

    					if(e.getSource() == miniupdate)
							{ 	
								if((semester.getSelectedIndex()+1) == a )					
    								{
    									CenterStage.performUpdate("Update teachers"+a+" set Name='"+name.getText()+"',password='"+pass.getText()+"',mobile_no="+Long.parseLong(number.getText())+",subject='"+String.valueOf(subject.getSelectedItem())+"' where id='"+id.getText()+"'");
            							if(CenterStage.is_stmt_executed>0)
         								{
           									JOptionPane.showMessageDialog(null,"Teacher Updated");
           									name.setText("");
           									id.setText("");
           									pass.setText("");
           									number.setText("");
           									subject.setSelectedIndex(0);
           									semester.setSelectedIndex(0); 

           									name.setEnabled(false);
											pass.setEnabled(false);
											semester.setEnabled(false);
											subject.setEnabled(false);
											number.setEnabled(false); 
											miniupdate.setEnabled(false);
            							}
            						}
            					else
            						{
            							CenterStage.performUpdate("Delete from teachers"+a+" where id='"+id.getText()+"'");
            							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.teachers"+(semester.getSelectedIndex()+1)+" ( name varchar(40) , id varchar(10) primary key , password varchar(15) , mobile_no bigint(11) , subject varchar(30) , semester int(2) ) " );
            							CenterStage.performUpdate("INSERT INTO Teachers"+(semester.getSelectedIndex()+1)+" VALUES('"+name.getText()+"','"+id.getText()+"','"+pass.getText()+"',"+Long.parseLong(number.getText())+",'"+String.valueOf(subject.getSelectedItem())+"',"+(semester.getSelectedIndex()+1)+")");
            							
            							if(CenterStage.is_stmt_executed>0)
            								{
            									JOptionPane.showMessageDialog(null,"Teacher Successfullly moved to Semester"+(semester.getSelectedIndex()+1));
            									name.setText("");
           										id.setText("");
           										pass.setText("");
           										number.setText("");
           										subject.setSelectedIndex(0);
           										semester.setSelectedIndex(0); 

           										name.setEnabled(false);
												pass.setEnabled(false);
												semester.setEnabled(false);
												subject.setEnabled(false);
												number.setEnabled(false); 
												miniupdate.setEnabled(false);
            								}
            						}
        							
    						}
    				}

    		public void keyReleased(KeyEvent e)
					{
						CenterStage.establishConnection("localhost","DigitalAttendance");

						if(e.getSource().equals(id))
							{
								CenterStage.performQuery("SELECT * FROM Teachers"+a+" where id = '"+id.getText()+"'");

								try
									{
										if(CenterStage.isFirstRow())
											{		
												name.setEnabled(true);
												pass.setEnabled(true);
												semester.setEnabled(true);
												subject.setEnabled(true);
												number.setEnabled(true); 
												miniupdate.setEnabled(true);
											
												name.setText(CenterStage.rs.getString("name"));
												pass.setText(CenterStage.rs.getString("password"));
												semester.setSelectedIndex(a-1);
												subject.setSelectedItem((Object)CenterStage.rs.getString("subject"));
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
