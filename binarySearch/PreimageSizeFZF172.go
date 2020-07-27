//ans: 0 or 5
func preimageSizeFZF(K int) int {
    //n/5 + n/25 + ... +  = K ==> n < 5*K
    var left = 0 
    var right = 5*K+1
    for left <= right {
        mid := left + (right-left)/2
        var zero = trailingZeroes(mid)
        if zero == K {
            return 5
        }
        if zero > K {
            right = mid - 1
        }else{
            left = mid + 1
        }
    }
    return 0
}

//172.阶乘后的0
func trailingZeroes(n int) int {
    var count = 0
    for n > 0 {
        n/=5
        count += n
    }
    return count
}