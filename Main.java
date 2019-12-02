import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {

    long start = System.currentTimeMillis();
    File file = new File("para.txt");
    Scanner sc = new Scanner(file);

    HashMap<String, PriorityQueue<Integer>> map = new HashMap();

    String line;
    int count = 0;

    while(sc.hasNextLine()) {
      line = sc.nextLine().toLowerCase();
      if(line.equals("")) {
        continue;
      }
      ++count;
      String[] tokens = line.split("[(\\s+)!?(),;:.]");
      // System.out.print("\nParagraph : "+ count + " Word Count : " + tokens.length + "\n");
      for(int j = 0; j < tokens.length; j++) {
        // System.out.print(tokens[j] + " ");
        if(!map.containsKey(tokens[j])) {
          map.put(tokens[j], new PriorityQueue<Integer>());
          map.get(tokens[j]).add(count);
        } else if(!map.get(tokens[j]).contains(count)) {
          map.get(tokens[j]).add(count);
        }
      }
      // System.out.println();
    }
    
    System.out.println("\n\nTotal Paragraphs : " + count + "\nTotal Unique Words : " + map.size());
    sc = new Scanner(new File("word.txt"));
    System.out.println("\n\nResult for searched words are as follows : \n------------------------------------------\n");
    while(sc.hasNext()) {
      line = sc.next().toLowerCase();
      // System.out.println(line + " : " + map.get(line) + "\n\n");
      //                          OR
      System.out.print(line + " : "); 
      PriorityQueue<Integer> temp = map.get(line);
      for(int i = 0; i < temp.size() && i < 10; i++) {
        System.out.print(temp.remove() + ", ");
      } System.out.print("\b\b\n\n");
    }
  
    System.out.println("Total execution time : " + (System.currentTimeMillis() - start)/1000.0 + "ms");
  }
}