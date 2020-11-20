# money-formatter-be

## How to run application:
1. Clone the repository
1. Launch server by running main from src/main/kotlin/MoneyFormatterServer.kt

## How to run tests:
1. Have Kotest plugin installed
2. Just launch any test you want through UI or terminal

## Why http4k?
It is lightweight, with great testability potential, and everything in it is function.

## Tests
As testing framework I used Kotest because it allows writing BDD like tests
with minimal effort. This way tests become executable requirements that are
always up-to-date. And it supports property based testing from box. For
better understanding of property based testing please see https://kotest.io/property_testing/

###Unit tests
Are property based tests. I was going to use BigDecimal generator from Kotest,
but got NumberFormatException while checking its edgecases. It converts double
edge cases to BigDecimal and fails on Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY.
That's why I wrote myBigDecimals that could be found in Arbs.kt

###Functional tests
Are tests on app level which is httphandler, function that accepts Request and returns Response.

###End-to-end tests
Just for testing that end-point is properly wired.
