package memoryManger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class output extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					output frame = new output();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public output() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        
			int width=160;
			int x=200;
		System.out.println(Input.event1.memory.size());
		for(int j=0;j<Input.event1.memory.size();j++)
		{
	
			System.out.println(Input.event1.memory.get(j).start);
			
		}
		int y=16;
		
		for(int i=0;i<Input.event1.memory.size();i++)
		{
			int height =Input.event1.memory.get(i).size*10;
			 JLabel label_6 = new JLabel(Integer.toString(Input.event1.memory.get(i).start));
				label_6.setBounds(180, y, 80, 15);
				contentPane.add(label_6);
			if(Input.event1.memory.get(i).busy==false)
			{ 
				JButton btnNewButton0 = new JButton("");
				btnNewButton0.setBounds(x, y, width, height );
				btnNewButton0.setBackground(Color.black);
				contentPane.add(btnNewButton0);
			}
			else {
				String p=Input.event1.memory.get(i).processName;
				JButton btnNewButton1 = new JButton(Input.event1.memory.get(i).processName+" "+Input.event1.memory.get(i).segmentName);
				btnNewButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					 dispose();
					Input.event1.deallocateProcess(p);
						output f=new output();
						f.setVisible(true);
					}
				});
				btnNewButton1.setBounds(x, y, width, height);
				btnNewButton1.setBackground(Color.white);
				contentPane.add(btnNewButton1);
				
			}
			if(i==Input.event1.memory.size()-1)
			{
				 JLabel label_5 = new JLabel(Integer.toString(Input.event1.memory.get(i).end));
					label_5.setBounds(180, y+height-1, 80, 15);
					contentPane.add(label_5);
				
			}
			y=y+height;
		}
	}
}
