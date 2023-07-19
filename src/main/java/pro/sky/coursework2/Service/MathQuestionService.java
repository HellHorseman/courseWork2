package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Entity.Question;
import pro.sky.coursework2.Exception.QuestionAlreadyAddedException;
import pro.sky.coursework2.Exception.QuestionNotFound;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final Set<Question> mathQuestions;

    public MathQuestionService() {
        this.mathQuestions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question ques = new Question(question, answer);
        if (!mathQuestions.contains(ques)) {
            mathQuestions.add(ques);
            return ques;
        }
        throw new QuestionAlreadyAddedException("Question already added");
    }

    @Override
    public Question add(Question question) {
        if (mathQuestions.contains(question)) {
            throw new QuestionAlreadyAddedException("Question already added");
        }
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!mathQuestions.contains(question)) {
            throw new QuestionNotFound("Question not found");
        }
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }

    @Override
    public Question getRandomQuestion() {
        if (!mathQuestions.isEmpty()) {
            int randomIndex = new Random().nextInt(mathQuestions.size());
            return mathQuestions.stream().skip(randomIndex).findFirst().orElse(null);
        }
        return null;
    }
}
