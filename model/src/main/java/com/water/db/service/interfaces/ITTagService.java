package com.water.db.service.interfaces;

import com.water.uubook.model.dto.ITTagDto;

import java.util.List;
import java.util.Map;

public interface ITTagService {
    List<ITTagDto> getAllParentTags();

    List<ITTagDto> getAllTags();

    Map<String, ITTagDto> getTagMap();
}