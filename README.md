# Yandex.Praktikum Diploma

## Project 2. "Stellar Burgers"

A set of automated API tests for ["Stellar Burgers"](https://stellarburgers.nomoreparties.site/).
Project's API documentation is
available [here](https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf)
.

Postman-collection, used while working on the project:
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/fa154c26896755bdc193?action=collection%2Fimport#?env%5Byandex_praktikum%5D=W3sia2V5IjoiY291cmllcklkIiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiYW55Iiwic2Vzc2lvblZhbHVlIjoibnVsbCIsInNlc3Npb25JbmRleCI6MH0seyJrZXkiOiJsb2dpbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IkpvaG5Eb2VfZWppaWFoZyIsInNlc3Npb25JbmRleCI6MX0seyJrZXkiOiJvcmRlcklkIiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6IiIsInNlc3Npb25JbmRleCI6Mn0seyJrZXkiOiJhY2Nlc3NUb2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IkJlYXJlci4uLiIsInNlc3Npb25JbmRleCI6M30seyJrZXkiOiJyZWZyZXNoVG9rZW4iLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJhbnkiLCJzZXNzaW9uVmFsdWUiOiI5ZDgwNjA3Yzg2Y2NmMTYzMGI5ODFkMjAzODA2MmU1NzI1ZTFkNjQwMjlmMzhiZmU4OTdlNGVjMDllNThiNDYxYTUyNmRhZjNkNDdmOTg5YyIsInNlc3Npb25JbmRleCI6NH0seyJrZXkiOiJ0aW1lIiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiYW55Iiwic2Vzc2lvblZhbHVlIjoiMjAyMi0xMi0xMlQxMjowMTowMi4wMDArMDE6MDAiLCJzZXNzaW9uSW5kZXgiOjV9XQ==)

## Project's Contents

Project consits of 2 main parts:

1. main/java/* - set of packages describing API and data models used for the web application.
2. test/java/* - set of test cases, also utility methods to simplify test data generation and cleaning after test
   execution.

### Test Scenarios

* Test scenarios were prepared according to the task
  description [here](https://practicum.yandex.ru/learn/qa-automation-engineer-java/courses/5c87a15a-37d9-4d06-8e7d-3ebe49aba2fb/sprints/48437/topics/7ec6ef07-a3d5-4923-a8ac-64313ac438e1/lessons/311b7751-0b28-438a-adb4-732ca7080912/)

## Tests Execution

Local environment preparation instruction is shared below.

### Prerequisites

Prepare local environment according to the
guide: ["Local development env"](https://practicum.yandex.ru/learn/qa-automation-engineer-java/courses/e2bf18c2-97c5-43f8-af20-80c52142e6f2/sprints/16356/topics/a1b6de5a-dd0d-418b-97ea-02258aa40b07/lessons/054c3a94-f4ee-46a4-8a5b-b5d373b9ada3/)
Download the project, store in local repository and execute, using IDE IntelliJ IDEA:

* `mvn clean test`
* `mvn allure:serve`

## Author

* **Artem Kot**

## Acknowledgment

* Thanks to QA_JAVA_12 telegram channel, mentors and students from Yandex Praktikum AQA course. 
