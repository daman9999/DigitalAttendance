package admin;

import javax.swing.*;
import separate.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateSubject extends EventClass
	{
		byte a;
		JTextField name;
		JFormattedTextField code;
		JComboBox <String> semester;
		JButton miniupdate;

		public UpdateSubject(byte a)
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
		     	code.setBounds(298,147,422,46);
		     	code.setOpaque(false);
			  	code.setBackground(new Color(0,0,0,0));
	        	code.setFont(CenterStage.f);
		       	code.setBorder(null);
		       	code.setHorizontalAlignment(JLabel.CENTER);
		       	code.addKeyListener(this);

				name = new JTextField();
				name.setBounds(304,259,418,46);
				name.setBackground(new Color(0,0,0,0));
			  	name.setHorizontalAlignment(JLabel.CENTER);
				name.setBorder(null); 	
				name.setOpaque(false);
				name.setFont(CenterStage.f);
				name.setEnabled(false);

				String[] semester_list = {"1","2","3","4","5","6"};
				semester = new JComboBox <String>(semester_list);

	        	semester.setBounds(301,366,423,47);
	        	semester.setFont(CenterStage.f);
	        	semester.setBackground(new Color(0,0,0,0));
	        	semester.setSelectedIndex(-1);
	        	semester.setBorder(null);
	        	semester.setOpaque(true);
	        	semester.updateUI();
	        	semester.setEnabled(false);

				miniupdate = new JButton();
				miniupdate.setBounds(283,461,238,101);
				miniupdate.setContentAreaFilled(false);
				miniupdate.setBorder(null);
				miniupdate.addActionListener(this);
				miniupdate.setEnabled(false);

                CenterStage.miniframe = new JFrame();
        		CenterStage.miniframe.setUndecorated(true);
            	CenterStage.miniframe.setLayout(null);

            	CenterStage.miniframe.add(CenterStage.miniexit);

            	CenterStage.miniframe.add(code);
            	CenterStage.miniframe.add(name);
            	CenterStage.miniframe.add(miniupdate);
            	CenterStage.miniframe.add(semester);

            	//CenterStage.miniframe.setAlwaysOnTop(true);

            	CenterStage.setMiniImage(Images.Subject.update);
            	CenterStage.miniframe.setSize(800,600);
            	CenterStage.miniframe.setLocation(200,200);
            	CenterStage.miniframe.setLocationRelativeTo(null);
            	CenterStage.miniframe.setVisible(true);
			}

			public void actionPerformed(ActionEvent e)
				{
					if((semester.getSelectedIndex()+1) == a )				
    								{
    									CenterStage.performUpdate("Update subjects"+a+" set sname='"+name.getText()+"' where scode="+Integer.parseInt(code.getText()));
            							if(CenterStage.is_stmt_executed>0)
         								{
           									JOptionPane.showMessageDialog(null,"Subject Updated");
           									name.setText("");
           									code.setText("");
           									semester.setSelectedIndex(-1); 

           									name.setEnabled(false);
											semester.setEnabled(false);
											miniupdate.setEnabled(false);
            							}
            						}
            					else
            						{
            							CenterStage.performUpdate("Delete from subjects"+a+" where scode="+Integer.parseInt(code.getText()));
            							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.subjects"+(semester.getSelectedIndex()+1)+"(sname varchar(25), scode int(7) primary key , semester int(1)  )");
            							CenterStage.performUpdate("INSERT INTO subjects"+(semester.getSelectedIndex()+1)+" VALUES('"+name.getText()+"',"+Integer.parseInt(code.getText())+","+(semester.getSelectedIndex()+1)+")");                             
            							if(CenterStage.is_stmt_executed>0)
            								{
            									JOptionPane.showMessageDialog(null,"Subject Successfullly moved to Semester"+(semester.getSelectedIndex()+1));
            								}
            						}

				}

			public void keyReleased(KeyEvent e)
				{
					CenterStage.establishConnection("localhost","DigitalAttendance");
					CenterStage.performQuery("Select * From subjects"+a+" where scode="+Integer.parseInt(code.getText()));

					if(CenterStage.isFirstRow())
						{
							name.setEnabled(true);
							semester.setEnabled(true);
							miniupdate.setEnabled(true);

							try
								{
									name.setText(CenterStage.rs.getString("sname"));
									semester.setSelectedIndex(a-1);
								}
							catch(Exception ex)
								{
									JOptionPane.showMessageDialog(null,ex);
								}
						}
					else
						{
							code.setText("");
							name.setText("");
							semester.setSelectedIndex(-1);
						}

				}
	}