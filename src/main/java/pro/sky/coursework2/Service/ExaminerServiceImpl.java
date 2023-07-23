package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Entity.Question;
import pro.sky.coursework2.Exception.BadRequestException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;

    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService,
                               QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new BadRequestException("Invalid call");
        }
        Set<Question> uniqueQuestions = new HashSet<>();

        Random random = new Random();
        int javaQuestionsCount = random.nextInt(amount) + 1;
        int mathQuestionsCount = amount - javaQuestionsCount;

        for (int i = 0; i < javaQuestionsCount; i++) {
            Question randomQuestion = javaQuestionService.getRandomQuestion();
            if (randomQuestion != null) {
                uniqueQuestions.add(randomQuestion);
            }
        }
        for (int i = 0; i < mathQuestionsCount; i++) {
            Question randomQuestion = mathQuestionService.getRandomQuestion();
            if (randomQuestion != null) {
                uniqueQuestions.add(randomQuestion);
            }
        }
        if (uniqueQuestions.size() < amount) {
            throw new BadRequestException();
        }
        return uniqueQuestions;
    }
}
