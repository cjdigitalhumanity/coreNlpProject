package org.example.nlp;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SentenceAnalyzer {
    public static void main(String[] args){
        try {
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            myReader.close();

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
       // String text = "This is a test for the sentences. Find Them all";

        CoreDocument coreDocument = new CoreDocument(data);

        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        int i = 0;

          for(CoreSentence sentence : sentences){
              i+=1;
              System.out.println("Sentence" + i + " " + ": " + sentence.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
