package org.example.nlp;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.util.Properties;

import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class SentimentAnalysis {
    public static void main(String[] args) {
        //read file data and create a data string
        try {
            File myObj = new File("C:\\Users\\cjdan\\OneDrive\\Documents\\testFile.txt");
            Scanner myReader = new Scanner(myObj);

                String data = myReader.nextLine();

            myReader.close();

            Properties props = new Properties();
            // set the list of annotators to run
            props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");
            // build pipeline
            StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(props);

           // String text = "Hello I am Richard Grayson, and im a great acrobat. I really hate talking to robots.";

            CoreDocument coreDocument = new CoreDocument(data);
            // annotate
            stanfordCoreNLP.annotate(coreDocument);

            List<CoreSentence> sentences = coreDocument.sentences();

            for (CoreSentence sentence : sentences) {
                String sentiment = sentence.sentiment();
                System.out.println(sentiment + " = " + sentence);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

