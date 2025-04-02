package at.fhj.msd;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String test = "1 2 * 1 3 * * ";
        double add = 0;
        double addend = 0;

        String[] ctest = test.split(" ");
        double[] bof = new double[ctest.length];
        ArrayList<Double> addi = new ArrayList<>();
        String[] signs = {"+", "-", "*", "/"};
        int count = -1;

        for (int i = 0; i < ctest.length; i++) {

            if (!((ctest[i].contains(signs[0]) || ctest[i].contains(signs[1])
            || ctest[i].contains(signs[2]) || ctest[i].contains(signs[3]))

            && (ctest[i - 1].contains(signs[0]) || ctest[i - 1].contains(signs[1])
            || ctest[i - 1].contains(signs[2]) || ctest[i - 1].contains(signs[3]))))

            {
                switch (ctest[i]) {
                    case "+" -> {
                        add = bof[i-2] + bof[i-1];
                        addi.add(add);
                        ++count;
                    }
                    case "-" -> {
                        add = bof[i-2] - bof[i-1];
                        addi.add(add);
                        ++count;
                    }
                    case "*" -> {
                        add = bof[i-2] * bof[i-1];
                        addi.add(add);
                        ++count;
                    }
                    case "/" -> {
                        add = bof[i-2] / bof[i-1];
                        addi.add(add);
                        ++count;
                    }
                    default -> bof[i] = Double.parseDouble(ctest[i]);
                }
            }
            else if (ctest[i].equals("+"))
            {
                addend = addi.get(count-1) + addi.get(count);
            }
            else if (ctest[i].equals("-"))
            {
                addend = addi.get(count-1) - addi.get(count);
            }
            else if (ctest[i].equals("*"))
            {
                addend = addi.get(count-1) * addi.get(count);
            }
            else if (ctest[i].equals("/"))
            {
                addend = addi.get(count-1) / addi.get(count);
            }
                    }
                    
                    System.out.println(addend);
                }

            }
