func mySqrt(x int) int {
    lx := int64(x)
    var left int64 = 0
    var right int64 = lx/2 + 1
    for left < right {
        mid := left + (right-left)/2
        if mid*mid < lx {
            left = mid + 1
            //向下取整的，所以需要额外判断或者取右中位数
            if left*left > lx {
                return int(mid)
            }
        } else {
            right = mid
        }
    }
    return int(left)
}

//这个其实更能体现模板的好处
func mySqrt2(x int) int {
    lx := int64(x)
    var left int64 = 0
    var right int64 = lx/2 + 1
    for left < right {
        mid := left + (right-left)/2 + 1
        //大于lx的一定不是res但是小于的不一定不是，题目是向下取整的
        if mid*mid > lx { 
            right = mid - 1
        } else {
            left = mid
        }
    }
    return int(left)
}
