package cn.almsound.www.testhttpserver.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.almsound.www.testhttpserver.R;
import cn.almsound.www.testhttpserver.adapter.base.AllPurposeAdapter;
import cn.almsound.www.testhttpserver.adapter.base.ViewHolder;
import cn.almsound.www.testhttpserver.utils.LogUtil;

/**
 * Created by jacke on 2017/2/22 0022.
 * ListViewAdapter
 */

public class ListViewAdapter extends AllPurposeAdapter<String> {
    /**
     * 构造方法
     *
     * @param context      上下文
     * @param mDatas       数据
     */
    public ListViewAdapter(Context context, List<String> mDatas) {
        super(context, mDatas, R.layout.layout_adapter_list_view);
    }

    @Override
    public void convert(ViewHolder holder, int position, String item) {
        LogUtil.w("ListAdapter", "position = " + position);
        holder.setText(R.id.position,String.valueOf(position + 1));
        View convertView = holder.getConvertView();
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setTextSize(13);
        textView.setText(item);
    }
}
