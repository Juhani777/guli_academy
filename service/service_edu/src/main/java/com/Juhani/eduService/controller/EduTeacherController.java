package com.Juhani.eduService.controller;


import com.Juhani.commonutils.R;
import com.Juhani.eduService.entity.EduTeacher;
import com.Juhani.eduService.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public R findAllTeacher(){
         List<EduTeacher> list = teacherService.list(null);
         return R.ok().data("items",list);
    }

    //逻辑删除讲师的方法
    @DeleteMapping("{id}")   //id需要通过路径传递
    public R removeTeacher(@PathVariable String id){   //获取
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }


    //分页查询讲师方法
    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,@PathVariable long limit){
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        teacherService.page(pageTeacher,null);
        long total = pageTeacher.getTotal();//总记录数
         List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);

    }

}

