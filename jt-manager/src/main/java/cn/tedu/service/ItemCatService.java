package cn.tedu.service;

import cn.tedu.pojo.ItemCat;
import cn.tedu.vo.EasyUITree;

import java.util.List;


public interface ItemCatService {

    ItemCat findItemCatById(Long itemCatId);

    List<EasyUITree> findItemCatListByParentId(Long parentId);
}
