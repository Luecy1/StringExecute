import java.io.BufferedReader
import java.io.File
import java.io.IOException

internal val currentDir by lazy { File(System.getProperty("user.dir")) }

fun String.execute(
    workingDir: File = currentDir,
    environmentMap: Map<out String, String>? = null
): String = try {
    val parts = this.split("\\s+".toRegex())
    val processBuilder = ProcessBuilder(parts)

    val environment = processBuilder.environment()

    // set environment variant
    environmentMap?.let { environment.putAll(it) }

    val proc = processBuilder
        .directory(workingDir)
        .redirectErrorStream(true)
        .start()

    val text = proc.inputStream.bufferedReader().use(BufferedReader::readText)
    text
} catch (e: IOException) {
    throw ExecuteException(e)
}

internal class ExecuteException(e: Exception) : RuntimeException(e)