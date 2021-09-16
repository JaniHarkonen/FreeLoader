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
import freeloader.robot.FLRobot;
import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.FLRobotAction;

public class FLElementActionList extends FLElement {
	
		// Robot who's actions are listed here
	private FLRobot ownerRobot;
	

	private FLElementActionList(FLAppContext host) {
		super(host);
	}
	
	public FLElementActionList(FLAppContext host, FLRobot owner) {
		super(host);
		ownerRobot = owner;
	}
	
	
	@Override
	public Component getElement() {
		JPanel wrapper = createWrapper();
		
		ArrayList<FLRobotAction> acts = ownerRobot.getRobotContext().actions;
		int s = acts.size();
		String[] dscrs = new String[s];
		for( int i = 0; i < s; i++ )
		dscrs[i] = acts.get(i).getDescription();
		
			// Create a list and handle clicks
		JList list = new JList(dscrs);
		list.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent evt) {
				onListElementClick(list.getSelectedIndex());
			}
		});
		
			// Insert into a scrollable pane
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(list);
		
		wrapper.add(sp);
		
		hostContext.guiContext.put("action-list-panel", wrapper);
		hostContext.guiContext.put("action-list", this);
		return wrapper;
	}
	
		// Performed upon clicking a list element
	private void onListElementClick(int index) {
		FLRobotContext bot = hostContext.getSelectedRobot().getRobotContext();
		FLSettings sets = FLSettings.buildSettings(bot.actions.get(index), hostContext);
		
		hostContext.setSelectedActionSettings(sets);
		hostContext.guiContext.put("selected-action-index", index);
	}
}