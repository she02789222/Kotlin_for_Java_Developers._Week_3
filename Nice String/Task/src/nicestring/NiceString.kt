package nicestring

fun String.isNice(): Boolean {
    var total = 0
    if (!this.contains("ba") && !this.contains("bu")
            && !this.contains("be")) {
        total++
    }

    val vowelList = listOf('a', 'e', 'i', 'o', 'u')
    var vowelCount = 0
    this.forEach { if(vowelList.contains(it)) vowelCount++}
    if(vowelCount >= 3) total++

    for(i in 0 until this.length - 1) {
        if(this[i] == this[i + 1]) {
            total++
            break
        }
    }

    return total >= 2
}