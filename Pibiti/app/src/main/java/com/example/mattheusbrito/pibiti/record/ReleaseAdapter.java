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
import java.util.zip.Inflater;

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
        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = view == null ? inflater.inflate(R.layout.release, viewGroup, false) : view;
        final RecordViewHolder releaseViewHolder = new RecordViewHolder();

        releaseViewHolder.indicator1View = view.findViewById(R.id.recordIndicator1);

        Release release = (Release) getItem(i);
        releaseViewHolder.indicator1View.setText(release.indicador1.toString());
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
