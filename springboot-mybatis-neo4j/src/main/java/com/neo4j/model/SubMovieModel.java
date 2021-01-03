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
public class SubMovieModel {
    @TableField(value = "asin")
    private String asin;

    @TableField(value = "format")
    private String format;

    @TableField(value = "version")
    private String version;

    @TableField(value = "score")
    private float score;
}
