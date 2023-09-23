package com.example.gongu.service;

import com.example.gongu.domain.dto.ClassDto;
import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.mapper.ClassMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassService {
    private final ClassMapper classMapper;

    public void register(ClassDto classDto){
        classMapper.insert(classDto);
        log.info(classDto.toString());
    }

    public List<ClassVo> findAll(){
        List<ClassVo> findList = classMapper.selectList();
        return findList;
    }
}
