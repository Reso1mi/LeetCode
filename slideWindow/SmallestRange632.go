func smallestRange(nums [][]int) []int {
    var n = len(nums)
    //列表中所有元素k,存在于那些数组中
    var m = make(map[int][]int)
    var Max = func (a, b int) int {if a > b {return a}; return b}
    var Min = func (a, b int) int {if a < b {return a}; return b}
    //记录最大最小值，然后在区间内滑窗，也可以直接将所有数组归并排一下，然后滑窗，比较麻烦，懒得写了
    //所以下面的做法实际上是和循序无关的，没有用到有序这个条件
    var maxV = math.MinInt32
    var minV = math.MaxInt32
    for i :=0; i < n; i++ {
        for j := 0; j < len(nums[i]); j++ {
            m[nums[i][j]] = append(m[nums[i][j]], i)
            maxV = Max(maxV, nums[i][j])
            minV = Min(minV, nums[i][j])
        }
    }
    //同 76.最小覆盖子串，这题可能思维的转换比较重要
    var count = 0
    var freq = make([]int, n+1)
    var res =[]int{minV, maxV}
    var left = minV
    for right := minV; right <= maxV; right++ {
        if lis, ok := m[right]; ok {
            for _, numIdx := range lis {
                freq[numIdx]++
                if freq[numIdx] == 1{
                    count++
                }
            }
        }
        for count == n && left <= right {
            if right-left < res[1]-res[0] {
                res[0] = left
                res[1] = right
            }
            if lis, ok := m[left]; ok{
                for _, numIdx := range lis {
                    freq[numIdx]--
                    if freq[numIdx] < 1 {
                        count--
                    }
                }
            }
            left++
        }
    }
    return res
}

//go封装一个堆
type Heap struct{
    data []int
}

func (heap *Heap) Push(val int){
    data = append(data, val)
    shiftUp(len(data)-1)
}

//   0
// 1   2
//3 4
func (heap *Heap) shiftUp(idx int){
    var data = heap.data
    for idx > 0 && data[idx] < data[idx/2] {
        data[(idx-1)/2], data[idx] = data[idx], data[(idx-1)/2]
        idx = (idx-1)/2
    }
}

func (heap *Heap) shiftDown(idx int){
    var data = heap.data
    var left = idx*2+1
    var right = left + 1
    for right < heap.Size() {
        //左右子节点的较小
        min := left
        if data[right] < data[left] {
            min = right
        }
        if data[min] >= data[idx] {
            return
        }
        data[min], data[idx] = data[idx], data[min]
        idx = min
    }
}

func (head *Heap) Pop() int{
    head.data[0]
}

func (heap *Heap) Size() int{
    return len(heap.data)
}

//算了，太麻烦了，上面的小根堆的实现应该没什么问题，但是下面的改动比较多
func smallestRange(nums [][]int) []int {
    type Node struct{
        i int
        j int
    }
    var heap = &Heap{}
    for i := 0; i < len(nums); i++ {
        heap.Push(&Node{i : i, j : 0})
    }
    var res = []int{math.MaxInt32, math.MinInt32}
    for  {
        
    }
}