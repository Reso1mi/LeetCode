func setZeroes(matrix [][]int)  {
    r, c := false, false
    for j := 0; j < len(matrix[0]); j++{
        if matrix[0][j] == 0{
            r = true
            break
        }
    }
    for i := 0; i < len(matrix); i++{
        if matrix[i][0] == 0{
            c = true
            break
        }
    }
    for i :=1; i < len(matrix); i++{
        for j := 1; j < len(matrix[0]); j++{
            if matrix[i][j] == 0{
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }
    for j :=1; j < len(matrix[0]); j++{
        if matrix[0][j] == 0{
            for i :=0; i < len(matrix);i++{
                matrix[i][j] = 0
            }
        }
    }
    for i :=1; i < len(matrix); i++{
        if matrix[i][0] == 0{
            for j :=0; j < len(matrix[0]); j++{
                matrix[i][j] = 0   
            }
        }
    }
    if r {
        for j :=0; j < len(matrix[0]); j++{
            matrix[0][j] = 0
        }
    }
    if c {
        for i :=0; i < len(matrix); i++{
            matrix[i][0] = 0
        }
    }
}