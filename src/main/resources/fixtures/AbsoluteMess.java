


public class HelloWorld {




    /** Multiline comment!*/

    public static         String loadString(String fileName)


    {
        StringBuilder sb = new StringBuilder();


        // single line comment
        try{


                                        BufferedReader br =

                                                new BufferedReader(new FileReader(fileName));
            try{
                String x;while ((x = br.readLine()) != null) {




                    sb.append(x);}

            } catch                                                                        (IOException e) {
                e.printStackTrace(); }
        } catch (FileNotFoundException




                e) {
                        System.out.println(e);
            e.printStackTrace();
        }
        return sb.toString();
    }
}




