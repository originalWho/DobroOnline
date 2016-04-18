package dobro.service;

import dobro.model.Word;

/**
 * Created by Artur on 4/18/16.
 */
public interface WordService {
    Iterable<Word> getAllWords();

    Word getWordById(Integer id);

    void saveWord(Word word);

    void deleteWordById(Integer id);

    void deleteWord(Word word);

    void deleteAllWords();
}
