import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read the CSV file into a list of strings
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("CollectionLog.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Choose a random line from the list
        Random rand = new Random();
        int index = rand.nextInt(lines.size());
        String randomLine = lines.get(index);

        // Split the line into an array of strings, with each element representing an item
        String[] items = randomLine.split(";");

        // Create an array of items that should be considered for selection
        List<String> validItems = new ArrayList<>();
        for (String item : items) {
            if (!item.equals("Items") && !item.contains("edit_source") && !item.equals("[List]") &&!item.equals("N/A")) {
                validItems.add(item);
            }
        }

        // Choose a random item from the array of valid items
        int itemIndex = rand.nextInt(validItems.size());
        String randomItem = validItems.get(itemIndex);

        // Print the selected item
        System.out.println("Random item from CollectionLog.csv:");
        System.out.println(randomItem);
    }
}