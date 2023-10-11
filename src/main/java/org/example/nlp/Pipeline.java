package org.example.nlp;
    import  edu.stanford.nlp.pipeline.StanfordCoreNLP;

    import java.util.Properties;

public class Pipeline {
        private static Properties properties;
        private static String propertiesName = "tokenize, ssplit, pos, lemma, sentiment";
        private static StanfordCoreNLP stanfordCoreNLP;

        private Pipeline(){

        }

        static {
            properties = new Properties();
            properties.setProperty("annotaters", propertiesName);
        }
        public static StanfordCoreNLP getPipeline(){
            if(stanfordCoreNLP == null){
                stanfordCoreNLP = new StanfordCoreNLP(properties);
            }
            return stanfordCoreNLP;
        }

    }
