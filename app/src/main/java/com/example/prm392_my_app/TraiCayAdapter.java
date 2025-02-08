package com.example.prm392_my_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    // Constructor
    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return traiCayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);

        // Bind views
        TextView txtTen = view.findViewById(R.id.textviewTen);
        TextView txtMota = view.findViewById(R.id.textviewMota);
        ImageView imageHinh = view.findViewById(R.id.imageviewHinh);

        // Get current TraiCay
        TraiCay traiCay = traiCayList.get(position);

        // Set values
        txtTen.setText(traiCay.getTen());
        txtMota.setText(traiCay.getMota());
        imageHinh.setImageResource(traiCay.getHinh());

        return view;
    }
}
