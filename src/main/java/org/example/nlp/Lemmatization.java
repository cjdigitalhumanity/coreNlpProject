package org.example.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Lemmatization {
    public static void main(String[] args){
        try {
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            myReader.close();

            StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

            // String text = "Damian, I will have been eating a steak";

            CoreDocument coreDocument = new CoreDocument(data);

            stanfordCoreNLP.annotate(coreDocument);

            List<CoreLabel> coreLabelList = coreDocument.tokens();

            for(CoreLabel coreLabel : coreLabelList){
                String lemma = coreLabel.lemma();

                System.out.println(coreLabel.originalText() + " = " + lemma);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
