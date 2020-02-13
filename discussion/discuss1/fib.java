public class fib{
    public static int fibFunc(int n){
        if(n==0)
            return 0;
        else if(n==1){
            return 1;
        }
        else if(n==2){
            return 1;
        }
        else
            return fibFunc(n-1)+fibFunc(n-2);
    }
    public static int fibFunc(int n,int k,int f0,int f1){
        if(k==n){return f0;}
        return fibFunc(n,k+1,f1,f1+f0);
    }
    public static void main(String[] args) {
        int ans = fibFunc(10,0,0,1);
        System.out.println(ans);
    }
}