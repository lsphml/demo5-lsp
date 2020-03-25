package com.lsp.demo5lsp.practise.deepCopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/25 14:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name implements Serializable {

    private String firstName;

    private String lastName;
}
