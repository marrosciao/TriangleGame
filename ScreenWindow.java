import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ScreenWindow implements WindowListener, Runnable{

	public static final Dimension SIZE = new Dimension(1600,1000);
	private Frame frame;
	public static String TITLE = "New Window";
	private boolean isRunning,isDone;
	private Image imgBuffer;
	
	public ScreenWindow(){
		frame = new Frame();
		frame.addWindowListener(this);
		
		frame.setSize(SIZE);
		frame.setTitle(TITLE);
		
		isRunning = true;
		isDone = false;
		frame.setVisible(true);
		imgBuffer = frame.createImage(SIZE.width, SIZE.height);
	}
	
	public void run(){
		while(isRunning){
			draw();
			
			try{
				Thread.sleep(50);
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
		}
		isDone = true;
	}
	
	
	public void draw(){
		Graphics2D g2 = (Graphics2D)imgBuffer.getGraphics();
		
		
		
		
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 0, SIZE.width, SIZE.height);
		
		
		
		g2 = (Graphics2D)frame.getGraphics();
		g2.drawImage(imgBuffer, 0, 0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
		g2.dispose();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		while(true){
			if(isDone){
				System.exit(0);
			}try{
				Thread.sleep(100);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		isRunning = false;
		frame.dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
