package service;

import org.springframework.beans.factory.annotation.Autowired;
import repo.WordRepo;

/**
 * Created by Artur on 4/18/16.
 */
public class WordServiceImpl implements WordService {
    private WordRepo wordRepo;

    @Autowired
    public void setWordRepo(WordRepo wordRepo) {
        this.wordRepo = wordRepo;
    }
}
