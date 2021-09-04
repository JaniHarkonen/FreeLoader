package freeloader.gui.window;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import freeloader.gui.FLWindow;
import freeloader.robot.actions.FLRobotAction;

public class FLElementTab extends FLElement {
	
	public FLElementTab(FLWindow host) {
		super(host);
	}
	

	@Override
	public Component getElement() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(constructTab());
		
		return container;
	}
	
		// Constructs a tab
	private JSplitPane constructTab() {
		JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL);
		sp.add(addActionList(host.get))
		
		return sp;
	}
	
		// Returns a JPanel containing the list of robot actions
	private JPanel addActionList(ArrayList<FLRobotAction> acts) {
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BorderLayout());
		
			// Compile actions into a list of descriptions
		int s = acts.size();
		String[] dscr = new String[s];
		for( int i = 0; i < s; i++ )
		dscr[i] = acts.get(i).getDescription();
		
			// Assign click event to the elements
		JList list = new JList(dscr);
		list.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent evt) {
				actionElementClicked(list.getSelectedIndex());
			}
		});
		
			// Place into a scrollable element
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(list);
		
		wrapper.add(sp);
		return wrapper;
	}
	
		// Called upon clicking an action list element
	private void actionElementClicked(int index) {
		
	}
}
