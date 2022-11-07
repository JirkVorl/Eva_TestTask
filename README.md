So, i will start from the beginning.
I have used Spring Boot to do this task.
Also using clean Hibernate to work with database. I could use JPA, but i think it would be redundant.
Using MySQL instead of PostgreSQL just because i am having it installed, but it is easy to reconfigure it to Postgre (just change driver at application.properties)
So, starting from DataInitializer.class. I am using @PostConstrunct annotation with method inject() to insert some test data to database. I am also using create-drop Hibernate
property, so i am having new database every time the app starts.
SecurityConfiguration.class needs to disable spring security module.
All main implementation is stored inside FilterController.class. The solution is definitely not having great optimisation, because i am not allowed to use SQL features.
So, i am collecting all the data from DB, and than filtering it with .stream. Tomcat is not allowing us to have some special chars in @RequestParam, so i had to allow it
manually in application.properties. I`m using .parallelStream to improve performance a little.
I am also using product DTO as a return type, because returning hibernate entity is a bad practice. There is a mapper to make DTO out of model.
Next you can also see some kind of 3-tier architecture: DAO layer -> Service layer -> Controller layer.