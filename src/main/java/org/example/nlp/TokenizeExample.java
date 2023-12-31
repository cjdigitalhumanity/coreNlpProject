package org.example.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TokenizeExample {
    public static void main (String[] args){
        //Read File Data
        //File found in Files directory
        try {
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            myReader.close();
            //Get methods and objects from the pipeline

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        // String text = "Hello! This is batman's example";


            // Use CoreDocument class to create object that uses coreNLP methods such as annotate the file

            CoreDocument coreDocument = new CoreDocument(data);

        //Annotates Document for tokenization
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();

            for(CoreLabel coreLabel : coreLabelList){
                System.out.println(coreLabel.originalText());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
