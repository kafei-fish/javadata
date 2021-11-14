package com.lxl.leetcode;

/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 *
 * 当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。
 *
 * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
 *
 * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
 *
 * 返回艾希处于中毒状态的 总 秒数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/teemo-attacking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[] timeSeries={1,2};
        int duration=2;
        int poisonedDuration = findPoisonedDuration(timeSeries, duration);
        System.out.println(poisonedDuration);
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans=0,last=-1;
        for (int s : timeSeries) {
            int e=s+duration-1; //2
            //这里进行判断，两次攻击是否重合
            //e 是结束点
            //如果攻击不重合,则就 ans+=duration; last=e;
            //如果攻击重合 则ans =ans+(e-last) 2+(3-2)
            ans+=last<s ?duration:e-last;
            last=e;
        }
        return ans;
    }
}
