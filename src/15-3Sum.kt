// Brute Force - doesn't finish
fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()
    val answer = hashSetOf<List<Int>>()
    nums.forEachIndexed i@{ i, iVal ->
        nums.forEachIndexed j@{ j, jVal ->
            if (j == i) return@j
            nums.forEachIndexed k@{ k, kVal ->
                if (k == i || k == j) return@k
                if (iVal + jVal == -kVal) answer.add(listOf(iVal, jVal, kVal).sorted())
            }
        }
    }
    return answer.toList()
}

// Better than brute force, still time out
fun threeSum2(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()
    val answer = hashSetOf<List<Int>>()
    val hashMap = hashMapOf<Int, List<Int>>()
    nums.forEachIndexed { index, num ->
        hashMap[num] = hashMap.getOrDefault(num, listOf()) + listOf(index)
    }
    nums.forEachIndexed i@{ i, iVal ->
        nums.forEachIndexed j@{ j, jVal ->
            if (j <= i) return@j
            val kVal = -(iVal + jVal)
            val k = hashMap[kVal] ?: return@j
            if (k.toMutableList().apply { remove(i); remove(j); }.size != 0) {
                answer.add(listOf(iVal, jVal, kVal))
            }
        }
    }
    return answer.toList()
}

fun threeSum3(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()
    val answer = hashSetOf<List<Int>>()
    nums.sort()

    for (i in 0..<nums.size - 2) {
        var (middle, end) = i + 1 to nums.lastIndex
        while (middle < end) {
            val sum = nums[i] + nums[middle] + nums[end]
            if (sum == 0) {
                answer.add(listOf(nums[i], nums[middle], nums[end]))
                middle++
                end--
                while (middle < end && nums[middle - 1] == nums[middle]) middle++
                while (middle < end && nums[end] == nums[end + 1]) end--
            } else if (sum < 0) middle++
            else end--
        }
    }
    return answer.toList()
}
