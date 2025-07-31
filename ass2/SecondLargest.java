import java.util.*;
public class SecondLargest {
        public static void main(String[] args){
        int[] arr={12,45,34,21,49};
        int max1=-1;
        int max2=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max1){
                max2=max1;
                max1=arr[i];
            }
            else if(arr[i]>max2 && arr[i]!=max1){
                max2=arr[i];
            }
            }
            System.out.println(max2);
        }

}
