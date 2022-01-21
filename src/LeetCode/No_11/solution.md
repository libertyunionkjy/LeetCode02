[题目链接](https://leetcode-cn.com/problems/container-with-most-water/submissions/)

解决思路：双指针

解释：已知双指针指向的位置代表容器的两壁，想要找到一个比目前容器更大的容器，由于面积等于长*宽，我们可以确定一个变量的变化方向后尝试增大另一个变量，例如初始时使双指针指向数组的头和尾，

```java
int left = 0, right = height.length - 1;
```

然后往中间找到一个可能的最大值。此时容器的宽（right - left）是减小的，所以我们只有增大容器的高度才可能找到一个比目前面积更大的容器。而容器的高度为：

```java
int height = Math.min(height[left], height[right]);
```

所以我们每次只要将代表高度的那个指针向中间逼近即可。