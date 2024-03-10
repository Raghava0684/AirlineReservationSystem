package airlines;

import java.sql.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookTicket extends JFrame
{
	JButton back;
	JComboBox src,dest,clas;
	String flight_amount,flight_code,flight_name;
	JLabel amt ,confirm;
	JTextField amttf,confirmtf;
	
	public BookTicket(String username,String password) 
	{
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setTitle("Book Ticket Frame");
		JLabel header = new JLabel("Book your Ticket");
		
		
		try 
		{
            BufferedImage originalImage = ImageIO.read(new File("\\Users\\Katroth Anil\\Downloads\\Airline4.jpg"));
            Image scaledImage = originalImage.getScaledInstance(1400, 1000, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            setContentPane(label);
        } 
		catch (IOException e) 
		{
			System.out.println("Photo Not Found");        
			
		}
		
		String source[] = {"select city","Telangana","Andhra Pradhesh","Arunachal Pradhesh","Goa","Tamil Nadu","Gujarath","Punjab","Rajasthan","Haryana","Madhya Pradhesh","Maharashtra","Delhi","Uttarakhand","Uttar Pradhesh","Kerala","Karnataka"};
		String destination[] = {"select city","Telangana","Andhra Pradhesh","Arunachal Pradhesh","Goa","Tamil Nadu","Gujarath","Punjab","Rajasthan","Haryana","Madhya Pradhesh","Maharashtra","Delhi","Uttarakhand","Uttar Pradhesh","Kerala","Karnataka"};
		String classes[] = {"select ","Business","Economy","Premium"};
		JLabel l1 = new JLabel("Source");
		JLabel l2 = new JLabel("Destination");
		JLabel l3 = new JLabel("Class");
		
		header.setBounds(85,20,400,40);
		header.setForeground(Color.white);
		header.setFont(new Font("Arial",Font.BOLD,35));
		add(header);
		l1.setBounds(20,100,130,30);
		l1.setFont(new Font("Arial",Font.BOLD,30));
		l1.setForeground(Color.white);
		l2.setBounds(20,170,180,30);
		l2.setFont(new Font("Arial",Font.BOLD,30));
		l2.setForeground(Color.white);
		l3.setBounds(20,240,100,30);
		l3.setForeground(Color.white);
		l3.setFont(new Font("Arial",Font.BOLD,30));
		src = new JComboBox(source);
		dest = new JComboBox(destination);
		clas = new JComboBox(classes);
		src.setBounds(200,100,250,30);
		src.setFont(new Font("Tohoma",Font.PLAIN,26));
		dest.setBounds(200,170,250,30);
		dest.setFont(new Font("Tohoma",Font.PLAIN,26));
		clas.setBounds(200,240,250,30);
		clas.setFont(new Font("Tohoma",Font.PLAIN,26));
		
		amt = new JLabel("Amount");
		amt.setBounds(20,300,300,30);
		amt.setForeground(Color.white);
		amt.setFont(new Font("Tohoma",Font.BOLD,26));
		add(amt);
		
		amttf = new JTextField();
		amttf.setFont(new Font("Tohoma",Font.PLAIN,26));
		amttf.setBounds(200,300,250,30);
		amttf.setText(flight_amount);
		add(amttf);
		
		confirm = new JLabel("Confirm Amount");
		confirm.setBounds(20,350,250,30);
		confirm.setForeground(Color.white);
		confirm.setFont(new Font("Tohoma",Font.BOLD,22));
		add(confirm);
		
		confirmtf = new JTextField();
		confirmtf.setBounds(200,350,250,30);
		confirmtf.setFont(new Font("Tohoma",Font.PLAIN,26));
		add(confirmtf);
		
		
		JButton amount = new JButton("Amount");
		amount.setBounds(40,480,180,40);
		amount.setForeground(Color.white);
		amount.setBackground(Color.black);
		amount.setFont(new Font("Tohoma",Font.PLAIN,28));
		add(amount);
		
		JButton book = new JButton("Book");
		book.setBounds(250,480,180,40);
		book.setForeground(Color.white);
		book.setBackground(Color.black);
		book.setFont(new Font("Tohoma",Font.PLAIN,28));
		back = new JButton("Back");
		back.setBounds(20,650,100,30);
		back.setForeground(Color.blue);
		back.setBackground(Color.yellow);
		
		add(back);
		add(book);
		add(src);
		add(dest);
		add(clas);
		add(l1);
		add(l2);
		add(l3);
		
		
		
		
		amount.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String source = (String) src.getSelectedItem();
						String destination = (String) dest.getSelectedItem();
						String Class = (String) clas.getSelectedItem();
						
						String query = "select *from flight where source = '"+source+"' and destination = '"+destination+"' and class = '"+Class+"' ";
						try
						{
							Database conn = new Database();
							ResultSet rs = conn.stmt.executeQuery(query);
							while(rs.next())
							{
								flight_code = rs.getString(1);
								flight_name = rs.getString(2);
								flight_amount = rs.getString(6);
								amttf.setText(flight_amount);
							}
							
							
						}
						catch(Exception ex)
						{
							System.out.println("Exception");
						}
					}
				});
		book.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						if(confirmtf.getText().isEmpty()) JOptionPane.showMessageDialog(null,"Enter amount correctly");
						else if(!confirmtf.getText().equals(amttf.getText())) JOptionPane.showMessageDialog(null,"Enter Full Amount \n as shown above"); 
						else 
						{
							
							String source = (String) src.getSelectedItem();
							String destination = (String) dest.getSelectedItem();
							String Class = (String) clas.getSelectedItem();
							String amount = amttf.getText();
							
							Date now = new Date();
			                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			                String date = sdf.format(now);
			                
			                LocalDateTime currentTime = LocalDateTime.now();
			                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			                String time = currentTime.format(formatter);
							
							String query = "insert into reservation(flightname,flightcode,username,source,destination,amount,time,date) values('"+flight_name+"', '"+flight_code+"', '"+username+"' , '"+source+"' , '"+destination+"', '"+amount+"', '"+time+"', '"+date+"' ) ";
							
							String query2 = "insert into payments(flightname,flightcode,username,source,destination,amount,time,date) values('"+flight_name+"', '"+flight_code+"','"+username+"' , '"+source+"' , '"+destination+"', '"+amount+"', '"+time+"', '"+date+"' ) ";
							try
							{
								Database conn = new Database();
								int rs = conn.stmt.executeUpdate(query);
								int rs2 = conn.stmt.executeUpdate(query2);
								if(rs == 1 && rs2 == 1) JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
							}
							catch(Exception ex)
							{
								System.out.println(ex);
								JOptionPane.showMessageDialog(null,"Error While Connecting to Database");
							}
							
						}
					}
				});
		
		setVisible(true);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new PassengerMainFrame(username,password);
				dispose();
			}
		});
		
	}

	public static void main(String[] args) 
	{
		//new BookTicket("","");
	}

}
