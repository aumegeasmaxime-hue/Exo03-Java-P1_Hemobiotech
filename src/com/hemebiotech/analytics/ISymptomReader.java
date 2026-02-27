package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
/*
Tout élément permettant de lire des données de symptômes à partir d'une source
* L'élément important est la valeur de retour de l'opération, qui est une liste de chaînes de caractères,
* pouvant contenir de nombreux doublons
* L'implémentation n'a pas besoin de trier la liste
*/


public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */

	/*
	 * Si aucune donnée n'est disponible, retourne une liste vide.
	 *
	 * @retourne une liste brute de tous les symptômes obtenus à partir d'une source de données
	 * ; les doublons sont possibles/probables.
	 */
	List<String> GetSymptoms ();

	TreeMap<String,Integer> getSymptomCounts(List<String> symptoms);
}
