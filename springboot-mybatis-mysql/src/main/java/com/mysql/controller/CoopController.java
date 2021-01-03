package com.mysql.controller;

import com.mysql.mapper.CoopMapper;
import com.mysql.model.CooperationModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/coop")
@Controller
@CrossOrigin
public class CoopController {
    @Autowired
    private CoopMapper coopMapper;

    @GetMapping("/ad")
    public ArrayList<CooperationModel> getAD(@RequestParam int count) {
        return coopMapper.getCoopAD(count);
    }

    @GetMapping("/aa")
    public ArrayList<CooperationModel> getAA(@RequestParam int count) {
        return coopMapper.getCoopAA(count);
    }

    @GetMapping("/dd")
    public ArrayList<CooperationModel> getDD(@RequestParam int count) {
        return coopMapper.getCoopDD(count);
    }

    @GetMapping("/ActorsByActor")
    public ArrayList<CooperationModel> getActorsByActor(
            @RequestParam int count,
            @RequestParam String actor) {
        return coopMapper.getActorByActor(count, actor);
    }

    @GetMapping("/ActorsByDirector")
    public ArrayList<CooperationModel> getActorsByDirector(
            @RequestParam int count,
            @RequestParam String director) {
        return coopMapper.getActorByDirector(count, director);
    }

    @GetMapping("/DirectorsByDirector")
    public ArrayList<CooperationModel> getDirectorsByDirector(
            @RequestParam int count,
            @RequestParam String director) {
        return coopMapper.getDirectorByDirector(count, director);
    }

    @GetMapping("/DirectorsByActor")
    public ArrayList<CooperationModel> getDirectorsByActor(
            @RequestParam int count,
            @RequestParam String actor) {
        return coopMapper.getDirectorByActor(count, actor);
    }

}
