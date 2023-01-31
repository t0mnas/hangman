import java.io.File

val hangman = listOf("""
    ----
    |  |
    |  O
    | /|\
    | / \
    |
    ------
""".trimIndent(), """
    ----
    |  |
    |  O
    | /|\
    | / 
    |
    ------
""".trimIndent(), """
    ----
    |  |
    |  O
    | /|\
    | 
    |
    ------
""".trimIndent(), """
    ----
    |  |
    |  O
    | /|
    | 
    |
    ------
""".trimIndent(), """
    ----
    |  |
    |  O
    | /
    | 
    |
    ------
""".trimIndent(), """
    ----
    |  |
    |  O
    | 
    |
    |
    ------
""".trimIndent(), """
    ----
    |  |
    |  
    | 
    | 
    |
    ------
""".trimIndent(), """
    ----
    |  
    | 
    | 
    | 
    |
    ------
""".trimIndent(), """
    
    | 
    | 
    | 
    | 
    |
    ------
""".trimIndent(),"""
    
    
    
    
    
    
    ------
""".trimIndent())

fun main() {
    val word = File("words.txt").readLines().random()
    var status = ".".repeat(word.length).toCharArray()
    var life = hangman.lastIndex

    while(String(status) != word && life > 0) {
        println(hangman[life])
        println(status)
        val input = readLine()!!

        if(input.length > 1) {
            if(input == word) status = input.toCharArray()
            else life--
        } else if(input in word) {
            word.forEachIndexed { index, c ->
                if(c in input) status[index] = c
            }
        } else life--
    }

    if(life > 0) println("Congratulations!")
    else println("Answer was $word")
}