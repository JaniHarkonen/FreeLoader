package freeloader.robot.actions.keyboard;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.values.FLInt;

public class FLActionType extends FLRobotAction {
	
		// Text to type
	private String text;
	
		// Whether to type characters one-by-one
	private boolean enableOneByOne;
	
		// Interval between characters (ms, one-by-one)
	private FLInt intervalCharacter;
	
		// Interval between words (ms)
	private FLInt intervalWord;
	

	public FLActionType() {
		super();
		
		description = "Type text";
		text = "";
		enableOneByOne = false;
		intervalCharacter = new FLInt(0);
		intervalWord = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		if( text.equals("") ) return;
		
		Robot bot = rc.getRobot();
		
		if( !enableOneByOne )
		{
				// Place the text into the clipboard
			StringSelection ss = new StringSelection(text);
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			cb.setContents(ss, ss);
			
				// Paste the text
			bot.keyPress(KeyEvent.VK_CONTROL);
			bot.keyPress(KeyEvent.VK_V);
			bot.keyRelease(KeyEvent.VK_CONTROL);
			bot.keyRelease(KeyEvent.VK_V);
		}
		else
		{
				// Types the text in by pressing each individual key
			// TO BE DONE :/
		}
	}
}
