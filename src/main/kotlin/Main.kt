fun main() {
    val anagramsMap = HashMap<String, Set<String>>()
    runChecker(anagramsMap)
    displayOptions()
    var answer = readln()
    while (answer != "3") {
        println(anagramsMap)
        when (answer) {
            "1" -> runChecker(anagramsMap)
            "2" -> runAnagramsExtractor(anagramsMap)
            else -> println("Unknown option!")
        }
        displayOptions()
        answer = readln()
    }
}

private fun displayOptions() {
    println(
        """
        ------------------------------------    
        Please choose one of these options:
        1) Check another texts
        2) Get anagrams for a given string
        3) Exit
    """.trimIndent()
    )
}

private fun runAnagramsExtractor(anagramsMap: HashMap<String, Set<String>>) {
    println("Please type the text to get all the anagrams")
    val text = readln()
    println(anagramsMap.getOrElse(text) { "No anagrams found :(" })
}

private fun runChecker(anagramsMap: HashMap<String, Set<String>>): Boolean {
    println("Please type the 1st text")
    val text1 = readln().trim()
    println("Please type the 2nd text")
    val text2 = readln().trim()

    return AnagramChecker.checkTexts(text1, text2).also {
        if (it) {
            anagramsMap[text1] = anagramsMap.getOrDefault(text1, emptySet()).plus(text2)
            anagramsMap[text2] = anagramsMap.getOrDefault(text2, emptySet()).plus(text1)
            println("The two texts are anagrams of each other")
        } else {
            println("The two texts are NOT anagrams of each other")
        }
    }
}