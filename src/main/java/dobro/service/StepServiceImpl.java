package dobro.service;

import dobro.model.Step;
import dobro.repository.StepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Artur on 4/19/16.
 */
@Service
public class StepServiceImpl implements StepService {
    private StepRepo stepRepo;

    @Autowired
    public void setStepRepo(StepRepo stepRepo) {
        this.stepRepo = stepRepo;
    }

    @Override
    public void deleteAllSteps() {
        stepRepo.deleteAll();
    }

    @Override
    public Iterable<Step> getAllSteps() {
        return stepRepo.findAll();
    }

    @Override
    public Step getStepById(Integer id) {
        return stepRepo.getOne(id);
    }

    @Override
    public void saveStep(Step step) {
        stepRepo.save(step);
    }

    @Override
    public void deleteStepById(Integer id) {
        stepRepo.delete(id);
    }

    @Override
    public void deleteStep(Step step) {
        stepRepo.delete(step);
    }
}
