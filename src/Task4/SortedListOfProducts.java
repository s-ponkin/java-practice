package Task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class SortedListOfProducts {

    public static void main(String[] args) {
        HashSet<Product> list = new HashSet<>();

        try {
            File file = new File("C:\\Users\\Сережа\\IdeaProjects\\JavaPractice\\src\\Task4\\ProductList.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null ){
                String[] arrLine = line.split(" - ");
                if(arrLine.length != 3){
                    System.out.println("Error");
                }

                Product product = new Product(arrLine[0],
                        Integer.parseInt(arrLine[1]),
                        Double.parseDouble(arrLine[2]));
                        list.add(product);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }

        list.stream().sorted().forEach(System.out::println);
    }
}
