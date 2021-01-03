package com.mysql.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieModel {
    @TableField("ID")
    private int ID;

    @TableField("director")
    private String director;

    @TableField("title")
    private String title;

    @TableField("runtime")
    private String runtime;

    @TableField("gerne")
    private String gerne;

    @TableField("language")
    private String language;

    @TableField("year")
    private String year;

    @TableField("producer")
    private String producer;

    @TableField("actor")
    private String actor;

    @TableField("score")
    private double score;
}
