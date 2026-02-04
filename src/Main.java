import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src\\input.txt");
            PushbackReader pbReader = new PushbackReader(fileReader);
            StringBuilder sb = new StringBuilder();
            int c = pbReader.read();

            while(c != -1 && c != 65535) {
                if(Character.isLetter(c)) {

                    while(Character.isLetter(c)) {
                        sb.append((char) c);
                        c = pbReader.read();
                    }

                    System.out.println((char) c + " String buffer: " + sb.toString());
                    sb.delete(0, sb.length());
                } else if(Character.isDigit(c)) {

                    while(Character.isDigit(c)) {
                        sb.append((char) c);
                        c = pbReader.read();
                    }

                    System.out.println("  Number buffer: " + sb.toString());
                    sb.delete(0, sb.length());
                } else if (c == ':') {
                    sb.append((char) c);
                    System.out.println((char) c + " Colon buffer: " + sb.toString());
                    sb.delete(0, sb.length());
                    c = pbReader.read();
                } else if (c == ',') {
                    sb.append((char) c);
                    System.out.println((char) c + " Comma buffer: " + sb.toString());
                    sb.delete(0, sb.length());
                    c = pbReader.read();
                } else if (c == '"') {
                    sb.append((char) c);
                    System.out.println((char) c + " Double quote buffer: " + sb.toString());
                    sb.delete(0, sb.length());
                    c = pbReader.read();
                } else if (c == ' '){
                    sb.append((char) c);
                    System.out.println((char) c + " Space buffer: " + sb.toString());
                    sb.delete(0, sb.length());
                    c = pbReader.read();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}