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
		JPanel jp_sets = new JPanel();
		jp_sets.setLayout(new BorderLayout());
		hostContext.setSelectedActionSettingsPanel(jp_sets);
		
		sp.add(al.getElement(), JSplitPane.LEFT);
		sp.add(jp_sets, JSplitPane.RIGHT);
		sp.setContinuousLayout(true);
		sp.setDividerLocation(250);
		
		wrapper.add(sp);
		return wrapper;
	}
}
