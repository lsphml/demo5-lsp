package com.lsp.demo5lsp.base.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsp.demo5lsp.base.dao.IBaseMapper;
import com.lsp.demo5lsp.base.entity.BaseEntity;


/**
 * @author lsp
 * @description TODO
 * @date 2020/3/18 18:46
 **/
public class BaseServiceImpl<M extends IBaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M,T> {
}
