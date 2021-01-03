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
public class CooperationModel {
    @TableField(value = "actor1")
    private String actor1;

    @TableField(value = "actor2")
    private String actor2;

    @TableField(value = "director1")
    private String director1;

    @TableField(value = "director2")
    private String director2;

    @TableField(value = "count")
    private int count;
}
