package fr.andromeda.fudro;

import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;

public class Meth {

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param nomHote String - Prend la valeur du nom de la machine de l'utilisateur
	 * @return String - Renvoie le nom de la machine utilisée
	 */

	public static String nomMachine (String nomMachine) {

		String nomHote ;

		try{
			InetAddress inetadr = InetAddress.getLocalHost();

			//Affiche le nom de la machine
			nomHote = (String) inetadr.getHostName();
			System.out.println("Nom de la machine : "+nomHote );

		} catch (UnknownHostException e){
			e.printStackTrace();
		}
		return nomMachine;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param adresseIPLocale String - Prend la valeur de l'adresse IP de la machinede l'utilisateur
	 * @return String - Retourne l'adresse IP de la machine utilisée
	 */

	public static String ipSearch (String ipSearch) {

		String adresseIPLocale ;

		try{
			InetAddress inetadr = InetAddress.getLocalHost();

			//Affiche l'adresse IP de la machine sur le réseau
			adresseIPLocale = (String) inetadr.getHostAddress();
			System.out.println("Adresse IP locale : "+adresseIPLocale );

		} catch (UnknownHostException e){
			e.printStackTrace();
		}
		return ipSearch;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param adrLocal InetAddress - Prend la valeur de l'adresse IP de la machine de l'utilisateur
	 * @param nomSite String - Permet l'affichage du site en clair de la recherche de l'utilisateur
	 * @param adrServers InetAddress[] - Permet d'afficher les adresse IP utilisés par le site recherché par l'utilisateur
	 * @return String - Retourne l'adresse IP de la machine utilisée ainsi que l'IP du site du choix de l'utilisateur
	 */

	@SuppressWarnings("resource")
	public static String addrWeb (String addrWeb) {
		Scanner sc = new Scanner (System.in);
		try {
			InetAddress adrLocale = InetAddress.getLocalHost(); 
			System.out.println("Adresse locale du PC = "+adrLocale.getHostAddress());
			System.out.println("Veuillez saisir le site à tester (www.exemple.com) : ");
			addrWeb = sc.next();
			String nomSite = addrWeb.substring(4, (addrWeb.length()-4));
			InetAddress[] adrServeurs = InetAddress.getAllByName(addrWeb);
			System.out.println("L'adresse de " + nomSite + " est : ");
			for (int i = 0; i < adrServeurs.length; i++) {
				System.out.println("     "+adrServeurs[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();	
		}
		return addrWeb;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd Process - Permet d'afficher l'execution de la commande traité
	 * @return String - Retourne l'association des extensions de fichiers avec la commande ASSOC de l'invite de commande Windows
	 */

	public static String assoc (String assoc) {
		Process cmd;
		try {
			cmd = Runtime.getRuntime().exec("cmd /c ASSOC");
			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			String line; 
			while((line = reader.readLine()) != null) { 
				System.out.println(line);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return assoc;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd Process - Permet d'afficher l'execution de la commande traité
	 * @return String - Retourne des Drivers de la machine avec la commande DRIVERSQUERY de l'invite de commande Windows
	 */

	public static String drivers (String drivers) {
		Process cmd;
		try {
			cmd = Runtime.getRuntime().exec("cmd /C DRIVERQUERY");

			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			while((drivers = reader.readLine()) != null) { 
				System.out.println(drivers);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return drivers;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd - Process Permet d'afficher l'execution de la commande traité
	 * @return String - Retourne la configuration IP de l'ordinateur avec la commande IPCONFIG de l'invite de commande Windows
	 */

	public static String ipConfig (String ipConfig) {
		Process cmd;
		try {
			cmd = Runtime.getRuntime().exec("cmd /C IPCONFIG /ALL");

			cmd.waitFor(); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			while((ipConfig = reader.readLine()) != null) { 
				System.out.println(ipConfig);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ipConfig;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd Process - Permet d'afficher l'execution de la commande traité
	 * @param ping String - Prends la valeur du site web choisi par l'utilisateur pour tester le ping
	 * @return String - Retourne un ping choisi par l'utilisateur avec la commande PING de l'invite de commande Windows
	 */

	public static String ping (String ping) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		Process cmd;
		try {
			System.out.println("Que voulez-vous pinguer ? (www.exemple.com) : ");
			ping = sc.next();
			cmd = Runtime.getRuntime().exec("cmd /C ping " + ping);
			cmd.waitFor(); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			while((ping = reader.readLine()) != null) { 
				System.out.println(ping);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ping;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd Process - Permet d'afficher l'execution de la commande traité
	 * @return String - Retourne les connexions actives avec la commande NETSTAT de l'invite de commande Windows
	 */

	public static String netStat (String netStat) {
		Process cmd;
		try {
			cmd = Runtime.getRuntime().exec("cmd /C NETSTAT -f -a");

			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			String line; 
			while((line = reader.readLine()) != null) { 
				System.out.println(line);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return netStat;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd Process - Permet d'afficher l'execution de la commande traité
	 * @return String - Retourne les informations systeme de la machine avec la commande SYSTEMINFO de l'invite de commande Windows
	 */

	public static String sysinfo (String sysinfo) {
		Process cmd;
		try {
			cmd = Runtime.getRuntime().exec("cmd /C SYSTEMINFO");

			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			String line; 
			while((line = reader.readLine()) != null) { 
				System.out.println(line);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sysinfo;
	}

	//JAVADOC
	/**
	 * @author ANDROMEDA
	 * @param cmd Process - Permet d'afficher l'execution de la commande traité
	 * @param route String - Permet à l'utilisateur de choisir le site web qu'il veut tester
	 * @return String - Retourne la route pour accéder au site web choisi par l'utilisateur avec la commande 
	 * TRACERT de l'invite de commande Windows
	 */

	public static String route (String route) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);		
		Process cmd;
		try {
			System.out.println("Quel site souhaitez-vous tester (www.exemple.com) : ");
			route = sc.next();
			cmd = Runtime.getRuntime().exec("cmd /C tracert " + route);

			BufferedReader reader=new BufferedReader(new InputStreamReader(
					cmd.getInputStream())); 
			String line; 
			while((line = reader.readLine()) != null) { 
				System.out.println(line);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return route;
	}
}