package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import separate.*;

public class AddLab extends EventClass
	{
		byte a;

		JTextField number_of_pc,lab_name;
		JButton miniadd,status;

		public AddLab()
			{
        							number_of_pc = new JTextField();
									number_of_pc.setBounds(319,226,334,40);
									number_of_pc.setBackground(new Color(0,0,0,0));
						        	number_of_pc.setHorizontalAlignment(JLabel.CENTER);
						        	number_of_pc.setBorder(null); 	
						       		number_of_pc.setOpaque(false);
						       		number_of_pc.setFont(CenterStage.f);

						       		lab_name = new JTextField();
									lab_name.setBounds(319,130,334,41);
									lab_name.setBackground(new Color(0,0,0,0));
						        	lab_name.setHorizontalAlignment(JLabel.CENTER);
						        	lab_name.setBorder(null); 	
						       		lab_name.setOpaque(false);
						       		lab_name.setFont(CenterStage.f);

						       		status = new JButton();
						       		status.setBounds(61,355,217,49);
						       		status.setContentAreaFilled(false);
						       		status.setBorder(null);
						       		status.addActionListener(this);

									miniadd = new JButton();
									miniadd.setBounds(412,353,229,50);
									miniadd.setContentAreaFilled(false);
									miniadd.setBorder(null);
									miniadd.addActionListener(this);

                					CenterStage.miniframe = new JFrame();
            						CenterStage.miniframe.setUndecorated(true);
            						CenterStage.miniframe.setLayout(null);

            						CenterStage.miniframe.add(CenterStage.miniexit);

            						CenterStage.miniframe.add(number_of_pc);
            						CenterStage.miniframe.add(lab_name);
            						CenterStage.miniframe.add(miniadd);
            						CenterStage.miniframe.add(status);

            						CenterStage.setMiniImage(Images.Lab.add);
            						CenterStage.miniframe.setSize(800,600);
            						CenterStage.miniframe.setLocation(200,200);
            						CenterStage.miniframe.setLocationRelativeTo(null);
            						CenterStage.miniframe.setVisible(true);
			}

		public void actionPerformed(ActionEvent e)
			{		
				if(e.getSource().equals(status))
				{
					CenterStage.miniframe.setEnabled(false);
					new CheckStatus(Byte.parseByte(number_of_pc.getText()));
				}

				else if(e.getSource().equals(miniadd))
				{

				}
				
			}	
	}