

public class Driver {
    public static void main(String[] args) {
        
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2), 
            new Point(5, 6),
            new Point(3, 4)  
        };

        int distinctCount = 0;

        
        for (int i = 0; i < points.length; i++) {
            boolean isRepeated = false;
            
            
            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    isRepeated = true;
                    break;
                }
            }
            
            
            if (!isRepeated) {
                distinctCount++;
            }
        }

        
        System.out.println("Distinct: " + distinctCount);
    }
}
