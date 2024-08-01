import kotlin.math.abs

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val zeros = mutableListOf<Pair<Int, Int>>()
    mat.forEachIndexed { row, ints ->
        ints.forEachIndexed { col, i ->
            if (i == 0) zeros.add(row to col)
        }
    }

    mat.forEachIndexed { row, ints ->
        ints.forEachIndexed { col, i ->
            mat[row][col] = if (i == 0) 0 else zeros.minOf { (zRow, zCol) -> abs(zRow - row) + abs(zCol - col) }
        }
    }
    return mat
}

fun updateMatrix2(mat: Array<IntArray>): Array<IntArray> {
    val zeros = mutableListOf<Pair<Int, Int>>()
    mat.forEachIndexed { row, ints ->
        ints.forEachIndexed { col, i ->
            if (i == 0) zeros.add(row to col) else mat[row][col] = -1
        }
    }
    var distance = 1
    while (zeros.isNotEmpty()) {
        var count = zeros.size
        while (count > 0) {
            val (row, col) = zeros.removeFirst()
            directions.forEach { (r, c) ->
                if (mat.getOrNull(row + r)?.getOrNull(col + c) == -1) {
                    mat[row + r][col + c] = distance
                    zeros.add(row + r to col + c)
                }
            }
            count--
        }
        distance++
    }
    return mat
}
