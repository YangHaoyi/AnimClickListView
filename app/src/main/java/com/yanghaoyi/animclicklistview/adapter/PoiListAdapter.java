package com.yanghaoyi.animclicklistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanghaoyi.animclicklistview.R;
import com.yanghaoyi.animclicklistview.model.data.ChargeStation;

import java.util.List;

/**
 * @author : YangHaoYi on 2018/9/28.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/28.
 *         Version : V 1.0
 */
public class PoiListAdapter extends RecyclerView.Adapter<PoiListAdapter.ViewHolder>{

    private OnItemClickListener onItemClickListener;
    private List<ChargeStation> list;

    public PoiListAdapter(List<ChargeStation> list){
        this.list = list;
    }

    public interface OnItemClickListener{
        /**
         *  Item点击事件
         * @param view item
         * @param name item 名字
         * */
        void onItemClick(View view,String name);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poi_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(holder.itemView,holder.tvName.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_poi_name);
        }
    }
}
