Let's think about this case.

Input: nums = [4,5,6,7,0,1,2], target = 0
Input array is rotated, so seems like we can't use binary search but actually we can use idea of binary search.

[4,5,6,7,0,1,2]
L     M     R

L: Left pointer
M: Middle pointer (= (L + R) // 2)
R: Right pointer
When we use binary search, input array is sorted in ascending order. Let's find a part of ascending order, because the input array is rotated.

Why do we need to find a part of ascending order? and How?
I'll explain why later. I'll talk about "How" at first.

First of all, Check middle number is equal to the target. It's false.

Next let's focus on L and M. Between then all numbers are sorted in ascending order.

The description says "There is an integer array nums sorted in ascending order". That means the original array is also sorted in ascending order.

So,

⭐️ Points

if nums[M] >= nums[L]
if true, all numbers are sorted in ascending order between them.

On the other hand

if false, all numbers are sorted in ascending order between M and R.

For example,

[4,5,6,7,0,1,2]
L       M   R
(This is impossible but this is image of false case)

Look at all numbers between M and R. They are sorted(= 0,1,2). Between L and M, all numbes are not sorted because 0 is coming after 7.

In this case, it's true, so we are sure all numbers are sorted between L and M.

Next, typical binary search process is to move L or R depends on size of number in M and the target.

[4,5,6,7,0,1,2]
L     M     R

target = 0
In this case,

⭐️ Points

if nums[L] <= target <= nums[M]:
if true, we are sure that target number is somewhere between L and M because all numbers are sorted(except no target case). L is the samllest number and M is the biggest number.

On the other hand right side between M and R is not sorted, so we are not sure target is on the right side with the above condition. And it's tough to create another condition with unsorted numbers.

We had a question above saying "Why do we need to find a part of ascending order?"

Creating this condtion the reason why we need to find the part of ascending order.

Let's go back to main point. We try to find the target with the part of ascending order, but it's false this time, so we are sure we don't have the target between L and M. So we should move L to M + 1 position

[4,5,6,7,0,1,2]
L     M     R

↓

[4,5,6,7,0,1,2]
M L   R

target = 0
Why + 1 instead of just M?

That's because at first we check if current middle number is equal to the target and it was false, that's why current middle number is definitely not the target number. Now candidates of the target number should be all numbers after the current middle number(= 0, 1 or 2). The next search range should be from at index 4 to 6.

Next, middle pointer should be at index 5.

[4,5,6,7,0,1,2]
L M R
target = 0
We will repeat the same process. At first check if the current middle number is equal to the target. it's false.

Next step,

if nums[M] >= nums[L] → true
We are sure all numbers between L and M are sorted, so

if nums[L] <= target <= nums[M] → true
We are sure we have the target number between L and M, so move R to M - 1. We have the same reason of +1 above for -1.

[4,5,6,7,0,1,2]
L M
R
target = 0
Next, middle pointer should be at 4.

[4,5,6,7,0,1,2]
L
R
M

target = 0
Check middle number is equal to the target. Yes, it's true.

return 4 (= `M`)
This example was bad lol, I didn't explain false case of

if nums[M] >= nums[L]
Let me explain it briefly.

[5,6,0,1,2,3,4]
L     M     R

target = 0
if nums[M] >= nums[L] → false
That means all numbers between L and M are not sorted and all numbers between M and R are sorted, so we can use range of M and R to find the target.

In this case, M should be the smallest and R is the biggest so,

if nums[M] <= target <= nums[R]
If true, L should be M + 1.
If false, R should be M - 1.

So, move R to M - 1 this case. we will repeat this process.

