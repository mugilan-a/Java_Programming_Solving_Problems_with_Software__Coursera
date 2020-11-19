
/**
 * Debugging1
 * @author: Mugilan
 * (19/07/2020)
 */

public class a {
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1) {
            break;
        }
        System.out.println("index+1,index+4 = " + (index+1) + "," + (index+4));
        String found = input.substring(index+1, index+4);
        System.out.println(found);    
        index = input.indexOf("abc", index+4);
    }
}
   public void test() {
    // findAbc("abcd");
    findAbc("abcdabc");
}

}
