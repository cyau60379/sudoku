package view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.SwingConstants;

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
		setBackground(getColor());
	}

	public void setDefaultValue(boolean pDefaultValue) {
		defaultValue = pDefaultValue;
		if (defaultValue) {
			setForeground(new Color(168, 168, 168));
			setRolloverEnabled(false);
		}
	}

	public void tieneError(boolean ptieneError) {
		if (ptieneError == true) {
			setForeground(Color.RED);
		} else {
			setForeground(Color.BLACK);
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
		setBackground(getColor());
		setEnabled(true);
	}

	private Color getColor() {
		int linea = id / 9;
		int columna = id % 9;
		int region = 3 * (linea / 3) + (columna / 3);
		Color color;
		if (region % 2 == 0) {
			color = new Color(242, 230, 255);
		} else {
			color = new Color(213, 202, 224);
		}
		return color;
	}
	public void setCandidatos (List<Integer> pCandidatos)
	{
		if (getText() == "") {
			String result = pCandidatos.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));
			this.setText(result);
            this.setFont(new Font("Tahoma", Font.PLAIN, 9));
            this.setVerticalAlignment(SwingConstants.TOP);
			
		}
		
	}
}
