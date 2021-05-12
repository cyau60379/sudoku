package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Ranking {
	private static Ranking ranking;
	private File fichero=new File("Ranking.txt");
	private Map<String,String> rankingMap = new HashMap<String,String>(); 
	private List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
	
	private Ranking() {
		
		crearFichero();
		escritorDeFichero();
		lectorDeFichero();
		ordenarRanking("Normal");
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
	

	private void lectorDeFichero () {
		try {
			FileReader file = new FileReader("Ranking.txt");
			Scanner sc = new Scanner(file);
			List <String> atributos = Arrays.asList("idPartida","nivel","nombre","puntos");
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] arr = linea.split(",");
				Map<String,String>map = new HashMap<String,String>();
				for (int i = 0; i < atributos.size(); i++) {
					
                	 map.put(atributos.get(i), arr[i]);
                }
				
				mapList.add(map);
			}
			file.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	private void escritorDeFichero () {
		try {
			FileWriter file = new FileWriter("Ranking.txt", true);
			file.write(cargarDatosRanking()+"\n");
			file.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	private String cargarDatosRanking() {
		return Juego.getJuego().cargarDatosRanking();
	}

	public List<Map<String,String>> ordenarRanking(String nivel)
	{
		List<Map<String,String>> listaRanking=new ArrayList<>();
		mapList.sort(Comparator.comparing(
                m -> Float.valueOf(m.get("puntos"))));
		for (int i=mapList.size()-1;i>0;i--) {
			switch (nivel) {
			case "Todos los niveles":
				try {
					listaRanking.add(mapList.get(i));
				}catch(NullPointerException e2) {
					
				}break;
			case "Facil":
				try {
					if(mapList.get(i).get("nivel").equals("1")) {
						listaRanking.add(mapList.get(i));
					}
				}catch(NullPointerException e2) {
					
				}break;
			case "Normal":
				try {
					if(mapList.get(i).get("nivel").equals("2")) {
						listaRanking.add(mapList.get(i));
					}
				}catch(NullPointerException e2) {
					
				}break;
			case "Dificil":
				try {
					if(mapList.get(i).get("nivel").equals("3")) {
						listaRanking.add(mapList.get(i));
					}
				}catch(NullPointerException e2) {
					
				}break;
			}
		}
		return listaRanking;
	}
}
