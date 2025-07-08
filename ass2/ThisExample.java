public class ThisExample {
    String player;
    int runs;
    ThisExample(String s,int r)
    {
        this.player=s;
        this.runs=r;
    }
    void display(){
        System.out.println(player+" has "+runs+" runs");
    }
    public static void main(String[] args) {
        ThisExample th=new ThisExample("kohli",18004);
        th.display();
        ThisExample th2=new ThisExample("rohit",11404);
        th2.display();
    }
}
