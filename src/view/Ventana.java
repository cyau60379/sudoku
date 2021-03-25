package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Juego;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Ventana extends JFrame implements Observer {

	private static final long serialVersionUID = -3382002272291572371L;
	// private Juego modelo;
	private Controlador controlador;
	private JPanel contentPane;
	// Editor elements
	private JPanel editor;
	private JLabel lblCandidatos;
	private JTextField textField;
	private JLabel lblValor;
	private JSpinner valor;
	private JButton btnModificar;
	private JButton btnRestablecer;
	private JButton btnAyuda;
	private JButton btnComprobar;
	private JTextPane info;
	// Grid elements
	private JPanel cuadricula;
	private CasillaG currentCasilla;
	private List<CasillaG> listaCasillas = new ArrayList<CasillaG>();

	/**
	 * Create the frame.
	 */
	public Ventana() {
		initialize();
		Juego.getJuego().addObserver(this);
		update(null, null);
	}

	private void initialize() {
		setTitle("Sudoku");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getEditor(), BorderLayout.EAST);
		contentPane.add(getCuadricula(), BorderLayout.CENTER);
	}

	private JPanel getEditor() {
		if (editor == null) {
			editor = new JPanel();
			GroupLayout gl_panel = new GroupLayout(editor);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(7)
						.addComponent(getInfo(), GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(getLblCandidatos())
							.addComponent(getLblValor()))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnModificar())
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(getValor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getBtnRestablecer()))
								.addComponent(getTextField())))
						.addGap(19))
					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addGap(35)
						.addComponent(getBtnAyuda())
						.addGap(18)
						.addComponent(getBtnComprobar())
						.addContainerGap(27, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblCandidatos())
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblValor())
							.addComponent(getValor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtnRestablecer()))
						.addGap(18)
						.addComponent(getBtnModificar())
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtnAyuda())
							.addComponent(getBtnComprobar()))
						.addGap(18)
						.addComponent(getInfo(), GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addContainerGap())
			);
			editor.setLayout(gl_panel);
		}
		return editor;
	}

	private JLabel getLblCandidatos() {
		if (lblCandidatos == null) {
			lblCandidatos = new JLabel("Candidatos:");
		}
		return lblCandidatos;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblValor() {
		if (lblValor == null) {
			lblValor = new JLabel("Valor:");
		}
		return lblValor;
	}

	private JSpinner getValor() {
		if (valor == null) {
			valor = new JSpinner();
			valor.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		}
		return valor;
	}

	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(getControlador());
		}
		return btnModificar;
	}

	private JButton getBtnRestablecer() {
		if (btnRestablecer == null) {
			btnRestablecer = new JButton("Restablecer");
			btnRestablecer.addActionListener(getControlador());
		}
		return btnRestablecer;
	}

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("Ayuda");
			btnAyuda.addActionListener(getControlador());
		}
		return btnAyuda;
	}

	private JButton getBtnComprobar() {
		if (btnComprobar == null) {
			btnComprobar = new JButton("Comprobar");
			btnComprobar.addActionListener(getControlador());
		}
		return btnComprobar;
	}
	
	private JTextPane getInfo() {
		if (info == null) {
			info = new JTextPane();
			info.setEditable(false);
		
		}
		return info;
	}

	private JPanel getCuadricula() {
		if (cuadricula == null) {
			cuadricula = new JPanel();
			cuadricula.setLayout(new GridLayout(9, 9, 0, 0));
			for (int i = 0; i < 81; i++) {
				cuadricula.add(getBtnCasilla(i, 0));
			}
		}
		return cuadricula;
	}
	

	private JButton getBtnCasilla(int index, int value) {
		if (listaCasillas.size() <= index || listaCasillas.get(index) == null) {
			String sValue;
			if (value == 0) {
				sValue = "";
			} else {
				sValue = Integer.toString(value);
			}
			CasillaG c = new CasillaG(sValue, index);
			c.addActionListener(getControlador());
			listaCasillas.add(c);
		}
		return listaCasillas.get(index);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Map<Integer, Boolean> valorError = Juego.getJuego().getTieneError();
		listaCasillas.stream().forEach(p -> p.tieneError(valorError.get(p.getId())));
		
		Map<Integer, Integer> mapValores = Juego.getJuego().getPartida();
		listaCasillas.stream().forEach(p -> p.setValue(mapValores.get(p.getId())));
		

		Map<Integer, Boolean> mapDefaultValores = Juego.getJuego().getDefaultValues();
		listaCasillas.stream().forEach(p -> p.setDefaultValue(mapDefaultValores.get(p.getId())));
		
		String mensaje = Juego.getJuego().getMensaje();
		getInfo().setText(mensaje);
	}

	// Controller

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador implements ActionListener, ChangeListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof CasillaG) {
				CasillaG c = (CasillaG) e.getSource();
				if (c.getDefaultValue() == false) {
					if (currentCasilla != null) {
						currentCasilla.unselect();
					}
					currentCasilla = (CasillaG) e.getSource();
					currentCasilla.select();
				}
			} else {
				JButton b = (JButton) e.getSource();
				if (b.getText() == "Modificar") {
					try {
						Juego.getJuego().updateCasilla(currentCasilla.getId(), Integer.parseInt(valor.getValue().toString()));
					} catch (NullPointerException e2) {}
				} else if (b.getText() == "Restablecer") {
					try {
						Juego.getJuego().updateCasilla(currentCasilla.getId(), 0);
					} catch (NullPointerException e2) {}
				}
			}
		}

		public void stateChanged(ChangeEvent e) {
			// TODO: implementation needed
		}
	}
}
