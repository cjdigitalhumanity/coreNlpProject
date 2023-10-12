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


                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = "This is a test for the sentences. Find Them all";

                CoreDocument coreDocument = new CoreDocument(text);

                stanfordCoreNLP.annotate(coreDocument);

                List<CoreSentence> sentences = coreDocument.sentences();

                int i = 0;

                for(CoreSentence sentence : sentences) {
                    i += 1;
                    System.out.println("Sentence" + i + " " + ": " + sentence.toString());
                }
        }
    }
