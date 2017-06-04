package sopt_android_20th.week8_pratice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pc on 2017-06-02.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    TextView writer_text;
    TextView content_text;

    public BaseViewHolder(View itemView) {
        super(itemView);
        writer_text = (TextView) itemView.findViewById(R.id.writer_text);
        content_text = (TextView) itemView.findViewById(R.id.content_text);
    }
}