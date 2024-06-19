package devide_conquer._1725_히스토그;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int num;

    public static int[] list=new int[100001];

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);

        num=scan.nextInt();

        for(int x=0;x<num;x++)
            list[x]=scan.nextInt();

        System.out.println(divide(0,num-1));
    }

    public static int divide(int left,int right){
        if(left==right)
            return list[left];
        else{
            int mid=(left+right)/2;

            int max_value=Math.max(divide(left,mid),divide(mid+1,right));

            int min_height=Math.min(list[mid],list[mid+1]);
            int temp_max_value=2*min_height;

            int lo=mid;
            int hi=mid+1;

            while(lo>left || hi < right){
                if(lo==left || list[hi+1]>list[lo-1]){
                    hi++;
                    min_height=Math.min(min_height,list[hi]);
                }else{
                    lo--;
                    min_height=Math.min(min_height,list[lo]);
                }

                temp_max_value=Math.max(temp_max_value,(hi-lo+1)*min_height);
            }

            return Math.max(max_value,temp_max_value);
        }
    }
}
