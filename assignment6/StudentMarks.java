import java.util.HashMap;
import java.util.Map;

public class StudentMarks {
    public static void main(String[] args) {
        Map<String,Integer> marksList=new HashMap<>();
        marksList.put("Shyam",87);
        marksList.put("balaram",89);
        marksList.put("hemanth",86);
        marksList.put("akbar",85);
        marksList.put("manoj",84);
        int highest=Integer.MIN_VALUE;
        int lowest=Integer.MAX_VALUE;
        String top=null;
        String bottom=null;
        for(Map.Entry<String,Integer> entry:marksList.entrySet()){
            if(entry.getValue()>highest){
                highest=entry.getValue();
                top=entry.getKey();
            }
            if(entry.getValue()<lowest){
                lowest=entry.getValue();
                bottom=entry.getKey();
            }
        }
        System.out.println("The higher mark student is "+top);
        System.out.println("The lower mark student is "+bottom);
         
    }
}
