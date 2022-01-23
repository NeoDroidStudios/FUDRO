package fr.andromeda.fudro;

import java.util.Scanner;

public class Menu{

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner (System.in);
		String line = null;
		int choix; // Permet le choix dans le menu
		String choixString; // Permet de sortir de la boucle de fin du programme

		//Affiche le logo

		Logo.AfficheLogo(line); //Appel de la méthode
		Thread.sleep(3000); //Permet d'attendre 3 secondes

		do {

			//Gestion du menu

			do {
				System.out.println("--------------------------");
				System.out.println("|--------  MENU  --------|");
				System.out.println("--------------------------");

				System.out.println();
				System.out.println("1 - IP Machine");
				System.out.println("2 - Adresse Serveur Web");
				System.out.println("3 - Association de fichiers");
				System.out.println("4 - Liste des Drivers");
				System.out.println("5 - Afficher la configuration IP");
				System.out.println("6 - Vérifier la latence et la connectivité");
				System.out.println("7 - Afficher les connexions actives");
				System.out.println("8 - Affiche les informations du systeme");
				System.out.println("9 - Faire un traceroute");
				System.out.println("10 - Crédit");

				System.out.println();

				System.out.println("~ Quel est votre choix : ");
				choix = sc.nextInt();

			}while(choix < 1 || choix > 10); //Sort quand le choix de l'utilisateur est compris entre 1 et 10

			//Gestion du choix de l'utilisateur

			switch(choix) {

			case 1: 
				//Appel de la class Meth contenant les méthodes nomMachine et ipSearch

				//Retourne l'affichage du nom de la machine
				Meth.nomMachine(line);

				//retourne l'affichage de l'adresse ip local de la machine
				Meth.ipSearch(line);

				break;

			case 2:
				//Appel de la class Meth contenant la méthode addrWeb

				//Affiche les informations IP du site choisi par l'utilisateur
				Meth.addrWeb(line);

				break;

			case 3:
				//Appel de la class Meth contenant la méthode assoc

				//Affiche les Association de fichiers
				Meth.assoc(line);
				break;

			case 4:
				//Appel de la class Meth contenant la méthode drivers

				//Affiche les drivers de la machine
				Meth.drivers(line);

				break;

			case 5:
				//Appel de la class Meth contenant la méthode ipConfig

				//Affiche la configuration IP de la machine de l'utilisateur
				Meth.ipConfig(line);

				break;

			case 6:
				//Appel de la class Meth contenant la méthode ping

				//Affiche le résultat d'un ping en fonction du site choisi par l'utilisateur
				Meth.ping(line);

				break;

			case 7:
				//Appel de la class Meth contenant la méthode netStat

				//Affiche les connexions actives sur la machine de l'utilisateur
				Meth.netStat(line);

				break;

			case 8:
				//Appel de la class Meth contenant la méthode sysinfo

				//Affiche les informations systèmes de la machine de l'utilisateur
				Meth.sysinfo(line);

				break;

			case 9:
				//Appel de la class Meth contenant la méthode route

				//Affiche la route permettant d'accéder au site choisi par l'utilisateur
				Meth.route(line);

				break;

			case 10:
				//Appel de la class Meth contenant la méthode credit

				//Affiche les crédits de ce programme
				Credit.credit(line);

				break;

			default:
				//Valeur par défaut en cas d'erreur
				System.out.println("Erreur");

				break;
			}

			System.out.println();
			System.out.println("~ Souhaitez-vous revenir au Menu (oui/non) : ");
			choixString = sc.next();

		}while(!"non".equals(choixString)); //boucle tant que la valeur est différent de non

		System.out.println("Merci d'avoir utilisé FUDRO");

		sc.close();
	}
}

//JAVADOC
/**
 * @author ANDROMEDA
 * @version 1.0
 * @param choix int - Permet à l'utilisateur de faire un choix dans la boucle du menu
 * @param choixString String - Permet de sortir de la dernière boucle et met donc fin au programme
 * @param line String - Permet l'éxécution des méthodes dans les différentes Class
 * @return Main - L'affichage des différentes méthodes en fonction du choix dans le menu
 */