package at.fhj.msd;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String test = "2 3 / 4 5 + +";
        double add = 0;

        String[] ctest = test.split(" ");
        double[] bof = new double[ctest.length];
        ArrayList<Double> addi = new ArrayList<>();

        for (int i = 0; i < ctest.length; i++) {

if (!(ctest[i].equals("+") && ctest[i-1].equals("+")))
{
    switch (ctest[i]) {
        case "+" -> {
            add = bof[i-2] + bof[i-1];
            addi.add(add);
        }
        case "-" -> {
            add = bof[i-2] - bof[i-1];
            addi.add(add);
        }
        case "*" -> {
            add = bof[i-2] * bof[i-1];
            addi.add(add);
        }
        case "/" -> {
            add = bof[i-2] / bof[i-1];
            addi.add(add);
        }
        default -> bof[i] = Double.parseDouble(ctest[i]);
    }
}
else{
    add = addi.get(0) + addi.get(1);
}
        }
        System.out.println(add);
        
    }

}
