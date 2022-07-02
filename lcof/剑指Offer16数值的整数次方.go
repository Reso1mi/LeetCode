// // fastPow
// func myPow(x float64, n int) float64 {
//     if n < 0 {
//         n = -n
//         x = 1/x
//     }
//     //1010
//     res := float64(1)
//     t := x
//     for n > 0 {
//         if n&1 == 1 {
//             res *= t
//         }
//         n>>=1
//         t *= t
//     }
//     return res
// }

// fastPow
func myPow(x float64, n int) float64 {
    var fastPow func(float64, int) float64
    fastPow = func(x float64, n int) float64 {
        if n == 0 {
            return 1
        }
        half := fastPow(x, n/2)
        if n&1 == 0 {
            return half * half
        }
        return half * half * x
    }
    if n < 0 {
        return fastPow(1/x, -n)
    }
    return fastPow(x, n)
}