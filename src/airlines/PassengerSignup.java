package airlines;

import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.*;

public class PassengerSignup {

	public PassengerSignup() 
	{
		JFrame f = new JFrame("Passenger SignUp");
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline4.jpg"));
            Image scaledImage = originalImage.getScaledInstance(1400, 700, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            f.setContentPane(label);
        } 
		catch (IOException e) 
		{
           System.out.println("Image NOt Found");
        }
		JLabel header = new JLabel("Register");
		header.setFont(new Font("Arial",Font.BOLD,40));
		header.setBounds(200,20,200,45);
		header.setForeground(Color.blue);
		
		JLabel name = new JLabel("Name");
		name.setBounds(100,100,150,30);
		name.setForeground(Color.white);
		name.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField nametf = new JTextField();
		nametf.setBounds(300,100,300,30);
		nametf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel email = new JLabel("E-Mail");
		email.setBounds(100,150,150,30);
		email.setForeground(Color.white);
		email.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField emailtf = new JTextField();
		emailtf.setBounds(300,150,300,30);
		emailtf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel username = new JLabel("Username");
		username.setBounds(100,200,150,30);
		username.setForeground(Color.white);
		username.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField usernametf = new JTextField();
		usernametf.setBounds(300,200,300,30);
		usernametf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel password = new JLabel("Password");
		password.setBounds(100,250,150,30);
		password.setForeground(Color.white);
		password.setFont(new Font("Arial",Font.PLAIN,24));
		
		JPasswordField passwordtf = new JPasswordField(20);
		passwordtf.setBounds(300,250,300,30);
		passwordtf.setFont(new Font("Arial",Font.PLAIN,22));
		passwordtf.setEchoChar('*');
		
		JLabel passport = new JLabel("PassportNo");
		passport.setBounds(100,300,150,30);
		passport.setForeground(Color.white);
		passport.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField passporttf = new JTextField();
		passporttf.setBounds(300,300,300,30);
		passporttf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(100,350,150,30);
		gender.setForeground(Color.white);
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
		mobile.setForeground(Color.white);
		mobile.setFont(new Font("Arial",Font.PLAIN,24));
		JTextField mobiletf = new JTextField();
		mobiletf.setBounds(300,400,300,30);
		mobiletf.setFont(new Font("Arial",Font.PLAIN,22));
		
		JButton save = new JButton("Save");
		save.setBounds(50,480,170,43);
		save.setFont(new Font("Arial",Font.PLAIN,28));
		save.setForeground(Color.green);
		save.setBackground(Color.red);
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(450,480,170,43);
		cancel.setFont(new Font("Arial",Font.PLAIN,28));
		cancel.setForeground(Color.green);
		cancel.setBackground(Color.red);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(250,480,170,43);
		reset.setFont(new Font("Arial",Font.PLAIN,28));
		reset.setForeground(Color.green);
		reset.setBackground(Color.red);
		
		JButton back = new JButton("Back");
		back.setBounds(50,650,100,40);
		back.setFont(new Font("Arial",Font.PLAIN,22));
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		
		f.add(header);
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
		f.add(save);
		f.add(cancel);
		f.add(back);
		f.add(reset);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cancel.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						f.setVisible(false);
					}
				});
		
		
		
		save.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String emailt = emailtf.getText();
					String namet = nametf.getText();
					String passwordt = passwordtf.getText();
					String passportt = passporttf.getText();
					String usertf = usernametf.getText();
					String mobilet = mobiletf.getText();
					if(emailt.isEmpty() || namet.isEmpty() || passwordt.isEmpty() || passportt.isEmpty() || usertf.isEmpty() || mobilet.isEmpty())
					{
						JOptionPane.showMessageDialog(f,"Please, Fill all the Fields Properly!");
					}
					String gender = "";
					if(!male.isSelected() && !female.isSelected()) JOptionPane.showMessageDialog(f,"Select your gender"); 
					if(male.isSelected()) gender = "Male";
					else if(female.isSelected()) gender = "Female";
					
					if(!isValidUsername(usertf)) JOptionPane.showMessageDialog(f,"InValid Username");
					else if(UserExistsOrNot(usertf)) JOptionPane.showMessageDialog(f,"This Username already exists \n Kindly choose another username");
					else if(!isValidateEmail(emailt)) JOptionPane.showMessageDialog(f, "InValid Email");
					else if(!isValidName(namet)) JOptionPane.showMessageDialog(f,"InValid Name"); 
					else if(!isValidPassword(passwordt)) JOptionPane.showMessageDialog(f,"Password Must Contain characters \n and digits of length atleast 8");
					else if(!isValidPassport(passportt)) JOptionPane.showMessageDialog(f,"Invalid Passport Number");
					else if(!isValidMobile(mobilet)) JOptionPane.showMessageDialog(f,"Invalid Mobile Number");
					
					
					
					
					else 
					{
						String query = "INSERT INTO passengers (username, password, name, email, passportno, gender, mobile) VALUES ('" + usertf + "', '" + passwordt + "', '" + namet + "', '" + emailt + "', '" + passportt + "', '" + gender + "', '" + mobilet + "')";

						try
						{
							Database conn = new Database();
							int rs = conn.stmt.executeUpdate(query);
							JOptionPane.showMessageDialog(f,"Registered Successfully");
							new PassengerLogin();
						}
						catch(Exception ex)
						{
							System.out.println("Exception");
							System.out.println(ex);
						}
					}
				}
			});
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				nametf.setText(null);
				emailtf.setText(null);
				usernametf.setText("");
				passwordtf.setText(null);
				passporttf.setText(null);
				mobiletf.setText(null);
				if(male.isSelected()) male.setSelected(false);
				else female.setSelected(false);
			}
		});
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new PassengerLogin();
			}
		});
	}
	public static boolean UserExistsOrNot(String username)
	{
		String query = "SELECT 1 FROM passengers WHERE username = '"+username+"' ";
		
		try{
			Database conn = new Database();
			ResultSet rs = conn.stmt.executeQuery(query);
			
			if(rs.next()) return true;
			else return false;
		}
		catch(Exception e)
		{	
			System.out.println("UserExists or Not exception");
		}
		
		return false;
	}
	public static boolean isValidateEmail(String email)
	{
		return email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}
	public static boolean isValidName(String name)
	{
		return name.matches("[a-zA-Z]+");
	}
	public static boolean isValidUsername(String name)
	{
		return name.matches("^[a-zA-Z]+\\d*$");
//		return name.matches("[a-zA-Z]+");
	}
	public static boolean isValidPassword(String password)
	{
		return password.matches("^(?=.*[a-zA-Z])(?=.*\\d).{8,}$");
	}
	public static boolean isValidPassport(String passport)
	{
		return passport.matches("^[A-Z]{2}\\d{7}$");
	}
	public static boolean isValidMobile(String mobile)
	{
		return mobile.matches("^\\d{10}$");
	}

	public static void main(String[] args) 
	{
		//new PassengerSignup();
	}

}
