package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Entity.Question;
import pro.sky.coursework2.Exception.MoreThanAvailableException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService service;

    public ExaminerServiceImpl(JavaQuestionService service) {
        this.service = service;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new MoreThanAvailableException();
        }
        return Stream.generate(service::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toSet());
    }
}
