package airlines;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PassengerMainFrame 
{

	public PassengerMainFrame(String user,String pass) 
	{
		JFrame f = new JFrame("Passenger Main Frame");
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline7.jpg"));
            Image scaledImage = originalImage.getScaledInstance(1500, 700, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		JLabel header = new JLabel("Hello " + user+"! Welcome to Indian Airlines!");
		header.setFont(new Font("Arial",Font.BOLD,45));
		header.setForeground(Color.white);
		header.setBounds(200,30,1000,50);
		
		JButton passengerdetails = new JButton("Passenger Details");
		passengerdetails.setFont(new Font("Arial",Font.PLAIN,34));
		passengerdetails.setForeground(Color.blue);
		passengerdetails.setBounds(200,250,350,50);
		
		JButton bookticket = new JButton("Book Ticket");
		bookticket.setFont(new Font("Arial",Font.PLAIN,34));
		bookticket.setForeground(Color.blue);
		bookticket.setBounds(750,250,350,50);
		
		JButton flightroutes = new JButton("Flight Routes");
		flightroutes.setFont(new Font("Arial",Font.PLAIN,34));
		flightroutes.setBounds(200,370,350,50);
		flightroutes.setForeground(Color.blue);
		
		JButton reservation = new JButton("Reservation Details");
		reservation.setBounds(750,370,350,50);
		reservation.setFont(new Font("Arial",Font.PLAIN,34));
		reservation.setForeground(Color.blue);
		
		JButton cancelticket = new JButton("Cancel Ticket");
		cancelticket.setFont(new Font("Arial",Font.PLAIN,34));
		cancelticket.setForeground(Color.blue);
		cancelticket.setBounds(200,480,350,50);
		
		JButton cancelhistory = new JButton("Cancellation History");
		cancelhistory.setBounds(750,480,350,50);
		cancelhistory.setFont(new Font("Arial",Font.PLAIN,34));
		cancelhistory.setForeground(Color.blue);
		
		JButton paymenthistory = new JButton("Payment History");
		paymenthistory.setBounds(200,590,350,50);
		paymenthistory.setFont(new Font("Arial",Font.PLAIN,34));
		paymenthistory.setForeground(Color.blue);
		
		JButton back = new JButton("Back to Login page");
		back.setBounds(750,590,350,50);
		back.setForeground(Color.blue);
		back.setFont(new Font("Arial",Font.PLAIN,34));
		
		f.add(header);
		f.add(passengerdetails);
		f.add(bookticket);
		f.add(cancelticket);
		f.add(cancelhistory);
		f.add(paymenthistory);
		f.add(back);
		f.add(flightroutes);
		f.add(reservation);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		passengerdetails.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new PassengerDetails(user,pass);
						f.dispose();
					}
				});
		bookticket.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new BookTicket(user,pass);
				f.dispose();
			}
		});
		cancelticket.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				new CancelTicket(user,pass);
				f.dispose();
			}
		});
		paymenthistory.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Payments(user,pass);
			}
		});
		cancelhistory.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new CancellationHistory(user,pass);
				f.dispose();
			}
		});
		
		reservation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Reservation(user,pass);
				f.dispose();
			}
		});
		
		flightroutes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new FlightRoutes(user,pass);
				f.dispose();
			}
		});
		
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new PassengerLogin();
				f.dispose();
			}
		});
	}

	public static void main(String[] args) 
	{
			//new PassengerMainFrame("","");
	}

}
