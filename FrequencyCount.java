import java.util.Scanner;

public class FrequencyCount {
        public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        int contains=0;
        for(int i=0;i<n;i++){
            if(a[i]==contains){
                continue;
            }
                int count=1;
                for(int j=i+1;j<n;j++){
                    if(a[i]==a[j]){
                        count++;
                        a[j]=contains;
                    }
                }
            System.out.println(a[i]+" occurs "+ count+ " times");
        }
    }

}



// import java.util.*;
// class First{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int arr[]={12,3,3,12,10,44};
//         HashMap<Integer,Integer>hs=new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
//         }
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times")
//     }
//     }
