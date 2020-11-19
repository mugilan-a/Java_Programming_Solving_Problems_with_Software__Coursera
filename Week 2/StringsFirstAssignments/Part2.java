
/**
 * Finding a Gene - Using the Simplified Algorithm Reorganized
 * @author: Mugilan
 * (21/07/2020)
 */

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = "";
        
        if( Character.isUpperCase(dna.charAt(0)) ) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        
        int start = dna.indexOf(startCodon);
        if(start == -1) {
            return "";
        }
        
        int stop = dna.indexOf(stopCodon, start);
        if(stop == -1) {
            return "";
        }
        
        if((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
     public void testSimpleGene() {
        String a = "ATTAGCTCTCACAAAGGTAAGTCTCA";       //String with no ATG
        String b = "ACGTATGACAGACTGTAGTGAGCTAC";       //String with no TAA
        String c = "CTAATCCGGATCCGAGTGATGTACGA";       //String with no ATG or TAA
        String d = "TAGTATGGGTCAGATATAAACTGTCG";       //String with ATG and TAA & substring is multiple of 3
        String e = "tagtatgggtcagatataaactgtcg";       //String in lowercase with ATG and TAA & substring is multiple of 3
        
        System.out.println("The String is: " + a + ". \t The Gene is: " + findSimpleGene(a, "ATG", "TAA"));
        System.out.println("The String is: " + b + ". \t The Gene is: " + findSimpleGene(b, "ATG", "TAA"));
        System.out.println("The String is: " + c + ". \t The Gene is: " + findSimpleGene(c, "ATG", "TAA"));
        System.out.println("The String is: " + d + ". \t The Gene is: " + findSimpleGene(d, "ATG", "TAA"));
        System.out.println("The String is: " + e + ". \t The Gene is: " + findSimpleGene(e, "ATG", "TAA"));
    }
    
    public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testSimpleGene();
    }
}