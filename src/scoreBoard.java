import sun.awt.windows.ThemeReader;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class scoreBoard {

    public static void save(List<String> topScores){
        try (BufferedWriter bfr=
                    new BufferedWriter(
                            new FileWriter("resources/topScores.txt"))) {
            for (String score : topScores) {

                bfr.write(score);
                bfr.newLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
