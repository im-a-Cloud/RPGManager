package com.imd.rpgmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.imd.rpgmanager.model.Personagem;

public class AtributosActivity extends AppCompatActivity {

    Button btnMaisNivel;

    Button btnMenosForca;
    Button btnMaisForca;

    Button btnMenosConstituicao;
    Button btnMaisConstituicao;

    Button btnMenosInteligencia;
    Button btnMaisInteligencia;

    Button btnMenosDestreza;
    Button btnMaisDestreza;

    Button btnMenosSabedoria;
    Button btnMaisSabedoria;

    Button btnMenosCarisma;
    Button btnMaisCarisma;

    Button btnMenosVida;
    Button btnMaisVida;

    Button btnResetar;
    Button btnConfirmar;


    TextView tvPontosAtuais;
    TextView tvNivel;
    TextView tvForca;
    TextView tvConstituicao;
    TextView tvInteligencia;
    TextView tvDestreza;
    TextView tvSabedoria;
    TextView tvCarisma;
    TextView tvVida;

    ProgressBar pbForca;
    ProgressBar pbConstituicao;
    ProgressBar pbInteligencia;
    ProgressBar pbDestreza;
    ProgressBar pbSabedoria;
    ProgressBar pbCarisma;
    ProgressBar pbVida;

    int Nivel = 0;
    int Forca = 0;
    int Constituicao = 0;
    int Inteligencia = 0;
    int Destreza = 0;
    int Sabedoria = 0;
    int Carisma = 0;
    int Vida = 0;

    int VidaMax = 0;

    int PONTOS_POR_NIVEL = 5;
    int NIVEL_MAX = 50;
    int PONTOS_MAX = 0; //baseado no nível do personagem quando upa
    //int ponto_atuais = 0;

    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos);

        getSupportActionBar().hide();

        Intent it = getIntent();
        personagem = (Personagem) it.getExtras().getSerializable("personagem");
        System.out.println("Teste Teste Teste Teste Teste " + personagem.getNome() + personagem.getNivel());

        btnMaisNivel = findViewById(R.id.btnMaisNivel);

        btnMenosForca = findViewById(R.id.btnMenosForca);
        btnMaisForca = findViewById(R.id.btnMaisForca);

        btnMenosConstituicao = findViewById(R.id.btnMenosConstituicao);
        btnMaisConstituicao = findViewById(R.id.btnMaisConstituicao);

        btnMenosInteligencia = findViewById(R.id.btnMenosInteligencia);
        btnMaisInteligencia = findViewById(R.id.btnMaisInteligencia);

        btnMenosDestreza = findViewById(R.id.btnMenosDestreza);
        btnMaisDestreza = findViewById(R.id.btnMaisDestreza);

        btnMenosSabedoria = findViewById(R.id.btnMenosSabedoria);
        btnMaisSabedoria = findViewById(R.id.btnMaisSabedoria);

        btnMenosCarisma = findViewById(R.id.btnMenosCarisma);
        btnMaisCarisma = findViewById(R.id.btnMaisCarisma);

        btnMenosVida = findViewById(R.id.btnMenosVida);
        btnMaisVida = findViewById(R.id.btnMaisVida);

        btnConfirmar = findViewById(R.id.btnCorfirmar);
        btnResetar = findViewById(R.id.btnResetar);

        //Valor dos atributos
        tvPontosAtuais = findViewById(R.id.tvPontosAtuais);
        tvNivel = findViewById(R.id.tvNivel);
        tvForca = findViewById(R.id.tvForca);
        tvConstituicao = findViewById(R.id.tvConstituicao);
        tvInteligencia = findViewById(R.id.tvInteligencia);
        tvDestreza = findViewById(R.id.tvDestreza);
        tvSabedoria = findViewById(R.id.tvSabedoria);
        tvCarisma = findViewById(R.id.tvCarisma);
        tvVida = findViewById(R.id.tvVida);

        //Barras de atributos
        pbForca = findViewById(R.id.pbForca);
        pbConstituicao = findViewById(R.id.pbConstituicao);
        pbInteligencia = findViewById(R.id.pbInteligencia);
        pbDestreza = findViewById(R.id.pbDestreza);
        pbSabedoria = findViewById(R.id.pbSabedoria);
        pbCarisma = findViewById(R.id.pbCarisma);
        pbVida = findViewById(R.id.pbVida);



        tvNivel.setText(String.valueOf(personagem.getNivel()));
        tvForca.setText(String.valueOf(personagem.getForca()));
        tvConstituicao.setText(String.valueOf(personagem.getConstituicao()));
        tvInteligencia.setText(String.valueOf(personagem.getInteligencia()));
        tvDestreza.setText(String.valueOf(personagem.getDestreza()));
        tvSabedoria.setText(String.valueOf(personagem.getSabedoria()));
        tvCarisma.setText(String.valueOf(personagem.getCarisma()));
        tvVida.setText(String.valueOf(personagem.getVida()));

        VidaMax = personagem.getConstituicao() * 2;//cálculo de vida máxima

        tvPontosAtuais.setText("0");

        atualizarProgressBars();

        btnMaisNivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvNivel.getText().toString()) <= NIVEL_MAX) {
                    tvNivel.setText(String.valueOf(Integer.parseInt(String.valueOf(tvNivel.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(PONTOS_POR_NIVEL + Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))));
                    PONTOS_MAX += PONTOS_POR_NIVEL;
                }
            }
        });


        //Força
        btnMenosForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvForca.getText())) > personagem.getForca()){
                    tvForca.setText(String.valueOf(Integer.parseInt(String.valueOf(tvForca.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvForca.setText(String.valueOf(Integer.parseInt(String.valueOf(tvForca.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Constituicao
        btnMenosConstituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvConstituicao.getText())) > personagem.getConstituicao()){
                    tvConstituicao.setText(String.valueOf(Integer.parseInt(String.valueOf(tvConstituicao.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisConstituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvConstituicao.setText(String.valueOf(Integer.parseInt(String.valueOf(tvConstituicao.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Inteligência
        btnMenosInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvInteligencia.getText())) > personagem.getInteligencia()){
                    tvInteligencia.setText(String.valueOf(Integer.parseInt(String.valueOf(tvInteligencia.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvInteligencia.setText(String.valueOf(Integer.parseInt(String.valueOf(tvInteligencia.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Destreza
        btnMenosDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvDestreza.getText())) > personagem.getDestreza()){
                    tvDestreza.setText(String.valueOf(Integer.parseInt(String.valueOf(tvDestreza.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvDestreza.setText(String.valueOf(Integer.parseInt(String.valueOf(tvDestreza.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Sabedoria
        btnMenosSabedoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvSabedoria.getText())) > personagem.getSabedoria()){
                    tvSabedoria.setText(String.valueOf(Integer.parseInt(String.valueOf(tvSabedoria.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisSabedoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvSabedoria.setText(String.valueOf(Integer.parseInt(String.valueOf(tvSabedoria.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Carisma
        btnMenosCarisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) < PONTOS_MAX && Integer.parseInt(String.valueOf(tvCarisma.getText())) > personagem.getCarisma()){
                    tvCarisma.setText(String.valueOf(Integer.parseInt(String.valueOf(tvCarisma.getText()))-1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))+1));
                }
            }
        });
        btnMaisCarisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    tvCarisma.setText(String.valueOf(Integer.parseInt(String.valueOf(tvCarisma.getText())) + 1));
                    tvPontosAtuais.setText(String.valueOf(Integer.parseInt(String.valueOf(tvPontosAtuais.getText()))-1));
                }else{
                    Toast.makeText(getApplicationContext(), "Não há pontos disponíveis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Vida
        btnMenosVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvVida.getText())) > 0){
                    tvVida.setText(String.valueOf(Integer.parseInt(String.valueOf(tvVida.getText())) - 1));
                }
            }
        });
        btnMaisVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvVida.getText())) < VidaMax){
                    tvVida.setText(String.valueOf(Integer.parseInt(String.valueOf(tvVida.getText())) + 1));
                }else{
                    Toast.makeText(getApplicationContext(), "Limite de vida atingido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Botão para resetar os atributos
        btnResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvNivel.getText())) == 0) {
                    Toast.makeText(getApplicationContext(), "Nada para resetar", Toast.LENGTH_SHORT).show();
                } else {
                    new AlertDialog.Builder(AtributosActivity.this)
                            .setTitle("Resetar")
                            .setMessage("Isso irá resetar seu nível e todos os seus pontos distribuídos")
                            .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                    tvPontosAtuais.setText("0");
                                    tvNivel.setText("0");
                                    tvForca.setText("0");
                                    tvConstituicao.setText("0");
                                    tvInteligencia.setText("0");
                                    tvDestreza.setText("0");
                                    tvSabedoria.setText("0");
                                    tvCarisma.setText("0");
                                    tvVida.setText("0");
                                    VidaMax = 0;
                                    PONTOS_MAX = 0;
                                    atualizarProgressBars();
                                }
                            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvPontosAtuais.getText())) > 0){
                    Toast.makeText(getApplicationContext(), "Ainda há pontos para gastar", Toast.LENGTH_SHORT).show();
                }else{
                    personagem.setNivel(Integer.parseInt((String) tvNivel.getText()));
                    personagem.setForca(Integer.parseInt((String) tvForca.getText()));
                    personagem.setConstituicao(Integer.parseInt((String) tvConstituicao.getText()));
                    personagem.setInteligencia(Integer.parseInt((String) tvInteligencia.getText()));
                    personagem.setDestreza(Integer.parseInt((String) tvDestreza.getText()));
                    personagem.setSabedoria(Integer.parseInt((String) tvSabedoria.getText()));
                    personagem.setCarisma(Integer.parseInt((String) tvCarisma.getText()));
                    personagem.setVida(Integer.parseInt((String) tvVida.getText()));
                    PONTOS_MAX = 0;
                    VidaMax = personagem.getConstituicao() * 2;
                    atualizarProgressBars();
                    Toast.makeText(getApplicationContext(), "Informações Salvas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void atualizarProgressBars(){
        pbForca.setProgress(Integer.parseInt(String.valueOf(tvForca.getText())));
        pbConstituicao.setProgress(Integer.parseInt(String.valueOf(tvConstituicao.getText())));
        pbInteligencia.setProgress(Integer.parseInt(String.valueOf(tvInteligencia.getText())));
        pbDestreza.setProgress(Integer.parseInt(String.valueOf(tvDestreza.getText())));
        pbSabedoria.setProgress(Integer.parseInt(String.valueOf(tvSabedoria.getText())));
        pbCarisma.setProgress(Integer.parseInt(String.valueOf(tvCarisma.getText())));
        pbVida.setMax(personagem.getConstituicao() * 2);//cálculo de vida máxima
        pbVida.setProgress(Integer.parseInt(String.valueOf(tvVida.getText())));



    }


    //Em testes
    private void setProgressMax(ProgressBar pb, int max) {
        pb.setMax(max * 100);
    }
    private void setProgressAnimate(ProgressBar pb, int progressTo)
    {
        ObjectAnimator animation = ObjectAnimator.ofInt(pb, "progress", pb.getProgress(), progressTo * 100);
        animation.setDuration(500);
        animation.setAutoCancel(true);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }
    //-----------------
}