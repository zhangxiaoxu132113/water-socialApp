package com.water.db.service.interfaces;

import com.water.db.model.dto.ITTagDto;

import java.util.List;

public interface ITTagService {
    List<ITTagDto> getAllTags();
}