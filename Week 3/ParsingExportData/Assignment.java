
/**
 * Programming Exercise: Parsing Export Data
 * @author: Mugilan
 * (09/08/2020)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Assignment {
    
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String currentCountry = record.get("Country");
            
            if (currentCountry.equalsIgnoreCase(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                
                String result = currentCountry + ": " + exports + ": " + value;
                return result;
            }
        }
        
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
         for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int totalCountry = 0;
        
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            
            if (exports.contains(exportItem)) {
                totalCountry++;
            }
        }
        
        return totalCountry;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String currentAmount = record.get("Value (dollars)");
            
            if (currentAmount.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + currentAmount);
            }
        }
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "germany"));
        
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "gold"));
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }
    

    // QUIZ
    
    public void tester_fish_nuts(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();    
        listExportersTwoProducts(parser, "fish" , "nuts" );
    }
    
    public void tester_sugar(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();    
        System.out.println(numberOfExporters( parser , "sugar" ));
    }
    
    public void tester_countryinfo_nauru(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));
    }
    
    public void tester_one_trillion_or_more(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999" );
    }
    
    public void tester_cotton_flowers(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();    
        listExportersTwoProducts(parser, "cotton" , "flowers" );
    }
    
    public void tester_cocoa(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();    
        System.out.println(numberOfExporters( parser , "cocoa" ));
    }
}