package com.lsp.demo5lsp.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lsp.demo5lsp.base.entity.BaseEntity;

public interface IBaseService<T extends BaseEntity> extends IService<T> {
}
