package airlines;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PassengerInfo 
{
	JTable tb;
	JButton show,back;
	public PassengerInfo(String user) 
	{
		JFrame f = new JFrame("Passenger Info");
		
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		try 
		{
			 BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline4.jpg"));

            Image scaledImage = originalImage.getScaledInstance(1400, 1000, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
			System.out.println("Image Not Found");        
		}
		
		
		show = new JButton("Show Passengers");
		show.setBounds(500,50,300,40);
		show.setFont(new Font("Arial",Font.PLAIN,28));
		show.setForeground(Color.green);
		show.setBackground(Color.darkGray);
		f.add(show);
		
		back = new JButton("Back");
		back.setBounds(400,650,100,30);
        back.setBackground(Color.yellow);
        back.setForeground(Color.blue);
        f.add(back);
		
		show.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent t)
					{
						String query = "Select *from passengers";
						
						try
						{
							Database conn = new Database();
							ResultSet rs = conn.stmt.executeQuery(query);
							String list [][] = new String [10000][8];
							int i = 0;
							String columns[] = {"Username","Password","Name","Email","Passport No","Gender","Mobile No"};
							
							while(rs.next())
							{
								String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7) };
								list[i ++] = data;
							}
							
							tb = new JTable(list,columns);
							
							JScrollPane pane = new JScrollPane(tb);
							pane.setBounds(150, 200,1000, 400);
							f.add(pane);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(f,"Error while connecting to DataBase");
						}
					}
				});
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new AdminMainFrame(user);
				f.dispose();
			}
		});
		
		f.setVisible(true);
		
	}

	public static void main(String[] args) 
	{
	}

}
