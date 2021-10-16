package freeloader.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import freeloader.gui.window.FLWindowTabs;
import freeloader.gui.window.FLWindowToolbar;
import freeloader.robot.FLRobot;

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
		
			// Tabs
		ArrayList<FLRobot> robots = new ArrayList<FLRobot>();
		
		FLGUIContext ctxt_tabs = new FLGUIContext();
		ctxt_tabs.put("robots", robots);
		
		FLWindowTabs tabs = new FLWindowTabs(ctxt_tabs);
		
			// Toolbar
		FLGUIContext ctxt_tbar = new FLGUIContext();
		ctxt_tbar.put("tabs-container", tabs);
		
		FLWindowToolbar tbar = new FLWindowToolbar(ctxt_tbar);
		container.add(tbar.render(), BorderLayout.PAGE_START);
		
		container.add(tabs.render());
		
		MAIN_WINDOW.add(container);
		MAIN_WINDOW.setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		MAIN_WINDOW.setVisible(true);
		return null;
	}
}
