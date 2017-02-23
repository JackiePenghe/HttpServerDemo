package cn.almsound.www.testhttpserver.adapter.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 为万能适配器创建的通用的ViewHolder
 * <p>
 * Created by ALM on 2016/7/7.
 */
public class ViewHolder {
    private final SparseArray<View> views;

    private int position;

    private View convertView;

    private ImageLoader imageLoader;

    private ViewHolder(Context context, ViewGroup parent, int layoutId,
                       int position) {
        this.position = position;
        this.views = new SparseArray<>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        // setTag
        convertView.setTag(this);
        imageLoader = ImageLoader.getInstance(context);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context 上下文
     * @param convertView 容器
     * @param parent 父容器
     * @param layoutId 布局的id
     * @param position 选中的位置
     * @return viewHolder
     */
    @SuppressWarnings("WeakerAccess")
    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return convertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId viewId
     * @return T类型
     */
    @SuppressWarnings("WeakerAccess")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        //noinspection unchecked
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId viewId
     * @param string string
     * @return ViewHolder
     */
    public ViewHolder setText(int viewId, CharSequence string) {
        TextView view = getView(viewId);
        view.setText(string);
        return this;
    }

    /**
     * 获取edit文本
     *
     * @param viewId viewId
     * @return edit文本
     */
    public String getEditText(int viewId) {
        EditText ed = getView(viewId);
        return ed.getText().toString();
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @param drawableId drawableId
     * @return ViewHolder
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @return ViewHolder
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @return ViewHolder
     */
    public ViewHolder setImageByUrl(int viewId, String url, boolean circle) {
        ImageView imageView = getView(viewId);
        imageLoader.displayImage(url, imageView, circle);
        return this;
    }

    /**
     * 给view设置背景色
     *
     * @param viewId viewId
     * @param color color
     * @return ViewHolder
     */
    public ViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public int getPosition() {
        return position;
    }

}
