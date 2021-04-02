package separate;

import javax.swing.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;


public class Images	    			
	{
		public static String admin_create,admin_login,semester,admin_home,add_teacher,delete_teacher,update_teacher,teacher_selected,add_student,delete_student,student_selected,update_student;
		public static String add_lab,delete_lab,update_lab,lab_selected,add_subject,delete_subject,update_subject,subject_selected,add_attendance,delete_attendance,update_attendance,attendance_selected;
		public static String logo;

		static
		{
			try
			{
				 logo = "E:\\DigitalAttendance\\photos\\logo.jpg";

		    	 admin_create =  "E:\\DigitalAttendance\\photos\\admin_create.jpg";
		    	 admin_login =  "E:\\DigitalAttendance\\photos\\admin_login.jpg";
		    	 semester =  "E:\\DigitalAttendance\\photos\\semester.jpg";
		         admin_home =  "E:\\DigitalAttendance\\photos\\admin_home.jpg";
		
		  	  	 add_teacher=  "E:\\DigitalAttendance\\photos\\add_teacher.jpg";
		   	 	 delete_teacher=  "E:\\DigitalAttendance\\photos\\delete_teacher.jpg";
		    	 update_teacher=  "E:\\DigitalAttendance\\photos\\update_teacher.jpg";
		    	 teacher_selected=  "E:\\DigitalAttendance\\photos\\teacher_selected.jpg";

		    	 add_student=  "E:\\DigitalAttendance\\photos\\add_student.jpg";
		    	 delete_student=  "E:\\DigitalAttendance\\photos\\delete_student.jpg";
		    	 student_selected=  "E:\\DigitalAttendance\\photos\\student_selected.jpg";
		    	 update_student=  "E:\\DigitalAttendance\\photos\\update_student.jpg";

		    	 add_lab=  "E:\\DigitalAttendance\\photos\\add_lab.jpg";
		    	 delete_lab =  "E:\\DigitalAttendance\\photos\\delete_lab.jpg";
	   	    	 update_lab =  "E:\\DigitalAttendance\\photos\\update_lab.jpg";
	   	    	 lab_selected=  "E:\\DigitalAttendance\\photos\\lab_selected.jpg";

		    	 add_subject=  "E:\\DigitalAttendance\\photos\\add_subject.jpg";
		     	 delete_subject =  "E:\\DigitalAttendance\\photos\\delete_subject.jpg";
		      	 update_subject=  "E:\\DigitalAttendance\\photos\\update_subject.jpg";
		    	 subject_selected=  "E:\\DigitalAttendance\\photos\\subject_selected.jpg";
	   
	        	 add_attendance =  "E:\\DigitalAttendance\\photos\\add_attendance.jpg";
	        	 delete_attendance =  "E:\\DigitalAttendance\\photos\\delete_attendance.jpg";
	        	 update_attendance=  "E:\\DigitalAttendance\\photos\\update_attendance.jpg";
		    	 attendance_selected=  "E:\\DigitalAttendance\\photos\\attendance_selected.jpg";
		    }
		    catch(Exception e)
		    	{
		    		JOptionPane.showMessageDialog(null,"HEkko"+e);
		    	}

		    }
		    public static class Teacher 
			{	
				    public static String add,update,delete;

				    static
				    {
				     	add = "E:\\DigitalAttendance\\photos\\Teacher\\add.jpg";
				     	update = "E:\\DigitalAttendance\\photos\\Teacher\\update.png";	
				     	delete = "E:\\DigitalAttendance\\photos\\Teacher\\delete.png";		
				    }
			}

			public static class Subject 
			{	
				    public static String add,update,delete;;

				    static
				    {
				     	add = "E:\\DigitalAttendance\\photos\\Subject\\add.jpg";		
				     	update = "E:\\DigitalAttendance\\photos\\Subject\\update.jpg";	
				     	delete = "E:\\DigitalAttendance\\photos\\Subject\\delete.jpg";			
				    }
			}

			public static class Student 
			{	
				    public static String add,update,delete;;

				    static
				    {
				     	add = "E:\\DigitalAttendance\\photos\\Student\\add.jpg";		
				     	update = "E:\\DigitalAttendance\\photos\\Student\\update.jpg";	
				     	delete = "E:\\DigitalAttendance\\photos\\Student\\delete.jpg";			
				    }
			}

			public static class Lab 
			{	
				    public static String add,update,delete,status;

				    static
				    {
				     	add = "E:\\DigitalAttendance\\photos\\Lab\\add.jpg";
				     	update = "E:\\DigitalAttendance\\photos\\Lab\\update.png";	
				     	delete = "E:\\DigitalAttendance\\photos\\Lab\\delete.png";		
				     	status = "E:\\DigitalAttendance\\photos\\Lab\\status.jpg";
				    }
			}
	
	}