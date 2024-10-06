# Worden
## Problem statement

### Revenue Brief
Consider an AI company, Worden, that provides data to a chatbot. Worden focus on providing rich data for chat-box
to train. The company is expected to generate around 1M per month and as part of the offering the following prices
are to be charged to customers. The pricing is divide into 2 separate categories, Processing and Reading.

### Processing Charges

| Charge Type  | Price                 | Description                                                                                            | Limits                     | 
|--------------|-----------------------|--------------------------------------------------------------------------------------------------------|----------------------------|
| Book Process | 0.01 Dollar per  book | Charge price to customer for processing each book, this is a flat price irrespective of the book type. | 100 Books per user per day |
| Page Process | 0.001 Dollar per page | Each book will be charge at 0.01 per page irrespective of number of words per page                     | 10000 pages per book       |
| Word Process | 0                     | There is no charge for processing of word                                                              | 3000 words per page        |
| Book Score   | 0                     | There is no charge for processing of book score                                                        | NA                         |
| Page Score   | 0                     | There is no charge for processing of book score                                                        | NA                         |
| Word Score   | 0                     | There is no charge for processing of book score                                                        | NA                         |

### Reading Charges

| Charge Type  | Write                  | Description                                             | Limits    |
|--------------|------------------------|---------------------------------------------------------|-----------|
| Read of page | 0.0001 Dollar per read | For each read of score for a page and word information  | No limit  |
