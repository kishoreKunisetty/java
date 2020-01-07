import java.util.*;
public class dynamicarray{
    private int[] items;
    private int count=0;
    public void Array(int length){
        items =new int[length];
    }
    public void print(){
        for(int i=0;i<count;i++){
            System.out.println(items[i]);
        }
    }
    public void insert(int item){
        if(items.length==count){
            int newitems[] =new int[count*2];
            newitems=Arrays.copyOf(items,count);
            items=newitems;//araycopy to the new array
            items[count]=item;
            count++;
        }else{
        items[count]=item;
            count++;}
    }
    
}
