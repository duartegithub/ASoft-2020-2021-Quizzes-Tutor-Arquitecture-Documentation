package pt.ulisboa.tecnico.socialsoftware.tutor.quiz;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.ulisboa.tecnico.socialsoftware.tutor.answer.dto.QuizAnswersDto;
import pt.ulisboa.tecnico.socialsoftware.tutor.quiz.dto.QuizDto;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/executions/{executionId}/quizzes/non-generated")
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#executionId, 'EXECUTION.ACCESS')")
    public List<QuizDto> findNonGeneratedQuizzes(@PathVariable int executionId) {
        return quizService.findNonGeneratedQuizzes(executionId);
    }

    @PostMapping("/executions/{executionId}/quizzes")
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#executionId, 'EXECUTION.ACCESS')")
    public QuizDto createQuiz(@PathVariable int executionId, @Valid @RequestBody QuizDto quiz) {
        formatDates(quiz);
        return this.quizService.createQuiz(executionId, quiz);
    }

    @GetMapping("/quizzes/{quizId}")
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#quizId, 'QUIZ.ACCESS')")
    public QuizDto getQuiz(@PathVariable Integer quizId) {
        return this.quizService.findById(quizId);
    }

    @PutMapping("/quizzes/{quizId}")
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#quizId, 'QUIZ.ACCESS')")
    public QuizDto updateQuiz(@PathVariable Integer quizId, @Valid @RequestBody QuizDto quiz) {
        formatDates(quiz);
        return this.quizService.updateQuiz(quizId, quiz);
    }

    @DeleteMapping("/quizzes/{quizId}")
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#quizId, 'QUIZ.ACCESS')")
    public ResponseEntity deleteQuiz(@PathVariable Integer quizId) {
        quizService.removeQuiz(quizId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/quizzes/{quizId}/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#quizId, 'QUIZ.ACCESS')")
    public @ResponseBody byte[] exportQuiz(@PathVariable Integer quizId, @RequestParam String type) throws IOException {
        String result = "";
        if (type.equals("latex")) {
             result = this.quizService.exportQuizzesToLatex(quizId);
        }

        InputStream in = IOUtils.toInputStream(result, StandardCharsets.UTF_8);

        return IOUtils.toByteArray(in);
    }

    @GetMapping("/quizzes/{quizId}/answers")
    @PreAuthorize("hasRole('ROLE_TEACHER') and hasPermission(#quizId, 'QUIZ.ACCESS')")
    public QuizAnswersDto getQuizAnswers(@PathVariable Integer quizId) {
        return this.quizService.getQuizAnswers(quizId);
    }

    private void formatDates(QuizDto quiz) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (quiz.getAvailableDate() != null && !quiz.getAvailableDate().matches("(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2})")){
            quiz.setAvailableDate(LocalDateTime.parse(quiz.getAvailableDate().replaceAll(".$", ""), DateTimeFormatter.ISO_DATE_TIME).format(formatter));
        }
        if (quiz.getConclusionDate() !=null && !quiz.getConclusionDate().matches("(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2})"))
            quiz.setConclusionDate(LocalDateTime.parse(quiz.getConclusionDate().replaceAll(".$", ""), DateTimeFormatter.ISO_DATE_TIME).format(formatter));
    }
}