package math;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI implements ActionListener {
	
	private int count = 0;
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	
	public GUI() {
		frame = new JFrame();
		
	    panel = new JPanel();
		
		button = new JButton("Click me");
		
		button.addActionListener(this);
		
		label = new JLabel("Number of clicks: 0");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Test GUI");
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new GUI();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
		
		
	}

}
