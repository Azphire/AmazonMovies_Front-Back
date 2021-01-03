package com.mysql.controller;

import com.mysql.mapper.MovieMapper;
import com.mysql.model.MovieModel;
import com.mysql.model.SubMovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movie")
@Controller
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieMapper movieMapper;

    /*-------------------------日期查询----------------------------*/
    //前端返回日期格式为yyyy-MM-dd，而mysql中日期存储格式为yyyy/MM/dd，因此需要先用replace转换。

    @GetMapping("/year")
    public ArrayList<MovieModel> getByYear(@RequestParam String year) {
        return movieMapper.getByYear(year);
    }

    @GetMapping("/month")
    public ArrayList<MovieModel> getByMonth(@RequestParam String month) {
        String m1 = month.replace("-0", "/");
        String m2 = m1.replace("-", "/");
        return movieMapper.getByMonth(m2);
    }

    @GetMapping("/date")
    public ArrayList<MovieModel> getByDate(@RequestParam String date) {
        String d1 = date.replace("-0", "/");
        String d2 = d1.replace("-", "/");
        return movieMapper.getByDate(d2);
    }

    @GetMapping("/span")
    public ArrayList<MovieModel> getBySpan(@RequestParam String start, @RequestParam String end) {
        String s1 = start.replace("-0", "/");
        String s2 = s1.replace("-", "/");
        String e1 = end.replace("-0", "/");
        String e2 = e1.replace("-", "/");
        return movieMapper.getBySpan(s2, e2);
    }

    @GetMapping("/CountByYear")
    public int countByYear(@RequestParam String year) {
        return movieMapper.countByYear(year);
    }

    @GetMapping("/CountByMonth")
    public int countByMonth(@RequestParam String month) {
        String m1 = month.replace("-0", "/");
        String m2 = m1.replace("-", "/");
        return movieMapper.countByMonth(m2);
    }

    @GetMapping("/CountByDate")
    public int countByDate(@RequestParam String date) {

        String d1 = date.replace("-0", "/");
        String d2 = d1.replace("-", "/");
        return movieMapper.countByDate(d2);
    }

    @GetMapping("/CountBySpan")
    public int countBySpan(@RequestParam String start, @RequestParam String end) {
        String s1 = start.replace("-0", "/");
        String s2 = s1.replace("-", "/");
        String e1 = end.replace("-0", "/");
        String e2 = e1.replace("-", "/");
        return movieMapper.countBySpan(s2, e2);
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
