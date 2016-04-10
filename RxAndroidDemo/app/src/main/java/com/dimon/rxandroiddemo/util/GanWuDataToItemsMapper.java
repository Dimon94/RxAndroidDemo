package com.dimon.rxandroiddemo.util;

import com.dimon.rxandroiddemo.db.GanWuData;
import com.dimon.rxandroiddemo.db.entity.News;
import com.dimon.rxandroiddemo.network.ApiException;
import com.dimon.rxandroiddemo.network.Item;
import com.socks.library.KLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将GanWuData的Data部分剥离出来返回给subscriber
 *
 * Created by Dimon on 2016/3/29.
 */
public class GanWuDataToItemsMapper implements Func1<GanWuData, List<Item>> {
    private static GanWuDataToItemsMapper INSTANCE = new GanWuDataToItemsMapper();

    public GanWuDataToItemsMapper() {
    }

    public static GanWuDataToItemsMapper getInstance() {
        KLog.a("到这里3");
        return INSTANCE;
    }

    @Override
    public List<Item> call(GanWuData ganWuData) {
        KLog.a("到这里2");
        if (ganWuData.isError()) {
            throw new ApiException(100);
        }
        List<News> ganwus = ganWuData.results.androidList;
        List<Item> items = new ArrayList<>(ganwus.size());
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for (News ganwu : ganwus) {
            Item item = new Item();
            try {
                Date date = inputFormat.parse(ganwu.createdAt);
                item.date = outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                item.date = "unknown date";
            }
            item.description = ganwu.desc;
            item.url = ganwu.url;
            item.who = ganwu.who;
            items.add(item);
            KLog.a(items);
        }
        return items;
    }
}