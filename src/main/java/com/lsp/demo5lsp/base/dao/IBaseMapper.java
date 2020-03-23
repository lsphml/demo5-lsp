package com.lsp.demo5lsp.base.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsp.demo5lsp.base.entity.BaseEntity;


public interface IBaseMapper<T extends BaseEntity> extends BaseMapper<T> {
}
