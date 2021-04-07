package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Juego;
import model.Nivel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaInicial extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8460844264000077330L;
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JLabel lblNombre;
	private JTextField nombre;
	private JLabel lblNivel;
	private JComboBox<Integer> nivel;
	private JButton btnJugar;
	private Controlador controlador;

	/**
	 * Create the frame.
	 */
	public VentanaInicial() {
		initialize();
		Juego.getJuego().addObserver(this);
		update(null, null);
	}

	private void initialize() {
		setTitle("Sudoku");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 237, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(getLblNivel()).addComponent(getLblNombre()))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(getComboBox(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(getTextNombre(), GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
								.addGap(15))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addGap(83)
										.addComponent(getBtnJugar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(75))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(78, Short.MAX_VALUE).addComponent(getLblBienvenido()).addGap(74)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(getLblBienvenido()).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(getLblNombre())
						.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getComboBox(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblNivel()))
				.addGap(20)
				.addComponent(getBtnJugar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("¡Bienvenido!");
		}
		return lblBienvenido;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
		}
		return lblNombre;
	}

	private JTextField getTextNombre() {
		if (nombre == null) {
			nombre = new JTextField();
			nombre.setColumns(10);
		}
		return nombre;
	}

	private JLabel getLblNivel() {
		if (lblNivel == null) {
			lblNivel = new JLabel("Nivel:");
		}
		return lblNivel;
	}

	private JComboBox<Integer> getComboBox() {
		if (nivel == null) {
			nivel = new JComboBox<>();
		}
		return nivel;
	}

	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.addActionListener(getControlador());
		}
		return btnJugar;
	}

	private void close() {
		this.dispose();
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
			Juego.getJuego().begin(getTextNombre().getText(), (int) getComboBox().getSelectedItem());
			close(); // closes the window--cannot be recovered
			Ventana ventana = new Ventana();
			ventana.setVisible(true);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		List<Integer> niveles = Juego.getJuego().getNiveles();
		niveles.stream().forEach(p -> getComboBox().addItem(p));
	}

}
