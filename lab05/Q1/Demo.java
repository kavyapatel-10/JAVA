abstract class Shape { 
    public abstract double area(); 
} 

class Circle extends Shape { 
    double radius; 
    Circle(double r1) { 
        this.radius = r1; 
    } 
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
} 

class Rectangle extends Shape { 
    double height; 
    double width; 
    Rectangle(double h1, double w1) { 
        this.height = h1; 
        this.width = w1; 
    } 
    @Override
    public double area() {
        return height * width;
    }
} 

class Triangle extends Shape { 
    double height; 
    double base; 
    Triangle(double h1, double b1) { 
        this.height = h1; 
        this.base = b1; 
    } 
    @Override
    public double area() {
        return 0.5 * base * height;
    }
} 

class Demo { 
    public static void main(String args[]) { 
        
        Shape s1[] = { 
            new Circle(10.00), 
            new Rectangle(20.0, 25.0), 
            new Triangle(30.0, 35.0), 
            
            new Circle(50.0) 
        }; 

        double calcarea = 0; 
        double runningarea = 0; 
        String largestarea = null; 
        double largearea = 0; 

        for(Shape sw : s1) { 
            calcarea = sw.area(); 
            runningarea += calcarea; 
            if(calcarea > largearea) { 
                largearea = calcarea; 
                largestarea = sw.getClass().getSimpleName(); 
            } 
        } 
        
        System.out.println("Total area: " + runningarea); 
        System.out.println("Shape with largest area: " + largestarea); 
    } 
}
