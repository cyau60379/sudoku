package view;

import java.awt.Color;

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
	
	public int getId() {
		return id;
	}

	public void setValue(int pValue) {
		setText(Integer.toString(pValue));
	}
	
	public void setDefaultValue(boolean pDefaultValue) {
		defaultValue = pDefaultValue;
		if (defaultValue) {
			setForeground(Color.MAGENTA);
		}
	}
	
	public void select() {
		// TODO: implement
	}
	
	public void unselect() {
		// TODO: implement
	}
}
