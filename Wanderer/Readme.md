# Project
This is the `Wanderer` Project

# Docs
1. [SRS](Docs/srs.md)
2. [HLD / System Design](Docs/system.md)
3. [LLD / Application Design](Docs/application.md)

# Project setup

## Reader pipeline
The execution of the java application follows a profile based approach.

1. To run using direct runner using local
```
mvn clean compile exec:java -Preader-local
```



## Processor pipeline
The execution of the java application follows a profile based approach.

1. To run using direct runner using local
```
mvn clean compile exec:java -Pprocessor-local
```
