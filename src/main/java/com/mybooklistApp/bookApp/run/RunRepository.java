package com.mybooklistApp.bookApp.run;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

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

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT id, title, started_on, completed_on, miles, location FROM Run WHERE id = :id" )
        .param("id", id).query(Run.class).optional();
    }

    public void create(Run run) {
        var update = jdbcClient.sql("INSERT INTO Run(id, title, started_on, completed_on, miles, location) values(?, ?, ?, ?, ?, ?)")
        .params(List.of(run.id(), run.title(), run.started_on(), run.completed_on(), run.miles(), run.Location().toString())).update();

        Assert.state(update == 1, "Failed to create run" + run.title());
    }

    public void update(Run run, Integer id ) {
        var updated = jdbcClient.sql("update run set title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? where id = ? ")
        .params(List.of(run.title(), run.started_on(), run.completed_on(), run.Location().toString(), run.miles(), id)).update();

        Assert.state(updated == 1, "Failed to run update run" + run.title());
    }

    public void delete (Integer id) {
        var updated = jdbcClient.sql("delete from run where id = :id").update();

        Assert.state(updated == 1, "Failed to run delete run" + id);
    }

    public int count(){ return jdbcClient.sql("select *from run").query().listOfRows().size(); }

    public void saveAll(List<Run> runs){
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from run where location = :location").param("location", location).query(Run.class).list();
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
