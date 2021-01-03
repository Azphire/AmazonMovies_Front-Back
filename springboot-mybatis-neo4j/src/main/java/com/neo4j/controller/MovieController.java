package com.neo4j.controller;

import com.neo4j.mapper.MovieMapper;
import com.neo4j.model.MovieModel;
import com.neo4j.model.SubMovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieMapper movieMapper;

    /*-------------------------日期查询----------------------------*/

    @GetMapping("/year")
    public ArrayList<MovieModel> getByYear(@RequestParam String year) {
        return movieMapper.getByYear(year);
    }

    @GetMapping("/month")
    public ArrayList<MovieModel> getByMonth(@RequestParam String month) {
        return movieMapper.getByMonth(month);
    }

    @GetMapping("/date")
    public ArrayList<MovieModel> getByDate(@RequestParam String date) {
        return movieMapper.getByDate(date);
    }

    @GetMapping("/span")
    public ArrayList<MovieModel> getBySpan(@RequestParam String start, @RequestParam String end) {
        return movieMapper.getBySpan(start, end);
    }

    @GetMapping("/CountByYear")
    public int countByYear(@RequestParam String year) {
        return movieMapper.countByYear(year);
    }

    @GetMapping("/CountByMonth")
    public int countByMonth(@RequestParam String month) {
        return movieMapper.countByMonth(month);
    }

    @GetMapping("/CountByDate")
    public int countByDate(@RequestParam String date) {
        return movieMapper.countByDate(date);
    }

    @GetMapping("/CountBySpan")
    public int countBySpan(@RequestParam String start, @RequestParam String end) {
        return movieMapper.countBySpan(start, end);
    }


    /*-------------------------电影名查询---------------------------*/
    @GetMapping("/title")
    public ArrayList<SubMovieModel> getByTitle(@RequestParam String title) {
        return movieMapper.getByTitle(title);
    }

    @GetMapping("/CountByTitle")
    public int countByTitle(@RequestParam String title) {
        return movieMapper.countByTitle(title);
    }


    /*-------------------------导演查询----------------------------*/
    @GetMapping("/director")
    public ArrayList<MovieModel> getByDirector(@RequestParam String director) {
        return movieMapper.getByDirector(director);
    }

    @GetMapping("/CountByDirector")
    public int countByDirector(@RequestParam String director) {
        return movieMapper.countByDirector(director);
    }


    /*-------------------------演员查询----------------------------*/
    @GetMapping("/actor")
    public ArrayList<MovieModel> getByActor(@RequestParam String actor) {
        return movieMapper.getByActor(actor);
    }

    @GetMapping("/CountByActor")
    public int countByActor(@RequestParam String actor) {
        return movieMapper.countByActor(actor);
    }


    /*-------------------------分类查询----------------------------*/
    @GetMapping("/type")
    public ArrayList<MovieModel> getByType(@RequestParam String type) {
        return movieMapper.getByType(type);
    }

    @GetMapping("/CountByType")
    public int countByType(@RequestParam String type) {
        return movieMapper.countByType(type);
    }


    /*-------------------------评分查询----------------------------*/
    @GetMapping("/score")
    public ArrayList<MovieModel> getByScore(@RequestParam double score) {
        return movieMapper.getByScore(score);
    }

    @GetMapping("/CountByScore")
    public int countByScore(@RequestParam double score) {
        return movieMapper.countByScore(score);
    }


    /*-------------------------评价查询----------------------------*/
    @GetMapping("/comment")
    public ArrayList<MovieModel> getByComment(@RequestParam double ratio) {
        return movieMapper.getByComment(ratio);
    }

    @GetMapping("/CountByComment")
    public int countByComment(@RequestParam double ratio) {
        return movieMapper.countByComment(ratio);
    }


    /*-------------------------组合查询----------------------------*/
    @GetMapping("/multi")
    public ArrayList<MovieModel> getByMulti(
            @RequestParam(required = false) double score,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String year,
            @RequestParam(required = false) String actor,
            @RequestParam(required = false) String director){
        return movieMapper.getByMulti(score, type, year, actor, director);
    }

    @GetMapping("/CountByMulti")
    public int countByMulti(
            @RequestParam(required = false) double score,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String year,
            @RequestParam(required = false) String actor,
            @RequestParam(required = false) String director){
        return movieMapper.countByMulti(score, type, year, actor, director);
    }


    /*-------------------------自由发挥----------------------------*/
    @GetMapping("/MostPopular")
    public ArrayList<MovieModel> getMostPopular(@RequestParam String year) {
        return movieMapper.getMostPopular(year);
    }

    @GetMapping("/MostUnpopular")
    public ArrayList<MovieModel> getMostUnpopular(@RequestParam String year) {
        return movieMapper.getMostUnpopular(year);
    }

}
