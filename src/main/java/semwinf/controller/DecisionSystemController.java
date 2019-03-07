package semwinf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import semwinf.application.ApplicationServicee;
import semwinf.model.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class DecisionSystemController {
    private ApplicationServicee applicationService;
    public DecisionSystemController(ApplicationServicee applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("step")
    public Step createStep(@RequestBody Step step) {
        return this.applicationService.createStep(step);
    }

    @GetMapping("step/{treeid}")
    public List<Step> getAllStepsFromTree(@PathVariable("treeid") String treeid) throws JsonProcessingException {
        return this.applicationService.getAllStepsFromTree(treeid);
    }

    @GetMapping("step/byid/{stepid}")
    public Step getStepByStepId(@PathVariable("stepid") String stepid) {
        return this.applicationService.getStepByStepId(stepid);
    }

    @DeleteMapping("step/{stepid}")
    public HttpStatus deleteStep(@PathVariable("stepid") String stepid) {
        return this.applicationService.deleteStep(stepid);
    }

    @GetMapping("tree")
    public List<TreeVM> getAllTrees() {
        return this.applicationService.getTrees();
    }

    @GetMapping("tree/{treeid}")
    public TreeVM getTree(@PathVariable("treeid") String treeid) {
        return this.applicationService.getTree(treeid);
    }

    @PostMapping("tree")
    public TreeVM createTree(@RequestBody TreeVM tree) {
        return this.applicationService.createTree(tree);
    }

    @PutMapping("tree")
    public Tree markTreeAsFinished(@RequestBody String treeid) {
        return this.applicationService.markTreeAsFinished(treeid);
    }

    @PostMapping("result")
    public Result createResult(@RequestBody Result result) {
        return this.applicationService.createResult(result);
    }

    @GetMapping("result/{resultid}")
    public Result getResultById(@PathVariable("resultid") String resultid) {
        return this.applicationService.getResultById(resultid);
    }

    @GetMapping("result/all/{treeid}")
    public List<Result> getAllResultsByTreeId(@PathVariable("treeid") String treeId) {
        return this.applicationService.getAllResultsByTreeId(treeId);
    }
}
