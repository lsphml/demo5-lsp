package com.lsp.demo5lsp.base.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsp.demo5lsp.base.entity.BaseEntity;

/**
 * @Description TODO
 * @Author lsp
 * @Date 2020/3/23 17:24
 */
public interface IBaseMapper<T extends BaseEntity> extends BaseMapper<T> {
}
