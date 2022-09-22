package kopo.poly.controller;

import kopo.poly.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Slf4j
@Controller
public class GameController {
    //서비스로 연결
//    @Resource(name = "GameService")
//    private IGameService gameService;

    @GetMapping(value = "/game/game")
    public String game() throws Exception {
        log.info(this.getClass().getName()+".game Start!!");
        log.info(this.getClass().getName()+".game End!!");
        return "/game/game";
    }

    @GetMapping(value = "/game/game-choice")
    public String gameChoice() throws Exception {
        log.info(this.getClass().getName()+".game-choice Start!!");
        log.info(this.getClass().getName()+".game-choice End!!");
        return "/game/game-choice";
    }

    @GetMapping(value = "/game/puzzle1")
    public String puzzle1() throws Exception {
        log.info(this.getClass().getName()+".puzzle1 Start!!");
        log.info(this.getClass().getName()+".puzzle1 End!!");
        return "/game/puzzle1";
    }

    @GetMapping(value = "/game/puzzle2")
    public String puzzle2() throws Exception {
        log.info(this.getClass().getName()+".puzzle1 Start!!");
        log.info(this.getClass().getName()+".puzzle1 End!!");
        return "/game/puzzle2";
    }
}
