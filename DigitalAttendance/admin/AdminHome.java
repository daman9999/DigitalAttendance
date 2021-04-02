package admin;

import separate.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;


public class AdminHome extends EventClass
	{
		byte a;
		JButton teacher_tab,student_tab,lab_tab,subject_tab,attendance_tab;
		JButton add,delete,update;

		Boolean check = false;

		public AdminHome(byte a)
			{	
				add = new JButton();
				add.setContentAreaFilled(false);
				add.setBorder(null);
				add.addActionListener(this);
				add.addMouseListener(this);

				delete = new JButton();
				delete.setContentAreaFilled(false);
				delete.setBorder(null);
				delete.addActionListener(this);
				delete.addMouseListener(this);

				update = new JButton();
				update.setContentAreaFilled(false);
				update.setBorder(null);
				update.addActionListener(this);
				update.addMouseListener(this);

				this.a = a;

				CenterStage.frame = new JFrame();
				CenterStage.frame.setLayout(null);
				CenterStage.frame.setUndecorated(true);
          	
				teacher_tab = new JButton();
				teacher_tab.setContentAreaFilled(false);
				teacher_tab.setBorder(null);
				teacher_tab.setBounds(87,212,163,72);
				teacher_tab.addActionListener(this);
				teacher_tab.addMouseListener(this);
				
				student_tab = new JButton();
				student_tab.setContentAreaFilled(false);
				student_tab.setBorder(null);
				student_tab.setBounds(337,212,157,72);
				student_tab.setBorderPainted(true);
				student_tab.addActionListener(this);
				student_tab.addMouseListener(this);

				lab_tab = new JButton();
				lab_tab.setContentAreaFilled(false);
				lab_tab.setBorder(null);
				lab_tab.setBounds(606,211,92,72);
				lab_tab.addActionListener(this);
				lab_tab.addMouseListener(this);

				subject_tab = new JButton();
				subject_tab.setContentAreaFilled(false);
				subject_tab.setBorder(null);
				subject_tab.setBounds(822,211,120,76);
				subject_tab.addActionListener(this);
				subject_tab.addMouseListener(this);

				attendance_tab = new JButton();
				attendance_tab.setContentAreaFilled(false);
				attendance_tab.setBorder(null);
				attendance_tab.setBounds(1053,213,219,72);
				attendance_tab.addActionListener(this);
				attendance_tab.addMouseListener(this);
				
				CenterStage.setImage(Images.admin_home);

				CenterStage.exit.addActionListener(this);
				CenterStage.miniexit.addActionListener(this);

				CenterStage.frame.add(CenterStage.exit);
				CenterStage.frame.add(teacher_tab);
				CenterStage.frame.add(student_tab);
				CenterStage.frame.add(lab_tab);
				CenterStage.frame.add(attendance_tab);
				CenterStage.frame.add(subject_tab);
				
				CenterStage.frame.add(add);
				CenterStage.frame.add(delete);
				CenterStage.frame.add(update);
				CenterStage.frame.addKeyListener(this);

				CenterStage.frame.setVisible(true);
				CenterStage.frame.setSize(CenterStage.framesizex,CenterStage.framesizey);
			}

			public void actionPerformed(ActionEvent e)
				{
					CenterStage.con = CenterStage.establishConnection("localhost","DigitalAttendance");
					
					CenterStage.frame.add(CenterStage.scroll);
					check = true;

					add.setBounds(69,334,111,69);
					update.setBounds(69,460,111,67);
					delete.setBounds(71,597,111,68);

					if(e.getSource().equals(teacher_tab))
						{
							teacher_tab.setName("Teacher");

							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.teachers"+a+" ( name varchar(40) , id varchar(10) primary key , password varchar(15) , mobile_no bigint(11) , subject varchar(30) , semester int(2) ) " );							
							CenterStage.performQuery("SELECT *FROM teachers"+a);
							CenterStage.table.setModel(DbUtils.resultSetToTableModel(CenterStage.rs));
						}

					if(e.getSource().equals(student_tab))
						{
							teacher_tab.setName("Student");
							
							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.students"+a+"( name varchar(40) , rollno varchar(8) Primary key , mobile_no bigint(11) , id varchar(10) , password varchar(15) , semester int(2) )  " );							
							CenterStage.performQuery("SELECT *FROM students"+a);
							CenterStage.table.setModel(DbUtils.resultSetToTableModel(CenterStage.rs));
						}

					if(e.getSource().equals(lab_tab))
						{
							teacher_tab.setName("Lab");
							CenterStage.performUpdate("CREATE DATABASE IF NOT EXISTS labs");
						}

						if(e.getSource().equals(subject_tab))
						{
							teacher_tab.setName("Subject");

							CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.subjects"+a+"(sname varchar(25), scode int(7) primary key , semester int(1)  )");
							CenterStage.performQuery("Select * from subjects"+a);
							CenterStage.table.setModel(DbUtils.resultSetToTableModel(CenterStage.rs));
						}

						if(e.getSource().equals(attendance_tab))
						{	
							teacher_tab.setName("Attendance");
						}

						if(e.getSource().equals(add))
						{
							CenterStage.frame.setEnabled(false);

							if(teacher_tab.getName().equalsIgnoreCase("Teacher"))
							{
								CenterStage.performUpdate("CREATE TABLE IF NOT EXISTS DigitalAttendance.subjects"+a+" ( sname varchar(25), scode int(7) primary key , semester int(1))");
								CenterStage.performQuery("Select * from subjects"+a);

								if(CenterStage.isFirstRow())
            					{	
            						new AddTeacher(a);
           						}
            					
            					else
            					{
            						JOptionPane.showMessageDialog(null, "There are No Subjects Added, Please Add subjects , Click Ok to Proceed");
            						new AddSubject(a);		
            					}
							}
						
							else if(teacher_tab.getName().equalsIgnoreCase("Student"))
							{
									new AddStudent(a);
							}
							
							else if(teacher_tab.getName().contains("Lab"))
							{
									new AddLab();
							}

							else if(teacher_tab.getName().contains("Subject"))
							{
								new AddSubject(a);
							}							
						}

						if(e.getSource().equals(delete))
							{
								if(teacher_tab.getName().equalsIgnoreCase("Teacher"))
								{
									CenterStage.performQuery("Select * from teachers"+a);

									if(CenterStage.isFirstRow())
            							{	
            								new DeleteTeacher(a);
           								}
            						else
            							{
            								JOptionPane.showMessageDialog(null, "There Is no Teacher Added For The Semester"+a);
            								CenterStage.frame.setEnabled(true);
            							}
								}
								

								else if(teacher_tab.getName().equalsIgnoreCase("Subject"))
									{
										CenterStage.performQuery("Select * from subjects"+a);

									if(CenterStage.isFirstRow())
            							{	
            								new DeleteSubject(a);
           								}
            						else
            							{
            								JOptionPane.showMessageDialog(null, "There Is no Subject Added For The Semester"+a);
            								CenterStage.frame.setEnabled(true);
            							}
									}					
								
								
								else if(teacher_tab.getName().equalsIgnoreCase("Student"))
									{
										CenterStage.performQuery("Select * from students"+a);

									if(CenterStage.isFirstRow())
            							{	
            								new DeleteStudent(a);
           								}
            						else
            							{
            								JOptionPane.showMessageDialog(null, "There Is no Student Added For The Semester"+a);
            								CenterStage.frame.setEnabled(true);
            							}
									}			
							}
							

						if(e.getSource().equals(update))
						{
							CenterStage.frame.setEnabled(false);

							if(teacher_tab.getName().equalsIgnoreCase("Teacher"))
							{
								CenterStage.performQuery("Select * from teachers"+a);

								if(CenterStage.isFirstRow())
            					{	
            						new UpdateTeacher(a);
           						}
            					
            					else
            					{
            						JOptionPane.showMessageDialog(null, "There Is no Teacher Added For The Semester"+a);
            						CenterStage.frame.setEnabled(true);
            					}
							}


							if(teacher_tab.getName().equalsIgnoreCase("Subject"))
							{
								CenterStage.performQuery("Select * from subjects"+a);

								if(CenterStage.isFirstRow())
            					{	
            						new UpdateSubject(a);
           						}
            					
            					else
            					{
            						JOptionPane.showMessageDialog(null, "There Is no Subject Added For The Semester"+a);
            						CenterStage.frame.setEnabled(true);
            					}
							}

							if(teacher_tab.getName().equalsIgnoreCase("Student"))
							{
								CenterStage.performQuery("Select * from students"+a);

								if(CenterStage.isFirstRow())
            					{	
            						new UpdateStudent(a);
           						}
            					
            					else
            					{
            						JOptionPane.showMessageDialog(null, "There Is no Student Added For The Semester"+a);
            						CenterStage.frame.setEnabled(true);
            					}
							}
						}

						if(e.getSource().equals(CenterStage.miniexit))
							{
								CenterStage.miniframe.dispose();
								CenterStage.frame.setEnabled(true);
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
						/*JOptionPane.showMessageDialog(null,e.getKeyCode());
						if(e.getKeyCode() == 27)
							{
								JOptionPane.showMessageDialog(null,e);
								CenterStage.frame.dispose();
							}*/
					}

				public void mouseEntered(MouseEvent e)
					{
							CenterStage.frame.remove(CenterStage.bg_image);
								if(e.getSource() == student_tab)
									{
										CenterStage.setImage(Images.student_selected);
									}
								else if(e.getSource() == teacher_tab)
									{
										CenterStage.setImage(Images.admin_home);
									}
								else if(e.getSource() == lab_tab)
									{
										CenterStage.setImage(Images.lab_selected);
									}
								else if(e.getSource() == subject_tab)
									{
										CenterStage.setImage(Images.subject_selected);
									}
								else if(e.getSource() == attendance_tab)
									{
										CenterStage.setImage(Images.attendance_selected);
									}									

								else if(e.getSource() == add)
									{
										String temp = teacher_tab.getName();

										if(temp.equalsIgnoreCase("Teacher"))
											{
												CenterStage.setImage(Images.add_teacher);
											}
										else if(temp.equalsIgnoreCase("Student"))
											{
												CenterStage.setImage(Images.add_student);
											}
										else if(temp.equalsIgnoreCase("Lab"))
											{
												CenterStage.setImage(Images.add_lab);
											}
										else if(temp.equalsIgnoreCase("Subject"))
											{
												CenterStage.setImage(Images.add_subject);
											}
										else if(temp.equalsIgnoreCase("Attendance"))
											{
												CenterStage.setImage(Images.add_attendance);
											}
									}

								else if(e.getSource() == delete)
									{
										String temp = teacher_tab.getName();

										if(temp.equalsIgnoreCase("Teacher"))
											{
												CenterStage.setImage(Images.delete_teacher);
											}
										else if(temp.equalsIgnoreCase("Student"))
											{
												CenterStage.setImage(Images.delete_student);
											}
										else if(temp.equalsIgnoreCase("Lab"))
											{
												CenterStage.setImage(Images.delete_lab);
											}
										else if(temp.equalsIgnoreCase("Subject"))
											{
												CenterStage.setImage(Images.delete_subject);
											}
										else if(temp.equalsIgnoreCase("Attendance"))
											{
												CenterStage.setImage(Images.delete_attendance);
											}
									}

								else if(e.getSource() == update)
									{
										String temp = teacher_tab.getName();

										if(temp.equalsIgnoreCase("Teacher"))
											{
												CenterStage.setImage(Images.update_teacher);
											}
										else if(temp.equalsIgnoreCase("Student"))
											{
												CenterStage.setImage(Images.update_student);
											}
										else if(temp.equalsIgnoreCase("Lab"))
											{
												CenterStage.setImage(Images.update_lab);
											}
										else if(temp.equalsIgnoreCase("Subject"))
											{
												CenterStage.setImage(Images.update_subject);
											}
										else if(temp.equalsIgnoreCase("Attendance"))
											{
												CenterStage.setImage(Images.update_attendance);
											}
									}								
					}

				public void mouseExited(MouseEvent e)
					{
						CenterStage.frame.remove(CenterStage.bg_image);
						if(check == false)
							{ 
								//student_tab.getGraphics().drawRect(0,0,157,72);
								//student_tab.paintBorder(student_tab.getGraphics());
								CenterStage.setImage(Images.admin_home);
							}
						else
							{
								String temp = teacher_tab.getName();

								if(temp.equalsIgnoreCase("Teacher"))
									{
										CenterStage.setImage(Images.admin_home);
									}
								else if(temp.equalsIgnoreCase("Student"))
									{
										CenterStage.setImage(Images.student_selected);
									}
								else if(temp.equalsIgnoreCase("Lab"))
									{
										CenterStage.setImage(Images.lab_selected);
									}
								else if(temp.equalsIgnoreCase("Subject"))
									{
										CenterStage.setImage(Images.subject_selected);
									}
								else
									{
										CenterStage.setImage(Images.attendance_selected);
									}	
							}
					}			

	}