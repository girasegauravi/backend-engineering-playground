## Quick Notes: Mini Kafka Concept

* Kafka is not just a traditional queue.

    * It is better understood as a **distributed append-only log**.
    * Messages are appended to partitions and retained for a configured duration.

* Kafka is used for asynchronous communication.

    * Producers send events to Kafka.
    * Consumers read events later at their own speed.
    * This decouples producer services from consumer services.

* Messages are not immediately deleted after consumption.

    * In a traditional queue, a message is usually removed after a consumer reads it.
    * In Kafka, messages remain in the log until retention expires.
    * This allows replay, debugging, reprocessing, and multiple independent consumers.

* Each message has an offset.

    * Offset is the position of a message inside a partition.
    * Example:

      ```text
      Offset 0 -> OrderCreated
      Offset 1 -> OrderPaid
      Offset 2 -> OrderShipped
      ```
    * Consumers use offsets to know where to resume reading.

* Consumer offset represents progress.

    * Kafka stores messages.
    * The consumer group stores how much it has already processed.
    * This separation allows consumers to restart safely without always reading from the beginning.

* Consumers poll Kafka.

    * Kafka does not usually push messages to consumers.
    * Consumers repeatedly ask Kafka for new messages using a polling loop.
    * Example:

      ```java
      while (true) {
          consumer.poll(...);
      }
      ```

* Consumer groups provide scalable consumption.

    * A consumer group is a logical group of consumers working together.
    * Each partition is assigned to only one active consumer inside the same group.
    * This allows parallel processing while preserving ordering inside each partition.

* One partition can have only one active consumer inside a consumer group.

    * This prevents multiple consumers from processing the same ordered log concurrently.
    * It protects ordering and simplifies offset ownership.

* Maximum parallelism is limited by partition count.

    * If a topic has 3 partitions, at most 3 consumers in the same consumer group can actively consume.
    * Extra consumers remain idle.
    * Therefore, partitions are the real scaling unit in Kafka.

* Kafka guarantees ordering only within a partition.

    * It does not guarantee global ordering across all partitions.
    * If ordering is required for a business entity, all events for that entity should go to the same partition.

* Partition key decides where a message goes.

    * Example:

      ```java
      partition = hash(customerId) % numberOfPartitions;
      ```
    * This ensures all events for the same customer go to the same partition.

* Partitioning by business key preserves entity-level ordering.

    * Example:

      ```text
      Customer A:
      OrderCreated -> OrderPaid -> OrderShipped
      ```
    * If all these events go to the same partition, Kafka preserves their order.

* Random partitioning improves distribution but loses ordering.

    * If related events are spread across multiple partitions, different consumers may process them out of order.
    * This can break workflows such as payment, order lifecycle, wallet updates, or execution state transitions.

* Hot partitions can happen.

    * If one customer/account/order generates very high traffic, all events for that key go to one partition.
    * This creates a hot partition.
    * Symptoms include consumer lag, high CPU on one consumer, backpressure, and uneven load distribution.

* Splitting a hot key improves throughput but weakens ordering.

    * Spreading one customer’s events across multiple partitions improves load distribution.
    * But Kafka no longer guarantees strict ordering for that customer.
    * This is a design tradeoff between correctness and scalability.

* Commit timing affects delivery guarantees.

    * If offset is committed before processing, message loss is possible.
    * If offset is committed after processing, duplicate processing is possible.

* At-most-once processing:

    * Flow:

      ```text
      Read -> Commit Offset -> Process
      ```
    * If the consumer crashes after committing but before processing, the message is lost.
    * No duplicates, but possible data loss.

* At-least-once processing:

    * Flow:

      ```text
      Read -> Process -> Commit Offset
      ```
    * If the consumer crashes after processing but before committing, the message is processed again.
    * No message loss, but duplicates are possible.

* Most production systems prefer at-least-once processing.

    * It is safer to process a message twice and handle duplicates than to lose a critical event permanently.
    * This is especially important for payments, orders, ledger systems, workflow execution, and audit trails.

* Idempotency is required with at-least-once delivery.

    * Since duplicate processing is possible, consumers should safely handle repeated messages.
    * Common techniques:

        * idempotency key
        * transaction ID
        * processed event table
        * deduplication store
        * unique constraint in database

* Exactly-once processing is hard.

    * Kafka supports exactly-once semantics within Kafka transactions.
    * But once external systems like databases, APIs, or payment gateways are involved, the application must still handle idempotency and consistency carefully.

* Kafka separates storage from processing progress.

    * Kafka owns the durable message log.
    * Consumer groups own progress using offsets.
    * This separation enables replay, independent consumers, retries, and recovery.



* Core mental model:

  ```text
  Producer
      -> Topic
          -> Partitions
              -> Append-only ordered log
                  -> Consumer Group
                      -> Consumer reads using offset
  ```

* Summary:

  > Kafka is a distributed append-only log used for asynchronous event streaming. It stores messages in partitioned logs, tracks consumer progress using offsets, preserves ordering within a partition, and enables scalable consumption through consumer groups. The main tradeoffs are ordering versus parallelism, and at-least-once reliability versus duplicate handling.
