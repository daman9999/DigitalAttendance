package admin;

import separate.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelectSemester extends EventClass
	{
		JButton semester[] = new JButton[6];
		short tempx = 208;

		SelectSemester()
			{
					CenterStage.frame = new JFrame();
					CenterStage.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					CenterStage.frame.setLayout(null);
					CenterStage.frame.setUndecorated(true);

					CenterStage.exit.addActionListener(this);
					CenterStage.frame.add(CenterStage.exit);

					for(byte i=0;i<semester.length;i++)
						{
							semester[i] = new JButton();
							semester[i].addActionListener(this);
     						semester[i].setContentAreaFilled(false);
        					semester[i].setBorder(null);

							if(i<3)
								{
									semester[i].setBounds(tempx,268,307,94);

									if(i==2) tempx = -134;
								}
							else
								{	
									semester[i].setBounds(tempx,424,307,94);
								}

							tempx= (short) (tempx+342);
							CenterStage.frame.add(semester[i]);
						}

					CenterStage.setImage(Images.semester);
					CenterStage.frame.setVisible(true);
					CenterStage.frame.setSize(CenterStage.framesizex,CenterStage.framesizey);
			}

		public void actionPerformed(ActionEvent e)
			{	
				CenterStage.frame.dispose();	
				
				if(e.getSource().equals(semester[0]))
					{
						new AdminHome((byte)1);
					}

				if(e.getSource().equals(semester[1]))
					{
						new AdminHome((byte)2);
					}
				
				if(e.getSource().equals(semester[2]))
					{
						new AdminHome((byte)3);
					}
					
				if(e.getSource().equals(semester[3]))
					{
						new AdminHome((byte)4);
					}
					
				if(e.getSource().equals(semester[4]))
					{
						new AdminHome((byte)5);
					}
					
				if(e.getSource().equals(semester[5]))
					{
						new AdminHome((byte)6);
					}
				
							
			/*	if(e.getSource().equals(CenterStage.exit))
					{
						
					}	*/								
	
			}
	}