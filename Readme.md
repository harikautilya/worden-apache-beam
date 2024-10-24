
# Repo structure 
This is mono repo that holds different project, the following will help in quickly grasping where is what

- Aurora: A monorepo for all frontend projects built on react js and turbo.
- Bouncer: A python project for user management built on django
- Foundation:  Pulumi code that holds the infrastructure in place.
- Foreman: A rust project that reads each user api usage and provide financial charges for each customer built on Axum/Actix. (not sure yet)
- Wanderer: A java project that holds the code for the apache-beam pipeline processing 
- Script:  A generalized scripts that used for the purpose of the project. Each script has its own use case
- Librarian: A Java service for book management built on spring boot


# Repo Description

This is showcase project to understand how dataflow and apache beam works. The project also introduces an effort towards
understand how company's revenue an d expectations are converted to technical software. In more realistic scenarios 
1. there are lot more process and lot more research goes into decision-making. 
2. There are more explanation for each product decision.

This project is simplified to just PRD and SRS to facilitate my need of learning. If any mistakes are found, please correct it by opening a PR . 

This project is developed to understand how to interact with the api and how to interface each application around the concepts of the apache beam technologies, spring boot. The project also focus on documentation of such use-cases as to how SRS, HLD and LLD designs are prepared to solve the use case. 
To facilitate this and having AI being the great interest in the recent time, Worden, a data company is imaginedand the following problem is described. 

`Imagined` being the keyword across all assumptions


Please read the docs in the following order to better understand the flow
1. [Company](Docs/company.md)
2. [Product](Docs/product.md)
3. [Software](Docs/software.md)
4. [Wanderer](Wanderer/Readme.md)


# Note 
There are some un-necessary steps i have taken to ensure i learn some additional feature/technologies. In a real world
I would change these decisions to ensure there is optimal design.

Here is the list
1. There is no specific need for `Processor` to be batch processing , making this streaming would make the feature more realtime
but i have taken it as batch to learn how pipeline options, etc. can change in terms batch design. Mostly I will make it streaming
in the upcoming workdays.


