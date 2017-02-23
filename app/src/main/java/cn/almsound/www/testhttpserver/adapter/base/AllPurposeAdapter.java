package cn.almsound.www.testhttpserver.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


/**
 * 自定义万能适配器
 * <p>
 * Created by ALM on 2016/6/28.
 */
public abstract class AllPurposeAdapter<T> extends BaseAdapter {

    /**
     * 布局加载器
     */
    private LayoutInflater mInflater;

    /**
     * 上下文
     */
    private Context mContext;

    /**
     * 数据内容
     */
    private List<T> mDatas;

    /**
     * adapterView的布局Id
     */
    private final int mItemLayoutId;

    /**
     * item的数量
     */
    private int countSum = -1;

    /**
     * 构造方法
     * @param context 上下文
     * @param mDatas 数据
     * @param itemLayoutId adapterView的布局Id
     */
    public AllPurposeAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }


    /**
     * 替换元素并刷新
     *
     * @param mDatas 要替换的元素列表
     */
    public void refresh(List<T> mDatas) {
        this.mDatas = mDatas;
        this.notifyDataSetChanged();
    }

    /**
     * 删除元素并更新
     *
     * @param position 要删除的元素所在的位置
     */
    public void deleteList(int position) {
        this.mDatas.remove(position);
        this.notifyDataSetChanged();
    }

    /**
     * 定义item的总数
     *
     * @param i 要设置的item总数
     * @return 返回一个AllPurposeAdapter对象
     */
    public AllPurposeAdapter setCount(int i) {
        countSum = i;
        this.notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        if (countSum == -1) {
            return mDatas.size();
        } else {
            return countSum;
        }
    }

    @Override
    public T getItem(int position) {
        if (countSum == -1) {
            return mDatas.get(position);
        } else {
            return mDatas.get(countSum % mDatas.size());
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView,
                parent);
        convert(viewHolder, position, getItem(position));
        return viewHolder.getConvertView();

    }

    public abstract void convert(ViewHolder holder, int position, T item);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
                position);
    }
}
