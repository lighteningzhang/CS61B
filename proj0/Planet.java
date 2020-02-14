public class Planet{
    private static final double G = 6.67*1e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public double acc;
    public Planet(double xP,double yP,double xV,double yV, double m,String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Planet a){
        return Math.sqrt((this.xxPos-a.xxPos)*(this.xxPos-a.xxPos)+(this.yyPos-a.yyPos)*(this.yyPos-a.yyPos));
    }
    public double calcForceExertedBy(Planet b){
        double dis = this.calcDistance(b);
        double F=G*this.mass*b.mass/(dis*dis);
        return F;
    }
    public double calcForceExertedByX(Planet[] ps){
        double Fx = 0;
        for(Planet p:ps){
            if(this.equals(p))
                continue;
            double dis = this.calcDistance(p);
            double dx = (-this.xxPos+p.xxPos);
            double Fxtmp = this.calcForceExertedBy(p);
            Fx += dx/dis*Fxtmp;
        }
        return Fx;
    }
    public double calcForceExertedByY(Planet[] ps){
        double Fy=0;
        for(Planet p:ps){
            if(this.equals(p))
                continue;
            double dis = this.calcDistance(p);
            double dy = (-this.yyPos+p.yyPos);
            double Fytmp = this.calcForceExertedBy(p);
            Fy += dy/dis*Fytmp;
        }
        return Fy;
    }
    public void update(double dt,double Fx,double Fy){
        double ax = Fx/this.mass;
        double ay = Fy/this.mass;
        this.xxVel = this.xxVel+ax*dt;
        this.yyVel = this.yyVel+ay*dt;
        this.xxPos = this.xxPos+dt*this.xxVel;
        this.yyPos = this.yyPos+dt*this.yyVel;
    }
    public void draw(){
        StdDraw.picture(xxPos,yyPos,"./images/"+imgFileName);
    }
}