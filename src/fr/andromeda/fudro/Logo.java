package fr.andromeda.fudro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Logo {

	public static String AfficheLogo (String fileName) {

		System.out.println();

		fileName = "logoFudro.txt" ;
		
		String line = null;

		try
		{
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null)
			{
				System.out.println(line);
			}

			bufferedReader.close();
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file named '" + fileName + "'");
		}

		return fileName;
	}
}

//JAVADOC
/**
* @author ANDROMEDA
* @version 1.0
* @return String - Affichage du logo
*/