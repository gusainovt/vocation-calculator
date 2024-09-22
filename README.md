## Приложение "Калькулятор отпускных"

Это микросервис, разработанный на базе Spring Boot и Java 11, предназначенный для расчета суммы отпускных, которые должен получить сотрудник. 

Микросервис принимает следующие входные параметры через GET запрос:

- **Средняя зарплата** за последние 12 месяцев (числовое значение).
- **Количество дней отпуска** (числовое значение).

На основе этих данных приложение рассчитывает сумму отпускных.


При запросе также можно указать:

- **Точные дни ухода в отпуск**. В этом случае расчёт отпускных будет выполнен с учётом праздничных и выходных дней.

### API

- **GET** `/calculate`

#### Параметры запроса:
- `averageSalary`: средняя зарплата за последние 12 месяцев (обязательный, числовой).
- `vacationDays`: количество дней отпуска (обязательный, числовой).
- `startDate`: дата начала отпуска (необязательный, формат: YYYY-MM-DD).
- `endDate`: дата окончания отпуска (необязательный, формат: YYYY-MM-DD).

#### Пример запроса:

  GET /calculate?averageSalary=50000&vacationDays=10&startDate=2023-06-01&endDate=2023-06-10
  

### Пример ответа

16666.67

### Запуск приложения

Для запуска приложения необходимо:

1. Установить JDK и Maven.
2. Клонировать репозиторий.
3. Перейти в директорию проекта и запустить команду:

`mvn spring-boot:run`
   
После этого приложение будет доступно на `http://localhost:8080`.
