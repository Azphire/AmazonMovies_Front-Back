package com.neo4j.mapper;

import com.neo4j.model.MovieModel;
import com.neo4j.model.SubMovieModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface MovieMapper {
    /*-------------------------日期查询----------------------------*/
    ArrayList<MovieModel> getByYear(@Param(value = "year") String year);

    ArrayList<MovieModel> getByMonth(@Param(value = "month")String month);

    ArrayList<MovieModel> getBySpan(@Param(value="start") String start, @Param(value = "end") String end);

    ArrayList<MovieModel> getByDate(@Param(value = "date")String date);

    int countByYear(@Param(value = "year") String year);

    int countByMonth(@Param(value = "month")String month);

    int countBySpan(@Param(value="start") String start, @Param(value = "end") String end);

    int countByDate(@Param(value = "date")String date);


    /*-------------------------电影名查询--------------------------*/
    ArrayList<SubMovieModel> getByTitle(@Param(value = "title") String title);

    int countByTitle(@Param(value = "title") String title);


    /*-------------------------导演查询----------------------------*/
    ArrayList<MovieModel> getByDirector(@Param(value = "director") String director);

    int countByDirector(@Param(value = "director") String director);


    /*-------------------------演员查询----------------------------*/
    ArrayList<MovieModel> getByActor(@Param(value = "actor") String actor);

    int countByActor(@Param(value = "actor") String actor);


    /*-------------------------分类查询----------------------------*/
    ArrayList<MovieModel> getByType(@Param(value = "type") String type);

    int countByType(@Param(value = "type") String type);


    /*-------------------------评分查询----------------------------*/
    ArrayList<MovieModel> getByScore(@Param(value = "score") double score);

    int countByScore(@Param(value = "score") double score);


    /*-------------------------评价查询----------------------------*/
    ArrayList<MovieModel> getByComment(@Param(value = "ratio") double ratio);

    int countByComment(@Param(value = "ratio") double ratio);


    /*-------------------------组合查询----------------------------*/
    ArrayList<MovieModel> getByMulti(
            @Param(value = "score") double score,
            @Param(value = "type") String type,
            @Param(value = "year") String year,
            @Param(value = "actor") String actor,
            @Param(value = "director") String director);

    int countByMulti(
            @Param(value = "score") double score,
            @Param(value = "type") String type,
            @Param(value = "year") String year,
            @Param(value = "actor") String actor,
            @Param(value = "director") String director);

    /*-------------------------自由发挥----------------------------*/
    ArrayList<MovieModel> getMostPopular(@Param(value = "year") String year);

    ArrayList<MovieModel> getMostUnpopular(@Param(value = "year") String year);

}
