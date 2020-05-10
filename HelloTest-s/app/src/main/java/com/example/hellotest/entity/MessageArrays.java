package com.example.hellotest.entity;

import com.example.hellotest.utils.StoresDood;

import java.util.ArrayList;
import java.util.List;

public class MessageArrays {
    public static List<Canteen> canteens=new ArrayList<>();
    public static List<CarOrder> carOrders=new ArrayList<>();

    //进行中的
    public static List<CarOrder> Orders=new ArrayList<>();
    //显示的订单
    public static List<CarOrder> orders=new ArrayList<>();
    //已完成订单
    public static List<CarOrder> doneOrders=new ArrayList<>();
    public static List<StoresDood> storesDoods=new ArrayList<>();
}
