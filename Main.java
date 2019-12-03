import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.stream.*; 
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    
    long startTime = System.currentTimeMillis();

    HashMap<String, PriorityQueue<Integer>> map = new HashMap();

    String[] paragraphs = readLineByLineJava8("para.txt").trim().toLowerCase().split("\n\n+");

    for(int paragraph = 0; paragraph < paragraphs.length; paragraph++) {
      String[] words = paragraphs[paragraph].split("[\\s+\n]");
      for(int j = 0; j < words.length; j++) {
        if(!map.containsKey(words[j])) {
          map.put(words[j], new PriorityQueue<Integer>());
          map.get(words[j]).add(paragraph + 1);
        } else if(!map.get(words[j]).contains(paragraph + 1)) {
          map.get(words[j]).add(paragraph + 1);
        }
      }
    }
    
    long searchTimeStart = System.currentTimeMillis();
    HashSet<String> printedWord = new HashSet<>();
    String[] words = readLineByLineJava8("word.txt").trim().toLowerCase().split("[\n\\s]+");
    System.out.println("\n\nTotal Paragraphs : " + paragraphs.length + "\nTotal Unique Words : " + map.size());
    System.out.println("\n\nResult for searched words are as follows : \n------------------------------------------\n");
    for(String word : words) {
      if(!printedWord.contains(word)) {
        printedWord.add(word);
        System.out.print(word + " : "); 
        PriorityQueue<Integer> temp = map.get(word);
        if(temp == null) {
          System.out.print("Not Found!\n\n");
          continue; 
        }
        for(int i = 0; i < temp.size() && i < 10; i++) {
          System.out.print(temp.remove() + ", ");
        } System.out.print("\b\b\n\n");
      }
    }
  
    System.out.println("Total execution time : " + (System.currentTimeMillis() - startTime)/1000.0 + "ms\nTotal search time through index : " + (System.currentTimeMillis() - searchTimeStart)/1000.0 + "ms.");
  }

  private static String readLineByLineJava8(String filePath) 
  {
    StringBuilder contentBuilder = new StringBuilder();
    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
    {
      stream.forEach(s -> contentBuilder.append(s).append("\n"));
    }
    catch (IOException e) {}
    return contentBuilder.toString();
  }
}