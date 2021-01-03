package com.neo4j.mapper;

import com.neo4j.model.CooperationModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CoopMapper {
    ArrayList<CooperationModel> getCoopAD(@Param(value = "count") int count);

    ArrayList<CooperationModel> getCoopAA(@Param(value = "count") int count);

    ArrayList<CooperationModel> getCoopDD(@Param(value = "count") int count);

    ArrayList<CooperationModel> getActorByDirector(@Param(value = "count") int count,
                                                   @Param(value = "director") String director);

    ArrayList<CooperationModel> getActorByActor(@Param(value = "count") int count,
                                                @Param(value = "actor") String actor);

    ArrayList<CooperationModel> getDirectorByDirector(@Param(value = "count") int count,
                                                      @Param(value = "director") String director);

    ArrayList<CooperationModel> getDirectorByActor(@Param(value = "count") int count,
                                                   @Param(value = "actor") String actor);
}
