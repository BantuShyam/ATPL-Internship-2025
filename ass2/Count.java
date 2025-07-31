import java.util.Scanner;

public class Count {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int arr[]={12,45,3,1,44};
        int even=0;
        int odd=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                even+=1;
            }
            else{
                odd+=1;
            }
        }
        System.out.println("even count:"+even);
        System.out.println("odd count:"+odd);
    }

}
