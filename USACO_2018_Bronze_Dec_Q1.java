import java.util.*;
import java.io.*;

public class USACO_2018_Bronze_Dec_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        ArrayList<Integer> capacities = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            String line1 = br.readLine();
            StringTokenizer tok = new StringTokenizer(line1);

            capacities.add(Integer.parseInt(tok.nextToken()));
            amount.add(Integer.parseInt(tok.nextToken()));

        }
        br.close();


        for (int i = 0; i < 100; i++) {
            int bucket = i%3;
            int ogAmount = amount.get(bucket);
            int secondBucket = Math.min(ogAmount + amount.get((bucket+1)%3), capacities.get((bucket+1)%3));
            int difference =secondBucket -  amount.get((bucket+1)%3);
            amount.set( (bucket+1)%3,secondBucket);
            amount.set(bucket,ogAmount-difference);

        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        out.println(amount.get(0));
        out.println(amount.get(1));
        out.println(amount.get(2));
        out.close();

    }



}
