type CQueue struct {
    stackIn  []int
    stackOut []int
}

func Constructor() CQueue {
    return *new(CQueue)
}

func (this *CQueue) AppendTail(value int) {
    this.stackIn = append(this.stackIn, value)
}

func (this *CQueue) DeleteHead() int {
    if len(this.stackIn) == 0 && len(this.stackOut) == 0 {
        return -1
    }
    if len(this.stackOut) != 0 {
        // pop
        res := this.stackOut[len(this.stackOut)-1]
        this.stackOut = this.stackOut[:len(this.stackOut)-1]
        return res
    }

    for len(this.stackIn) != 0 {
        this.stackOut = append(this.stackOut, this.stackIn[len(this.stackIn)-1])
        this.stackIn = this.stackIn[:len(this.stackIn)-1]
    }
    res := this.stackOut[len(this.stackOut)-1]
    this.stackOut = this.stackOut[:len(this.stackOut)-1]
    return res
}

/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */