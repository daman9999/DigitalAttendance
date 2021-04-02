package separate;

import admin.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class CenterStage extends EventClass
	{
		public static Connection con;
		public static PreparedStatement ps;
		public static ResultSet rs;
		public static byte is_stmt_executed;
		public static JFrame frame,miniframe,superminiframe;
		public static CustomResizableJLabel bg_image;
		public static CustomResizableJLabelForMiniFrame mini_bg_image;
		public static JLabel mini_simple_image;
		public static JButton exit,miniexit;
		public static JTable table;
		public static JScrollPane scroll;
		public static Font f;
		public static int framesizex,framesizey;
		public static ImageIcon temp;
 
		static
		{	
			framesizex = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			framesizey = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

			table = new JTable();
			scroll = new JScrollPane();
			exit = new JButton();
			miniexit = new JButton();

			f = new Font("Ink Free Regular",Font.PLAIN,30);
			
			exit.setBounds(framesizex-39,11,24,24);  // May need to some modifications in future.
			exit.setContentAreaFilled(false);
			exit.setBorder(null);

			miniexit.setBounds(775,10,22,19);		 // May need to some modifications in future.
			miniexit.setContentAreaFilled(false	);
			miniexit.setBorder(null);
	//	656565   514646	 626361
			
			table. setBackground(new Color(62,63,61));
			scroll.setViewportView(table);
			scroll.setBounds(249,335,1100,330);
			table.setFillsViewportHeight(true);
			//table.setOpaque(true);
		    
		}

		public static Connection establishConnection(String ip,String data_base)
			{
					try
						{
							Class.forName("com.mysql.jdbc.Driver");
							con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/"+data_base,"root","");
						}
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}

					return con;
			}
			
		public static void performQuery(String query)
			{
						try
						{ 		
             				ps = con.prepareStatement(query);
             				rs = ps.executeQuery();
           				}
       					catch(Exception ex)
       					{
            				JOptionPane.showMessageDialog(null,ex);
            			}
			}

		public static void performUpdate(String query)
			{
					try
					{
               			ps = con.prepareStatement(query);
               			is_stmt_executed = (byte)ps.executeUpdate();
               		}
               		catch(Exception e)
               		{
               			JOptionPane.showMessageDialog(null,e);
               		}
			}

		public static void closeConnections()
			{
				try
					{
						ps.close();
						con.close();
					}
				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e);
					}

			}

		public static boolean isFirstRow()
			{
				boolean check = false;

				try 
				{
					check = rs.first();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}

				return check;
			}

		public static void setImage(String img)
			{
				bg_image = new CustomResizableJLabel(img);
				frame.add(bg_image);
				bg_image.setBounds(0,0,CenterStage.framesizex,CenterStage.framesizey);
			}


		public static void setMiniImage(String img)
			{
				mini_bg_image = new CustomResizableJLabelForMiniFrame(img);
				miniframe.add(mini_bg_image);
				mini_bg_image.setBounds(0,0,800,600);
			}

		public static void setSuperMiniImage(String img)
			{
				bg_image = new CustomResizableJLabel(img);
				miniframe.add(bg_image);
				bg_image.setBounds(0,0,CenterStage.framesizex,CenterStage.framesizey);
			}

		public static void setSimpleImage(ImageIcon i)
			{
				mini_simple_image = new JLabel();
				mini_simple_image.setIcon(i);
				miniframe.add(mini_simple_image);
				miniframe.setVisible(true);
				mini_simple_image.setBounds(0,0,800,600);
				mini_simple_image.setFocusable(true);
				mini_simple_image.requestFocusInWindow();
			}
	} 

	
			