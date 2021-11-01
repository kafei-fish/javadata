package com.lxl;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //新建一个二维数组的棋盘
        System.out.println("初始棋盘");
        int checkerboard[][]=new int[11][11];
        checkerboard[1][2]=1;
        checkerboard[2][3]=2;
        checkerboard[3][4]=1;
        for (int[] data : checkerboard) {
            for (int datum : data) {
                System.out.printf("%d\t",datum);
            }
            System.out.println();
        }
        int sum=0;
        for(int i=0;i<checkerboard.length;i++){
            for(int j=0;j<checkerboard.length;j++){
                if(checkerboard[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        //创建一个稀疏数组，列是棋盘元素的个数+，行是3行
        int sparseArray[][]=new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;
        int count=0;
        for(int i=0;i<checkerboard.length;i++){
            for(int j=0;j<checkerboard.length;j++){
                if(checkerboard[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=checkerboard[i][j];
                }
            }
        }
        System.out.println("稀疏数组");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    //在通过稀疏数组进行恢复成普通数组
        int checkerboard2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i=1;i<sparseArray.length;i++){
                checkerboard2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        System.out.println("恢复后的棋盘");
        for (int[] ints : checkerboard2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}
