package freeloader.gui.window;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
			System.out.println(bot.getName());
			tp.add(bot.getName(), new FLElementTab(hostContext).getElement());
		}
		
		wrapper.add(tp);
		return wrapper;
	}
}