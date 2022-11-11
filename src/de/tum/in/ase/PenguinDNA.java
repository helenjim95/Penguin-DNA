package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class PenguinDNA {
    public static boolean checkChains(String chain1, String chain2) {
        //TODO: Check if two chains can bind to eachother
//        The DNA of a penguin is made up of 4 nucleotides: Cytosine (C), Guanine (G), Adenine (A), and Thymine (T).
//        Adenine and Thymine will form a bond, same for Guanine and Cytosine
        boolean isBond = true;
        for (int i = 0; i < chain1.length(); i++) {
            String nucleotide_one = String.valueOf(chain1.charAt(i));
            String nucleotide_two = String.valueOf(chain1.charAt(i));
            switch (nucleotide_one) {
                case "C":
                    if (!nucleotide_two.equals("G")) {
                        isBond = false;
                        break;
                    }
                    break;
                case "G":
                    if (!nucleotide_two.equals("C")) {
                        isBond = false;
                        break;
                    }
                    break;
                case "A":
                    if (!nucleotide_two.equals("T")) {
                        isBond = false;
                        break;
                    }
                    break;
                case "T":
                    if (!nucleotide_two.equals("A")) {
                        isBond = false;
                        break;
                    }
                    break;
            }
        }
        return isBond;
    }

    public static String createMatchingChain(String chain1) {
        //TODO: Create a matching chain for chain1
        List<String> matchingChain_list = new ArrayList<>();
        String matchingChain = "";
        for (int i = 0; i < chain1.length(); i++) {
            String nucleotide_one = String.valueOf(chain1.charAt(i));
            switch (nucleotide_one) {
                case "C":
                    matchingChain = "G";
                    matchingChain_list.add(matchingChain);
                    break;
                case "G":
                    matchingChain = "C";
                    matchingChain_list.add(matchingChain);
                    break;
                case "A":
                    matchingChain = "T";
                    matchingChain_list.add(matchingChain);
                    break;
                case "T":
                    matchingChain = "A";
                    matchingChain_list.add(matchingChain);
                    break;
                default:
                    matchingChain = "";
                    break;
            }
        }
        return String.join((CharSequence) matchingChain_list);
    }

    public static boolean isPenguinDNA(String chain1, String chain2, String sequence) {
        //TODO: Checking penguin DNA
//        This means that both chains (first two method parameters) should be able to bind to each other
//        they contain the given nucleotide sequence (third method parameter).
//        The nucleotide sequence can be in either chain, but should not occur more than once.
        boolean isPenguinDNA = false;
        boolean isMatch = checkChains(chain1, chain2);
        boolean isContain = false;
        if (isMatch && (chain1.contains(sequence) || chain2.contains(sequence))) {
            return true;
        }
        return false;
    }

}
