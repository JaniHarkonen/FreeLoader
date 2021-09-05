package freeloader.gui.window;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import freeloader.FLAppContext;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.FLRobotAction;

public class FLElementActionList extends FLElement {

	public FLElementActionList(FLAppContext host) {
		super(host);
	}
	
	
	@Override
	public Component getElement() {
		JPanel wrapper = createWrapper();
		
			// Get action descriptions for the currently open robot
		ArrayList<FLRobotAction> acts = hostContext.getSelectedRobot().getRobotContext().actions;
		int s = acts.size();
		String[] dscrs = new String[s];
		for( int i = 0; i < s; i++ )
		dscrs[i] = acts.get(i).getDescription();
		
			// Create a list and handle clicks
		JList list = new JList(dscrs);
		list.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent evt) {
				onListElementClick(list.getSelectedIndex());
			}
		});
		
			// Insert into a scrollable pane
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(list);
		
		wrapper.add(sp);
		return wrapper;
	}
	
		// Performed upon clicking a list element
	private void onListElementClick(int index) {
		FLRobotContext bot = hostContext.getSelectedRobot().getRobotContext();
		FLSettings sets = FLSettings.buildSettings(bot.actions.get(index), hostContext);
		
		hostContext.setSelectedActionSettings(sets);
	}
}