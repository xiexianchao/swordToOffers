#### combination and permutation
LeetCode39,40,77,78,90,131,46,47   
通用步骤
---
主函数:
1. 初始化结果result
2. 如果存在重复数字可能要进行排序
3. 调用递归函数
4. 返回结果
---
递归函数:
1. 递归退出条件，何时保存结果。有的时到达边界保存结果，有的时每次都要保存结果。例如LeetCode78. Subsets
2. for循环，注意一般情况下全排列从0开始，组合从start开始。
3. 剪枝，全排列需要去除包含已经包含i的，有重复元素要去除重复的影响。
在全排列中需要使用used[]数组来标记时候已经被包含来去除重复,而在组合当中只需要
判断i>start && nums[i] == nums[i-1]来去除重复。因为组合只会组合start之后的元素。
而排列是从0开始的，不使用used数组的话无法记录前一个重复元素是否被包含。
4. 递归。排列一般是start+1,而组合一般是i+1。
注意是否可以重复使用元素。比如leetcode39 combination sum
5. 调用完要删除当前结果的最后一个元素。进入到一下个循环才不会重复。    
参考:   [LeetCode子集合，排列组合，回文分离等问题的通用递归算法](https://segmentfault.com/a/1190000007062572)
[LeetCode 排列组合 题目汇总](https://www.jianshu.com/p/89297b012033)
[一次搞懂全排列——LeetCode四道Permutations问题详解](https://blog.csdn.net/Jacky_chenjp/article/details/66477538)
[leetcode77 Combinations](https://blog.csdn.net/u010500263/article/details/18435495)