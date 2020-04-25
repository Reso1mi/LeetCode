func canCompleteCircuit(gas []int, cost []int) int {
    n:=len(gas)
    curGas:=0 //当前油量
    start:=0 //起点
    total:=0 //gas和cost之差,小于0的话肯定无法绕圈
    for i:=start;i<n;i++{
        curGas+=(gas[i]-cost[i])
        total+=(gas[i]-cost[i])
        //油量不够，i无法继续前进到i+1,说明从start~i无法绕环
        if curGas<0{ 
            start=i+1
            curGas=0
        }
    }
    if total<0{
        return -1
    }
    return start
}