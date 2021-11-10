package com.lxl.demo04;

public class TestDemo01 {
    public static void main(String[] args) {
        //添加一个棋盘
        int[][] map=new int[8][7];
        //将上下都置位1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右都置为1
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        System.out.println("地图的情况");
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //遍历整个二维数组
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("找到路");
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     *  使用递归回溯来进行小球招路
     *  说明：
     *  1 .map 表示地图
     *  2. i j 表示从地图的哪个位置出发
     *  3. 如果小球能到map[6][5]位置，说明小球找到
     *  4. 约定：当map[i][j]为0表示该点没有走过，当为1时为墙，2表示路通过可以走；3表示该点已经走过，但是走不通
     *  5. 在走迷宫时，需要确定一个策略（方法）下-》 右-》上-》左，如果该点走不满，在回溯
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true，否则就返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                //向下走
                if(setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1 ,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else {
                    //否则就说明该点走不通
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
