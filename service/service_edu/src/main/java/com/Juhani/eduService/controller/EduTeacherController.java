package com.Juhani.eduService.controller;


import com.Juhani.eduService.entity.EduTeacher;
import com.Juhani.eduService.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Juhani
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/eduService/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;
    //查询讲师数据
    //rest风格
    @GetMapping("/findAll")
    public List<EduTeacher> findAllTeacher(){
         List<EduTeacher> list = teacherService.list(null);
         return list;
    }

    //逻辑删除讲师的方法
    @DeleteMapping("{id}")   //id需要通过路径传递
    public boolean removeTeacher(@PathVariable String id){   //获取
        boolean flag = teacherService.removeById(id);
        return flag;
    }

}

