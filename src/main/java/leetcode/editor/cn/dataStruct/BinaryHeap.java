package leetcode.editor.cn.dataStruct;

import java.util.Arrays;

public class BinaryHeap {


  
    
    public static void upAdjust(int[] array){
        int childIndex=array.length-1;
        int parentIndex=(childIndex-1)/2;
        
        int temp=array[childIndex];
        
        while (childIndex>0&&temp<array[parentIndex]){
            
            array[childIndex]=array[parentIndex];
            childIndex=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
        array[childIndex]=temp;
    }
    
    
    public static void downAdjust(int[] arry,int parentIndex,int length){
        int temp=arry[parentIndex];
        int childIndex=2*parentIndex+1;
        
        while (childIndex<length){
            
            //如果有右孩子,且右孩子小于左孩子的值,则定位到右孩子
            if (childIndex+1<length&&arry[childIndex+1]<arry[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值,跳出
            if (temp<=arry[childIndex])break;
            
            //无须真正交换,单向赋值
            arry[parentIndex]=arry[childIndex];
            parentIndex=childIndex;
            childIndex=2*parentIndex+1;//循环操作
        }
        arry[parentIndex]=temp;
    }


    public static void downAdjustBig(int[] arry,int parentIndex,int length){
        int temp=arry[parentIndex];
        int childIndex=2*parentIndex+1;

        while (childIndex<length){

            //如果有右孩子,且右孩子小于左孩子的值,则定位到右孩子
            if (childIndex+1<length&&arry[childIndex+1]>arry[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值,跳出
            if (temp>=arry[childIndex])break;

            //无须真正交换,单向赋值
            arry[parentIndex]=arry[childIndex];
            parentIndex=childIndex;
            childIndex=2*parentIndex+1;//循环操作
        }
        arry[parentIndex]=temp;
    }
    
    
    
    
    
    public static void HeadAdjust(int A[],int k,int len){
        A[0]=A[k];
        for (int i=2*k;i<=len;i*=2){
            if (i<len&&A[i]<A[i+1]){
                i++;
            }
            if (A[0]>=A[i]){
                break;
            }else {
                A[k]=A[i];
                k=i;
            }
        }
        A[k]=A[0];
    }
    
    
    public static void buildHeap(int[] array){
        for (int i=(array.length-2)/2;i>=0;i--){
            downAdjustBig(array,i,array.length);
        }
        
/*        for (int i=(array.length-2)/2;i>0;i--){
            HeadAdjust(array,i,array.length);
        }*/
    }
    
    

    public static void main(String[] args) {
       int[] arr= new int[]{1,6,2,5,4,7,9,3,-1};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
        
        
    }
}
