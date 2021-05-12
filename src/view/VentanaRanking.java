package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import model.Juego;
import model.Ranking;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VentanaRanking extends JFrame implements Observer {

	private static VentanaRanking ventanaRanking;
	private JPanel rankingPanel;
	private Controlador controlador;
	private JComboBox<String> filtro;
	private String nivel = "Todos los niveles";
	private JTextArea textArea;
	private JTextArea textArea2;
	private JButton btnFiltrar;

	private VentanaRanking() {
		Juego.getJuego().addObserver(this);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Ranking");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(933, 100, 454, 267);
		setVisible(true);
		inicializar();
		update(null, null);
	}

	public static VentanaRanking getVentanaRanking() {
		if (ventanaRanking == null) {
			ventanaRanking = new VentanaRanking();
			return ventanaRanking;
		} else {
			ventanaRanking.setVisible(true);
			return ventanaRanking;
		}

	}

	private void inicializar() {

		rankingPanel = new JPanel();
		rankingPanel.setBackground(Color.WHITE);

		getTextArea2().setBackground(Color.LIGHT_GRAY);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rankingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addComponent(getTextArea2(), GroupLayout.PREFERRED_SIZE, 351,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnFiltrar())))
						.addContainerGap(114, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(rankingPanel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(getTextArea2(), GroupLayout.PREFERRED_SIZE, 163,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(getBtnFiltrar()))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		getTextArea().setEditable(false);
		getTextArea().setText("Seleccion todos o un nivel en concreto:");
		rankingPanel.add(getTextArea());

		rankingPanel.add(getFiltro());
		getContentPane().setLayout(groupLayout);
	}

	private JButton getBtnFiltrar() {
		// TODO Auto-generated method stub
		if (btnFiltrar == null) {
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(getControlador());
			return btnFiltrar;
		}
		return btnFiltrar;
	}

	private JTextArea getTextArea() {
		// TODO Auto-generated method stub
		if (textArea == null) {
			textArea = new JTextArea();
			return textArea;
		}
		return textArea;
	}

	private JTextArea getTextArea2() {
		// TODO Auto-generated method stub
		if (textArea2 == null) {
			textArea2 = new JTextArea();
			textArea2.setEditable(false);
			return textArea2;
		}
		return textArea2;
	}

	private JComboBox<String> getFiltro() {
		if (filtro == null) {
			filtro = new JComboBox<>();
			filtro.addItem("Todos los niveles");
			filtro.addItem("Facil");
			filtro.addItem("Normal");
			filtro.addItem("Dificil");
		}
		return filtro;
	}

	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		cargarRanking();
		mostrarRanking();

	}

	public void cargarRanking() {
		Juego.getJuego().getRanking();
	}

	public void mostrarRanking() {
		List<Map<String, String>> list = Ranking.getRanking().ordenarRanking(nivel);
		String text = "";
		int j = 0;
		for (int i = 0; i < list.size(); i++) {
			if (j < 10) {
				text += list.get(i).toString() + "\n";
				j++;
			}

		}
		textArea2.setText(text);
	}

	private class Controlador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nivel = (String) filtro.getSelectedItem();
			mostrarRanking();
		}

	}
}
