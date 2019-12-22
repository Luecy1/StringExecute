import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtTest {

    @Test
    fun StringExecuteTest() {

        // only mac or linux
        val expect = "hello world\n"
        val actual = "echo hello world".execute()

        assertEquals(expect, actual)
    }
}