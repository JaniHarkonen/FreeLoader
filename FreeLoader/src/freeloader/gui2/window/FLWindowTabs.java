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
	

	public FLWindowTabs(FLGUIContext c) {
		super(c);
		selectedRobotIndex = 0;
	}
	
	
	@Override
	public JPanel draw() {
		ArrayList<FLRobot> bots = (ArrayList<FLRobot>) context.get("robots");
		
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
			// Add tabs for all the robots
		JTabbedPane tp = new JTabbedPane();
		int s = bots.size();
		for( int i = 0; i < s; i++ )
		{
			JPanel tab;
			
				// Only render the current tab
			if( i == selectedRobotIndex )
			tab = new JPanel();
			else tab = new JPanel();
			
			tp.add(bots.get(i).getName(), tab);
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
		System.out.println("change to: " + ind);
		selectedRobotIndex = ind;
		render();
	}
}