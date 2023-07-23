package pro.sky.coursework2.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.Entity.Question;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService javaQuestionService;

    @Mock
    private QuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    List<Question> javaQuestions = Arrays.asList(
            new Question("Question1", "Answer1"),
            new Question("Question2", "Answer2"),
            new Question("Question3", "Answer3"));

    List<Question> mathQuestions = Arrays.asList(
            new Question("Que1", "Ans1"),
            new Question("Que2", "Ans2"),
            new Question("Que3", "Ans3"));

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    @Test
    void testGetQuestions() {
        int amount = 3;
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(javaQuestions.get(0))
                .thenReturn(javaQuestions.get(1))
                .thenReturn(javaQuestions.get(2));

        when(mathQuestionService.getRandomQuestion())
                .thenReturn(javaQuestions.get(0))
                .thenReturn(javaQuestions.get(1))
                .thenReturn(javaQuestions.get(2));

        Collection<Question> returnQuestion = examinerService.getQuestions(amount);
        assertEquals(amount, returnQuestion.size());
    }
}
