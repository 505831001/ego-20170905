package com.ego.service.impl;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;
import com.ego.entity.TbItemParamPlus;
import com.ego.mapper.TbItemCatMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.service.TbItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 商品规则参数 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    private EasyUIPageVO easyUIPageVO;

    @Override
    public EasyUIPageVO list(int pageNum, int pageSize) {
        EasyUIPageVO easyUIPageVO = new EasyUIPageVO();
        List<TbItemParamPlus> plusList = new LinkedList<>();
        List<TbItemParam> itemParamList = new LinkedList<>();
        if (CollectionUtils.isEmpty(itemParamList)) {
            itemParamList = (List<TbItemParam>) this.easyUIPageVO.getRows();
        }
        for (TbItemParam po : itemParamList) {
            TbItemParamPlus vo = new TbItemParamPlus();
            vo.setId(po.getId());
            vo.setItemCatId(po.getItemCatId());
            vo.setParamData(po.getParamData());
            vo.setCreated(po.getCreated());
            vo.setUpdated(po.getUpdated());
            String itemCatName = tbItemCatMapper.selectByPrimaryKey(po.getItemCatId()).getName();
            vo.setItemCatName(itemCatName);
            System.out.println("TbItemParamPlus ->" + vo.toString());
            plusList.add(vo);
        }
        System.out.println("plusList ->" + plusList.toString());
        easyUIPageVO.setRows(plusList);
        return easyUIPageVO;
    }
}
