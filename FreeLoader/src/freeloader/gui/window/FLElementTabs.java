package freeloader.gui.window;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import freeloader.FLAppContext;
import freeloader.robot.FLRobot;

public class FLElementTabs extends FLElement {

	public FLElementTabs(FLAppContext host) {
		super(host);
	}
	
	
	@Override
	public Component getElement() {
		JPanel wrapper = createWrapper();
		
		JTabbedPane tp = new JTabbedPane();
		for( FLRobot bot : hostContext.getRobots() )
		{
			//System.out.println(bot.getName());
			tp.add(bot.getName(), new FLElementTab(hostContext, bot).getElement());
		}
		
		tp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hostContext.setSelectedRobot(hostContext.getRobots().get(tp.getSelectedIndex()));
				tp.getTabComponentAt(tp.getSelectedIndex());
				JPanel tab = (JPanel) hostContext.guiContext.get("open-tab-panel");
				if( tab == null ) return;
				
				tab.revalidate();
				tab.repaint();
			}
		});
		
		wrapper.add(tp);
		return wrapper;
	}
}