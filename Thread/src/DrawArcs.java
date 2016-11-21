import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.*;


public class DrawArcs extends JFrame {
  public DrawArcs() {
    setTitle("DrawArcs");
    
  }


  /** Main method */
  public static void main(String[] args) {
    DrawArcs frame = new DrawArcs();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 300);
    frame.setVisible(true);
    ArcsPanel panel = new ArcsPanel();
    frame.add(panel);
    JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	panel.add(startButton);
	panel.add(stopButton);
	//Thread test = new Thread(panel);
	startButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	panel.setMyBoolean(true);
        	Thread test = new Thread(panel);
        	test.start();
        }
	  });
	  
	stopButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            panel.stop();
        }
	  });
  }
}

// The class for drawing arcs on a panel
class ArcsPanel extends JPanel implements Runnable{
	private boolean myBoolean; 
	private int arcOne =0, arcTwo = 90, arcThree = 180, arcFour = 270; 
	
	@Override
	
	protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

    int x = xCenter - radius;
    int y = yCenter - radius;

    g.fillArc(x, y, 2 * radius, 2 * radius, arcOne, 30);
    g.fillArc(x, y, 2 * radius, 2 * radius, arcTwo, 30);
    g.fillArc(x, y, 2 * radius, 2 * radius, arcThree, 30);
    g.fillArc(x, y, 2 * radius, 2 * radius, arcFour, 30);
  }
  
  public void changeArcs(){
	  arcOne += 45;
	  arcTwo += 45;
	  arcThree += 45;
	  arcFour += 45; 
	  repaint(); 
  }
  
  public void setMyBoolean(boolean input){
	  
	  myBoolean = input; 
  }
  
  @Override
  public void run(){
	  
	  while (myBoolean) {
	      try {
	        Thread.sleep(250);
	      } catch (InterruptedException e) {
	      }
	      changeArcs(); 
	  }
	  
  }
  
  public void stop(){
	  myBoolean = false; 
  }
  
}

