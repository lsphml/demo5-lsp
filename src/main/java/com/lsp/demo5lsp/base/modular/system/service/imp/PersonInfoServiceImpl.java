package com.lsp.demo5lsp.base.modular.system.service.imp;

import com.lsp.demo5lsp.base.modular.system.model.PersonInfoEntity;
import com.lsp.demo5lsp.base.modular.system.dao.PersonInfoMapper;
import com.lsp.demo5lsp.base.modular.system.service.IPersonInfoService;
import com.lsp.demo5lsp.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsp
 * @since 2020-03-23
 */
@Service
public class PersonInfoServiceImpl extends BaseServiceImpl<PersonInfoMapper, PersonInfoEntity> implements IPersonInfoService {

}
