/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * type MountainArray struct {
 * }
 *
 * func (this *MountainArray) get(index int) int {}
 * func (this *MountainArray) length() int {}
 */

func findInMountainArray(target int, mountainArr *MountainArray) int {
    n := mountainArr.length()
    //寻找山顶
    left := 0
    right := n - 1
    for left < right {
        mid := left + (right-left)/2
        //mid+1肯定不会越界
        if mountainArr.get(mid) < mountainArr.get(mid+1) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    res := -1
    res = binarySearchUp(mountainArr, target, 0, left)
    if res == -1 {
        res = binarySearchDown(mountainArr, target, left, n-1)
    }
    return res
}

func binarySearchUp(mountainArr *MountainArray, target, left, right int) int {
    for left < right {
        mid := left + (right-left)/2
        if mountainArr.get(mid) < target {
            left = mid + 1
        } else {
            right = mid
        }
    }
    if mountainArr.get(left) == target {
        return left
    }
    return -1
}

func binarySearchDown(mountainArr *MountainArray, target, left, right int) int {
    for left < right {
        mid := left + (right-left)/2
        if mountainArr.get(mid) > target {
            left = mid + 1
        } else {
            right = mid
        }
    }
    if mountainArr.get(left) == target {
        return left
    }
    return -1
}
