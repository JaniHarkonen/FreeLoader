package freeloader.gui.settings.keyboard;

/**
 * Container class for a keyboard key "identifier-tag" pair.
 * The identifier is the constant integer in KeyEvent used
 * to identify a keyboard key (such as KeyEvent.VK_UP) whereas
 * the tag is the name of the key to be displayed in, for 
 * example, a key selection drop-down menu. 
 * @author Joe
 *
 */
public class FLKeyTag {
	
	/**
	 * Key identifier (from KeyEvent).
	 */
	public int id;
	
	/**
	 * Key's name tag.
	 */
	public String tag;
	
	
	/**
	 * Constructs a blank pair with neither identifier nor tag. 
	 */
	public FLKeyTag() {
		this.id = -1;
		this.tag = "<no key>";
	}
	
	/**
	 * Constructs an identifier-tag pair with a given name tag and
	 * identifier.
	 * @param id Key's identifier (from KeyEvents).
	 * @param tag Name of the key.
	 */
	public FLKeyTag(int id, String tag) {
		this.id = id;
		this.tag = tag;
	}
}
