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
	
		// Currently selected action index in the list
	private int actionIndex;
	
	
	public FLWindowActionList(FLGUIContext c) {
		super(c, false);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public JPanel draw() {
		actionIndex = -1;
		
		ArrayList<FLRobotAction> acts = (ArrayList<FLRobotAction>) context.get("actions");
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
		int s = acts.size();
		String[] dscrs = new String[s];
		for( int i = 0; i < s; i++ )
		dscrs[i] = acts.get(i).getDescription();
		
			// Create a list and handle clicks
		JList<String> list = new JList<String>(dscrs);
		list.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent evt) {
				onListElementClick(list.getSelectedIndex());
			}
		});
		
			// Insert into a scrollable pane
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(list);
		
		container.add(sp);
		return container;
	}
	
		// Performed upon clicking a list element
	@SuppressWarnings("unchecked")
	private void onListElementClick(int index) {
		ArrayList<FLRobotAction> acts = (ArrayList<FLRobotAction>) context.get("actions");
		
		if( index < 0 || index >= acts.size() ) return;
		
		FLWindowSettingsWrapper sets = ((FLWindowTab) context.get("host")).getSettingsPanel();
		sets.openAction(acts.get(index));
		
		actionIndex = index;
	}
		
		// Removes selected robot action from the currently open robot
	@SuppressWarnings("unchecked")
	public void removeAction() {
		ArrayList<FLRobotAction> acts = (ArrayList<FLRobotAction>) context.get("actions");
		
		if( acts.size() <= 0 || actionIndex < 0 ) return;
		
		acts.remove(actionIndex);
		
		((FLWindowTab) context.get("host")).render();
	}
	
		// Returns the index of currently selected action
	public int getActionIndex() {
		return actionIndex;
	}
}