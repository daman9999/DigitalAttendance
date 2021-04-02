package admin;

import javax.swing.*;
import separate.*;
import java.awt.*;


public class LetsTheFunBegin
{	
	JProgressBar jb;
	JFrame f;
	int i=0,num=0;
		LetsTheFunBegin()
			{
					UIManager.put("ProgressBar.background", Color.ORANGE);
					UIManager.put("ProgressBar.foreground", Color.BLUE);
					UIManager.put("ProgressBar.selectionBackground", Color.RED);
					UIManager.put("ProgressBar.selectionForeground", Color.GREEN);

					f = new JFrame();
					f.setUndecorated(true);
					f.setLayout(null);
						
					CustomResizableJLabelForMiniFrame img = new CustomResizableJLabelForMiniFrame(Images.logo);
					f.add(img);
					img.setBounds(0,0,800,600);

					jb=new JProgressBar();

					jb.setBounds(230,450,310,30);
					jb.setValue(0);
					jb.setStringPainted(true);
				
					
					f.add(jb);
					f.setSize(800,600);
					f.setLocationRelativeTo(null);
					f.setVisible(true);

				CenterStage.con = CenterStage.establishConnection("localhost","");
				CenterStage.performUpdate("CREATE DATABASE IF NOT EXISTS DigitalAttendance");
				CenterStage.closeConnections();
				CenterStage.con = CenterStage.establishConnection("localhost","DigitalAttendance");
            
            if(CenterStage.is_stmt_executed>0) 
            	{
                			CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.admins(username varchar(20) Primary Key,password varchar(20) Not Null)");
             				CenterStage.performQuery("SELECT * FROM admins");	
             
                 	}
			}
			public void iterate()
			{
				if(CenterStage.isFirstRow())
             				{
             					while(i<=100)
									{
										if(i>10)
											jb.setString("Searching for Admins");
										if(i>25)
											jb.setString("Admin Founded");
										if(i>40)
											jb.setString("Initializing Key Listeners and Mouse Motion Listeners");
										if(i>70)
											jb.setString("Proceeding To Login Page");
										if(i>90)
											jb.setString("Starting......");
											jb.setValue(i);
											i=i+10;
										try 
											{
											  Thread.sleep(600);
										    }
										catch(Exception e)
											{
												JOptionPane.showMessageDialog(null,e);
											}
									}
             					CenterStage.closeConnections();
             					f.dispose();
                 				new AdminLogin();
             				}
             			else
             				{
             					while(i<=100)
									{
										if(i>10)
											jb.setString("Creating Database For First Use");
										if(i>25)
											jb.setString("Datbase Created");
										if(i>40)
											jb.setString("Creating Tables");
										if(i>70)
											jb.setString("Initializing Key Listeners and Mouse Motion Listeners");
										if(i>90)
											jb.setString("Starting......");
											jb.setValue(i);
											i=i+10;
										try 
											{
											  Thread.sleep(600);
										    }
										catch(Exception e)
											{
												JOptionPane.showMessageDialog(null,e);
											}
									}
								f.dispose();
				                new AdminCreate();
				            }
			}
		 public static void main(String[] args)
		  	{
		  		LetsTheFunBegin starting = new LetsTheFunBegin();
		  		starting.iterate();	
			}

}