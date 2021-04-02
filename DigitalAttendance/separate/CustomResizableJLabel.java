package separate;

import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CustomResizableJLabel extends JLabel
	{
		String img;

		public CustomResizableJLabel(String img)
			{
				this.img = img;
			}

		public void paint(Graphics g) 
			{
      			Image imgt = createImage();
      			g.drawImage(imgt,0,0,this);
   		}

   		private Image createImage() 
   			{
      			BufferedImage bufferedImage = new BufferedImage(CenterStage.framesizex,CenterStage.framesizey,BufferedImage.TYPE_INT_RGB);
      			Graphics g = bufferedImage.getGraphics();
					
					try
						{
      						g.drawImage(ImageIO.read(new File(img)),0,0,CenterStage.framesizex,CenterStage.framesizey,this);
      					}
      				catch(Exception e) 
      					{	
      						JOptionPane.showMessageDialog(null,e);	
      					}

      			return bufferedImage;
   			}
	}