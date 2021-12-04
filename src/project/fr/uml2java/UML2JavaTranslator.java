package fr.uml2java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class UML2JavaTranslator {
    private FileReader fileReader;
    private JSONObject jsonObject;
    private List<UMLObject> umlObjects = new ArrayList<>();

    public UML2JavaTranslator(String file) {
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getFile() throws IOException {
        String parsable = "";
        int r;
        while ((r = fileReader.read()) != -1) {

            parsable += (char) r;
        }
        System.out.println(parsable);
        jsonObject = new JSONObject(parsable);
    }

    public void translate() {
        try {
            getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
