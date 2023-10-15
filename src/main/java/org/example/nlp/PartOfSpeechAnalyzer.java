package org.example.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class PartOfSpeechAnalyzer {
    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            myReader.close();

            CoreDocument coreDocument = new CoreDocument(data);

            StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

            stanfordCoreNLP.annotate(coreDocument);

            List<CoreLabel> coreLabelList = coreDocument.tokens();






        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
