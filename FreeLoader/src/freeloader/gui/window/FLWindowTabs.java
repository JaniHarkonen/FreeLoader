package freeloader.gui.window;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.robot.FLRobot;

public class FLWindowTabs extends FLGUIComponent {
	
		// The position of the robot in the robot list (also the tab index)
	private int selectedRobotIndex;
	
		// Reference to the currently open tab
	private FLWindowTab selectedRobotTab;
	

	public FLWindowTabs(FLGUIContext c) {
		super(c);
		selectedRobotIndex = 0;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public JPanel draw() {
		ArrayList<FLRobot> bots = (ArrayList<FLRobot>) context.get("robots");
		
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
		if( bots == null || bots.size() <= 0 ) return container;
		
			// Add tabs for all the robots
		JTabbedPane tp = new JTabbedPane();
		int s = bots.size();
		for( int i = 0; i < s; i++ )
		{
			FLRobot bot = bots.get(i);
			JPanel tab;
			
				// Only render the current tab
			if( i == selectedRobotIndex )
			{
				FLGUIContext ctxt_tab = new FLGUIContext();
				ctxt_tab.put("selected-robot", bot);
				selectedRobotTab = new FLWindowTab(ctxt_tab);
				tab = selectedRobotTab.render();
			}
			else tab = new JPanel();
			
			tp.add(bot.getName(), tab);
		}
		
		tp.setSelectedIndex(selectedRobotIndex);
		
			// Listen to changes in tabs
		tp.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				changeTab(tp.getSelectedIndex());
			}
		});
		
		container.add(tp);
		return container;
	}
	
		// Upon changing tabs
	private void changeTab(int ind) {
		selectedRobotIndex = ind;
		render();
	}
	
		// Adds a new robot
	@SuppressWarnings("unchecked")
	public void addRobot() {
		String name = (String) JOptionPane.showInputDialog("Enter robot name:");
		
		if( name == null || name.equals("") ) return;
		
		ArrayList<FLRobot> bots = (ArrayList<FLRobot>) context.get("robots");
		
		if( robotExists(name) ) return;
		
		FLRobot bot = new FLRobot();
		bot.setName(name);
		selectedRobotIndex = bots.size();
		bots.add(bot);
		render();
	}
	
		// Deletes currently open robot
	@SuppressWarnings("unchecked")
	public void deleteRobot() {
		((ArrayList<FLRobot>) context.get("robots")).remove(selectedRobotIndex);
		selectedRobotIndex = Math.max(0, selectedRobotIndex - 1);
		render();
	}
	
		// Opens up an action addition panel
	public void addAction() {
		selectedRobotTab.addAction();
	}
	
		// Removes selected robot action from the currently open robot
	public void removeAction() {
		selectedRobotTab.removeAction();
	}
	
	
		// Checks whether a robot with given name already exists
	@SuppressWarnings("unchecked")
	private boolean robotExists(String name) {
		if( name == null ) return false;
		
		for( FLRobot bot : (ArrayList<FLRobot>) context.get("robots") )
		if( bot.getName().equals(name) ) return true;
		
		return false;
	}
}