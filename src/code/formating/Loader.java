package code.formating;

import sun.misc.IOUtils;

import java.io.*;

public class Loader {

    public static String loadString(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try {
                String x;
                while ((x = br.readLine()) != null) {
                    sb.append(x);
                }
                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
            return "";
        }
    }
}
