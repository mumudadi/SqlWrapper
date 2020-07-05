package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.vo.SysUserVO;
import com.example.demo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * 用户后台管理
 *
 * @author 严秋旺
 * @since 2018/9/30 9:20
 **/
@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;
    /**
     * @Description: 获取用户分页数据
     * @Title: manage
     * @author lz
     */
    @RequestMapping("/page")
    public R<IPage<SysUserVO>> page(SysUserVO sysUserVO) {
        Page<SysUserVO> page = new Page(1,10);
        return R.ok(sysUserService.findPage(page, sysUserVO));
    }


}
