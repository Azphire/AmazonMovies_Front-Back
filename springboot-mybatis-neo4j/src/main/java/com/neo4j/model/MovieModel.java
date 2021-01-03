package com.neo4j.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @TableField("release")
    private String release;

    @TableField("producer")
    private String producer;

    @TableField("actor")
    private String actor;

    @TableField("score")
    private float score;
}
