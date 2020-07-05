package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SysUser;
import com.example.demo.entity.vo.SysUserVO;

/**
 * @ClassName ISysUserService
 * @Author lz
 * @Description 用户接口层
 * @Date 2018/10/9 11:32
 * @Version V1.0
 **/
public interface ISysUserService extends IService<SysUser> {


    IPage<SysUserVO> findPage(Page<SysUserVO> page, SysUserVO sysUserVO);

}
