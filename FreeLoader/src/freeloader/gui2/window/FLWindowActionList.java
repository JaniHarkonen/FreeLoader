package freeloader.gui2.window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.robot.actions.FLRobotAction;

public class FLWindowActionList extends FLGUIComponent {
	
	public FLWindowActionList(FLGUIContext c) {
		super(c, false);
	}
	
	
	@Override
	public JPanel draw() {
		ArrayList<FLRobotAction> acts = (ArrayList<FLRobotAction>) context.get("actions");
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
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
		
		container.add(sp);
		
		//hostContext.guiContext.put("action-list-panel", wrapper);
		//hostContext.guiContext.put("action-list", this);
		return container;
	}
	
		// Performed upon clicking a list element
	private void onListElementClick(int index) {
		ArrayList<FLRobotAction> acts = (ArrayList<FLRobotAction>) context.get("actions");
		FLWindowSettingsWrapper sets = (FLWindowSettingsWrapper) context.get("settings-panel");
		sets.openAction(acts.get(index));
		/*FLRobotContext bot = hostContext.getSelectedRobot().getRobotContext();
		FLSettings sets = FLSettings.buildSettings(bot.actions.get(index), hostContext);
		
		hostContext.setSelectedActionSettings(sets);
		hostContext.guiContext.put("selected-action-index", index);*/
	}
}