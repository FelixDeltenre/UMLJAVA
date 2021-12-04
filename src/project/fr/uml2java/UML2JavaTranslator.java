package fr.uml2java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.*;

public class UML2JavaTranslator {
    private FileReader fileReader;
    private JSONObject jsonFile;
    private UMLProject project;
    private FileWriter fileWriter;

    public UML2JavaTranslator(String file) {
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getFile() throws IOException {
        StringBuilder parsable = new StringBuilder();
        int r;
        while ((r = fileReader.read()) != -1) {

            parsable.append((char) r);
        }
        System.out.println(parsable);
        jsonFile = new JSONObject(parsable.toString());
    }

    public void translate() {
        try {
            this.getFile();
            this.project = new UMLProject(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UMLProject getProject() {
        return project;
    }
}
