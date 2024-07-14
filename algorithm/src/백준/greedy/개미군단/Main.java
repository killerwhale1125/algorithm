package greedy.개미군단;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hp = Integer.parseInt(br.readLine());
        List<Ant> ants = new ArrayList<>();

        ants.add(new GeneralAnt("장군"));
        ants.add(new SolidAnt("병정"));
        ants.add(new NormalAnt("일"));

//        Collections.sort(ants);


    }
}
