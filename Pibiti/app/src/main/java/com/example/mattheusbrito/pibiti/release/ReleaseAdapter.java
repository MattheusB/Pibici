package com.example.mattheusbrito.pibiti.release;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mattheusbrito.pibiti.R;

import java.util.List;

public class ReleaseAdapter extends BaseAdapter {

    private Context releaseContext;
    private List<Release> releaseList;

    public ReleaseAdapter(Context context, List<Release> releases) {
        releaseList = releases;
        releaseContext = context;
    }

    public void add(Release release) {
        releaseList.add(release);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = view == null ? inflater.inflate(R.layout.release, viewGroup, false) : view;
        final ReleaseViewHolder releaseViewHolder = new ReleaseViewHolder();




        releaseViewHolder.indicator1View = view.findViewById(R.id.releaseIndicator1);
        releaseViewHolder.indicator2View = view.findViewById(R.id.releaseIndicator2);
        releaseViewHolder.indicator3View = view.findViewById(R.id.releaseIndicator3);
        releaseViewHolder.indicator4View = view.findViewById(R.id.releaseIndicator4);


        Release release = (Release) getItem(i);
        releaseViewHolder.indicator1View.setText(release.indicador1);

        if (releaseViewHolder.indicator1View.getText().equals("Producao Horaria")){


            releaseViewHolder.indicator2View.setText(Integer.toString(release.indicador2) + " kg/h");

            if (release.indicador2 > 100){
                releaseViewHolder.indicator3View.setText("Acima da meta");
            }
            else if (release.indicador2 > 90 && release.indicador2 <= 100){
                releaseViewHolder.indicator3View.setText("Na meta");
            }else{
                releaseViewHolder.indicator3View.setText("Abaixo da meta");
            }

        }
        else if(releaseViewHolder.indicator1View.getText().equals("Producao Embalada")){

            releaseViewHolder.indicator2View.setText(Integer.toString(release.indicador2) + " kg");

            if (release.indicador2 > 100){
                releaseViewHolder.indicator3View.setText("Acima da meta");
            }
            else if (release.indicador2 > 90 && release.indicador2 <= 100){
                releaseViewHolder.indicator3View.setText("Na meta");
            }else{
                releaseViewHolder.indicator3View.setText("Abaixo da meta");
            }
        }
        else if (releaseViewHolder.indicator1View.getText().equals("Embalagem Utilizada")){



            int total = release.indicador2 + release.indicador3;

            releaseViewHolder.indicator2View.setText(Integer.toString(total) + " kg");

            if (total > 20){
                releaseViewHolder.indicator3View.setText("Acima da meta");
            }
            else if (total > 10 && total <= 20){
                releaseViewHolder.indicator3View.setText("Na meta");
            }else{
                releaseViewHolder.indicator3View.setText("Abaixo da meta");
            }
        }
        else if (releaseViewHolder.indicator1View.getText().equals("Perdas de Qualidade")){

            int total = release.indicador2 + release.indicador3 + release.indicador4;

            releaseViewHolder.indicator2View.setText(Integer.toString(total) + " %");

            if (total > 20){
                releaseViewHolder.indicator3View.setText("Abaixo da meta");
            }
            else if (total > 10 && total <= 20){
                releaseViewHolder.indicator3View.setText("Na meta");
            }else{
                releaseViewHolder.indicator3View.setText("Acima da meta");
            }

        }



        releaseViewHolder.indicator4View.setText("Detalhes");
        return view;
    }

    private static class ReleaseViewHolder {

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
