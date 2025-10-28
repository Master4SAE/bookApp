package com.mybooklistApp.bookApp.run;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;
    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }
    //get all req
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }
}
