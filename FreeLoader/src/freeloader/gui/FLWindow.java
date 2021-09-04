package freeloader.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import freeloader.gui.window.FLElementToolbar;
import freeloader.robot.FLRobot;
import freeloader.robot.FLRobotManager;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLActionMouseClick;

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
	private FLRobotManager robotManager;
	
		// Currently open robot
	private FLRobot currentRobot;

	
	public FLWindow() {
		robotManager = new FLRobotManager();
		ArrayList<FLRobot> bots = new ArrayList<FLRobot>();
		FLRobot bot = new FLRobot();
		bots.add(bot);
		bot.setName("Robot 1");
		ArrayList<FLRobotAction> acts = new ArrayList<FLRobotAction>();
		FLActionMouseClick mc = new FLActionMouseClick();
		mc.updateDescription();
		acts.add(mc);
		bot.setActions(acts);
		bots.add(new FLRobot());
		bots.get(1).setName("Robot 2");
		robotManager.setRobots(bots);
		createMainWindow();
	}
	
	
		// Creates the main window
	private void createMainWindow() {
		JFrame f = new JFrame(APP_NAME + " " + APP_VERSION);
		JPanel cont = new JPanel();
		cont.setLayout(new BorderLayout());
		FLElementToolbar tb = new FLElementToolbar(this);
		cont.add(tb.getElement(), BorderLayout.PAGE_START);
	    //f.add(createRobotTabs());
		f.add(cont);
	    f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	    f.setVisible(true);
	}
	
		// Creates tabs for all the available robots and adds
		// them to a given JTabbedPane
	private JPanel createRobotTabs() {
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
	}
	
		// Creates a tab (JPanel) for a robot
	private JPanel createSingleRobotTab(FLRobot bot) {
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
	}
	
		// Returns the RobotManager
	public FLRobotManager getRobotManager() {
		
	}
}
