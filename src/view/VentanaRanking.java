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

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VentanaRanking extends JFrame implements Observer {

	private JPanel rankingPanel;
	private Controlador controlador;
	private JComboBox<String> filtro;
	private String nivel = "Todos los niveles";
	private JTextArea textArea;
	private JTextArea textArea2;
	private JButton btnFiltrar;

	public VentanaRanking() {
		Juego.getJuego().addObserver(this);
		inicializar();
		update(null, null);
	}

	private void inicializar() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Ranking");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(933, 100, 454, 267);
		rankingPanel = new JPanel();
		rankingPanel.setBackground(Color.WHITE);

		getTextArea2().setBackground(Color.LIGHT_GRAY);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rankingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getBtnFiltrar()))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(getTextArea2(), GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(getBtnFiltrar(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rankingPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getTextArea2(), GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

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
		int pNivel = 0;
		switch(nivel) {
		case "Facil":
			pNivel = 1;
			break;
		case "Normal":
			pNivel = 2;
			break;
		case "Dificil":
			pNivel = 3;
			break;
		default:
			pNivel = 0;	
		}
		
		List<Map<String, String>> list = Juego.getJuego().getRanking(pNivel);
		if (list == null) {
			textArea2.setText("File Error: the ranking.txt file contains an error, please verify it");
		} else {
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
	}

	private class Controlador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nivel = (String) filtro.getSelectedItem();
			update(null, null);
		}

	}
}
