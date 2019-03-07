package semwinf.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import semwinf.database.ResultRepository;
import semwinf.database.StepRepository;
import semwinf.database.TreeRepository;
import semwinf.model.Result;
import semwinf.model.Step;
import semwinf.model.Tree;
import semwinf.model.TreeVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationServicee {

    private StepRepository stepRepository;
    private TreeRepository treeRepository;
    private ResultRepository resultRepository;

    public ApplicationServicee(StepRepository stepRepository, TreeRepository treeRepository, ResultRepository resultRepository) {
        this.stepRepository = stepRepository;
        this.treeRepository = treeRepository;
        this.resultRepository = resultRepository;
    }

    public Step createStep(Step step) {
        System.out.println(step.getStepid());

        if(step.getStepid() == null)
            step.setStepid(UUID.randomUUID().toString());

        stepRepository.save(step);

        return step;
    }

    public List<Step> getAllStepsFromTree(String treeid) {
        List<Step> steps = stepRepository.findAllBytreeid(treeid);

        return steps;
    }

    public HttpStatus deleteStep(String stepid) {
        if (stepid == null)
            return HttpStatus.NOT_FOUND;

        stepRepository.deleteById(stepid);

        return HttpStatus.OK;
    }


    public Step getStepByStepId(String stepid) {
        Optional<Step> optStep = this.stepRepository.findById(stepid);

        if(!optStep.isPresent())
            return null;

        Step step = optStep.get();
        return step;
    }

    public List<TreeVM> getTrees() {

        List<Tree> list = treeRepository.findAllByisFinishedTrue();

        List<TreeVM> ret = new ArrayList<TreeVM>();

        System.out.println(ret.size());
        for(Tree item : list) {
            ret.add(new TreeVM(item.getTreeid(),item.getCaption(), item.getStartStepId()));
        }

        return ret;
    }

    public TreeVM getTree(@PathVariable("treeid") String treeid) {
        Optional<Tree> result = this.treeRepository.findById(treeid);

        Tree tree = result.get();

        if(tree == null)
            return null;

        return new TreeVM(tree.getTreeid(), tree.getCaption(), tree.getStartStepId());
    }

    public TreeVM createTree(@RequestBody TreeVM tree) {

        Tree target;
        if(tree.getTreeid() == null)
            target = new Tree(UUID.randomUUID().toString(),tree.getCaption(),tree.getStartStepId());

        target = new Tree(tree.getTreeid(),tree.getCaption(),tree.getStartStepId());
        treeRepository.save(target);

        return new TreeVM(target.getTreeid(), target.getCaption(), target.getStartStepId());
    }

    public Tree markTreeAsFinished(String treeid) {
        //this.treeRepository.findAllByisFinishedTrue();

        Optional<Tree> treeOptional = this.treeRepository.findById(treeid);
        if(!treeOptional.isPresent())
            return null;

        Tree tree = treeOptional.get();
        tree.setFinished(true);
        this.treeRepository.save(tree);
        return tree;
    }

    public Result createResult(@RequestBody Result result) {
        if(result.getResultid() == null)
            result.setResultid(UUID.randomUUID().toString());

        resultRepository.save(result);
        return result;
    }

    public Result getResultById(String resultid) {
        Optional<Result> result = resultRepository.findById(resultid);

        return result.get();
    }

    public List<Result> getAllResultsByTreeId(String treeId) {
        List<Result> results = resultRepository.findAllBytreeid(treeId);

        return results;
    }

}
