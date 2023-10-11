package org.example.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class POSExample {
    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            myReader.close();


            StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

           // String text = "Tim Said, Jason Should have lost poker";

            CoreDocument coreDocument = new CoreDocument(data);

            stanfordCoreNLP.annotate(coreDocument);

            List<CoreLabel> coreLabelList = coreDocument.tokens();

            for (CoreLabel coreLabel : coreLabelList) {
                String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println(coreLabel.originalText() + "  " + pos);
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
