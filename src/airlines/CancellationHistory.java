package airlines;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class CancellationHistory 
{
	JTable tb;
	public CancellationHistory(String username,String password) 
	{
		JLabel header = new JLabel("Cancellation History");
		
		JFrame f = new JFrame("Cancellation History");
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
			String query = "select *from cancelHistory where username = '"+username+"' ";
			ResultSet rs = conn.stmt.executeQuery(query);
			
			String list[][] = new String[10000][4];
			int i = 0;
			String columns[] = {"Username" , "Flightcode" , "Source","Destination"};
			while(rs.next())
			{
				String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				list[i ++] = data;
			}
			
			tb = new JTable(list,columns);
			
			JScrollPane pane = new JScrollPane(tb);
			pane.setBounds(200,100,1000,350);
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
				new PassengerMainFrame(username,password);
			}
		});
	}

	public static void main(String[] args) 
	{
		//new CancellationHistory("","");
	}

}
