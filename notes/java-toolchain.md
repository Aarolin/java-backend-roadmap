# Java toolchain notes

## Installed versions

```text

java -version:
Команда показывает версию JVM (JVM запускает скомпилированный компилятором javac файл)
openjdk version "25.0.3" 2026-04-21 LTS
OpenJDK Runtime Environment Temurin-25.0.3+9 (build 25.0.3+9-LTS)
OpenJDK 64-Bit Server VM Temurin-25.0.3+9 (build 25.0.3+9-LTS, mixed mode, sharing)


javac -version:
Команда показывает версию компилятора java.
javac 25.0.3

JDK:
Набор инструментов разработчика. Содержит в себе JVM, JRE (среда для запуска приложений на java), компилятор и др.

JAVA_HOME:
переменная, указывающая на корневую папку установленного JDK. Её используют Maven, Gradle, IDE и другие Java-инструменты.

PATH:
список папок, в которых командная оболочка ищет исполняемые файлы вроде java.exe и javac.exe.
```

```text
IntelliJ IDEA setup
Project SDK: 25 Eclipse Temurin 25.0.3
Language level: SDK default
Source root: Правый клик на папку -> Mark Directory As -> Source root
How I run the app: Найти на верхней панели команду со значком 'Play' или воспользоваться комбинацией клавиш Shift+F10
How I debug the app: Найти на верхней панели команду со значком жука или воспользоваться комбинацией клавиш Shift+F9
```
```text
| Действие              | Значение |
| ------------------- | ------- |
| Breakpoint          | Точка останова. Останавливает выполнение кода в указанном месте.        |
| Step Over           | Продолжить выполнение кода до следующей строки, не проваливаясь внутрь функций.        |
| Step Into           | Зайти внутрь вызываемого метода.        |
| Step Out            | Выйти из текущего методв.        |
| Resume              | Продолжить выполнение кода до следующей точки останова, либо до конца, если больше нет установленных точек.        |
| Evaluate Expression | Вычисляет произвольное выражение.        |
| Watch               | Закрепить выражение или переменные для дальнейшего наблюдения.        |
```

```text
# My summary
Как запустить файл .java:
1. Сначала его нужно скомпилировать командой javac. `javac` скомпилирует исходный `.java`-файл в `.class`-файл, содержащий Java bytecode.
2. Команда `java` запускает JVM, которая загружает нужный класс и вызывает его метод `main`.

# Частые ошибки сегодня

## Ошибка 1. `java` работает, а `javac` нет

Обычно это значит, что установлен JRE, а не JDK, или `PATH` указывает не туда.

Проверка:
```

```bash
javac -version
```

```text
Ошибка 2. IntelliJ использует не тот JDK

Симптом: в терминале Java 25, а в IntelliJ проект открыт с Java 17/21 или вообще без SDK.

Исправление:
File -> Project Structure -> Project -> SDK -> JDK 25

Ошибка 3. Could not find or load main class

Чаще всего причина одна из этих:
не из той папки запускаешь;

неверный -cp out;

пакет package com.roadmap.debug; не совпадает с папками;
класс не скомпилировался в out.
Правильный запуск из корня проекта:
java -cp out com.roadmap.debug.DebugPlayground
Не так:
java DebugPlayground
Потому что у класса есть package:
package com.roadmap.debug;

Ошибка 4. JAVA_HOME указывает на bin

Неправильно:

JAVA_HOME=/path/to/jdk/bin

Правильно:

JAVA_HOME=/path/to/jdk

Проверь:

ты запустил именно Debug, не Run;
breakpoint стоит на исполняемой строке;
код реально доходит до этой строки;

breakpoint не disabled.
```