package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;


public class LanguageManipulation {
  CollaboratorClass collab;

  public LanguageManipulation(CollaboratorClass collab){
    this.collab = collab;
  }

	// The strings are stored in property files under /resources
	// Each file corresponds to a Language
	// This method return the string associated with a key, e.g.,
	// translate("greeting", English) == "How are you?"
	// translate("greeting", Spanish) == "¿Cómo se encuentra?"
	//
	// See the smokeTest
	public String getText(String key, Language language) throws Exception {

		// Property filename
		String fileName = language.toString() + "-strings.properties";
    String text;

		// Load the property fileException
		// If the file does not exist, we raise an exception
		collab.loadFile(fileName);

		// Find the requested string
		text = collab.getString(key);

		// Non-existing key: case 1
		if(text == null && language == Language.English) { 
			throw new NonExistingKeyException();
		}

		// Non-existing key: case 2
		if(text == null && language != Language.English) { 
			text = "This Key does not exist or it has not been yet translated";
		}

		return text;
	}


}
