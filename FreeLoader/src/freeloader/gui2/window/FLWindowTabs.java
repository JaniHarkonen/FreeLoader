package freeloader.gui2.window;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
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
		ArrayList<FLRobot> bots = (ArrayList<FLRobot>) context.get("robots");
		FLRobot bot = new FLRobot();
		bot.setName("test name");
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
}