package reading_with_exceptions;

import java.io.*;
import java.util.Scanner;

public class ReadingWithExceptions {
    public static void process(String fileName) {
        Scanner in = null;
        PrintWriter out = null;
        String outputFileName;
        int numbers_to_read;
        int counter = 0;
        try {
            in = new Scanner(new FileInputStream(fileName));
            outputFileName = in.next();
            if(in.hasNextInt()){
                numbers_to_read = in.nextInt();
            } else {
                numbers_to_read = -1;
                in.next();
            }

            out = new PrintWriter(new FileOutputStream(outputFileName));

            while(in.hasNext() && (counter < numbers_to_read || numbers_to_read == -1)) {
                if(in.hasNextInt()) {
                    out.print(in.nextInt() + " ");
                    counter++;
                }else{
                    in.next();
                }
                if(counter%10==0) {
                    out.println();
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();

        }
    }

    public static void main(String[] args) {

        for(String file:args) {
            process(file);

        }
    }
}