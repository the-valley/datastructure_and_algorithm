package question933;

import java.util.*;

/**
 * @author wangyong
 * @date 2019/5/23
 * @description
 * 写一个 RecentCounter 类来计算最近的请求。
 *
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 *
 * 返回从 3000 毫秒前到现在的 ping 数。
 *
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 *
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 *
 *
 * 示例：
 *
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 */
public class RecentCounter {
    private Deque<Integer> cache = new ArrayDeque<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        cache.addFirst(t);
        while (cache.getLast() < t - 3000) {
            cache.removeLast();
        }
        return cache.size();
    }
}
