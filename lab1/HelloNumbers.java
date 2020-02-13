public class HelloNumbers{
    public static void main(String[] args){
        int sum = 0, x = 1;
        while(x<10){
            sum += x;
            x += 1;
            System.out.print(sum+" ");
        }
        System.out.println();
        
    }
}
/*
    1. Before variables can be used, declare
    2. Type never change
    3. Types are verified before the code even runs
*/