package airlines;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DeletePassenger {

	public DeletePassenger(String user) 
	{
		
		JFrame f = new JFrame("Delete Passenger Frame");
		f.setLayout(null);
		
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
		
		JLabel header = new JLabel("Delete Passenger");
		header.setBounds(220,30,400,50);
		header.setForeground(Color.black);
		header.setFont(new Font("Tohoma",Font.BOLD,30));
		f.add(header);
		
		JLabel username = new JLabel("Username");
		username.setBounds(100,150,300,40);
		username.setFont(new Font("Arial",Font.PLAIN,30));
		username.setForeground(Color.blue);
		f.add(username);
		
		JTextField usertf = new JTextField();
		usertf.setBounds(280,150,300,40);
		usertf.setFont(new Font("Arial",Font.PLAIN,26));
		f.add(usertf);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(150,250,130,40);
		delete.setBackground(Color.red);
		delete.setFont(new Font("Arial",Font.PLAIN,22));
		delete.setForeground(Color.white);
		f.add(delete);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(380,250,130,40);
		cancel.setBackground(Color.cyan);
		cancel.setFont(new Font("Arial",Font.PLAIN,22));
		cancel.setForeground(Color.black);
		f.add(cancel);
		
		
		f.setVisible(true);
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		delete.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String user = usertf.getText();
						String query = "delete from passengers where username = '" + user + "'";
						try
						{
							Database conn = new Database();
							int rs = conn.stmt.executeUpdate(query);
							if(rs == 1) JOptionPane.showMessageDialog(f,"User Deleted Successfully!");
							else JOptionPane.showMessageDialog(f,"No User found with the entered Username!");
							
							
						}
						catch(Exception ex) {
							System.out.println("Exception");
						}
						
					}
				});
		
		cancel.addActionListener(new ActionListener()
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
		//new DeletePassenger("");
	}

}
