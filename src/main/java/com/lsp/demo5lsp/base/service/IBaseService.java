package com.lsp.demo5lsp.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lsp.demo5lsp.base.entity.BaseEntity;

/**
 * @Description TODO
 * @Author lsp
 * @Date 2020/3/23 17:24
 */
public interface IBaseService<T extends BaseEntity> extends IService<T> {
}
