package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

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
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line;
		ArrayList<String> symptomList = new ArrayList<>();
		ArrayList<String> symptomListComplete = new ArrayList<>();
		FileWriter writer = new FileWriter("result.out");

		int count = 0;
		int temp = 0;

		while ((line = reader.readLine()) != null) { 	//parcours du .txt
			symptomListComplete.add(line);
			if (!symptomList.contains(line)) {			//comparaison de la list pour eviter les doublons
				symptomList.add(line);					//ajout du nouveau symptom a la liste
			}
		}
		reader.close();

		Collections.sort(symptomList);
		System.out.println(symptomList);
		System.out.println(symptomListComplete);

		for(int i = 0;i < symptomList.size(); i++){		//permet iteration de la premiere liste et permet une boucle
			for(String symptom : symptomListComplete) {			//permet iteration de la second list
				if (symptomList.get(i).equals(symptom)) {		//compare le 2 listes
					count++;									//compete le nombre d'element identique
				}
			}
			System.out.println(symptomList.get(i) + " " + (count-temp));
			writer.write(symptomList.get(i) + " est present : " + (count-temp) + " fois dans le fichier txt" +"\n");
			temp = count;
		}
		writer.close();
	}
}

