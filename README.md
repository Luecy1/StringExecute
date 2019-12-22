# StringExecute

## What's this?

This is Kotlin extension library.

Running command as "echo hello".execute()

## Usage

build.gradle repositories block add this

```
repositories {
    maven {
        url 'https://luecy1.github.io/StringExecute/repository'
    }
}
```

build.gradle dependencies block add this

```
dependencies {
    implementation 'com.github.luecy1:string_execute:1.0.0'
}
```

Finally, you can call execute method like this.

```

"echo hello".execute() // retuns "hello\n"


```


