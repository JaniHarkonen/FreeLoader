package freeloader.gui2;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import freeloader.gui2.window.FLWindowTabs;
import freeloader.gui2.window.FLWindowToolbar;
import freeloader.robot.FLRobot;
import freeloader.robot.actions.FLActionExec;
import freeloader.robot.actions.FLActionWait;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.keyboard.FLActionKeyHold;
import freeloader.robot.actions.keyboard.FLActionKeyPress;
import freeloader.robot.actions.keyboard.FLActionKeyRelease;
import freeloader.robot.actions.mouse.FLActionMouseClick;
import freeloader.robot.actions.mouse.FLActionMouseHold;
import freeloader.robot.actions.mouse.FLActionMouseMove;
import freeloader.robot.actions.mouse.FLActionMouseRelease;
import freeloader.robot.actions.mouse.FLActionMouseScroll;

public class FLWindow extends FLGUIComponent {

	// Name of the application
	public static final String APP_NAME = "FreeLoader";
	
		// Version number
	public static final String APP_VERSION = "v0.1";
	
		// Default width of the window
	public static final int DEFAULT_WINDOW_WIDTH = 800;
	
		// Default height of the window
	public static final int DEFAULT_WINDOW_HEIGHT = 600;
	
		// Main window
	private static JFrame MAIN_WINDOW;

	
	public FLWindow() {
		super(null, true);
		render();
		
	}
	
	
	@Override
	public JPanel render() {
		MAIN_WINDOW = new JFrame(APP_NAME + " " + APP_VERSION);
		
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
			// Toolbar
		FLWindowToolbar tbar = new FLWindowToolbar(null);
		container.add(tbar.render(), BorderLayout.PAGE_START);
		
			// Tabs
		ArrayList<FLRobot> robots = new ArrayList<FLRobot>();
		int n_bots = (int) (Math.random() * 4.9999) + 1;
		for( int i = 0; i < n_bots; i++ ) robots.add(DEBUGgenerateRandomRobot());
		FLGUIContext ctxt = new FLGUIContext();
		ctxt.put("robots", robots);
		FLWindowTabs tabs = new FLWindowTabs(ctxt);
		container.add(tabs.render());
		
		MAIN_WINDOW.add(container);
		MAIN_WINDOW.setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		MAIN_WINDOW.setVisible(true);
		return null;
	}
	
	private FLRobot DEBUGgenerateRandomRobot() {
		FLRobot bot = new FLRobot();
		bot.setName("" + Math.random());
		int n_acts = (int) (Math.random() * 10.9999);
		
		for( int i = 0; i < n_acts; i++ )
		{
			FLRobotAction act;
			int act_ind = (int) (Math.random() * 9.99);
			
			switch( act_ind )
			{
				case 0: act = new FLActionMouseHold(); break;
				case 1: act = new FLActionMouseRelease(); break;
				case 2: act = new FLActionMouseMove(); break;
				case 3: act = new FLActionMouseClick(); break;
				case 4: act = new FLActionMouseScroll(); break;
				case 5: act = new FLActionKeyPress(); break;
				case 6: act = new FLActionKeyHold(); break;
				case 7: act = new FLActionKeyRelease(); break;
				case 8: act = new FLActionWait(); break;
				case 9: act = new FLActionExec(); break;
				
				default: act = new FLActionMouseHold(); break;
			}
			
			bot.getRobotContext().actions.add(act);
		}
		return bot;
	}
}
