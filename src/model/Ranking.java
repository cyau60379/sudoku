package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Cuadricula.Cuadricula;

public class Ranking {
	private static Ranking ranking;
	private String path;
	private File fichero;
	private List<Map<String, String>> mapList;

	private Ranking() {
		path = Paths.get("src", "resources", "ranking.txt").toString();
		fichero = new File(path);
		crearFichero();
		lectorDeFichero();
		ordenarRanking(0);
	}

	public static Ranking getRanking() {
		if (ranking == null) {
			ranking = new Ranking();
			return ranking;
		}
		return ranking;
	}

	private void crearFichero() {
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	private void lectorDeFichero() {
		mapList = new ArrayList<Map<String, String>>();
		try {
			FileReader file = new FileReader(path);
			Scanner sc = new Scanner(file);
			List<String> atributos = Arrays.asList("idPartida", "nivel", "nombre", "puntos");
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] arr = linea.split(",");
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 0; i < atributos.size(); i++) {
					map.put(atributos.get(i), arr[i]);
				}
				mapList.add(map);
			}
			file.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	private void escritorDeFichero(String pMessage) {
		try {
			FileWriter file = new FileWriter(path, true);
			file.write(pMessage);
			file.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	private String cargarDatosRanking() {
		String idPartida = Cuadricula.getCuadricula().getIdPartida();
		int nivel = Cuadricula.getCuadricula().getNivel().getValor();
		String nombrePartida = Cuadricula.getCuadricula().getNombrePartida();
		float puntos = Cuadricula.getCuadricula().calcularPuntos();
		String st = idPartida + "," + nivel + "," + nombrePartida + "," + puntos;
		Logger.getLogger().write("End Game " + idPartida + " [Level:" + nivel + "]: [Points:" + puntos + "]\n");
		return st;
	}

	public List<Map<String, String>> ordenarRanking(int pNivel) {
		if (pNivel == 0) {
			mapList.sort(Comparator.comparing(m -> Float.valueOf(m.get("puntos"))));
			Collections.reverse(mapList);
			return mapList;
		}
		List<Map<String, String>> listaRanking = mapList.stream()
				.filter(p -> Integer.parseInt(p.get("nivel")) == pNivel).collect(Collectors.toList());
		listaRanking.sort(Comparator.comparing(m -> Float.valueOf(m.get("puntos"))));
		Collections.reverse(listaRanking);
		return listaRanking;
	}
	
	public void saveRanking() {
		escritorDeFichero(cargarDatosRanking() + "\n");
		lectorDeFichero(); // Update mapList
	}
}
