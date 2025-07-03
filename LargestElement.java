import java.util.*;
class LargestElement{
    public static void main(String[] args){
        int[] arr={12,45,34,21};
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
}
}


// import java.util.*;
// class First{
//     public static void main(String[] args){
//         int[] arr={12,45,34,21};
//         int len=arr.length;
//         Arrays.sort(arr);
//         System.out.println(arr[len-1]);
//     }
// }

