package com.lsp.demo5lsp.base.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/18 18:37
 **/
public class BaseEntity<T extends BaseEntity<?>> extends Model<T> {
}
