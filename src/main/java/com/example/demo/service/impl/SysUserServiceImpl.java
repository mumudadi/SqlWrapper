package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SysRole;
import com.example.demo.entity.SysUser;
import com.example.demo.entity.SysUserRole;
import com.example.demo.entity.vo.SysUserVO;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.service.ISysUserService;
import com.example.demo.support.Condition;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Author lz
 * @Description 用户接口实现层
 * @Date 2018/10/9 11:33
 * @Version V1.0
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public IPage<SysUserVO> findPage(Page<SysUserVO> page, SysUserVO sysUserVO) {

        return baseMapper.findPage(page, Condition.get(sysUserVO).from(SysUser.class,"u")
                .leftJoin(SysUserRole.class,"ur","ur.user_id=u.id")
                .leftJoin(SysRole.class,"r","ur.role_id=r.id"));
    }

}
