package sopt_android_20th.week8_pratice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by pc on 2017-06-02.
 */

public class FooterViewHolder extends RecyclerView.ViewHolder {
    EditText writer_edit;
    EditText content_edit;
    Button commentBtn;

    public FooterViewHolder(View itemView) {
        super(itemView);
        writer_edit = (EditText) itemView.findViewById(R.id.comment_writer_edit);
        content_edit = (EditText) itemView.findViewById(R.id.comment_content_edit);
        commentBtn = (Button) itemView.findViewById(R.id.commentBtn);
    }
}