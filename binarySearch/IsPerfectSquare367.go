func isPerfectSquare(num int) bool {
    var left = 0
    var right = num
    var res = num + 1
    for left <= right {
        mid := left + (right-left)/2
        if mid*mid >= num {
            res = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return res*res == num
}

//完全平方数性质 n^2 = 1 + 3 + 5 +...+2n+1 (前n个奇数的和)
//所以只需要判断num能不能被奇数减成0就行了
func isPerfectSquare(num int) bool {
    var i = 1
    for num > 0 {
        num -= i
        i += 2
    }
    return num == 0
}
