package spell_check;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SpellChecker {
    private HashSet<String> dictionary = new HashSet<String>();
    private TreeSet<String> miss_spelled_words = new TreeSet<String>();

    public SpellChecker() throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("dictionary.txt"));
        while (fileInput.hasNextLine()) {
            dictionary.add(fileInput.nextLine());
        }
        fileInput.close();
    }
        public void checkSpelling(String fileName) throws FileNotFoundException {
            System.out.println("======== Spell checking " + fileName + " =========");

            miss_spelled_words.clear();

            Scanner fileInput = new Scanner(new File(fileName));
            Scanner kbInput = new Scanner(System.in);

            int lineNumber = 1;
            boolean linePrint;

            while (fileInput.hasNextLine()) {
                //outdated
                //StringTokenizer st = new StringTokenizer(line, " \t,.;:-% '\"");

                String[] words = fileInput.nextLine().split(" +|\\p{Punct}");

                linePrint = true;

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    word = word.toLowerCase();

                    if (!Character.isLetter(word.charAt(0))) {
                        continue;
                    }

                    if (dictionary.contains(word) || miss_spelled_words.contains(word)) {
                        continue;
                    }
                    if (word.endsWith("s")) {
                        word = word.substring(0, word.length() - 1);
                        if (dictionary.contains(word) || miss_spelled_words.contains(word)) {
                            continue;
                        }
                    }
                    if (linePrint) {
                        System.out.println("Line Number: " + lineNumber);
                        linePrint = false;
                    }
                    System.out.println(word + " add to dictionary? y or n");
                    if (kbInput.nextLine().charAt(0) == 'y') {
                        dictionary.add(word);
                    } else {
                        miss_spelled_words.add(word);
                    }
                }

                lineNumber += 1;

            }
            fileInput.close();
        }
        public void dump_miss_spelled_words()
        {
            System.out.println("=======miss spelled words======");
            for(String word : miss_spelled_words) {
                System.out.println(word);
            }
        }


        public static void main (String[]args){

            try {
                SpellChecker spellChecker = new SpellChecker();

                for (int i = 0; i < args.length; i++) {
                    spellChecker.checkSpelling(args[i]);
                    spellChecker.dump_miss_spelled_words();
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

        }
    }

