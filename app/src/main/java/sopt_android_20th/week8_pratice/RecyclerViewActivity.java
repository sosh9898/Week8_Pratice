package sopt_android_20th.week8_pratice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Itemdata_recyclerview> itemdata;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        itemdata = new ArrayList<Itemdata_recyclerview>();
        itemdata.add(new Itemdata_recyclerview("댓글1","입니다1"));
        itemdata.add(new Itemdata_recyclerview("댓글2","입니다2"));
        itemdata.add(new Itemdata_recyclerview("댓글3","입니다3"));
        itemdata.add(new Itemdata_recyclerview("댓글4","입니다4"));
        recyclerAdapter = new RecyclerAdapter(itemdata,onClickListener,getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);

    }
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int tempposition = recyclerView.getChildPosition(view);
            if (tempposition == 0){
                Toast.makeText(getApplicationContext(),"헤더입니다",Toast.LENGTH_SHORT).show();
            }
            else if(tempposition != itemdata.size()+2){
                Toast.makeText(getApplicationContext(),tempposition+"번 댓글",Toast.LENGTH_SHORT).show();
                String temp_header = recyclerAdapter.itemdata.get(tempposition-1).writer;
                HeaderViewHolder.header_text.setText(temp_header);    //static 변수로 선언한 header_text 뷰 객체 제어

            }
        }
    };
}
