package com.mybooklistApp.bookApp.run;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class RunRepository {
    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;
    
    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    public List<Run> findAll() {
        return jdbcClient.sql("select * from run").query(Run.class).list();
    }


    
    
    

    

    

    // @PostConstruct
    // private void init(){
    //     runs.add(new Run(1,"monday morning run",
    //     LocalDateTime.now(),LocalDateTime.now().plus(30,ChronoUnit.MINUTES),
    //     2,Location.INDOOR));

    //     runs.add(new Run(2,"sunday morning run",
    //     LocalDateTime.now(),LocalDateTime.now().plus(3,ChronoUnit.HOURS),
    //     10,Location.OUTDOOR));
    //}
}
