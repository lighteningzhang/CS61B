public class IntList{
    int first;
    IntList rest;
    public IntList(int first, IntList rest){
        this.first = first;
        this.rest = rest;
    }
    
    public static IntList square(IntList L){
        if(L.rest==null){
            return new IntList(L.first*L.first,null);
        }
        else
            return new IntList(L.first*L.first,square(L.rest));
    }
    
    public static IntList squareMutative(IntList L){
        if(L.rest==null){
            L.first = L.first*L.first;
            return L;
        }
        else{
            L.first = L.first*L.first;
            L.rest = squareMutative(L.rest);
            return L;
        }
    }

    public static IntList sqIt(IntList l){
        

        l = new IntList(l.first*l.first,l.rest);
        IntList c = l;
        IntList p = l.rest;
        
        while(p!=null){
            c.rest = new IntList(p.first*p.first,null);
            p = p.rest;
            c = c.rest;
        }
        return l;
    }

    public static IntList sqItM(IntList l){
        while(l!=null){
            l.first = l.first*l.first;
            l = l.rest;
        }
        return l;
    }

    public void printList(){
        IntList l = this;
        while(l!=null){
            System.out.print(l.first);
            System.out.print(" ");
            l = l.rest;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        IntList l = new IntList(3,null);
        l = new IntList(4,l);
        l = new IntList(5,l);
        l = sqIt(l);
        l.printList();
        
    }

}   