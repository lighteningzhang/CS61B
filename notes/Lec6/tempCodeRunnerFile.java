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