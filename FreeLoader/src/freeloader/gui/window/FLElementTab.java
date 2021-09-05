package freeloader.gui.window;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import freeloader.FLAppContext;

public class FLElementTab extends FLElement {
	
	public FLElementTab(FLAppContext host) {
		super(host);
	}
	

	@Override
	public Component getElement() {
		JPanel wrapper = createWrapper();
		
		JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL);
		FLElementActionList al = new FLElementActionList(hostContext);
		//FLSettings sets = hostContext.getSelectedActionSettings();
		JPanel sets = new JPanel();
		sets.setLayout(new BorderLayout());
		
		sp.add(al.getElement(), JSplitPane.LEFT);
		sp.add(sets, JSplitPane.RIGHT);
		sp.setContinuousLayout(true);
		sp.setDividerLocation(400);
		
		wrapper.add(sp);
		return wrapper;
	}
}
