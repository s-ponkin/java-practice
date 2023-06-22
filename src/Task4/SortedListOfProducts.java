package Task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


public class SortedListOfProducts {

    public static void main(String[] args) {
        Map<String, Product> list = new TreeMap<>();

        try {
            File file = new File("data/ProductList.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] arrLine = line.split(" - ");
                if (arrLine.length != 3) {
                    throw new Exception("Error while reading the file. Check the file structure.");
                }

                Product product = new Product(arrLine[0],
                        Integer.parseInt(arrLine[1]),
                        Double.parseDouble(arrLine[2]));
                if (list.containsKey(arrLine[0])) {
                    list.get(arrLine[0]).add(Integer.parseInt(arrLine[1]));
                } else {
                    list.put(arrLine[0], product);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<Product> sortedList = new ArrayList<Product>(list.values());
        sortedList.stream().sorted().forEach(System.out::println);
    }
}
