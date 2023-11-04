import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AnagramCheckerTest {

    @Test
    fun `should return true for two anagram texts`() {
        assertEquals(AnagramChecker.checkTexts("morhaf", "forham"), true)
    }

    @Test
    fun `should return false for non anagram texts`() {
        assertEquals(AnagramChecker.checkTexts("morhaf", "korham"), false)
    }
}