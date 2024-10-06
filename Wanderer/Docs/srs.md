# SRS Wanderer

## Overview
As part of the PRD, one of the step is to read from books and convert to  text. The text has to filtered out to be remove
articles, the text later will bed attached scores based on the length of the word and forward to other sinks.
Each page of the book will have a page score with respect how many even length words are present , if and when such words
are same total word count will be present and if when total words match , page number will be considered for the purpose
of scoring.

The scoring mechanisms is not planned to be decoupled as the scope of different types of scoring is not clear at this instant.

## Functional
- Only PDF books are to be accepted for processing.
- The pdf books are to be present as a single http/https link per book.
- All the books are expected to be in english

## Non-Functional
- To facilitate the functionalities, a new java project `Wanderer` will be developed
- Able to understand the time taken to process each book
- The book is expected to be processed in less than half an hour (< 30 mins)
- The expected load is based on the revenue goal
    - Each user max income potential : (0.01 + (0.001*10000)) * 100 = 1001 dollars
    - 1mil/ 1001 = 999.000999 ~ 1000 such users per month
    - 1000/30 ~ 34 such books per day
    - Since each book may not have 10000 page , a more real world approach would be to consider ~1000 page per book
    - 1mil/(((0.01 + (0.001*1000)) * 100)*30) ~ 331 per day

## Risk
There are two forms of risk for this project
1. Most of the technologies are new to the team in terms of language and implementation
2. The processing time of < 30 mins is not derived metric rather it is a perceived metric with respect to human behaviour.
   The team is not sure if technology can support such use-cases
3. Developing both batch and streaming pipeline in the same project is feasible is unknown to the team.


## Capacity Planning
The following team is planned to implement this

| Profile       | Count |
|---------------|-------|
| Data engineer | 1     |
