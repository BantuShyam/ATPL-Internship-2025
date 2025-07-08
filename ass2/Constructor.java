public class Constructor {
    String country;
    int rank;
    Constructor(String c,int r){
        this.country=c;
        this.rank=r;
    }
    Constructor(){
    this("India",1);
    System.out.println(country+" is at "+rank+" position.");
    }

    public static void main(String[] args) {
        Constructor c=new Constructor();
    }
}
