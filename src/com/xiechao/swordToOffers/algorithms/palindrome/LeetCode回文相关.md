###LeetCode上回文相关的问题

LeetCode234 Palindrome Linked List   判断一个链表是否满足回文 O(n),O(1)   
先反转前(或者后)半部分链表，再进行比较   

LeetCode9  Palindrome Number    判断一个数字是否是回文。不能将其转成字符串
将数字反转，判断相等与否，注意反转溢出情况分析    

LeetCode409 Longest Palindrome 给定一个由小写或大写字母组成的字符串，找到可以用这些字母构建的最长的回文长度。区分大小写     
很简单：根据回文子串的定义，如果是串中字符个数为偶数个，必定是n对字符；如果是奇数个，必定是n对字符+1
所以统计字符串s中出现成对出现字符的个数，只要成对出现都可以用来组成回文串，如果最后回文串的长度len小于原始字符串的长度，
那么说明还有没有使用的字符，那么len+1    
***
LeetCode125     Valid Palindrome 判断一个字符串是否是回文，只考虑数字字母字符，并忽略大小写    

LeetCode680     Valid Palindrome II 给定非空字符串s，能否最多可以删除一个字符使其成为回文。    
***
LeetCode131     Palindrome Partitioning 给定一个字符串，返回其每个子字符串都满足回文的集合     
回溯，组合的模型直接套上去    
LeetCode132     Palindrome Partitioning II 给你一个字符串s，返回最少的分割次数使得分割后的字串都为回文    
使用回溯的方法超时    
使用dp
***
LeetCode647     Palindromic Substrings 给出一个字符串，返回其子字符串满足回文的个数    
遍历字符串，对于每个元素，假设其为回文的中心（奇数或者偶数），向两边扩散。    
LeetCode5       Longest Palindromic Substring 给出一个字符串，返回其满足回文子字符串的最大长度    
LeetCode647的变形     

***
LeetCode516 Longest Palindromic Subsequence 求最长回文子序列，子序列不需要连续，而子字符串需要连续   
dp









