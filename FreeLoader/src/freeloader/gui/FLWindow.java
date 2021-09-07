package freeloader.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.gui.window.FLElementTabs;
import freeloader.gui.window.FLElementToolbar;
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

public class FLWindow {
	
		// Name of the application
	public static String APP_NAME = "FreeLoader";
	
		// Version number
	public static String APP_VERSION = "v0.1";
	
		// Default width of the window
	public static int WINDOW_WIDTH = 800;
	
		// Default height of the window
	public static int WINDOW_HEIGHT = 600;
	
		// Manager for all the available robots
	private FLAppContext applicationContext;
	
		// Main window
	private static JFrame MAIN_WINDOW;

	
	public FLWindow() {
		applicationContext = new FLAppContext(this);
		
		ArrayList<FLRobot> bots = new ArrayList<FLRobot>();
		bots.add(DEBUGgenerateRandomRobot());
		bots.add(DEBUGgenerateRandomRobot());
		applicationContext.setRobots(bots);
		applicationContext.setSelectedRobot(bots.get(0));
		createMainWindow();
	}
	
	
		// Creates the main window
	private void createMainWindow() {
		MAIN_WINDOW = new JFrame(APP_NAME + " " + APP_VERSION);
		
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		FLElementToolbar tbar = new FLElementToolbar(applicationContext);
		FLElementTabs tabs = new FLElementTabs(applicationContext);
		container.add(tbar.getElement(), BorderLayout.PAGE_START);
		container.add(tabs.getElement());
		
		MAIN_WINDOW.add(container);
		
		MAIN_WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		MAIN_WINDOW.setVisible(true);
	}
	
	private FLRobot DEBUGgenerateRandomRobot() {
		Random rand = new Random();
		
		FLRobot bot = new FLRobot();
		bot.setName("Robot " + Math.abs(rand.nextInt() % 10));
		
		ArrayList<FLRobotAction> acts = new ArrayList<FLRobotAction>();
		FLActionMouseHold act = new FLActionMouseHold();
		FLActionMouseRelease act2 = new FLActionMouseRelease();
		FLActionMouseMove act3 = new FLActionMouseMove();
		FLActionMouseClick act4 = new FLActionMouseClick();
		FLActionMouseScroll act5 = new FLActionMouseScroll();
		FLActionKeyPress act6 = new FLActionKeyPress();
		FLActionKeyHold act7 = new FLActionKeyHold();
		FLActionKeyRelease act8 = new FLActionKeyRelease();
		FLActionWait act9 = new FLActionWait();
		FLActionExec act10 = new FLActionExec();
		act.updateDescription();
		act2.updateDescription();
		act4.updateDescription();
		act5.updateDescription();
		act6.updateDescription();
		act7.updateDescription();
		act8.updateDescription();
		act9.updateDescription();
		acts.add(act);
		acts.add(act2);
		acts.add(act3);
		acts.add(act4);
		acts.add(act5);
		acts.add(act6);
		acts.add(act7);
		acts.add(act8);
		acts.add(act9);
		acts.add(act10);
		
		bot.setActions(acts);
		
		return bot;
	}
}
