package airlines;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;


public class PassengerDetails 
{
	JTable tb;
	
	public PassengerDetails(String user,String pass) 
	{
		JFrame f = new JFrame("Passenger Details");
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
		
		JLabel header = new JLabel("Your Information");
		header.setFont(new Font("Arial",Font.BOLD,35));
		header.setBounds(200,30,300,40);
		header.setForeground(Color.white);
		f.add(header);
		
		JLabel name = new JLabel("Name");
		name.setBounds(100,100,150,30);
		name.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField nametf = new JTextField();
		nametf.setBounds(300,100,300,30);
		nametf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel email = new JLabel("E-Mail");
		email.setBounds(100,150,150,30);
		email.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField emailtf = new JTextField();
		emailtf.setBounds(300,150,300,30);
		emailtf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel username = new JLabel("Username");
		username.setBounds(100,200,150,30);
		username.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField usernametf = new JTextField();
		usernametf.setBounds(300,200,300,30);
		usernametf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel password = new JLabel("Password");
		password.setBounds(100,250,150,30);
		password.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField passwordtf = new JTextField();
		passwordtf.setBounds(300,250,300,30);
		passwordtf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel passport = new JLabel("PassportNo");
		passport.setBounds(100,300,150,30);
		passport.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField passporttf = new JTextField();
		passporttf.setBounds(300,300,300,30);
		passporttf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(100,350,150,30);
		gender.setFont(new Font("Arial",Font.PLAIN,24));
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(300,350,100,30);
		male.setFont(new Font("Arial",Font.PLAIN,24));
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(450,350,150,30);
		female.setFont(new Font("Arial",Font.PLAIN,24));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		
		JLabel mobile = new JLabel("Mobile No");
		mobile.setBounds(100,400,150,30);
		mobile.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField mobiletf = new JTextField();
		mobiletf.setBounds(300,400,300,30);
		mobiletf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JButton back = new JButton("Back");
		back.setBounds(100,600,100,30);
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		f.add(back);
		
		f.add(nametf);
		f.add(name);
		f.add(email);
		f.add(emailtf);
		f.add(usernametf);
		f.add(username);
		f.add(passwordtf);
		f.add(password);
		f.add(passporttf);
		f.add(passport);
		f.add(female);
		f.add(male);
		f.add(gender);
		f.add(mobile);
		f.add(mobiletf);
		
		try
		{
			String query = "select *from passengers where name = '" + user + "' and password = '"+ pass + "'";
			
			Database conn = new Database();
			ResultSet rs = conn.stmt.executeQuery(query);
			
			while(rs.next())
			{
					String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7) };
					usernametf.setText(rs.getString(1));
					passwordtf.setText(rs.getString(2));
					nametf.setText(rs.getString(3));
					emailtf.setText(rs.getString(4));
					passporttf.setText(rs.getString(5));
					mobiletf.setText(rs.getString(7));
					String genders = rs.getString(6);
					if(genders.equals("Male")) male.setSelected(true); 
					else female.setSelected(true);
					
			}
			
			
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
				new PassengerMainFrame(user,pass);
				f.dispose();
			}
		});
	}

	public static void main(String[] args) 
	{
		//new PassengerDetails("","");
	}

}
