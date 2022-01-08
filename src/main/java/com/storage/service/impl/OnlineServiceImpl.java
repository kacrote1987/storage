package com.storage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.storage.entity.form.CartForm;
import com.storage.entity.form.GoodsForm;
import com.storage.entity.form.LoginForm;
import com.storage.entity.vo.*;
import com.storage.exception.UnAuthorizationException;
import com.storage.mapper.OnlineMapper;
import com.storage.service.OnlineService;
import com.storage.util.MyCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class OnlineServiceImpl implements OnlineService {
    @Resource
    OnlineMapper onlineMapper;

    @Override
    public CustomerLoginVo login(LoginForm form) {
        CustomerLoginVo customerLoginVo=onlineMapper.selectByUsername(form.getUsername(),form.getPassword());
        if(customerLoginVo==null){
            throw new UnAuthorizationException("用户名或密码错误");
        }
        customerLoginVo.setToken(UUID.randomUUID().toString());
        MyCache.put(customerLoginVo.getToken(),customerLoginVo,30, TimeUnit.MINUTES);
        return customerLoginVo;
    }

    @Override
    public Page<GoodsVo> selectGoods(GoodsForm goodsForm) {
        PageHelper.startPage(goodsForm.getPageNo(),goodsForm.getPageSize());
        Page<GoodsVo> goodsVoPage=onlineMapper.selectGoods(goodsForm.getDictId(),goodsForm.getName(),goodsForm.getVipDiscount());
        return goodsVoPage;
    }

    @Override
    public void insertCart(Long customerId,Long goodsId,Long num) {
        String bl=onlineMapper.selectOne(customerId,goodsId);
        if(bl==null){
            onlineMapper.insertCart(customerId,goodsId,num);
        }else{
            onlineMapper.plusCart(customerId,goodsId,num);
        }
    }

    @Override
    public void deleteCart(Long customerId, Long goodsId,Long num) {
        String bl=onlineMapper.selectOne(customerId,goodsId);
        if(bl==num.toString()){
            onlineMapper.deleteCart(customerId,goodsId);
        }else{//减少数字num的最大值应该在页面上控制为大于0，小于等于购物车中该商品的最大值。因此else中只包含小于num的情况。
            onlineMapper.minusCart(customerId,goodsId,num);
        }
    }

    @Override
    public CartVo selectCart(Long customerId) {
        CartVo cartVo=onlineMapper.selectCart(customerId,onlineMapper.getDiscount(customerId));
        return cartVo;
    }

    @Override
    public void createOrder(CartForm cartForm) {
        String orderNo=UUID.randomUUID().toString();
        onlineMapper.createOrder(orderNo,cartForm.getCustomerId(),2,-1,-1);
        Long orderId=onlineMapper.getOrderId(orderNo);
        for(int i=0;i<cartForm.getList().size();i++){
            onlineMapper.createOrderDetail(orderId,cartForm.getList().get(i).getId(),cartForm.getList().get(i).getNum());
        }
        //计算订单总价并更新
        onlineMapper.updatePrice(orderId);
    }

    @Override
    public void updateScore(CartForm cartForm) {
        Long customerId=cartForm.getCustomerId();
        for(int i=0;i<cartForm.getList().size();i++){
            //更新用户积分
            onlineMapper.updateScore(customerId,cartForm.getList().get(i).getId(),cartForm.getList().get(i).getNum());
        }
        //更新VIP等级
        onlineMapper.updateVip(customerId);
    }

    @Override
    public OrderVo myOrder(Long customerId) {
        OrderVo orderVo=onlineMapper.selectMyorder(customerId);
        orderVo.setList(onlineMapper.selectMyorderDetail(orderVo.getId()));
        return orderVo;
    }
}
