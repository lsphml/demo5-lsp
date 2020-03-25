package com.lsp.demo5lsp.practise.linked;

import lombok.Data;

@Data
public class ListNode {
    private int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}
