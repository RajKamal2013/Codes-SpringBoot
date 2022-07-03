
# Spring JDBC 

### JPA
1. JPA stands for Java Persistence API (Application Programming Interface). 
2. Spring Boot JPA is a Java specification for managing relational data in 
Java applications. 
3. It allows us to access and persist data between Java object/ class and relational 
database. 
4. JPA follows Object-Relation Mapping (ORM). It is a set of interfaces.
5. It is used to examine, control, and persist data between Java objects and 
relational databases

### Starter JPA
1. JPA is the interface for the Hibernate framework. starter-data-jpa is used 
for Spring Data JPA with Hibernate.
2. The pom.xml file shows that it has a dependency on spring-boot-strater-aop, 
spring-boot-starter-jdbc, hibernate-core, and transaction-api.

### Spring Initializer
1. JDBC API for querying the database
2. H2 Database that supports JDBC API access
3. Spring Web for the web console offered by H2

### H2 Database
In-memory H2 database offers a web client for viewing the database.

### Important Things for JDBC
1. application.properties
2. schema.sql
3. data.sql
4. jdbc template
5. BeanPropertyRowMapper


### jdbctemplate
1. Spring JDBC makes talking to databases easy by eliminating the need for establishing 
a connection, handling expectations, and closing connections.
2. Spring provides a template class called JdbcTemplate to interact with databases 
which offers a wide array of methods to perform storage and retrieval of data.
3. The JdbcTemplate class hides all the boilerplate code for connection management 
and error handling whereby the developer can focus on the SQL query.
4. Using the Spring JdbcTemplate, a Java application can store and retrieve objects 
of a class to a table in the database.


When using Spring Boot, only one dependency (spring-boot-starter-jdbc) is needed in 
the pom.xml file as compared to multiple dependencies in Spring
(spring-context, spring-jdbc, etc.).

Spring Boot automatically initializes the datasource bean whereas it needs to be 
created using XML or Java configuration in Spring.

Spring Boot also autoconfigures the JdbcTemplate and other template beans that need to 
be explicitly registered in Spring.


### schema.sql
Spring Boot automatically creates the database schema specified in the 
schema.sql file. 
The schema needs to be explicitly configured if Spring is used.

### data.sql
Spring Boot automatically creates the row in table based on data in data.sql based on 
table in schema.sql file

### Rowmapper 
A row mapper is used to match the data coming from the database to the attributes of 
the bean. The BeanPropertyRowMapper is the default row mapper defined by Spring.

### Make Querry using
We will make use of the query method of JdbcTemplate to execute a SELECT * query.


## DML Querry
1. Define Player bean (sql schema) -> class for table
```
    public class Player{
        private int id;
        private String name;
        private String nationality;
        private Date birthDate;
        private int titles;
        //. . .
    }

```
2. create DAO Class
   define @repository
``` 
    class <tableName>Dao {

        @Autowired
        JdbcTemplate jdbcTemplate;

        public List<Player> getAllPlayers() {
            String sql = "SELECT * FROM PLAYER";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player> (Player.class));
        }
    }
```

3. Executing the query

   1. A CommandLineRunner is an interface in Spring Boot which has only one method 
   called run.
   2. This method is launched as soon as the context is loaded. 
   3. Our TennisPlayerApplication will implement the CommandLineRunner.
   4. We will autowire the PlayerDao class to use an object of this class to call 
   the getAllPlayers method inside the run method of the CommandLineRunner.
   5. A logger will display the list of players returned.

```
SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;
 
    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All Players Data: {}", dao.getAllPlayers());
    }
}


```


4. Accessing DB in Web

   The database can be viewed in the web browser by typing localhost:8080/h2-console 
   or http://127.0.0.1:8080/h2-console

   In the login page that shows up, make sure that the JDBC URL is the same as the 
   one that we provided in the applications.properties file (jdbc:h2:mem:testdb).

   If not, change it to jdbc:h2:mem:testdb and click connect to go to the database 
    console

5. Querry
    ```
    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, 
                                       new BeanPropertyRowMapper<Player>(Player.class), 
                                       new Object[] {id});
        }
    ```

6. Insert
   1. The update method is used for an INSERT query.
   2. This method takes the SQL query as well as an array of objects containing the 
   values that will be inserted.
   3. The method returns an int value which shows the number of rows affected by the query.

```
    public int insertPlayer(Player player)
    {
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality,Birth_date, Titles) " + 
                                                                  "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update( sql, new Object[] 
                               { player.getId(), player.getName(), player.getNationality(), 
                                 new Timestamp(player.getBirthDate().getTime()), 
                                 player.getTitles()  
                               });
    }

```
7. Update

   1. The update method of the JdbcTemplate is used to execute INSERT as well as UPDATE 
   queries. So, to update a record in the table, we will create a method updatePlayer, 
   which will be similar to the insertPlayer method.
   2. The only difference is in the query, which will change from INSERT to an 
     UPDATE query.

```
public int updatePlayer(Player player){
    String sql = "UPDATE PLAYER " +
                 "SET Name = ?, Nationality = ?, Birth_date = ? , Titles = ? " +
                 "WHERE ID = ?";

    return jdbcTemplate.update( sql, new Object[] { 
                                   player.getName(), 
                                   player.getNationality(), 
                                   new Timestamp(player.getBirthDate().getTime()), 
                                   player.getTitles(), 
                                   player.getId() }
                              );
}
```
```
@Override
public void run(String... args) throws Exception {
    //Inserting a player
    logger.info("Inserting Player 4: {}", dao.insertPlayer( 
                        new Player(4, "Thiem", "Austria", 
                                   new Date(System.currentTimeMillis()), 17))); 
 
    //Updating a player
    logger.info("Updating Player with Id 4: {}",  dao.updatePlayer(
                        new Player(4, "Thiem", "Austria", 
                                   Date.valueOf("1993-09-03"), 17)));
 
    //View player by Id
    logger.info("Players with Id 4: {}", dao.getPlayerById(4));
}
```
8. Delete
   Use the update method of the JdbcTemplate class.
```
public int deletePlayerById(int id) {
    String sql="DELETE FROM PLAYER WHERE ID = ?";
    return jdbcTemplate.update(sql, new Object[] {id});
}

```

## DDL Querry
create a table which is a Data Definition Language (DDL).
Table Creation.

1. Let’s say we want to create a Tournament table to store details of a 
tennis tournament. 
2. Create a method called createTournamentTable 
with a CREATE TABLE query

```
public void createTournamentTable() {
    String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), 
                                           LOCATION VARCHAR(50), PRIMARY KEY (ID))";
    jdbcTemplate.execute(sql);
    System.out.println("Table created");
}

```

3. call the createTournamentTable method in the run method and check if a 
table has been created from the output log.

```
@Override
public void run(String... args) throws Exception {
        dao.createTournamentTable();
}

```

## Custom RowMapper 
1. RowMapper 

   1. The BeanPropertyRowMapper to map the results of the query to our bean. If the database 
   table has a different structure or column names, we need to define our custom mapping.

   2. We can define our own row mapper by implementing the RowMapper interface and 
   providing the bean onto which the rows will be mapped.

   3. The custom row mapper, PlayerMapper is created as an inner class because it will 
   only be used inside JdbcPlayerDao. It is best practice to make it static and final.

```
@Repository
public class PlayerDao {
    //...
    private static final class PlayerMapper implements RowMapper<Player> {

    }

}
```
2. mapRow 
   1. The Rowmapper interface has one method, mapRow, for which we will write our custom 
   implementation to initialize a Player object.
   2. This method defines how a row is mapped.
   3. It takes two arguments, the first being the result set which JdbcTemplate gets after
   running the query and the second being the row number.
   4. The row number of every row in the result set is different.
   5. The JdbcTemplate calls the mapRow method for every row in the result set and passes
   its row number as an argument.
   6. The method returns an object of Player type.

   
```
@Override
public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    Player player = new Player();
    player.setId(resultSet.getInt("id"));
    player.setName(resultSet.getString("name"));
    player.setNationality(resultSet.getString("nationality"));
    player.setBirthDate(resultSet.getTime("birth_date"));
    player.setTitles(resultSet.getInt("titles"));
    return player; 
}
```
3. using custom rowmapper
   1. To use PlayerMapper, we can simply pass it in any method instead of the 
   BeanPropertyRowMapper. 
   2. We will create a method that finds players based on their nationality and 
   use our custom mapper to convert the result set to objects as follows:
```
public List<Player> getPlayerByNationality(String nationality) {
    String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
    return jdbcTemplate.query(sql, new PlayerMapper(), new Object[] {nationality});
}
```
```
@Override
public void run(String... args) throws Exception {
    logger.info("French Players: {}", dao.getPlayerByNationality("France"));
}
```


### Connecting to Other Databases
1. Remove the H2 dependency from pom.xml and replace it with the dependency of the 
   database we wish to connect to. 
2. Suppose we wish to connect to MySql. 
   The dependency for MySql is given below.Dependencies for other databases are 
   available online.
```
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
</dependency>
```
3. Configuring property Value 
   1. For any database, we need to configure its URL, username, and password. 
   2. These values are specified in the application.properties file.

```
spring.jpa.hibernate.ddl-auto=none 
spring.datasource.url = jdbc:mysql://localhost:3306/movie_example
spring.datasource.username = demo
spring.datasource.password = demo
```