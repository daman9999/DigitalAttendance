package separate;

import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CustomResizableJLabelForMiniFrame extends JLabel
	{
		String img;

		public CustomResizableJLabelForMiniFrame(String img)
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
      			BufferedImage bufferedImage = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
      			Graphics g = bufferedImage.getGraphics();
					
					try
						{
      						g.drawImage(ImageIO.read(new File(img)),0,0,800,600,this);
      					}
      				catch(Exception e) 
      					{	
      						JOptionPane.showMessageDialog(null,e);	
      					}

      			return bufferedImage;
   			}
	}