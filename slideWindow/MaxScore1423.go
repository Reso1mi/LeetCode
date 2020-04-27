func maxScore(cardPoints []int, k int) int {
    if cardPoints==nil || len(cardPoints)==0 {
        return 0
    }
    n:=len(cardPoints)
    left:=0
    right:=n-k-1
    sum:=0
    windowSum:=0
    for i,num:=range cardPoints{
        sum+=num
        if i == right{
            windowSum = sum
        }
    }
    if k==n {
        return sum
    }
    minWin:=windowSum
    for right+1<n{
        windowSum+=(cardPoints[right+1]-cardPoints[left])
        minWin = min(windowSum,minWin)
        right++
        left++
    }
    return sum-minWin
}

func min(a,b int)int{
    if a<b{
        return a
    }
    return b
}