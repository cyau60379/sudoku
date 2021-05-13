package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

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
	private JButton btnCandidatos;
	private JButton btnCalcularCandidatos;
	private JButton btnRanking;
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
		setBounds(100, 100, 833, 500);
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

			JButton btnCalcularCandidatos = new JButton("CalCandidatos");
			btnCalcularCandidatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			GroupLayout gl_panel = new GroupLayout(editor);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLblCandidatos())
									.addComponent(getLblValor()))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(getTextField(), GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getBtnCandidatos())
										.addGap(5))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(getValor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getBtnModificar())))
								.addGap(14))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(getBtnComprobar())
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(getBtnRestablecer()))
									.addComponent(getInfo(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(getBtnRanking())
								.addGap(18)
								.addComponent(getBtnAyuda())
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getBtnCalcularCandidatos())
								.addGap(15))))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblCandidatos())
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtnCandidatos()))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblValor())
							.addComponent(getValor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtnModificar()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtnComprobar())
							.addComponent(getBtnRestablecer()))
						.addGap(34)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtnAyuda())
							.addComponent(getBtnCalcularCandidatos())
							.addComponent(getBtnRanking()))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getInfo(), GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
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

	private JButton getBtnCandidatos() {
		if (btnCandidatos == null) {
			btnCandidatos = new JButton("Cambiar");
			btnCandidatos.addActionListener(getControlador());
		}
		return btnCandidatos;
	}
	
	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Ranking");
			btnRanking.addActionListener(getControlador());
		}
		return btnRanking;
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

	private JButton getBtnCalcularCandidatos() {
		if (btnCalcularCandidatos == null) {
			btnCalcularCandidatos = new JButton("CalCandidatos");
			btnCalcularCandidatos.addActionListener(getControlador());
		}
		return btnCalcularCandidatos;
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

		Map<Integer, Set<Integer>> candidatos = Juego.getJuego().getCandidatos();
		listaCasillas.stream().forEach(p -> p.setCandidatos(candidatos.get(p.getId())));

		List<Integer> lineas = Juego.getJuego().getLineasConError();
		listaCasillas.stream().filter(p -> lineas.contains(p.getId() / 9)).forEach(p -> p.setErrorField());

		List<Integer> columnas = Juego.getJuego().getColumnasConError();
		listaCasillas.stream().filter(p -> columnas.contains(p.getId() % 9)).forEach(p -> p.setErrorField());

		List<Integer> regiones = Juego.getJuego().getRegionesConError();
		listaCasillas.stream().filter(p -> regiones.contains(3 * (p.getId() / 27) + ((p.getId() % 9) / 3)))
				.forEach(p -> p.setErrorField());

		Map<Integer, Boolean> mapDefaultValores = Juego.getJuego().getDefaultValues();
		listaCasillas.stream().forEach(p -> p.setDefaultValue(mapDefaultValores.get(p.getId())));
	}

	// Controller

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private class Controlador implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() instanceof CasillaG) { // click on a square of the sudoku
				CasillaG c = (CasillaG) e.getSource();
				if (c.getDefaultValue() == false) { // do something if it is an editable square
					if (currentCasilla != null) {
						currentCasilla.unselect(); // unselect the previous square
					}
					currentCasilla = (CasillaG) e.getSource();
					currentCasilla.select();
					if (c.getText().length() != 1) { // change the candidate text with the one of the selected square
						getTextField().setText(c.getText());
					} else { // the selected square already have a value assigned
						getTextField().setText("");
					}
				}
			} else { // use one of the button of the edition part
				JButton b = (JButton) e.getSource();
				switch (b.getText()) {
				case "Modificar":
					try {
						Juego.getJuego().updateCasilla(currentCasilla.getId(),
								Integer.parseInt(valor.getValue().toString()));
						String mensaje = Juego.getJuego().getMensaje();
						getInfo().setText(mensaje);
						if (Juego.getJuego().isFinished()) {
							VentanaRanking.getVentanaRanking();
						}
					} catch (NullPointerException e2) {
					}
					break;
				case "CalCandidatos":
					try {
						Juego.getJuego().autoUpdateCandidatos(currentCasilla.getId());
					} catch (NullPointerException e2) {
					}
					break;
				case "Restablecer":
					try {
						Juego.getJuego().updateCasilla(currentCasilla.getId(), 0);
						Juego.getJuego().updateCandidatos(currentCasilla.getId(), new HashSet<>());
					} catch (NullPointerException e2) {
					}
					break;
				case "Comprobar":
					try {
						Juego.getJuego().comprobarSolucion();
						String mensaje = Juego.getJuego().getMensaje();
						getInfo().setText(mensaje);
						if (Juego.getJuego().isFinished()) {
							VentanaRanking.getVentanaRanking();
						}
					} catch (NullPointerException e2) {
						e2.printStackTrace();
					}
					break;
				case "Cambiar":
					try {
						Set<Integer> listaCandidatos = new HashSet<Integer>();
						String[] arr = getTextField().getText().split(",");

						for (String a : arr) {
							listaCandidatos.add(Integer.parseInt(a));
						}
						Juego.getJuego().updateCandidatos(currentCasilla.getId(), listaCandidatos);

					} catch (NumberFormatException | NullPointerException e2) {
					}
					break;
				case "Ayuda":
					try {
						getInfo().setText(Juego.getJuego().getAyuda());
						if (Juego.getJuego().isFinished()) {
							String mensaje = Juego.getJuego().getMensaje();
							getInfo().setText(mensaje);
							VentanaRanking.getVentanaRanking();
						}
					} catch (NullPointerException e2) {
					}
					break;
				case "Ranking":
					try {
						VentanaRanking.getVentanaRanking();
					} catch (NullPointerException e2) {
					}
				default:
					break;
				}
			}
		}
	}
}
