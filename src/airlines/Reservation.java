package airlines;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Reservation 
{
	JTable tb;
	public Reservation(String username,String pass) 
	{
		JLabel header = new JLabel("Reservation History");
		
		JFrame f = new JFrame("Reservation History");
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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
		
		header.setBounds(550,50,350,40);
		header.setFont(new Font("Tohoma",Font.BOLD,30));
		header.setForeground(Color.white);
		f.add(header);
		
		JButton back = new JButton("Back");
		back.setBounds(100,600,100,30);
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		f.add(back);
		try
		{
			Database conn = new Database();
			String query = "select *from reservation where username = '"+username+"' ";
			ResultSet rs = conn.stmt.executeQuery(query);
			
			String list[][] = new String[10000][8];
			int i = 0;
			String columns[] = {"FlightName" , "Flightcode" ,"Username", "Source","Destination","Amount","Time","Date"};
			while(rs.next())
			{
				String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
				list[i ++] = data;
			}
			
			tb = new JTable(list,columns);
			
			JScrollPane pane = new JScrollPane(tb);
			pane.setBounds(200,100,1000,300);
			f.add(pane);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		f.setVisible(true);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new PassengerMainFrame(username,pass);
				f.dispose();
			}
		});
	}

	public static void main(String[] args) 
	{
		//new Reservation("");
	}

}
