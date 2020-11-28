# Deserialization and the Visitor Pattern

## Scenario

Suppose we have two services that communicate with each other through a messaging system.
- Service A is the producer of the message
- Service B is the consumer of the message

Service A sends different messages, let's call them "events" that indicate some simple CRUD operations
on some users.

Service B should receive this messages and perform some operations based on the given events.

The type of events can be:
- create user
- delete user
- update user ..... and the list can go on

The simple architecture of this scenario can be seen bellow:

![simple-architecture](./simple-messaging.png)

### The problem



