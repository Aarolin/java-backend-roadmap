# Git and GitHub basics

## Core terms

- Git:
- GitHub:
- Repository:
- Working tree:
- Staging area:
- Commit:
- Branch:
- Remote:
- Origin:
- Push:
- Clone:
- SSH:

## Change flow

```text
Working tree
    -> git add
Staging area
    -> git commit
Local repository
    -> git push
GitHub repository
```

## Глобальные настройки
| Command                                       | Meaning |
| --------------------------------------------- | ------- |
| `git config --global user.name "..."`         | Установить имя пользователя в настройки. В сделанных изменениях будет отображаться это имя. |
| `git config --global user.email "..."`        | Установить email для пользователя в настройки.        |
| `git config --global init.defaultBranch main` | Установить имя main для ветки по умолчанию.        |
| `git config --global core.autocrlf true`      |         |


## Ежедневные команды
| Command               | Meaning |
| --------------------- | ------- |
| `git status`          |         |
| `git add <path>`      |         |
| `git diff`            |         |
| `git diff --cached`   |         |
| `git commit -m "..."` |         |
| `git log --oneline`   |         |
| `git switch <branch>` |         |
| `git push`            |         |
| `git pull`            |         |
| `git clone <url>`     |         |


## Проблемы и решения
| Problem | Cause | Fix |
| ------- | ----- | --- |
|         |       |     |


## Мои объяснения
1. Разница между git add и git commit: команда git add добавляет текущее состояние указанных файлов в область подготовленных изменений.
Команда git commit это как подтверждение нужных нам изменений, которые мы до этого добавляли в область.
2. Разница между commit и push: commit фиксирует изменения локально на компьютере. Push отправляет изменений в удаленный репозиторий.
3. Разница между Git и Github: Git - система контроля версий, которая позволяет отслеживать изменения файлов и быстро возвращаться к нужным версиям при необходимости.
Github - интернет-сервис для хранения Git репозиториев.
4. Разница между различными ветками (например main и feature): ветка - это отдельная последовательность commit'ов (принятых изменений). Разные ветки помогают разделить
изменения, которые должны попасть в рабочую версию репозитория, и предположим, в тестовую.
