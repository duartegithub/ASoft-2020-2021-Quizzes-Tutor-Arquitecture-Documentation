package pt.ulisboa.tecnico.socialsoftware.tutor.statement.domain;

import pt.ulisboa.tecnico.socialsoftware.tutor.question.domain.Option;
import pt.ulisboa.tecnico.socialsoftware.tutor.question.domain.Question;
import pt.ulisboa.tecnico.socialsoftware.tutor.statement.dto.StatementAnswerDto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.util.Map;

@Entity
@DiscriminatorValue(Question.QuestionTypes.MULTIPLE_CHOICE_QUESTION)
public class MultipleChoiceAnswerItem extends QuestionAnswerItem {

    private Integer optionId;

    public MultipleChoiceAnswerItem() {
    }

    public MultipleChoiceAnswerItem(String username, int quizId, StatementAnswerDto answer) {
        super(username, quizId, answer);
    }

    @Override
    public String getAnswerRepresentation(Map<Integer, Option> options) {
        return this.getOptionId() != null ? convertSequenceToLetter(options.get(this.getOptionId()).getSequence()) : "X";
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    private String convertSequenceToLetter(Integer value) {
        switch (value) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            default:
                return "X";
        }
    }
}