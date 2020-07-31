package cn.tedu.service;

import cn.tedu.mapper.ItemMapper;
import cn.tedu.pojo.Item;
import cn.tedu.vo.EasyUITable;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Resource
	private ItemMapper itemMapper;
	/**
	 * 执行步骤:1.手动编辑sql    2.利用MP机制 动态生成
	 * SELECT * FROM tb_item LIMIT 起始位置,查询记录数
	 /*第一页 java中数组运算 一般都是含头不含尾
	 SELECT * FROM tb_item LIMIT 0,20;
	 /*第二页
	 SELECT * FROM tb_item LIMIT 20,20;
	 /*第三页
	 SELECT * FROM tb_item LIMIT 40,20;
	 *第N页
	 SELECT * FROM tb_item LIMIT (n-1)ROWS,ROWS;
	 */
	@Override
	public EasyUITable findItemByPage(Integer page, Integer rows) {
		//参数1.记录总数   参数2: rows 当前页的记录数
		long total=itemMapper.selectCount(null);
		int startIndex=(page-1)*rows;
		List<Item> itemList=itemMapper.findItemByPage(startIndex,rows);
		return new EasyUITable(total,itemList);
	}

}
