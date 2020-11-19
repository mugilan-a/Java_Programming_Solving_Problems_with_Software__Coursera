
/**
 * HowMany - Finding Multiple Occurences
 * @author: Mugilan
 * (22/07/20)
 */

public class Part2 {
    public int howMany(String stringa, String stringb){
        int count=0, current=0;
        while(true) {
            int index = stringb.indexOf(stringa, current);
            if(index == -1) {
                break;
            }
            count++;
            current = index + stringa.length();
        }
        return count;
    }
    
    public void testHowMany() {
        String a = "GAA";
        String b = "ATGAACGAATTGAATC";
        System.out.println("Total occurences of " + a + " in " + b + " = " + howMany(a, b));
        
        String c = "AA";
        String d = "ATAAAA";
        System.out.println("Total occurences of " + c + " in " + d + " = " + howMany(c, d));
    }
}
