package airlines;

import java.awt.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class LoginType 
{

	public LoginType() 
	{
		JFrame f = new JFrame("Login Type");
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline1.jpg"));
            Image scaledImage = originalImage.getScaledInstance(1500, 700, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		f.setVisible(true);
		f.setLayout(null);
		
		JLabel header = new JLabel("Please Select your LoginType");
		header.setBounds(500,30,1000,40);
		header.setFont(new Font("Tohoma",Font.BOLD,30));
		header.setForeground(Color.red);
		f.add(header);
		
		JButton admin = new JButton("Admin");
		admin.setBounds(600,360,150,30);
		admin.setForeground(Color.gray);
		admin.setFont(new Font("Arial",Font.PLAIN,24));
		admin.setBackground(Color.white);
		f.add(admin);
		
		JButton passenger = new JButton("Passenger");
		passenger.setBounds(600,450,150,30);
		passenger.setForeground(Color.gray);
		passenger.setFont(new Font("Arial",Font.PLAIN,24));
		passenger.setBackground(Color.white);
		f.add(passenger);
		
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new AdminLogin();
				f.dispose();
			}
		});
		passenger.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new PassengerLogin();
				f.dispose();
			}
		});
		
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	

	public static void main(String[] args) 
	{
		new LoginType();
	}

}
