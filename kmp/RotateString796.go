

//不够聪明的做法: 二分+KMP 时间复杂度O(NlogN)
func rotateString(A string, B string) bool {
    if len(A) != len(B) {
        return false
    }
    if A == B {
        return true
    }
    var left = 0
    var right = len(B) - 1
    var rotate = -1
    //二分找旋转点
    for left <= right {
        mid := left + (right-left)/2
        if kmp(A, B[:mid+1]) != -1 {
            rotate = mid
            left++
        } else {
            right--
        }
    }
    if rotate == -1 {
        return false
    }
    return kmp(A, B[rotate+1:]) != -1
}

//聪明的解法: A+A包含了所有可能的旋转情况，直接对A+A和B做kmp就行了
//abcdeabcde
func rotateString(A string, B string) bool {
    if len(A) != len(B) {
        return false
    }
    if A == B {
        return true
    }
    return kmp(A+A, B) != -1
}

func kmp(A string, t string) int {
    var next = getNext(t)
    var Ai = 0
    var ti = 0
    for Ai < len(A) && ti < len(t) {
        if A[Ai] == t[ti] {
            Ai++
            ti++
        } else if next[ti] == -1 {
            Ai++
        } else {
            ti = next[ti]
        }
    }
    if ti == len(t) {
        return Ai - 1
    }
    return -1
}

func getNext(t string) []int {
    if len(t) < 2 {
        return []int{-1}
    }
    var next = make([]int, len(t))
    var left = 0
    next[0] = -1
    next[1] = 0
    var i = 2
    for i < len(t) {
        if t[left] == t[i-1] {
            left++
            next[i] = left
            i++
        } else if next[left] == -1 {
            i++
        } else {
            left = next[left]
        }
    }
    return next
}
