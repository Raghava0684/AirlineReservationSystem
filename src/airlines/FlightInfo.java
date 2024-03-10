package airlines;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class FlightInfo {
    JTable tb;

    public FlightInfo(String user) {
        JFrame f = new JFrame("Flight Information"); // Corrected typo
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        try 
		{
			 BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline6.jpg"));

            Image scaledImage = originalImage.getScaledInstance(1400, 1000, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
			System.out.println("Image Not Found");        
		}
        
        JButton header = new JButton("Available Flights");
        header.setBounds(300,100,300,40);
        header.setForeground(Color.red);
        header.setBackground(Color.white);
        header.setFont(new Font("Arial",Font.BOLD,30));
        f.add(header);
        JButton info = new JButton("Show");
        info.setBounds(750, 100, 250, 40);
        info.setFont(new Font("Tahoma", Font.PLAIN, 28));
        info.setForeground(Color.darkGray);
        f.add(info);
        
        JButton back = new JButton("Back");
        back.setBounds(400,650,100,30);
        back.setBackground(Color.yellow);
        back.setForeground(Color.blue);
        f.add(back);

        f.setVisible(true);

        info.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    String query = "select * from flight";
                    Database conn = new Database();
                    ResultSet rs = conn.stmt.executeQuery(query);
                    
                    String column[] = {"flightcode","flightname","source","destination","class","amount"};
                    String ans[][] = new String[1000][7];
                    int i = 0;
                    while(rs.next())
                    {
                    	String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                    	ans[i ++] = data;
                    }
                    tb = new JTable(ans,column);
                    JScrollPane scrollPane = new JScrollPane(tb);
                    scrollPane.setBounds(250, 200,1000, 400);
                    f.add(scrollPane);
                      
                    JOptionPane.showMessageDialog(null,"Fetched Successfully");
                } 
                catch (SQLException ex) 
                {
                    ex.printStackTrace();
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
    }

    public static void main(String[] args) 
    {
    	//new FlightInfo("");
    }
}
