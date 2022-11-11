package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class PenguinDNA {
    public static boolean checkChains(String chain1, String chain2) {
        //TODO: Check if two chains can bind to eachother
//        The DNA of a penguin is made up of 4 nucleotides: Cytosine (C), Guanine (G), Adenine (A), and Thymine (T).
//        Adenine and Thymine will form a bond, same for Guanine and Cytosine
        boolean isBond = true;
        if (chain1 == null || chain2 == null || chain1.length() == 0 || chain2.length() == 0 || chain1.length() != chain2.length()) {
            isBond = false;
        } else {
            for (int i = 0; i < chain1.length(); i++) {
                String nucleotide_one = String.valueOf(chain1.charAt(i));
                String nucleotide_two = String.valueOf(chain2.charAt(i));
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
        }
        return isBond;
    }

    public static String createMatchingChain(String chain1) {
        //TODO: Create a matching chain for chain1
        List<String> matchingChain_list = new ArrayList<>();
        String matchingChain = "";
        if (chain1.length() == 0) {
            return null;
        } else {
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
            return String.join("", matchingChain_list);
        }
    }

    public static boolean containsOnlyOnce(String fullString, String subString) {
        int firstIndex = fullString.indexOf(subString);
        System.out.printf("firstIndex of the substring: %d, lastIndex: %d%n", fullString.indexOf(subString), fullString.lastIndexOf(subString));
//        if fullString does not contain subString, firstIndex = -1
//        if fullString contains subString more than once, then firstIndex of subString != lastIndex of subString in the fullString
        return firstIndex !=-1 && firstIndex == fullString.lastIndexOf(subString);
    }
    public static boolean isPenguinDNA(String chain1, String chain2, String sequence) {
        //TODO: Checking penguin DNA
//        This means that both chains (first two method parameters) should be able to bind to each other
//        they contain the given nucleotide sequence (third method parameter).
//        The nucleotide sequence can be in either chain, but should not occur more than once.
        boolean isPenguinDNA = true;
        boolean isMatch = checkChains(chain1, chain2);
//        boolean isContain = false;
        if (chain1 == null || chain2 == null || chain1.length() == 0 || chain2.length() == 0 || sequence.length() == 0) {
            isPenguinDNA = false;
        } else if (!isMatch) {
            isPenguinDNA = false;
        } else {
//            count whether the sequence contains more than once
            isPenguinDNA = containsOnlyOnce(chain1, sequence) || containsOnlyOnce(chain2, sequence);
        }
        return isPenguinDNA;
    }


    public static void main(String[] args) {
        String chain1 = "ACGTT";
        String chain2 = "TGCAA";
        String chain3 = "GTTAC";
        String sequence = "T";
//        System.out.printf("checkChains 1 & 2 %b%n", checkChains(chain1, chain2));
//        System.out.printf("checkChains 2 & 3 %b%n", checkChains(chain2, chain3));
//        System.out.printf("checkChains 1 & 3 %b%n", checkChains(chain1, chain3));
//        System.out.printf("createMatchingChain %s%n", createMatchingChain(chain1));
//        System.out.println(containsOnlyOnce(chain1, sequence));
//        System.out.printf("isPenguinDNA %b%n", isPenguinDNA(chain1, chain2, sequence));
//        System.out.println(containsOnlyOnce(chain1, sequence));

    }
}
