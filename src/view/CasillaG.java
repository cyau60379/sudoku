package view;

import javax.swing.JButton;

public class CasillaG extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 116338867507125322L;
	private int id;
	private boolean defaultValue;

	public CasillaG(String name, int pId) {
		super(name);
		id = pId;
	}

	public void setValue(int pValue) {
		// TODO: implement
	}
	
	public void setDefaultValue(boolean pDefaultValue) {
		defaultValue = pDefaultValue;
	}
	
	public void select() {
		// TODO: implement
	}
	
	public void unselect() {
		// TODO: implement
	}
}
