# Maven basics

## Installed version

```text
mvn -v:
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
Maven home: C:\Program Files\apache-maven-3.9.16-bin\apache-maven-3.9.16
Java version: 25.0.3, vendor: Eclipse Adoptium, runtime: C:\Program Files\Eclipse Adoptium\jdk-25.0.3.9-hotspot
Default locale: ru_RU, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"

where.exe mvn:
C:\Program Files\apache-maven-3.9.16-bin\apache-maven-3.9.16\bin\mvn
C:\Program Files\apache-maven-3.9.16-bin\apache-maven-3.9.16\bin\mvn.cmd
```

## Core terms
```text
Maven: инструмент сборки и управления Java-проектом.
Build: процесс превращения исходников проекта в проверенный результат.
POM: Project Object Model. Представляет собой файл xml.
Maven coordinates: координаты артефакта.
groupId: Название группы, компании, пространства имен и т.д.
artifactId: Название проекта.
version: Версия проекта.
SNAPSHOT: Слово - договоренность о том, что версия с таким названием не является релизом.
Artifact: результат сборки или библиотека, которой управляет Maven.
Dependency: внешняя библиотека, которая нужна проекту.
Plugin: расширение Maven, которое выполняет конкретную работу.
Goal: конкретная задача Maven plugin.
Phase: стадия жизненного цикла Maven.
Lifecycle: цепочка фаз сборки.
Local repository: локальный кэш Maven на компьютере.
Remote repository: удалённое хранилище Maven artifacts.
Maven Central: хранит опубликованные Java-библиотеки.
target: папка, куда Maven складывает результаты сборки.
Maven Wrapper: набор файлов внутри проекта, который позволяет запускать Maven без предварительной глобальной установки Maven на компьютере пользователя.
```

## Standard Maven project structure
| Path                 | Purpose |
| -------------------- | ------- |
| `pom.xml`            | Лежит в корне проекта. Описывает: имя проекта, версию, Java версию, зависимости, плагины, правила сборки.        |
| `src/main/java`      | Каталог, который содержит исходный код проекта.        |
| `src/main/resources` |         |
| `src/test/java`      | Каталог, в котором лежит код для тестирования проекта.        |
| `target`             | Каталог, в который Maven кладет результаты сборки проекта.        |

## My project coordinates
```text
groupId: com.roadmap
artifactId: sandbox-maven-basics
version: 1.0.0-SNAPSHOT
packaging: jar
```

## Dependency used
```text
groupId: Группа, организация или namespace.
artifactId: Имя проекта.
version: Версия проекта.
why it is used: Вместе это называется координаты проекта. Maven упаковывает результаты сборки в файл с такими координатами.
where Maven downloaded it: Maven загружает это в каталог target. 
```


## Commands
| Command                                  | What it does | What changes on disk |
| ---------------------------------------- | ------------ | -------------------- |
| `mvn validate`                           | Проверяет что файлы проекта корректны и вся необходимая информация доступна.            | Ничего не меняет на диске.                     |
| `mvn compile`                            | Комплирует файлы исходного кода проекта.             | Появляется каталог target с файлами байткода.                     |
| `mvn compile exec:java`                  | Компилирует файлы исходного кода проекта и выполняет запуск метода main.             | Появляется каталог target с файлами байткода.                     |
| `mvn package`                            | Комплирует файлы исходного кода проекта, компилирует тесты, собирает ресурсы, и упаковывает результаты сборки в тип файла, указанный в packaging.             | Упаковывает все собранные файлы в тип файла, указанный в packaging, например в JAR.                     |
| `mvn clean`                              | Очищает результаты сборки.             | Удаляет папку target.                     |
| `mvn wrapper:wrapper -Dtype=only-script` | Добавляет Maven wrapper в проект. Maven wrapper - легкая версия Maven, которая может использоваться локально в одном проекте.            | Появляются файлы mvnw, mvnw.cmd и каталог .mvnw.                     |
| `.\mvnw.cmd clean package`               | Пересоздает сборку. Сначала происходит очищение предыдущих результатов, а затем сборка создается заново.             | Сначала удалется папка target, а затем создается заново с новыми результатами.                     |

## Manual javac vs Maven
| Problem | Cause | Fix |
| ------- | ----- | --- |
|         |       |     |

## My summary
Maven это инструмент, который управляет сборкой проекта.
Он не компилирует файлы сам, не проводит тестирование сам.
Работу выполняет с помощью других инструментов, например, компиляцию с помощью компилятора javac.
Использует заданную согласованную структуру проекта. Это позволяет брать одни и те же виды файлов из одних и тех же мест и добавлять результаты сборки в одни и те же места.
Настройка сборки происходит с помощью файла pom.xml.