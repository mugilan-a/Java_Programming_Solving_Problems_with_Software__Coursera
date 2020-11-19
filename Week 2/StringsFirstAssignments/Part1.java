
/**
 * Finding a Gene - Using the Simplified Algorithm
 * @author: Mugilan
 * (21/07/2020)
 */

public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        int start = dna.indexOf("ATG");
        if(start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA", start);
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
        String d = "TAGTATGGGTCAGSTATAAACTGTCG";       //String with ATG and TAA & substring is multiple of 3
        String e = "CGATCGCATGCATGCGATAGCTAAGC";       //String with ATG and TAA & substring is not multiple of 3
        
        System.out.println("The String is: " + a + ". \t The Gene is: " + findSimpleGene(a));
        System.out.println("The String is: " + b + ". \t The Gene is: " + findSimpleGene(b));
        System.out.println("The String is: " + c + ". \t The Gene is: " + findSimpleGene(c));
        System.out.println("The String is: " + d + ". \t The Gene is: " + findSimpleGene(d));
        System.out.println("The String is: " + e + ". \t The Gene is: " + findSimpleGene(e));
    }
    
    public static void main (String[] args) {
        Part1 gene = new Part1();
        gene.testSimpleGene();
    }
}
