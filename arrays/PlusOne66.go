func plusOne(digits []int) []int {
    n := len(digits) - 1
    carry := 1
    for n >= 0 {
        digits[n] += carry
        carry = digits[n] / 10
        digits[n] %= 10
        n--
    }
    if carry == 1 {
        digits = append([]int{1}, digits...)
    }
    return digits
}
