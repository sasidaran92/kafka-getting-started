# kafka-getting-started



## Kafka Commands

cd C:\kafka

#### Start Zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

#### Start Kafka broker
.\bin\windows\kafka-server-start.bat .\config\server.properties

#### Create Topic
.\bin\windows\kafka-topics.bat --create --topic my_topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1

#### List topics
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

#### Describe topics
.\bin\windows\kafka-topics.bat --describe --topic my_topic --bootstrap-server localhost:9092

#### Console Producer
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my_topic

#### Console consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my_topic --from-beginning


### Cluster

#### server.properties fields to be updated
broker.id=2
listeners=PLAINTEXT://:9093
log.dirs=/tmp/kafka-logs-2

#### broker -1
.\bin\windows\kafka-server-start.bat .\config\server-1.properties

#### broker-2
.\bin\windows\kafka-server-start.bat .\config\server-2.properties

#### broker-3
.\bin\windows\kafka-server-start.bat .\config\server-3.properties

#### topic
.\bin\windows\kafka-topics.bat --create --topic my_topic_cluster --bootstrap-server localhost:9092 --replication-factor 3 --partitions 1

#### Describe
.\bin\windows\kafka-topics.bat --describe --topic my_topic_cluster --bootstrap-server localhost:9092

#### Producer
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic my_topic_cluster

#### Consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my_topic_cluster --from-beginning



### Cluster Java
.\bin\windows\kafka-topics.bat --create --topic my_topic_cluster_java --bootstrap-server localhost:9092 --replication-factor 3 --partitions 3

#### Consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092,loaclhost:9093 --topic my_topic_cluster_java --from-beginning

#### Alter Partition
.\bin\windows\kafka-topics.bat --alter --topic my_topic_cluster_java --partitions 4 --bootstrap-server localhost:9092
