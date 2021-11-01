package com.lxl;

import java.io.*;

/**
 * 稀疏数组的代码实现：
 * 将一个二维数组进行压缩，成一个稀疏的二维数组；
 * 该算法可用于在下棋是，用户退出该棋盘，但是我们要保存该棋局，
 * 但是用只下了两次器，整个棋盘的空间还有很大，会浪费空间，
 * 这时候，我们将使用稀疏算法，进行压缩，就可以提高效率
 */
public class SparseArray02 {
    public static void main(String[] args) throws IOException {
        //创建一个普通的二维数组
        System.out.println("创建棋盘");
        int[][] checkerboard = SparseArray02.checkerboard();
        SparseArray02.printCheckerboard(checkerboard);
        //创建一个稀疏数组
        System.out.println("创建一个稀疏数组");
        int[][] ints = SparseArray02.sparseArray(checkerboard);
        SparseArray02.printSparSeArray(ints);

        //把生成的稀疏数组存入本地
        System.out.println("将存入本地");
        String str="D:/sparse3.txt";
        try {

            SparseArray02.writeFile(ints,str);
        } catch (IOException e) {
            System.out.println("输出失败");
        }
        //再从本地读取
        System.out.println("从本地读取");
        int[][] ints1 = SparseArray02.readSparseArray(str, sum(checkerboard));
        SparseArray02.printSparSeArray(ints);
        System.out.println("转换成棋盘");
        int[][] ints2 = SparseArray02.ConvertToChessboard(ints1);
        SparseArray02.printCheckerboard(ints2);
    }
    //普通数组
    public static int[][] checkerboard(){
        int chessArray[][]=new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][3]=2;
        chessArray[3][4]=1;
        chessArray[5][2]=1;
        return chessArray;
    }
    //打印棋盘

    /**
     *
     * @param checkerboard
     */
    public static void printCheckerboard(int[][] checkerboard){
        for (int[] ints : checkerboard) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
    //打印稀疏数组

    /**
     *
     * @param sparse
     */
    public static void printSparSeArray(int[][] sparse){
        for (int[] ints : sparse) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
    //稀疏数组

    /**
     *
     * @param chessArray
     * @return
     */
    public static int[][] sparseArray(int[][] chessArray){
        //通过棋子的个数我们就可以获取稀疏棋盘的行和列
        int sum = SparseArray02.sum(chessArray);
        int sparseAr[][]=new int[sum+1][3];
        sparseAr[0][0]=11;
        sparseAr[0][1]=11;
        sparseAr[0][2]=sum;
        //循环变量棋盘把
        int count=0;
        for(int i=0;i<chessArray.length;i++){
            for(int j=0;j<chessArray.length;j++){
                if(chessArray[i][j]!=0){
                    count++;
                    sparseAr[count][0]=i;
                    sparseAr[count][1]=j;
                    sparseAr[count][2]=chessArray[i][j];
                }
            }
        }
        return sparseAr;
    }
    //获取棋盘的棋子个数

    /**
     *
     * @param chessArray
     * @return
     */
    public static int sum(int[][] chessArray){
        int sum=0;
        for(int i=0;i<chessArray.length;i++){
            for(int j=0;j<chessArray.length;j++){
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        return sum;
    }

    //将数组保存到本地

    /**
     *
     * @param sparseArray
     * @param str
     * @throws IOException
     */
    public static void writeFile(int[][] sparseArray,String str) throws IOException {

        File file=new File(str);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter=new FileWriter(str);
        System.out.println("开始输出");
        for(int i=0;i<sparseArray.length;i++){
            //一行一行的写入到文本文件中
            for(int j=0;j<sparseArray[i].length;j++){
                fileWriter.write(sparseArray[i][j]+"\t");
            }
           fileWriter.write("\r\n");
        }
        fileWriter.close();
        System.out.println("输出成功");
    }

    /**
     *
     * @param str
     * @param sum
     * @return
     * @throws IOException
     */
    public static int[][] readSparseArray(String str,int sum) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(str)));
        //还要进行判空


        int[][] sparseArray=new int[sum+1][3];
        String line;
        int rows=0;
        while ((line=bufferedReader.readLine())!=null){
            String[] split = line.split("\t");
            for(int i=0;i<split.length;i++){
                sparseArray[rows][i]=Integer.parseInt(split[i]);
            }
            rows++;
        }
        return sparseArray;
    }
    //转换成棋盘

    /**
     *
     * @param SparseArray
     * @return
     */
    public static int[][] ConvertToChessboard(int[][] SparseArray){
        int[][] checkerboard=new int[SparseArray[0][0]][SparseArray[0][1]];
        for(int i=1;i<SparseArray.length;i++){
            checkerboard[SparseArray[i][0]][SparseArray[i][1]]=SparseArray[i][2];
        }
        return checkerboard;
    }
}
