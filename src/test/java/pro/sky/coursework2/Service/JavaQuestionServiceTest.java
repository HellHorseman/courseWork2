package pro.sky.coursework2.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.Entity.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private JavaQuestionService serviceMock = new JavaQuestionService();

    @Test
    void add() {
        Question expected = new Question("Question", "Answer");
        Question actual = serviceMock.add("Question", "Answer");
        assertEquals(expected, actual);

    }

    @Test
    void remove() {
        Question question = new Question("Question", "Answer");
        serviceMock.add("Question", "Answer");
        serviceMock.add("Question1", "Answer1");
        serviceMock.remove(question);
        assertEquals(1, serviceMock.getAll().size());
    }

    @Test
    void getAll() {
        serviceMock.add("Answer", "Answer");
        serviceMock.add("Question", "Question");
        assertEquals(2, serviceMock.getAll().size());
    }
}
