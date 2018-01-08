package guiMachine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton onButton;
	private JButton sixButton;
	private JButton eightButton;
	private JButton twelveButton;
	private JTextArea Display;
	private BorderLayout layout;
	private Container container;
	private JPanel speedButtons;
	private JComboBox<String> temperatureButton;
	private boolean on = false;
	private String tempSelected;
	
	public GUI(){
		super("Settings");
		String[] temperatures = {"30","45","60","75","90"};
		tempSelected = temperatures[0];
		layout = new BorderLayout();
		container = getContentPane();
		container.setLayout(layout);
		
		speedButtons = new JPanel();
		speedButtons.setLayout(new GridLayout(1,3));
		
		sixButton = new JButton("600 RPM");
		eightButton = new JButton("800 RPM");
		twelveButton = new JButton("1200 RPM");
		
		speedButtons.add(sixButton);
		speedButtons.add(eightButton);
		speedButtons.add(twelveButton);
		
		onButton = new JButton("ON");
		container.add(onButton, BorderLayout.EAST);
		
		Display = new JTextArea();
		Display.setEditable(false);
		Display.setText("Waiting\n");
		
		temperatureButton = new JComboBox<String>(temperatures);
		temperatureButton.setMaximumRowCount(temperatures.length);
		temperatureButton.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange() == ItemEvent.SELECTED) {
							if(on) {
								if(temperatureButton.getSelectedIndex() == 0) {
									Display.append("The temperature selected was " + temperatures[0] + " degrees.\n");
								} else if(temperatureButton.getSelectedIndex() == 1) {
									Display.append("The temperature selected was " + temperatures[1] + " degrees.\n");
								} else if(temperatureButton.getSelectedIndex() == 2) {
									Display.append("The temperature selected was " + temperatures[2] + " degrees.\n");
								} else if(temperatureButton.getSelectedIndex() == 3) {
									Display.append("The temperature selected was " + temperatures [3] + " degrees.\n");
								} else if(temperatureButton.getSelectedIndex() == 4) {
									Display.append("The temperature selected was " + temperatures[4] + " degrees.\n");
								} 
							} else {
								tempSelected = temperatures[temperatureButton.getSelectedIndex()];
							}
						}
					}
				});
		container.add(temperatureButton, BorderLayout.WEST);
		
		container.add(speedButtons, BorderLayout.SOUTH);
		container.add(Display, BorderLayout.CENTER);
		
		ButtonHandler handler = new ButtonHandler();
		onButton.addActionListener(handler);
		sixButton.addActionListener(handler);
		eightButton.addActionListener(handler);
		twelveButton.addActionListener(handler);
		
		setSize(400,200);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		GUI gui = new GUI();
	}
	
	private class ButtonHandler implements ActionListener { 
		public void actionPerformed( ActionEvent event )
		{
			
			if(event.getActionCommand().equals("ON")){
				if(!on) {
					Display.append("The on button was pressed.\n");
					Display.append("Temperature selected is " + tempSelected + " degrees.\n");
					System.out.println("The on button was pressed.");
					on = true;
				} else {
					Display.append("The washing machine is already on.\n");
				}
			} else if(event.getActionCommand().equals("600 RPM")){
				if(on) {
					Display.append("The 600 RPM button was pressed.\n");
					System.out.println("The 600 RPM button was pressed.");
				}
			} else if(event.getActionCommand().equals("800 RPM")){
				if(on) {
					Display.append("The 800 RPM button was pressed.\n");
					System.out.println("The 800 RPM button was pressed.");
				}
			} else if (event.getActionCommand().equals("1200 RPM")) {
				if(on) {
					Display.append("The 1200 RPM button was pressed.\n");
					System.out.println("The 1200 RPM button was pressed.");
				}
			}
			//Display.append("\nThe " + event.getActionCommand() + " button was pressed.");
		//	on = true;
		}
	}
}