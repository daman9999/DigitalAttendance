import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class StudentLogin implements ActionListener
{
	JFrame st;
	JTextField user,pc_no;
	JPasswordField password;
	JButton login,exit;
	JLabel bg;
	
	public static void main(String []sdf)
	{
		new StudentLogin();
	}

    StudentLogin()
	{
	st=new JFrame("Student Login Page");
	st.setUndecorated(true);// this must always before setVisible
	st.setVisible(true);
	st.setLayout(null);
	
	
	exit=new JButton();
	exit.setBounds(1325,7,28,30);
	exit.setBackground(new Color(0,0,0,0));
	exit.setBorder(null);
	exit.setOpaque(false);
	exit.addActionListener(this);
	st.add(exit);
	
	user=new JTextField();
	user.setBounds(540,358,436,32);
	user.setBackground(new Color(0,0,0,0));
    user.setHorizontalAlignment(JLabel.CENTER);
    user.setBorder(null);
    user.setOpaque(false);
    st.add(user);   
	
	password=new JPasswordField();
	password.setBounds(540,440,436,32);
	password.setBackground(new Color(0,0,0,0));
    password.setHorizontalAlignment(JLabel.CENTER);
    password.setBorder(null);
    password.setOpaque(false);
    st.add(password);   
	
	pc_no=new JTextField();
	pc_no.setBounds(540,521,436,32);
	pc_no.setBackground(new Color(0,0,0,0));
    pc_no.setHorizontalAlignment(JLabel.CENTER);
    pc_no.setBorder(null);
    pc_no.setOpaque(false);
    st.add(pc_no);   
	
	login=new JButton();
	login.setBounds(847,576,141,44);
	login.setBackground(new Color(0,0,0,0));
    login.setBorder(null);
    login.setOpaque(false);
    st.add(login);   
	
	Icon bgi=new ImageIcon("user_login.jpg");
	bg=new JLabel(bgi);
	bg.setBounds(0,0,1366,768);
	st.add(bg);
	

	st.setSize(1366,768);
	//st.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ob)
	{
		if(ob.getSource()==exit)
		{
			st.dispose();
		}
	}
}