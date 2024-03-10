package airlines;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About 
{

	public About(String user) 
	{
		JFrame f = new JFrame("Admins");
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JButton back = new JButton("Back");
		back.setBounds(20,30,100,40);
		back.setFont(new Font("Arial",Font.PLAIN,22));
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		
		//f.add(back);)
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Admins.png"));
            Image scaledImage = originalImage.getScaledInstance(700, 600, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		
		f.add(back);
		f.setVisible(true);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new AdminMainFrame(user);
				f.dispose();
			}
		});
		
	}

	public static void main(String[] args) 
	{
	}

}
