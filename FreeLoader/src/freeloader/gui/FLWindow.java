package freeloader.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FLWindow {
	
	public static String APP_NAME = "FreeLoader";
	public static String APP_VERSION = "v0.1";
	
	public static int WINDOW_WIDTH = 800;
	public static int WINDOW_HEIGHT = 600;

	public FLWindow() {
		JFrame jf = new JFrame(APP_NAME + " " + APP_VERSION);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		jf.setVisible(true);
		jf.getContentPane().setLayout(new FlowLayout());
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JButton jb = new JButton("lol");
		jb.setBounds(0, 0, 100, 22);
		jf.add(jp);
		
		
		/*jp.revalidate();
		jp.repaint();*/
		
		/*JPanel jp = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				Graphics2D g2d = (Graphics2D) g;
				
			}
		};*/
		
		while( true ) {}
	}
}
