package 杨辉三角;

public class 杨辉三角 {  
public static void main(String[] args) {
        int i,j;
        int [][]a=new int[123][22];
        int s=a.length;
//        int level = 10;
//        int Lei[][] = new int [level][];
        int Lei[][] = new int [10][];
        for(i = 0;i<Lei.length;i++)
            Lei[i] = new int [i+1];
        //为Lei数组的每个元素赋值
        Lei[0][0] = 1;
        for(i=1;i<Lei.length;i++) {
            Lei[i][0] = 1;
            for(j=1;j<Lei[i].length-1;j++)
                Lei[i][j] = Lei[i-1][j-1]+Lei[i-1][j];
            Lei[i][Lei[i].length-1] = 1;
            
        }
        //输出Lei数组的每个元素
        for(i = 0;i<Lei.length;i++) {
            for(j=0;j<Lei[i].length;j++)
                System.out.print(Lei[i][j]+" ");
            System.out.println();//换行
        }
        System.out.println(s);
    }

}