import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TestClock extends JFrame {
	
	
	public static void main(String[] args) {
		TestClock frame = new TestClock();
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 500);
	    frame.setVisible(true);
	    StillClock clock = new StillClock();
	    frame.add(clock, BorderLayout.CENTER);
	    clock.start();
	    
	    
	}
	
	
	
}

