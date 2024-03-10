package airlines;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AdminMainFrame {

	public AdminMainFrame(String user) 
	{
		JFrame f = new JFrame("Admin Main Frame");
		JLabel header = new JLabel("Hello " +user+"! Welcome to Indian Airlines!");
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline6.jpg"));
            Image scaledImage = originalImage.getScaledInstance(1500, 700, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		
		header.setFont(new Font("Arial",Font.BOLD,45));
		header.setForeground(Color.cyan);
		header.setBounds(270,40,1000,50);
		
		JButton addflight = new JButton("Add Flight");
		addflight.setFont(new Font("Arial",Font.PLAIN,34));
		addflight.setForeground(Color.darkGray);
		addflight.setBackground(Color.white);
		addflight.setBounds(200,250,350,50);
		
		JButton passengerinfo = new JButton("Passenger Info");
		passengerinfo.setFont(new Font("Arial",Font.PLAIN,34));
		passengerinfo.setForeground(Color.darkGray);
		passengerinfo.setBackground(Color.white);
		passengerinfo.setBounds(750,250,350,50);
		
		JButton deletepassenger = new JButton("Delete Passenger");
		deletepassenger.setFont(new Font("Arial",Font.PLAIN,34));
		deletepassenger.setBounds(200,390,350,50);
		deletepassenger.setForeground(Color.darkGray);
		deletepassenger.setBackground(Color.white);
		
		JButton flightinfo = new JButton("Flight Info");
		flightinfo.setBounds(750,390,350,50);
		flightinfo.setBackground(Color.white);
		flightinfo.setFont(new Font("Arial",Font.PLAIN,34));
		flightinfo.setForeground(Color.darkGray);
		
		JButton back = new JButton("Back to Login page");
		back.setFont(new Font("Arial",Font.PLAIN,34));
		back.setForeground(Color.darkGray);
		back.setBackground(Color.white);
		back.setBounds(200,530,350,50);
		
		JButton about = new JButton("About");
		about.setBackground(Color.white);
		about.setBounds(750,530,350,50);
		about.setFont(new Font("Arial",Font.PLAIN,34));
		about.setForeground(Color.darkGray);
		
		
		f.add(header);
		f.add(addflight);
		f.add(passengerinfo);
		f.add(deletepassenger);
		f.add(flightinfo);
		f.add(back);
		f.add(about);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		addflight.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new AddFlight(user);
						f.dispose();
					}
				});
		passengerinfo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new PassengerInfo(user);
				f.dispose();
			}
		});
		deletepassenger.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new DeletePassenger(user);
				f.dispose();
			}
		});
		about.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new About(user);
				f.dispose();
			}
		});
		flightinfo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new FlightInfo(user);
				f.dispose();
			}
		});
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new LoginType();
				f.dispose();
			}
		});
	}

	public static void main(String[] args) 
	{
		//new AdminMainFrame("");
	}

}
