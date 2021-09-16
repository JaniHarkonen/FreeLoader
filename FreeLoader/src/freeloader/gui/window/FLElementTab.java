package freeloader.gui.window;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import freeloader.FLAppContext;
import freeloader.robot.FLRobot;

public class FLElementTab extends FLElement {
	
		// Robot who's tab this is
	private FLRobot ownerRobot;
	
	
	private FLElementTab(FLAppContext host) {
		super(host);
	}
	
	public FLElementTab(FLAppContext host, FLRobot owner) {
		super(host);
		ownerRobot = owner;
	}
	

	@Override
	public Component getElement() {
		JPanel wrapper = createWrapper();
		
		JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL);
		FLElementActionList al = new FLElementActionList(hostContext, ownerRobot);
		
		JPanel jp_sets = new JPanel();
		jp_sets.setLayout(new BorderLayout());
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				saveSettings();
			}
		});
		
		hostContext.guiContext.put("open-settings-panel__" + ownerRobot.getName(), jp_sets);
		
		sp.add(al.getElement(), JSplitPane.LEFT);
		sp.add(jp_sets, JSplitPane.RIGHT);
		sp.setContinuousLayout(true);
		sp.setDividerLocation(250);
		
		wrapper.add(sp);
		hostContext.guiContext.put("open-tab-panel", sp);
		return wrapper;
	}
	
		// Upon clicking "Save" in the settings panel
	private void saveSettings() {
		
	}
}
