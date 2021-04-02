package admin;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import separate.*;

public class CheckStatus extends EventClass
	{
		static JRadioButton[] pc;
    	ButtonGroup[]  gr;
    	JLabel[] pcno;
    	byte number_of_pc;
		

		public CheckStatus(byte number_of_pc)
			{
				this.number_of_pc = number_of_pc;
    			CenterStage.superminiframe = new JFrame();
    			CenterStage.superminiframe.setUndecorated(true);
    			CenterStage.superminiframe.setLayout(null);
    			CenterStage.setSuperMiniImage(Images.Lab.status);
    			CenterStage.superminiframe.add(CenterStage.exit);
    			initializeButtons();

				CenterStage.superminiframe.setVisible(true);
				CenterStage.superminiframe.setSize(CenterStage.framesizex,CenterStage.framesizey);
			}

		public void initializeButtons()
			{
				int i=0,j=0;
				short a = (short)(CenterStage.framesizex);
				short k = (short)(CenterStage.framesizey);

				do
					{
						a = (short)(a/2);
					}while(!(a<=30));

				do
					{
						k =(short)( k / 2);
					}while(!(k<=35));

       			short templpy = (short)(CenterStage.framesizey - k);

		        short radio = (short)(number_of_pc*2);
		        short group = (short)(number_of_pc);		       
		      
		       try
		       {
		         pc = new JRadioButton[radio];
		         gr = new ButtonGroup[group];
		         pcno = new JLabel[group];
		        
		        
		        A:   for(i=0;i<pc.length;i=i+2)
		        {
		        
		        for(;j<gr.length;)
		        {  
		            pcno[j] = new JLabel("Pc-"+(j+1));
		            pcno[j].setBounds(a,k,50,20);
		            CenterStage.superminiframe.add(pcno[j]);
		             
		           
		                pc[i] = new JRadioButton("Working");
		                pc[i+1] = new JRadioButton("Not Working");
		                pc[i].setSelected(true);
		               
		            
		            pc[i].setBounds(a+60,k,100,20);
		            pc[i+1].setBounds(a+160,k,100,20);
		            
		            CenterStage.superminiframe.add(pc[i]);
		            CenterStage.superminiframe.add(pc[i+1]);
		            
		          if(k<templpy)
		          {
		                k = (short) (k + 25);
		          }
		          else
		          {
		                a = (short) (a+500);
		                k = (short) (CenterStage.framesizey-templpy);
		          }
		          
		        gr[j] = new ButtonGroup();
		        
		        gr[j].add(pc[i]);
		        gr[j].add(pc[i+1]);
		        
		        j++; 
		        continue A;
		        }
		    }

		        //AddLab.check = true;               
		       }
		       catch(Exception e)
		       {
		           JOptionPane.showMessageDialog(null, e);
		       }
		       
		       //submit.setLocation(a+100, k);
		       //add(submit);
		    }
			
}
	