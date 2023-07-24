package pro.sky.coursework2.Repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursework2.Entity.Question;
import pro.sky.coursework2.Exception.QuestionAlreadyAddedException;
import pro.sky.coursework2.Exception.QuestionNotFound;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question ques = new Question(question, answer);
        if (!questions.contains(ques)) {
            questions.add(ques);
            return ques;
        }
        throw new QuestionAlreadyAddedException("Question already added");
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException("Question already added");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFound("Question not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
