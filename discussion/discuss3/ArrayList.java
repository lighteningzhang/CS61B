public class ArrayList{
    int[] arr;
    int sz;

    public ArrayList(int[] arr){
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        sz = arr.length;
    }

    public void resize(int size){
        int[] a = new int[size];
        System.arraycopy(arr, 0, a, 0, sz);
    }
    
    public static int[] resize(int[] arr,int sz){
        int[] a = new int[sz];
        return a;
    }

    public void insert(int item, int pos){
        if(sz==arr.length){
            this.resize(1+sz);
        }
        else if(pos>=sz){
            pos = sz;
        }
        else
            System.arraycopy(arr,pos,arr,pos+1,sz-pos);
        arr[pos] = item;
        sz+=1;
    }

    public static int[] insert(int[] arr, int item, int pos){
        System.arraycopy(arr, pos, arr, pos+1, arr.length-pos-1);
        arr[pos] = item;
        // without manipulating the variable size
        return arr;
    }

    public static int[] replicate(int[] arr){
        int st = 0;
        int[] res = new int[0];
        int idx = 0;
        // int res=0;
        // for(int item:arr){
        //     res+=item;
        // }
        // int[] rt = new int[res];
        while(st<arr.length){
            int[] tmp = res;
            res = resize(res,idx+arr[st]);
            System.arraycopy(tmp, 0, res, 0, tmp.length);
            int val = arr[st];
            while(val!=0){
                res[idx++] = arr[st];
                val--;
            }
            st+=1;
        }
        return res;
    }

    public void print(){
        int ct = 0;
        while(ct<sz){
            System.out.print(arr[ct]);
            ct+=1;
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void reverse(int[] arr){
        int mid = arr.length/2;
        int st = 0;
        while(st<mid){
            int tmp = arr[st];
            arr[st] = arr[arr.length-1-st];
            arr[arr.length-1-st] = tmp;
            st+=1;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,3,5,2,9};
        ArrayList arrList = new ArrayList(a);
        arrList.insert(arrList.arr,6, 3);
        
        arrList.insert(arrList.arr,9, 3);
        
        arrList.insert(arrList.arr,3, 3);
        arrList.print();
        reverse(arrList.arr);
        arrList.print();

        int[] res = replicate(arrList.arr);
        for(int i:res){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    
}