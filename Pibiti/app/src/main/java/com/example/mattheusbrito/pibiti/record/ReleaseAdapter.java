package com.example.mattheusbrito.pibiti.record;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mattheusbrito.pibiti.R;

import java.util.List;

public class ReleaseAdapter extends BaseAdapter {

    private Context recordContext;
    private List<Release> releaseList;

    public ReleaseAdapter(Context context, List<Release> releases) {
        releaseList = releases;
        recordContext = context;
    }

    public void add(Release release) {
        releaseList.add(release);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RecordViewHolder holder;

        if (view ==null){
            LayoutInflater recordInflater = (LayoutInflater)
                    recordContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = recordInflater.inflate(R.layout.release, null);

            holder = new RecordViewHolder();
            holder.indicator1View = (TextView) view.findViewById(R.id.recordIndicator1);
            holder.indicator2View = (TextView) view.findViewById(R.id.recordIndicator2);
            holder.indicator3View = (TextView) view.findViewById(R.id.recordIndicator3);
            holder.indicator4View = (TextView) view.findViewById(R.id.recordIndicator4);
            view.setTag(holder);

        }else {
            holder = (RecordViewHolder) view.getTag();
        }

        Release release = (Release) getItem(i);
        holder.indicator1View.setText(release.indicator1);
        holder.indicator2View.setText(release.indicator2);
        holder.indicator3View.setText(release.indicator3);
        holder.indicator4View.setText(release.indicator4);
        return view;
    }

    private static class RecordViewHolder {

        public TextView indicator1View;

        public TextView indicator2View;
        public TextView indicator3View;
        public TextView indicator4View;
    }

    @Override
    public int getCount() {
        return releaseList.size();
    }
    @Override
    public Object getItem(int i) {
        return releaseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
