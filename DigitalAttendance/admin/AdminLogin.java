package admin;

import separate.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdminLogin extends EventClass
	{
		JTextField user;
		JPasswordField pass;
		JButton login;

		public AdminLogin()
			{
				CenterStage.frame = new JFrame();
				
				CenterStage.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CenterStage.frame.setLayout(null);
				CenterStage.frame.setUndecorated(true);
				CenterStage.frame.setFocusable(true);
				CenterStage.frame.addKeyListener(this);

			
				user = new JTextField();
				user.setBounds(536,357,445,30);
				user.setBackground(new Color(0,0,0,0));
        		user.setHorizontalAlignment(JLabel.CENTER);
        		user.setBorder(null);
        		user.setOpaque(false);
        		user.setFont(CenterStage.f);
       
				//user.addKeyListener(this);
				
				pass = new JPasswordField(20);
				pass.setBounds(536,436,445,30);
				pass.setBackground(new Color(0,0,0,0));
        		pass.setHorizontalAlignment(JLabel.CENTER);
        		pass.setBorder(null);
        		pass.setOpaque(false);
        		pass.setFont(CenterStage.f);

				login = new JButton();
				login.setBounds(841,504,143,44);
				login.setContentAreaFilled(false);
				login.setBorder(null);
				login.addActionListener(this);

				CenterStage.exit.addActionListener(this);
				CenterStage.frame.add(CenterStage.exit);

				CenterStage.frame.add(user);
				CenterStage.frame.add(pass);
				CenterStage.frame.add(login);
				CenterStage.setImage(Images.admin_login);
				
				CenterStage.frame.setSize(CenterStage.framesizex,CenterStage.framesizey);
				CenterStage.frame.setVisible(true);
			}
					
		public void actionPerformed(ActionEvent e)
			{	
					if(e.getSource().equals(login))
					{
						CenterStage.con = CenterStage.establishConnection("localhost","DigitalAttendance");

						try
						{
							CenterStage.ps = CenterStage.con.prepareStatement("Select * from admins");
							CenterStage.rs = CenterStage.ps.executeQuery();

							while(CenterStage.rs.next())
							{
								if(CenterStage.rs.getString("username").equalsIgnoreCase(user.getText()))
									{
										if(CenterStage.rs.getString("password").equals(String.valueOf(pass.getPassword())))
											{
												CenterStage.frame.dispose();
												new SelectSemester();
											}
										else
											{
												JOptionPane.showMessageDialog(null,"Please Enter Correct Password");			
											}
									
									}
								else
									{
										JOptionPane.showMessageDialog(null,"Please Enter Correct Username And Password");
									}
							}
							CenterStage.rs.close();
							CenterStage.closeConnections();
						}
						catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null,ex);
							}
					
            				
            		
            		}

						if(e.getSource().equals(CenterStage.exit))
						{
							CenterStage.frame.dispose();
							CenterStage.closeConnections();
						}
			}


			public void keyReleased(KeyEvent e)
				{
					JOptionPane.showMessageDialog(null,e.getKeyChar());
				}

	}