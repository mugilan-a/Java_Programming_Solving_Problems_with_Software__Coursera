import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double perimeter=getPerimeter(s);
        int number=getNumPoints(s);
        double avglen=perimeter/number;
        return avglen;
    }

    public double getLargestSide(Shape s) {
        double largest=0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(largest<currDist){
                largest=currDist;
            }
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double x=0;
        for (Point currPt : s.getPoints()) {
            if(x < currPt.getX()){
                x= currPt.getX();
            }
         
        }
        return x;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double larg_per_mul=0;
        for (File f : dr.selectedFiles()) { 
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double totalPerim = 0.0;
            Point prevPt = s.getLastPoint();
            for (Point currPt : s.getPoints()) {
                double currDist = prevPt.distance(currPt);
                totalPerim = totalPerim + currDist;
                prevPt = currPt;
            }
            
            if(larg_per_mul<totalPerim){
                larg_per_mul=totalPerim;
            }
                   
            
        }
        return larg_per_mul;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;
        double larg_per_mul=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) { 
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double totalPerim = 0.0;
            Point prevPt = s.getLastPoint();
            for (Point currPt : s.getPoints()) {
                double currDist = prevPt.distance(currPt);
                totalPerim = totalPerim + currDist;
                prevPt = currPt;
            }
            
            if(larg_per_mul<totalPerim){
                larg_per_mul=totalPerim;
                temp=f;
            }
                   
            
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int pts = getNumPoints(s);
        System.out.println("number of points =" + pts);
        double avglen = getAverageLength(s);
        System.out.println("average length =" + avglen);
        double larsid = getLargestSide(s);
        System.out.println("largest size =" + larsid); 
        double larX = getLargestX(s);
        System.out.println("largest X =" + larX); 
        
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
        
    
    public void testPerimeterMultipleFiles() {
        double peri_mul = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter of all files =" + peri_mul);
    }

    public void testFileWithLargestPerimeter() {
        String lar_file = getFileWithLargestPerimeter();
        System.out.println("file with the largest perimeter =" + lar_file);
    }

    
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
