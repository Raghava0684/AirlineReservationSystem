package airlines;

import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FlightRoutes 
{
	JTable tb;
	public FlightRoutes(String username,String password) 
	{
		JFrame f = new JFrame("Flight Routes");
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
		
		JLabel header = new JLabel("Flight Routes");
		header.setBounds(600,30,300,40);
		header.setFont(new Font("Tohoma",Font.BOLD,35));
		header.setForeground(Color.black);
		
		f.add(header);
		JLabel source = new JLabel("Source");
		source.setBounds(500,100,200,30);
		source.setFont(new Font("Tohoma",Font.BOLD,30));
		source.setForeground(Color.red);
		f.add(source);
		
		
		JLabel destination = new JLabel("Destination");
		destination.setBounds(500,150,200,30);
		destination.setFont(new Font("Tohoma",Font.BOLD,30));
		destination.setForeground(Color.red);
		f.add(destination);
		
		
		String sources[] = {"select city","Telangana","Andhra Pradhesh","Arunachal Pradhesh","Goa","Tamil Nadu","Gujarath","Punjab","Rajasthan","Haryana","Madhya Pradhesh","Maharashtra","Delhi","Uttarakhand","Uttar Pradhesh","Kerala","Karnataka"};
		String dest[] = {"select city","Telangana","Andhra Pradhesh","Arunachal Pradhesh","Goa","Tamil Nadu","Gujarath","Punjab","Rajasthan","Haryana","Madhya Pradhesh","Maharashtra","Delhi","Uttarakhand","Uttar Pradhesh","Kerala","Karnataka"};
		
		JComboBox src = new JComboBox(sources);
		src.setFont(new Font("Tohoma",Font.PLAIN,22));
		JComboBox destin = new JComboBox(dest);
		destin.setFont(new Font("Tohoma",Font.PLAIN,22));
		
		src.setBounds(750,100,200,30);
		destin.setBounds(750,150,200,30);
		f.add(src);
		f.add(destin);
		
		JButton show = new JButton("Show");
		show.setBounds(550,230,150,30);
		show.setBackground(Color.black);
		show.setForeground(Color.green);
		show.setFont(new Font("Tohoma",Font.PLAIN,28));
		f.add(show);
		
		JButton back = new JButton("Back");
		back.setBounds(760,230,150,30);
		back.setBackground(Color.black);
		back.setForeground(Color.green);
		back.setFont(new Font("Tohoma",Font.PLAIN,28));
		f.add(back);
		
		f.setVisible(true);
		
		show.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String source = (String) src.getSelectedItem();
						String desti = (String) destin.getSelectedItem();
						String query = "select *from flight where source = '"+source+"' and destination = '"+desti+"' ";
						
						try
						{
							Database conn = new Database();
							ResultSet rs = conn.stmt.executeQuery(query);
							
							String list[][] = new String[10000][6];
							int i = 0;
							String columns[] = {"Username" , "Flightcode" , "Source","Destination"};
							while(rs.next())
							{
								String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
								list[i ++] = data;
							}
							
							tb = new JTable(list,columns);
							
							JScrollPane pane = new JScrollPane(tb);
							pane.setBounds(200,350,1000,300);
							f.add(pane);
						}
						catch(Exception ex)
						{
							System.out.println(ex);
						}
					}
				});
		
		back.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new PassengerMainFrame(username,password);
						f.dispose();
					}
				});
		
	}

	public static void main(String[] args) 
	{
	}

}
