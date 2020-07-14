func divisorGame(N int) bool {
    //N=i时，先手的人能否赢
    var dp = make([]bool, N+1)
    dp[1] = false
    for i := 2; i <= N; i++ {
        //尝试所有可行的选择
        //从i中先手拿j，看对方在i-j中先手能不能赢
        for j := 1; j < i; j++ {
            if i%j == 0 && !dp[i-j] {
                dp[i] = true
                break
            }
        }
    }
    return dp[N]
}

//规律，偶数必赢，奇数必输
//最后在N=2的时候结束比赛，所以谁先到2谁就赢
//奇数的因子只有奇数，奇数-奇数 = 偶数，当我拿到偶数时候可以直接拿走1，变为奇数，如此往来
//最终我必定能先到2
func divisorGame(N int) bool {
    return N%2 == 0
}
