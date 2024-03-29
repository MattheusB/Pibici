package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.mattheusbrito.pibiti.release.Release;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import android.widget.Spinner;
import android.widget.Toast;

import com.example.mattheusbrito.pibiti.R;

import java.util.ArrayList;
import java.util.Calendar;


public class FormActivity extends Activity implements View.OnClickListener {


    private EditText producaoHoraria1;
    private EditText producaoEmbalada1;
    private EditText retrabalho;
    private EditText descarte;
    private EditText sobrepeso;
    private EditText embalagemPerdida;
    private EditText embalagemProdutosAcabados;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef = database.getReference();

    ArrayList<Release> lancamentos = new ArrayList<>();


    private ConstraintLayout constraintProducaoHoraria;
   private ConstraintLayout constraintProducaoEmbalada;
   private ConstraintLayout constraintPerdasQualidade;
   private ConstraintLayout constraintEmbalagemUtilizada;

    private Spinner spinner;

    private ArrayAdapter<CharSequence> indicators;

    private Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        producaoHoraria1 = (EditText) findViewById(R.id.producaoHoraria1);
        producaoEmbalada1 = (EditText) findViewById(R.id.producaoEmbalada1);
        retrabalho = (EditText) findViewById(R.id.perdasQualidade1);
        descarte = (EditText) findViewById(R.id.perdasQualidade2);
        sobrepeso = (EditText) findViewById(R.id.perdasQualidade3);
        embalagemPerdida = (EditText) findViewById(R.id.embalagemUtilizada1);
        embalagemProdutosAcabados = (EditText) findViewById(R.id.embalagemUtilizada2);




        spinner = (Spinner) findViewById(R.id.spinnerID);

        indicators = ArrayAdapter.createFromResource(this, R.array.indicatorsArray, android.R.layout.simple_spinner_item);
        indicators.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        constraintProducaoHoraria = (ConstraintLayout) findViewById(R.id.constraintProducaoHoraria);
        constraintProducaoEmbalada = (ConstraintLayout) findViewById(R.id.constraintProducaoEmbalada);
        constraintPerdasQualidade = (ConstraintLayout) findViewById(R.id.constraintPerdasQualidade);
        constraintEmbalagemUtilizada = (ConstraintLayout) findViewById(R.id.constraintEmbalagemUtilizada);


        spinner.setAdapter(indicators);

        sendButton = (Button) findViewById(R.id.sendButtonID);







        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position){
                    case 0:
                        setAllGone();
                        constraintProducaoHoraria.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setAllGone();
                        constraintProducaoEmbalada.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setAllGone();
                        constraintPerdasQualidade.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        setAllGone();
                        constraintEmbalagemUtilizada.setVisibility(View.VISIBLE);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });



        sendButton.setOnClickListener(this);

    }

    public void sendProducaoHoraria() {

        String nomeIndicador = "Producao Horaria";
        int valorProducaoHoraria = Integer.parseInt(producaoHoraria1.getText().toString());

        Release release = new Release(nomeIndicador, valorProducaoHoraria);
        lancamentos.add(release);
        databaseRef.child("lancamentos").setValue(lancamentos);




    }

    public void sendProducaoEmbalada() {

        String nomeIndicador = "Producao Embalada";
        int valorProducaoEmbalada = Integer.parseInt(producaoEmbalada1.getText().toString());

        Release release = new Release(nomeIndicador, valorProducaoEmbalada);
        lancamentos.add(release);
        databaseRef.child("lancamentos").setValue(lancamentos);


    }

    public void sendEmbalagemUtilizada() {

        String nomeIndicador = "Embalagem Utilizada";
        int valorEmbalagemPerdida = Integer.parseInt(embalagemPerdida.getText().toString());
        int valorProdutosAcabados = Integer.parseInt(embalagemProdutosAcabados.getText().toString());

        Release release = new Release(nomeIndicador, valorEmbalagemPerdida, valorProdutosAcabados);
        lancamentos.add(release);
        databaseRef.child("lancamentos").setValue(lancamentos);


    }

    public void sendPerdasQualidade() {

        String nomeIndicador = "Perdas de Qualidade";
        int valorRetrabalho = Integer.parseInt(retrabalho.getText().toString());
        int valorDescarte = Integer.parseInt(descarte.getText().toString());
        int valorSobrepeso = Integer.parseInt(sobrepeso.getText().toString());

        Release release = new Release(nomeIndicador, valorRetrabalho, valorDescarte, valorSobrepeso);
        lancamentos.add(release);
        databaseRef.child("lancamentos").setValue(lancamentos);


    }


    @Override
    public void onClick(View v) {
        if (constraintProducaoHoraria.getVisibility() == View.VISIBLE){
            sendProducaoHoraria();
        }else if (constraintProducaoEmbalada.getVisibility() == View.VISIBLE){
            sendProducaoEmbalada();
        } else if (constraintEmbalagemUtilizada.getVisibility() == View.VISIBLE){
            sendEmbalagemUtilizada();
        }else if (constraintPerdasQualidade.getVisibility() == View.VISIBLE){
            sendPerdasQualidade();
        }
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }


    private void setAllGone(){
        constraintProducaoHoraria.setVisibility(View.GONE);
        constraintProducaoEmbalada.setVisibility(View.GONE);
        constraintPerdasQualidade.setVisibility(View.GONE);
        constraintEmbalagemUtilizada.setVisibility(View.GONE);
    }




}
