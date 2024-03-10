package airlines;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;

public class AddFlight 
{

	public AddFlight(String user) 
	{
		JFrame f = new JFrame("Add Flight Frame");
		
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
		
		JLabel header = new JLabel("Add Flight Details");
		header.setBounds(200,30,360,40);
		header.setFont(new Font("Arial",Font.BOLD,35));
		header.setForeground(Color.black);
		
		JLabel flightname = new JLabel("Flight Name");
		flightname.setBounds(100,150,250,40);
		flightname.setFont(new Font("Tohoma",Font.PLAIN,30));
		flightname.setForeground(Color.white);
		JTextField flightnametf = new JTextField();
		flightnametf.setBounds(350,150,250,40);
		flightnametf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel flightcode = new JLabel("Flight Code");
		flightcode.setBounds(100,220,250,40);
		flightcode.setFont(new Font("Tohoma",Font.PLAIN,30));
		flightcode.setForeground(Color.white);
		JTextField flightcodetf = new JTextField();
		flightcodetf.setBounds(350,220,250,40);
		flightcodetf.setFont(new Font("Arial",Font.PLAIN,22));
		
		String sources[] = {"select city","Telangana","Andhra Pradhesh","Arunachal Pradhesh","Goa","Tamil Nadu","Gujarath","Punjab","Rajasthan","Haryana","Madhya Pradhesh","Maharashtra","Delhi","Uttarakhand","Uttar Pradhesh","Kerala","Karnataka"};
		String dest[] = {"select city","Telangana","Andhra Pradhesh","Arunachal Pradhesh","Goa","Tamil Nadu","Gujarath","Punjab","Rajasthan","Haryana","Madhya Pradhesh","Maharashtra","Delhi","Uttarakhand","Uttar Pradhesh","Kerala","Karnataka"};
		String classs[] = {"Select","Economy","Business","Premium"};
		
		JLabel source = new JLabel("Source");
		source.setBounds(100,290,250,40);
		source.setForeground(Color.white);
		source.setFont(new Font("Tohoma",Font.PLAIN,30));

		JLabel destination = new JLabel("Destination");
		destination.setBounds(100,360,250,40);
		destination.setForeground(Color.white);
		destination.setFont(new Font("Tohoma",Font.PLAIN,30));

		JComboBox src = new JComboBox(sources);
		JComboBox destin = new JComboBox(dest);
		JComboBox clas = new JComboBox(classs);
		
		src.setBounds(350,290,250,40);
		src.setFont(new Font("Tohoma",Font.PLAIN,26));
//		src.setBackground(Color.white);
		destin.setBounds(350,360,250,40);
		destin.setFont(new Font("Tohoma",Font.PLAIN,26));
		//destin.setBackground(Color.yellow);
		
		JLabel Class = new JLabel("Class");
		Class.setBounds(100,430,250,40);
		Class.setFont(new Font("Tohoma",Font.PLAIN,30));
		Class.setForeground(Color.white);
		clas.setBounds(350,430,250,40);
		clas.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel cost = new JLabel("Cost Of Service");
		cost.setFont(new Font("Tohoma",Font.PLAIN,30));
		cost.setForeground(Color.white);
		cost.setBounds(100,500,250,40);
		JTextField costtf = new JTextField();
		costtf.setBounds(350,500,250,40);
		costtf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JButton save = new JButton("Save");
		save.setBounds(155,620,150,40);
		save.setFont(new Font("Tohoma",Font.PLAIN,26));
		save.setForeground(Color.black);
		save.setBackground(Color.green);
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(355,620,160,40);
		cancel.setFont(new Font("Tohoma",Font.PLAIN,26));
		cancel.setForeground(Color.black);
		cancel.setBackground(Color.red);
		
		f.add(save);
		f.add(cancel);
		f.add(src);
		f.add(destin);
		f.add(cost);
		f.add(costtf);
		f.add(clas);
		f.add(Class);
		f.add(flightnametf);
		f.add(flightname);
		f.add(header);
		f.add(destination);
		f.add(source);
		f.add(flightcodetf);
		f.add(flightcode);
		f.setLayout(null);
		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		cancel.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new AdminMainFrame(user);
						f.dispose();
					}
				});
		save.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String flight_code = flightcodetf.getText();
						String flight_name = flightnametf.getText();
						String source = (String) src.getSelectedItem();
						String destination = (String) destin.getSelectedItem();
						String Class = (String) clas.getSelectedItem();
						String amount = costtf.getText();
						
		                if (source.isEmpty() || destination.isEmpty() || source.equals(destination) || Class.isEmpty() || amount.isEmpty()|| flight_code.isEmpty() | flight_name.isEmpty()) 
		                {
		                    JOptionPane.showMessageDialog(null, "Please, check all fields and Submit!");
		                }
		                else
		                {
		                	String query = "INSERT INTO flight values( '"+flight_code+"', '"+flight_name+"', '"+source+"','"+destination+"', '" + Class + "', '"+ amount + "')";		                	
		                	try
		                	{
		                		Database conn = new Database();
		                		int rs = conn.stmt.executeUpdate(query);
		                		JOptionPane.showMessageDialog(f,"Flight Added Successfully");
		                	}
		                	catch(Exception ex)
		                	{
		                		System.out.println("Exception");
		                	}
		                }
						
						
						
					}
				});
		
		
	}	

	public static void main(String[] args) 
	{
	}

}
