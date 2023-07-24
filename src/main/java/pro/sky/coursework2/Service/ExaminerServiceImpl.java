package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Entity.Question;
import pro.sky.coursework2.Exception.BadRequestException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Set<QuestionService> questionServices;

    public ExaminerServiceImpl(Set<QuestionService> questionServices) {
        this.questionServices = new HashSet<>();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new BadRequestException("Invalid call");
        }
        Set<Question> requestedQuestions = new HashSet<>();
        Random random = new Random();
        for (QuestionService questionService : questionServices) {
            int questionsCount = random.nextInt(amount) + 1;

            for (int i = 0; i < questionsCount; i++) {
                Question randomQuestion = questionService.getRandomQuestion();
                if (randomQuestion != null) {
                    requestedQuestions.add(randomQuestion);
                }
            }
            amount -= questionsCount;
            if (amount <= 0) {
                break;
            }
        }
        if (requestedQuestions.size() < amount) {
            throw new BadRequestException("Over than list contains");
        }
        return requestedQuestions;
    }
}
