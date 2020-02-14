public class NBody{
    public static double readRadius(String f){
        In input  = new In(f);
        int firstPara = input.readInt();
        double radius = input.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String f){
        In input = new In(f);
        int first = input.readInt();
        double sec = input.readDouble();
        // String[] s = new String[5];
        Planet[] ps = new Planet[5];
        for(int i=0;i<5;i++){
            double xxPos = input.readDouble();
            double yyPos = input.readDouble();
            double xVel = input.readDouble();
            double yVel = input.readDouble();
            double mass = input.readDouble();
            String str = input.readString();
            ps[i] = new Planet(xxPos,yyPos,xVel,yVel,mass,str);
        }
        return ps;
    }
    
    public static void main(String[] args) {
        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        String filename = args[2]; 
        double radius = readRadius(filename);  
        StdDraw.setScale(-radius,radius);

        StdDraw.clear();
       
        Planet[] ps = readPlanets(filename);
        StdDraw.picture(0,0,"./images/starfield.jpg");
        for(Planet p:ps){
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        double t = 0;
        while(t<T){
            Double[] xForces = new Double[ps.length];
            Double[] yForces = new Double[ps.length];
            for(int i=0;i<ps.length;i++){
                xForces[i] = ps[i].calcForceExertedByX(ps);
                yForces[i] = ps[i].calcForceExertedByY(ps);
            }
            for(int i=0;i<ps.length;i++){
                ps[i].update(dt, xForces[i], yForces[i]);
            }
            
            StdDraw.picture(0,0,"./images/starfield.jpg");
            for(Planet p:ps){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n",ps.length);
        StdOut.printf("%.2e\n",radius);
        for(int i=0;i<ps.length;i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
            ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
        }

    }
}