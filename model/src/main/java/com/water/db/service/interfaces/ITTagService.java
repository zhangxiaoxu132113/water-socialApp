package com.water.db.service.interfaces;

import com.water.uubook.model.dto.TbUbTagDto;

import java.util.List;
import java.util.Map;

public interface ITTagService {
    List<TbUbTagDto> getAllParentTags();

    List<TbUbTagDto> getAllTags();

    Map<String, TbUbTagDto> getTagMap();
}