package com.example.gridadapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    private Context mContext = null;
    private int[] data = null;

    public CustomAdapter(Context c, int[] d){
        this.mContext = c;
        this.data = d;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(data[position]);

        // 클릭 추가
        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                View dialogView = View.inflate(mContext, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(mContext);
                ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                dlg.setTitle("Big POSTER");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                dlg.setView(dialogView);
                dlg.setNegativeButton("close", null);
                dlg.show();
            }
        });
        return imageView;
    }
}
