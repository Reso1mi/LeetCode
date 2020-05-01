package arrays

func pivotIndex(nums []int) int {
	//前缀和，后缀和
	n := len(nums)
	if n == 0 {
		return -1
	}
	pre := make([]int, n+1) //i之前的元素和,不包含i
	pre[0] = 0
	last := make([]int, n+1) //(i-1)之后元素和,不包含(i-1)
	last[n] = 0
	for i, j := 1, n-1; i <= n && j >= 0; i, j = i+1, j-1 {
		//这里其实只要代入值验证第一次的转移是正确的就行了,不用考虑太多
		pre[i] = pre[i-1] + nums[i-1]
		last[j] = last[j+1] + nums[j]
	}
	for i := 0; i < n; i++ {
		//联系上面数组的定义思考
		if pre[i] == last[i+1] {
			return i
		}
	}
	return -1
}

func pivotIndex(nums []int) int {
	n := len(nums)
	if n == 0 {
		return -1
	}
	sum := 0
	for _, num := range nums {
		sum += num
	}
	temp := 0 //包含了边界0
	for i := 0; i < n; i++ {
		if temp*2+nums[i] == sum {
			return i
		}
		temp += nums[i]
	}
	return -1
}
