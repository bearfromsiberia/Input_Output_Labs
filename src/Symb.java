import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Symb {
    public static void main(String[] args) throws IOException {
        FileReader f1in = new FileReader("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f1.txt");
        FileReader f2in = new FileReader("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f2.txt");
        FileReader f3in = new FileReader("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f3.txt");
        FileWriter f2out = new FileWriter("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f2.txt");
        FileWriter f3out = new FileWriter("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f3.txt");
        FileWriter f4out = new FileWriter("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f4.txt");
        int words = 0;
        int symb = 0;
        while (f1in.ready()){
            symb++;
            char ch = (char) f1in.read();
            if(ch == ' '){
                words++;
            }
            else if(ch == '\n'){
                words++;
                symb--;
                f2out.write(symb-1+"\n");
                f2out.flush();
                f3out.write(words+"\n");
                f3out.flush();
                words = 0;
                symb = 0;
            }
        }
        f2out.write(String.valueOf(symb));
        f2out.flush();
        f3out.write(String.valueOf(words+1));
        f3out.flush();
        char f2;
        char f3;
        FileReader f1oin = new FileReader("C:\\Users\\lomte\\IdeaProjects\\StreamFilters\\src\\f1.txt");
        while (f1oin.ready()){
            char ch = (char) f1oin.read();
            if(ch == '\n'){
                f4out.write(" ");
                while((f2 = (char) f2in.read()) != '\n'){
                    f4out.write(f2);
                }
                f4out.write(' ');
                while ((f3 = (char) f3in.read()) != '\n'){
                    f4out.write(f3);
                }
            }
            f4out.write(ch);
            f4out.flush();
        }
        f4out.write(" ");
        while(f2in.ready()){
            f4out.write(f2in.read());
            f4out.flush();
        }
        f4out.write(' ');
        while (f3in.ready()){
            f4out.write(f3in.read());
            f4out.flush();
        }
    }
}

