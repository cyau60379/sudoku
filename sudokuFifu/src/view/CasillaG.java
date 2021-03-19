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
		if (pValue == 0) {
			setText("");
		} else {
			setText(Integer.toString(pValue));
		}
	}
	
	public void setDefaultValue(boolean pDefaultValue) {
		defaultValue = pDefaultValue;
		if (defaultValue) {
			setContentAreaFilled(false);
			setForeground(Color.MAGENTA);
			setRolloverEnabled(false);
		}
	}
	
	public boolean getDefaultValue() {
		return defaultValue;
	}
	
	public void select() {
		setBackground(new Color(196, 224, 255));
		setEnabled(false);
	}
	
	public void unselect() {
		setBackground(null);
		setEnabled(true);
	}
}
