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
            //Read File Data
            //File found in Files directory
            //Look to "PartsOfSpeechExplained" to discover the meanings behind every part of speech, located in the resources/files folder of the project
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            myReader.close();

            //Use CoreDocument class to create object that uses coreNLP methods such as annotate the file

            CoreDocument coreDocument = new CoreDocument(data);

            StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

            stanfordCoreNLP.annotate(coreDocument);

            //CoreLabelList to tokenize words and analyze words in text

            List<CoreLabel> coreLabelList = coreDocument.tokens();

            for(CoreLabel coreLabel : coreLabelList){
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
