package com.example.zhumeilu.listviewtest;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhumeilu.listviewtest.model.Fruit;

import java.util.List;

/**
 * Created by zhumeilu on 2017/5/2.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {


    private int resourceId;

    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    //    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
////        return super.getView(position, convertView, parent);
//        Fruit item = getItem(position);     //获取当前项的fruit实例
//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        ImageView imageView = (ImageView
//                ) view.findViewById(R.id.fruit_image);
//        TextView textView = (TextView) view.findViewById(R.id.fruit_name);
//        imageView.setImageResource(item.getId());
//        textView.setText(item.getName());
//        return view;
//    }
//
    /**
     * 优化1
     * 将view存储到convertView中
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        Fruit item = getItem(position);     //获取当前项的fruit实例
//        View view = null;
//        if(convertView!=null)
//            view = convertView;
//        else
//            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        ImageView imageView = (ImageView
//                ) view.findViewById(R.id.fruit_image);
//        TextView textView = (TextView) view.findViewById(R.id.fruit_name);
//        imageView.setImageResource(item.getId());
//        textView.setText(item.getName());
//        return view;
//    }

    /**
     * 优化2
     * 将控件封装成一个对象存储到view中
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit item = getItem(position);     //获取当前项的fruit实例
        View view = null;
        ViewHolder viewHolder;
        if (convertView != null){
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        else {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView
                    ) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }
        viewHolder.fruitImage.setImageResource(item.getId());
        viewHolder.fruitName.setText(item.getName());
        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
