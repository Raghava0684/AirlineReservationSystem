package airlines;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PassengerLogin {
	JTextField usertf;
	public String usernames;
	public String passwords;
	JPasswordField passtf;
	public PassengerLogin() {
		JFrame f = new JFrame("PassengerLogin");
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline1.jpg"));
            
            Image scaledImage = originalImage.getScaledInstance(1500, 700, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
           System.out.println("Image NOt Found");
        }
		JLabel header = new JLabel("Passenger Login");
		header.setBounds(530,30,500,50);
		header.setForeground(Color.red);
		header.setFont(new Font("Arial", Font.PLAIN, 45));
		f.add(header);
		
		JLabel username = new JLabel("Username");
		username.setBounds(510,150,200,40);
		username.setFont(new Font("Arial", Font.PLAIN, 32));
		username.setForeground(Color.blue);
		
		usertf = new JTextField(20);
		usertf.setBounds(700,150,200,40);
		usertf.setFont(new Font("Arial",Font.PLAIN, 20));
		
		JLabel password = new JLabel("Password");
		password.setBounds(510,200,200,40);
		password.setFont(new Font("Arial", Font.PLAIN, 32));
		password.setForeground(Color.blue);
		
		passtf = new JPasswordField();
		passtf.setBounds(700,200,200,40);
		passtf.setFont(new Font("Arial",Font.PLAIN, 20));
		passtf.setEchoChar('*');
		
		JButton login = new JButton("Login");
		login.setForeground(Color.green);
		login.setBounds(510,280,150,40);
		login.setBackground(Color.red);
		login.setFont(new Font("Arial",Font.PLAIN,26));
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(Color.green);
		cancel.setBounds(750,280,150,40);
		cancel.setBackground(Color.red);
		cancel.setFont(new Font("Arial",Font.PLAIN,26));
		
		JLabel newuser = new JLabel("New User?");
		newuser.setBounds(510,400,300,40);
		newuser.setForeground(Color.magenta);
		newuser.setFont(new Font("Arial",Font.PLAIN,30));
		
		JButton signup = new JButton("Sign up");
		signup.setBounds(750,400,150,40);
		signup.setForeground(Color.green);
		signup.setBackground(Color.red);
		signup.setFont(new Font("Arial",Font.PLAIN,26));
		
		JButton back = new JButton("Back");
		back.setBounds(600,600,100,40);
		back.setFont(new Font("Arial",Font.PLAIN,22));
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		
		
		f.add(username);
		f.add(password);
		f.add(usertf);
		f.add(passtf);		
		f.add(login);
		f.add(cancel);
		f.add(newuser);
		f.add(signup);
		f.add(back);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		login.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        usernames = usertf.getText();
		        passwords = passtf.getText();
		        String query = "select *from passengers where name = '" + usernames + "' and password = '"+ passwords + "'";

		        try 
		        {
		        	Database conn = new Database();
		            ResultSet rs = conn.stmt.executeQuery(query);

		            if (rs.next()) 
		            {
		                new PassengerMainFrame(usernames,passwords);
		                f.dispose();
		            } 
		            else 
		            {
		                JOptionPane.showMessageDialog(f, "Invalid Login");
		            }
		        } 
		        catch (SQLException ex) 
		        {
		            JOptionPane.showMessageDialog(f, "Error connecting to database");
		        }
		    }
		});

		
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				f.setVisible(false);
			}
		});
		
		signup.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new PassengerSignup();
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

	public static void main(String[] args) {
			//new PassengerLogin();
	}

}
