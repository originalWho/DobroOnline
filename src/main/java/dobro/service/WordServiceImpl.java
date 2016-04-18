package dobro.service;

import dobro.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import dobro.repository.WordRepo;
import org.springframework.stereotype.Service;

/**
 * Created by Artur on 4/18/16.
 */
@Service
public class WordServiceImpl implements WordService {
    private WordRepo wordRepo;

    @Autowired
    public void setWordRepo(WordRepo wordRepo) {
        this.wordRepo = wordRepo;
    }

    @Override
    public void deleteAllWords() {
        wordRepo.deleteAll();
    }

    @Override
    public Iterable<Word> getAllWords() {
        return wordRepo.findAll();
    }

    @Override
    public Word getWordById(Integer id) {
        return wordRepo.getOne(id);
    }

    @Override
    public void saveWord(Word word) {
        wordRepo.save(word);
    }

    @Override
    public void deleteWordById(Integer id) {
        wordRepo.delete(id);
    }

    @Override
    public void deleteWord(Word word) {
        wordRepo.delete(word);
    }
}
