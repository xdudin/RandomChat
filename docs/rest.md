# REST

## get categories

request categories of language, gender and age with relevant ids

endpoint

```text
/categories
```

response

```json
{
  "language": [
    {
      "id": 1,
      "name": "English",
      "code": "en"
    }
  ],
  "gender": [
    {
      "id": 1,
      "gender": "male"
    }
  ],
  "age": [
    {
      "id": 1,
      "age": "14-18"
    }
  ]
}
```