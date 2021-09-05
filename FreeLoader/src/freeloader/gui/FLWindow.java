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
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLActionMouseRelease;

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
		
		draw();
		
		MAIN_WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		MAIN_WINDOW.setVisible(true);
	}
	
	private FLRobot DEBUGgenerateRandomRobot() {
		Random rand = new Random();
		
		FLRobot bot = new FLRobot();
		bot.setName("Robot " + Math.abs(rand.nextInt() % 10));
		
		ArrayList<FLRobotAction> acts = new ArrayList<FLRobotAction>();
		FLActionMouseRelease act = new FLActionMouseRelease();
		act.updateDescription();
		acts.add(act);
		
		bot.setActions(acts);
		
		return bot;
	}
	
		// Creates tabs for all the available robots and adds
		// them to a given JTabbedPane
	/*private JPanel createRobotTabs() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JTabbedPane tp = new JTabbedPane();
		
		for( FLRobot bot : robotManager.getRobots() )
		tp.add(bot.getName(), createSingleRobotTab(bot));
		
		JPanel jp_btn = new JPanel();
		jp_btn.setLayout(new FlowLayout());
		JButton btn = new JButton("lol");
		JButton btn2 = new JButton("nother");
		//btn.setBounds(0,0,120,24);
		//btn.setVisible(true);
	
		jp_btn.add(btn);
		jp_btn.add(btn2);
		jp.add(jp_btn, BorderLayout.PAGE_START);
		jp.add(tp);
		//return tp;
		return jp;
	}*/
	
		// Creates a tab (JPanel) for a robot
	/*private JPanel createSingleRobotTab(FLRobot bot) {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
			// Robot actions - settings
		JPanel jp_setting = new JPanel();
		
			// Robot actions - actions
		ArrayList<FLRobotAction> actions = bot.getRobotContext().actions;
		int s = actions.size();
		String[] items = new String[s];
		
			// Get action descriptions
		for( int i = 0; i < s; i++ )
		items[i] = actions.get(i).getDescription();
		
		JList jl = new JList(items);
		jl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				
			}
		});
		JScrollPane scrp = new JScrollPane();
		scrp.setViewportView(jl);
		JPanel jp_list = new JPanel();
		jp_list.setLayout(new BorderLayout());
		jp_list.add(scrp);
		
		
			// Split view
		JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL);
		sp.add(jp_list, JSplitPane.LEFT);
		sp.add(jp_setting, JSplitPane.RIGHT);
		sp.setContinuousLayout(true);
		sp.setDividerLocation(400);
		jp.add(sp);
		
		return jp;
	}*/
	
		// Returns the RobotManager
	/*public FLRobotManager getRobotManager() {
		
	}*/
	
		// Draws the application window with 'redraw(false)'
	public void draw() {
		redraw(false);
	}
	
		// Redraws the application window
		// 're' determines whether to revalidate and repaint at the end
	public void redraw(boolean re) {
		
		if( re ) MAIN_WINDOW.getContentPane().removeAll();
		
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		FLElementToolbar tbar = new FLElementToolbar(applicationContext);
		FLElementTabs tabs = new FLElementTabs(applicationContext);
		container.add(tbar.getElement(), BorderLayout.PAGE_START);
		container.add(tabs.getElement());
		
		MAIN_WINDOW.add(container);
		
		if( re )
		{
			MAIN_WINDOW.revalidate();
			MAIN_WINDOW.repaint();
		}
	}
}
