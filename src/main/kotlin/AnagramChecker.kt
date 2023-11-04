object AnagramChecker {
    fun checkTexts(text1: String, text2: String): Boolean {
        if (text1.length != text2.length) {
            return false
        }

        val occurrencesMap = HashMap<Char, Int>()

        text1.forEach {
            occurrencesMap[it] = occurrencesMap.getOrDefault(it, 0) + 1
        }

        text2.forEach {
            occurrencesMap[it] = occurrencesMap.getOrDefault(it, 0) - 1
        }

        return occurrencesMap.values.all {
            it == 0
        }
    }
}