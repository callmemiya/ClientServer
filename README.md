# Store

## Задача
Написать чат с помощью сокетов(данная реализация не использует многопоточное программирование).

## Запуск
Сначала запускается Server, далее FirstClient, далее SecondClient. 
Первым пишет FirstClient, далее отвечает SecondClient.
Данную программу можно запускать с помощью нескольких компьютеров, подключенных к одной Wi-fi сети.
Для этого необходимо на одном компьютере запустить Server и одного из клиентов, а на втором другого клиента
(написав при этом в программе последнего вместо "localhost" IP-адрес компьютера, на котором запущен сервер).