package leetcode.editor.cn;

public class CountSortTest {

    public static void main(String[] args) {
        
    }
    
    
    
    public int[] CountSort(int[] arr){
        //找出最大值
        if (arr.length==0){
            return new int[]{};
        }
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        
        int[] arrTemp=new int[max];

        for (int i = 0; i < arr.length; i++) {
             arrTemp[arr[i]]++;
        }
        
        int[] resultAr=new int[arr.length];
        int index=0;
        for (int i = 0; i < arrTemp.length; i++) {
              for (int j=0;j<arrTemp[i];j++){
                   resultAr[index++]=i;
              }
        }
        return resultAr;
    }
    
}
