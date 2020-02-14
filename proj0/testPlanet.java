
public class testPlanet{
    public static double F(Planet a, Planet b){
        double F = a.calcForceExertedBy(b);
        return F;
    }
    public static void main(String[] args) {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(1.0, 3.0, 3.0, 4.0, 5.0, "jupiter.gif");
        System.out.println(F(p1,p2));
    }
}