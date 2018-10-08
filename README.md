# Landloop assignment

## First exercise:
Prerequisites:
* Use Jackson library for string/bytes to Json deserialization
* Scala 2.11/2.12 (Java is used in this implementation

Write a method "jsonToMap" which converts any json input to a scala Map while retaining the structure.
Therefore on a nested json it will end up with a Map-of-Maps.
```scala
def jsonToMap(json:InputStream):Map[String, Any]
```

## Second Exercise:
Create a REST application with a single endpoint: `POST /api/convert` Body:
```json
{
  "fromCurrency": "GBP",
  "toCurrency" : "EUR",
  "amount" : 102.6
}
```

The return should be an object with the exchange rate between the "fromCurrency" to "toCurrency" and the amount converted to the second curency.

```json
{
  "exchange" : 1.11,
  "amount" : 113.886,
  "original" : 102.6
}
```

The exchange rates should be dynamic and loaded from https://exchangeratesapi.io/api/latest on demand
