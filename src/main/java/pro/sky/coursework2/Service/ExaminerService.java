package pro.sky.coursework2.Service;

import pro.sky.coursework2.Entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
