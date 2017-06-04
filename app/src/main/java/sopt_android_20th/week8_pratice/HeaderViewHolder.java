package sopt_android_20th.week8_pratice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pc on 2017-06-02.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public static TextView header_text;    //static 변수로 선언 (메인 부분에서 접근하기 위해)

    public HeaderViewHolder(View itemView) {
        super(itemView);
        header_text = (TextView) itemView.findViewById(R.id.header_text);

    }
}