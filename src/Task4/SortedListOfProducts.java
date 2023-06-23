package Task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SortedListOfProducts {

    private static final Logger logger = Logger.getLogger(SortedListOfProducts.class.getName());

    public static void main(String[] args) {
        Map<String, Product> list = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/ProductList.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] arrLine = line.split(" - ");
                if (arrLine.length != 3) {
                    throw new FileStructuresException("Error while reading the file. Check the file structure.");
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

        } catch (IOException | FileStructuresException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        List<Product> sortedList = new ArrayList<>(list.values());
        sortedList.stream().sorted().forEach(System.out::println);
    }
}
