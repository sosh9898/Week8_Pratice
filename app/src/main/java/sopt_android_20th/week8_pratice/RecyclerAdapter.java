package sopt_android_20th.week8_pratice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by pc on 2017-03-23.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    ArrayList<Itemdata_recyclerview> itemdata;
    Context context;
    View.OnClickListener onClickListener;

    public RecyclerAdapter(ArrayList<Itemdata_recyclerview> itemdata, View.OnClickListener onClickListener, Context context) {
        this.context = context;
        this.itemdata = itemdata;
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (context).inflate (R.layout.custom_recyclerview_header, parent, false);
            v.setOnClickListener(onClickListener);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_FOOTER) {
            View v = LayoutInflater.from (context).inflate (R.layout.custom_recyclerview_footer, parent, false);
            return new FooterViewHolder (v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (context).inflate (R.layout.custom_recyclerview_item, parent, false);
            v.setOnClickListener(onClickListener);
            return new BaseViewHolder (v);
        }
        return null;
    }
    public RecyclerView.ViewHolder getViewHolder(View view){
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderViewHolder) {

        } else if(holder instanceof FooterViewHolder) {
            final FooterViewHolder footerHolder = (FooterViewHolder) holder;
            footerHolder.commentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(footerHolder.writer_edit.length()==0||footerHolder.content_edit.length()==0){
                        Toast.makeText(context, "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                         String temp_writer = footerHolder.writer_edit.getText().toString();
                         String temp_content = footerHolder.content_edit.getText().toString();
                        itemdata.add(new Itemdata_recyclerview(temp_writer, temp_content));
                        notifyDataSetChanged();
                        Toast.makeText(context, "댓글 등록", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } else if(holder instanceof BaseViewHolder) {
            Itemdata_recyclerview currentItem = itemdata.get(position-1);
            BaseViewHolder BaseViewHolder = (BaseViewHolder) holder;
            BaseViewHolder.writer_text.setText ("작성자 : "+currentItem.writer);
            BaseViewHolder.content_text.setText("내용 : "+currentItem.content);
        }
    }


    @Override
    public int getItemViewType (int position) {
        if(position == 0) {
            return TYPE_HEADER;
        } else if(position == itemdata.size () + 1) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }


    @Override
    public int getItemCount () {
        return itemdata!=null ? itemdata.size () + 2:0;
    }
}
