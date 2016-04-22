package dobro.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artur on 4/19/16.
 */
@Entity
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "owner_id")
    private Lesson owner;
    @ManyToMany(mappedBy = "steps")
    private List<Word> wordList;
    private String correctAnswer;
    private String view;
    private boolean isPassed;
    private boolean isEnabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public Lesson getOwner() {
        return owner;
    }

    public void setOwner(Lesson owner) {
        this.owner = owner;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public List<String> getStrings() {
        List<String> list = new ArrayList<>();
        for (Word word : wordList)
            list.add(word.toString());
        return list;
    }
}
