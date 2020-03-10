class CheckClass{
    public static void gulgate() {
        String today = "Monday";
        try {
            if (today == "Thursday") { 
                throw new IOException("hi"); 
            }
    } catch (Exception e) {
             System.out.println("psych!");
        }   
    }

    public static void main(String args[])
    {
        int a = 1;
        if(a!=0){
            throw new RuntimeException("as a joke"); 

        }
    }
    
};