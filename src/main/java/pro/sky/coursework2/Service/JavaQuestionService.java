package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Entity.Question;
import pro.sky.coursework2.Exception.QuestionAlreadyAddedException;
import pro.sky.coursework2.Exception.QuestionNotFound;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
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
        if (questions.equals(question)) {
            throw new QuestionAlreadyAddedException("Question already added");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFound("Question not found");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
//        int size=questions.size();
//        if(size>0){
//            int randomIndex=new Random().nextInt(size);
//
//            return questions.get(randomIndex);
//        }
        return null;
    }

}
