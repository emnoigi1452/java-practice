import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static final char trans = '&';

  public static String translate(char trans, String text) {
    /*
     * Note : I do not claim credit for the creation of this
     * Original code by md_5, i just copied how to translate it
     * Source : https://github.com/SpigotMC/BungeeCord/blob/master/chat/src/main/java/net/md_5/bungee/api/ChatColor.java
     * File's and other stuff is created by me
    */
    String ALT_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx";
    String COLOR_FORMAT = "\u00A7";
    char[] scan = text.toCharArray();
    for(int i = 0; i < scan.length; i++) {
      if(scan[i] == trans && ALT_CODES.indexOf(b[i+1]) != -1) {
        scan[i] = COLOR_FORMAT;
        scan[i+1] = Character.toLowerCase(scan[i+1]); 
      }
    }
    return new String(scan);
  }
  public static void main(String[] args) {
    File s = new File("lore.in");
    File t = new File("lore.out");
    if(!(s.exist())) {
      try {
        s.createNewFile();
        System.out.println("Restart!");
        System.exit(-1);
      } catch(IOException e) {
        e.printStackTrace();
      }
    } else if(!(t.exists())) {
      try {
        t.createNewFile();
        System.out.println("Restart!");
        System.exit(-1);
      } catch(IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        Scanner reader = new Scanner(s);
        FileWriter writer = new FileWriter(t);
        while(reader.hasNextLine()) {
          String p = reader.nextLine();
          writer.write(translate(trans, p));
        }
        writer.flush();
        writer.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
}
