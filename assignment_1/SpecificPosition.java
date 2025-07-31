import java.util.Arrays;
import java.util.Scanner;

public class SpecificPosition {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] a=new int[6];
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        int element=sc.nextInt();
        int position=sc.nextInt();
        int[] b=new int[a.length+1];
        for(int i=0;i<position;i++){
            b[i]=a[i];
        }
        b[position]=element;
        for(int i=position;i<a.length;i++){
            b[i+1]=a[i];
        }
        System.out.println("updated array: "+Arrays.toString(b));
    }

}

// import java.util.*;
// class First{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         Integer arr[]={12,45,34,21,49};
//         int element=sc.nextInt();
//         int pos=sc.nextInt();
//       ArrayList<Integer> list=new ArrayList<>(Arrays.asList(arr));
//         list.add(pos,element);
//         System.out.println(list);

//     }
//     }


