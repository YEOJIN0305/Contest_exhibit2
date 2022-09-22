package kopo.poly.controller;

import kopo.poly.service.IQuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Slf4j
@Controller
public class QuizController {
    //서비스로 연결
    @Resource(name = "QuizService")
    private IQuizService quizService;

    @GetMapping(value = "/quiz/quiz-make")
    public String quizMake() throws Exception {
        log.info(this.getClass().getName()+".quizMake Start!!");
        log.info(this.getClass().getName()+".quizMake End!!");
        return "/quiz/quiz-make";
    }

    @GetMapping(value = "/quiz/quiz-replay-bookmark")
    public String quizBookmark() throws Exception {
        log.info(this.getClass().getName()+".quizBookmark Start!!");
        log.info(this.getClass().getName()+".quizBookmark End!!");
        return "/quiz/quiz-replay-bookmark";
    }

    @RequestMapping(value = "/quiz/quiz-result")
    public String quizResult() throws Exception {
        log.info(this.getClass().getName()+".quizResult Start!!");
        log.info(this.getClass().getName()+".quizResult End!!");
        return "/quiz/quiz-result";
    }

    @RequestMapping(value = "/quiz/quiz-workbook")
    public String quizWorkBook() throws Exception {
        log.info(this.getClass().getName()+".quizWorkBook Start!!");
        log.info(this.getClass().getName()+".quizWorkBook End!!");
        return "/quiz/quiz-workbook";
    }

    @GetMapping(value = "/quiz/quiz-workbook-check")
    public String quizWorkBookCheck() throws Exception {
        log.info(this.getClass().getName()+".quizWorkBookCheck Start!!");
        log.info(this.getClass().getName()+".quizWorkBookCheck End!!");
        return "/quiz/quiz-workbook-check";
    }
}
