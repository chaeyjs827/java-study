package javalearn.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndOfFile {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        int i = 1;
        while((input = br.readLine()) != null) {
            i++;
            System.out.println(i + " " + input);
        }

    }

}
