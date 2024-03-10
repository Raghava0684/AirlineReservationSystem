package airlines;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.regex.*;


public class AdminLogin {

	public AdminLogin() 
	{
		JFrame f = new JFrame("Admin Login");
		
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
		JLabel header = new JLabel("Admin Login");
		header.setBounds(170,30,500,50);
		header.setForeground(Color.red);
		header.setFont(new Font("Arial", Font.PLAIN, 45));
		f.add(header);
		
		JLabel username = new JLabel("Username");
		username.setBounds(100,150,200,40);
		username.setFont(new Font("Arial", Font.PLAIN, 32));
		username.setForeground(Color.darkGray);
		
		JTextField usertf = new JTextField(20);
		usertf.setBounds(300,150,200,40);
		usertf.setFont(new Font("Arial",Font.PLAIN, 20));
		
		JLabel password = new JLabel("Password");
		password.setBounds(100,220,200,40);
		password.setFont(new Font("Arial", Font.PLAIN, 32));
		password.setForeground(Color.darkGray);
		
		JPasswordField passtf = new JPasswordField(20);
		passtf.setBounds(300,220,200,40);
		passtf.setFont(new Font("Arial",Font.PLAIN, 20));
		passtf.setEchoChar('*'); 

		
		JButton login = new JButton("Login");
		login.setForeground(Color.blue);
		login.setBounds(100,320,150,40);
		login.setBackground(Color.cyan);
		login.setFont(new Font("Arial",Font.PLAIN,26));
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(Color.blue);
		cancel.setBounds(350,320,150,40);
		cancel.setBackground(Color.cyan);
		cancel.setFont(new Font("Arial",Font.PLAIN,26));
		
		
		
		JButton back = new JButton("Back");
		back.setBounds(100,600,100,40);
		back.setFont(new Font("Arial",Font.PLAIN,22));
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		
		
		f.add(username);
		f.add(password);
		f.add(usertf);
		f.add(passtf);		
		f.add(login);
		f.add(cancel);
		f.add(back);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		login.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String username = usertf.getText();
						String password = passtf.getText();
						String str = "select * from admin where name = '" + username + "' and password = '" + password + "'";
						
						try
						{
							Database conn = new Database();
							ResultSet rs = conn.stmt.executeQuery(str);
							
							if(rs.next()) 
							{
								String user = usertf.getText();
								JOptionPane.showMessageDialog(f,"Login Successful!");
								new AdminMainFrame(user);
								f.dispose();
							}
							else JOptionPane.showMessageDialog(f,"Invalid Login");
							
						}
						catch(Exception ex)
						{
							System.out.println("Exception");
							System.out.println(ex);
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
		
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new LoginType();
			}
		});
		
		
	}

	public static void main(String[] args) 
	{
		new AdminLogin();
	}

}
