package admin;

import separate.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AdminCreate extends EventClass
{
	JButton create;
	JTextField user;
	JPasswordField pass;
	
	public AdminCreate()
		{
			CenterStage.frame = new JFrame();
			CenterStage.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			CenterStage.frame.setLayout(null);
			CenterStage.frame.setUndecorated(true);

			user = new JTextField();
			user.setBounds(536,357,445,30);
			user.setBackground(new Color(0,0,0,0));
        	user.setHorizontalAlignment(JLabel.CENTER);
        	user.setBorder(null); 	
       		user.setOpaque(false);
       		user.setFont(CenterStage.f);

			pass = new JPasswordField(20);
			pass.setBounds(536,436,445,30);
			pass.setBackground(new Color(0,0,0,0));
        	pass.setHorizontalAlignment(JLabel.CENTER);
        	pass.setBorder(null);
        	pass.setOpaque(false);
        	pass.setFont(CenterStage.f);

			create = new JButton();
			create.setBounds(841,504,143,44);
			create.setContentAreaFilled(false);
			create.setBorder(null);
			create.addActionListener(this);

			CenterStage.exit.addActionListener(this);
			CenterStage.frame.add(CenterStage.exit);

			CenterStage.frame.add(user);
			CenterStage.frame.add(pass);
			CenterStage.frame.add(create);
			CenterStage.setImage(Images.admin_create);

			CenterStage.frame.setSize(1366,768);
			CenterStage.frame.setVisible(true);

		}

	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(create))
			{
					CenterStage.performUpdate("INSERT INTO admins VALUES('"+user.getText()+"','"+String.valueOf(pass.getPassword())+"')");

					if(CenterStage.is_stmt_executed>0)
						{
							JOptionPane.showMessageDialog(null,"Admin Created");
							CenterStage.closeConnections();
							CenterStage.frame.dispose();	
							new AdminLogin();	
						}
			}

			if(e.getSource().equals(CenterStage.exit))
			{
				CenterStage.closeConnections();
				JOptionPane.showMessageDialog(null,"Closed");
				CenterStage.frame.dispose();
			}

		}

	public void keyTyped(KeyEvent e)
		{
			JOptionPane.showMessageDialog(null,e.getKeyCode());

				//if(e.getKeyCode() == 27)
				//{}
		}
}