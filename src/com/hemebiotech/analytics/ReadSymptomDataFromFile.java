package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Simple brute force implementation */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/** @param filepath a full or partial path to file with symptom strings in it, one per line	 */

	/*@param filepath Chemin complet ou partiel vers un fichier contenant les chaînes de symptômes, une par ligne*/

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}//constructeur surcharger
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();		//
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// stream version
	/*
	@Override
	public TreeMap<String,Integer> getSymptomCounts(List<String> symptoms){
		if(symptoms == null){
			throw new IllegalArgumentException("the symptom list cannot be null");
		}
		return symptoms.stream()
				.collect(
						Collectors.groupingBy(
								Function.identity(),
								TreeMap::new,
								Collectors.summingInt(value -> 1)
						)
				);
	}
	*/

	//merge Version
	@Override
	public TreeMap<String,Integer> getSymptomCounts(List<String> symptoms){
		TreeMap<String,Integer> symptomsCount = new TreeMap<>();
		symptoms.forEach(
				s ->symptomsCount.merge(s,1,Integer::sum)
		);
		return  symptomsCount;
	}

}
