package com.fxc.repository;

import com.fxc.entity.Goods;

public interface GoodsRepository {
    public Goods findById(int id);
}
