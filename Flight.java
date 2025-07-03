public class Flight {
    int flightNo;
    String destination;
    int duration;
    Flight(){
        System.out.println("Flight has arrived...");
    }
    Flight(int no,String des,int dur){
        this.flightNo=no;
        this.destination=des;
        this.duration=dur;
        System.out.println(no+" flight for "+des+" will arrive in "+dur+" hours");
    }
    public static void main(String[] args){
        Flight f1=new Flight();
        Flight f2=new Flight(247,"vizag",5);
    }
}