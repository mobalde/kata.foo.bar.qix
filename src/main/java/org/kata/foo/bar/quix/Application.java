package org.kata.foo.bar.quix;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author mbalde
 * class main de test
 *
 */
public class Application 
{
	private static String regx = "[0-9]{1,}"; //expression regular
	private static final String[] LISTEDIVISEUR = {"3", "5", "7"};
	private static String resultat;
	private static String diviseursContaint;
	private static Scanner scanne;
	private static String dividende = "";
	
	/**
	 * Cette methode verifie si un nombre est divisible par 3, 5, 7
	 * @param dividende
	 * @param diviseur
	 * @return boolean
	 */
	public static boolean divisible(int dividende, int diviseur) {
		return dividende%diviseur == 0;
	}
	
	
	/**
	 * Cette methode construit le resultat 
	 * de la divisibilité
	 */
	private static void calculeDivisibilite() {
		int dividendes = Integer.parseInt(dividende);
		for(String diviseurs : LISTEDIVISEUR){
			int diviseur = Integer.parseInt(diviseurs);
			if("3".equals(diviseurs)) {
				resultat = divisible(dividendes, diviseur) ? "Foo" : resultat; // dividende
			}
			if("5".equals(diviseurs)) {
				resultat = divisible(dividendes, diviseur) ? resultat+="Bar" : resultat ; // dividende
			}
			if("7".equals(diviseurs)) {
				resultat = divisible(dividendes, diviseur) ? resultat+="Qix" : resultat ; // dividende
			}
		}
	}
	
	// calcule containts dividendes
	/**
	 * Cette methode construit le resultat 
	 * du nombre d'occurence des entiers 3, 5, 7
	 * et remplace 0 par une etoile *
	 * @param tabDividende tableau de la chaine entrée en parametre
	 */
	private static void containtsDiviseur(String... tabDividende) {
		if(resultat == "" && StringUtils.contains(dividende, "0")) {
			diviseursContaint = StringUtils.replace(dividende, "0", "*");
		} 
		if(diviseursContaint == ""){
			for(int i=0; i<tabDividende.length; i++) {
				if("0".equals(tabDividende[i])) {
					diviseursContaint+="*";
				}
				if("3".equals(tabDividende[i])) {
					diviseursContaint+="Foo";
				}
				if("5".equals(tabDividende[i])) {
					diviseursContaint+="Bar";
				}
				if("7".equals(tabDividende[i])) {
					diviseursContaint+="Qix";
				}
			}
		}
	}
	
	// methode compute
	public static void compute(String dividende) {
		String tabDividende[] = dividende.split("");
		resultat = "";
		diviseursContaint = "";
		calculeDivisibilite();
		containtsDiviseur(tabDividende);
		resultat = resultat.isEmpty() && diviseursContaint.isEmpty() ? dividende : resultat + diviseursContaint;
	}
	
	public static void main(String[] args) {
	
		System.out.println("Entrer le nombre: ");
		scanne = new Scanner(System.in);
		dividende = scanne.next();
		do {
			Pattern p = Pattern.compile(regx);
			Matcher m = p.matcher(dividende);
			boolean b = m.matches();
			if(b) {
				// Traitement 
				compute(dividende);
				System.out.println(dividende + " => "+resultat);
			} else {
				System.out.println(dividende + " => " + dividende);
			}
			
			System.out.println("Entrer le nombre ou -1 pour quitter: ");
			scanne = new Scanner(System.in);
			dividende = scanne.next();
			
		}while(!"-1".equals(dividende));
		
		System.out.println("!!!!! Merci pour votre visite");
		
	}
}
