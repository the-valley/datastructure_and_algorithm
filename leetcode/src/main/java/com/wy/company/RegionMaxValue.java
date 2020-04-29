package com.wy.company;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description:    字节跳动2018年真题，根据规则求区间的最大值
 *
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列 [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值：
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 * 区间内的所有数字都在[0, 100]的范围内;
 *
 * @Author:         wy
 * @CreateDate:     2019/1/8 7:55
 * @Version:        1.0
 */
public class RegionMaxValue {
    public static int solution(Integer[] array, int start, int end){
        if (array == null || end < start){
            return 0;
        }
        int minValue = Collections.min(Arrays.asList(array));
        int sum = 0;
        return 0;
    }

}
