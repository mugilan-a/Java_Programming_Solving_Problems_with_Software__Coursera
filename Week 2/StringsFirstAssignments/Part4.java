
/**
 * Finding Web Links
 * @author: Mugilan
 * (21/07/2020)
 */

import edu.duke.*;

public class Part4 {
    public void printUrls(String url) {
        URLResource myurl = new URLResource(url);
        for(String item : myurl.words()) {          //word by word reading
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if(pos != -1) {
                int beg = item.indexOf("\"");          //Index of starting quotation
                int end = item.indexOf("\"", beg+1);   //Index of ending quotation. Can also use lastIndexOf()
                System.out.println(item.substring(beg+1, end));
                
            }
        }
    }
    
    public void testUrl() {
        printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    
    public static void main() {
        Part4 url = new Part4();
        url.testUrl();
    }
}