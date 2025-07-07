class NumberException{
    static void checkPositive(int number){
        if(number<0){
            throw new IllegalArgumentException("Number cannot be negative");
        }
        else{
            System.out.println(number+" Number is valid");
        }
    }
    public static void main(String[] a) {
        try{
        checkPositive(5);
        checkPositive(10);
        checkPositive(-4);
        }
        catch(IllegalArgumentException e){
            System.out.println("Error is "+e.getMessage());

        }
    }
}