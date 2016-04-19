package dobro.service;

import dobro.model.Step;

/**
 * Created by Artur on 4/19/16.
 */
public interface StepService {
    Iterable<Step> getAllSteps();

    Step getStepById(Integer id);

    void saveStep(Step step);

    void deleteStepById(Integer id);

    void deleteStep(Step step);

    void deleteAllSteps();
}
