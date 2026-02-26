package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;    // initialize to 0
	private static int rashCount = 0;        // initialize to 0
	private static int pupilCount = 0;


	public static void main(String args[]) throws Exception {

		// first get input
		//BufferedReader est une classe qui permet de lire du texte
		//Elle est utilisée pour lire du texte à partir d’un flux de caractères (le fichier txt)
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		//convertion du text en String
		String line = reader.readLine();

		//int i = 0;	// set i to 0 // initialisation de i a 0 //ne sert a rien
		//int headCount = 0;	// counts headaches //compte les maux de tête //ne sert a rien
		while (line != null) {
			//i++;	// increment i
			//System.out.println("symptom from file: " + line);  // erreur possible n'affiche pas la bonne chose
			if (line.equals("headache")) {        //permet de compter et d'afficher en console "headache"
				headacheCount++;                                                                //erreur possible devrait increment "headacheCount"
				//System.out.println("number of headaches: " + headCount);					//pas de nessecité de faire un sout
			} else if (line.equals("rash")) {        //permet de compter "rush" // erreur faute de frappe possible "rash" au lieu de "rush"
				rashCount++;
			} else if (line.contains("dialated pupils")) {            //permet de compter "pupil" terme non present dans la list
				pupilCount++;
			}


			line = reader.readLine();    // get another symptom
		}


		// next generate output
		//FileWriter est une classe de Java qui permet d’écrire du texte dans un fichier.
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n"); // "\n" permet le retour a la ligne
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		//writer.close();

		findDifferentSymptom();

	}

	public static void findDifferentSymptom() throws IOException {
		ReadSymptomDataFromFile listAllSymptom = new ReadSymptomDataFromFile("symptoms.txt"); //instensiation classe pour acces a la methode getSymptom
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line;
		ArrayList<String> symptomList = new ArrayList<>();
		FileWriter writer = new FileWriter("result.out");
		Map<String , Integer> symptomListMap = new TreeMap<>();

		int count = 0;
		int temp = 0;
		/*
		while ((line = reader.readLine()) != null) {	//parcours du .txt
			if (!symptomList.contains(line)) {			//comparaison de la list pour eviter les doublons
				symptomList.add(line);					//ajout du nouveau symptom a la liste
			}
		}
		//reader.close();

		Collections.sort(symptomList); //permet d'ordonner un arreyList


		for(int i = 0;i < symptomList.size(); i++){		//permet iteration de la premiere liste et permet une boucle
			for(String symptom : listAllSymptom.GetSymptoms()) {			//permet iteration de la second list
				if (symptomList.get(i).equals(symptom)) {		//compare le 2 listes
					count++;									//compete le nombre d'element identique
				}
			}

			writer.write(symptomList.get(i) + " est present : " + (count-temp) + " fois dans le fichier txt" +"\n");
			temp = count;
		}
		writer.close();
		*/
		while ((line = reader.readLine()) != null) {
			symptomListMap.put(line ,symptomListMap.getOrDefault(line , 0)+1); //getOrDefault(line, 0)Si la clé existe → récupère la valeur Sinon → retourne 0

		}
		reader.close();
		writer.write(symptomListMap + "\n");
		writer.close();
		System.out.println(symptomListMap);
	}
}

