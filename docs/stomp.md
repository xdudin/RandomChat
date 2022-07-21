# STOMP

stomp api over websocket. Connection is established in two steps -
create websocket session via `connect` and subscribe to incoming messages
via `subscribe`

## connect

create a connection to server

endpoint

```text
/connect
```

## subscribe

subscribe to incoming messages

endpoint

```text
/user/dialog
```

## create a user

After the request about user creation is sent, user is added to `userPool`and will be there
until corresponding new user will create a pair. When pair will be created, `dialog`
is created, and you will receive a response message with `chatUUID` and `senderUUID`.
SenderUUID is the final UUID of the user and can not be changed.

endpoint

```text
/start
```

outgoing message

```json
{
  "name": "Bob",
  "languageCode": "ru",
  "userAttributes": {
    "gender": "male",
    "age": null
  },
  "targetAttributes": {
    "gender": "female",
    "age": null
  }
}
```

incoming message

| eventCode | meaning      |
|-----------|--------------|
| 10        | user created |
| 11        | `reserved`   |

```json
{
  "chatUUID": "f7e0bef0-9544-4713-9fbd-d01be302e778",
  "senderUUID": "a337225c-0413-4260-8971-b08d922518d5",
  "eventCode": 10,
  "serviceContent": null,
  "content": null
}
```

## send message

endpoint

```text
/message
```

outgoing message

```json
{
  "chatUUID": "f7e0bef0-9544-4713-9fbd-d01be302e778",
  "senderUUID": "a337225c-0413-4260-8971-b08d922518d5",
  "content": "hello"
}
```

incoming message

| eventCode | meaning      |
|-----------|--------------|
| 20        | message sent |
| 21        | `reserved`   |

```json
{
  "chatUUID": "f7e0bef0-9544-4713-9fbd-d01be302e778",
  "senderUUID": "a337225c-0413-4260-8971-b08d922518d5",
  "eventCode": 20,
  "serviceContent": null,
  "content": "hello"
}
```

## end dialog

endpoint

```text
/stop
```

outgoing message

```json
{
  "chatUUID": "f7e0bef0-9544-4713-9fbd-d01be302e778",
  "senderUUID": "a337225c-0413-4260-8971-b08d922518d5",
  "content": null
}
```

incoming message

| eventCode | meaning           |
|-----------|-------------------|
| 30        | user exits dialog |
| 31        | `reserved`        |

```json
{
  "chatUUID": "f7e0bef0-9544-4713-9fbd-d01be302e778",
  "senderUUID": "a337225c-0413-4260-8971-b08d922518d5",
  "eventCode": 30,
  "serviceContent": null,
  "content": null
}
```
