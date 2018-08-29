package com.bksx.nettest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.NewsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by try on 2018/5/8.
 */

public class NewsAdapter extends BaseAdapterHelper<NewsBean.ResultBean.DataBean> {

    public NewsAdapter(Context context, List<NewsBean.ResultBean.DataBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_news, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(list.get(position).getTitle());
        Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(viewHolder.header);
        return convertView;
    }

    class ViewHolder{

        ImageView header;
        TextView title;

        public ViewHolder(View rootView) {
            this.header = rootView.findViewById(R.id.iv_header);
            this.title = rootView.findViewById(R.id.tv_title);
        }
    }
}
