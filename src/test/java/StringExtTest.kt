import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class StringExtTest {

    @Test
    fun StringExecuteTest() {
        // only mac or linux
        val expect = "200"
        val actual = "curl -LI http://example.com -o /dev/null -w %{http_code} -s".execute()

        assertEquals(expect, actual)
    }

    @Test
    fun StringExecuteTest2() {
        // only mac or linux
        val expect = System.getProperty("user.home")
        val currentDirectory = File(expect)
        val actual = "pwd -L".execute(currentDirectory)

        assertEquals(expect + "\n", actual)
    }

    @Test
    fun StringExecuteTest3() {
        // only mac or linux
        val expect = "hogehoge\n"
        val environmentMap = mapOf("TEST" to "hogehoge")
        val actual = "./src/test/resources/EchoVariant.sh \$PATH"
            .execute(environmentMap = environmentMap)

        assertEquals(expect, actual)
    }
}