package airlines;

import java.sql.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CancelTicket 
{

	public CancelTicket(String username,String password) 
	{
		JFrame f = new JFrame("Cancel Ticket");
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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
		
		JLabel header = new JLabel("Cancel Ticket");
		header.setBounds(150,40,250,40);
		header.setFont(new Font("Tohoma",Font.BOLD,30));
		header.setForeground(Color.black);
		f.add(header);
		
		JButton code = new JButton("Flight Code");
		code.setBounds(20,150,200,30);
		code.setFont(new Font("Tohoma",Font.PLAIN,26));
		code.setForeground(Color.green);
		code.setBackground(Color.black);
		
		f.add(code);
		JTextField codetf = new JTextField();
		codetf.setBounds(300,150,200,30);
		codetf.setFont(new Font("Tohoma",Font.PLAIN,26));
		f.add(codetf);
		
		JButton cancel = new JButton("Delete");
		cancel.setBackground(Color.red);
		cancel.setFont(new Font("Tohoma",Font.PLAIN,24));
		cancel.setForeground(Color.green);
		cancel.setBounds(50,250,150,30);
		f.add(cancel);
		
		JButton back = new JButton("Back");
		back.setBounds(280,250,150,30);
		back.setFont(new Font("Tohoma",Font.PLAIN,24));
		back.setForeground(Color.green);
		back.setBackground(Color.red);
		f.add(back);
		
		cancel.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String flight = codetf.getText();
						
						String query = "select *from reservation where username = '"+username+"' and flightcode = '"+flight+"' ";
						
						try
						{
							Database conn = new Database();
							ResultSet rs= conn.stmt.executeQuery(query);
							boolean flag = true;
							while(rs.next())
							{
								flag = false;
								String from = rs.getString(4);
								String to = rs.getString(5);
								String date = rs.getString(8);
								String str = "insert into cancelHistory(username,flightcode,source,destination) values ('"+username+"' , '"+flight+"', '"+from+"', '"+to+"') ";
								int rss = conn.stmt.executeUpdate("delete from reservation where username = '"+username+"' and flightcode = '"+flight+"' and date = '"+date+"' ");
								int r = conn.stmt.executeUpdate(str);
								JOptionPane.showMessageDialog(null,"Ticket Cancelled Successfully");
								
							}
							if(flag) JOptionPane.showMessageDialog(null,"No Tickets Found with that Flight Code");
						}
						catch(Exception ex)
						{
							System.out.println(ex);
						}
					}
				});
		
		
		f.setVisible(true);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new PassengerMainFrame(username,password);
			}
		});
		
	}

	public static void main(String[] args) 
	{
		//new CancelTicket("","");
	}

}
