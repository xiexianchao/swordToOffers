#### 无限背包
即物品可以取无限次或者有无限个，这里包含了一个隐形条件：背包承重的固定性
导致每种最多只能取W/w[i]个。即对于第i种物品，它可以取0，1，2，...,W/w[i]
件，而在0/1背包种，只能取0，1件。0/1背包是无限背包的一个特例。所有完全可以
用类似0/1背包的思路写出无限背包的基本算法：
F[i][j]=max{F[i-1][j- k *w[i]] + k * w[i]} ,0 <= k <= j/w[i],i=0,1,...n j=0,1...W