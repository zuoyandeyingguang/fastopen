package com.pengfei.fastopen.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用的Adapter 通过实现里面的bindItemDatas方法，即可将要绑定的数据绑定到视图上<br>
 *
 * @param <T> 要Adapter显示的数据的封装类<br>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;

    protected List<T> mList;

    private int mItemLayoutResource;

    public CommonAdapter(Context mContext, List<T> mList, int mItemLayoutResource) {
        this.mContext = mContext;
        this.mList = mList;
        this.mItemLayoutResource = mItemLayoutResource;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getHolder(mContext, position,
                convertView, parent, mItemLayoutResource);

        bindItemDatas(holder, mList.get(position));

        return holder.getConvertView();
    }

    /**
     * 为ListView的Item绑定数据
     *
     * @param holder 通过holder的getView来获取到item的控件
     * @param bean   bean 数据
     */
    public abstract void bindItemDatas(ViewHolder holder, T bean);

}
