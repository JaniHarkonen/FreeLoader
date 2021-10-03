package freeloader.gui.settings.keyboard;

import java.awt.event.KeyEvent;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.settings.FLSettings;
import freeloader.gui.sub.FLSubDropDownMenu;
import freeloader.robot.actions.keyboard.FLKeyboardKey;

public abstract class FLSettingsKeyboard extends FLSettings {
	
		// Contains key Identifier-Tag pairs
	public static final FLKeyTag[] keyTags = {
			new FLKeyTag(KeyEvent.VK_ENTER, 		"Enter"),
			new FLKeyTag(KeyEvent.VK_BACK_SPACE,	"Backspace"),
			new FLKeyTag(KeyEvent.VK_TAB, 			"Tab"),
			new FLKeyTag(KeyEvent.VK_CANCEL, 		"Cancel"),
			new FLKeyTag(KeyEvent.VK_CLEAR, 		"Clear"),
			new FLKeyTag(KeyEvent.VK_SHIFT, 		"Shift"),
			new FLKeyTag(KeyEvent.VK_CONTROL, 		"CTRL"),
			new FLKeyTag(KeyEvent.VK_ALT, 			"ALT"),
			new FLKeyTag(KeyEvent.VK_PAUSE, 		"Pause"),
			new FLKeyTag(KeyEvent.VK_CAPS_LOCK, 	"Caps lock"),
			new FLKeyTag(KeyEvent.VK_ESCAPE, 		"ESC"),
			new FLKeyTag(KeyEvent.VK_SPACE, 		"Space"),
			new FLKeyTag(KeyEvent.VK_PAGE_UP, 		"Page up"),
			new FLKeyTag(KeyEvent.VK_PAGE_DOWN, 	"Page down"),
			new FLKeyTag(KeyEvent.VK_END, 			"End"),
			new FLKeyTag(KeyEvent.VK_HOME, 			"Home"),
			
			new FLKeyTag(KeyEvent.VK_LEFT, 	"Left"),
			new FLKeyTag(KeyEvent.VK_UP, 	"Up"),
			new FLKeyTag(KeyEvent.VK_RIGHT, "Right"),
			new FLKeyTag(KeyEvent.VK_DOWN, 	"Down"),
			
			new FLKeyTag(KeyEvent.VK_COMMA,  ","),
			new FLKeyTag(KeyEvent.VK_MINUS,  "-"),
			new FLKeyTag(KeyEvent.VK_PERIOD, "."),
			new FLKeyTag(KeyEvent.VK_SLASH,  "/"),
			
			new FLKeyTag(KeyEvent.VK_0, "0"),
			new FLKeyTag(KeyEvent.VK_1, "1"),
			new FLKeyTag(KeyEvent.VK_2, "2"),
			new FLKeyTag(KeyEvent.VK_3, "3"),
			new FLKeyTag(KeyEvent.VK_4, "4"),
			new FLKeyTag(KeyEvent.VK_5, "5"),
			new FLKeyTag(KeyEvent.VK_6, "6"),
			new FLKeyTag(KeyEvent.VK_7, "7"),
			new FLKeyTag(KeyEvent.VK_8, "8"),
			new FLKeyTag(KeyEvent.VK_9, "9"),
				
				
			new FLKeyTag(KeyEvent.VK_SEMICOLON, ";"),
			new FLKeyTag(KeyEvent.VK_EQUALS, 	"="),
				
				
			new FLKeyTag(KeyEvent.VK_A, "A"),
			new FLKeyTag(KeyEvent.VK_B, "B"),
			new FLKeyTag(KeyEvent.VK_C, "C"),
			new FLKeyTag(KeyEvent.VK_D, "D"),
			new FLKeyTag(KeyEvent.VK_E, "E"),
			new FLKeyTag(KeyEvent.VK_F, "F"),
			new FLKeyTag(KeyEvent.VK_G, "G"),
			new FLKeyTag(KeyEvent.VK_H, "H"),
			new FLKeyTag(KeyEvent.VK_I, "I"),
			new FLKeyTag(KeyEvent.VK_J, "J"),
			new FLKeyTag(KeyEvent.VK_K, "K"),
			new FLKeyTag(KeyEvent.VK_L, "L"),
			new FLKeyTag(KeyEvent.VK_M, "M"),
			new FLKeyTag(KeyEvent.VK_N, "N"),
			new FLKeyTag(KeyEvent.VK_O, "O"),
			new FLKeyTag(KeyEvent.VK_P, "P"),
			new FLKeyTag(KeyEvent.VK_Q, "Q"),
			new FLKeyTag(KeyEvent.VK_R, "R"),
			new FLKeyTag(KeyEvent.VK_S, "S"),
			new FLKeyTag(KeyEvent.VK_T, "T"),
			new FLKeyTag(KeyEvent.VK_U, "U"),
			new FLKeyTag(KeyEvent.VK_V, "V"),
			new FLKeyTag(KeyEvent.VK_W, "W"),
			new FLKeyTag(KeyEvent.VK_X, "X"),
			new FLKeyTag(KeyEvent.VK_Y, "Y"),
			new FLKeyTag(KeyEvent.VK_Z, "Z"),
				
				
			new FLKeyTag(KeyEvent.VK_OPEN_BRACKET, 	"["),
			new FLKeyTag(KeyEvent.VK_BACK_SLASH, 	"\\"),
			new FLKeyTag(KeyEvent.VK_CLOSE_BRACKET, "]"),
				
				
			new FLKeyTag(KeyEvent.VK_NUMPAD0, "NUM0"),
			new FLKeyTag(KeyEvent.VK_NUMPAD1, "NUM1"),
			new FLKeyTag(KeyEvent.VK_NUMPAD2, "NUM2"),
			new FLKeyTag(KeyEvent.VK_NUMPAD3, "NUM3"),
			new FLKeyTag(KeyEvent.VK_NUMPAD4, "NUM4"),
			new FLKeyTag(KeyEvent.VK_NUMPAD5, "NUM5"),
			new FLKeyTag(KeyEvent.VK_NUMPAD6, "NUM6"),
			new FLKeyTag(KeyEvent.VK_NUMPAD7, "NUM7"),
			new FLKeyTag(KeyEvent.VK_NUMPAD8, "NUM8"),
			new FLKeyTag(KeyEvent.VK_NUMPAD9, "NUM9"),
			new FLKeyTag(KeyEvent.VK_MULTIPLY, "*"),
			new FLKeyTag(KeyEvent.VK_ADD, 	   "+"),
				
				
			new FLKeyTag(KeyEvent.VK_SEPARATER, 	"Separater"),
			new FLKeyTag(KeyEvent.VK_SUBTRACT, 		"-"),
			new FLKeyTag(KeyEvent.VK_DECIMAL, 		","),
			new FLKeyTag(KeyEvent.VK_DIVIDE, 		"/"),
			new FLKeyTag(KeyEvent.VK_DELETE, 		"Delete"),
			new FLKeyTag(KeyEvent.VK_NUM_LOCK, 		"Num lock"),
			new FLKeyTag(KeyEvent.VK_SCROLL_LOCK, 	"Scroll lock"),
				
				
			new FLKeyTag(KeyEvent.VK_F1,  "F1"),
			new FLKeyTag(KeyEvent.VK_F2,  "F2"),
			new FLKeyTag(KeyEvent.VK_F3,  "F3"),
			new FLKeyTag(KeyEvent.VK_F4,  "F4"),
			new FLKeyTag(KeyEvent.VK_F5,  "F5"),
			new FLKeyTag(KeyEvent.VK_F6,  "F6"),
			new FLKeyTag(KeyEvent.VK_F7,  "F7"),
			new FLKeyTag(KeyEvent.VK_F8,  "F8"),
			new FLKeyTag(KeyEvent.VK_F9,  "F9"),
			new FLKeyTag(KeyEvent.VK_F10, "F10"),
			new FLKeyTag(KeyEvent.VK_F11, "F11"),
			new FLKeyTag(KeyEvent.VK_F12, "F12"),
			new FLKeyTag(KeyEvent.VK_F13, "F13"),
			new FLKeyTag(KeyEvent.VK_F14, "F14"),
			new FLKeyTag(KeyEvent.VK_F15, "F15"),
			new FLKeyTag(KeyEvent.VK_F16, "F16"),
			new FLKeyTag(KeyEvent.VK_F17, "F17"),
			new FLKeyTag(KeyEvent.VK_F18, "F18"),
			new FLKeyTag(KeyEvent.VK_F19, "F19"),
			new FLKeyTag(KeyEvent.VK_F20, "F20"),
			new FLKeyTag(KeyEvent.VK_F21, "F21"),
			new FLKeyTag(KeyEvent.VK_F22, "F22"),
			new FLKeyTag(KeyEvent.VK_F23, "F23"),
			new FLKeyTag(KeyEvent.VK_F24, "F24"),
				
				
			new FLKeyTag(KeyEvent.VK_PRINTSCREEN, 	"Print screen"),
			new FLKeyTag(KeyEvent.VK_INSERT, 		"Insert"),
			new FLKeyTag(KeyEvent.VK_HELP, 			"Help"),
			new FLKeyTag(KeyEvent.VK_META, 			"Meta"),
			new FLKeyTag(KeyEvent.VK_BACK_QUOTE, 	"`"),
			new FLKeyTag(KeyEvent.VK_QUOTE, 		"´"),
				
				
			new FLKeyTag(KeyEvent.VK_KP_UP, 	"NUM UP"),
			new FLKeyTag(KeyEvent.VK_KP_DOWN, 	"NUM DOWN"),
			new FLKeyTag(KeyEvent.VK_KP_LEFT, 	"NUM LEFT"),
			new FLKeyTag(KeyEvent.VK_KP_RIGHT, 	"NUM RIGHT"),
				
				
			new FLKeyTag(KeyEvent.VK_DEAD_GRAVE, 			"`"),
			new FLKeyTag(KeyEvent.VK_DEAD_ACUTE, 			"´"),
			new FLKeyTag(KeyEvent.VK_DEAD_CIRCUMFLEX, 		"^"),
			new FLKeyTag(KeyEvent.VK_DEAD_TILDE, 			"~"),
			new FLKeyTag(KeyEvent.VK_DEAD_MACRON, 			"¯"),
			new FLKeyTag(KeyEvent.VK_DEAD_BREVE, 			"˘"),
			new FLKeyTag(KeyEvent.VK_DEAD_ABOVEDOT, 		"·"),
			new FLKeyTag(KeyEvent.VK_DEAD_DIAERESIS, 		"¨"),
			new FLKeyTag(KeyEvent.VK_DEAD_ABOVERING, 		"˚"),
			new FLKeyTag(KeyEvent.VK_DEAD_DOUBLEACUTE, 		"´´"),
			new FLKeyTag(KeyEvent.VK_DEAD_CARON, 			"̌"),
			new FLKeyTag(KeyEvent.VK_DEAD_CEDILLA, 			"¸"),
			new FLKeyTag(KeyEvent.VK_DEAD_OGONEK, 			"˛"),
			new FLKeyTag(KeyEvent.VK_DEAD_IOTA, 			"ι"),
			new FLKeyTag(KeyEvent.VK_DEAD_VOICED_SOUND, 	"̔"), 
			new FLKeyTag(KeyEvent.VK_DEAD_SEMIVOICED_SOUND, "᾿"),
				
				
			new FLKeyTag(KeyEvent.VK_AMPERSAND, 				"&"),
			new FLKeyTag(KeyEvent.VK_ASTERISK, 					"*"),
			new FLKeyTag(KeyEvent.VK_QUOTEDBL, 					"'"),
			new FLKeyTag(KeyEvent.VK_LESS, 						"<"),
			new FLKeyTag(KeyEvent.VK_GREATER, 					">"),
			new FLKeyTag(KeyEvent.VK_BRACELEFT, 				"{"),
			new FLKeyTag(KeyEvent.VK_BRACERIGHT, 				"}"),
			new FLKeyTag(KeyEvent.VK_AT, 						"@"),
			new FLKeyTag(KeyEvent.VK_COLON, 					":"),
			new FLKeyTag(KeyEvent.VK_CIRCUMFLEX, 				"^"),
			new FLKeyTag(KeyEvent.VK_DOLLAR, 					"$"),
			new FLKeyTag(KeyEvent.VK_EURO_SIGN, 				"€"),
			new FLKeyTag(KeyEvent.VK_EXCLAMATION_MARK, 			"!"),
			new FLKeyTag(KeyEvent.VK_INVERTED_EXCLAMATION_MARK, "¡"),
			new FLKeyTag(KeyEvent.VK_LEFT_PARENTHESIS, 			"("),
			new FLKeyTag(KeyEvent.VK_NUMBER_SIGN, 				"#"),
			new FLKeyTag(KeyEvent.VK_PLUS, 						"+"),
			new FLKeyTag(KeyEvent.VK_RIGHT_PARENTHESIS, 		")"),
			new FLKeyTag(KeyEvent.VK_UNDERSCORE, 				"_"),
			
			
			new FLKeyTag(KeyEvent.VK_WINDOWS, 		"Windows key"),
			new FLKeyTag(KeyEvent.VK_CONTEXT_MENU, 	"Context menu"),
			new FLKeyTag(KeyEvent.VK_FINAL, 		"Final"),
			new FLKeyTag(KeyEvent.VK_CONVERT, 		"Convert"),
			new FLKeyTag(KeyEvent.VK_NONCONVERT, 	"Non-convert"),
			new FLKeyTag(KeyEvent.VK_ACCEPT, 		"Accept"),
			new FLKeyTag(KeyEvent.VK_MODECHANGE, 	"Mode change"),
				

			new FLKeyTag(KeyEvent.VK_KANA, 				 "Kana"),
			new FLKeyTag(KeyEvent.VK_KANJI, 			 "Kanji"),
			new FLKeyTag(KeyEvent.VK_ALPHANUMERIC, 		 "Alphanumeric"),
			new FLKeyTag(KeyEvent.VK_KATAKANA, 			 "Katakana"),
			new FLKeyTag(KeyEvent.VK_HIRAGANA, 			 "Hiragana"),
			new FLKeyTag(KeyEvent.VK_FULL_WIDTH, 		 "Full width"),
			new FLKeyTag(KeyEvent.VK_HALF_WIDTH, 		 "Half width"),
			new FLKeyTag(KeyEvent.VK_ROMAN_CHARACTERS, 	 "Roman"),
			new FLKeyTag(KeyEvent.VK_ALL_CANDIDATES, 	 "All candidates"),
			new FLKeyTag(KeyEvent.VK_PREVIOUS_CANDIDATE, "Previous candidate"),
			new FLKeyTag(KeyEvent.VK_CODE_INPUT, 		 "Code input"),
			new FLKeyTag(KeyEvent.VK_JAPANESE_KATAKANA,  "Jp Katakana"),
			new FLKeyTag(KeyEvent.VK_JAPANESE_HIRAGANA,  "Jp Hiragana"),
			new FLKeyTag(KeyEvent.VK_JAPANESE_ROMAN, 	 "Jp Roman"),
			new FLKeyTag(KeyEvent.VK_KANA_LOCK, 		 "Kana lock"),
				
				
			new FLKeyTag(KeyEvent.VK_INPUT_METHOD_ON_OFF, "Input method ON/OFF"),
			
			
			new FLKeyTag(KeyEvent.VK_CUT, 		"Cut"),
			new FLKeyTag(KeyEvent.VK_COPY, 		"Copy"),
			new FLKeyTag(KeyEvent.VK_PASTE, 	"Paste"),
			new FLKeyTag(KeyEvent.VK_UNDO, 		"Undo"),
			new FLKeyTag(KeyEvent.VK_AGAIN, 	"Again"),
			new FLKeyTag(KeyEvent.VK_FIND, 		"Find"),
			new FLKeyTag(KeyEvent.VK_PROPS, 	"Props"),
			new FLKeyTag(KeyEvent.VK_STOP, 		"Stop"),
			new FLKeyTag(KeyEvent.VK_COMPOSE, 	"Compose"),
			new FLKeyTag(KeyEvent.VK_ALT_GRAPH, "Alt graph"),
			new FLKeyTag(KeyEvent.VK_BEGIN, 	"Begin")
	};
	

		// DROP-DOWN MENU - Keyboard key
	protected FLSubDropDownMenu ddKeyboardKey;
	
	
	protected FLSettingsKeyboard(FLGUIContext c) {
		super(c);
	}
	
	
		// UTILITY: Creates a drop-down menu containing the mouse buttons and automatically
		// stores it in 'ddMouseButton'
	protected void createKeyboardKeyMenu() {
		FLKeyboardKey act = (FLKeyboardKey) context.get("action");
		ddKeyboardKey = buildKeyboardKeyMenu(this);
		ddKeyboardKey.dropDownMenu.setSelectedIndex(getKeyTagIndexById(act.getKeyboardKey()));
	}
	
	
		// Finds the drop-down menu index of a key given its ID
	public static int getKeyTagIndexById(int id) {
		for( int i = 0; i < keyTags.length; i++ )
		if( keyTags[i].id == id ) return i;
		
		return -1;
	}
	
		// Builds a drop-down menu containing the mouse buttons and assigns it
		// to a given owner
	public static FLSubDropDownMenu buildKeyboardKeyMenu(FLGUIComponent o) {
		String[] ch = new String[keyTags.length];
		
		for( int i = 0; i < ch.length; i++ )
		ch[i] = keyTags[i].tag;
		
		return new FLSubDropDownMenu(o, "Keyboard key:  ", ch);
	}
	
	
	@Override
	public void updateAction() {
		FLKeyboardKey act = (FLKeyboardKey) context.get("action");
		int ind = ddKeyboardKey.dropDownMenu.getSelectedIndex();
		
		act.setKeyboardKey(keyTags[ind].id);
	}
}
